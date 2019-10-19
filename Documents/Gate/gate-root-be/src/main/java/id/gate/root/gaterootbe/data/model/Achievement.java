package id.gate.root.gaterootbe.data.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Entity
@Table(name = "achievement")
public class Achievement implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    private String associatedWith;

    private Integer status;

    private Date createdAt;

    private Date updateAt;

    private Date deleteAt;

}
