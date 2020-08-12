package net.pixeleon.khpi.oop.shop24.io;

import net.pixeleon.khpi.oop.shop24.AbstractWorkingHour;
import net.pixeleon.khpi.oop.shop24.Shop24WithList;
import net.pixeleon.khpi.oop.shop24.WorkingHour;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TextFileShop24 extends Shop24WithList implements FileIO{

    @Override
    public void readFromFile(String fileName) throws FileNotFoundException {
        try(Scanner scanner = new Scanner(new FileReader(fileName))) {
            setName(scanner.nextLine());
            setAddress(scanner.nextLine());
            while (scanner.hasNext()) {
                int oclock = scanner.nextInt();
                int customersNumber = scanner.nextInt();
                String comment = scanner.nextLine().trim();
                addWorkingHour(new WorkingHour(oclock,customersNumber,comment));
            }
        }
    }

    @Override
    public void writeToFile(String fileName) throws IOException {
        try(PrintWriter printer = new PrintWriter(new FileWriter(fileName))) {
            printer.println(getName());
            printer.println(getAddress());
            for(AbstractWorkingHour wh : getWorkingHours()) {
                printer.println(wh.getOclock() + " " + wh.getCustomersNumber());
                printer.println(wh.getComment());
            }
        }
    }

    public static void main(String[] args) {
        TextFileShop24 shop = new TextFileShop24();
        try {
            shop.readFromFile("yizhak.txt");
            shop.testMyShop();
            shop.writeToFile("sortedyizhak.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }
}
