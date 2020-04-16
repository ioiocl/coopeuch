package cl.coopeuch.demo.dao;

import java.util.List;

import cl.coopeuch.demo.entities.Task;

public interface ITaskDAO {
	
	public List<Task> getTasks();

	public Task getTask(Long id);
	
	public void createTask(Task user);
	
	public void updateTask(Task user);
	
	public void deleteTask(Long id);

}
