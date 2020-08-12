package net.pixeleon.khpi.oop.shop24.io;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileIO {
    void readFromFile(String fileName) throws Exception;
    void writeToFile(String fileName) throws Exception;
}
