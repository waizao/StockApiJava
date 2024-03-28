import com.google.gson.reflect.TypeToken;
import constant.*;
import stock.ExportTool;
import stock.api.StockApi;
import stock.bean.StockBaseInfo;
import stock.bean.StockKLine;

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
        String token = "";//歪枣网（www.waizaowang.com）上登录后获取Token
        StockApi restSpider = new StockApi();
        //请求日线数据，返回JSON格式
        String result = restSpider.getDayKLine(
                AssertType.Stock_HS_A.getType(),
                "all",//返回全部字段
                KLineType.Day.getType(),
                FqType.Before.getType(),
                "2024-02-01",//code选择all的场景下，开始日期和结束日期必须相同，表示返回市场上当天所有股票的数据
                "2024-02-01",
                "all",//返回全部字段
                token,
                "",
                MethodType.GET,
                ExportType.String_Json);//返回数据类型

        //返回的Json字符串转Obj对象
        List<StockKLine> list = ExportTool.toObj(result, new TypeToken<List<StockKLine>>() {
        }.getType());
        //返回的Json字符串转List<Map<String,String>>
        List<Map<String, String>> map = ExportTool.toJson(result);

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
    }
}
