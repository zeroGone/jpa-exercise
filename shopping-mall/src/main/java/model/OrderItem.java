package model;

import javax.persistence.*;

@Entity
public class OrderItem extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    private int orderPrice;
    private int count;

    public void setOrder(Order order) {
        this.order = order;
    }
}
