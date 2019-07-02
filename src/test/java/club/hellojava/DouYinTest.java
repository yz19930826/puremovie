package club.hellojava;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by yanzhan1 on 2019/7/2 15:14
 **/
public class DouYinTest {


    private String USER_AGENT = "Mozilla/5.0 (Linux; Android 8.0.0; MI 6 Build/OPR1.170623.027; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/62.0.3202.84 Mobile Safari/537.36";

    private String api = "https://aweme.snssdk.com/aweme/v1/aweme/detail/?origin_type=link&retry_type=no_retry&iid=74655440239&device_id=57318346369&ac=wifi&channel=wandoujia&aid=1128&app_name=aweme&version_code=140&version_name=1.4.0&device_platform=android&ssmix=a&device_type=MI+8&device_brand=xiaomi&os_api=22&os_version=5.1.1&uuid=865166029463703&openudid=ec6d541a2f7350cd&manifest_version_code=140&resolution=1080*1920&dpi=1080&update_version_code=1400&ts=1561136202&as=a13510902a54ed1cad&cp=0a40dc5ba5db09cee1&aweme_id=";

    @Test
    public void testGetOriginUrl(){
        HttpResponse response = HttpRequest
                .get("http://v.douyin.com/hT3PsC/")
                .header(Header.USER_AGENT, USER_AGENT)
                .execute();

        String location = response.header("Location");
        System.out.println("重定向到:"+location);
        String body = HttpRequest.get(location).header(Header.USER_AGENT, USER_AGENT).execute().body();
        if (body.contains("itemId")){
            System.out.println("获取itemId的值...");
            String itemId = StrUtil.subBetween(body, "itemId: \"", "\"");
            String api = this.api+itemId;
            System.out.println("api:"+api);
            String body1 = HttpRequest.get(api).header(Header.USER_AGENT,USER_AGENT).execute().body();
            JSONObject result = JSONUtil.parseObj(body1);
            JSONObject awemeDetail = result.getJSONObject("aweme_detail");
            JSONObject video = awemeDetail.getJSONObject("video");
            JSONObject playAddr = video.getJSONObject("play_addr");
            JSONArray urlList = playAddr.getJSONArray("url_list");
            Object o = urlList.get(0);
            System.out.println(o);
//            System.out.println(body1);
        }
    }

}
