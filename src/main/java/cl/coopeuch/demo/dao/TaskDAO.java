package cl.coopeuch.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.coopeuch.demo.entities.Task;

@Repository
public class TaskDAO implements ITaskDAO {

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public Task getTask(Long id) {
		return em.find(Task.class, id);
	}


	@Override
	@Transactional
	public List<Task> getTasks() {
		List<Task> resultList = em.createQuery("FROM Task", Task.class).getResultList();
		return resultList;
	}

	@Override
	@Transactional
	public void createTask(Task task) {
		em.persist(task);
		
	}

	@Override
	@Transactional
	public void updateTask(Task task) {
		em.merge(task);
		
	}

	@Override
	@Transactional
	public void deleteTask(Long id) {
		Task task = this.getTask(id);
		em.remove(task);
	}

}
