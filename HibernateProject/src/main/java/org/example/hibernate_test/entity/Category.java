package org.example.hibernate_test.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mygroup")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;
    @Column(name = "groupName")
    public String name;

    @OneToMany(mappedBy = "cat")
    private List<Product> products;


    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(Class<Category> categoryClass, int identificator) {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if (name.matches("^[A-ZА-ЯЁ][^A-ZА-ЯЁ]*$")) {
            this.name = name;
            return true;
        } else {
            System.out.println("Введите корректные данные - первая буква должна быть заглавной");
            return false;
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';

    }
}
