package edu.westga.comp4420.task_manager.view.codebehind;

import edu.westga.comp4420.task_manager.model.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.time.LocalDate;

public class EditTaskWindow {

    @FXML
    private DatePicker dueDatePicker;

    @FXML
    private RadioButton completeRadioButton;

    @FXML
    private RadioButton incompleteRadioButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button cancelButton;

    @FXML
    private AnchorPane guiPane;

    private Task taskToEdit;

    @FXML
    private void initialize() {
        ToggleGroup statusGroup = new ToggleGroup();
        this.completeRadioButton.setToggleGroup(statusGroup);
        this.incompleteRadioButton.setToggleGroup(statusGroup);
    }

    public void setTaskToEdit(Task task) {
        this.taskToEdit = task;
        if (task != null) {
            this.dueDatePicker.setValue(LocalDate.parse(task.getDueDate()));
            if (task.isCompleted()) {
                this.completeRadioButton.setSelected(true);
            } else {
                this.incompleteRadioButton.setSelected(true);
            }
        }
    }

    @FXML
    private void handleUpdateButtonAction() {
        LocalDate dueDate = this.dueDatePicker.getValue();
        boolean isCompleted = this.completeRadioButton.isSelected();

        if (dueDate == null) {
            this.showErrorAlert("Due date must be selected.");
            return;
        }

        if (dueDate.isBefore(LocalDate.now())) {
            this.showErrorAlert("Due date cannot be in the past.");
            return;
        }

        this.taskToEdit.setDueDate(dueDate.toString());
        this.taskToEdit.setCompleted(isCompleted);

        this.closeWindow();
    }

    @FXML
    private void handleCancelButtonAction() {
        this.closeWindow();
    }

    private void closeWindow() {
        this.guiPane.getScene().getWindow().hide();
    }

    private void showErrorAlert(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
