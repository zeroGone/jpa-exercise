package io.zerogone.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();


    public List<Order> getOrders() {
        return orders;
    }
}
