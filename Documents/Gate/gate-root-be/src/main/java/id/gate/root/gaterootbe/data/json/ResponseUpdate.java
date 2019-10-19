package id.gate.root.gaterootbe.data.json;

import lombok.Data;

@Data
public class ResponseUpdate {

    private String message;
    private Object data;

    public ResponseUpdate(Object data) {
        this.message = "Successfully Update Data";
        this.data = data;
    }
}
