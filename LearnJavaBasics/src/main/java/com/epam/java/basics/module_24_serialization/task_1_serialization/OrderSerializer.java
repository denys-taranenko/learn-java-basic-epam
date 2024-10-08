package com.epam.java.basics.module_24_serialization.task_1_serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class OrderSerializer {
    public static void serializeOrder(Order order, OutputStream sink) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(sink);
        outputStream.writeObject(order);
    }

    public static Order deserializeOrder(InputStream sink) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(sink);
        return (Order) inputStream.readObject();
    }
}
