package stock.spider;

import client.HttpClientRest;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import stock.bean.DataStockPanKou;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SpiderApi {
    private static final Pattern dataPattern = Pattern.compile("\"(.*?)\"");

    /**
     * 买卖五档，盘口数据
     * 纯爬虫接口，完全免费使用，歪枣网不校验权限也不存储任何数据，若用于商业，请合规使用。
     * 参考网址：https://finance.sina.com.cn/realstock/company/sz000001/nc.shtml
     *
     * @param codes
     * @return StockPanKou
     * @throws IOException
     */
    public List<DataStockPanKou> getPanKou(List<String> codes) throws IOException {
        String url = String.format("https://hq.sinajs.cn/rn=%s&list=%s", System.currentTimeMillis(), codes.stream().collect(Collectors.joining(",")));
        Header[] headers = new BasicHeader[]{new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36"),
                new BasicHeader("Referer", "https://finance.sina.com.cn"), new BasicHeader("host", "hq.sinajs.cn")};
        String result = HttpClientRest.intance.get(url, headers);
        Matcher matcher = dataPattern.matcher(result);
        List<DataStockPanKou> stockPanKous = new ArrayList<>();
        int index = 0;
        while (matcher.find()) {
            String[] datas = matcher.group().replace("\"", "").split(",");
            String code = codes.get(index++);
            if (datas.length >= 33) {
                DataStockPanKou stockPanKou = new DataStockPanKou();
                stockPanKou.setCode(code);
                stockPanKou.setName(datas[0]);
                stockPanKou.setOpen(Float.valueOf(datas[1]));
                stockPanKou.setYclose(Float.valueOf(datas[2]));
                stockPanKou.setPrice(Float.valueOf(datas[3]));
                stockPanKou.setHigh(Float.valueOf(datas[4]));
                stockPanKou.setLow(Float.valueOf(datas[5]));
                stockPanKou.setBid(Float.valueOf(datas[6]));
                stockPanKou.setAsk(Float.valueOf(datas[7]));
                stockPanKou.setV(Float.valueOf(datas[8]));
                stockPanKou.setE(Float.valueOf(datas[9]));
                stockPanKou.setB1v(Float.valueOf(datas[10]));
                stockPanKou.setB1p(Float.valueOf(datas[11]));
                stockPanKou.setB2v(Float.valueOf(datas[12]));
                stockPanKou.setB2p(Float.valueOf(datas[13]));
                stockPanKou.setB3v(Float.valueOf(datas[14]));
                stockPanKou.setB3p(Float.valueOf(datas[15]));
                stockPanKou.setB4v(Float.valueOf(datas[16]));
                stockPanKou.setB4p(Float.valueOf(datas[17]));
                stockPanKou.setB5v(Float.valueOf(datas[18]));
                stockPanKou.setB5p(Float.valueOf(datas[19]));
                stockPanKou.setS1v(Float.valueOf(datas[20]));
                stockPanKou.setS1p(Float.valueOf(datas[21]));
                stockPanKou.setS2v(Float.valueOf(datas[22]));
                stockPanKou.setS2p(Float.valueOf(datas[23]));
                stockPanKou.setS3v(Float.valueOf(datas[24]));
                stockPanKou.setS3p(Float.valueOf(datas[25]));
                stockPanKou.setS4v(Float.valueOf(datas[26]));
                stockPanKou.setS4p(Float.valueOf(datas[27]));
                stockPanKou.setS5v(Float.valueOf(datas[28]));
                stockPanKou.setS5p(Float.valueOf(datas[29]));
                stockPanKou.setTdate(String.format("%s %s", datas[30], datas[31]));
                stockPanKous.add(stockPanKou);
            } else {
                System.out.println("返回数据格式与预期不符。result=" + result);
            }
        }
        return stockPanKous;
    }
}
