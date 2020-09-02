package net.pixeleon.khpi.oop.shop24.model;

import java.util.*;

public class Shop24WithList extends AbstractShop24Hour {

    private String name;
    private String address;
    private List<AbstractWorkingHour> workingHours = new ArrayList<>();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public AbstractWorkingHour[] getWorkingHours() {
        return workingHours.toArray(new AbstractWorkingHour[0]);
    }

    @Override
    public void setWorkingHours(AbstractWorkingHour[] hours) {
        this.workingHours = new ArrayList<>(Arrays.asList(hours));
    }

    @Override
    public AbstractWorkingHour getWorkingHour(int i) {
        return workingHours.get(i);
    }

    @Override
    public boolean addWorkingHour(AbstractWorkingHour hour) {
        return workingHours.add(hour);
    }

    @Override
    public boolean addWorkingHour(int oclock, int customersNumber, String comment) {
        return addWorkingHour(new WorkingHour(oclock, customersNumber, comment));
    }

    @Override
    public void setWorkingHour(int i, AbstractWorkingHour hour) {
        workingHours.set(i, hour);
    }

    @Override
    public int workingHoursCount() {
        return workingHours.size();
    }

    @Override
    public void clearWorkingHours() {
        workingHours.clear();
    }

    @Override
    public void sortByCustomersNumberDesc() {
        Collections.sort(workingHours);
    }

    @Override
    public void sortByCommentsAsc() {
        Collections.sort(workingHours, (wh1,wh2) -> (wh1.getComment().compareTo(wh2.getComment())));
    }

    @Override
    public void  sortByCommentsDesc() {
        Collections.sort(workingHours, (wh1,wh2) -> (-wh1.getComment().compareTo(wh2.getComment())));
    }
}
