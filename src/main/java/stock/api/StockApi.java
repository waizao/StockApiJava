package stock.api;

import client.HttpClientRest;
import com.google.common.collect.ImmutableMap;
import com.google.gson.reflect.TypeToken;
import constant.ExportType;
import constant.MethodType;
import stock.ExportTool;
import stock.bean.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class StockApi {

    /**
     *  沪深京A股、沪深京B股、港股、美股、黄金、汇率、Reits、加密货币、沪深指数、香港指数、全球指数、债券指数、场内基金、沪深债券、行业板块、概念板块、地域板块等范围列表。其中行业数据包括行业板块、概念板块、地域板块；场内基金包括ETF基金和LOF基金。可根据股票代码，调用通用接口中的每日行情、分线数据、时线数据、日线数据等接口。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；14|成分股指数；15|A-综合指数；20|场内基金；30|沪深债券；37|A-一级行业；38|A-二级行业；39|A-三级行业；40|B-行业板块；41|B-概念板块；42|B-地域板块；47|C-行业板块；48|C-概念板块；49|C-地域板块；60|加密货币
     * @param code        股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getBaseInfo(int type, String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getBaseInfo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockBaseInfo> getBaseInfo(int type, String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getBaseInfo(type , code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     *  将沪深京股票分类，方便大家根据股票类别获取对应的股票集。包括上证A股、深证A股、北证A股、沪深京B股、新股、创业板、科创板、沪股通(港>沪)、深股通(港>深)、风险警示股票、港股通(沪>港)、港股通(深>港)等类型。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param flags       分类标记，取值范围：1|上证A股；2|深证A股；3|北证A股；4|沪深京B股；5|新股；6|创业板；7|科创板；8|沪股通(港>沪)；9|深股通(港>深)；10|st股票；11|港股通(沪>港)；12|港股通(深>港)；13|注册制上证A股；14|核准制上证A股；15|注册制深证A股；16|核准制深证A股；17|主板港股；18|创业板港股；19|知名港股；20|蓝筹港股；21|红筹港股；22|国企港股；23|知名美股；24|中概美股；25|粉单市场
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getStockType(long flags, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockType";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("flags", flags)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockBaseInfo> getStockType(long flags, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockType(flags , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     *  股票市场交易日历，包括沪深京股票、港股通、沪股通(港>沪)、港股。沪深港通-北向，包括沪股通(港>沪)、深股通(港>深)；沪深港通-南向，包括港股通(沪>港)、港股通(深>港)。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param mtype       市场类型，取值范围：1|沪深京A股；2|港股；3|沪深港通-北向；4|沪深港通-南向
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考TradeDate对象
     * @throws IOException
     */

    public String getTradeDate(int mtype, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getTradeDate";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("mtype", mtype)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<TradeDate> getTradeDate(int mtype, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getTradeDate(mtype , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<TradeDate>>() {
        }.getType());
    }

    /**
     *  资金情况，数据范围包括沪深京A股、港股、美股、沪深指数、场内基金、行业板块、概念板块、地域板块。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；3|港股；4|美股；10|沪深指数；20|场内基金；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorMuchMoney对象
     * @throws IOException
     */

    public String getIndicatorMoney(int type, String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorMoney";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorMuchMoney> getIndicatorMoney(int type, String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorMoney(type , code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorMuchMoney>>() {
        }.getType());
    }

    /**
     *  基本指标，数据范围包括沪深京A股、港股、美股、场内基金。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；3|港股；4|美股；20|场内基金
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorBaseInfo对象
     * @throws IOException
     */

    public String getIndicatorBaseInfo(int type, String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorBaseInfo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorBaseInfo> getIndicatorBaseInfo(int type, String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorBaseInfo(type , code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorBaseInfo>>() {
        }.getType());
    }

    /**
     *  如果想立即获取当天的收盘数据，收盘后可通过本接口采集当天日K线数据。每日行情数据，数据范围包括沪深京A股、沪深京B股、港股、美股、黄金、汇率、Reits、沪深指数、香港指数、全球指数、债券指数、场内基金、沪深债券、行业板块、概念板块、地域板块。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockDailyMarketCopy对象
     * @throws IOException
     */

    public String getDailyMarket(int type, String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getDailyMarket";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockDailyMarketCopy> getDailyMarket(int type, String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getDailyMarket(type , code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockDailyMarketCopy>>() {
        }.getType());
    }

    /**
     *  分线数据，数据以分钟为粒度。数据均为不复权数据。数据范围包括沪深京A股、沪深京B股、港股、美股、场内基金、沪深债券。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param startDate   开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate     结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockMinuteKLine对象
     * @throws IOException
     */

    public String getMinuteKLine(int type, String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getMinuteKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockMinuteKLine> getMinuteKLine(int type, String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getMinuteKLine(type , code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockMinuteKLine>>() {
        }.getType());
    }

    /**
     *  时线数据，提供5分钟、15分钟、30分钟、60分钟数据。数据均为不复权数据。数据范围包括沪深京A股、沪深京B股、港股、美股、沪深指数、香港指数、全球指数、债券指数、场内基金、沪深债券。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：5|5分钟；15|15分钟；30|30分钟；60|60分钟
     * @param startDate   开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate     结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockHourKLine对象
     * @throws IOException
     */

    public String getHourKLine(int type, String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getHourKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockHourKLine> getHourKLine(int type, String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getHourKLine(type , code , ktype , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockHourKLine>>() {
        }.getType());
    }

    /**
     *  如果想收盘后立即获取当日的收盘数据，可通过【实时行情】或者【每日行情】接口获取收盘后的日K线数据。日线、周线、月线数据，数据范围包括沪深京A股、沪深京B股、港股、美股、黄金、汇率、Reits、加密货币、沪深指数、香港指数、全球指数、债券指数、场内基金、沪深债券、行业板块、概念板块、地域板块。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；15|A-综合指数；20|场内基金；30|沪深债券；37|A-一级行业；38|A-二级行业；39|A-三级行业；40|B-行业板块；41|B-概念板块；42|B-地域板块；47|C-行业板块；48|C-概念板块；49|C-地域板块；60|加密货币
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype       K线类别，取值范围：101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockKLine对象
     * @throws IOException
     */

    public String getDayKLine(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getDayKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockKLine> getDayKLine(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getDayKLine(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockKLine>>() {
        }.getType());
    }

    /**
     *  分时成交数据是指在一定时间内的成交和，如3秒内所有成交手数算在一起。数据均为不复权数据。数据范围包括沪深京A股、沪深京B股、场内基金、沪深债券。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；20|场内基金；30|沪深债券
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param startDate   开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate     结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockLevel2TimeDeal对象
     * @throws IOException
     */

    public String getLevel2TimeDeal(int type, String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getLevel2TimeDeal";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockLevel2TimeDeal> getLevel2TimeDeal(int type, String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getLevel2TimeDeal(type , code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockLevel2TimeDeal>>() {
        }.getType());
    }

    /**
     *  指数或者行业板块成分股数据。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：14|成分股指数；15|A-综合指数；37|A-一级行业；38|A-二级行业；39|A-三级行业；40|B-行业板块；41|B-概念板块；42|B-地域板块；47|C-行业板块；48|C-概念板块；49|C-地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockChengFenGu对象
     * @throws IOException
     */

    public String getStockChengFenGu(int type, String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockChengFenGu";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockChengFenGu> getStockChengFenGu(int type, String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockChengFenGu(type , code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockChengFenGu>>() {
        }.getType());
    }

    /**
     *  查询行业板块、概念板块、地域板块下的成分股。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param bkcode      板块代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getHangyeCfg(String bkcode, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getHangyeCfg";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("bkcode", bkcode)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockBaseInfo> getHangyeCfg(String bkcode, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getHangyeCfg(bkcode , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     *  主要包含沪深京主要指数和香港主要指数的成分股数据。特别说明：指数成分股接口中指数只有沪深指数、香港指数中的一部分，大约有700只指数的成分股数据，也就是说沪深指数、香港指数中有部分指数是查不到成分股数据的。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        指数代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ZhiShuChengFenGuZhongZhen对象
     * @throws IOException
     */

    public String getZhiShuChengFenGuZhongZhen(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getZhiShuChengFenGuZhongZhen";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<ZhiShuChengFenGuZhongZhen> getZhiShuChengFenGuZhongZhen(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getZhiShuChengFenGuZhongZhen(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<ZhiShuChengFenGuZhongZhen>>() {
        }.getType());
    }

    /**
     *  只包含沪深300、上证50、中证500、科创50四个指数的成分股数据。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param mtype       指数类别，取值范围：1|沪深300；2|上证50；3|中证500；4|科创50
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ZhiShuChengFenGu对象
     * @throws IOException
     */

    public String getZhiShuChengFenGu(int mtype, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getZhiShuChengFenGu";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("mtype", mtype)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<ZhiShuChengFenGu> getZhiShuChengFenGu(int mtype, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getZhiShuChengFenGu(mtype , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<ZhiShuChengFenGu>>() {
        }.getType());
    }

    /**
     *  盘口买卖五档。纯爬虫接口，完全免费使用。歪枣网不校验权限也不存储任何数据，若用于商业，请合规使用。接口使用详情请参考：https://github.com/waizao，可以直接使用Python SDK或者Java SDK。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockPanKou对象
     * @throws IOException
     */

    public String getStockPanKou(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockPanKou";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockPanKou> getStockPanKou(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockPanKou(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockPanKou>>() {
        }.getType());
    }

    /**
     *  如果想立即获取当天的收盘数据，收盘后可通过本接口采集当天日K线数据。提供沪深京A股、沪深京B股、港股、美股、黄金、汇率、Reits、沪深指数、香港指数、全球指数、债券指数、场内基金（ETF）、沪深债券实时数据获取接口。接口提供交易日当天实时交易数据，数据更新周期1分钟。沪深京股票交易时间：上午9：15--11：30，下午：13：00--15：00。港股交易时间：（1）正常交易时段：9:30至12:00；13:00至16:00。（2）早盘竞价时段：09:00至09:20；收市竞价交易：16:00至16:10。备注：每次请求实时接口只会返回当前最新一条数据。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考WatchStockTimeKLine对象
     * @throws IOException
     */

    public String getWatchStockTimeKLine(int type, String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getWatchStockTimeKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<WatchStockTimeKLine> getWatchStockTimeKLine(int type, String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getWatchStockTimeKLine(type , code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<WatchStockTimeKLine>>() {
        }.getType());
    }

    /**
     *  盘口异动数据，数据更新周期1分钟。沪深京股票交易时间：上午9：15--11：30，下午：13：00--15：00。港股交易时间：（1）正常交易时段：9:30至12:00；13:00至16:00。（2）早盘竞价时段：09:00至09:20；收市竞价交易：16:00至16:10。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockYiDong对象
     * @throws IOException
     */

    public String getStockYiDong(String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockYiDong";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockYiDong> getStockYiDong(String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockYiDong(startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockYiDong>>() {
        }.getType());
    }

    /**
     *  包含当日当前涨停的所有A股股票(不含未中断连续一字涨停板的新股)。注：涨停板行情专题统计不包含ST股票及科创板股票。数据更新周期1分钟。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考PoolZT对象
     * @throws IOException
     */

    public String getPoolZT(String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getPoolZT";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<PoolZT> getPoolZT(String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getPoolZT(startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<PoolZT>>() {
        }.getType());
    }

    /**
     *  包含创下60日新高或近期多次涨停的A股股票。注：涨停板行情专题统计不包含ST股票及科创板股票。数据更新周期1分钟。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考PoolQS对象
     * @throws IOException
     */

    public String getPoolQS(String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getPoolQS";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<PoolQS> getPoolQS(String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getPoolQS(startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<PoolQS>>() {
        }.getType());
    }

    /**
     *  包含上市一年以内且中断了连续一字涨停板的A股股票。注：涨停板行情专题统计不包含ST股票及科创板股票。数据更新周期1分钟。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考PoolCX对象
     * @throws IOException
     */

    public String getPoolCX(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getPoolCX";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<PoolCX> getPoolCX(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getPoolCX(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<PoolCX>>() {
        }.getType());
    }

    /**
     *  包含当日触及过涨停板且当前未封板的A股股票。注：涨停板行情专题统计不包含ST股票及科创板股票。数据更新周期1分钟。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考PoolZB对象
     * @throws IOException
     */

    public String getPoolZB(String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getPoolZB";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<PoolZB> getPoolZB(String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getPoolZB(startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<PoolZB>>() {
        }.getType());
    }

    /**
     *  包含当日当前跌停的所有A股股票。注：涨停板行情专题统计不包含ST股票及科创板股票。数据更新周期1分钟。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考PoolDT对象
     * @throws IOException
     */

    public String getPoolDT(String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getPoolDT";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<PoolDT> getPoolDT(String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getPoolDT(startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<PoolDT>>() {
        }.getType());
    }

    /**
     *  反余弦函数。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaAcos对象
     * @throws IOException
     */

    public String getIndicatorTaAcos(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaAcos";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaAcos> getIndicatorTaAcos(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaAcos(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaAcos>>() {
        }.getType());
    }

    /**
     *  AD指标（Accumulation/Distribution）是一种用于量化分析股票、期货或其他金融资产的技术指标。它主要用于判断资金流向以及市场买卖压力的变化，进而辅助投资者做出买卖决策。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaAd对象
     * @throws IOException
     */

    public String getIndicatorTaAd(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaAd";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaAd> getIndicatorTaAd(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaAd(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaAd>>() {
        }.getType());
    }

    /**
     *  ADOSC指标是一种技术分析指标，全称为累积/派发指标（Accumulation/Distribution Oscillator）。它用于衡量市场买卖压力的强度和方向。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      快速移动平均线周期
     * @param input2      慢速移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaAdOsc对象
     * @throws IOException
     */

    public String getIndicatorTaAdOsc(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaAdOsc";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaAdOsc> getIndicatorTaAdOsc(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaAdOsc(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaAdOsc>>() {
        }.getType());
    }

    /**
     *  向量加法运算。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaAdd对象
     * @throws IOException
     */

    public String getIndicatorTaAdd(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaAdd";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaAdd> getIndicatorTaAdd(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaAdd(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaAdd>>() {
        }.getType());
    }

    /**
     *  ADX指标（Average Directional Movement Index）是一种技术分析指标，用于衡量市场趋势的强弱程度。它由J. Welles Wilder于1978年提出，并广泛应用于股票、期货和外汇市场等。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaAdx对象
     * @throws IOException
     */

    public String getIndicatorTaAdx(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaAdx";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaAdx> getIndicatorTaAdx(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaAdx(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaAdx>>() {
        }.getType());
    }

    /**
     *  ADXR指标（Average Directional Movement Index Rating）是根据ADX指标（Average Directional Index）计算得出的一个指标，用于衡量市场趋势的强度。它是J. Welles Wilder开发的技术分析工具之一。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaAdxr对象
     * @throws IOException
     */

    public String getIndicatorTaAdxr(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaAdxr";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaAdxr> getIndicatorTaAdxr(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaAdxr(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaAdxr>>() {
        }.getType());
    }

    /**
     *  APO（Absolute Price Oscillator）指标是一种技术分析指标，用于衡量股票价格的变动幅度。它计算了两个不同时间周期的移动平均线之间的差异，从而提供了价格变动的绝对数值。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      快速移动平均线周期
     * @param input3      慢速移动平均线周期
     * @param input4      移动平均线类型，取值范围：1|SMA-简单移动平均线；2|EMA-指数移动平均线；3|WMA-加权移动平均线；4|DEMA-双指数移动平均线；5|TEMA-三重指数移动平均线；6|TRIMA-三重移动平均线；7|KAMA-考夫曼自适应移动平均线；8|MAMA-自适应移动平均线；9|T3-三重移动平均线
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaApo对象
     * @throws IOException
     */

    public String getIndicatorTaApo(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaApo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("input3", input3)
                .put("input4", input4)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaApo> getIndicatorTaApo(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaApo(type , code , ktype , fq , startDate , endDate , input1 , input2 , input3 , input4 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaApo>>() {
        }.getType());
    }

    /**
     *  AROON指标的中文名称是“阿隆指标”，该指标是一种技术分析指标，用于衡量价格趋势的强度和趋势的方向。阿隆指标由两条线组成：上升线（Aroon Up）和下降线（Aroon Down）。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaAroon对象
     * @throws IOException
     */

    public String getIndicatorTaAroon(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaAroon";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaAroon> getIndicatorTaAroon(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaAroon(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaAroon>>() {
        }.getType());
    }

    /**
     *  AroonOsc指标的名称是Aroon Oscillator（阿隆振荡器），它是Aroon指标的衍生指标。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaAroonOsc对象
     * @throws IOException
     */

    public String getIndicatorTaAroonOsc(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaAroonOsc";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaAroonOsc> getIndicatorTaAroonOsc(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaAroonOsc(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaAroonOsc>>() {
        }.getType());
    }

    /**
     *  反正弦函数。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaAsin对象
     * @throws IOException
     */

    public String getIndicatorTaAsin(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaAsin";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaAsin> getIndicatorTaAsin(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaAsin(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaAsin>>() {
        }.getType());
    }

    /**
     *  反正切函数。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaAtan对象
     * @throws IOException
     */

    public String getIndicatorTaAtan(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaAtan";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaAtan> getIndicatorTaAtan(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaAtan(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaAtan>>() {
        }.getType());
    }

    /**
     *  ATR称为真实波动幅度指标，英文名称为Average True Range。ATR指标是一种衡量市场波动性的技术指标，它通过计算一定时间内的价格波动幅度，来评估市场的波动性程度。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaAtr对象
     * @throws IOException
     */

    public String getIndicatorTaAtr(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaAtr";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaAtr> getIndicatorTaAtr(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaAtr(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaAtr>>() {
        }.getType());
    }

    /**
     *  称为平均价格，Average Price (AVGPRICE) 。指标计算公式：AVGPRICE = (开盘价 + 最高价 + 最低价 + 收盘价) / 4 。它可以帮助分析师确定资产价格的趋势和波动性。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaAvgPrice对象
     * @throws IOException
     */

    public String getIndicatorTaAvgPrice(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaAvgPrice";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaAvgPrice> getIndicatorTaAvgPrice(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaAvgPrice(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaAvgPrice>>() {
        }.getType());
    }

    /**
     *  BBANDS称为布林带，英文名称为Bollinger Bands。布林带是一种基于统计学原理的技术分析指标，由约翰·布林格（John Bollinger）于20世纪80年代提出。它通过计算价格的标准差来确定价格的高低波动区间，并以此构建出上下两条通道线，从而帮助判断价格的超买和超卖情况。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param input3      上轨道线的标准偏差倍数
     * @param input4      下轨道线的标准偏差倍数
     * @param input5      移动平均线类型，取值范围：1|SMA-简单移动平均线；2|EMA-指数移动平均线；3|WMA-加权移动平均线；4|DEMA-双指数移动平均线；5|TEMA-三重指数移动平均线；6|TRIMA-三重移动平均线；7|KAMA-考夫曼自适应移动平均线；8|MAMA-自适应移动平均线；9|T3-三重移动平均线
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaBbands对象
     * @throws IOException
     */

    public String getIndicatorTaBbands(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String input5, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaBbands";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("input3", input3)
                .put("input4", input4)
                .put("input5", input5)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaBbands> getIndicatorTaBbands(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String input5, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaBbands(type , code , ktype , fq , startDate , endDate , input1 , input2 , input3 , input4 , input5 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaBbands>>() {
        }.getType());
    }

    /**
     *  Beta指标。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input3      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaBeta对象
     * @throws IOException
     */

    public String getIndicatorTaBeta(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaBeta";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("input3", input3)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaBeta> getIndicatorTaBeta(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaBeta(type , code , ktype , fq , startDate , endDate , input1 , input2 , input3 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaBeta>>() {
        }.getType());
    }

    /**
     *  BOP指标的名称是Balance of Power，也称为能量平衡指标。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaBop对象
     * @throws IOException
     */

    public String getIndicatorTaBop(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaBop";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaBop> getIndicatorTaBop(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaBop(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaBop>>() {
        }.getType());
    }

    /**
     *  CCI指标的全称是“商品通道指数”（Commodity Channel Index），它是一种技术分析指标，用于评估商品（或其他金融资产）的价格波动情况和超买超卖状态。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCci对象
     * @throws IOException
     */

    public String getIndicatorTaCci(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCci";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCci> getIndicatorTaCci(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCci(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCci>>() {
        }.getType());
    }

    /**
     *  形态识别-Cdl2Crows指标。Two Crows 两只乌鸦，三日K线模式，第一天长阳，第二天高开收阴，第三天再次高开继续收阴，收盘比前一日收盘价低，预示股价下跌。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdl2Crows对象
     * @throws IOException
     */

    public String getIndicatorTaCdl2Crows(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdl2Crows";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdl2Crows> getIndicatorTaCdl2Crows(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdl2Crows(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdl2Crows>>() {
        }.getType());
    }

    /**
     *  形态识别-Cdl3BlackCrows指标。Three Black Crows 三只乌鸦，三日K线模式，连续三根阴线，每日收盘价都下跌且接近最低价，每日开盘价都在上根K线实体内，预示股价下跌。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdl3BlackCrows对象
     * @throws IOException
     */

    public String getIndicatorTaCdl3BlackCrows(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdl3BlackCrows";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdl3BlackCrows> getIndicatorTaCdl3BlackCrows(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdl3BlackCrows(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdl3BlackCrows>>() {
        }.getType());
    }

    /**
     *  形态识别-Cdl3Inside指标。Three Inside Up/Down 三内部上涨和下跌，三日K线模式，母子信号+长K线，以三内部上涨为例，K线为阴阳阳，第三天收盘价高于第一天开盘价，第二天K线在第一天K线内部，预示着股价上涨。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdl3Inside对象
     * @throws IOException
     */

    public String getIndicatorTaCdl3Inside(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdl3Inside";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdl3Inside> getIndicatorTaCdl3Inside(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdl3Inside(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdl3Inside>>() {
        }.getType());
    }

    /**
     *  形态识别-Cdl3LineStrike指标。Three-Line Strike 三线打击，四日K线模式，前三根阳线，每日收盘价都比前一日高，开盘价在前一日实体内，第四日市场高开，收盘价低于第一日开盘价，预示股价下跌。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdl3LineStrike对象
     * @throws IOException
     */

    public String getIndicatorTaCdl3LineStrike(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdl3LineStrike";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdl3LineStrike> getIndicatorTaCdl3LineStrike(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdl3LineStrike(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdl3LineStrike>>() {
        }.getType());
    }

    /**
     *  形态识别-Cdl3Outside指标。Three Outside Up/Down 三外部上涨和下跌,三日K线模式，与三内部上涨和下跌类似，K线为阴阳阳，但第一日与第二日的K线形态相反，以三外部上涨为例，第一日K线在第二日K线内部，预示着股价上涨。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdl3Outside对象
     * @throws IOException
     */

    public String getIndicatorTaCdl3Outside(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdl3Outside";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdl3Outside> getIndicatorTaCdl3Outside(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdl3Outside(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdl3Outside>>() {
        }.getType());
    }

    /**
     *  形态识别-Cdl3StarsInSouth指标。Three Stars In The South 南方三星，三日K线模式，与大敌当前相反，三日K线皆阴，第一日有长下影线，第二日与第一日类似，K线整体小于第一日，第三日无下影线实体信号，成交价格都在第一日振幅之内，预示下跌趋势反转，股价上升。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdl3StarsInSouth对象
     * @throws IOException
     */

    public String getIndicatorTaCdl3StarsInSouth(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdl3StarsInSouth";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdl3StarsInSouth> getIndicatorTaCdl3StarsInSouth(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdl3StarsInSouth(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdl3StarsInSouth>>() {
        }.getType());
    }

    /**
     *  形态识别-Cdl3WhiteSoldiers指标。Three Advancing White Soldiers 三个白兵，三日K线模式，三日K线皆阳，每日收盘价变高且接近最高价，开盘价在前一日实体上半部，预示股价上升。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdl3WhiteSoldiers对象
     * @throws IOException
     */

    public String getIndicatorTaCdl3WhiteSoldiers(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdl3WhiteSoldiers";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdl3WhiteSoldiers> getIndicatorTaCdl3WhiteSoldiers(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdl3WhiteSoldiers(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdl3WhiteSoldiers>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlAbandonedBaby指标。Abandoned Baby 弃婴，三日K线模式，第二日价格跳空且收十字星（开盘价与收盘价接近，最高价最低价相差不大），预示趋势反转，发生在顶部下跌，底部上涨。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       穿透率
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlAbandonedBaby对象
     * @throws IOException
     */

    public String getIndicatorTaCdlAbandonedBaby(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlAbandonedBaby";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlAbandonedBaby> getIndicatorTaCdlAbandonedBaby(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlAbandonedBaby(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlAbandonedBaby>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlAdvanceBlock指标。Advance Block 大敌当前，三日K线模式，三日都收阳，每日收盘价都比前一日高，开盘价都在前一日实体以内，实体变短，上影线变长。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlAdvanceBlock对象
     * @throws IOException
     */

    public String getIndicatorTaCdlAdvanceBlock(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlAdvanceBlock";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlAdvanceBlock> getIndicatorTaCdlAdvanceBlock(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlAdvanceBlock(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlAdvanceBlock>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlBeltHold指标。Belt-hold CDLBELTHOLD 捉腰带线，两日K线模式，下跌趋势中，第一日阴线，第二日开盘价为最低价，阳线，收盘价接近最高价，预示价格上涨。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlBeltHold对象
     * @throws IOException
     */

    public String getIndicatorTaCdlBeltHold(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlBeltHold";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlBeltHold> getIndicatorTaCdlBeltHold(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlBeltHold(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlBeltHold>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlBreakaway。指标Breakaway 脱离，五日K线模式，以看涨脱离为例，下跌趋势中，第一日长阴线，第二日跳空阴线，延续趋势开始震荡，第五日长阳线，收盘价在第一天收盘价与第二天开盘价之间，预示价格上涨。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlBreakaway对象
     * @throws IOException
     */

    public String getIndicatorTaCdlBreakaway(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlBreakaway";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlBreakaway> getIndicatorTaCdlBreakaway(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlBreakaway(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlBreakaway>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlClosingMarubozu指标。Closing Marubozu 收盘缺影线，一日K线模式，以阳线为例，最低价低于开盘价，收盘价等于最高价，预示着趋势持续。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlClosingMarubozu对象
     * @throws IOException
     */

    public String getIndicatorTaCdlClosingMarubozu(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlClosingMarubozu";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlClosingMarubozu> getIndicatorTaCdlClosingMarubozu(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlClosingMarubozu(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlClosingMarubozu>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlConcealBabysWall指标。Concealing Baby Swallow 藏婴吞没，四日K线模式，下跌趋势中，前两日阴线无影线，第二日开盘、收盘价皆低于第二日，第三日倒锤头，第四日开盘价高于前一日最高价，收盘价低于前一日最低价，预示着底部反转。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlConcealBabysWall对象
     * @throws IOException
     */

    public String getIndicatorTaCdlConcealBabysWall(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlConcealBabysWall";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlConcealBabysWall> getIndicatorTaCdlConcealBabysWall(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlConcealBabysWall(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlConcealBabysWall>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlCounterAttack指标。Counterattack 反击线，二日K线模式，与分离线类似。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlCounterAttack对象
     * @throws IOException
     */

    public String getIndicatorTaCdlCounterAttack(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlCounterAttack";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlCounterAttack> getIndicatorTaCdlCounterAttack(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlCounterAttack(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlCounterAttack>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlDarkCloudCover指标。Dark Cloud Cover 乌云盖顶，二日K线模式，第一日长阳，第二日开盘价高于前一日最高价，收盘价处于前一日实体中部以下，预示着股价下跌。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       穿透率
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlDarkCloudCover对象
     * @throws IOException
     */

    public String getIndicatorTaCdlDarkCloudCover(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlDarkCloudCover";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlDarkCloudCover> getIndicatorTaCdlDarkCloudCover(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlDarkCloudCover(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlDarkCloudCover>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlDoji指标。Doji 十字，一日K线模式，开盘价与收盘价基本相同。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlDoji对象
     * @throws IOException
     */

    public String getIndicatorTaCdlDoji(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlDoji";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlDoji> getIndicatorTaCdlDoji(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlDoji(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlDoji>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlDojiStar指标。Doji Star 十字星，一日K线模式，开盘价与收盘价基本相同，上下影线不会很长，预示着当前趋势反转。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlDojiStar对象
     * @throws IOException
     */

    public String getIndicatorTaCdlDojiStar(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlDojiStar";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlDojiStar> getIndicatorTaCdlDojiStar(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlDojiStar(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlDojiStar>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlDragonflyDoji指标。Dragonfly Doji 蜻蜓十字/T形十字，一日K线模式，开盘后价格一路走低，之后收复，收盘价与开盘价相同，预示趋势反转。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlDragonflyDoji对象
     * @throws IOException
     */

    public String getIndicatorTaCdlDragonflyDoji(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlDragonflyDoji";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlDragonflyDoji> getIndicatorTaCdlDragonflyDoji(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlDragonflyDoji(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlDragonflyDoji>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlEngulfing指标。Dragonfly 蜻蜓十字/T形十字指标，一日K线模式，开盘后价格一路走低，之后收复，收盘价与开盘价相同，预示趋势反转。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlEngulfing对象
     * @throws IOException
     */

    public String getIndicatorTaCdlEngulfing(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlEngulfing";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlEngulfing> getIndicatorTaCdlEngulfing(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlEngulfing(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlEngulfing>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlEveningDojiStar指标。Evening Doji Star 十字暮星指标，三日K线模式，基本模式为暮星，第二日收盘价和开盘价相同，预示顶部反转。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       穿透率
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlEveningDojiStar对象
     * @throws IOException
     */

    public String getIndicatorTaCdlEveningDojiStar(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlEveningDojiStar";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlEveningDojiStar> getIndicatorTaCdlEveningDojiStar(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlEveningDojiStar(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlEveningDojiStar>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlEveningStar指标。Evening Star 暮星指标，三日K线模式，与晨星相反，上升趋势中,第一日阳线，第二日价格振幅较小，第三日阴线，预示顶部反转。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       穿透率
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlEveningStar对象
     * @throws IOException
     */

    public String getIndicatorTaCdlEveningStar(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlEveningStar";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlEveningStar> getIndicatorTaCdlEveningStar(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlEveningStar(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlEveningStar>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlGapSideSideWhite指标。Up/Down-gap side-by-side white lines 向上/下跳空并列阳线指标，二日K线模式，上升趋势向上跳空，下跌趋势向下跳空,第一日与第二日有相同开盘价，实体长度差不多，则趋势持续。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlGapSideSideWhite对象
     * @throws IOException
     */

    public String getIndicatorTaCdlGapSideSideWhite(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlGapSideSideWhite";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlGapSideSideWhite> getIndicatorTaCdlGapSideSideWhite(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlGapSideSideWhite(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlGapSideSideWhite>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlGravestoneDoji指标。Gravestone Doji 墓碑十字/倒T十字指标。一日K线模式，开盘价与收盘价相同，上影线长，无下影线，预示底部反转。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlGravestoneDoji对象
     * @throws IOException
     */

    public String getIndicatorTaCdlGravestoneDoji(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlGravestoneDoji";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlGravestoneDoji> getIndicatorTaCdlGravestoneDoji(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlGravestoneDoji(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlGravestoneDoji>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlHammer指标。Hammer 锤头指标。一日K线模式，实体较短，无上影线，下影线大于实体长度两倍，处于下跌趋势底部，预示反转。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlHammer对象
     * @throws IOException
     */

    public String getIndicatorTaCdlHammer(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlHammer";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlHammer> getIndicatorTaCdlHammer(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlHammer(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlHammer>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlHangingMan指标。Hanging Man 上吊线指标。一日K线模式，形状与锤子类似，处于上升趋势的顶部，预示着趋势反转。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlHangingMan对象
     * @throws IOException
     */

    public String getIndicatorTaCdlHangingMan(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlHangingMan";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlHangingMan> getIndicatorTaCdlHangingMan(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlHangingMan(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlHangingMan>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlHarami指标。Harami Pattern 母子线指标。二日K线模式，分多头母子与空头母子，两者相反，以多头母子为例，在下跌趋势中，第一日K线长阴，第二日开盘价收盘价在第一日价格振幅之内，为阳线，预示趋势反转，股价上升。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlHarami对象
     * @throws IOException
     */

    public String getIndicatorTaCdlHarami(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlHarami";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlHarami> getIndicatorTaCdlHarami(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlHarami(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlHarami>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlHaramiCross指标。Harami Cross Pattern 十字孕线指标。二日K线模式，与母子县类似，若第二日K线是十字线，便称为十字孕线，预示着趋势反转。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlHaramiCross对象
     * @throws IOException
     */

    public String getIndicatorTaCdlHaramiCross(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlHaramiCross";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlHaramiCross> getIndicatorTaCdlHaramiCross(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlHaramiCross(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlHaramiCross>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlHignWave指标。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlHignWave对象
     * @throws IOException
     */

    public String getIndicatorTaCdlHignWave(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlHignWave";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlHignWave> getIndicatorTaCdlHignWave(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlHignWave(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlHignWave>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlHikkake指标。Hikkake Pattern 陷阱，三日K线模式，与母子类似，第二日价格在前一日实体范围内,第三日收盘价高于前两日，反转失败，趋势继续。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlHikkake对象
     * @throws IOException
     */

    public String getIndicatorTaCdlHikkake(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlHikkake";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlHikkake> getIndicatorTaCdlHikkake(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlHikkake(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlHikkake>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlHikkakeMod指标。Modified Hikkake Pattern 修正陷阱，三日K线模式，与陷阱类似，上升趋势中，第三日跳空高开；下跌趋势中，第三日跳空低开，反转失败，趋势继续。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlHikkakeMod对象
     * @throws IOException
     */

    public String getIndicatorTaCdlHikkakeMod(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlHikkakeMod";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlHikkakeMod> getIndicatorTaCdlHikkakeMod(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlHikkakeMod(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlHikkakeMod>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlHomingPigeon指标。Homing Pigeon 家鸽，二日K线模式，与母子线类似，不同的的是二日K线颜色相同，第二日最高价、最低价都在第一日实体之内，预示着趋势反转。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlHomingPigeon对象
     * @throws IOException
     */

    public String getIndicatorTaCdlHomingPigeon(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlHomingPigeon";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlHomingPigeon> getIndicatorTaCdlHomingPigeon(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlHomingPigeon(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlHomingPigeon>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlIdentical3Crows指标。Identical Three Crows 三胞胎乌鸦，三日K线模式，上涨趋势中，三日都为阴线，长度大致相等，每日开盘价等于前一日收盘价，收盘价接近当日最低价，预示价格下跌。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlIdentical3Crows对象
     * @throws IOException
     */

    public String getIndicatorTaCdlIdentical3Crows(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlIdentical3Crows";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlIdentical3Crows> getIndicatorTaCdlIdentical3Crows(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlIdentical3Crows(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlIdentical3Crows>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlInNeck指标。In-Neck Pattern 颈内线，二日K线模式，下跌趋势中，第一日长阴线，第二日开盘价较低，收盘价略高于第一日收盘价，阳线，实体较短，预示着下跌继续。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlInNeck对象
     * @throws IOException
     */

    public String getIndicatorTaCdlInNeck(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlInNeck";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlInNeck> getIndicatorTaCdlInNeck(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlInNeck(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlInNeck>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlInvertedHammer指标。Inverted Hammer 倒锤头，一日K线模式，上影线较长，长度为实体2倍以上，无下影线，在下跌趋势底部，预示着趋势反转。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlInvertedHammer对象
     * @throws IOException
     */

    public String getIndicatorTaCdlInvertedHammer(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlInvertedHammer";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlInvertedHammer> getIndicatorTaCdlInvertedHammer(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlInvertedHammer(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlInvertedHammer>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlKicking指标。Kicking 反冲形态，二日K线模式，与分离线类似，两日K线为秃线，颜色相反，存在跳空缺口。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlKicking对象
     * @throws IOException
     */

    public String getIndicatorTaCdlKicking(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlKicking";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlKicking> getIndicatorTaCdlKicking(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlKicking(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlKicking>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlKickingByLength指标。Kicking - bull/bear determined by the longer marubozu 由较长缺影线决定的反冲形态，二日K线模式，与反冲形态类似，较长缺影线决定价格的涨跌。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlKickingByLength对象
     * @throws IOException
     */

    public String getIndicatorTaCdlKickingByLength(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlKickingByLength";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlKickingByLength> getIndicatorTaCdlKickingByLength(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlKickingByLength(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlKickingByLength>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlLadderBottom指标。Ladder Bottom 梯底，五日K线模式，下跌趋势中，前三日阴线，开盘价与收盘价皆低于前一日开盘、收盘价，第四日倒锤头，第五日开盘价高于前一日开盘价，阳线，收盘价高于前几日价格振幅，预示着底部反转。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlLadderBottom对象
     * @throws IOException
     */

    public String getIndicatorTaCdlLadderBottom(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlLadderBottom";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlLadderBottom> getIndicatorTaCdlLadderBottom(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlLadderBottom(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlLadderBottom>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlLongLeggedDoji指标。Long Legged Doji 长脚十字，一日K线模式，开盘价与收盘价相同居当日价格中部，上下影线长，表达市场不确定性。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlLongLeggedDoji对象
     * @throws IOException
     */

    public String getIndicatorTaCdlLongLeggedDoji(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlLongLeggedDoji";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlLongLeggedDoji> getIndicatorTaCdlLongLeggedDoji(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlLongLeggedDoji(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlLongLeggedDoji>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlLongLine指标。Long Line Candle 长蜡烛，一日K线模式，K线实体长，无上下影线。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlLongLine对象
     * @throws IOException
     */

    public String getIndicatorTaCdlLongLine(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlLongLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlLongLine> getIndicatorTaCdlLongLine(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlLongLine(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlLongLine>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlMarubozu指标。Marubozu 光头光脚/缺影线，一日K线模式，上下两头都没有影线的实体，阴线预示着熊市持续或者牛市反转，阳线相反。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlMarubozu对象
     * @throws IOException
     */

    public String getIndicatorTaCdlMarubozu(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlMarubozu";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlMarubozu> getIndicatorTaCdlMarubozu(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlMarubozu(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlMarubozu>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlMatHold指标。Mat Hold 铺垫，五日K线模式，上涨趋势中，第一日阳线，第二日跳空高开影线，第三、四日短实体影线，第五日阳线，收盘价高于前四日，预示趋势持续。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       穿透率
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlMatHold对象
     * @throws IOException
     */

    public String getIndicatorTaCdlMatHold(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlMatHold";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlMatHold> getIndicatorTaCdlMatHold(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlMatHold(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlMatHold>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlMatchingLow指标。Matching Low 相同低价，二日K线模式，下跌趋势中，第一日长阴线，第二日阴线，收盘价与前一日相同，预示底部确认，该价格为支撑位。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlMatchingLow对象
     * @throws IOException
     */

    public String getIndicatorTaCdlMatchingLow(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlMatchingLow";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlMatchingLow> getIndicatorTaCdlMatchingLow(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlMatchingLow(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlMatchingLow>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlMorningDojiStar指标。Morning Doji Star 十字晨星,三日K线模式，基本模式为晨星，第二日K线为十字星，预示底部反转。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       穿透率
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlMorningDojiStar对象
     * @throws IOException
     */

    public String getIndicatorTaCdlMorningDojiStar(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlMorningDojiStar";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlMorningDojiStar> getIndicatorTaCdlMorningDojiStar(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlMorningDojiStar(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlMorningDojiStar>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlMorningStar指标。Morning Star 晨星，三日K线模式，下跌趋势，第一日阴线，第二日价格振幅较小，第三天阳线，预示底部反转。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       穿透率
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlMorningStar对象
     * @throws IOException
     */

    public String getIndicatorTaCdlMorningStar(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlMorningStar";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlMorningStar> getIndicatorTaCdlMorningStar(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlMorningStar(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlMorningStar>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlOnNeck指标。On-Neck Pattern 颈上线,二日K线模式，下跌趋势中，第一日长阴线，第二日开盘价较低，收盘价与前一日最低价相同，阳线，实体较短，预示着延续下跌趋势。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlOnNeck对象
     * @throws IOException
     */

    public String getIndicatorTaCdlOnNeck(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlOnNeck";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlOnNeck> getIndicatorTaCdlOnNeck(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlOnNeck(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlOnNeck>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlPiercing指标。Piercing Pattern 刺透形态，两日K线模式，下跌趋势中，第一日阴线，第二日收盘价低于前一日最低价，收盘价处在第一日实体上部，预示着底部反转。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlPiercing对象
     * @throws IOException
     */

    public String getIndicatorTaCdlPiercing(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlPiercing";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlPiercing> getIndicatorTaCdlPiercing(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlPiercing(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlPiercing>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlRickshawMan指标。Rickshaw Man 黄包车夫,一日K线模式，与长腿十字线类似，若实体正好处于价格振幅中点，称为黄包车夫。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlRickshawMan对象
     * @throws IOException
     */

    public String getIndicatorTaCdlRickshawMan(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlRickshawMan";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlRickshawMan> getIndicatorTaCdlRickshawMan(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlRickshawMan(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlRickshawMan>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlRiseFall3Methods指标。Rising/Falling Three Methods 上升/下降三法，五日K线模式，以上升三法为例，上涨趋势中，第一日长阳线，中间三日价格在第一日范围内小幅震荡，第五日长阳线，收盘价高于第一日收盘价，预示股价上升。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlRiseFall3Methods对象
     * @throws IOException
     */

    public String getIndicatorTaCdlRiseFall3Methods(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlRiseFall3Methods";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlRiseFall3Methods> getIndicatorTaCdlRiseFall3Methods(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlRiseFall3Methods(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlRiseFall3Methods>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlSeperatingLines指标。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlSeperatingLines对象
     * @throws IOException
     */

    public String getIndicatorTaCdlSeperatingLines(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlSeperatingLines";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlSeperatingLines> getIndicatorTaCdlSeperatingLines(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlSeperatingLines(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlSeperatingLines>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlShootingStar指标。Shooting Star 射击之星，一日K线模式，上影线至少为实体长度两倍，没有下影线，预示着股价下跌。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlShootingStar对象
     * @throws IOException
     */

    public String getIndicatorTaCdlShootingStar(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlShootingStar";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlShootingStar> getIndicatorTaCdlShootingStar(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlShootingStar(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlShootingStar>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlShortLine指标。Short Line Candle 短蜡烛，一日K线模式，实体短，无上下影线。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlShortLine对象
     * @throws IOException
     */

    public String getIndicatorTaCdlShortLine(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlShortLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlShortLine> getIndicatorTaCdlShortLine(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlShortLine(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlShortLine>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlSpinningTop指标。Spinning Top 纺锤，一日K线，实体小。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlSpinningTop对象
     * @throws IOException
     */

    public String getIndicatorTaCdlSpinningTop(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlSpinningTop";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlSpinningTop> getIndicatorTaCdlSpinningTop(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlSpinningTop(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlSpinningTop>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlStalledPattern指标。Stalled Pattern 停顿形态，三日K线模式，上涨趋势中，第二日长阳线，第三日开盘于前一日收盘价附近，短阳线，预示着上涨结束。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlStalledPattern对象
     * @throws IOException
     */

    public String getIndicatorTaCdlStalledPattern(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlStalledPattern";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlStalledPattern> getIndicatorTaCdlStalledPattern(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlStalledPattern(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlStalledPattern>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlStickSandwhich指标。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlStickSandwhich对象
     * @throws IOException
     */

    public String getIndicatorTaCdlStickSandwhich(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlStickSandwhich";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlStickSandwhich> getIndicatorTaCdlStickSandwhich(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlStickSandwhich(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlStickSandwhich>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlTakuri指标。Takuri (Dragonfly Doji with very long lower shadow) 探水竿，一日K线模式，大致与蜻蜓十字相同，下影线长度长。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlTakuri对象
     * @throws IOException
     */

    public String getIndicatorTaCdlTakuri(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlTakuri";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlTakuri> getIndicatorTaCdlTakuri(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlTakuri(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlTakuri>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlTasukiGap指标。Tasuki Gap 跳空并列阴阳线，三日K线模式，分上涨和下跌，以上升为例，前两日阳线，第二日跳空，第三日阴线，收盘价于缺口中，上升趋势持续。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlTasukiGap对象
     * @throws IOException
     */

    public String getIndicatorTaCdlTasukiGap(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlTasukiGap";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlTasukiGap> getIndicatorTaCdlTasukiGap(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlTasukiGap(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlTasukiGap>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlThrusting指标。Thrusting Pattern 插入，二日K线模式，与颈上线类似，下跌趋势中，第一日长阴线，第二日开盘价跳空，收盘价略低于前一日实体中部，与颈上线相比实体较长，预示着趋势持续。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlThrusting对象
     * @throws IOException
     */

    public String getIndicatorTaCdlThrusting(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlThrusting";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlThrusting> getIndicatorTaCdlThrusting(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlThrusting(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlThrusting>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlTristar指标。Tristar Pattern 三星，三日K线模式，由三个十字组成，第二日十字必须高于或者低于第一日和第三日，预示着反转。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlTristar对象
     * @throws IOException
     */

    public String getIndicatorTaCdlTristar(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlTristar";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlTristar> getIndicatorTaCdlTristar(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlTristar(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlTristar>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlUnique3River指标。Unique 3 River 奇特三河床，三日K线模式，下跌趋势中，第一日长阴线，第二日为锤头，最低价创新低，第三日开盘价低于第二日收盘价，收阳线，收盘价不高于第二日收盘价，预示着反转，第二日下影线越长可能性越大。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlUnique3River对象
     * @throws IOException
     */

    public String getIndicatorTaCdlUnique3River(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlUnique3River";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlUnique3River> getIndicatorTaCdlUnique3River(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlUnique3River(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlUnique3River>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlUpsideGap2Crows指标。Upside Gap Two Crows 向上跳空的两只乌鸦，三日K线模式，第一日阳线，第二日跳空以高于第一日最高价开盘，收阴线，第三日开盘价高于第二日，收阴线，与第一日比仍有缺口。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlUpsideGap2Crows对象
     * @throws IOException
     */

    public String getIndicatorTaCdlUpsideGap2Crows(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlUpsideGap2Crows";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlUpsideGap2Crows> getIndicatorTaCdlUpsideGap2Crows(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlUpsideGap2Crows(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlUpsideGap2Crows>>() {
        }.getType());
    }

    /**
     *  形态识别-CdlXSideGap3Methods指标。Upside/Downside Gap Three Methods 上升/下降跳空三法，五日K线模式，以上升跳空三法为例，上涨趋势中，第一日长阳线，第二日短阳线，第三日跳空阳线，第四日阴线，开盘价与收盘价于前两日实体内，第五日长阳线，收盘价高于第一日收盘价，预示股价上升。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCdlXSideGap3Methods对象
     * @throws IOException
     */

    public String getIndicatorTaCdlXSideGap3Methods(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCdlXSideGap3Methods";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCdlXSideGap3Methods> getIndicatorTaCdlXSideGap3Methods(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCdlXSideGap3Methods(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCdlXSideGap3Methods>>() {
        }.getType());
    }

    /**
     *  向上取整数。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCeil对象
     * @throws IOException
     */

    public String getIndicatorTaCeil(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCeil";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCeil> getIndicatorTaCeil(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCeil(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCeil>>() {
        }.getType());
    }

    /**
     *  CMO指标的名称：Chande Momentum Oscillator（CMO，钱德动量振荡器）。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCmo对象
     * @throws IOException
     */

    public String getIndicatorTaCmo(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCmo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCmo> getIndicatorTaCmo(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCmo(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCmo>>() {
        }.getType());
    }

    /**
     *  Correl指标。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input3      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCorrel对象
     * @throws IOException
     */

    public String getIndicatorTaCorrel(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCorrel";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("input3", input3)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCorrel> getIndicatorTaCorrel(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCorrel(type , code , ktype , fq , startDate , endDate , input1 , input2 , input3 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCorrel>>() {
        }.getType());
    }

    /**
     *  余弦函数。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCos对象
     * @throws IOException
     */

    public String getIndicatorTaCos(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCos";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCos> getIndicatorTaCos(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCos(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCos>>() {
        }.getType());
    }

    /**
     *  双曲正弦函数。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaCosh对象
     * @throws IOException
     */

    public String getIndicatorTaCosh(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaCosh";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaCosh> getIndicatorTaCosh(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaCosh(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaCosh>>() {
        }.getType());
    }

    /**
     *  DEMA指标是一种双指数移动平均线，全称为Double Exponential Moving Average。DEMA指标用于平滑价格数据，以便更好地识别价格趋势。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaDema对象
     * @throws IOException
     */

    public String getIndicatorTaDema(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaDema";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaDema> getIndicatorTaDema(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaDema(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaDema>>() {
        }.getType());
    }

    /**
     *  向量减法运算。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaDiv对象
     * @throws IOException
     */

    public String getIndicatorTaDiv(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaDiv";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaDiv> getIndicatorTaDiv(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaDiv(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaDiv>>() {
        }.getType());
    }

    /**
     *  动向指标(DMI)，英文名称是Directional Movement Index。动向指标（Dx）是一种技术分析指标，用于衡量市场趋势的强度和方向。它由综合指标（+DI和-DI）计算得出，可以帮助交易者判断市场是上涨趋势、下跌趋势还是盘整。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaDx对象
     * @throws IOException
     */

    public String getIndicatorTaDx(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaDx";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaDx> getIndicatorTaDx(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaDx(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaDx>>() {
        }.getType());
    }

    /**
     *  EMA指标是指数移动平均线，全称为Exponential Moving Average。它是一种常用的技术分析工具，用于平滑价格数据并识别趋势。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaEma对象
     * @throws IOException
     */

    public String getIndicatorTaEma(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaEma";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaEma> getIndicatorTaEma(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaEma(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaEma>>() {
        }.getType());
    }

    /**
     *  指数曲线。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaExp对象
     * @throws IOException
     */

    public String getIndicatorTaExp(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaExp";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaExp> getIndicatorTaExp(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaExp(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaExp>>() {
        }.getType());
    }

    /**
     *  向下取整数。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaFloor对象
     * @throws IOException
     */

    public String getIndicatorTaFloor(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaFloor";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaFloor> getIndicatorTaFloor(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaFloor(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaFloor>>() {
        }.getType());
    }

    /**
     *  Dominant Cycle Period 希尔伯特变换-主导周期。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaHtDcPeriod对象
     * @throws IOException
     */

    public String getIndicatorTaHtDcPeriod(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaHtDcPeriod";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaHtDcPeriod> getIndicatorTaHtDcPeriod(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaHtDcPeriod(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaHtDcPeriod>>() {
        }.getType());
    }

    /**
     *  Dominant Cycle Phase 希尔伯特变换-主导循环阶段。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaHtDcPhase对象
     * @throws IOException
     */

    public String getIndicatorTaHtDcPhase(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaHtDcPhase";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaHtDcPhase> getIndicatorTaHtDcPhase(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaHtDcPhase(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaHtDcPhase>>() {
        }.getType());
    }

    /**
     *  Phasor Components 希尔伯特变换-希尔伯特变换相量分量。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaHtPhasor对象
     * @throws IOException
     */

    public String getIndicatorTaHtPhasor(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaHtPhasor";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaHtPhasor> getIndicatorTaHtPhasor(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaHtPhasor(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaHtPhasor>>() {
        }.getType());
    }

    /**
     *  SineWave 希尔伯特变换-正弦波。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaHtSine对象
     * @throws IOException
     */

    public String getIndicatorTaHtSine(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaHtSine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaHtSine> getIndicatorTaHtSine(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaHtSine(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaHtSine>>() {
        }.getType());
    }

    /**
     *  Trend vs Cycle Mode 希尔伯特变换-趋势与周期模式。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaHtTrendMode对象
     * @throws IOException
     */

    public String getIndicatorTaHtTrendMode(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaHtTrendMode";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaHtTrendMode> getIndicatorTaHtTrendMode(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaHtTrendMode(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaHtTrendMode>>() {
        }.getType());
    }

    /**
     *  HTTRENDLINE称为趋势线，英文名称为HTTRENDLINE。该指标是一种基于趋势线的技术分析工具。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaHtTrendline对象
     * @throws IOException
     */

    public String getIndicatorTaHtTrendline(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaHtTrendline";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaHtTrendline> getIndicatorTaHtTrendline(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaHtTrendline(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaHtTrendline>>() {
        }.getType());
    }

    /**
     *  KAMA是考夫曼自适应移动平均线，全称为Kaufman Adaptive Moving Average。是由Perry J. Kaufman开发的一种技术分析工具，用于平滑股价走势并提供趋势信号。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaKama对象
     * @throws IOException
     */

    public String getIndicatorTaKama(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaKama";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaKama> getIndicatorTaKama(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaKama(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaKama>>() {
        }.getType());
    }

    /**
     *  LinearReg指标。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaLinearReg对象
     * @throws IOException
     */

    public String getIndicatorTaLinearReg(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaLinearReg";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaLinearReg> getIndicatorTaLinearReg(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaLinearReg(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaLinearReg>>() {
        }.getType());
    }

    /**
     *  LinearRegAngle指标。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaLinearRegAngle对象
     * @throws IOException
     */

    public String getIndicatorTaLinearRegAngle(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaLinearRegAngle";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaLinearRegAngle> getIndicatorTaLinearRegAngle(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaLinearRegAngle(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaLinearRegAngle>>() {
        }.getType());
    }

    /**
     *  LinearRegIntercept指标。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaLinearRegIntercept对象
     * @throws IOException
     */

    public String getIndicatorTaLinearRegIntercept(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaLinearRegIntercept";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaLinearRegIntercept> getIndicatorTaLinearRegIntercept(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaLinearRegIntercept(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaLinearRegIntercept>>() {
        }.getType());
    }

    /**
     *  LinearRegSlope指标。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaLinearRegSlope对象
     * @throws IOException
     */

    public String getIndicatorTaLinearRegSlope(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaLinearRegSlope";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaLinearRegSlope> getIndicatorTaLinearRegSlope(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaLinearRegSlope(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaLinearRegSlope>>() {
        }.getType());
    }

    /**
     *  自然对数。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaLn对象
     * @throws IOException
     */

    public String getIndicatorTaLn(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaLn";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaLn> getIndicatorTaLn(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaLn(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaLn>>() {
        }.getType());
    }

    /**
     *  对数函数。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaLog10对象
     * @throws IOException
     */

    public String getIndicatorTaLog10(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaLog10";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaLog10> getIndicatorTaLog10(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaLog10(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaLog10>>() {
        }.getType());
    }

    /**
     *  MACD指标的中文名称为移动平均线收敛/发散指标，英文名称为Moving Average Convergence Divergence。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      快速移动平均线周期
     * @param input3      慢速移动平均线周期
     * @param input4      信号移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaMacd对象
     * @throws IOException
     */

    public String getIndicatorTaMacd(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaMacd";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("input3", input3)
                .put("input4", input4)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaMacd> getIndicatorTaMacd(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaMacd(type , code , ktype , fq , startDate , endDate , input1 , input2 , input3 , input4 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaMacd>>() {
        }.getType());
    }

    /**
     *  MACDEXT指标的中文名称是MACD扩展，英文名称是MACD Extended。MACD扩展是基于移动平均线收敛背离（MACD）指标的一种变种指标。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      快速移动平均线周期
     * @param input3      快速移动平均线类型，取值范围：1|SMA-简单移动平均线；2|EMA-指数移动平均线；3|WMA-加权移动平均线；4|DEMA-双指数移动平均线；5|TEMA-三重指数移动平均线；6|TRIMA-三重移动平均线；7|KAMA-考夫曼自适应移动平均线；8|MAMA-自适应移动平均线；9|T3-三重移动平均线
     * @param input4      慢速移动平均线周期
     * @param input5      慢速移动平均线类型，取值范围：1|SMA-简单移动平均线；2|EMA-指数移动平均线；3|WMA-加权移动平均线；4|DEMA-双指数移动平均线；5|TEMA-三重指数移动平均线；6|TRIMA-三重移动平均线；7|KAMA-考夫曼自适应移动平均线；8|MAMA-自适应移动平均线；9|T3-三重移动平均线
     * @param input6      信号移动平均线周期
     * @param input7      信号移动平均线类型，取值范围：1|SMA-简单移动平均线；2|EMA-指数移动平均线；3|WMA-加权移动平均线；4|DEMA-双指数移动平均线；5|TEMA-三重指数移动平均线；6|TRIMA-三重移动平均线；7|KAMA-考夫曼自适应移动平均线；8|MAMA-自适应移动平均线；9|T3-三重移动平均线
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaMacdExt对象
     * @throws IOException
     */

    public String getIndicatorTaMacdExt(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String input5, String input6, String input7, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaMacdExt";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("input3", input3)
                .put("input4", input4)
                .put("input5", input5)
                .put("input6", input6)
                .put("input7", input7)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaMacdExt> getIndicatorTaMacdExt(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String input5, String input6, String input7, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaMacdExt(type , code , ktype , fq , startDate , endDate , input1 , input2 , input3 , input4 , input5 , input6 , input7 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaMacdExt>>() {
        }.getType());
    }

    /**
     *  MACDFIX指标的中文名称为移动平均收敛/背离指标，英文名称为Moving Average Convergence Divergence Fix。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      信号移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaMacdFix对象
     * @throws IOException
     */

    public String getIndicatorTaMacdFix(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaMacdFix";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaMacdFix> getIndicatorTaMacdFix(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaMacdFix(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaMacdFix>>() {
        }.getType());
    }

    /**
     *  MAMA是MESA自适应移动平均线，全称为MESA Adaptive Moving Average。它是根据价格的移动平均线和自适应移动平均线来计算的，它的设计初衷是能够更好地适应不同市场的变化。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      输入参数
     * @param input3      输入参数
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaMama对象
     * @throws IOException
     */

    public String getIndicatorTaMama(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaMama";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("input3", input3)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaMama> getIndicatorTaMama(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaMama(type , code , ktype , fq , startDate , endDate , input1 , input2 , input3 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaMama>>() {
        }.getType());
    }

    /**
     *  周期内最大值。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaMax对象
     * @throws IOException
     */

    public String getIndicatorTaMax(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaMax";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaMax> getIndicatorTaMax(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaMax(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaMax>>() {
        }.getType());
    }

    /**
     *  周期内最大值的索引。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaMaxIndex对象
     * @throws IOException
     */

    public String getIndicatorTaMaxIndex(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaMaxIndex";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaMaxIndex> getIndicatorTaMaxIndex(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaMaxIndex(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaMaxIndex>>() {
        }.getType());
    }

    /**
     *  称为中位数价格指标，Median Price Indicator。指标计算公式：MEDPRICE = (最高价 + 最低价) / 2。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaMedPrice对象
     * @throws IOException
     */

    public String getIndicatorTaMedPrice(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaMedPrice";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaMedPrice> getIndicatorTaMedPrice(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaMedPrice(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaMedPrice>>() {
        }.getType());
    }

    /**
     *  MFI指标的中文名称是资金流量指标，英文名称是Money Flow Index。MFI指标是一种衡量资金流入和流出的指标。它通过计算一定时期内的典型价格和成交量的买卖压力来衡量市场的超买和超卖情况。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaMfi对象
     * @throws IOException
     */

    public String getIndicatorTaMfi(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaMfi";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaMfi> getIndicatorTaMfi(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaMfi(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaMfi>>() {
        }.getType());
    }

    /**
     *  MIDPOINT是一种基于价格的技术指标，用于衡量价格趋势的中点。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaMidPoint对象
     * @throws IOException
     */

    public String getIndicatorTaMidPoint(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaMidPoint";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaMidPoint> getIndicatorTaMidPoint(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaMidPoint(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaMidPoint>>() {
        }.getType());
    }

    /**
     *  MIDPRICE指标是一种技术分析工具，用于计算一段时间内的市场中间价。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaMidPrice对象
     * @throws IOException
     */

    public String getIndicatorTaMidPrice(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaMidPrice";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaMidPrice> getIndicatorTaMidPrice(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaMidPrice(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaMidPrice>>() {
        }.getType());
    }

    /**
     *  周期内最小值。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaMin对象
     * @throws IOException
     */

    public String getIndicatorTaMin(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaMin";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaMin> getIndicatorTaMin(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaMin(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaMin>>() {
        }.getType());
    }

    /**
     *  周期内最小值的索引。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaMinIndex对象
     * @throws IOException
     */

    public String getIndicatorTaMinIndex(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaMinIndex";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaMinIndex> getIndicatorTaMinIndex(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaMinIndex(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaMinIndex>>() {
        }.getType());
    }

    /**
     *  周期内最小值和最大值。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaMinMax对象
     * @throws IOException
     */

    public String getIndicatorTaMinMax(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaMinMax";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaMinMax> getIndicatorTaMinMax(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaMinMax(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaMinMax>>() {
        }.getType());
    }

    /**
     *  周期内最小值和最大值索引。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaMinMaxIndex对象
     * @throws IOException
     */

    public String getIndicatorTaMinMaxIndex(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaMinMaxIndex";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaMinMaxIndex> getIndicatorTaMinMaxIndex(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaMinMaxIndex(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaMinMaxIndex>>() {
        }.getType());
    }

    /**
     *  MINUSDI指标中文名称为负向动向指标，英文名称为Negative Directional Indicator。它是技术分析中的一个指标，用于衡量市场下跌趋势的强度。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaMinusDI对象
     * @throws IOException
     */

    public String getIndicatorTaMinusDI(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaMinusDI";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaMinusDI> getIndicatorTaMinusDI(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaMinusDI(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaMinusDI>>() {
        }.getType());
    }

    /**
     *  MINUSDM指标的中文名称为负方向运动指标，英文名称为Minus Directional Movement Indicator。该指标用于衡量股价下跌的动力和趋势强度。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaMinusDM对象
     * @throws IOException
     */

    public String getIndicatorTaMinusDM(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaMinusDM";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaMinusDM> getIndicatorTaMinusDM(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaMinusDM(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaMinusDM>>() {
        }.getType());
    }

    /**
     *  MOM金融指标的中文名称为动量指标，英文名称为Momentum Indicator。该指标是通过比较当前价格与一定期间前的价格变动情况来衡量市场的趋势力量。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaMom对象
     * @throws IOException
     */

    public String getIndicatorTaMom(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaMom";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaMom> getIndicatorTaMom(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaMom(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaMom>>() {
        }.getType());
    }

    /**
     *  MOVINGAVERAGE金融指标的中文名称为移动平均线，英文名称为Moving Average。该指标通过计算一段时间内收盘价的平均值来观察价格变动的趋势。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param input3      移动平均线类型，取值范围：1|SMA-简单移动平均线；2|EMA-指数移动平均线；3|WMA-加权移动平均线；4|DEMA-双指数移动平均线；5|TEMA-三重指数移动平均线；6|TRIMA-三重移动平均线；7|KAMA-考夫曼自适应移动平均线；8|MAMA-自适应移动平均线；9|T3-三重移动平均线
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaMovingAverage对象
     * @throws IOException
     */

    public String getIndicatorTaMovingAverage(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaMovingAverage";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("input3", input3)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaMovingAverage> getIndicatorTaMovingAverage(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaMovingAverage(type , code , ktype , fq , startDate , endDate , input1 , input2 , input3 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaMovingAverage>>() {
        }.getType());
    }

    /**
     *  向量乘法运算。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaMult对象
     * @throws IOException
     */

    public String getIndicatorTaMult(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaMult";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaMult> getIndicatorTaMult(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaMult(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaMult>>() {
        }.getType());
    }

    /**
     *  NATR称为归一化真实波动幅度，英文名称为Normalized Average True Range。该指标用于衡量市场的波动性。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaNatr对象
     * @throws IOException
     */

    public String getIndicatorTaNatr(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaNatr";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaNatr> getIndicatorTaNatr(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaNatr(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaNatr>>() {
        }.getType());
    }

    /**
     *  OBV指标（On-Balance Volume）是一种量能指标，用于衡量成交量的变化趋势和预测价格趋势的强弱。OBV指标通过统计成交量的正负值来判断市场的买卖力量，从而预测价格的上涨或下跌趋势。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaObv对象
     * @throws IOException
     */

    public String getIndicatorTaObv(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaObv";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaObv> getIndicatorTaObv(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaObv(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaObv>>() {
        }.getType());
    }

    /**
     *  正向移动方向指标，英文名称是Positive Directional Indicator。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaPlusDI对象
     * @throws IOException
     */

    public String getIndicatorTaPlusDI(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaPlusDI";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaPlusDI> getIndicatorTaPlusDI(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaPlusDI(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaPlusDI>>() {
        }.getType());
    }

    /**
     *  正向动向变动指标，英文名称是Positive Directional Movement。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaPlusDM对象
     * @throws IOException
     */

    public String getIndicatorTaPlusDM(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaPlusDM";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaPlusDM> getIndicatorTaPlusDM(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaPlusDM(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaPlusDM>>() {
        }.getType());
    }

    /**
     *  价格振荡百分比指标，英文名称为Percentage Price Oscillator。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      快速移动平均线周期
     * @param input3      慢速移动平均线周期
     * @param input4      移动平均线类型，取值范围：1|SMA-简单移动平均线；2|EMA-指数移动平均线；3|WMA-加权移动平均线；4|DEMA-双指数移动平均线；5|TEMA-三重指数移动平均线；6|TRIMA-三重移动平均线；7|KAMA-考夫曼自适应移动平均线；8|MAMA-自适应移动平均线；9|T3-三重移动平均线
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaPpo对象
     * @throws IOException
     */

    public String getIndicatorTaPpo(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaPpo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("input3", input3)
                .put("input4", input4)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaPpo> getIndicatorTaPpo(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaPpo(type , code , ktype , fq , startDate , endDate , input1 , input2 , input3 , input4 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaPpo>>() {
        }.getType());
    }

    /**
     *  ROC金融指标的中文名称是变动率，英文名称是Rate of Change，ROC指标是一种衡量价格变动速度的技。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaRoc对象
     * @throws IOException
     */

    public String getIndicatorTaRoc(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaRoc";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaRoc> getIndicatorTaRoc(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaRoc(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaRoc>>() {
        }.getType());
    }

    /**
     *  ROCP指标的中文名称为变化率指标，英文名称为Rate of Change Percentage。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaRocP对象
     * @throws IOException
     */

    public String getIndicatorTaRocP(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaRocP";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaRocP> getIndicatorTaRocP(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaRocP(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaRocP>>() {
        }.getType());
    }

    /**
     *  ROCR金融指标是指Rate of Change Ratio，其中文名称是变动率比率，英文名称是Rate of Change Ratio。该指标用于衡量价格的变动率，并通过计算价格的百分比变化来表示。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaRocR对象
     * @throws IOException
     */

    public String getIndicatorTaRocR(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaRocR";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaRocR> getIndicatorTaRocR(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaRocR(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaRocR>>() {
        }.getType());
    }

    /**
     *  ROCR100金融指标的中文名称为价格变动率，英文名称为Rate of Change Ratio 100，指标介绍为衡量价格在一定时间内的变动幅度，以百分比表示。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaRocR100对象
     * @throws IOException
     */

    public String getIndicatorTaRocR100(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaRocR100";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaRocR100> getIndicatorTaRocR100(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaRocR100(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaRocR100>>() {
        }.getType());
    }

    /**
     *  RSI指标是相对强弱指标，全称为Relative Strength Index。它是一种用于衡量市场超买超卖状态的技术指标，由J. Welles Wilder于1978年提出。RSI指标的计算基于一定时期内的价格变动幅度，通过将一定时期内的上涨幅度和下跌幅度进行比较，以确定市场的强弱程度。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaRsi对象
     * @throws IOException
     */

    public String getIndicatorTaRsi(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaRsi";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaRsi> getIndicatorTaRsi(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaRsi(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaRsi>>() {
        }.getType());
    }

    /**
     *  SAR称为抛物线指标，英文名称为Parabolic SAR (Stop and Reverse)。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      加速因子
     * @param input2      最大值
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaSar对象
     * @throws IOException
     */

    public String getIndicatorTaSar(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaSar";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaSar> getIndicatorTaSar(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaSar(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaSar>>() {
        }.getType());
    }

    /**
     *  SAREXT称为拓展停损点指标，英文名称为SAREXT (Extended Stop and Reverse Indicator)。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      起始值
     * @param input2      反转偏移量
     * @param input3      多头初始加速因子
     * @param input4      多头加速因子
     * @param input5      多头最大加速因子
     * @param input6      空头初始加速因子
     * @param input7      空头加速因子
     * @param input8      空头最大加速因子
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaSarExt对象
     * @throws IOException
     */

    public String getIndicatorTaSarExt(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String input5, String input6, String input7, String input8, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaSarExt";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("input3", input3)
                .put("input4", input4)
                .put("input5", input5)
                .put("input6", input6)
                .put("input7", input7)
                .put("input8", input8)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaSarExt> getIndicatorTaSarExt(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String input5, String input6, String input7, String input8, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaSarExt(type , code , ktype , fq , startDate , endDate , input1 , input2 , input3 , input4 , input5 , input6 , input7 , input8 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaSarExt>>() {
        }.getType());
    }

    /**
     *  正弦函数。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaSin对象
     * @throws IOException
     */

    public String getIndicatorTaSin(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaSin";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaSin> getIndicatorTaSin(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaSin(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaSin>>() {
        }.getType());
    }

    /**
     *  双曲正弦函数。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaSinh对象
     * @throws IOException
     */

    public String getIndicatorTaSinh(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaSinh";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaSinh> getIndicatorTaSinh(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaSinh(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaSinh>>() {
        }.getType());
    }

    /**
     *  SMA指标是简单移动平均线，全称为Simple Moving Average。它是一种常用的技术分析指标，用于平滑价格数据并显示价格趋势。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaSma对象
     * @throws IOException
     */

    public String getIndicatorTaSma(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaSma";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaSma> getIndicatorTaSma(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaSma(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaSma>>() {
        }.getType());
    }

    /**
     *  非负实数的平方根。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaSqrt对象
     * @throws IOException
     */

    public String getIndicatorTaSqrt(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaSqrt";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaSqrt> getIndicatorTaSqrt(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaSqrt(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaSqrt>>() {
        }.getType());
    }

    /**
     *  StdDev指标。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param input3      标准差倍数
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaStdDev对象
     * @throws IOException
     */

    public String getIndicatorTaStdDev(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaStdDev";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("input3", input3)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaStdDev> getIndicatorTaStdDev(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaStdDev(type , code , ktype , fq , startDate , endDate , input1 , input2 , input3 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaStdDev>>() {
        }.getType());
    }

    /**
     *  STOCH是随机指标（KDJ指标），英文名称是Stochastic Oscillator。该指标是一种用来测量价格相对于其价格范围的位置的技术指标。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      快速移动平均线K周期
     * @param input2      慢速移动平均线K周期
     * @param input3      慢速移动平均线K类型，取值范围：1|SMA-简单移动平均线；2|EMA-指数移动平均线；3|WMA-加权移动平均线；4|DEMA-双指数移动平均线；5|TEMA-三重指数移动平均线；6|TRIMA-三重移动平均线；7|KAMA-考夫曼自适应移动平均线；8|MAMA-自适应移动平均线；9|T3-三重移动平均线
     * @param input4      慢速移动平均线D周期
     * @param input5      慢速移动平均线D类型，取值范围：1|SMA-简单移动平均线；2|EMA-指数移动平均线；3|WMA-加权移动平均线；4|DEMA-双指数移动平均线；5|TEMA-三重指数移动平均线；6|TRIMA-三重移动平均线；7|KAMA-考夫曼自适应移动平均线；8|MAMA-自适应移动平均线；9|T3-三重移动平均线
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaStoch对象
     * @throws IOException
     */

    public String getIndicatorTaStoch(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String input5, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaStoch";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("input3", input3)
                .put("input4", input4)
                .put("input5", input5)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaStoch> getIndicatorTaStoch(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String input5, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaStoch(type , code , ktype , fq , startDate , endDate , input1 , input2 , input3 , input4 , input5 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaStoch>>() {
        }.getType());
    }

    /**
     *  STOCHF是随机振荡指标（Stochastic Fast）。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      快速移动平均线K周期
     * @param input2      慢速移动平均线D周期
     * @param input3      慢速移动平均线D类型，取值范围：1|SMA-简单移动平均线；2|EMA-指数移动平均线；3|WMA-加权移动平均线；4|DEMA-双指数移动平均线；5|TEMA-三重指数移动平均线；6|TRIMA-三重移动平均线；7|KAMA-考夫曼自适应移动平均线；8|MAMA-自适应移动平均线；9|T3-三重移动平均线
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaStochF对象
     * @throws IOException
     */

    public String getIndicatorTaStochF(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaStochF";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("input3", input3)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaStochF> getIndicatorTaStochF(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaStochF(type , code , ktype , fq , startDate , endDate , input1 , input2 , input3 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaStochF>>() {
        }.getType());
    }

    /**
     *  随机相对强弱指标，Stochastic Relative Strength Index (STOCHRSI)。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param input3      快速移动平均线K周期
     * @param input4      慢速移动平均线D周期
     * @param input5      慢速移动平均线D类型，取值范围：1|SMA-简单移动平均线；2|EMA-指数移动平均线；3|WMA-加权移动平均线；4|DEMA-双指数移动平均线；5|TEMA-三重指数移动平均线；6|TRIMA-三重移动平均线；7|KAMA-考夫曼自适应移动平均线；8|MAMA-自适应移动平均线；9|T3-三重移动平均线
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaStochRsi对象
     * @throws IOException
     */

    public String getIndicatorTaStochRsi(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String input5, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaStochRsi";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("input3", input3)
                .put("input4", input4)
                .put("input5", input5)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaStochRsi> getIndicatorTaStochRsi(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String input5, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaStochRsi(type , code , ktype , fq , startDate , endDate , input1 , input2 , input3 , input4 , input5 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaStochRsi>>() {
        }.getType());
    }

    /**
     *  向量除法运算。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaSub对象
     * @throws IOException
     */

    public String getIndicatorTaSub(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaSub";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaSub> getIndicatorTaSub(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaSub(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaSub>>() {
        }.getType());
    }

    /**
     *  周期内求和。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaSum对象
     * @throws IOException
     */

    public String getIndicatorTaSum(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaSum";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaSum> getIndicatorTaSum(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaSum(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaSum>>() {
        }.getType());
    }

    /**
     *  T3是三重移动平均线，全称是Triple Exponential Moving Average。它是指数移动平均线（EMA）的一种改进版本。T3指标通过使用三次平滑来减少EMA的滞后性，并提供更快的响应速度。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param input3      va系数
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaT3对象
     * @throws IOException
     */

    public String getIndicatorTaT3(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaT3";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("input3", input3)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaT3> getIndicatorTaT3(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaT3(type , code , ktype , fq , startDate , endDate , input1 , input2 , input3 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaT3>>() {
        }.getType());
    }

    /**
     *  正切函数。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaTan对象
     * @throws IOException
     */

    public String getIndicatorTaTan(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaTan";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaTan> getIndicatorTaTan(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaTan(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaTan>>() {
        }.getType());
    }

    /**
     *  双曲正切函数。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaTanh对象
     * @throws IOException
     */

    public String getIndicatorTaTanh(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaTanh";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaTanh> getIndicatorTaTanh(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaTanh(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaTanh>>() {
        }.getType());
    }

    /**
     *  TEMA是三重指数移动平均线，全程为Triple Exponential Moving Average。它是一种技术分析指标，用于平滑价格数据并识别趋势的变化。TEMA通过多次平滑价格数据来减少价格波动的影响，从而更准确地识别趋势的变化。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaTema对象
     * @throws IOException
     */

    public String getIndicatorTaTema(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaTema";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaTema> getIndicatorTaTema(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaTema(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaTema>>() {
        }.getType());
    }

    /**
     *  TRIMA是三重指数平均线，全称为Triangular Moving Average。它是一种平滑的移动平均线，通过将价格数据进行多次平均处理来消除噪音和波动。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaTrima对象
     * @throws IOException
     */

    public String getIndicatorTaTrima(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaTrima";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaTrima> getIndicatorTaTrima(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaTrima(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaTrima>>() {
        }.getType());
    }

    /**
     *  TRIX金融指标的中文名称是三重指数平滑平均线，英文名称是Triple Exponential Moving Average (TRIX)。TRIX是一种技术分析指标，用于衡量资产价格的趋势强度。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaTrix对象
     * @throws IOException
     */

    public String getIndicatorTaTrix(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaTrix";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaTrix> getIndicatorTaTrix(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaTrix(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaTrix>>() {
        }.getType());
    }

    /**
     *  称为真实波幅，英文名称为True Range。它是一种衡量价格波动性的指标。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaTrueRange对象
     * @throws IOException
     */

    public String getIndicatorTaTrueRange(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaTrueRange";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaTrueRange> getIndicatorTaTrueRange(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaTrueRange(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaTrueRange>>() {
        }.getType());
    }

    /**
     *  Tsf指标。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaTsf对象
     * @throws IOException
     */

    public String getIndicatorTaTsf(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaTsf";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaTsf> getIndicatorTaTsf(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaTsf(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaTsf>>() {
        }.getType());
    }

    /**
     *  TYPPRICE是一种计算股票或其他金融资产的典型价格的方法。指标计算公式：Typical Price = (High + Low + Close) / 3。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaTypPrice对象
     * @throws IOException
     */

    public String getIndicatorTaTypPrice(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaTypPrice";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaTypPrice> getIndicatorTaTypPrice(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaTypPrice(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaTypPrice>>() {
        }.getType());
    }

    /**
     *  ULTOSC称为综合摆动指标，英文名称：Ultimate Oscillator (ULTOSC)。综合摆动指标是一种多周期的技术指标，用于衡量市场买卖力量的强弱。它通过将短期、中期和长期的价格波动进行加权平均，以提供更全面的市场信号。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      移动平均线周期1
     * @param input2      移动平均线周期2
     * @param input3      移动平均线周期3
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaUltOsc对象
     * @throws IOException
     */

    public String getIndicatorTaUltOsc(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaUltOsc";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("input3", input3)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaUltOsc> getIndicatorTaUltOsc(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaUltOsc(type , code , ktype , fq , startDate , endDate , input1 , input2 , input3 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaUltOsc>>() {
        }.getType());
    }

    /**
     *  方差。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param input3      标准差倍数
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaVariance对象
     * @throws IOException
     */

    public String getIndicatorTaVariance(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaVariance";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("input3", input3)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaVariance> getIndicatorTaVariance(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaVariance(type , code , ktype , fq , startDate , endDate , input1 , input2 , input3 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaVariance>>() {
        }.getType());
    }

    /**
     *  WCLPRICE指标称为加权收盘价，英文名称为Weighted Close Price。指标计算公式：WCLPRICE = (最高价 + 最低价 + 2 * 收盘价) / 4 。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaWclPrice对象
     * @throws IOException
     */

    public String getIndicatorTaWclPrice(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaWclPrice";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaWclPrice> getIndicatorTaWclPrice(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaWclPrice(type , code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaWclPrice>>() {
        }.getType());
    }

    /**
     *  WILLR指标的中文名称为威廉指标(WR)，英文名称为Williams' %R(W%R)。该指标通过测量价格在给定时间周期内的相对变动程度，来判断市场的超买和超卖情况。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input       移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaWillR对象
     * @throws IOException
     */

    public String getIndicatorTaWillR(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaWillR";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input", input)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaWillR> getIndicatorTaWillR(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaWillR(type , code , ktype , fq , startDate , endDate , input , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaWillR>>() {
        }.getType());
    }

    /**
     *  WMA指标是一种移动平均线指标，全称为Weighted Moving Average。它是一种加权平均线指标，与简单移动平均线（SMA）不同，WMA在计算平均值时给予较近期的数据更高的权重。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1      数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2      移动平均线周期
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaWma对象
     * @throws IOException
     */

    public String getIndicatorTaWma(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndicatorTaWma";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("input1", input1)
                .put("input2", input2)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<IndicatorTaWma> getIndicatorTaWma(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndicatorTaWma(type , code , ktype , fq , startDate , endDate , input1 , input2 , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<IndicatorTaWma>>() {
        }.getType());
    }

    /**
     *  沪深京A股基本信息。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getStockHSABaseInfo(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockHSABaseInfo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockBaseInfo> getStockHSABaseInfo(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockHSABaseInfo(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     *  如果想立即获取当天的收盘数据，收盘后可通过本接口采集当天日K线数据。沪深京A股每日行情数据。温馨提示：code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockDailyMarketCopy对象
     * @throws IOException
     */

    public String getStockHSADailyMarket(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockHSADailyMarket";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockDailyMarketCopy> getStockHSADailyMarket(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockHSADailyMarket(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockDailyMarketCopy>>() {
        }.getType());
    }

    /**
     *  沪深京A股分线数据，数据以分钟为粒度。数据均为不复权数据。温馨提示：code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param startDate   开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate     结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockMinuteKLine对象
     * @throws IOException
     */

    public String getStockHSAMinuteKLine(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockHSAMinuteKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockMinuteKLine> getStockHSAMinuteKLine(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockHSAMinuteKLine(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockMinuteKLine>>() {
        }.getType());
    }

    /**
     *  沪深京A股时线数据，数据均为不复权数据。温馨提示：code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：5|5分钟；15|15分钟；30|30分钟；60|60分钟
     * @param startDate   开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate     结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockHourKLine对象
     * @throws IOException
     */

    public String getStockHSAHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockHSAHourKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("ktype", ktype)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockHourKLine> getStockHSAHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockHSAHourKLine(code , ktype , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockHourKLine>>() {
        }.getType());
    }

    /**
     *  如果想收盘后立即获取当日的收盘数据，可通过【实时行情】或者【每日行情】接口获取收盘后的日K线数据。沪深京A股日线、周线、月线数据。温馨提示：code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype       K线类别，取值范围：101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockKLine对象
     * @throws IOException
     */

    public String getStockHSADayKLine(String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockHSADayKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockKLine> getStockHSADayKLine(String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockHSADayKLine(code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockKLine>>() {
        }.getType());
    }

    /**
     *  沪深京B股基本信息。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getStockHSBBaseInfo(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockHSBBaseInfo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockBaseInfo> getStockHSBBaseInfo(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockHSBBaseInfo(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     *  如果想立即获取当天的收盘数据，收盘后可通过本接口采集当天日K线数据。沪深京B股每日行情数据。温馨提示：code参数可以从【沪深京->B股->B股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【沪深京->B股->B股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockDailyMarketCopy对象
     * @throws IOException
     */

    public String getStockHSBDailyMarket(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockHSBDailyMarket";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockDailyMarketCopy> getStockHSBDailyMarket(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockHSBDailyMarket(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockDailyMarketCopy>>() {
        }.getType());
    }

    /**
     *  沪深京B股分线数据，数据以分钟为粒度。温馨提示：code参数可以从【沪深京->B股->B股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【沪深京->B股->B股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param startDate   开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate     结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockMinuteKLine对象
     * @throws IOException
     */

    public String getStockHSBMinuteKLine(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockHSBMinuteKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockMinuteKLine> getStockHSBMinuteKLine(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockHSBMinuteKLine(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockMinuteKLine>>() {
        }.getType());
    }

    /**
     *  沪深京B股分时数据。提供5分钟、15分钟、30分钟、60分钟数据。温馨提示：code参数可以从【沪深京->B股->B股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【沪深京->B股->B股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：5|5分钟；15|15分钟；30|30分钟；60|60分钟
     * @param startDate   开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate     结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockHourKLine对象
     * @throws IOException
     */

    public String getStockHSBHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockHSBHourKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("ktype", ktype)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockHourKLine> getStockHSBHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockHSBHourKLine(code , ktype , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockHourKLine>>() {
        }.getType());
    }

    /**
     *  如果想收盘后立即获取当日的收盘数据，可通过【实时行情】或者【每日行情】接口获取收盘后的日K线数据。沪深京B股日线、周线、月线数据。温馨提示：code参数可以从【沪深京->B股->B股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【沪深京->B股->B股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype       K线类别，取值范围：101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockKLine对象
     * @throws IOException
     */

    public String getStockHSBDayKLine(String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockHSBDayKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockKLine> getStockHSBDayKLine(String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockHSBDayKLine(code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockKLine>>() {
        }.getType());
    }

    /**
     *  沪深两市每日行情统计。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考MarketView对象
     * @throws IOException
     */

    public String getMarketView(String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getMarketView";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<MarketView> getMarketView(String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getMarketView(startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<MarketView>>() {
        }.getType());
    }

    /**
     *  沪深A股公司概况信息。温馨提示：code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考F10CompanyBaseInfo对象
     * @throws IOException
     */

    public String getF10CompanyBaseInfo(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getF10CompanyBaseInfo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<F10CompanyBaseInfo> getF10CompanyBaseInfo(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getF10CompanyBaseInfo(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<F10CompanyBaseInfo>>() {
        }.getType());
    }

    /**
     *  主力数据。温馨提示：code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockZhuLi对象
     * @throws IOException
     */

    public String getStockZhuLi(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockZhuLi";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockZhuLi> getStockZhuLi(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockZhuLi(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockZhuLi>>() {
        }.getType());
    }

    /**
     *  AH股比价。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockAHComparePrice对象
     * @throws IOException
     */

    public String getStockAHComparePrice(String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockAHComparePrice";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockAHComparePrice> getStockAHComparePrice(String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockAHComparePrice(fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockAHComparePrice>>() {
        }.getType());
    }

    /**
     *  沪深A股股票曾用名。温馨提示：code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockReName对象
     * @throws IOException
     */

    public String getStockReName(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockReName";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockReName> getStockReName(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockReName(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockReName>>() {
        }.getType());
    }

    /**
     *  沪深A股公司题材信息。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考CompanyInfo对象
     * @throws IOException
     */

    public String getCompanyInfo(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getCompanyInfo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<CompanyInfo> getCompanyInfo(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getCompanyInfo(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<CompanyInfo>>() {
        }.getType());
    }

    /**
     *  股票账户统计详细数据。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockAccount对象
     * @throws IOException
     */

    public String getStockAccount(String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockAccount";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockAccount> getStockAccount(String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockAccount(fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockAccount>>() {
        }.getType());
    }

    /**
     *  沪深股票市场交易日历。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考HSTradeDate对象
     * @throws IOException
     */

    public String getStockTradeDate(String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockTradeDate";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<HSTradeDate> getStockTradeDate(String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockTradeDate(startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<HSTradeDate>>() {
        }.getType());
    }

    /**
     *  沪深A股除权除息数据。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ChuQuanChuXi对象
     * @throws IOException
     */

    public String getChuQuanChuXi(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getChuQuanChuXi";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<ChuQuanChuXi> getChuQuanChuXi(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getChuQuanChuXi(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<ChuQuanChuXi>>() {
        }.getType());
    }

    /**
     *  沪深A股复权因子。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param fq          复权类别，取值范围：1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考FuQuanYinZi对象
     * @throws IOException
     */

    public String getFuQuanYinZi(String code, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getFuQuanYinZi";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<FuQuanYinZi> getFuQuanYinZi(String code, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getFuQuanYinZi(code , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<FuQuanYinZi>>() {
        }.getType());
    }

    /**
     *  机构调研统计。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考JiGouDiaoYanTongJi对象
     * @throws IOException
     */

    public String getJiGouDiaoYanTongJi(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getJiGouDiaoYanTongJi";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<JiGouDiaoYanTongJi> getJiGouDiaoYanTongJi(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getJiGouDiaoYanTongJi(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<JiGouDiaoYanTongJi>>() {
        }.getType());
    }

    /**
     *  机构调研详细。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考JiGouDiaoYanXiangXi对象
     * @throws IOException
     */

    public String getJiGouDiaoYanXiangXi(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getJiGouDiaoYanXiangXi";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<JiGouDiaoYanXiangXi> getJiGouDiaoYanXiangXi(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getJiGouDiaoYanXiangXi(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<JiGouDiaoYanXiangXi>>() {
        }.getType());
    }

    /**
     *  机构调研记录，记录机构调查详细内容，评估公司经营情况。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考JiGouDiaoYanJiLv对象
     * @throws IOException
     */

    public String getJiGouDiaoYanJiLv(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getJiGouDiaoYanJiLv";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<JiGouDiaoYanJiLv> getJiGouDiaoYanJiLv(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getJiGouDiaoYanJiLv(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<JiGouDiaoYanJiLv>>() {
        }.getType());
    }

    /**
     *  沪深京A股龙虎榜详情数据。温馨提示：code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考LonghbDetail对象
     * @throws IOException
     */

    public String getLonghbDetail(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getLonghbDetail";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<LonghbDetail> getLonghbDetail(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getLonghbDetail(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<LonghbDetail>>() {
        }.getType());
    }

    /**
     *  沪深京A股龙虎榜每日活跃营业部。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考LonghbActive对象
     * @throws IOException
     */

    public String getLonghbActive(String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getLonghbActive";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<LonghbActive> getLonghbActive(String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getLonghbActive(startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<LonghbActive>>() {
        }.getType());
    }

    /**
     *  沪深京A股龙虎榜机构每日买卖统计。温馨提示：code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考LonghbJigou对象
     * @throws IOException
     */

    public String getLonghbJigou(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getLonghbJigou";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<LonghbJigou> getLonghbJigou(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getLonghbJigou(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<LonghbJigou>>() {
        }.getType());
    }

    /**
     *  沪市、深市融资融券交易信息。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param mtype       市场类型，取值范围：1|沪深两市；2|沪市；3|深市；3|京市
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考RzRjMarket对象
     * @throws IOException
     */

    public String getRzRjMarket(int mtype, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getRzRjMarket";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("mtype", mtype)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<RzRjMarket> getRzRjMarket(int mtype, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getRzRjMarket(mtype , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<RzRjMarket>>() {
        }.getType());
    }

    /**
     *  沪深A股板块融资融券。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        板块代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考RzRjHangye对象
     * @throws IOException
     */

    public String getRzRjHangye(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getRzRjHangye";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<RzRjHangye> getRzRjHangye(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getRzRjHangye(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<RzRjHangye>>() {
        }.getType());
    }

    /**
     *  沪深京A股融资融券交易信息。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考RzRjStock对象
     * @throws IOException
     */

    public String getStockRzRj(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockRzRj";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<RzRjStock> getStockRzRj(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockRzRj(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<RzRjStock>>() {
        }.getType());
    }

    /**
     *  沪深京A股融资融券账户信息。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考RzRjAccount对象
     * @throws IOException
     */

    public String getRzRjAccount(String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getRzRjAccount";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<RzRjAccount> getRzRjAccount(String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getRzRjAccount(startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<RzRjAccount>>() {
        }.getType());
    }

    /**
     *  备用沪深京A股股票日线、周线、月线数据。温馨提示：code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype       K线类别，取值范围：101|日线；102|周线；103|月线
     * @param fq          复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考XQStockKLine对象
     * @throws IOException
     */

    public String getStockXQHSADayKLine(String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockXQHSADayKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("ktype", ktype)
                .put("fq", fq)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<XQStockKLine> getStockXQHSADayKLine(String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockXQHSADayKLine(code , ktype , fq , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<XQStockKLine>>() {
        }.getType());
    }

    /**
     *  个股研报。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考YanBaoStock对象
     * @throws IOException
     */

    public String getYanBaoStock(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getYanBaoStock";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<YanBaoStock> getYanBaoStock(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getYanBaoStock(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<YanBaoStock>>() {
        }.getType());
    }

    /**
     *  新股研报。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考YanBaoXinGu对象
     * @throws IOException
     */

    public String getYanBaoXinGu(String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getYanBaoXinGu";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<YanBaoXinGu> getYanBaoXinGu(String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getYanBaoXinGu(startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<YanBaoXinGu>>() {
        }.getType());
    }

    /**
     *  行业研报。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考YanBaoHangYe对象
     * @throws IOException
     */

    public String getYanBaoHangYe(String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getYanBaoHangYe";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<YanBaoHangYe> getYanBaoHangYe(String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getYanBaoHangYe(startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<YanBaoHangYe>>() {
        }.getType());
    }

    /**
     *  策略报告。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考YanBaoCeLue对象
     * @throws IOException
     */

    public String getYanbaoCelue(String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getYanbaoCelue";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<YanBaoCeLue> getYanbaoCelue(String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getYanbaoCelue(startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<YanBaoCeLue>>() {
        }.getType());
    }

    /**
     *  券商晨报。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考YanBaoChenBao对象
     * @throws IOException
     */

    public String getYanBaoChenBao(String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getYanBaoChenBao";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<YanBaoChenBao> getYanBaoChenBao(String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getYanBaoChenBao(startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<YanBaoChenBao>>() {
        }.getType());
    }

    /**
     *  宏观研究。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考YanBaoHongGuan对象
     * @throws IOException
     */

    public String getYanBaoHongGuan(String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getYanBaoHongGuan";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<YanBaoHongGuan> getYanBaoHongGuan(String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getYanBaoHongGuan(startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<YanBaoHongGuan>>() {
        }.getType());
    }

    /**
     *  盈利预测。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考YanBaoYingLi对象
     * @throws IOException
     */

    public String getYanBaoYingLi(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getYanBaoYingLi";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<YanBaoYingLi> getYanBaoYingLi(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getYanBaoYingLi(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<YanBaoYingLi>>() {
        }.getType());
    }

    /**
     *  沪深京上市公司业绩报表。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ReportNianBao对象
     * @throws IOException
     */

    public String getReportNianBao(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getReportNianBao";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<ReportNianBao> getReportNianBao(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getReportNianBao(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<ReportNianBao>>() {
        }.getType());
    }

    /**
     *  沪深京上市公司业绩快报。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ReportKuaiBao对象
     * @throws IOException
     */

    public String getReportKuaiBao(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getReportKuaiBao";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<ReportKuaiBao> getReportKuaiBao(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getReportKuaiBao(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<ReportKuaiBao>>() {
        }.getType());
    }

    /**
     *  沪深京上市公司业绩预告。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ReportYugao对象
     * @throws IOException
     */

    public String getReportYugao(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getReportYugao";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<ReportYugao> getReportYugao(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getReportYugao(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<ReportYugao>>() {
        }.getType());
    }

    /**
     *  沪深京上市公司预约披露时间。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ReportYuyueTime对象
     * @throws IOException
     */

    public String getReportYuyueTime(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getReportYuyueTime";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<ReportYuyueTime> getReportYuyueTime(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getReportYuyueTime(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<ReportYuyueTime>>() {
        }.getType());
    }

    /**
     *  沪深京上市公司资产负债表。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ReportFuzhai对象
     * @throws IOException
     */

    public String getReportFuzhai(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getReportFuzhai";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<ReportFuzhai> getReportFuzhai(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getReportFuzhai(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<ReportFuzhai>>() {
        }.getType());
    }

    /**
     *  沪深京上市公司利润表。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ReportLirun对象
     * @throws IOException
     */

    public String getReportLirun(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getReportLirun";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<ReportLirun> getReportLirun(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getReportLirun(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<ReportLirun>>() {
        }.getType());
    }

    /**
     *  沪深京上市公司现金流量表。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ReportXianjin对象
     * @throws IOException
     */

    public String getReportXianjin(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getReportXianjin";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<ReportXianjin> getReportXianjin(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getReportXianjin(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<ReportXianjin>>() {
        }.getType());
    }

    /**
     *  沪深京上市公司分红送配。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ReportFenhong对象
     * @throws IOException
     */

    public String getReportFenhong(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getReportFenhong";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<ReportFenhong> getReportFenhong(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getReportFenhong(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<ReportFenhong>>() {
        }.getType());
    }

    /**
     *  南向资金、北向资金流向数据，包括净流入、资金余额、累计净流入。香港投资者交易内地股票，称为北向资金，内地投资者交易香港股票，称为南向资金。当日资金流入额=当日限额-当日余额。当日资金流入额包含两部分：当日成交净买额，当日申报但未成交的买单金额。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param mtype       沪深港通资金类型，取值范围：1|沪股通(港>沪)资金-北向；2|深股通(港>深)资金-北向；3|北向资金；4|港股通(沪>港)资金-南向；5|港股通(深>港)资金-南向；6|南向资金
     * @param ktype       K线类别，取值范围：101|日线；102|周线；103|月线；104|季线；106|年线
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考HSGTMoney对象
     * @throws IOException
     */

    public String getHSGTMoney(int mtype, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getHSGTMoney";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("mtype", mtype)
                .put("ktype", ktype)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<HSGTMoney> getHSGTMoney(int mtype, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getHSGTMoney(mtype , ktype , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<HSGTMoney>>() {
        }.getType());
    }

    /**
     *  北向板块排行数据。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        板块代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考HSGTBlockRank对象
     * @throws IOException
     */

    public String getHSGTBlockRank(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getHSGTBlockRank";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<HSGTBlockRank> getHSGTBlockRank(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getHSGTBlockRank(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<HSGTBlockRank>>() {
        }.getType());
    }

    /**
     *  北向个股排行数据。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考HSGTStockRank对象
     * @throws IOException
     */

    public String getHSGTStockRank(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getHSGTStockRank";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<HSGTStockRank> getHSGTStockRank(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getHSGTStockRank(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<HSGTStockRank>>() {
        }.getType());
    }

    /**
     *  沪深港通历史数据。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param mtype       市场类别，取值范围：1|沪股通(港>沪)；2|深股通(港>深)；3|港股通(沪>港)；4|港股通(深>港)
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考HSGTHistory对象
     * @throws IOException
     */

    public String getHSGTHistory(int mtype, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getHSGTHistory";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("mtype", mtype)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<HSGTHistory> getHSGTHistory(int mtype, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getHSGTHistory(mtype , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<HSGTHistory>>() {
        }.getType());
    }

    /**
     *  沪深港通十大成交股。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param mtype       市场类别，取值范围：1|沪股通(港>沪)；2|港股通(沪>港)；3|深股通(港>深)；4|港股通(深>港)
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考HsgtStockTop10对象
     * @throws IOException
     */

    public String getHsgtStockTop10(String code, int mtype, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getHsgtStockTop10";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("mtype", mtype)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<HsgtStockTop10> getHsgtStockTop10(String code, int mtype, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getHsgtStockTop10(code , mtype , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<HsgtStockTop10>>() {
        }.getType());
    }

    /**
     *  沪深股市财务数据主要指标，按报告期、年度数据。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param mtype       报告类型，取值范围：0|按报告期；1|按年度
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考CaiWuZYZBReportHSA对象
     * @throws IOException
     */

    public String getCaiWuZYZBReportHSA(String code, int mtype, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getCaiWuZYZBReportHSA";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("mtype", mtype)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<CaiWuZYZBReportHSA> getCaiWuZYZBReportHSA(String code, int mtype, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getCaiWuZYZBReportHSA(code , mtype , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<CaiWuZYZBReportHSA>>() {
        }.getType());
    }

    /**
     *  沪深股市财务数据主要指标，按季度数据。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考CaiWuZYZBQuarterHSA对象
     * @throws IOException
     */

    public String getCaiWuZYZBQuarterHSA(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getCaiWuZYZBQuarterHSA";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<CaiWuZYZBQuarterHSA> getCaiWuZYZBQuarterHSA(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getCaiWuZYZBQuarterHSA(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<CaiWuZYZBQuarterHSA>>() {
        }.getType());
    }

    /**
     *  沪深股市财务数据企业负债表，同比字段单位为百分比（%）。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param mtype       报告类型，取值范围：0|按报告期；1|按年度
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考FinanceHSDebt对象
     * @throws IOException
     */

    public String getFinanceHSDebt(String code, int mtype, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getFinanceHSDebt";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("mtype", mtype)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<FinanceHSDebt> getFinanceHSDebt(String code, int mtype, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getFinanceHSDebt(code , mtype , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<FinanceHSDebt>>() {
        }.getType());
    }

    /**
     *  股东户数。温馨提示：code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考SharePeoples对象
     * @throws IOException
     */

    public String getSharePeoples(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getSharePeoples";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<SharePeoples> getSharePeoples(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getSharePeoples(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<SharePeoples>>() {
        }.getType());
    }

    /**
     *  十大股东。温馨提示：code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ShareTopHolder对象
     * @throws IOException
     */

    public String getShareTopHolder(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getShareTopHolder";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<ShareTopHolder> getShareTopHolder(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getShareTopHolder(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<ShareTopHolder>>() {
        }.getType());
    }

    /**
     *  股东解禁。温馨提示：code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ShareJieJin对象
     * @throws IOException
     */

    public String getShareJieJin(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getShareJieJin";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<ShareJieJin> getShareJieJin(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getShareJieJin(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<ShareJieJin>>() {
        }.getType());
    }

    /**
     *  股东增减持。温馨提示：code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ShareZengJianChi对象
     * @throws IOException
     */

    public String getShareZengJianChi(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getShareZengJianChi";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<ShareZengJianChi> getShareZengJianChi(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getShareZengJianChi(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<ShareZengJianChi>>() {
        }.getType());
    }

    /**
     *  高管增减持。温馨提示：code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ShareGaoGuanZengJianChi对象
     * @throws IOException
     */

    public String getShareGaoGuanZengJianChi(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getShareGaoGuanZengJianChi";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<ShareGaoGuanZengJianChi> getShareGaoGuanZengJianChi(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getShareGaoGuanZengJianChi(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<ShareGaoGuanZengJianChi>>() {
        }.getType());
    }

    /**
     *  场内基金（ETF、LOF）基本信息。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getCnFundBaseInfo(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getCnFundBaseInfo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockBaseInfo> getCnFundBaseInfo(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getCnFundBaseInfo(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     *  如果想立即获取当天的收盘数据，收盘后可通过本接口采集当天日K线数据。场内基金（ETF、LOF）每日行情数据。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockDailyMarketCopy对象
     * @throws IOException
     */

    public String getCnFundDailyMarket(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getCnFundDailyMarket";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockDailyMarketCopy> getCnFundDailyMarket(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getCnFundDailyMarket(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockDailyMarketCopy>>() {
        }.getType());
    }

    /**
     *  场内基金（ETF、LOF）分线数据，数据以分钟为粒度。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param startDate   开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate     结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockMinuteKLine对象
     * @throws IOException
     */

    public String getCnFundMinuteKLine(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getCnFundMinuteKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockMinuteKLine> getCnFundMinuteKLine(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getCnFundMinuteKLine(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockMinuteKLine>>() {
        }.getType());
    }

    /**
     *  场内基金（ETF、LOF）分时数据，提供5分钟、15分钟、30分钟、60分钟数据。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：5|5分钟；15|15分钟；30|30分钟；60|60分钟
     * @param startDate   开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate     结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockHourKLine对象
     * @throws IOException
     */

    public String getCnFundHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getCnFundHourKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("ktype", ktype)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockHourKLine> getCnFundHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getCnFundHourKLine(code , ktype , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockHourKLine>>() {
        }.getType());
    }

    /**
     *  如果想收盘后立即获取当日的收盘数据，可通过【实时行情】或者【每日行情】接口获取收盘后的日K线数据。场内基金日线、周线、月线数据。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype       K线类别，取值范围：101|日线；102|周线；103|月线
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockKLine对象
     * @throws IOException
     */

    public String getCnFundADayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getCnFundADayKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("ktype", ktype)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockKLine> getCnFundADayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getCnFundADayKLine(code , ktype , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockKLine>>() {
        }.getType());
    }

    /**
     *  所有基金基本信息。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        基金代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考FundBaseInfo对象
     * @throws IOException
     */

    public String getFundBaseInfo(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getFundBaseInfo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<FundBaseInfo> getFundBaseInfo(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getFundBaseInfo(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<FundBaseInfo>>() {
        }.getType());
    }

    /**
     *  如果想立即获取当天的收盘数据，收盘后可通过本接口采集当天日K线数据。基金每日行情数据。温馨提示：code参数可以从【基金->基金列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        基金代码，code参数可以从【基金->基金列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考FundRank对象
     * @throws IOException
     */

    public String getFundRank(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getFundRank";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<FundRank> getFundRank(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getFundRank(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<FundRank>>() {
        }.getType());
    }

    /**
     *  基金净值数据。温馨提示：code参数可以从【基金->基金列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        基金代码，code参数可以从【基金->基金列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考FundNav对象
     * @throws IOException
     */

    public String getFundNav(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getFundNav";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<FundNav> getFundNav(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getFundNav(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<FundNav>>() {
        }.getType());
    }

    /**
     *  获取基金历史最大回撤率。最大回撤率是指在选定周期内任一历史时点往后推，产品净值走到最低点时的收益率回撤幅度的最大值。最大回撤用来描述买入产品后可能出现的最糟糕的情况。历史最大回撤率=（最高点累计净值-最低点累计净值）/最高点累计净值。温馨提示：code参数可以从【基金->基金列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        基金代码，code参数可以从【基金->基金列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考FundMaxBack对象
     * @throws IOException
     */

    public String getFundMaxBack(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getFundMaxBack";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<FundMaxBack> getFundMaxBack(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getFundMaxBack(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<FundMaxBack>>() {
        }.getType());
    }

    /**
     *  基金持仓数据。温馨提示：code参数可以从【基金->基金列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        基金代码，code参数可以从【基金->基金列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考FundPosition对象
     * @throws IOException
     */

    public String getFundPosition(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getFundPosition";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<FundPosition> getFundPosition(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getFundPosition(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<FundPosition>>() {
        }.getType());
    }

    /**
     *  提供个股每个季度被各大基金机构持有数据。可通过股票代码，查询出该股票被基金公司持有的数据。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param scode       股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考FundPosition对象
     * @throws IOException
     */

    public String getStockPosition(String scode, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockPosition";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("scode", scode)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<FundPosition> getStockPosition(String scode, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockPosition(scode , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<FundPosition>>() {
        }.getType());
    }

    /**
     *  沪深京A股行业板块基本信息，备注：可根据返回的成分股,在其它接口里作为入参（code字段）查询详细数据。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getStockHyBKBaseInfo(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockHyBKBaseInfo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockBaseInfo> getStockHyBKBaseInfo(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockHyBKBaseInfo(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     *  沪深京A股概念板块基本信息，备注：可根据返回的成分股,在其它接口里作为入参（code字段）查询详细数据。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getStockGnBKBaseInfo(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockGnBKBaseInfo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockBaseInfo> getStockGnBKBaseInfo(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockGnBKBaseInfo(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     *  沪深京A股地域板块基本信息，备注：可根据返回的成分股,在其它接口里作为入参（code字段）查询详细数据。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getStockDyBKBaseInfo(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockDyBKBaseInfo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockBaseInfo> getStockDyBKBaseInfo(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockDyBKBaseInfo(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     *  如果想立即获取当天的收盘数据，收盘后可通过本接口采集当天日K线数据。如果想立即获取当天的收盘数据，收盘后可通过本接口采集当天日K线数据。沪深京A股行业板块每日行情数据。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        板块代码（行业板块、地域板块、概念板块），code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockDailyMarketCopy对象
     * @throws IOException
     */

    public String getStockHYADailyMarket(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockHYADailyMarket";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockDailyMarketCopy> getStockHYADailyMarket(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockHYADailyMarket(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockDailyMarketCopy>>() {
        }.getType());
    }

    /**
     *  如果想收盘后立即获取当日的收盘数据，可通过【实时行情】或者【每日行情】接口获取收盘后的日K线数据。沪深京A股板块日线、周线、月线数据。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        板块代码（行业板块、地域板块、概念板块），code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype       K线类别，取值范围：101|日线；102|周线；103|月线
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockKLine对象
     * @throws IOException
     */

    public String getStockBKDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockBKDayKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("ktype", ktype)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockKLine> getStockBKDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockBKDayKLine(code , ktype , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockKLine>>() {
        }.getType());
    }

    /**
     *  市场估值概况。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        市场代码，取值范围：000300|沪深两市；000001|沪市主板；000688|科创板；399001|深市主板；399006|创业板
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考GZMarket对象
     * @throws IOException
     */

    public String getGZMarket(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getGZMarket";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<GZMarket> getGZMarket(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getGZMarket(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<GZMarket>>() {
        }.getType());
    }

    /**
     *  行业估值概况。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        板块代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考GZHangYe对象
     * @throws IOException
     */

    public String getGZHangYe(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getGZHangYe";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<GZHangYe> getGZHangYe(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getGZHangYe(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<GZHangYe>>() {
        }.getType());
    }

    /**
     *  个股估值概况。温馨提示：code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考GZStock对象
     * @throws IOException
     */

    public String getHSGZStock(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getHSGZStock";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<GZStock> getHSGZStock(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getHSGZStock(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<GZStock>>() {
        }.getType());
    }

    /**
     *  行业数据包括行业板块、概念板块、地域板块、证监会行业板块。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：40|行业板块；41|概念板块；42|地域板块；43|证监会行业板块
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfoPlatB对象
     * @throws IOException
     */

    public String getBaseInfoPlatB(int type, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getBaseInfoPlatB";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockBaseInfoPlatB> getBaseInfoPlatB(int type, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getBaseInfoPlatB(type , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfoPlatB>>() {
        }.getType());
    }

    /**
     *  查询行业板块、概念板块、地域板块、证监会行业板块下的成分股。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param bkcode      板块代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfoPlatB对象
     * @throws IOException
     */

    public String getHangyeCfgPlatB(String bkcode, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getHangyeCfgPlatB";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("bkcode", bkcode)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockBaseInfoPlatB> getHangyeCfgPlatB(String bkcode, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getHangyeCfgPlatB(bkcode , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfoPlatB>>() {
        }.getType());
    }

    /**
     *  港股股票基本信息。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getStockHKBaseInfo(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockHKBaseInfo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockBaseInfo> getStockHKBaseInfo(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockHKBaseInfo(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     *  如果想立即获取当天的收盘数据，收盘后可通过本接口采集当天日K线数据。港股行情数据。温馨提示：code参数可以从【港股->港股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【港股->港股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockDailyMarketCopy对象
     * @throws IOException
     */

    public String getStockHKDailyMarket(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockHKDailyMarket";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockDailyMarketCopy> getStockHKDailyMarket(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockHKDailyMarket(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockDailyMarketCopy>>() {
        }.getType());
    }

    /**
     *  港股分线数据，数据以分钟为粒度。温馨提示：code参数可以从【港股->港股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【港股->港股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param startDate   开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate     结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockMinuteKLine对象
     * @throws IOException
     */

    public String getStockHKMinuteKLine(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockHKMinuteKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockMinuteKLine> getStockHKMinuteKLine(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockHKMinuteKLine(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockMinuteKLine>>() {
        }.getType());
    }

    /**
     *  港股分时数据，提供5分钟、15分钟、30分钟、60分钟数据。温馨提示：code参数可以从【港股->港股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【港股->港股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：5|5分钟；15|15分钟；30|30分钟；60|60分钟
     * @param startDate   开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate     结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockHourKLine对象
     * @throws IOException
     */

    public String getStockHKHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockHKHourKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("ktype", ktype)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockHourKLine> getStockHKHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockHKHourKLine(code , ktype , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockHourKLine>>() {
        }.getType());
    }

    /**
     *  如果想收盘后立即获取当日的收盘数据，可通过【实时行情】或者【每日行情】接口获取收盘后的日K线数据。港股日线、周线、月线数据。温馨提示：code参数可以从【港股->港股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【港股->港股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype       K线类别，取值范围：101|日线；102|周线；103|月线
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockKLine对象
     * @throws IOException
     */

    public String getStockHKDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockHKDayKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("ktype", ktype)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockKLine> getStockHKDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockHKDayKLine(code , ktype , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockKLine>>() {
        }.getType());
    }

    /**
     *  美股股票基本信息。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getStockUSABaseInfo(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockUSABaseInfo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockBaseInfo> getStockUSABaseInfo(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockUSABaseInfo(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     *  如果想立即获取当天的收盘数据，收盘后可通过本接口采集当天日K线数据。美股行情数据。温馨提示：code参数可以从【美股->美股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【美股->美股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockDailyMarketCopy对象
     * @throws IOException
     */

    public String getStockUSADailyMarket(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockUSADailyMarket";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockDailyMarketCopy> getStockUSADailyMarket(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockUSADailyMarket(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockDailyMarketCopy>>() {
        }.getType());
    }

    /**
     *  美股分线数据，数据以分钟为粒度。温馨提示：code参数可以从【美股->美股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【美股->美股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param startDate   开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate     结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockMinuteKLine对象
     * @throws IOException
     */

    public String getStockUSAMinuteKLine(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockUSAMinuteKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockMinuteKLine> getStockUSAMinuteKLine(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockUSAMinuteKLine(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockMinuteKLine>>() {
        }.getType());
    }

    /**
     *  美股分时数据，提供5分钟、15分钟、30分钟、60分钟数据。温馨提示：code参数可以从【美股->美股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【美股->美股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：5|5分钟；15|15分钟；30|30分钟；60|60分钟
     * @param startDate   开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate     结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockHourKLine对象
     * @throws IOException
     */

    public String getStockUSAHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockUSAHourKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("ktype", ktype)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockHourKLine> getStockUSAHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockUSAHourKLine(code , ktype , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockHourKLine>>() {
        }.getType());
    }

    /**
     *  如果想收盘后立即获取当日的收盘数据，可通过【实时行情】或者【每日行情】接口获取收盘后的日K线数据。美股日线、周线、月线数据。温馨提示：code参数可以从【美股->美股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【美股->美股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype       K线类别，取值范围：101|日线；102|周线；103|月线
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockKLine对象
     * @throws IOException
     */

    public String getStockUSADayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockUSADayKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("ktype", ktype)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockKLine> getStockUSADayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getStockUSADayKLine(code , ktype , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockKLine>>() {
        }.getType());
    }

    /**
     *  沪深指数基本信息。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getIndexHSBaseInfo(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndexHSBaseInfo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockBaseInfo> getIndexHSBaseInfo(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndexHSBaseInfo(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     *  香港指数基本信息。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getIndexHKBaseInfo(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndexHKBaseInfo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockBaseInfo> getIndexHKBaseInfo(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndexHKBaseInfo(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     *  全球指数基本信息。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getIndexQQBaseInfo(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndexQQBaseInfo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockBaseInfo> getIndexQQBaseInfo(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndexQQBaseInfo(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     *  债券指数基本信息。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getIndexBondBaseInfo(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndexBondBaseInfo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockBaseInfo> getIndexBondBaseInfo(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndexBondBaseInfo(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     *  如果想立即获取当天的收盘数据，收盘后可通过本接口采集当天日K线数据。所有指数行情数据。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockDailyMarketCopy对象
     * @throws IOException
     */

    public String getIndexDailyMarket(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndexDailyMarket";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockDailyMarketCopy> getIndexDailyMarket(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndexDailyMarket(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockDailyMarketCopy>>() {
        }.getType());
    }

    /**
     *  所有指数5分钟、15分钟、30分钟、60分钟数据。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：5|5分钟；15|15分钟；30|30分钟；60|60分钟
     * @param startDate   开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate     结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockHourKLine对象
     * @throws IOException
     */

    public String getIndexHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndexHourKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("ktype", ktype)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockHourKLine> getIndexHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndexHourKLine(code , ktype , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockHourKLine>>() {
        }.getType());
    }

    /**
     *  如果想收盘后立即获取当日的收盘数据，可通过【实时行情】或者【每日行情】接口获取收盘后的日K线数据。所有指数日线、周线、月线数据。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype       K线类别，取值范围：101|日线；102|周线；103|月线
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockKLine对象
     * @throws IOException
     */

    public String getIndexDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getIndexDayKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("ktype", ktype)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockKLine> getIndexDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getIndexDayKLine(code , ktype , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockKLine>>() {
        }.getType());
    }

    /**
     *  沪深可转债基本信息。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        债券代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getBondHSBaseInfo(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getBondHSBaseInfo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockBaseInfo> getBondHSBaseInfo(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getBondHSBaseInfo(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     *  沪深可转债基本信息。温馨提示：code参数可以从【债券->可转债列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        债券代码，code参数可以从【债券->可转债列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考BondBaseInfo对象
     * @throws IOException
     */

    public String getBondHSDetailInfo(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getBondHSDetailInfo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<BondBaseInfo> getBondHSDetailInfo(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getBondHSDetailInfo(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<BondBaseInfo>>() {
        }.getType());
    }

    /**
     *  如果想立即获取当天的收盘数据，收盘后可通过本接口采集当天日K线数据。可转债行情数据。温馨提示：code参数可以从【债券->可转债列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【债券->可转债列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockDailyMarketCopy对象
     * @throws IOException
     */

    public String getBondHSDailyMarket(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getBondHSDailyMarket";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockDailyMarketCopy> getBondHSDailyMarket(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getBondHSDailyMarket(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockDailyMarketCopy>>() {
        }.getType());
    }

    /**
     *  可转债分线数据，数据以分钟为粒度。温馨提示：code参数可以从【债券->可转债列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【债券->可转债列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param startDate   开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate     结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockMinuteKLine对象
     * @throws IOException
     */

    public String getBondMinuteKLine(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getBondMinuteKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockMinuteKLine> getBondMinuteKLine(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getBondMinuteKLine(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockMinuteKLine>>() {
        }.getType());
    }

    /**
     *  可转债分时数据。温馨提示：code参数可以从【债券->可转债列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【债券->可转债列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype       K线类别，取值范围：5|5分钟；15|15分钟；30|30分钟；60|60分钟
     * @param startDate   开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate     结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockHourKLine对象
     * @throws IOException
     */

    public String getBondHSHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getBondHSHourKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("ktype", ktype)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockHourKLine> getBondHSHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getBondHSHourKLine(code , ktype , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockHourKLine>>() {
        }.getType());
    }

    /**
     *  如果想收盘后立即获取当日的收盘数据，可通过【实时行情】或者【每日行情】接口获取收盘后的日K线数据。可转债日线、周线、月线数据。温馨提示：code参数可以从【债券->可转债列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【债券->可转债列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype       K线类别，取值范围：101|日线；102|周线；103|月线
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockKLine对象
     * @throws IOException
     */

    public String getBondHSDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getBondHSDayKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("ktype", ktype)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockKLine> getBondHSDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getBondHSDayKLine(code , ktype , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockKLine>>() {
        }.getType());
    }

    /**
     *  黄金基本信息。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getGoldBaseInfo(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getGoldBaseInfo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockBaseInfo> getGoldBaseInfo(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getGoldBaseInfo(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     *  如果想收盘后立即获取当日的收盘数据，可通过【实时行情】或者【每日行情】接口获取收盘后的日K线数据。黄金日线、周线、月线数据。温馨提示：code参数可以从【其它->黄金->黄金列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【其它->黄金->黄金列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype       K线类别，取值范围：101|日线；102|周线；103|月线
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockKLine对象
     * @throws IOException
     */

    public String getGoldDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getGoldDayKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("ktype", ktype)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockKLine> getGoldDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getGoldDayKLine(code , ktype , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockKLine>>() {
        }.getType());
    }

    /**
     *  外汇基本信息。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getWaihuiBaseInfo(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getWaihuiBaseInfo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockBaseInfo> getWaihuiBaseInfo(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getWaihuiBaseInfo(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     *  如果想收盘后立即获取当日的收盘数据，可通过【实时行情】或者【每日行情】接口获取收盘后的日K线数据。外汇日线、周线、月线数据。温馨提示：code参数可以从【其它->外汇->外汇列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【其它->外汇->外汇列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype       K线类别，取值范围：101|日线；102|周线；103|月线
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockKLine对象
     * @throws IOException
     */

    public String getWaihuiDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getWaihuiDayKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("ktype", ktype)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockKLine> getWaihuiDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getWaihuiDayKLine(code , ktype , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockKLine>>() {
        }.getType());
    }

    /**
     *  黄金基本信息。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getReitsBaseInfo(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getReitsBaseInfo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockBaseInfo> getReitsBaseInfo(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getReitsBaseInfo(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     *  如果想收盘后立即获取当日的收盘数据，可通过【实时行情】或者【每日行情】接口获取收盘后的日K线数据。Reits日线、周线、月线数据。温馨提示：code参数可以从【其它->REITS->REITS列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【其它->REITS->REITS列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype       K线类别，取值范围：101|日线；102|周线；103|月线
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockKLine对象
     * @throws IOException
     */

    public String getReitsDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getReitsDayKLine";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("ktype", ktype)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockKLine> getReitsDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getReitsDayKLine(code , ktype , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockKLine>>() {
        }.getType());
    }

    /**
     *  期货基本信息。温馨提示：建议选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考QiHuoBaseInfo对象
     * @throws IOException
     */

    public String getQihuoBaseInfo(String code, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getQihuoBaseInfo";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<QiHuoBaseInfo> getQihuoBaseInfo(String code, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getQihuoBaseInfo(code , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<QiHuoBaseInfo>>() {
        }.getType());
    }

    /**
     *  如果想立即获取当天的收盘数据，收盘后可通过本接口采集当天日K线数据。期货每日行情数据。温馨提示：code参数可以从【其它->期货->期货列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param code        股票代码，code参数可以从【其它->期货->期货列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考QiHuoKLine对象
     * @throws IOException
     */

    public String getQihuoDailyMarket(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getQihuoDailyMarket";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<QiHuoKLine> getQihuoDailyMarket(String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getQihuoDailyMarket(code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<QiHuoKLine>>() {
        }.getType());
    }

    /**
     *  提供各大机构持有沪深京A股、沪深京B股、港股数据。主要用于分析个股每个季度被各大基金机构持有情况。温馨提示：code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据。
     * 
     * @param type        资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股
     * @param code        股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate   开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate     结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields      数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token       令牌，登录后可获取
     * @param filter      过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考TSStockPosition对象
     * @throws IOException
     */

    public String getTSStockPosition(int type, String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getTSStockPosition";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("type", type)
                .put("code", code)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<TSStockPosition> getTSStockPosition(int type, String code, String startDate, String endDate, String fields, String token, String filter,  MethodType method) throws IOException {
        String data = getTSStockPosition(type , code , startDate , endDate , fields , token , filter ,  method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<TSStockPosition>>() {
        }.getType());
    }

}
