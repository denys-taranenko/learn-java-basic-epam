package com.epam.java.basics.module_24_serialization.task_1_serialization;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class DoubleItemCharacteristic extends ItemCharacteristic  implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    protected double value;

    public DoubleItemCharacteristic(Long id, String name, String type, double value) {
        super(id, name, type);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Serial
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.writeLong(id);
        oos.writeUTF(name);
        oos.writeUTF(type);
        oos.writeDouble(value);
    }

    @Serial
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        id = ois.readLong();
        name = ois.readUTF();
        type = ois.readUTF();
        value = ois.readDouble();
    }

    public void writeItemCharacteristic(DataOutputStream out) throws IOException {
        out.writeDouble(value);
    }


    public void readItemCharacteristic(DataInputStream in) throws IOException {
        value = in.readDouble();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DoubleItemCharacteristic that = (DoubleItemCharacteristic) o;
        return Double.compare(value, that.value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }
}
