package proj.david.game803.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AccountEntity {

    @NotBlank(message = "sid不能为空")
    private String sid;

    @NotNull(message = "gameId不能为空")
    private Long gameId;

    @NotBlank(message = "apiKey不能为空")
    private String apiKey;


    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
