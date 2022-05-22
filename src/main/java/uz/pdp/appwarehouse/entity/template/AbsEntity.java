package uz.pdp.appwarehouse.entity.template;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass

public abstract class AbsEntity { //we need this class to give all other classes similar data fields, all other
                                  //classes extends from this class
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private boolean active = true;

}
