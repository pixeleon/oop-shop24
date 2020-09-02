package net.pixeleon.khpi.oop.shop24.model.io;

public interface FileIO {
    void readFromFile(String fileName) throws Exception;
    void writeToFile(String fileName) throws Exception;
}
