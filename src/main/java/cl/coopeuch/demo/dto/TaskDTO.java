package cl.coopeuch.demo.dto;

import java.util.Date;

public class TaskDTO {
	private Long id;
	private String description;
	private Boolean active;

	private Date date;
	
	public TaskDTO(Long id, String description, Boolean active, Date date) {
		super();
		this.id = id;
		this.description = description;
		this.active = active;
		this.date = date;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
