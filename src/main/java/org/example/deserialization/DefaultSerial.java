package org.example.deserialization;

import java.io.IOException;
import java.io.Serializable;

public class DefaultSerial implements Serializable {
    private String name;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String digest = "";
        DefaultSerial instance = (DefaultSerial) DeserializationUtility.deSerializeObjectFromString(digest);
    }
}
