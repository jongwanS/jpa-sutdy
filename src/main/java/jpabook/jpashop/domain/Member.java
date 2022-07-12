package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity//데이터베이스에 테이블을 만들어준다.
@Getter
@Setter
public class Member {

    //PK를 나타내기 위해 @Id 어노테이션을 사용
    @Id
    /*
    PK 생성전략을 나타냄 예를들어, 오라클 이면 SEQUENCE라는 것을 명시
    ex) @GeneratedValue(strategy = GenerationType.SEQUENCE,
                			generator="USER_PK_GENERATOR")  */
    @GeneratedValue
    private Long id;
    private String name;

    @Embedded//내장타입이다.
    private Address address;

    @OneToMany(mappedBy = "member")//order 테이블에 있는 member에 의해 매핑된놈이야(읽기전용)
    private List<Order> orders = new ArrayList<>();

}
