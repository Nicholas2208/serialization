package org.example.deserialization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.io.InvalidClassException;

public class DeserializationUnitTest {
    private static final String serializedObj = "";
    private static long userDefinedSerialVersionUID = 1234567L;

    /**
     * Tests the deserialization of the original "AppleProduct" (no exceptions are thrown)
     * @throws ClassNotFoundException
     * @throws IOException
     */
    @Test
    public void testDeserializeObj_compatible() throws IOException, ClassNotFoundException {
        assertEquals(userDefinedSerialVersionUID, AppleProduct.getSerialVersionUID());

        AppleProduct macBook = new AppleProduct();
        macBook.headphonePort = "headphonePort2020";
        macBook.thunderboltPort = "thunderboltPort2020";
        macBook.lightningPort = "lightningPort2020";

        // serializes the "AppleProduct" object
        String serializedProduct = SerializationUtility.serializeObjectToString(macBook);

        // deserializes the "AppleProduct" object
        AppleProduct deserializedProduct = (AppleProduct) DeserializationUtility.deSerializeObjectFromString(serializedProduct);

        assertTrue(deserializedProduct.headphonePort.equalsIgnoreCase(macBook.headphonePort));
        assertTrue(deserializedProduct.thunderboltPort.equalsIgnoreCase(macBook.thunderboltPort));
        assertTrue(deserializedProduct.lightningPort.equalsIgnoreCase(macBook.lightningPort));
    }

    /**
     * Tests the deserialization of the modified (non-compatible) "AppleProduct".
     * The test should result in an InvalidClassException being thrown.
     *
     * Note: to run this test:
     *          1. Modify the value of the serialVersionUID identifier in AppleProduct.java
     *          2. Remove the @Ignore annotation
     *          3. Run the test individually (do not run the entire set of tests)
     *          4. Revert the changes made in 1 & 2 (so that you're able to re-run the tests successfully)
     *
     * @throws ClassNotFoundException
     * @throws IOException
     */
    @Ignore
    @Test(expected = InvalidClassException.class)
    public void testDeserializeObj_incompatible() throws ClassNotFoundException, IOException {
        assertNotEquals(userDefinedSerialVersionUID, AppleProduct.getSerialVersionUID());
        // attempts to deserialize the "AppleProduct" object
        DeserializationUtility.deSerializeObjectFromString(serializedObj);
    }
}
