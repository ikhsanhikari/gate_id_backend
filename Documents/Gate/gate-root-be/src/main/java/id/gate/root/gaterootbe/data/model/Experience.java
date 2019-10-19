package id.gate.root.gaterootbe.data.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Entity
@Table(name = "experience")
public class Experience implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String company;

    private String location;

    private Date startDate;

    private Date endDate;

    private String headline;

    private String description;


    private Integer status;

    private Date createdAt;

    private Date updateAt;

    private Date deleteAt;

}
