package dudapro.todolist.resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TaskResourceIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldListAllTasksTest() throws Exception {
        URI uri = new URI("/to-do-list");
        String json = "";

        mockMvc.perform(MockMvcRequestBuilders
                        .get(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));
    }

    @Test
    public void shouldListAllTasksWithNameSpecificationTest() throws Exception {
        URI postUri = new URI("/to-do-list");
        String postJson = "{\"name\":\"Task name\",\"priority\":\"MEDIUM\",\"dueDate\":\"2022-07-20\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post(postUri)
                        .content(postJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String content = result.getResponse().getContentAsString();

        URI uri = new URI("/to-do-list/?name=name");
        String json = "";

        mockMvc.perform(MockMvcRequestBuilders
                        .get(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));

        deleteCreatedTask(result);
    }

    @Test
    public void shouldListAllTasksWithPrioritySpecificationTest() throws Exception {
        URI postUri = new URI("/to-do-list");
        String postJson = "{\"name\":\"Task name\",\"priority\":\"MEDIUM\",\"dueDate\":\"2022-07-20\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post(postUri)
                        .content(postJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String content = result.getResponse().getContentAsString();

        URI uri = new URI("/to-do-list/?priority=medium");
        String json = "";

        mockMvc.perform(MockMvcRequestBuilders
                        .get(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));

        deleteCreatedTask(result);
    }

    @Test
    public void shouldListAllTasksWithDateSpecificationTest() throws Exception {
        URI postUri = new URI("/to-do-list");
        String postJson = "{\"name\":\"Task name\",\"priority\":\"MEDIUM\",\"dueDate\":\"2022-07-20\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post(postUri)
                        .content(postJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String content = result.getResponse().getContentAsString();

        URI uri = new URI("/to-do-list/?date=2022-07-20");
        String json = "";

        mockMvc.perform(MockMvcRequestBuilders
                        .get(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));

        deleteCreatedTask(result);
    }

    @Test
    public void shouldListAllTasksWithNameAndPrioritySpecificationTest() throws Exception {
        URI postUri = new URI("/to-do-list");
        String postJson = "{\"name\":\"Task name\",\"priority\":\"MEDIUM\",\"dueDate\":\"2022-07-20\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post(postUri)
                        .content(postJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String content = result.getResponse().getContentAsString();

        URI uri = new URI("/to-do-list/?name=name&priority=medium");
        String json = "";

        mockMvc.perform(MockMvcRequestBuilders
                        .get(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));

        deleteCreatedTask(result);
    }

    @Test
    public void shouldListAllTasksWithPriorityAndDateSpecificationTest() throws Exception {
        URI postUri = new URI("/to-do-list");
        String postJson = "{\"name\":\"Task name\",\"priority\":\"MEDIUM\",\"dueDate\":\"2022-07-20\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post(postUri)
                        .content(postJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String content = result.getResponse().getContentAsString();

        URI uri = new URI("/to-do-list/?priority=medium&date=2022-07-20");
        String json = "";

        mockMvc.perform(MockMvcRequestBuilders
                        .get(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));

        deleteCreatedTask(result);
    }

    @Test
    public void shouldListAllTasksWithNameAndDateSpecificationTest() throws Exception {
        URI postUri = new URI("/to-do-list");
        String postJson = "{\"name\":\"Task name\",\"priority\":\"MEDIUM\",\"dueDate\":\"2022-07-20\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post(postUri)
                        .content(postJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String content = result.getResponse().getContentAsString();

        URI uri = new URI("/to-do-list/?name=name&date=2022-07-20");
        String json = "";

        mockMvc.perform(MockMvcRequestBuilders
                        .get(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));

        deleteCreatedTask(result);
    }

    @Test
    public void shouldListAllTasksWithNameAndPriorityAndDateSpecificationTest() throws Exception {
        URI postUri = new URI("/to-do-list");
        String postJson = "{\"name\":\"Task name\",\"priority\":\"MEDIUM\",\"dueDate\":\"2022-07-20\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post(postUri)
                        .content(postJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String content = result.getResponse().getContentAsString();

        URI uri = new URI("/to-do-list/?name=name&priority=medium&date=2022-07-20");
        String json = "";

        mockMvc.perform(MockMvcRequestBuilders
                        .get(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));

        deleteCreatedTask(result);
    }

    @Test
    public void shouldInsertTaskTest() throws Exception {
        URI uri = new URI("/to-do-list");
        String json = "{\"name\":\"Task name\",\"priority\":\"HIGH\",\"dueDate\":\"2022-07-20\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                    .post(uri)
                    .content(json)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200))
                .andReturn();

        deleteCreatedTask(result);
    }

    @Test
    public void shouldNotInsertTaskWithInvalidPriorityRequestTest() throws Exception {
        URI uri = new URI("/to-do-list");
        String json = "{\"name\":\"Task name\",\"priority\":\"INVALID\",\"dueDate\":\"2022-07-20\"}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(400));
    }

    @Test
    public void shouldNotInsertTaskWithInvalidDueDateRequestTest() throws Exception {
        URI uri = new URI("/to-do-list");
        String json = "{\"name\":\"Task name\",\"priority\":\"MEDIUM\",\"dueDate\":\"abc\"}";

        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .post(uri)
                            .content(json)
                            .contentType(MediaType.APPLICATION_JSON));
            fail("Insertion with invalid date attribute did not throw exception.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void shouldNotInsertTaskWithoutNameRequestTest() throws Exception {
        URI uri = new URI("/to-do-list");
        String json = "{\"name\":,\"priority\":\"INVALID\",\"dueDate\":\"2022-07-20\"}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(400));
    }

    @Test
    public void shouldNotInsertTaskWithoutPriorityRequestTest() throws Exception {
        URI uri = new URI("/to-do-list");
        String json = "{\"name\":\"Task name\",\"priority\":,\"dueDate\":\"2022-07-20\"}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(400));
    }

    @Test
    public void shouldNotInsertTaskWithoutDateRequestTest() throws Exception {
        URI uri = new URI("/to-do-list");
        String json = "{\"name\":\"Task name\",\"priority\":\"INVALID\",\"dueDate\":}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(400));
    }

    @Test
    public void shouldEditTaskTest() throws Exception {
        URI postUri = new URI("/to-do-list");
        String postJson = "{\"name\":\"Task name\",\"priority\":\"MEDIUM\",\"dueDate\":\"2022-07-20\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post(postUri)
                        .content(postJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String content = result.getResponse().getContentAsString();

        URI uri = new URI("/to-do-list/" + content);
        System.out.println(uri);
        String json = "{\"name\":\"Altered name\",\"priority\":\"MEDIUM\",\"dueDate\":\"2022-07-20\"}";

        mockMvc.perform(MockMvcRequestBuilders
                        .put(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));

        deleteCreatedTask(result);
    }

    @Test
    public void shouldNotEditNonExistentTaskTest() throws Exception {
        URI uri = new URI("/to-do-list/999999999");
        System.out.println(uri);
        String json = "{\"name\":\"Altered name\",\"priority\":\"MEDIUM\",\"dueDate\":\"2022-07-20\"}";

        mockMvc.perform(MockMvcRequestBuilders
                        .put(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(404));
    }

    @Test
    public void shouldNotEditWithoutNameTaskTest() throws Exception {
        URI postUri = new URI("/to-do-list");
        String postJson = "{\"name\":\"Task name\",\"priority\":\"MEDIUM\",\"dueDate\":\"2022-07-20\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post(postUri)
                        .content(postJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String content = result.getResponse().getContentAsString();

        URI uri = new URI("/to-do-list/" + content);
        String json = "{\"name\":,\"priority\":\"MEDIUM\",\"dueDate\":\"2022-07-20\"}";

        mockMvc.perform(MockMvcRequestBuilders
                        .put(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(400));

        deleteCreatedTask(result);
    }

    @Test
    public void shouldNotEditWithoutPriorityTaskTest() throws Exception {
        URI postUri = new URI("/to-do-list");
        String postJson = "{\"name\":\"Task name\",\"priority\":\"LOW\",\"dueDate\":\"2022-07-20\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post(postUri)
                        .content(postJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String content = result.getResponse().getContentAsString();

        URI uri = new URI("/to-do-list/" + content);
        String json = "{\"name\":\"Altered name\",\"priority\":,\"dueDate\":\"2022-07-20\"}";

        mockMvc.perform(MockMvcRequestBuilders
                        .put(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(400));

        deleteCreatedTask(result);
    }

    @Test
    public void shouldNotEditWithoutDateTaskTest() throws Exception {
        URI postUri = new URI("/to-do-list");
        String postJson = "{\"name\":\"Task name\",\"priority\":\"MEDIUM\",\"dueDate\":\"2022-07-20\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post(postUri)
                        .content(postJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String content = result.getResponse().getContentAsString();

        URI uri = new URI("/to-do-list/" + content);
        String json = "{\"name\":\"Altered name\",\"priority\":\"MEDIUM\",\"dueDate\":}";

        mockMvc.perform(MockMvcRequestBuilders
                        .put(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(400));

        deleteCreatedTask(result);
    }

    @Test
    public void shouldDeleteTaskTest() throws Exception {
        URI postUri = new URI("/to-do-list");
        String postJson = "{\"name\":\"Task name\",\"priority\":\"MEDIUM\",\"dueDate\":\"2022-07-20\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post(postUri)
                        .content(postJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String content = result.getResponse().getContentAsString();

        URI uri = new URI("/to-do-list/" + content);
        System.out.println(uri);
        String json = "";

        mockMvc.perform(MockMvcRequestBuilders
                        .delete(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));
    }

    @Test
    public void shouldNotDeleteNonExistentTaskTest() throws Exception {
        URI uri = new URI("/to-do-list/999999999999999");
        String json = "";

        mockMvc.perform(MockMvcRequestBuilders
                        .delete(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(404));
    }

    private void deleteCreatedTask(MvcResult result) throws Exception {
        String content = result.getResponse().getContentAsString();
        URI uri = new URI("/to-do-list/" + content);
        String json = "";
        mockMvc.perform(MockMvcRequestBuilders
                        .delete(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));
    }
}
