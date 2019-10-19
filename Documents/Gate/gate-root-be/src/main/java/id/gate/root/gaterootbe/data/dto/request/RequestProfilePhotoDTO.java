package id.gate.root.gaterootbe.data.dto.request;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class RequestProfilePhotoDTO implements Serializable {

    private Long userId;

    private String url;

    private Boolean isApply;

}
