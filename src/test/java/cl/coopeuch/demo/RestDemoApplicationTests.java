package cl.coopeuch.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cl.coopeuch.demo.dto.TaskDTO;
import cl.coopeuch.demo.service.TaskService;
import java.util.Date;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;



@RunWith(SpringRunner.class)
@SpringBootTest
public class RestDemoApplicationTests {

	
    @Autowired
    private TaskService taskService;
    
	@Test
	public void contextLoads() {
		TaskDTO task = new TaskDTO(4L, "Una prueba", false, new Date());
		taskService.createTask(task);	
		List<TaskDTO> list = taskService.getAllTasks();

		assertThat(list.isEmpty(), is(false));
	}

}
