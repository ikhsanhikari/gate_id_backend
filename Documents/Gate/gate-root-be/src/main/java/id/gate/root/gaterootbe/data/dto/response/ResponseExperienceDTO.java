package id.gate.root.gaterootbe.data.dto.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class ResponseExperienceDTO implements Serializable {

    private String title;

    private String company;

    private String location;

    private String startDate;

    private String endDate;

    private String headline;

    private String description;


    private Integer status;

    private Date createdAt;

    private Date updateAt;

    private Date deleteAt;
}
