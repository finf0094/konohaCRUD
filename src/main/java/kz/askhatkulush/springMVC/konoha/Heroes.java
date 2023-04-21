package kz.askhatkulush.springMVC.konoha;

import javax.persistence.*;

@Table(name = "heroes")
@Entity
public class Heroes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "rang")
    private String rang;

    public Heroes() {}

    public Heroes(String name, String rang) {
        this.name = name;
        this.rang = rang;
    }
    public Heroes(int id, String name, String rang) {
        this.id = id;
        this.name = name;
        this.rang = rang;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getRang() {
        return rang;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }
}
