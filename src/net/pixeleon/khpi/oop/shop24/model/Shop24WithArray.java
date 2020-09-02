package net.pixeleon.khpi.oop.shop24.model;

import java.util.Arrays;

public class Shop24WithArray extends AbstractShop24Hour{
    private String name;
    private String address;
    private AbstractWorkingHour[] workingHours;

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
        return workingHours;
    }

    @Override
    public void setWorkingHours(AbstractWorkingHour[] hours) {
        this.workingHours = hours;
    }

    @Override
    public AbstractWorkingHour getWorkingHour(int i) {
        return workingHours[i];
    }

    @Override
    public boolean addWorkingHour(AbstractWorkingHour hour) {
        if(getWorkingHours() != null) {
            for (AbstractWorkingHour wh: getWorkingHours()) {
                if(hour.getOclock() == wh.getOclock()) {
                    return false;
                }
            }
        }
        setWorkingHours(addToArray(getWorkingHours(), hour));
        return true;
    }

    @Override
    public boolean addWorkingHour(int oclock, int customersNumber, String comment) {
        AbstractWorkingHour workingHour = new WorkingHour(oclock, customersNumber, comment);
        return addWorkingHour(workingHour);
    }

    @Override
    public void setWorkingHour(int i, AbstractWorkingHour hour) {
        workingHours[i] = hour;
    }

    @Override
    public int workingHoursCount() {
        return workingHours.length;
    }

    @Override
    public void clearWorkingHours() {
        workingHours = null;
    }

    @Override
    public void sortByCustomersNumberDesc() {
        Arrays.sort(workingHours);
    }

    @Override
    public void sortByCommentsAsc() {
        Arrays.sort(workingHours, (wh1,wh2) -> (wh1.getComment().compareTo(wh2.getComment())));
    }

    @Override
    public void sortByCommentsDesc() {
        Arrays.sort(workingHours, (wh1,wh2) -> (-wh1.getComment().compareTo(wh2.getComment())));
    }

    public static void main(String[] args) {
        new Shop24WithArray().createShop().testMyShop();
    }
}
