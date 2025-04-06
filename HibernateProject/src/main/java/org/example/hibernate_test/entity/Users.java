package org.example.hibernate_test.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users_table_3")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone_number")
    private String telephone_number;

    @Column(name = "role")
    private String role;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "mygroup2_tovar_directional"
            , joinColumns = @JoinColumn(name = "user_id")
            , inverseJoinColumns = @JoinColumn(name = "tovar_id")
    )
    private List<Product> productList;


    public Users() {
    }

    public Users(String surname, String name, String patronymic, String email, String telephone_number, String role, String login, String password) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.email = email;
        this.telephone_number = telephone_number;
        this.role = role;
        this.login = login;
        this.password = password;

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", email='" + email + '\'' +
                ", telephone_number='" + telephone_number + '\'' +
                ", role='" + role + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }


    public boolean setSurname(String surname) {
        if (surname.matches("^[A-ZА-ЯЁ][^A-ZА-ЯЁ]*$")) {
            this.surname = surname;
            return true;
        } else {
            System.out.println("Введите корректные данные");
            return false;
        }
    }

    public String getName() {
        return name;
    }


    public boolean setName(String name) {
        if (name.matches("^[A-ZА-ЯЁ][^A-ZА-ЯЁ]*$")) {
            this.name = name;
            return true;
        } else {
            System.out.println("Введите корректные данные");
            return false;
        }
    }

    public String getPatronymic() {
        return patronymic;
    }

    public boolean setPatronymic(String patronymic) {
        if (patronymic.matches("^[A-ZА-ЯЁ][^A-ZА-ЯЁ]*$")) {
            this.patronymic = patronymic;
            return true;
        } else {
            System.out.println("Введите корректные данные");
            return false;
        }
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if (email.matches("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}")) {
            this.email = email;
            return true;
        } else {
            System.out.println("Введите корректное значение");
            return false;
        }

    }

    public String getTelephone_number() {
        return telephone_number;
    }

    public boolean setTelephone_number(String telephone_number) {
        if (telephone_number.matches("(\\+7|8)-\\d{3}-\\d{3}-\\d{2}-\\d{2}")) {
            if (telephone_number.length() == 16) {
                this.telephone_number = "+7-" + telephone_number.substring(3);
            } else if (telephone_number.length() == 15) {
                this.telephone_number = "+7-" + telephone_number.substring(2);
            }


            return true;
        } else {
            System.out.println("Введите корректное значение");
            return false;
        }
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public boolean setLogin(String login) {
        if (login.matches("^\\s*$")) {
            System.out.println("Значение логина не может быть пустым");
            return false;
        } else {
            this.login = login;
            return true;
        }
    }

    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {
        if (password.matches("^\\s*$")) {
            System.out.println("Значение пароля не может быть пустым");
            return false;
        } else {
            this.password = password;
            return true;
        }
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void addUserToProduct(Product product) {
        if (productList == null) {
            productList = new ArrayList<Product>();
        }
        productList.add(product);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return getId() == users.getId() && Objects.equals(getSurname(), users.getSurname()) && Objects.equals(getName(), users.getName()) && Objects.equals(getPatronymic(), users.getPatronymic()) && Objects.equals(getEmail(), users.getEmail()) && Objects.equals(getTelephone_number(), users.getTelephone_number()) && Objects.equals(getRole(), users.getRole()) && Objects.equals(getLogin(), users.getLogin()) && Objects.equals(getPassword(), users.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSurname(), getName(), getPatronymic(), getEmail(), getTelephone_number(), getRole(), getLogin(), getPassword());
    }
}


