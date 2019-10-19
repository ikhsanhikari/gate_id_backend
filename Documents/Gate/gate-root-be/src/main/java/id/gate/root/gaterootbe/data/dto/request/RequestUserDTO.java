package id.gate.root.gaterootbe.data.dto.request;


import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
@Data
public class RequestUserDTO implements Serializable {

    private String firstName;

    private String lastName;

    private String description;

    private String phoneNumber;

    private Date birthDate;

    private String gender;

    private String email;

    private String password;

}
