package dudapro.todolist.service;

import dudapro.todolist.model.Priority;
import dudapro.todolist.model.Task;
import dudapro.todolist.repository.TaskRepository;
import dudapro.todolist.resource.dto.EditTaskDto;
import dudapro.todolist.resource.dto.NewTaskDto;
import dudapro.todolist.specification.TaskSpecification;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> listTasks(String name, String priorityStr, String dateStr) {
        Priority priority = priorityConverter(priorityStr);
        LocalDate dueDate = dueDateConverter(dateStr);

        if (name == null && priority == null && dueDate == null) {
            return taskRepository.findAll();
        } else return taskRepository.findAll(Specification.where(
                TaskSpecification.name(name))
                .or(TaskSpecification.priority(priority))
                .or(TaskSpecification.dueDate(dueDate))
        );
    }

    public Long insertNewTask(NewTaskDto newTaskDto) {
        Task task = newTaskDto.toTask();
        taskRepository.save(task);
        return task.getId();
    }

    public ResponseEntity<EditTaskDto> editTask(@PathVariable Long id, EditTaskDto editTaskDto) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            Task task = editTaskDto.toTask(id, taskRepository);
            taskRepository.save(task);
            return ResponseEntity.ok().build();
        } return ResponseEntity.notFound().build();
    }

    public ResponseEntity<EditTaskDto> deleteTask(@PathVariable Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            taskRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } return ResponseEntity.notFound().build();
    }

    private Priority priorityConverter(String priority) {
        if (priority != null && !priority.equals("")) {
            return Priority.valueOf(priority.toUpperCase());
        } return null;
    }

    private LocalDate dueDateConverter(String date) {
        if (date != null && !date.equals("")) {
            return LocalDate.parse(date);
        } return null;
    }
}
