import bean.StockBaseInfo;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import constant.EnumExportType;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class DemoApplication {

    /**
     * 如果有新的股票数据采集需求，可以直接联系作者
     */
    public static void main(String[] args) throws IOException {
        int exportType = EnumExportType.ExportType_String_Json.getType();
        String token = "";//歪枣网上登录后获取Token
        String url = String.format("http://api.waizaowang.com/doc/getStockHSABaseInfo?code=all&fields=code,name,market&export=%s&token=%s", exportType, token);
        switch (exportType) {
            case 1:
                processJson(url);
                break;
            default:
                processTxt(url);
        }
    }


    private static void processTxt(String url) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpclient.execute(httpGet);
        try {
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);
            System.out.println(content);
            String[] data = content.split(";");
            System.out.println(data);
        } finally {
            response.close();
        }
    }

    private static void processJson(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = getClient().execute(httpGet);
        try {
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);
            System.out.println(content);
            List<StockBaseInfo> data = new Gson().fromJson(JsonParser.parseString(content).getAsJsonObject().get("data"), new TypeToken<List<StockBaseInfo>>() {
            }.getType());
            System.out.println(data);
        } finally {
            response.close();
        }
    }

    private static CloseableHttpClient getClient() {
        return HttpClients.createDefault();
    }
}
