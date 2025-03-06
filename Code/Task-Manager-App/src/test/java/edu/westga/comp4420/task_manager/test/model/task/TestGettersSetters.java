package edu.westga.comp4420.task_manager.test.model.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.comp4420.task_manager.model.Task;

/**
 * Tests for Task getters and setters.
 * 
 * @author Tomiwa Jinadu
 */
class TestGettersSetters {

    @Test
    void testSetAndGetTitle() {
        Task task = new Task("Initial Title", "Desc", "2025-03-10", false);
        task.setTitle("New Title");
        assertEquals("New Title", task.getTitle(), "Checking title after setting");
    }

    @Test
    void testSetAndGetDescription() {
        Task task = new Task("Title", "Initial Description", "2025-03-10", false);
        task.setDescription("New Description");
        assertEquals("New Description", task.getDescription(), "Checking description after setting");
    }

    @Test
    void testSetAndGetDueDate() {
        Task task = new Task("Title", "Desc", "2025-03-10", false);
        task.setDueDate("2025-04-15");
        assertEquals("2025-04-15", task.getDueDate(), "Checking due date after setting");
    }

    @Test
    void testSetAndIsCompleted() {
        Task task = new Task("Title", "Desc", "2025-03-10", false);
        task.setCompleted(true);
        assertEquals(true, task.isCompleted(), "Checking completed status after setting");
    }

    @Test
    void testToString() {
        Task task = new Task("Title", "Desc", "2025-03-10", true);
        String expected = "Task{title='Title', dueDate='2025-03-10', completed=true}";
        assertEquals(expected, task.toString(), "Checking toString output");
    }
}
