package org.example.hibernate_test.entity;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "number")
    private String number;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Users user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tovar_id")
    private Product product;


    @Column(name = "dAndT")
    private LocalDateTime dAndT;

    @Column(name = "status")
    private Status status;

    //Конструктор без параметров
    public Order() {
    }


    public Order(String number, Users user, Product product, LocalDateTime dAndT, Status status) {
        this.number = number;
        this.user = user;
        this.product = product;
        this.dAndT = dAndT;
        this.status = status;
    }

    public Order(String number, Users user, Product product, Status status) {
        this.number = number;
        this.user = user;
        this.product = product;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDateTime getdAndT() {
        return dAndT;
    }

    public void setdAndT(LocalDateTime dAndT) {
        this.dAndT = dAndT;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}
