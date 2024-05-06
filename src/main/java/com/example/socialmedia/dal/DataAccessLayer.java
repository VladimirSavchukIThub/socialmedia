package com.example.socialmedia.dal;

import com.example.socialmedia.models.*;
import com.example.socialmedia.models.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Getter
public class DataAccessLayer {
    private final SessionFactory sessionFactory;

    @Autowired
    public DataAccessLayer(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    Session session = null;
    public void createProduct(Products newProduct) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newProduct);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteProduct(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Products products = session.get(Products.class, id);
        session.remove(products);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void updateProduct(Long id, Products newProduct){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Products products = session.get(Products.class, id);
        products.setProductName(newProduct.getProductName());
        products.setPrice(newProduct.getPrice());
        products.setDescription(newProduct.getDescription());
        session.merge(products);
        session.getTransaction().commit();
    }
    public Products getProduct(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Products products = session.get(Products.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return products;
    }
    public List<Products> getProducts(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Products> query = builder.createQuery(Products.class);
        Root<Products> root = query.from(Products.class);
        query.select(root);
        List<Products> resultList = session.createQuery(query).getResultList();
        return resultList;
    }
    public void createCategory(Categories newCategory) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newCategory);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteCategory(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Categories categories = session.get(Categories.class, id);
        session.remove(categories);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void updateCategory(Long id, Categories updateCategory){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Categories categories = session.get(Categories.class, id);
        categories.setCategoryName(updateCategory.getCategoryName());
//        employee.setPassport(updatedEmployee.getPassport());
//        employee.setFullName(updatedEmployee.getFullName());
//        employee.setBirthDate(updatedEmployee.getBirthDate());
        session.merge(categories);
        session.getTransaction().commit();
    }
    public Categories getCategory(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Categories categories = session.get(Categories.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return categories;
    }
    public List<Categories> getCategory(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Categories> query = builder.createQuery(Categories.class);
        Root<Categories> root = query.from(Categories.class);
        query.select(root);
        List<Categories> resultList = session.createQuery(query).getResultList();
        return resultList;
    }
    public void createOrder(Orders newOrder) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newOrder);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteOrder(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Orders ticket = session.get(Orders.class, id);
        session.remove(ticket);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void updateOrder(Long id, Orders updateOrder){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Orders orders = session.get(Orders.class, id);
        orders.setOrderDate(updateOrder.getOrderDate());
        session.merge(orders);
        orders.setStatus(updateOrder.getStatus());
        session.merge(orders);
        session.getTransaction().commit();
    }
    public Orders getOrder(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Orders ticket = session.get(Orders.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return ticket;
    }
    public List<Orders> getOrders(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Orders> query = builder.createQuery(Orders.class);
        Root<Orders> root = query.from(Orders.class);
        query.select(root);
        List<Orders> resultList = session.createQuery(query).getResultList();
        return resultList;
    }
    public void createUser(User newUser) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newUser);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteUser(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.remove(user);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void updateUser(Long id, User updateUser){
        session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        user.setUserName(updateUser.getUserName());
        user.setEmail(updateUser.getEmail());
        user.setPassword(updateUser.getPassword());
        user.setAddress(updateUser.getAddress());
        user.setPhoneNumber(updateUser.getPhoneNumber());
        session.merge(user);
        session.getTransaction().commit();
    }
    public User getUser(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        User ticketCategory = session.get(User.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return ticketCategory;
    }
    public List<User> getUsers(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root);
        List<User> resultList = session.createQuery(query).getResultList();
        return resultList;
    }
    public void createDetail(OrderDetails newDetails) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newDetails);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteDetails(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        OrderDetails orderDetails = session.get(OrderDetails.class, id);
        session.remove(orderDetails);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void updateDetails(Long id, OrderDetails updateDetails){
        session = sessionFactory.openSession();
        session.beginTransaction();
        OrderDetails orderDetails = session.get(OrderDetails.class, id);
        orderDetails.setQuantity(updateDetails.getQuantity());
        orderDetails.setUnitPrice(updateDetails.getUnitPrice());
        session.merge(orderDetails);
        session.getTransaction().commit();
    }
    public OrderDetails getDetail(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        OrderDetails position = session.get(OrderDetails.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return position;
    }
    public List<OrderDetails> getDetails(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<OrderDetails> query = builder.createQuery(OrderDetails.class);
        Root<OrderDetails> root = query.from(OrderDetails.class);
        query.select(root);
        List<OrderDetails> resultList = session.createQuery(query).getResultList();
        return resultList;
    }
    public void createReview(Reviews newReview) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newReview);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteReview(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Reviews reviews = session.get(Reviews.class, id);
        session.remove(reviews);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void updateReview(Long id, Reviews updateReview){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Reviews reviews = session.get(Reviews.class, id);
        reviews.setRating(updateReview.getRating());
        reviews.setComment(updateReview.getComment());
        session.merge(reviews);
        session.getTransaction().commit();
    }
    public Reviews getReview(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Reviews reviews = session.get(Reviews.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return reviews;
    }
    public List<Reviews> getReviews(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Reviews> query = builder.createQuery(Reviews.class);
        Root<Reviews> root = query.from(Reviews.class);
        query.select(root);
        List<Reviews> resultList = session.createQuery(query).getResultList();
        return resultList;
    }
    public String newUserToDatabase(User user) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        String name = user.getUserName();
//        String password = user.getPassword();
//        Long phoneNumber = user.getPhoneNumber();
//        String address = user.getAddress();
//        String email = user.getEmail();

        Query query = session
                .createQuery("FROM User WHERE userName = :username")
                .setParameter("username", name);

        User userFrom = (User) query.uniqueResult();

        if (userFrom != null) {
            return "Выберите другое имя";
        }
        session.persist(user);
        session.getTransaction().commit();
        session.close();
        return "Pabeda)";
    }

    public User getUserFromDatabaseByUsername(String name) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session
                .createQuery("FROM User WHERE userName = :username")
                .setParameter("username", name);

        User userFrom = (User) query.uniqueResult();
        if (userFrom == null) {
            return null;
        }
        return userFrom;
    }
}
