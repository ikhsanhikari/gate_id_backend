package id.gate.root.gaterootbe.data.json;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseDelete implements Serializable {

    private String message;
    private Object data;

    public ResponseDelete(Object data) {
        this.message = "Successfully Delete Data";
        this.data = data;
    }
}
