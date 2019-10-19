package id.gate.root.gaterootbe.data.dto.request;

import lombok.Data;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@ToString
public class SampleRequestDTO implements Serializable {
    private String name;
    private MultipartFile file;
}
