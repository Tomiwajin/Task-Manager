package edu.westga.comp4420.task_manager.view.codebehind;

import edu.westga.comp4420.task_manager.model.Task;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableCell;

public class MainWindow {

    @FXML
    private TableView<Task> taskTable;

    @FXML
    private TableColumn<Task, String> titleColumn;

    @FXML
    private TableColumn<Task, String> descriptionColumn;

    @FXML
    private TableColumn<Task, String> dueDateColumn;

    @FXML
    private TableColumn<Task, String> statusColumn; 

    @FXML
    private Button addTaskButton;

    private ObservableList<Task> taskList;

    public MainWindow() {
        this.taskList = FXCollections.observableArrayList();
    }

    @FXML
    public void initialize() {
        
        this.titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        this.descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        this.dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));

       
        this.statusColumn.setCellValueFactory(cellData -> {
            Task task = cellData.getValue();
            BooleanProperty isCompletedProperty = new SimpleBooleanProperty(task.isCompleted());
            return isCompletedProperty.asString();
        });

        
        this.statusColumn.setCellFactory(column -> new TableCell<Task, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    boolean isCompleted = Boolean.parseBoolean(item);
                    setText(isCompleted ? "Complete" : "Incomplete");
                }
            }
        });

        this.taskTable.setItems(this.taskList);
    }
}
