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

@Table(name="sparepartstype")
public class Sparepartstype {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sparepartstype_id")
    private int sparepartstypeId;

    @NotEmpty
    @Size(min = 3, message = "sparepartsName should have at least 3 characters")
    @Column(name="sparepartstype_name")
    private String sparepartstypeName;

    @Column(name="is_active",columnDefinition = "integer default 0")
    private int isActive;

    @Column(name="is_delete",columnDefinition = "integer default 0")
    private int isDelete;

    @Column(name="created_at")
    private Timestamp createDateTime;

    @Column(name="modified_at")
    private Timestamp updateDateTime;

}
