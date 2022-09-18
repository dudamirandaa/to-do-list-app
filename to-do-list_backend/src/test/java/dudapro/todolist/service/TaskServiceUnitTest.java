package dudapro.todolist.service;

import dudapro.todolist.model.Priority;
import dudapro.todolist.model.Task;
import dudapro.todolist.repository.TaskRepository;
import dudapro.todolist.resource.dto.NewTaskDto;
import dudapro.todolist.specification.TaskSpecification;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class TaskServiceUnitTest {

    private TaskService service;

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private NewTaskDto newTaskDto;

    private MockMvc mockMvc;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        this.service = new TaskService(taskRepository);
    }

    @Test
    void shouldListAllTasksWhenNoFilterIsSelected() throws URISyntaxException {
        List<Task> mockTaskList = mockTaskList();
        Mockito.when(taskRepository.findAll()).thenReturn(mockTaskList);

        List<Task> taskList = service.listTasks(null, null, null);

        Assertions.assertEquals(mockTaskList.get(0).getName(), taskList.get(0).getName());
        Assertions.assertEquals(mockTaskList.get(1).getDueDate(), taskList.get(1).getDueDate());
    }

    @Test
    public void shouldListAllTasksWithNameSpecification() throws URISyntaxException {
        List<Task> mockTaskList = mockTaskListByName();
        String name = "task";
        Priority priority = null;
        LocalDate dueDate = null;
        Mockito.when(taskRepository.findAll(Specification.where(
                                TaskSpecification.name(name))
                        .or(TaskSpecification.priority(priority))
                        .or(TaskSpecification.dueDate(dueDate))
                ))
                .thenReturn(mockTaskList);

//        List<Task> taskList = service.listTasks(nameSpecification, null, null);

//        Assert.assertEquals(mockTaskList, taskList);
    }

    @Test
    public void shouldInsertTask() {
        Task mockTask = mockTask();
        Mockito.when(newTaskDto.toTask()).thenReturn(mockTask);
        Long taskId = service.insertNewTask(newTaskDto);
        Mockito.verify(taskRepository).save(mockTask);
        Assert.assertEquals(taskId, mockTask.getId());
    }

    private List<Task> mockTaskList() {
        List<Task> list = new ArrayList<>();

        Task task1 = new Task();
        task1.setName("task 1");
        task1.setPriority(Priority.HIGH);
        task1.setDueDate(LocalDate.parse("2022-07-20"));

        Task task2 = new Task();
        task2.setName("task 2");
        task2.setPriority(Priority.MEDIUM);
        task2.setDueDate(LocalDate.parse("2022-07-21"));

        list.add(task1);
        list.add(task2);
        return list;
    }

    private List<Task> mockTaskListByName() {
        List<Task> list = new ArrayList<>();

        Task task1 = new Task();
        task1.setName("task 1");
        task1.setPriority(Priority.HIGH);
        task1.setDueDate(LocalDate.parse("2022-07-20"));

        list.add(task1);
        return list;
    }

    private Task mockTask() {
        Task task = new Task();
        task.setName("mock task name");
        task.setPriority(Priority.HIGH);
        task.setDueDate(LocalDate.parse("2022-07-20"));
        return task;
    }
}
