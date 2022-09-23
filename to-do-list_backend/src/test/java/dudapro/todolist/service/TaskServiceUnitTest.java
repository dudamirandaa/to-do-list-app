package dudapro.todolist.service;

import dudapro.todolist.model.Priority;
import dudapro.todolist.model.Task;
import dudapro.todolist.repository.TaskRepository;
import dudapro.todolist.resource.dto.NewTaskDto;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.verify;

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
        List<Task> taskList = service.listTasks(null, null, null);
        verify(taskRepository).findAll();
    }

    @Test
    public void shouldFilterTasksWithSomeSpecification() throws URISyntaxException {
        String name = "name";
        String priority = "medium";
        String date = "2022-07-20";
        List<Task> taskList = service.listTasks(name, priority, date);
        verify(taskRepository).findAll(Specification.where(
                Mockito.any())
        );
    }

    @Test
    public void shouldInsertTask() {
        Task mockTask = mockTask();
        Mockito.when(newTaskDto.toTask()).thenReturn(mockTask);
        Long taskId = service.insertNewTask(newTaskDto);
        Mockito.verify(taskRepository).save(mockTask);
        Assert.assertEquals(taskId, mockTask.getId());
    }

    private Task mockTask() {
        Task task = new Task();
        task.setName("mock task name");
        task.setPriority(Priority.HIGH);
        task.setDueDate(LocalDate.parse("2022-07-20"));
        return task;
    }
}
