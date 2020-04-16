package cl.coopeuch.demo.service;

import java.util.List;

import cl.coopeuch.demo.dto.TaskDTO;

public interface ITaskService {

	public List<TaskDTO> getAllTasks();

	public TaskDTO getTaskById(Long id);

	public void createTask(TaskDTO task);

	public void updateTask(TaskDTO task);

	public void deleteTask(Long id);
}
