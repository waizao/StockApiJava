import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestMain {
    public static void main(String[] args) {
        System.out.println(get("http://127.0.0.1:9030/doc/getStockHSADailyMarket?code=000001&startDate=2021-11-30&endDate=2021-12-31&export=0&token=ac96d60da53c737fffeb166207c26c39&fields=code,tdate"));
    }

    public static String get(String strUrl) {
        try {
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            conn.setConnectTimeout(10000);
            conn.setRequestMethod("GET");
            conn.setUseCaches(false);
            conn.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
            conn.disconnect();
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
