package jpabasicbook.jpabasicshop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id @GeneratedValue
    private Long id;

    private String name;

    //JPA는 자기 자신을 매핑할 수도 있다.
    //카테고리를 펼쳤을 때 목록이 출력되는 매핑
    @ManyToOne
    @JoinColumn(name="PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    //다대다 관계 매핑
    //실무에선 사용 x
    @ManyToMany
    @JoinTable(name = "CATEGORY_ID",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
    private List<Item> items = new ArrayList<>();
}

