package cl.coopeuch.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.coopeuch.demo.dto.TaskDTO;
import cl.coopeuch.demo.exceptions.InternalServerError;
import cl.coopeuch.demo.exceptions.WrongParameters;
import cl.coopeuch.demo.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin
public class TaskController {

	@Autowired
	TaskService service;

	@RequestMapping(value="", method=RequestMethod.GET, produces="application/json" )
	public ResponseEntity<List<TaskDTO>> readAll() {
		List<TaskDTO> task = service.getAllTasks();
		return new ResponseEntity<>(task, HttpStatus.OK);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET, produces="application/json" )
	public ResponseEntity<TaskDTO> read(@PathVariable Long id) {
		TaskDTO task = service.getTaskById(id);
		return new ResponseEntity<>(task, HttpStatus.OK);
	}

	@RequestMapping(value="", method=RequestMethod.POST, produces="application/json" )
	public ResponseEntity<TaskDTO> create(@RequestBody TaskDTO user) {
		try {
			service.createTask(user);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (WrongParameters p) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (InternalServerError u) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@RequestMapping(value="", method=RequestMethod.PUT, produces="application/json" )
	public ResponseEntity<TaskDTO> update(@RequestBody TaskDTO task) {
		try {
			service.updateTask(task);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (WrongParameters p) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (InternalServerError u) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE, produces="application/json" )
	public ResponseEntity<TaskDTO> delete(@PathVariable Long id) {
		try {
			service.deleteTask(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (WrongParameters p) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (InternalServerError u) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
}
