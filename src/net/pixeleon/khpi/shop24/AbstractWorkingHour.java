package net.pixeleon.khpi.shop24;

import java.util.Arrays;
import java.util.StringTokenizer;

public abstract class AbstractWorkingHour implements Comparable<AbstractWorkingHour>{

    public abstract int getCustomersNumber();
    public abstract void setCustomersNumber(int customersNumber);
    public abstract String getComment();
    public abstract void setComment(String comment);
    public abstract int getOclock();
    public abstract void setOclock(int oclock);

    public boolean containsWord(String word) {
        StringTokenizer st = new StringTokenizer(getComment());
        while (st.hasMoreTokens()) {
            if(st.nextToken().equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }


    public boolean containsSubstring(String substring) {
        return getComment().toLowerCase().contains(substring.toLowerCase());
    }

    private void testWord(String word) {
        if(containsWord(word)) {
            System.out.println("Comment contains the word '" + word+ "'");
        }
        else {
            System.out.println("Comment does not contain the word \"" + word+ "'");
        }
        if (containsSubstring(word)) {
            System.out.println("Comment contains the text '" + word + "'");
        }
        else {
            System.out.println("Comment does not contain the text '" + word + "'");
        }
    }

    @Override
    public String toString() {
        return "Working hour: " + getOclock() + " o'clock" +
                ", customers number: " + getCustomersNumber() +
                ", comment: '" + getComment() +'\'';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        //unnecessary 'obj == null' condition
        if(!(obj instanceof AbstractWorkingHour)) {
            return false;
        }
        AbstractWorkingHour wh = (AbstractWorkingHour) obj;
        return  wh.getOclock() == getOclock() &&
                wh.getCustomersNumber() == getCustomersNumber() &&
                (getComment() != null && getComment().equals(wh.getComment()));

    }

    @Override
    public int compareTo(AbstractWorkingHour wh) {
        return -Integer.compare(getCustomersNumber(), wh.getCustomersNumber());
    }

    protected void testWorkingHour() {
        setOclock(12);
        setCustomersNumber(15);
        setComment("it is too hot in the shop! (no other problems)");
        System.out.println(this);
        testWord("hot");
        testWord("shop");
        testWord("problem");
    }
}
