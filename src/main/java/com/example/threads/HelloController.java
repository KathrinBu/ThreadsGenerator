package com.example.threads;

import javafx.animation.AnimationTimer;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class HelloController {
    @FXML
    Button button1, button2;
    @FXML
    TableView tableView;

    ObservableList<ObservableMessage> messages = FXCollections.observableArrayList();
    ObservableList<ObservableMessage> messages2 = javafx.collections.FXCollections.synchronizedObservableList(messages);
    BlockingQueue<String> mesQueue = new LinkedBlockingQueue<>();

    public void initialize(){

        button1.setOnAction(actionEvent -> {
            try {
                Generator.work("VVV",messages);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        button2.setOnAction(actionEvent -> {
            try {
                Generator.work("SSS",messages);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        messages2.addListener((ListChangeListener<String>) change -> {
            while(change.next())
                if(change.wasAdded())
                    for (String mes : change.getAddedSubList() ) {
                        mesQueue.add(mes);
                    }
        });
    initTable();

    }
    private void initTable() {
        tableView.setItems(messages2);
        TableColumn<String, String> col1 = new TableColumn<>("сообщение");
        col1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<String, String> stringStringCellDataFeatures) {
                return new SimpleStringProperty(stringStringCellDataFeatures.getValue());
            }
        });
        tableView.getColumns().add(col1);
    }
    }


