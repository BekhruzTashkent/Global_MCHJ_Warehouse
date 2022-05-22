package uz.pdp.appwarehouse.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.appwarehouse.entity.template.AbsEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)// we need this because in AbsEntity there such methods and we should implement them here
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Category extends AbsEntity {

    //other datafield in AbsEntity

    @ManyToOne
    private Category parentCategory;   //for instance many types of phone in category telephone


}


