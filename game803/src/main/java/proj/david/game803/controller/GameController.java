package proj.david.game803.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proj.david.game803.dto.AccountBody;
import proj.david.game803.dto.AccountEntity;
import proj.david.util.HttpClient;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/game/")
public class GameController {

    @PostMapping("/account/verify")
    public Map<String, Object> accountVerify(@RequestBody @Valid AccountEntity entity){
        AccountBody body = new AccountBody();
        body.setId(genId());
        Map<String, String> data = new HashMap<>();
        data.put("sid", entity.getSid());
        body.setData(data);
        Map<String, Long> game = new HashMap<>();
        game.put("gameId", entity.getGameId());
        body.setGame(game);
        String sign = DigestUtils.md5DigestAsHex(("sid="+entity.getSid()+entity.getApiKey()).getBytes());
        body.setSign(sign);
        String result = HttpClient.httpPost(JSONObject.toJSONString(body));
        return JSONObject.parseObject(result);
    }


    private Long genId(){
        ZoneOffset zoneOffset= ZoneOffset.ofHours(8);
        LocalDateTime localDateTime= LocalDateTime.now();
        return localDateTime.toEpochSecond(zoneOffset);
    }
}
