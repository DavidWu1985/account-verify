package proj.david.api;

import lombok.Data;

import java.util.Map;

@Data
public class R {
    private Map<String, Object> state;
    private String msg;


}
