package net.pixeleon.khpi.oop.shop24.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.pixeleon.khpi.oop.shop24.model.io.xml.XMLShop24;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shop24Facade {
    private static Shop24Facade instance = null;
    private XMLShop24 shop;
    private ObservableList<AbstractWorkingHour> observableHoursList;

    //private constructor makes it impossible to create objects not with getInstance() method
    private Shop24Facade() { }

    public static Shop24Facade getInstance() {
        if (instance == null) {
            instance = new Shop24Facade();
        }
        return instance;
    }

    public XMLShop24 getShop() {
        return shop;
    }

    public void setShop(XMLShop24 shop) {
        this.shop = shop;
    }

    public ObservableList<AbstractWorkingHour> getObservableHoursList() {
        return observableHoursList;
    }

    public void setObservableHoursList(ObservableList<AbstractWorkingHour> observableHoursList) {
        this.observableHoursList = observableHoursList;
    }

    public void doNew() {
        shop = new XMLShop24();
        observableHoursList = null;
    }

    public void readFromFile(String fileName) throws JAXBException, FileNotFoundException {
        shop.readFromFile(fileName);
    }

    public void writeToFile(String fileName) throws JAXBException, IOException {
        updateData();
        shop.writeToFile(fileName);
    }


    public String getName() {
        return shop.getName();
    }

    public void setName(String name) {
        shop.setName(name);
    }

    public String getAddress() {
        return shop.getAddress();
    }

    public void setAddress(String address) {
        shop.setAddress(address);
    }

    public void clearWorkingHours() {
        shop.clearWorkingHours();
    }

    public void addWorkingHour(AbstractWorkingHour wh) {
        shop.addWorkingHour(wh);
    }

    public void addWorkingHour(int oclock, int customersNumber, String comment) {
        shop.addWorkingHour(oclock, customersNumber, comment);
    }

    public AbstractWorkingHour[] getWorkingHours() {
        return shop.getWorkingHours();
    }

    public void doRemoveRow() {
        if (observableHoursList == null) {
            return;
        }
        if (observableHoursList.size() <= 0) {
            observableHoursList = null;
        } else {
            observableHoursList.remove(observableHoursList.size() - 1);
        }
    }

    public void sortByCustomersNumberDesc() {
        updateData();
        shop.sortByCustomersNumberDesc();
    }

    public void sortByCommentsAsc() {
        updateData();
        shop.sortByCommentsAsc();
    }

    public void updateData() {
        shop.clearWorkingHours();
        for (AbstractWorkingHour wh : observableHoursList) {
            shop.addWorkingHour(wh);
        }
    }

    public void updateObservableHoursList() {
        List<AbstractWorkingHour> hoursList = new ArrayList<>(Arrays.asList(shop.getWorkingHours()));
        observableHoursList = FXCollections.observableList(hoursList);
    }
}
