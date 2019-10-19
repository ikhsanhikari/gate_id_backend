package id.gate.root.gaterootbe.data.json;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseSave implements Serializable {
    private String message;
    private Object data;

    public ResponseSave(Object data) {
        this.message = "Successfully Save Data";
        this.data = data;
    }
}
