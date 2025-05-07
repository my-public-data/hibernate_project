package org.example.hibernate_test.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tovar")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;
    @Column(name = "tovarCode")
    public String code;
    @Column(name = "tovarName")
    private String product_name;
    @Column(name = "tovarPrice")
    private double product_price;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "mygroup_tovar"
            , joinColumns = @JoinColumn(name = "tovar_id")
            , inverseJoinColumns = @JoinColumn(name = "user_id")
    )

    private List<Users> usersList;


    @ManyToOne
    @JoinColumn(name = "mygroup_id", referencedColumnName = "id")

    private Category cat;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Order> orderList;


    public Product(String code, String product_name, Double product_price, Category cat) {

        this.code = code; // номер товара
        this.product_name = product_name;
        this.product_price = product_price;
        this.cat = cat;
    }

    public Product(String code, String product_name, Double product_price) {

        this.code = code; // номер товара
        this.product_name = product_name;
        this.product_price = product_price;


    }

    public Product() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public boolean setCode(String code) {

        if (code.matches("[A-ZА-Я]{2}\\d{4}")) {
            this.code = code;
            return true;
        } else {
            System.out.println("Введите корректные данные"); // Если то, что введет пользователь не соответствует регулярному выражению
            return false;
        }

    }


    public String getProduct_name() {
        return product_name;
    }

    public boolean setProduct_name(String product_name) {
        if (product_name.matches("^\\s*$")) {                // проверка на пустоту
            System.out.println("Значение наименования товара не может быть пустым");
            return false;
        } else {
            this.product_name = product_name;
            return true;
        }
    }


    public double getProduct_price() {
        return product_price;
    }

    public boolean setProduct_price(double product_price) {
        if (product_price <= 0) {
            System.out.println("Значение цены товара должно быть положительным");
            return false;


        } else {
            this.product_price = product_price;
            return true;
        }

    }


    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String
    toString() {
        return "id товара - " + id + ", " +
                "номер товара - " + code + ", " +
                "наименование товара - " + product_name + ", " +
                " цена товара - " + product_price;
    }

    public void addTovarToUser(Users users) {
        if (usersList == null) {
            usersList = new ArrayList<Users>();
        }
        usersList.add(users);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getId() == product.getId() && Double.compare(getProduct_price(), product.getProduct_price()) == 0 && Objects.equals(getCode(), product.getCode()) && Objects.equals(getProduct_name(), product.getProduct_name()) && Objects.equals(getCat(), product.getCat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode(), getProduct_name(), getProduct_price(), getCat());
    }
}

