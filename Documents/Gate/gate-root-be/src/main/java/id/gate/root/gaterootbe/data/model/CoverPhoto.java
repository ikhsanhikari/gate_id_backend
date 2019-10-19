package id.gate.root.gaterootbe.data.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "cover_photo")
@ToString
public class CoverPhoto implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String url;

    private Boolean isApply;

    private Integer status;

    private Date createdAt;

    private Date updateAt;

    private Date deleteAt;

}
