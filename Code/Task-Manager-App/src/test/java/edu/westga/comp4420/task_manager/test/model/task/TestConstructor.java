package edu.westga.comp4420.task_manager.test.model.task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import edu.westga.comp4420.task_manager.model.Task;

/**
 * Tests the constructor of the Task class.
 * 
 * @author Tomiwa Jinadu
 * @version Spring 2025
 */
class TestConstructor {

    @ParameterizedTest
    @CsvSource({
        "Homework, Complete math exercises, 2025-03-10, true",
        "Grocery Shopping, Buy groceries for the week, 2025-03-11, false"
    })
    void testValidInput(String title, String description, String dueDate, boolean isCompleted) {
        Task result = new Task(title, description, dueDate, isCompleted);

        assertEquals(title, result.getTitle(), "Checking task title");
        assertEquals(description, result.getDescription(), "Checking task description");
        assertEquals(dueDate, result.getDueDate(), "Checking task due date");
        assertEquals(isCompleted, result.isCompleted(), "Checking task completion status");
    }

    @ParameterizedTest
    @CsvSource({
        ", Description, 2025-03-10, true",            
        "'', Description, 2025-03-10, false",         
        "Title,, 2025-03-10, true",                   
        "Title, Description,, true",                   
        "Title, Description, '', false"                
    })
    void testInvalidInput(String title, String description, String dueDate, boolean isCompleted) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(title, description, dueDate, isCompleted);
        });
    }
}
