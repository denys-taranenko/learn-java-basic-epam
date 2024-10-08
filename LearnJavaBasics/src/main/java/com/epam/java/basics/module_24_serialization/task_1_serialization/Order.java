package com.epam.java.basics.module_24_serialization.task_1_serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

public class Order implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private BigDecimal total;
    private Map<Item, Integer> items;

    public Order(Long id, Map<Item, Integer> items) {
        this.id = id;
        this.items = items;
        this.total = null;
    }

    public BigDecimal getTotal() {
        if (total == null) {
            if (items == null || items.isEmpty()) {
                total = BigDecimal.ZERO;
            } else {
                total = calculateTotal();
            }
        }
        return total;
    }

    private BigDecimal calculateTotal() {
        BigDecimal totalResult = BigDecimal.ZERO;
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            Item item = entry.getKey();
            Integer itemCounts = entry.getValue();
            totalResult = totalResult.add(item.getPrice().multiply(BigDecimal.valueOf(itemCounts)));
        }
        total = totalResult;
        return total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeLong(id);
        out.writeObject(items);
    }

    @Serial
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        id = in.readLong();
        items = (Map<Item, Integer>) in.readObject();
        total = (BigDecimal) in.readObject();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(items, order.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, items);
    }
}
