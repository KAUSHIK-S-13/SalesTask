package com.sales.management.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private int orderId;

    @Column(name="order_quantity")
    private int orderQuantity;

    @Column(name="order_destination")
    private String orderDestination;

    @Column(name="is_active",columnDefinition = "integer default 0")
    private int isActive;

    @Column(name="is_delete",columnDefinition = "integer default 0")
    private int isDelete;

    @Column(name="created_at")
    private Timestamp createDateTime;

    @Column(name="modified_at")
    private Timestamp updateDateTime;

    @ManyToOne
    @JoinColumn(name = "fk_spareparts_id")
    private Spareparts sparepartss;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User users;

}
