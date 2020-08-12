package net.pixeleon.khpi.oop.shop24.io.xml;

import net.pixeleon.khpi.oop.shop24.AbstractWorkingHour;

public class XMLWorkingHour extends AbstractWorkingHour {
    private Shop24Data.WorkingHourData workingHourData;

    public XMLWorkingHour(Shop24Data.WorkingHourData workingHourData) {
        this.workingHourData = workingHourData;
    }

    @Override
    public int getCustomersNumber() {
        return workingHourData.getCustomersNumber();
    }

    @Override
    public void setCustomersNumber(int customersNumber) {
        workingHourData.setCustomersNumber(customersNumber);
    }

    @Override
    public String getComment() {
        return workingHourData.getComment();
    }

    @Override
    public void setComment(String comment) {
        workingHourData.setComment(comment);
    }

    @Override
    public int getOclock() {
        return workingHourData.getOclock();
    }

    @Override
    public void setOclock(int oclock) {
        workingHourData.setOclock(oclock);
    }
}
