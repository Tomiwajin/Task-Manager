package edu.westga.comp4420.task_manager.view.codebehind;

import edu.westga.comp4420.task_manager.model.Task;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.time.LocalDate;

public class AddTaskWindow {

    @FXML
    private TextField titleTextBox;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private DatePicker dueDatePicker;

    @FXML
    private RadioButton completeRadioButton;

    @FXML
    private RadioButton incompleteRadioButton;

    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;

    private Stage dialogStage;
    private Task newTask;

    
    private ObservableList<Task> taskList;

    
    public void setTaskList(ObservableList<Task> taskList) {
        this.taskList = taskList;
    }

    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    
    @FXML
    private void initialize() {
        ToggleGroup statusGroup = new ToggleGroup();
        this.completeRadioButton.setToggleGroup(statusGroup);
        this.incompleteRadioButton.setToggleGroup(statusGroup);
    }

    
    @FXML
    private void handleAddButtonAction() {
        String title = this.titleTextBox.getText();
        String description = this.descriptionTextArea.getText();
        LocalDate dueDate = this.dueDatePicker.getValue();
        boolean isCompleted = this.completeRadioButton.isSelected();

        if (title.isEmpty() || description.isEmpty() || dueDate == null) {
            this.showErrorAlert("All fields must be filled.");
            return;
        }

        if (dueDate.isBefore(LocalDate.now())) {
            this.showErrorAlert("Due date cannot be in the past.");
            return;
        }

        this.newTask = new Task(title, description, dueDate.toString(), isCompleted);

        this.taskList.add(this.newTask);

        this.dialogStage.close();
    }

    @FXML
    private void handleCancelButtonAction() {
        this.dialogStage.close();
    }

  
    private void showErrorAlert(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
