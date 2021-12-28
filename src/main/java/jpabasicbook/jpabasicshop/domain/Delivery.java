package jpabasicbook.jpabasicshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Delivery {

    @Id @GeneratedValue
    private Long id;

    //Order와 양방향 매핑
    @OneToOne(mappedBy = "delivery")
    private Order order;

    private String city;
    private String street;
    private String zipcode;
    private DeliveryStatus status;
}