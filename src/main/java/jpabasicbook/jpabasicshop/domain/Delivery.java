package jpabasicbook.jpabasicshop.domain;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
public class Delivery extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    //Order와 양방향 매핑
    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

    private String city;
    private String street;
    private String zipcode;
    private DeliveryStatus status;
}
