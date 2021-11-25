package proj.david.kuaishou.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KuaishouConf {

    public static String kuaishouUrlUserinfo;

    @Value("${kuaishou.url.userinfo}")
    public void setKuaishouUrlUserinfo(String kuaishouUrlUserinfo) {
        KuaishouConf.kuaishouUrlUserinfo = kuaishouUrlUserinfo;
    }
}
