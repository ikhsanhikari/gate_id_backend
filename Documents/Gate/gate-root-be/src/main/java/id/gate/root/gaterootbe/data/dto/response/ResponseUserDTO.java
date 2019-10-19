package id.gate.root.gaterootbe.data.dto.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ToString
public class ResponseUserDTO implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private String description;

    private String phoneNumber;

    private Date birthDate;

    private String gender;

    private List<ResponseAchievementDTO> achievements;

    private List<ResponseExperienceDTO> experiences;

    private List<ResponseEducationDTO> educations;
}
