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


    private String USER_AGENT = "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Mobile Safari/537.36";

    private String api = "https://api.amemv.com/aweme/v1/aweme/detail/?app_name=aweme&version_name=7.0.0&js_sdk_version=1.18.2.1&device_brand=Xiaomi&aid=1128&aweme_id=";

    @Test
    public void testGetOriginUrl(){
//        HttpResponse response = HttpRequest
//                .get("http://v.douyin.com/krt8BS/")
//                .header(Header.USER_AGENT, USER_AGENT)
//                .execute();

//        String location = response.header("Location");
//        System.out.println("重定向到:"+location);
//        String body = HttpRequest.get(location).header(Header.USER_AGENT, USER_AGENT).execute().body();
//        if (body.contains("itemId")){
//            System.out.println("获取itemId的值...");
//            String itemId = StrUtil.subBetween(body, "itemId: \"", "\"");
//            String api = this.api+itemId;
//            System.out.println("api:"+api);
//            String body1 = HttpRequest.get(api).header(Header.USER_AGENT,USER_AGENT).execute().body();
//            JSONObject result = JSONUtil.parseObj(body1);
//            JSONObject awemeDetail = result.getJSONObject("aweme_detail");
//            JSONObject video = awemeDetail.getJSONObject("video");
//            JSONObject playAddr = video.getJSONObject("play_addr");
//            JSONArray urlList = playAddr.getJSONArray("url_list");
//            Object o = urlList.get(0);
//            System.out.println(o);
////            System.out.println(body1);
//        }
        HttpRequest s = HttpRequest.get("https://api.amemv.com/aweme/v1/aweme/detail/?app_name=aweme&version_name=7.0.0&js_sdk_version=1.18.2.1&device_brand=Xiaomi&aid=1128&aweme_id=6709740106569338124").header(Header.USER_AGENT,USER_AGENT).disableCookie()
                .header(Header.CONTENT_TYPE,"application/json; charset=utf-8");
        HttpResponse execute = s.execute();
        System.out.println(s);
    }

}
