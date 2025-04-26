package org.example.hibernate_test.entity;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tovar_id")
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Users user;


    @Column(name = "dAndT")
    private String dAndT;

    @Column(name = "status")
    private Status status;

    //Конструктор без параметров
    public Order() {
    }

    //Конструктор с параметрами
    public Order(Product product, Users user, String dAndT, Status status) {
        this.product = product;
        this.user = user;
        this.dAndT = dAndT;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getdAndT() {
        return dAndT;
    }

    public void setdAndT(String dAndT) {
        this.dAndT = dAndT;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}
