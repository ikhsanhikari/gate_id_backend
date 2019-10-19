package id.gate.root.gaterootbe.data.dto.request;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class RequestExperienceDTO implements Serializable {

    private Long userId;

    private String title;

    private String company;

    private String location;

    private Date startDate;

    private Date endDate;

    private String headline;

    private String description;

}
