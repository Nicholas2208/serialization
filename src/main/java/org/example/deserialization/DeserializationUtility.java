package org.example.deserialization;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Base64;

public class DeserializationUtility {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        String serializedObj = "rO0ABXNyAChvcmcuZXhhbXBsZS5kZXNlcmlhbGl6YXRpb24uQXBwbGVQcm9kdWN0AAAAAAAS1ocCAANMAA1oZWFkcGhvbmVQb3J0dAASTGphdmEvbGFuZy9TdHJpbmc7TAANbGlnaHRuaW5nUG9ydHEAfgABTAAPdGh1bmRlcmJvbHRQb3J0cQB+AAF4cHQAEWhlYWRwaG9uZVBvcnQyMDIwdAARbGlnaHRuaW5nUG9ydDIwMjB0ABN0aHVuZGVyYm9sdFBvcnQyMDIw";
        System.out.println("Deserializing AppleProduct...");
        AppleProduct deserializedObj = (AppleProduct) deSerializeObjectFromString(serializedObj);
        System.out.println("Headphone port of AppleProduct:" + deserializedObj.getHeadphonePort());
        System.out.println("Thunderbolt port of AppleProduct:" + deserializedObj.getThunderboltPort());
        System.out.println("LightningPort port of AppleProduct:" + deserializedObj.getLightningPort());
    }

    public static Object deSerializeObjectFromString(String s) throws IOException, ClassNotFoundException {
        byte[] data = Base64.getDecoder().decode(s);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        Object o = ois.readObject();
        ois.close();
        return o;
    }
}
