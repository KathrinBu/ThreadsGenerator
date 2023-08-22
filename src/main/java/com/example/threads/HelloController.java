package com.example.threads;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class HelloController {
    @FXML
    Button button1, button2;
    @FXML
    TableView tableView;

    ObservableList<MyMessage> messages = FXCollections.observableArrayList();
    ObservableList<MyMessage> messages2 = javafx.collections.FXCollections.synchronizedObservableList(messages);

    public void initialize(){

        button1.setOnAction(actionEvent -> {
            Generator gena1 = new Generator("VVV",messages2, 16);
            gena1.start();
        });
        button2.setOnAction(actionEvent -> {

            Generator gena2 = new Generator("Fu",messages2, 10);
            gena2.start();

        });

    initTable();

    }
    private void initTable() {
        tableView.setItems(messages2);
        TableColumn<MyMessage, String> col1 = new TableColumn<>("message");
        col1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<MyMessage, String>, ObservableValue<String>>() {
                                     @Override
                                     public ObservableValue<String> call(TableColumn.CellDataFeatures<MyMessage, String> myMessageStringCellDataFeatures) {
                                         return new SimpleStringProperty(myMessageStringCellDataFeatures.getValue().getMessage());
                                     }
                                 });
                tableView.getColumns().add(col1);
        TableColumn<MyMessage, String> col2 = new TableColumn<>("time");
        col2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<MyMessage, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<MyMessage, String> myMessageStringCellDataFeatures) {
                return new SimpleStringProperty(String.valueOf(myMessageStringCellDataFeatures.getValue().getTime()));
            }
    }
    );
        tableView.getColumns().add(col2);
        TableColumn<MyMessage,String> col3=new TableColumn<>("sender");
        col3.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<MyMessage, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<MyMessage, String> myMessageStringCellDataFeatures) {
                return new SimpleStringProperty(myMessageStringCellDataFeatures.getValue().getSender());
            }
        });
        tableView.getColumns().add(col3);

    }
    }


