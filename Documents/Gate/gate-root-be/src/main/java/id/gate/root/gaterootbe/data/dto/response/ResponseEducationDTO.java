package id.gate.root.gaterootbe.data.dto.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class ResponseEducationDTO implements Serializable {

    private Long id;

    private String school;

    private String degree;

    private String fieldOfStudy;

    private Integer startYear;

    private Integer endYear;

    private String grade;

    private String activies;

    private String description;

    private Integer status;

    private Date createdAt;

    private Date updateAt;

    private Date deleteAt;


}
