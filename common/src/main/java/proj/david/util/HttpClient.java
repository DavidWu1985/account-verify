package proj.david.util;

import org.apache.http.ParseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class HttpClient {

    private static CloseableHttpClient httpClient;// = HttpClientBuilder.create().build();
    private static ResponseHandler<String> responseHandler;

    static {
        httpClient = HttpClients.custom()
                .useSystemProperties()
                .setRetryHandler(new DefaultHttpRequestRetryHandler(3, true))
                .build();
        responseHandler = new BasicResponseHandler();
    }


    public static String httpPost(String jsonString) {
        String result = null;
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
//        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        // 创建Post请求
        HttpPost httpPost = new HttpPost("http://sgsdkaccount.9game.cn/sg/cp/sgaccount.verifySession");
        StringEntity entity = new StringEntity(jsonString, "UTF-8");
        // post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        // 响应模型
//        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
//            httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
//            HttpEntity responseEntity = response.getEntity();
//            if (responseEntity != null) {
//                result = EntityUtils.toString(responseEntity);
//            }
            //性能优化后代码
            return httpClient.execute(httpPost, responseHandler);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
//        } finally {
//            try {
            // 释放资源
//                if (httpClient != null) {
//                    httpClient.close();
//                }
//                if (response != null) {
//                    response.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
        return result;
    }


    public static String httpGet(String url) {
        String result = null;
        HttpGet httpGet = new HttpGet(url);
//        CloseableHttpResponse response = null;
        try {
//            response = httpClient.execute(httpGet);
//            HttpEntity responseEntity = response.getEntity();
//            if (responseEntity != null) {
//                result = EntityUtils.toString(responseEntity);
//            }
            //性能优化后
            return httpClient.execute(httpGet, responseHandler);
        } catch (IOException e) {
            e.printStackTrace();
//        } finally {
//            try {
//                // 释放资源
//                if (httpClient != null) {
//                    httpClient.close();
//                }
//                if (response != null) {
//                    response.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
        return result;
    }

}
