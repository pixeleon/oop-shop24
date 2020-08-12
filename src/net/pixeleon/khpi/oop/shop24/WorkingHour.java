package net.pixeleon.khpi.oop.shop24;

public class WorkingHour extends AbstractWorkingHour{

    int oclock;
    int customersNumber;
    String comment;

    public WorkingHour() {
    }

    public WorkingHour(int oclock, int customersNumber, String comment) {
        this.oclock = oclock;
        this.customersNumber = customersNumber;
        this.comment = comment;
    }

    @Override
    public int getCustomersNumber() {
        return customersNumber;
    }

    @Override
    public void setCustomersNumber(int customersNumber) {
        this.customersNumber = customersNumber;
    }

    @Override
    public String getComment() {
        return comment;
    }

    @Override
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int getOclock() {
        return oclock;
    }

    @Override
    public void setOclock(int oclock) {
        this.oclock = oclock;
    }

    public static void main(String[] args) {
        new WorkingHour().testWorkingHour();
    }
}
