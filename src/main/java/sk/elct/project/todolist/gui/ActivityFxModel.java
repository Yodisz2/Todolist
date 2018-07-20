package sk.elct.project.todolist.gui;

import java.time.LocalDateTime;

import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import sk.elct.project.todolist.Activity;
import sk.elct.project.todolist.Category;

public class ActivityFxModel {
	private Long id;
	private StringProperty title = new SimpleStringProperty();
	private Integer priority;
	//private IntegerProperty priority = new SimpleIntegerProperty(0);
	private LocalDateTime dueDate;
	private StringProperty body = new SimpleStringProperty();
	private Integer progress;
	//private IntegerProperty progress = new SimpleIntegerProperty(0);
	private Category category;
	
	public ActivityFxModel() {
		category = new Category();
		category.setId(4L);
		category.setName("other");
	}
	
	public Activity getActivity() {
		Activity activity = new Activity();
		activity.setId(getId());
		activity.setTitle(getTitle());
		activity.setBody(getBody());
		activity.setPriority(getPriority());
		activity.setDueDate(getDueDate());
		activity.setProgress(getProgress());
		activity.setCategory(getCategory());
		return activity;
		}
	
	public Long getId() {
		return id;
	}
	public int getPriority() {
		return priority;
	}
	public LocalDateTime getDueDate() {
		return dueDate;
	}
	public Integer getProgress() {
		return progress;
	}
	public Category getCategory() {
		return category;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title.get();
	}
	public StringProperty titleProperty() {
		return title;
	}
	public void setTitle(String title) {
		this.title.set(title);
	}
	public String getBody() {
		return body.get();
	}
	public StringProperty bodyProperty() {
		return body;
	}
	public void setBody(String body) {
		this.body.set(body);
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}
	public void setProgress(Integer progress) {
		this.progress = progress;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
