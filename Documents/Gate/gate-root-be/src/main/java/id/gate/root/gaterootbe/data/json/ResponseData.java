package id.gate.root.gaterootbe.data.json;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseData implements Serializable {

    private Integer itemSize;
    private String title;
    private Object data;

    public ResponseData() {
    }

    public ResponseData(Integer itemSize, String title, Object data) {
        this.itemSize = itemSize;
        this.title = title;
        this.data = data;
    }
}
