package trade.backtrade;

import bean.StockKLine;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import trade.TradeInfo;
import trade.strategy.TradeStrategy;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 策略回测
 */
public class BackTest {
    public static String token = "";//登录歪枣网上获取token

    public static void main(String[] args) {
        try {
            back(new TradeStrategy());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void back(TradeStrategy tradeStrategy) throws IOException {
        List<TradeInfo> tradeInfoList = new ArrayList<>();
        List<StockKLine> stockKLineList = getStockKLineList(tradeStrategy).stream().sorted(Comparator.comparing(StockKLine::getTdate)).collect(Collectors.toList());
        for (int todayIndex = 0; todayIndex < stockKLineList.size(); todayIndex++) {
            StockKLine todayStockKLine = stockKLineList.get(todayIndex);
            if (isBuy(todayIndex, stockKLineList, tradeStrategy)) {
                double money = tradeInfoList.stream().filter(tradeInfo -> tradeInfo.isOpen()).count() * tradeStrategy.getSingleMoney();
                if (money < tradeStrategy.getTotalMoney()) {
                    TradeInfo tradeInfo = new TradeInfo();
                    tradeInfo.setOpen(true);
                    tradeInfo.setBuyDate(LocalDate.parse(stockKLineList.get(todayIndex).getTdate()));
                    tradeInfo.setBuyPrice(stockKLineList.get(todayIndex).getClose());
                    tradeInfoList.add(tradeInfo);
                } else {
                    System.out.println("no enough money." + stockKLineList.get(todayIndex));
                }
            }
            sell(todayStockKLine, tradeInfoList, tradeStrategy);
        }
        System.out.println(String.format("成交笔数：%s,被套笔数:%s，策略：%s", tradeInfoList.stream().filter(o -> !o.isOpen()).count(), tradeInfoList.stream().filter(o -> o.isOpen()).count(), tradeStrategy));
        tradeInfoList.stream().forEach(tradeInfo -> System.out.println(tradeInfo));
    }

    private static void sell(StockKLine todayStockKLine, List<TradeInfo> tradeInfoList, TradeStrategy tradeStrategy) {
        tradeInfoList.stream().filter(tradeInfo -> tradeInfo.isOpen()).forEach(tradeInfo -> {
                    if (todayStockKLine.getClose() > tradeInfo.getBuyPrice()
                            && (todayStockKLine.getClose() - tradeInfo.getBuyPrice()) * 100 / tradeInfo.getBuyPrice() > tradeStrategy.getSellPoint()) {
                        tradeInfo.setOpen(false);
                        tradeInfo.setSellDate(LocalDate.parse(todayStockKLine.getTdate()));
                        tradeInfo.setSellPrice(todayStockKLine.getClose());
                    }
                }
        );
    }

    private static boolean isBuy(int todayIndex, List<StockKLine> stockKLineList, TradeStrategy tradeStrategy) {
        StockKLine todayStockKLine = stockKLineList.get(todayIndex);
        for (int index = 1; index < tradeStrategy.getTradeDays() && (todayIndex - index) >= 0; index++) {
            StockKLine lastStockKLine = stockKLineList.get(todayIndex - index);
            if (lastStockKLine.getClose() < tradeStrategy.getProfitLine() && lastStockKLine.getClose() > todayStockKLine.getClose() &&
                    (lastStockKLine.getClose() - todayStockKLine.getClose()) * 100 / lastStockKLine.getClose() > tradeStrategy.getBuyPoint()) {//在安全价格范围内,且下跌幅度足够
                return true;
            }
        }
        return false;
    }

    public static List<StockKLine> getStockKLineList(TradeStrategy tradeStrategy) throws IOException {
        String url = String.format("http://api.waizaowang.com/doc/getCnFundADayKLine?code=%s&startDate=2000-09-15&endDate=2100-01-01&ktype=101&fields=all&export=1&token=%s", tradeStrategy.getStockCode(), token);
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = getClient().execute(httpGet);
        try {
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);
            System.out.println(content);
            return new Gson().fromJson(JsonParser.parseString(content).getAsJsonObject().get("data"), new TypeToken<List<StockKLine>>() {
            }.getType());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            response.close();
        }
        return new ArrayList<>();
    }

    private static CloseableHttpClient getClient() {
        return HttpClients.createDefault();
    }
}
