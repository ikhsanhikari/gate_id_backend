package id.gate.root.gaterootbe.data.dto.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class ResponseAchievementDTO implements Serializable {

    private String courseName;
    private String associatedWith;

}
