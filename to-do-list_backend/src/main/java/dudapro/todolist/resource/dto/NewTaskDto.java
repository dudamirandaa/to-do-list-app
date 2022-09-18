package dudapro.todolist.resource.dto;

import dudapro.todolist.model.Priority;
import dudapro.todolist.model.Task;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class NewTaskDto {

    @Length(min = 3)
    private String name;
    @Enumerated(EnumType.STRING) @NotNull
    private Priority priority;
    @NotNull
    private String dueDate;

    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Task toTask() {
        Task task = new Task();
        task.setName(name);
        task.setPriority(priority);
        task.setDueDate(LocalDate.parse(dueDate));
        return task;
    }
}
