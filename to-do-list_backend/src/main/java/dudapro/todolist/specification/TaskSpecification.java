package dudapro.todolist.specification;

import dudapro.todolist.model.Priority;
import dudapro.todolist.model.Task;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class TaskSpecification {

    public static Specification<Task> name(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<Task> priority(Priority priority) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("priority"), priority);
    }

    public static Specification<Task> dueDate(LocalDate dueDate) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("dueDate"), dueDate);
    }
}
