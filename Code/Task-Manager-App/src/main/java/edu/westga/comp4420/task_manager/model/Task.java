package edu.westga.comp4420.task_manager.model;

/**
 * Represents an instance of a task.
 * 
 * @author Tomiwa Jinadu
 * 
 */
public class Task {

    private String title;
    private String description;
    private String dueDate;
    private boolean isCompleted;

    /**
     * Constructs a Task object.
     * 
     * @param title       the title of the task
     * @param description the description of the task
     * @param dueDate     the due date of the task
     * @param isCompleted whether the task is completed
     */
    public Task(String title, String description, String dueDate, boolean isCompleted) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
    }

    /**
     * Gets the title of the task.
     * 
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of the task.
     * 
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the description of the task.
     * 
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of the task.
     * 
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the due date of the task.
     * 
     * @return the due date
     */
    public String getDueDate() {
        return this.dueDate;
    }

    /**
     * Sets the due date of the task.
     * 
     * @param dueDate the new due date
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Checks if the task is completed.
     * 
     * @return true if completed, false otherwise
     */
    public boolean isCompleted() {
        return this.isCompleted;
    }

    /**
     * Sets the task's completion status.
     * 
     * @param completed true if completed, false otherwise
     */
    public void setCompleted(boolean completed) {
        this.isCompleted = completed;
    }

    @Override
    public String toString() {
        return "Task{" + "title='" + this.title + '\'' + ", dueDate='" + this.dueDate + '\'' + ", completed="
                + this.isCompleted + '}';
    }
}
