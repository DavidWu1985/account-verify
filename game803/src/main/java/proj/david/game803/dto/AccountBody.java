package proj.david.game803.dto;

import java.util.Map;

public class AccountBody {

    private Long id;
    private Map<String, String> data;
    private Map<String, Long> game;
    private String sign;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public Map<String, Long> getGame() {
        return game;
    }

    public void setGame(Map<String, Long> game) {
        this.game = game;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
