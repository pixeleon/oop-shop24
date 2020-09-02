package net.pixeleon.khpi.oop.shop24.model.io.xml;

import net.pixeleon.khpi.oop.shop24.model.AbstractShop24Hour;
import net.pixeleon.khpi.oop.shop24.model.AbstractWorkingHour;
import net.pixeleon.khpi.oop.shop24.model.io.FileIO;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

public class XMLShop24 extends AbstractShop24Hour implements FileIO {

    private Shop24Data shop24Data = new Shop24Data();

    @Override
    public String getName() {
        return shop24Data.getName();
    }

    @Override
    public void setName(String name) {
        shop24Data.setName(name);
    }

    @Override
    public String getAddress() {
        return shop24Data.getAddress();
    }

    @Override
    public void setAddress(String address) {
        shop24Data.setAddress(address);
    }

    @Override
    public AbstractWorkingHour[] getWorkingHours() {
        AbstractWorkingHour[] hours = new AbstractWorkingHour[workingHoursCount()];
        for (int i = 0; i < workingHoursCount(); i++) {
            hours[i] = new XMLWorkingHour(shop24Data.getWorkingHourData().get(i));
        }
        return hours;
    }

    @Override
    public void setWorkingHours(AbstractWorkingHour[] hours) {
        clearWorkingHours();
        for (AbstractWorkingHour wh : hours) {
            addWorkingHour(wh);
        }
    }

    @Override
    public AbstractWorkingHour getWorkingHour(int i) {
        return new XMLWorkingHour(shop24Data.getWorkingHourData().get(i));
    }

    @Override
    public void setWorkingHour(int i, AbstractWorkingHour hour) {
        shop24Data.getWorkingHourData().get(i).setOclock(hour.getOclock());
        shop24Data.getWorkingHourData().get(i).setCustomersNumber(hour.getCustomersNumber());
        shop24Data.getWorkingHourData().get(i).setComment(hour.getComment());
    }

    @Override
    public boolean addWorkingHour(AbstractWorkingHour hour) {
        Shop24Data.WorkingHourData hourData = new Shop24Data.WorkingHourData();
        hourData.setOclock(hour.getOclock());
        hourData.setCustomersNumber(hour.getCustomersNumber());
        hourData.setComment(hour.getComment());
        return shop24Data.getWorkingHourData().add(hourData);
    }

    @Override
    public boolean addWorkingHour(int oclock, int customersNumber, String comment) {
        Shop24Data.WorkingHourData hourData = new Shop24Data.WorkingHourData();
        hourData.setOclock(oclock);
        hourData.setCustomersNumber(customersNumber);
        hourData.setComment(comment);
        return shop24Data.getWorkingHourData().add(hourData);
    }

    @Override
    public int workingHoursCount() {
        return shop24Data.getWorkingHourData().size();
    }

    @Override
    public void clearWorkingHours() {
        shop24Data.getWorkingHourData().clear();
    }

    @Override
    public void sortByCustomersNumberDesc() {
        Collections.sort(shop24Data.getWorkingHourData(), (wh1, wh2) ->
                (-Integer.compare(wh1.getCustomersNumber(),wh2.getCustomersNumber())));
    }

    @Override
    public void sortByCommentsAsc() {
        Collections.sort(shop24Data.getWorkingHourData(), (wh1,wh2) -> (wh1.getComment().compareTo(wh2.getComment())));
    }

    @Override
    public void sortByCommentsDesc() {
        Collections.sort(shop24Data.getWorkingHourData(), (wh1,wh2) -> (-wh1.getComment().compareTo(wh2.getComment())));
    }

    @Override
    public void readFromFile(String fileName) throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance("net.pixeleon.khpi.oop.shop24.model.io.xml");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        shop24Data = (Shop24Data) unmarshaller.unmarshal(new FileReader(fileName));
    }

    @Override
    public void writeToFile(String fileName) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance("net.pixeleon.khpi.oop.shop24.model.io.xml");
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(shop24Data, new FileWriter(fileName));
    }

    public Shop24Data.WorkingHourData getWorkingHourData(int i){
        return shop24Data.getWorkingHourData().get(i);
    }

    public void setWorkingHourData(int i, Shop24Data.WorkingHourData hourData) {
        shop24Data.getWorkingHourData().set(i, hourData);
    }

    public static void main(String[] args) {
        XMLShop24 shop = new XMLShop24();
        try {
            shop.readFromFile("yizhak.xml");
            shop.testMyShop();
            shop.writeToFile("sortedyizhak.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("reading from file failed");
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("writing to file failed");
        } catch (JAXBException e) {
            e.printStackTrace();
            System.out.println("wrong format");
        }
    }
}
