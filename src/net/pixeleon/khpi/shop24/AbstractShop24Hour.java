package net.pixeleon.khpi.shop24;

import java.util.Arrays;

public abstract class AbstractShop24Hour {
    public abstract String getName();
    public abstract void setName(String name);
    public abstract String getAddress();
    public abstract void setAddress(String address);
    public abstract AbstractWorkingHour[] getWorkingHours();
    public abstract void setWorkingHours(AbstractWorkingHour[] workingHours);
    public abstract AbstractWorkingHour getWorkingHour(int i);
    public abstract void setWorkingHour(int i, AbstractWorkingHour hour);
    public abstract boolean addWorkingHour(AbstractWorkingHour hour);
    public abstract boolean addWorkingHour(int oclock, int customersNumber, String comment);
    public abstract int workingHoursCount();
    public abstract void clearWorkingHours();

    public abstract void sortByCustomersNumberDesc();

    public abstract void sortByCommentsAsc();
    public abstract void sortByCommentsDesc();

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Shop name: " + getName() +
                ", address: " + getAddress() +
                ", recorded working hours:\n");
        for (AbstractWorkingHour wh : getWorkingHours()) {
                result.append(wh.toString()).append('\n');
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        //unnecessary 'obj == null' condition
        if(!(obj instanceof AbstractShop24Hour)) return false;
        AbstractShop24Hour shop = (AbstractShop24Hour) obj;

        if ((getName() != shop.getName() &&
                (getName() == null || !getName().equals(shop.getName()))) ||
                (getAddress() != shop.getAddress() &&
                        (getAddress() == null || !getAddress().equals(shop.getAddress())))) {
            return false;
        }
        return getWorkingHours() == shop.getWorkingHours() ||
                (getWorkingHours() != null && Arrays.equals(getWorkingHours(),shop.getWorkingHours()));
    }

    public int totalCustomersNumber() {
        int totalNumber = 0;
        for (AbstractWorkingHour wh: getWorkingHours()) {
            totalNumber += wh.getCustomersNumber();
        }
        return totalNumber;
    }

    public int minCustomersHour() {
        AbstractWorkingHour hour = getWorkingHour(0);
        for (int i = 1; i < workingHoursCount(); i++) {
            if(getWorkingHour(i).getCustomersNumber() < hour.getCustomersNumber()) {
                hour = getWorkingHour(i);
            }
        }
        return hour.getOclock();
    }

    public int maxCustomersHour() {
        AbstractWorkingHour hour = getWorkingHour(0);
        for (int i = 1; i < workingHoursCount(); i++) {
            if(getWorkingHour(i).getCustomersNumber() > hour.getCustomersNumber()) {
                hour = getWorkingHour(i);
            }
        }
        return hour.getOclock();
    }

    public AbstractWorkingHour[] findWord(String word) {
        AbstractWorkingHour[] found = null;
        for (AbstractWorkingHour wh : getWorkingHours()) {
            if(wh.containsWord(word) || wh.containsSubstring(word)) {
                found = addToArray(found, wh);
            }
        }
        return found;
    }

    public static AbstractWorkingHour[] addToArray(AbstractWorkingHour[] hours, AbstractWorkingHour newHour) {
        AbstractWorkingHour[] newHours;
        if(hours != null) {
            newHours = new AbstractWorkingHour[hours.length + 1];
            System.arraycopy(hours, 0, newHours, 0, hours.length);
        }
        else {
            newHours = new  AbstractWorkingHour[1];
        }
        newHours[newHours.length-1] = newHour;
        return newHours;
    }


    private void printWord(String word) {
        AbstractWorkingHour[] result = findWord(word);
        if(result == null) {
            System.out.println("The word '" + word + "' is not present in the comments");
        }
        else {
            System.out.println("The word '" + word + "' is present in these comments: ");
            for(AbstractWorkingHour wh : result) {
                System.out.println(wh);
            }

        }
    }

    public AbstractShop24Hour createShop() {
        setName("Yizhak");
        setAddress("Likvidatoriv str. 31");
        addWorkingHour(10, 17, "we ran out of pepsi and coca-cola");
        addWorkingHour(12, 25,"it is too hot in here");
        addWorkingHour(16, 44, "we have not enough ice cream, people buy it too much");
        addWorkingHour(16,44,"hot!");
        addWorkingHour(21,20,"police came to check the documents");
        addWorkingHour(23,11,"planned cleaning");
        return this;
    }

    public void testMyShop() {
        System.out.println("Total number of customers: " + totalCustomersNumber());
        System.out.println("Hour with the smallest number of customers: " + minCustomersHour() + " o'clock");
        System.out.println("Hour with the biggest number of customers: " + maxCustomersHour() + " o'clock");

        printWord("police");
        printWord("problem");
        printWord("we");

        System.out.println(this);
        sortByCustomersNumberDesc();
        System.out.println(this);
        sortByCommentsAsc();
        System.out.println(this);
        sortByCommentsDesc();
        System.out.println(this);



    }

}
