import com.google.common.collect.ImmutableList;
import com.google.gson.reflect.TypeToken;
import constant.*;
import stock.ExportTool;
import stock.api.StockApi;
import stock.bean.StockKLine;
import stock.bean.StockPanKou;
import stock.spider.SpiderApi;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class ApiDemo {

    /**
     * 财经数据库
     * 歪枣网   http://www.waizaowang.com/
     */
    public static void main(String[] args) throws IOException {
        //请求买卖五档，盘口数据
        SpiderApi realTimeApi = new SpiderApi();
        List<StockPanKou> datas = realTimeApi.getPanKou(ImmutableList.of("sz000001", "sh600000", "bj833171"));
        System.out.println(String.format("输出List对象：%s", datas));//沪深京股票输出

        datas = realTimeApi.getPanKou(ImmutableList.of("gb_ifn"));
        System.out.println(String.format("输出List对象：%s", datas));//美股输出

        String token = "";//歪枣网（www.waizaowang.com）上登录后获取Token
        StockApi restSpider = new StockApi();

        //请求日线数据，返回JSON格式
        String result = restSpider.getDayKLine(
                AssertType.Stock_HS_A.getType(),
                "all",//请求A股所有股票
                KLineType.Day.getType(),
                FqType.Before.getType(),
                "2024-02-01",//code选择all的场景下，开始日期和结束日期必须相同，表示返回市场上当天所有股票的数据
                "2024-02-01",
                "all",//返回全部字段
                token,
                "",
                MethodType.GET,
                ExportType.String_Json);//返回数据类型
        System.out.println(String.format("输出Json字符串：%s", result));//输出

        //返回的Json字符串转Obj对象
        List<StockKLine> list = ExportTool.toObj(result, new TypeToken<List<StockKLine>>() {
        }.getType());
        System.out.println(String.format("输出List对象：%s", list));//输出

        //返回的Json字符串转List<Map<String,String>>
        List<Map<String, String>> map = ExportTool.toJson(result);
        System.out.println(String.format("输出map对象：%s", map));//输出

        //请求日线数据，返回List<StockKLine>格式
        List<StockKLine> data =
                restSpider.getDayKLine(
                        AssertType.Stock_HS_A.getType(),
                        "000001,000002",
                        KLineType.Day.getType(),
                        FqType.Before.getType(),
                        "2024-01-01",
                        "2025-01-01",
                        "code,name,ktype",//定制返回字段
                        token,
                        "",
                        MethodType.POST);

        //请求日线数据，返回Txt格式
        result = restSpider.getDayKLine(
                AssertType.Stock_HS_A.getType(),
                "000001,000002",
                KLineType.Day.getType(),
                FqType.Before.getType(),
                "2024-01-01",
                "2025-01-01",
                "all",//返回返回字段
                token,
                "",
                MethodType.GET,
                ExportType.String_Txt);
        System.out.println(String.format("输出Txt字符串：%s", result));//输出

        //返回的Txt字符串转List<String>
        List<String> txt = ExportTool.toTxt(result);

        //请求日线数据，返回CSV文件
        result = restSpider.getDayKLine(
                AssertType.Stock_HS_A.getType(),
                "000001,000002",
                KLineType.Day.getType(),
                FqType.Before.getType(),
                "2024-01-01",
                "2025-01-01",
                "code,name,ktype",//定制返回字段
                token,
                "",
                MethodType.POST, ExportType.File_Csv);//返回CSV文件内容
        String filePath = System.getProperty("user.dir") + File.separator + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".csv";
        ExportTool.toFile(result, new File(filePath));//导出CSV文件
        System.out.println(String.format("导出Csv文件：filePath=%s", filePath));//输出

        //请求日线数据，返回Json文件
        result = restSpider.getDayKLine(
                AssertType.Stock_HS_A.getType(),
                "000001,000002",
                KLineType.Day.getType(),
                FqType.Before.getType(),
                "2024-01-01",
                "2025-01-01",
                "code,name,ktype",//定制返回字段
                token,
                "",
                MethodType.POST, ExportType.File_JSON);//返回JSON文件内容
        filePath = System.getProperty("user.dir") + File.separator + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".json";
        ExportTool.toFile(result, new File(filePath));//导出JSON文件
        System.out.println(String.format("导出Json文件：filePath=%s", filePath));//输出

        //请求日线数据，返回TXT文件
        result = restSpider.getDayKLine(
                AssertType.Stock_HS_A.getType(),
                "000001,000002",
                KLineType.Day.getType(),
                FqType.Before.getType(),
                "2024-01-01",
                "2025-01-01",
                "code,name,ktype",//定制返回字段
                token,
                "",
                MethodType.POST, ExportType.File_Txt);
        filePath = System.getProperty("user.dir") + File.separator + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".txt";
        ExportTool.toFile(result, new File(filePath));//导出TXT文件
        System.out.println(String.format("导出txt文件：filePath=%s", filePath));//输出
    }
}
