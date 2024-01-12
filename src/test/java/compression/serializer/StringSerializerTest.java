package compression.serializer;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class StringSerializerTest {

    @Test
    void correctnessOfSerialize() {
        int[] test_array = {1, 1, 1, 3, 2, 299, 300, 285, 10, 200, 123, 123};
        String serialized = StringSerializer.serialize(test_array);
        int[] deserialized = StringSerializer.deserialize(serialized);
        assertArrayEquals(test_array, deserialized);
    }

    @Test
    void reductionSizeTest() {
        int[] test_array = {300, 1, 200, 2, 100};
        String serialized = StringSerializer.serialize(test_array);
        int originalSize = test_array.length * Integer.BYTES;
        int serializedSize = serialized.getBytes().length;
        assertTrue(serializedSize < originalSize);
    }

    @Test
    public void simpleRandomPerformanceTest_1() {
        int[] test_array = new int[50];
        for (int i = 0; i < test_array.length; i++) {
            test_array[i] = 1 + new Random().nextInt(300);
        }

        String serialized = StringSerializer.serialize(test_array);

        int originalSize = test_array.length * Integer.BYTES;

        int serializedSize = serialized.getBytes().length;

        System.out.println("In bytes | original size = " + originalSize + "; serialized size = " + serializedSize);
        assertTrue(serializedSize < originalSize * 2);
    }

    @Test
    public void simpleRandomPerformanceTest_2() {
        int[] test_array = new int[100];
        for (int i = 0; i < test_array.length; i++) {
            test_array[i] = 1 + new Random().nextInt(300);
        }

        String serialized = StringSerializer.serialize(test_array);

        int originalSize = test_array.length * Integer.BYTES;

        int serializedSize = serialized.getBytes().length;

        System.out.println("In bytes | original size = " + originalSize + "; serialized size = " + serializedSize);

        assertTrue(serializedSize < originalSize * 2);
    }

    @Test
    public void simpleRandomPerformanceTest_3() {
        int[] test_array = new int[500];
        for (int i = 0; i < test_array.length; i++) {
            test_array[i] = 1 + new Random().nextInt(300);
        }

        String serialized = StringSerializer.serialize(test_array);

        int originalSize = test_array.length * Integer.BYTES;

        int serializedSize = serialized.getBytes().length;

        System.out.println("In bytes | original size = " + originalSize + "; serialized size = " + serializedSize);

        assertTrue(serializedSize < originalSize * 2);
    }

    @Test
    public void simpleRandomPerformanceTest_4() {
        int[] test_array = new int[1000];
        for (int i = 0; i < test_array.length; i++) {
            test_array[i] = 1 + new Random().nextInt(300);
        }

        String serialized = StringSerializer.serialize(test_array);

        int originalSize = test_array.length * Integer.BYTES;

        int serializedSize = serialized.getBytes().length;

        System.out.println("In bytes | original size = " + originalSize + "; serialized size = " + serializedSize);

        assertTrue(serializedSize < originalSize * 2);
    }

    //All numbers in the range of 1 to 9
    @Test
    public void boundaryRandomPerformanceTest_singleSign() {
        int[] test_array = new int[500];
        for (int i = 0; i < test_array.length; i++) {
            test_array[i] = 1 + new Random().nextInt(9);
        }

        String serialized = StringSerializer.serialize(test_array);

        int originalSize = test_array.length * Integer.BYTES;

        int serializedSize = serialized.getBytes().length;

        System.out.println("In bytes | original size = " + originalSize + "; serialized size = " + serializedSize);

        assertTrue(serializedSize < originalSize * 2);
    }

    //All numbers in the range of tens (10 to 99)
    @Test
    public void boundaryRandomPerformanceTest_twoSign() {
        int[] test_array = new int[700];
        for (int i = 0; i < test_array.length; i++) {
            test_array[i] = 10 + new Random().nextInt(99);
        }

        String serialized = StringSerializer.serialize(test_array);

        int originalSize = test_array.length * Integer.BYTES;

        int serializedSize = serialized.getBytes().length;

        System.out.println("In bytes | original size = " + originalSize + "; serialized size = " + serializedSize);

        assertTrue(serializedSize < originalSize * 2);
    }

    //All numbers in the range of hundreds (100 to 999)
    @Test
    public void boundaryRandomPerformanceTest_threeSign() {

        int[] test_array = new int[1000];

        for (int i = 0; i < test_array.length; i++) {
            test_array[i] = 100 + new Random().nextInt(999);
        }

        String serialized = StringSerializer.serialize(test_array);

        int originalSize = test_array.length * Integer.BYTES;

        int serializedSize = serialized.getBytes().length;

        System.out.println("In bytes | original size = " + originalSize + "; serialized size = " + serializedSize);

        assertTrue(serializedSize < originalSize * 2);
    }

}