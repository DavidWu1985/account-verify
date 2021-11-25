package proj.david.kuaishou.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import proj.david.kuaishou.conf.KuaishouConf;
import proj.david.util.HttpClient;

import java.util.Map;

@Service
public class AccountService {

    public Map<String, Object> getAccountInfo(String appId, String gameId, String gameToken){
        StringBuilder builder = new StringBuilder();
        builder.append(KuaishouConf.kuaishouUrlUserinfo).append("app_id=").append(appId)
                .append("&game_id=").append(gameId).append("&game_token=").append(gameToken);
        String result = HttpClient.httpGet(builder.toString());
        return JSONObject.parseObject(result);

    }

}
