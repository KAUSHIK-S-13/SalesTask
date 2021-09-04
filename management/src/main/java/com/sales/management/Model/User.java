package com.sales.management.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Getter
@Setter

@Table(name="user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;

    @NotEmpty
    @Size(min = 2, message = "user name should have at least 2 characters")
    @Column(name="user_name")
    private String userName;

    @NotEmpty
    @Size(min = 5, message = "password should have at least 5 characters")
    @Column(name="password")
    private String passWord;

    @Column(name="is_active",columnDefinition = "integer default 0")
    private int isActive;

    @Column(name="is_delete",columnDefinition = "integer default 0")
    private int isDelete;

    @Column(name="created_at")
    private Timestamp createDateTime;

    @Column(name="modified_at")
    private Timestamp updateDateTime;

   /*@OneToMany(mappedBy="users")
    private List<Order> order;*/

}
