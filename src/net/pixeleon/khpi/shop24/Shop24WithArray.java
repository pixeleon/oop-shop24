package net.pixeleon.khpi.shop24;

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
    public void setWorkingHours(AbstractWorkingHour[] workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public AbstractWorkingHour getWorkingHour(int i) {
        return workingHours[i];
    }

    @Override
    public boolean addWorkingHour(AbstractWorkingHour workingHour) {
        if(getWorkingHours() != null) {
            for (AbstractWorkingHour wh: getWorkingHours()) {
                if(workingHour.equals(wh)) {
                    return false;
                }
            }
        }
        setWorkingHours(addToArray(getWorkingHours(), workingHour));
        return true;
    }

    @Override
    public boolean addWorkingHour(int oclock, int customersNumber, String comment) {
        AbstractWorkingHour workingHour = new WorkingHour(oclock, customersNumber, comment);
        return addWorkingHour(workingHour);
    }

    @Override
    public void setWorkingHour(int i, AbstractWorkingHour wh) {
        workingHours[i] = wh;
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
