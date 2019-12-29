package spring.model;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "money")
    private Long money;

    @Column(name = "role")
    private String role;

    public User() {
    }

    public User(String name, String password, Long money) {
        this.name = name;
        this.password = password;
        this.money = money;
        this.role = "user"; //при создании User без указания роли (через регистрацию), по-умолчанию роль будет user
    }

    public User(String name, String password, Long money, String role) {
        this.name = name;
        this.password = password;
        this.money = money;
        this.role = role;
    }

    public User(int id, String name, String password, Long money, String role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.money = money;
        this.role = role;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getName().equals(user.getName()) &&
                getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPassword());
    }

}