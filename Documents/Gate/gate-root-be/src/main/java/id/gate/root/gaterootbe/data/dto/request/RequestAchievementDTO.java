package id.gate.root.gaterootbe.data.dto.request;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class RequestAchievementDTO implements Serializable {

    private Long userId;
    private String courseName;
    private String associatedWith;
}
