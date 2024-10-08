package com.epam.java.basics.module_24_serialization.task_1_serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class IntItemCharacteristic extends ItemCharacteristic implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    protected int value;

    public IntItemCharacteristic(Long id, String name, String type, int value) {
       super(id, name, type);
       this.value = value;
    }

    public int getValue() {
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
        oos.writeInt(value);
    }

    @Serial
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        id = ois.readLong();
        name = ois.readUTF();
        type = ois.readUTF();
        value = ois.readInt();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntItemCharacteristic that = (IntItemCharacteristic) o;
        return value == that.value && super.equals(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, super.hashCode());
    }
}
