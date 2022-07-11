package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.Name;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private  Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "delivery_id")//연관관계주인입니다.
    private Delivery delivery;

    private LocalDateTime orderDate;

    private OrderStatus status;//주문상태
}
