package compression;

import compression.serializer.StringSerializer;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        int[] array = {1, 300, 20, 1};
        String ser = StringSerializer.serialize(array);
        int[] des = StringSerializer.deserialize(ser);

        System.out.println(ser);
        System.out.println(Arrays.toString(des));
    }
}
