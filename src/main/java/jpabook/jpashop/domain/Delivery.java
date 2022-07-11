package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Delivery {
    @Id
    @GeneratedValue
    @Column(name =  "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")//얘는거울이얌
    private Order order;

    @Embedded
    private Address address;

    //EnumType.ORDINAL 숫자형태로 들어감, enum type 추가되면 장애남
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;//ready, comp
}
