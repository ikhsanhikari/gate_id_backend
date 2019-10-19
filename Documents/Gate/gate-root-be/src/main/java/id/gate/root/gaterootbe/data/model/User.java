package id.gate.root.gaterootbe.data.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@ToString
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String description;

    private String phoneNumber;

    private Date birthDate;

    private String gender;

    private String username;

    private String email;

    private String password;

    private Integer status;

    private Date createdAt;

    private Date updateAt;

    private Date deleteAt;

}
