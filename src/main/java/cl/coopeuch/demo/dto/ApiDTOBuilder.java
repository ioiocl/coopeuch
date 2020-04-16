package cl.coopeuch.demo.dto;

import cl.coopeuch.demo.entities.Task;

public class ApiDTOBuilder {
	public static TaskDTO taskToTaskDTO(Task task) {
		return new TaskDTO(task.getId(), task.getDescription(),task.getActive(),task.getDate());
	}
	public static Task taskDTOToTask(TaskDTO task) {
		return new Task(task.getDescription(),task.getActive(),task.getDate());
	}
}
