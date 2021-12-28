package jpabasicbook.jpabasicshop;

import jpabasicbook.jpabasicshop.domain.Member;
import jpabasicbook.jpabasicshop.domain.Order;
import jpabasicbook.jpabasicshop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Order order = new Order(); // 양방향 연관관계 방식
            order.addOrderItem(new OrderItem()); // 양방향 연관관계 방식

            //단방향 연관관계 방식
//            Order order = new Order();
//            em.persist(order);
//
//            OrderItem orderItem = new OrderItem();
//            orderItem.setOrder(order);
//            em.persist(orderItem);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
