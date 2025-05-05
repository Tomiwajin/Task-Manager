package edu.westga.comp4420.task_manager.view.codebehind;

import edu.westga.comp4420.task_manager.model.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class TaskDetailsWindow {

    @FXML
    private TextField titleTextField;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private TextField dueDateField;

    @FXML
    private TextField statusField;

    @FXML
    private Button closeButton;

    @FXML
    private AnchorPane guiPane;

    public void setTask(Task task) {
        this.titleTextField.setText(task.getTitle());
        this.descriptionTextArea.setText(task.getDescription());
        this.dueDateField.setText(task.getDueDate());
        this.statusField.setText(task.isCompleted() ? "Complete" : "Incomplete");
    }

    @FXML
    private void handleCloseButtonAction() {
        this.guiPane.getScene().getWindow().hide();
    }
}
