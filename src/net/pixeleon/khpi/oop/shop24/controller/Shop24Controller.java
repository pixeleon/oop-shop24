package net.pixeleon.khpi.oop.shop24.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.util.converter.IntegerStringConverter;
import net.pixeleon.khpi.oop.shop24.model.AbstractWorkingHour;
import net.pixeleon.khpi.oop.shop24.model.Shop24Facade;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Shop24Controller implements Initializable {

    public TextField textFieldName;
    public TextField textFieldAddress;
    public TextField textFieldText;
    public Button buttonSearchWord;
    public Button buttonSearchSubstring;
    public TextArea textAreaResults;
    public TableView<AbstractWorkingHour> tableViewWorkingHours;
    public TableColumn<AbstractWorkingHour, Integer> tableColumnOclock;
    public TableColumn<AbstractWorkingHour, Integer> tableColumnCustomersNumber;
    public TableColumn<AbstractWorkingHour, String> tableColumnComment;
    //private XMLShop24 shop = new XMLShop24();
    //private ObservableList<AbstractWorkingHour> observableHoursList;
    private final Shop24Facade facade = Shop24Facade.getInstance();

    private FileChooser getFileChooser(String title) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(title);
        fileChooser.setInitialDirectory(new File("."));
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml"));
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Other files (*.*)", "*.*"));
        return fileChooser;
    }

    private void showMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setHeaderText(message);
        alert.showAndWait();
    }

    private void showError(String error) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(error);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableViewWorkingHours.setPlaceholder(new Label(""));
    }

    private void updateTable() {
        facade.updateObservableHoursList();

        tableViewWorkingHours.setItems(facade.getObservableHoursList());

        tableColumnOclock.setCellValueFactory(new PropertyValueFactory<>("oclock"));
        tableColumnOclock.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tableColumnOclock.setOnEditCommit(this::updateOclock);
        tableColumnCustomersNumber.setCellValueFactory(new PropertyValueFactory<>("customersNumber"));
        tableColumnCustomersNumber.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tableColumnCustomersNumber.setOnEditCommit(this::updateCustomersNumber);
        tableColumnComment.setCellValueFactory(new PropertyValueFactory<>("comment"));
        tableColumnComment.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumnComment.setOnEditCommit(this::updateComment);
    }

    //
    private void updateComment(TableColumn.CellEditEvent<AbstractWorkingHour, String> t) {
        AbstractWorkingHour hour = t.getTableView().getItems().get(t.getTablePosition().getRow());
        hour.setComment(t.getNewValue());
    }

    //
    private void updateCustomersNumber(TableColumn.CellEditEvent<AbstractWorkingHour, Integer> t) {
        AbstractWorkingHour hour = t.getTableView().getItems().get(t.getTablePosition().getRow());
        hour.setCustomersNumber(t.getNewValue());
    }

    //
    private void updateOclock(TableColumn.CellEditEvent<AbstractWorkingHour, Integer> t) {
        AbstractWorkingHour hour = t.getTableView().getItems().get(t.getTablePosition().getRow());
        hour.setOclock(t.getNewValue());
    }

    public void doNew(ActionEvent actionEvent) {
        facade.doNew();
        textFieldName.setText("");
        textFieldAddress.setText("");
        textFieldText.setText("");
        textAreaResults.setText("");
        tableViewWorkingHours.setItems(null);
        tableViewWorkingHours.setPlaceholder(new Label(""));
    }

    public void doOpen(ActionEvent actionEvent) {
        try {
            FileChooser fileChooser = getFileChooser("Load data from XML file");
            File fileIn = fileChooser.showOpenDialog(null);
            if (fileIn != null) {
                facade.readFromFile(fileIn.getCanonicalPath());
                textFieldName.setText(facade.getName());
                textFieldAddress.setText(facade.getAddress());
                textAreaResults.setText("");
                updateTable();
            }
        } catch (IOException e) {
            showError("File not found");
        } catch (JAXBException e) {
            showError("Wrong file format");
        }
    }

    public void doSave(ActionEvent actionEvent) {
        try {
            FileChooser fileChooser = getFileChooser("Save data to XML file");
            File fileOut = fileChooser.showSaveDialog(null);
            if (fileOut != null) {
                facade.writeToFile(fileOut.getName());
                showMessage("Successfully saved!");
            }
        } catch (JAXBException e) {
            showError("Wrong file format");
        } catch (IOException e) {
            showError("File not found");
        }
    }

    public void doExit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void doAddRow(ActionEvent actionEvent) {
        facade.addWorkingHour(0, 0, "");
        updateTable();
    }

    public void doRemoveRow(ActionEvent actionEvent) {
        facade.doRemoveRow();
    }

    public void doSortByCustomersNumber(ActionEvent actionEvent) {
        facade.sortByCustomersNumberDesc();
        updateTable();
    }

    public void doSortByComments(ActionEvent actionEvent) {
        facade.sortByCommentsAsc();
        updateTable();
    }

    public void doAbout(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Application to work with 24-hour shop data");
        alert.setContentText("Version 1.0 Copyright (c) 2020 V. Sheveliev");
        alert.show();
    }

    public void doSearchWord(ActionEvent actionEvent) {
        facade.updateData();
        String word = textFieldText.getText();
        textAreaResults.setText("");
        for (AbstractWorkingHour wh : facade.getWorkingHours()) {
            if (wh.containsWord(word)) {
                textAreaResults.appendText(wh.toString());
            }
        }
    }

    public void doSearchSubstring(ActionEvent actionEvent) {
        facade.updateData();
        String substring = textFieldText.getText();
        textAreaResults.setText("");
        for (AbstractWorkingHour wh : facade.getWorkingHours()) {
            if (wh.containsSubstring(substring)) {
                textAreaResults.appendText(wh.toString());
            }
        }
    }

    public void nameChanged(ActionEvent actionEvent) {
        try {
            facade.setName(textFieldName.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addressChanged(ActionEvent actionEvent) {
        try {
            facade.setAddress(textFieldAddress.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
