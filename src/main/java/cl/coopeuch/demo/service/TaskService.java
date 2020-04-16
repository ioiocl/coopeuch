package cl.coopeuch.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.coopeuch.demo.dao.ITaskDAO;
import cl.coopeuch.demo.dto.ApiDTOBuilder;
import cl.coopeuch.demo.dto.TaskDTO;
import cl.coopeuch.demo.entities.Task;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

@Component
public class TaskService implements ITaskService {

	@Autowired
	private ITaskDAO taskDAO;
	
	@Override
	public List<TaskDTO> getAllTasks() {
		List<Task> entities = taskDAO.getTasks();
		List<TaskDTO> tasks = new ArrayList<TaskDTO>();

		Iterator<Task> iterator = entities.iterator();

		while(iterator.hasNext()) {
			Task task = iterator.next();
			tasks.add(ApiDTOBuilder.taskToTaskDTO(task));
		}
		return tasks;
	}

	@Override
	public TaskDTO getTaskById(Long id) {
		Task task = taskDAO.getTask(id);	
		return ApiDTOBuilder.taskToTaskDTO(task);
	}

	@Override
	public void createTask(TaskDTO task) {
		taskDAO.createTask(ApiDTOBuilder.taskDTOToTask(task));	
	}

	@Override
	public void updateTask(TaskDTO task) {
		taskDAO.updateTask(ApiDTOBuilder.taskDTOToTask(task));
		
	}

	@Override
	public void deleteTask(Long id) {
		taskDAO.deleteTask(id);
	}

}
