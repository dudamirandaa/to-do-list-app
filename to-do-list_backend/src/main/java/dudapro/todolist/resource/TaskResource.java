package dudapro.todolist.resource;

import dudapro.todolist.model.Task;
import dudapro.todolist.resource.dto.EditTaskDto;
import dudapro.todolist.resource.dto.NewTaskDto;
import dudapro.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/to-do-list")
public class TaskResource {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> listTasks(String name, String priority, String date){
        return taskService.listTasks(name, priority, date);
    }

    @PostMapping
    @Transactional
    public Long insertNewTask(@RequestBody @Valid NewTaskDto newTaskDto) {
        return taskService.insertNewTask(newTaskDto);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EditTaskDto> editTask(@PathVariable Long id, @RequestBody @Valid EditTaskDto editTaskDto) {
        return taskService.editTask(id, editTaskDto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<EditTaskDto> deleteTask(@PathVariable Long id) {
        return taskService.deleteTask(id);
    }
}
