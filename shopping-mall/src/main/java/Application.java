import model.Member;
import model.Order;
import model.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabook");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Member member = new Member();
            entityManager.persist(member);

            Order order = new Order();
            entityManager.persist(order);

            OrderItem orderItem = new OrderItem();
            entityManager.persist(orderItem);

            order.addOrderItem(orderItem);
            order.setMember(member);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        EntityManager entityManager2 = entityManagerFactory.createEntityManager();
        Order order = entityManager2.find(Order.class, (long) 2);
        System.out.println(order);
        System.out.println(order.getMember());
        System.out.println(order.getOrderItems().get(0));

        entityManager2.close();
        entityManagerFactory.close();
    }
}
