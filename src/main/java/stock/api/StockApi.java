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
     * @param type   资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code   股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getBaseInfo(int type, String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockBaseInfo> getBaseInfo(int type, String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getBaseInfo(type, code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param flags  分类标记，取值范围：1|上证A股；2|深证A股；3|北证A股；4|沪深京B股；5|新股；6|创业板；7|科创板；8|沪股通(港>沪)；9|深股通(港>深)；10|st股票；11|港股通(沪>港)；12|港股通(深>港)；13|注册制上证A股；14|核准制上证A股；15|注册制深证A股；16|核准制深证A股；17|主板港股；18|创业板港股；19|知名港股；20|蓝筹港股；21|红筹港股；22|国企港股；23|知名美股；24|中概美股；25|粉单市场
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getStockType(long flags, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockBaseInfo> getStockType(long flags, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockType(flags, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param mtype     市场类型，取值范围：1|沪深京A股；2|港股；3|沪深港通-北向；4|沪深港通-南向
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考TradeDate对象
     * @throws IOException
     */

    public String getTradeDate(int mtype, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<TradeDate> getTradeDate(int mtype, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getTradeDate(mtype, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；3|港股；4|美股；10|沪深指数；20|场内基金；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorMuchMoney对象
     * @throws IOException
     */

    public String getIndicatorMoney(int type, String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorMuchMoney> getIndicatorMoney(int type, String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorMoney(type, code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；3|港股；4|美股；20|场内基金
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorBaseInfo对象
     * @throws IOException
     */

    public String getIndicatorBaseInfo(int type, String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorBaseInfo> getIndicatorBaseInfo(int type, String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorBaseInfo(type, code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockDailyMarketCopy对象
     * @throws IOException
     */

    public String getDailyMarket(int type, String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockDailyMarketCopy> getDailyMarket(int type, String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getDailyMarket(type, code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param startDate 开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate   结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockMinuteKLine对象
     * @throws IOException
     */

    public String getMinuteKLine(int type, String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockMinuteKLine> getMinuteKLine(int type, String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getMinuteKLine(type, code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：5|5分钟；15|15分钟；30|30分钟；60|60分钟
     * @param startDate 开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate   结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockHourKLine对象
     * @throws IOException
     */

    public String getHourKLine(int type, String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockHourKLine> getHourKLine(int type, String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getHourKLine(type, code, ktype, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype     K线类别，取值范围：101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockKLine对象
     * @throws IOException
     */

    public String getDayKLine(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockKLine> getDayKLine(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getDayKLine(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；20|场内基金；30|沪深债券
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param startDate 开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate   结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockLevel2TimeDeal对象
     * @throws IOException
     */

    public String getLevel2TimeDeal(int type, String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockLevel2TimeDeal> getLevel2TimeDeal(int type, String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getLevel2TimeDeal(type, code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param bkcode 板块代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getHangyeCfg(String bkcode, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockBaseInfo> getHangyeCfg(String bkcode, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getHangyeCfg(bkcode, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code   指数代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ZhiShuChengFenGuZhongZhen对象
     * @throws IOException
     */

    public String getZhiShuChengFenGuZhongZhen(String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<ZhiShuChengFenGuZhongZhen> getZhiShuChengFenGuZhongZhen(String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getZhiShuChengFenGuZhongZhen(code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param mtype  指数类别，取值范围：1|沪深300；2|上证50；3|中证500；4|科创50
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ZhiShuChengFenGu对象
     * @throws IOException
     */

    public String getZhiShuChengFenGu(int mtype, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<ZhiShuChengFenGu> getZhiShuChengFenGu(int mtype, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getZhiShuChengFenGu(mtype, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type   资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code   股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考WatchStockTimeKLine对象
     * @throws IOException
     */

    public String getWatchStockTimeKLine(int type, String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<WatchStockTimeKLine> getWatchStockTimeKLine(int type, String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getWatchStockTimeKLine(type, code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel1对象
     * @throws IOException
     */

    public String getIndicatorTaAcos(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel1> getIndicatorTaAcos(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaAcos(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaAd(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaAd(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaAd(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    快速移动平均线周期
     * @param input2    慢速移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel4对象
     * @throws IOException
     */

    public String getIndicatorTaAdOsc(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel4> getIndicatorTaAdOsc(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaAdOsc(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel5对象
     * @throws IOException
     */

    public String getIndicatorTaAdd(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel5> getIndicatorTaAdd(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaAdd(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel3对象
     * @throws IOException
     */

    public String getIndicatorTaAdx(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel3> getIndicatorTaAdx(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaAdx(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel3对象
     * @throws IOException
     */

    public String getIndicatorTaAdxr(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel3> getIndicatorTaAdxr(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaAdxr(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    快速移动平均线周期
     * @param input3    慢速移动平均线周期
     * @param input4    移动平均线类型，取值范围：1|SMA-简单移动平均线；2|EMA-指数移动平均线；3|WMA-加权移动平均线；4|DEMA-双指数移动平均线；5|TEMA-三重指数移动平均线；6|TRIMA-三重移动平均线；7|KAMA-考夫曼自适应移动平均线；8|MAMA-自适应移动平均线；9|T3-三重移动平均线
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel17对象
     * @throws IOException
     */

    public String getIndicatorTaApo(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel17> getIndicatorTaApo(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaApo(type, code, ktype, fq, startDate, endDate, input1, input2, input3, input4, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel8对象
     * @throws IOException
     */

    public String getIndicatorTaAroon(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel8> getIndicatorTaAroon(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaAroon(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel3对象
     * @throws IOException
     */

    public String getIndicatorTaAroonOsc(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel3> getIndicatorTaAroonOsc(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaAroonOsc(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel1对象
     * @throws IOException
     */

    public String getIndicatorTaAsin(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel1> getIndicatorTaAsin(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaAsin(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel1对象
     * @throws IOException
     */

    public String getIndicatorTaAtan(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel1> getIndicatorTaAtan(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaAtan(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel3对象
     * @throws IOException
     */

    public String getIndicatorTaAtr(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel3> getIndicatorTaAtr(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaAtr(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaAvgPrice(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaAvgPrice(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaAvgPrice(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param input3    上轨道线的标准偏差倍数
     * @param input4    下轨道线的标准偏差倍数
     * @param input5    移动平均线类型，取值范围：1|SMA-简单移动平均线；2|EMA-指数移动平均线；3|WMA-加权移动平均线；4|DEMA-双指数移动平均线；5|TEMA-三重指数移动平均线；6|TRIMA-三重移动平均线；7|KAMA-考夫曼自适应移动平均线；8|MAMA-自适应移动平均线；9|T3-三重移动平均线
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel21对象
     * @throws IOException
     */

    public String getIndicatorTaBbands(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String input5, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel21> getIndicatorTaBbands(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String input5, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaBbands(type, code, ktype, fq, startDate, endDate, input1, input2, input3, input4, input5, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input3    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel13对象
     * @throws IOException
     */

    public String getIndicatorTaBeta(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel13> getIndicatorTaBeta(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaBeta(type, code, ktype, fq, startDate, endDate, input1, input2, input3, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaBop(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaBop(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaBop(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel3对象
     * @throws IOException
     */

    public String getIndicatorTaCci(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel3> getIndicatorTaCci(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCci(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdl2Crows(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdl2Crows(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdl2Crows(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdl3BlackCrows(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdl3BlackCrows(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdl3BlackCrows(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdl3Inside(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdl3Inside(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdl3Inside(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdl3LineStrike(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdl3LineStrike(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdl3LineStrike(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdl3Outside(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdl3Outside(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdl3Outside(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdl3StarsInSouth(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdl3StarsInSouth(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdl3StarsInSouth(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdl3WhiteSoldiers(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdl3WhiteSoldiers(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdl3WhiteSoldiers(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     穿透率
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel3对象
     * @throws IOException
     */

    public String getIndicatorTaCdlAbandonedBaby(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel3> getIndicatorTaCdlAbandonedBaby(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlAbandonedBaby(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlAdvanceBlock(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlAdvanceBlock(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlAdvanceBlock(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlBeltHold(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlBeltHold(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlBeltHold(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlBreakaway(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlBreakaway(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlBreakaway(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlClosingMarubozu(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlClosingMarubozu(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlClosingMarubozu(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlConcealBabysWall(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlConcealBabysWall(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlConcealBabysWall(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlCounterAttack(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlCounterAttack(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlCounterAttack(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     穿透率
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel3对象
     * @throws IOException
     */

    public String getIndicatorTaCdlDarkCloudCover(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel3> getIndicatorTaCdlDarkCloudCover(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlDarkCloudCover(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlDoji(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlDoji(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlDoji(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlDojiStar(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlDojiStar(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlDojiStar(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlDragonflyDoji(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlDragonflyDoji(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlDragonflyDoji(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlEngulfing(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlEngulfing(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlEngulfing(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     穿透率
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel3对象
     * @throws IOException
     */

    public String getIndicatorTaCdlEveningDojiStar(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel3> getIndicatorTaCdlEveningDojiStar(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlEveningDojiStar(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     穿透率
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel3对象
     * @throws IOException
     */

    public String getIndicatorTaCdlEveningStar(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel3> getIndicatorTaCdlEveningStar(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlEveningStar(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlGapSideSideWhite(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlGapSideSideWhite(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlGapSideSideWhite(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlGravestoneDoji(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlGravestoneDoji(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlGravestoneDoji(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlHammer(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlHammer(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlHammer(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlHangingMan(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlHangingMan(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlHangingMan(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlHarami(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlHarami(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlHarami(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlHaramiCross(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlHaramiCross(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlHaramiCross(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlHignWave(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlHignWave(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlHignWave(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlHikkake(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlHikkake(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlHikkake(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlHikkakeMod(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlHikkakeMod(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlHikkakeMod(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlHomingPigeon(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlHomingPigeon(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlHomingPigeon(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlIdentical3Crows(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlIdentical3Crows(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlIdentical3Crows(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlInNeck(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlInNeck(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlInNeck(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlInvertedHammer(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlInvertedHammer(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlInvertedHammer(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlKicking(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlKicking(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlKicking(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlKickingByLength(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlKickingByLength(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlKickingByLength(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlLadderBottom(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlLadderBottom(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlLadderBottom(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlLongLeggedDoji(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlLongLeggedDoji(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlLongLeggedDoji(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlLongLine(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlLongLine(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlLongLine(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlMarubozu(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlMarubozu(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlMarubozu(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     穿透率
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel3对象
     * @throws IOException
     */

    public String getIndicatorTaCdlMatHold(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel3> getIndicatorTaCdlMatHold(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlMatHold(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlMatchingLow(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlMatchingLow(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlMatchingLow(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     穿透率
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel3对象
     * @throws IOException
     */

    public String getIndicatorTaCdlMorningDojiStar(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel3> getIndicatorTaCdlMorningDojiStar(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlMorningDojiStar(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     穿透率
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel3对象
     * @throws IOException
     */

    public String getIndicatorTaCdlMorningStar(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel3> getIndicatorTaCdlMorningStar(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlMorningStar(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlOnNeck(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlOnNeck(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlOnNeck(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlPiercing(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlPiercing(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlPiercing(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlRickshawMan(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlRickshawMan(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlRickshawMan(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlRiseFall3Methods(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlRiseFall3Methods(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlRiseFall3Methods(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlSeperatingLines(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlSeperatingLines(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlSeperatingLines(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlShootingStar(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlShootingStar(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlShootingStar(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlShortLine(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlShortLine(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlShortLine(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlSpinningTop(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlSpinningTop(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlSpinningTop(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlStalledPattern(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlStalledPattern(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlStalledPattern(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlStickSandwhich(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlStickSandwhich(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlStickSandwhich(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlTakuri(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlTakuri(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlTakuri(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlTasukiGap(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlTasukiGap(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlTasukiGap(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlThrusting(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlThrusting(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlThrusting(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlTristar(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlTristar(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlTristar(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlUnique3River(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlUnique3River(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlUnique3River(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlUpsideGap2Crows(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlUpsideGap2Crows(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlUpsideGap2Crows(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaCdlXSideGap3Methods(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaCdlXSideGap3Methods(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCdlXSideGap3Methods(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel1对象
     * @throws IOException
     */

    public String getIndicatorTaCeil(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel1> getIndicatorTaCeil(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCeil(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaCmo(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaCmo(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCmo(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input3    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel13对象
     * @throws IOException
     */

    public String getIndicatorTaCorrel(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel13> getIndicatorTaCorrel(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCorrel(type, code, ktype, fq, startDate, endDate, input1, input2, input3, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel1对象
     * @throws IOException
     */

    public String getIndicatorTaCos(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel1> getIndicatorTaCos(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCos(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel1对象
     * @throws IOException
     */

    public String getIndicatorTaCosh(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel1> getIndicatorTaCosh(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaCosh(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaDema(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaDema(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaDema(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel5对象
     * @throws IOException
     */

    public String getIndicatorTaDiv(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel5> getIndicatorTaDiv(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaDiv(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel3对象
     * @throws IOException
     */

    public String getIndicatorTaDx(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel3> getIndicatorTaDx(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaDx(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaEma(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaEma(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaEma(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel1对象
     * @throws IOException
     */

    public String getIndicatorTaExp(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel1> getIndicatorTaExp(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaExp(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel1对象
     * @throws IOException
     */

    public String getIndicatorTaFloor(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel1> getIndicatorTaFloor(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaFloor(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel1对象
     * @throws IOException
     */

    public String getIndicatorTaHtDcPeriod(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel1> getIndicatorTaHtDcPeriod(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaHtDcPeriod(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel1对象
     * @throws IOException
     */

    public String getIndicatorTaHtDcPhase(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel1> getIndicatorTaHtDcPhase(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaHtDcPhase(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel6对象
     * @throws IOException
     */

    public String getIndicatorTaHtPhasor(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel6> getIndicatorTaHtPhasor(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaHtPhasor(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel6对象
     * @throws IOException
     */

    public String getIndicatorTaHtSine(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel6> getIndicatorTaHtSine(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaHtSine(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel1对象
     * @throws IOException
     */

    public String getIndicatorTaHtTrendMode(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel1> getIndicatorTaHtTrendMode(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaHtTrendMode(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel1对象
     * @throws IOException
     */

    public String getIndicatorTaHtTrendline(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel1> getIndicatorTaHtTrendline(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaHtTrendline(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaKama(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaKama(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaKama(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaLinearReg(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaLinearReg(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaLinearReg(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaLinearRegAngle(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaLinearRegAngle(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaLinearRegAngle(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaLinearRegIntercept(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaLinearRegIntercept(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaLinearRegIntercept(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaLinearRegSlope(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaLinearRegSlope(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaLinearRegSlope(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel1对象
     * @throws IOException
     */

    public String getIndicatorTaLn(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel1> getIndicatorTaLn(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaLn(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel1对象
     * @throws IOException
     */

    public String getIndicatorTaLog10(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel1> getIndicatorTaLog10(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaLog10(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    快速移动平均线周期
     * @param input3    慢速移动平均线周期
     * @param input4    信号移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel19对象
     * @throws IOException
     */

    public String getIndicatorTaMacd(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel19> getIndicatorTaMacd(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaMacd(type, code, ktype, fq, startDate, endDate, input1, input2, input3, input4, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    快速移动平均线周期
     * @param input3    快速移动平均线类型，取值范围：1|SMA-简单移动平均线；2|EMA-指数移动平均线；3|WMA-加权移动平均线；4|DEMA-双指数移动平均线；5|TEMA-三重指数移动平均线；6|TRIMA-三重移动平均线；7|KAMA-考夫曼自适应移动平均线；8|MAMA-自适应移动平均线；9|T3-三重移动平均线
     * @param input4    慢速移动平均线周期
     * @param input5    慢速移动平均线类型，取值范围：1|SMA-简单移动平均线；2|EMA-指数移动平均线；3|WMA-加权移动平均线；4|DEMA-双指数移动平均线；5|TEMA-三重指数移动平均线；6|TRIMA-三重移动平均线；7|KAMA-考夫曼自适应移动平均线；8|MAMA-自适应移动平均线；9|T3-三重移动平均线
     * @param input6    信号移动平均线周期
     * @param input7    信号移动平均线类型，取值范围：1|SMA-简单移动平均线；2|EMA-指数移动平均线；3|WMA-加权移动平均线；4|DEMA-双指数移动平均线；5|TEMA-三重指数移动平均线；6|TRIMA-三重移动平均线；7|KAMA-考夫曼自适应移动平均线；8|MAMA-自适应移动平均线；9|T3-三重移动平均线
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel23对象
     * @throws IOException
     */

    public String getIndicatorTaMacdExt(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String input5, String input6, String input7, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel23> getIndicatorTaMacdExt(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String input5, String input6, String input7, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaMacdExt(type, code, ktype, fq, startDate, endDate, input1, input2, input3, input4, input5, input6, input7, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    信号移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel14对象
     * @throws IOException
     */

    public String getIndicatorTaMacdFix(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel14> getIndicatorTaMacdFix(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaMacdFix(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    输入参数
     * @param input3    输入参数
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel15对象
     * @throws IOException
     */

    public String getIndicatorTaMama(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel15> getIndicatorTaMama(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaMama(type, code, ktype, fq, startDate, endDate, input1, input2, input3, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaMax(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaMax(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaMax(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaMaxIndex(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaMaxIndex(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaMaxIndex(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaMedPrice(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaMedPrice(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaMedPrice(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel3对象
     * @throws IOException
     */

    public String getIndicatorTaMfi(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel3> getIndicatorTaMfi(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaMfi(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaMidPoint(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaMidPoint(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaMidPoint(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel3对象
     * @throws IOException
     */

    public String getIndicatorTaMidPrice(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel3> getIndicatorTaMidPrice(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaMidPrice(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaMin(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaMin(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaMin(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaMinIndex(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaMinIndex(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaMinIndex(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel9对象
     * @throws IOException
     */

    public String getIndicatorTaMinMax(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel9> getIndicatorTaMinMax(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaMinMax(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel9对象
     * @throws IOException
     */

    public String getIndicatorTaMinMaxIndex(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel9> getIndicatorTaMinMaxIndex(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaMinMaxIndex(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel3对象
     * @throws IOException
     */

    public String getIndicatorTaMinusDI(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel3> getIndicatorTaMinusDI(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaMinusDI(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel3对象
     * @throws IOException
     */

    public String getIndicatorTaMinusDM(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel3> getIndicatorTaMinusDM(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaMinusDM(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaMom(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaMom(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaMom(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param input3    移动平均线类型，取值范围：1|SMA-简单移动平均线；2|EMA-指数移动平均线；3|WMA-加权移动平均线；4|DEMA-双指数移动平均线；5|TEMA-三重指数移动平均线；6|TRIMA-三重移动平均线；7|KAMA-考夫曼自适应移动平均线；8|MAMA-自适应移动平均线；9|T3-三重移动平均线
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel11对象
     * @throws IOException
     */

    public String getIndicatorTaMovingAverage(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel11> getIndicatorTaMovingAverage(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaMovingAverage(type, code, ktype, fq, startDate, endDate, input1, input2, input3, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel5对象
     * @throws IOException
     */

    public String getIndicatorTaMult(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel5> getIndicatorTaMult(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaMult(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel3对象
     * @throws IOException
     */

    public String getIndicatorTaNatr(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel3> getIndicatorTaNatr(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaNatr(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel1对象
     * @throws IOException
     */

    public String getIndicatorTaObv(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel1> getIndicatorTaObv(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaObv(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel3对象
     * @throws IOException
     */

    public String getIndicatorTaPlusDI(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel3> getIndicatorTaPlusDI(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaPlusDI(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel3对象
     * @throws IOException
     */

    public String getIndicatorTaPlusDM(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel3> getIndicatorTaPlusDM(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaPlusDM(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    快速移动平均线周期
     * @param input3    慢速移动平均线周期
     * @param input4    移动平均线类型，取值范围：1|SMA-简单移动平均线；2|EMA-指数移动平均线；3|WMA-加权移动平均线；4|DEMA-双指数移动平均线；5|TEMA-三重指数移动平均线；6|TRIMA-三重移动平均线；7|KAMA-考夫曼自适应移动平均线；8|MAMA-自适应移动平均线；9|T3-三重移动平均线
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel17对象
     * @throws IOException
     */

    public String getIndicatorTaPpo(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel17> getIndicatorTaPpo(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaPpo(type, code, ktype, fq, startDate, endDate, input1, input2, input3, input4, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaRoc(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaRoc(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaRoc(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaRocP(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaRocP(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaRocP(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaRocR(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaRocR(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaRocR(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaRocR100(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaRocR100(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaRocR100(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaRsi(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaRsi(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaRsi(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    加速因子
     * @param input2    最大值
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel4对象
     * @throws IOException
     */

    public String getIndicatorTaSar(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel4> getIndicatorTaSar(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaSar(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    起始值
     * @param input2    反转偏移量
     * @param input3    多头初始加速因子
     * @param input4    多头加速因子
     * @param input5    多头最大加速因子
     * @param input6    空头初始加速因子
     * @param input7    空头加速因子
     * @param input8    空头最大加速因子
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel22对象
     * @throws IOException
     */

    public String getIndicatorTaSarExt(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String input5, String input6, String input7, String input8, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel22> getIndicatorTaSarExt(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String input5, String input6, String input7, String input8, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaSarExt(type, code, ktype, fq, startDate, endDate, input1, input2, input3, input4, input5, input6, input7, input8, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel1对象
     * @throws IOException
     */

    public String getIndicatorTaSin(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel1> getIndicatorTaSin(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaSin(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel1对象
     * @throws IOException
     */

    public String getIndicatorTaSinh(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel1> getIndicatorTaSinh(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaSinh(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaSma(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaSma(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaSma(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel1对象
     * @throws IOException
     */

    public String getIndicatorTaSqrt(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel1> getIndicatorTaSqrt(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaSqrt(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param input3    标准差倍数
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel10对象
     * @throws IOException
     */

    public String getIndicatorTaStdDev(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel10> getIndicatorTaStdDev(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaStdDev(type, code, ktype, fq, startDate, endDate, input1, input2, input3, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    快速移动平均线K周期
     * @param input2    慢速移动平均线K周期
     * @param input3    慢速移动平均线K类型，取值范围：1|SMA-简单移动平均线；2|EMA-指数移动平均线；3|WMA-加权移动平均线；4|DEMA-双指数移动平均线；5|TEMA-三重指数移动平均线；6|TRIMA-三重移动平均线；7|KAMA-考夫曼自适应移动平均线；8|MAMA-自适应移动平均线；9|T3-三重移动平均线
     * @param input4    慢速移动平均线D周期
     * @param input5    慢速移动平均线D类型，取值范围：1|SMA-简单移动平均线；2|EMA-指数移动平均线；3|WMA-加权移动平均线；4|DEMA-双指数移动平均线；5|TEMA-三重指数移动平均线；6|TRIMA-三重移动平均线；7|KAMA-考夫曼自适应移动平均线；8|MAMA-自适应移动平均线；9|T3-三重移动平均线
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel18对象
     * @throws IOException
     */

    public String getIndicatorTaStoch(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String input5, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel18> getIndicatorTaStoch(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String input5, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaStoch(type, code, ktype, fq, startDate, endDate, input1, input2, input3, input4, input5, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    快速移动平均线K周期
     * @param input2    慢速移动平均线D周期
     * @param input3    慢速移动平均线D类型，取值范围：1|SMA-简单移动平均线；2|EMA-指数移动平均线；3|WMA-加权移动平均线；4|DEMA-双指数移动平均线；5|TEMA-三重指数移动平均线；6|TRIMA-三重移动平均线；7|KAMA-考夫曼自适应移动平均线；8|MAMA-自适应移动平均线；9|T3-三重移动平均线
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel16对象
     * @throws IOException
     */

    public String getIndicatorTaStochF(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel16> getIndicatorTaStochF(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaStochF(type, code, ktype, fq, startDate, endDate, input1, input2, input3, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param input3    快速移动平均线K周期
     * @param input4    慢速移动平均线D周期
     * @param input5    慢速移动平均线D类型，取值范围：1|SMA-简单移动平均线；2|EMA-指数移动平均线；3|WMA-加权移动平均线；4|DEMA-双指数移动平均线；5|TEMA-三重指数移动平均线；6|TRIMA-三重移动平均线；7|KAMA-考夫曼自适应移动平均线；8|MAMA-自适应移动平均线；9|T3-三重移动平均线
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel20对象
     * @throws IOException
     */

    public String getIndicatorTaStochRsi(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String input5, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel20> getIndicatorTaStochRsi(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String input4, String input5, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaStochRsi(type, code, ktype, fq, startDate, endDate, input1, input2, input3, input4, input5, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel5对象
     * @throws IOException
     */

    public String getIndicatorTaSub(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel5> getIndicatorTaSub(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaSub(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaSum(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaSum(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaSum(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param input3    va系数
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel10对象
     * @throws IOException
     */

    public String getIndicatorTaT3(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel10> getIndicatorTaT3(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaT3(type, code, ktype, fq, startDate, endDate, input1, input2, input3, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel1对象
     * @throws IOException
     */

    public String getIndicatorTaTan(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel1> getIndicatorTaTan(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaTan(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel1对象
     * @throws IOException
     */

    public String getIndicatorTaTanh(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel1> getIndicatorTaTanh(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaTanh(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaTema(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaTema(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaTema(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaTrima(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaTrima(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaTrima(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaTrix(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaTrix(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaTrix(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaTrueRange(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaTrueRange(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaTrueRange(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaTsf(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaTsf(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaTsf(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaTypPrice(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaTypPrice(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaTypPrice(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    移动平均线周期1
     * @param input2    移动平均线周期2
     * @param input3    移动平均线周期3
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel12对象
     * @throws IOException
     */

    public String getIndicatorTaUltOsc(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel12> getIndicatorTaUltOsc(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaUltOsc(type, code, ktype, fq, startDate, endDate, input1, input2, input3, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param input3    标准差倍数
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel10对象
     * @throws IOException
     */

    public String getIndicatorTaVariance(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel10> getIndicatorTaVariance(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String input3, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaVariance(type, code, ktype, fq, startDate, endDate, input1, input2, input3, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel2对象
     * @throws IOException
     */

    public String getIndicatorTaWclPrice(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel2> getIndicatorTaWclPrice(int type, String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaWclPrice(type, code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input     移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel3对象
     * @throws IOException
     */

    public String getIndicatorTaWillR(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel3> getIndicatorTaWillR(int type, String code, int ktype, int fq, String startDate, String endDate, String input, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaWillR(type, code, ktype, fq, startDate, endDate, input, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股；4|美股；5|黄金；6|汇率；7|Reits；10|沪深指数；11|香港指数；12|全球指数；13|债券指数；20|场内基金；30|沪深债券；40|行业板块；41|概念板块；42|地域板块
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：1|1分钟；5|5分钟；15|15分钟；30|30分钟；60|60分钟；101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param input1    数据标签，取值范围：1|open-开盘价；2|close-收盘价；3|high-最高价；4|low-最低价；5|cjl-成交量；6|cje-成交额
     * @param input2    移动平均线周期
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考IndicatorTaModel7对象
     * @throws IOException
     */

    public String getIndicatorTaWma(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<IndicatorTaModel7> getIndicatorTaWma(int type, String code, int ktype, int fq, String startDate, String endDate, String input1, String input2, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndicatorTaWma(type, code, ktype, fq, startDate, endDate, input1, input2, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code   股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getStockHSABaseInfo(String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockBaseInfo> getStockHSABaseInfo(String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockHSABaseInfo(code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockDailyMarket对象
     * @throws IOException
     */

    public String getStockHSADailyMarket(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockDailyMarket> getStockHSADailyMarket(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockHSADailyMarket(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param startDate 开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate   结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockMinuteKLine对象
     * @throws IOException
     */

    public String getStockHSAMinuteKLine(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockMinuteKLine> getStockHSAMinuteKLine(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockHSAMinuteKLine(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：5|5分钟；15|15分钟；30|30分钟；60|60分钟
     * @param startDate 开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate   结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockHourKLine对象
     * @throws IOException
     */

    public String getStockHSAHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockHourKLine> getStockHSAHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockHSAHourKLine(code, ktype, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype     K线类别，取值范围：101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockKLine对象
     * @throws IOException
     */

    public String getStockHSADayKLine(String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockKLine> getStockHSADayKLine(String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockHSADayKLine(code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code   股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getStockHSBBaseInfo(String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockBaseInfo> getStockHSBBaseInfo(String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockHSBBaseInfo(code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【沪深京->B股->B股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockDailyMarket对象
     * @throws IOException
     */

    public String getStockHSBDailyMarket(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockDailyMarket> getStockHSBDailyMarket(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockHSBDailyMarket(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【沪深京->B股->B股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param startDate 开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate   结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockMinuteKLine对象
     * @throws IOException
     */

    public String getStockHSBMinuteKLine(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockMinuteKLine> getStockHSBMinuteKLine(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockHSBMinuteKLine(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【沪深京->B股->B股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：5|5分钟；15|15分钟；30|30分钟；60|60分钟
     * @param startDate 开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate   结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockHourKLine对象
     * @throws IOException
     */

    public String getStockHSBHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockHourKLine> getStockHSBHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockHSBHourKLine(code, ktype, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【沪深京->B股->B股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype     K线类别，取值范围：101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockKLine对象
     * @throws IOException
     */

    public String getStockHSBDayKLine(String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockKLine> getStockHSBDayKLine(String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockHSBDayKLine(code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockReName对象
     * @throws IOException
     */

    public String getStockReName(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockReName> getStockReName(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockReName(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code   股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考CompanyInfo对象
     * @throws IOException
     */

    public String getCompanyInfo(String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<CompanyInfo> getCompanyInfo(String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getCompanyInfo(code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockAccount对象
     * @throws IOException
     */

    public String getStockAccount(String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
        String url = "http://api.waizaowang.com/doc/getStockAccount";
        Map<String, Object> para = ImmutableMap.<String, Object>builder()
                .put("fields", fields)
                .put("token", token)
                .put("filter", filter)
                .put("export", exportType.getType())
                .build();
        return method.equals(MethodType.GET) ? HttpClientRest.getIntance().get(url, para) : HttpClientRest.getIntance().post(url, para);
    }

    public List<StockAccount> getStockAccount(String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockAccount(fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考HSTradeDate对象
     * @throws IOException
     */

    public String getStockTradeDate(String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<HSTradeDate> getStockTradeDate(String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockTradeDate(startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ChuQuanChuXi对象
     * @throws IOException
     */

    public String getChuQuanChuXi(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<ChuQuanChuXi> getChuQuanChuXi(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getChuQuanChuXi(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param fq        复权类别，取值范围：1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考FuQuanYinZi对象
     * @throws IOException
     */

    public String getFuQuanYinZi(String code, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<FuQuanYinZi> getFuQuanYinZi(String code, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getFuQuanYinZi(code, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考JiGouDiaoYanTongJi对象
     * @throws IOException
     */

    public String getJiGouDiaoYanTongJi(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<JiGouDiaoYanTongJi> getJiGouDiaoYanTongJi(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getJiGouDiaoYanTongJi(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考JiGouDiaoYanXiangXi对象
     * @throws IOException
     */

    public String getJiGouDiaoYanXiangXi(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<JiGouDiaoYanXiangXi> getJiGouDiaoYanXiangXi(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getJiGouDiaoYanXiangXi(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code   股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考JiGouDiaoYanJiLv对象
     * @throws IOException
     */

    public String getJiGouDiaoYanJiLv(String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<JiGouDiaoYanJiLv> getJiGouDiaoYanJiLv(String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getJiGouDiaoYanJiLv(code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考LonghbDetail对象
     * @throws IOException
     */

    public String getLonghbDetail(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<LonghbDetail> getLonghbDetail(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getLonghbDetail(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考LonghbActive对象
     * @throws IOException
     */

    public String getLonghbActive(String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<LonghbActive> getLonghbActive(String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getLonghbActive(startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考LonghbJigou对象
     * @throws IOException
     */

    public String getLonghbJigou(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<LonghbJigou> getLonghbJigou(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getLonghbJigou(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param mtype     市场类型，取值范围：1|沪深两市；2|沪市；3|深市；3|京市
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考RzRjMarket对象
     * @throws IOException
     */

    public String getRzRjMarket(int mtype, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<RzRjMarket> getRzRjMarket(int mtype, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getRzRjMarket(mtype, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      板块代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考RzRjHangye对象
     * @throws IOException
     */

    public String getRzRjHangye(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<RzRjHangye> getRzRjHangye(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getRzRjHangye(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考RzRjStock对象
     * @throws IOException
     */

    public String getStockRzRj(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<RzRjStock> getStockRzRj(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockRzRj(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考RzRjAccount对象
     * @throws IOException
     */

    public String getRzRjAccount(String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<RzRjAccount> getRzRjAccount(String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getRzRjAccount(startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype     K线类别，取值范围：101|日线；102|周线；103|月线
     * @param fq        复权信息，取值范围：0|不复权；1|前复权；2|后复权
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考XQStockKLine对象
     * @throws IOException
     */

    public String getStockXQHSADayKLine(String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<XQStockKLine> getStockXQHSADayKLine(String code, int ktype, int fq, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockXQHSADayKLine(code, ktype, fq, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考YanBaoStock对象
     * @throws IOException
     */

    public String getYanBaoStock(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<YanBaoStock> getYanBaoStock(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getYanBaoStock(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考YanBaoXinGu对象
     * @throws IOException
     */

    public String getYanBaoXinGu(String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<YanBaoXinGu> getYanBaoXinGu(String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getYanBaoXinGu(startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考YanBaoHangYe对象
     * @throws IOException
     */

    public String getYanBaoHangYe(String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<YanBaoHangYe> getYanBaoHangYe(String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getYanBaoHangYe(startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考YanBaoCeLue对象
     * @throws IOException
     */

    public String getYanbaoCelue(String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<YanBaoCeLue> getYanbaoCelue(String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getYanbaoCelue(startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考YanBaoChenBao对象
     * @throws IOException
     */

    public String getYanBaoChenBao(String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<YanBaoChenBao> getYanBaoChenBao(String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getYanBaoChenBao(startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考YanBaoHongGuan对象
     * @throws IOException
     */

    public String getYanBaoHongGuan(String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<YanBaoHongGuan> getYanBaoHongGuan(String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getYanBaoHongGuan(startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code   股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考YanBaoYingLi对象
     * @throws IOException
     */

    public String getYanBaoYingLi(String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<YanBaoYingLi> getYanBaoYingLi(String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getYanBaoYingLi(code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ReportNianBao对象
     * @throws IOException
     */

    public String getReportNianBao(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<ReportNianBao> getReportNianBao(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getReportNianBao(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ReportKuaiBao对象
     * @throws IOException
     */

    public String getReportKuaiBao(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<ReportKuaiBao> getReportKuaiBao(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getReportKuaiBao(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ReportYugao对象
     * @throws IOException
     */

    public String getReportYugao(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<ReportYugao> getReportYugao(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getReportYugao(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ReportYuyueTime对象
     * @throws IOException
     */

    public String getReportYuyueTime(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<ReportYuyueTime> getReportYuyueTime(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getReportYuyueTime(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ReportFuzhai对象
     * @throws IOException
     */

    public String getReportFuzhai(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<ReportFuzhai> getReportFuzhai(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getReportFuzhai(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ReportLirun对象
     * @throws IOException
     */

    public String getReportLirun(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<ReportLirun> getReportLirun(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getReportLirun(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ReportXianjin对象
     * @throws IOException
     */

    public String getReportXianjin(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<ReportXianjin> getReportXianjin(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getReportXianjin(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考ReportFenhong对象
     * @throws IOException
     */

    public String getReportFenhong(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<ReportFenhong> getReportFenhong(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getReportFenhong(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param mtype     沪深港通资金类型，取值范围：1|沪股通(港>沪)资金-北向；2|深股通(港>深)资金-北向；3|北向资金；4|港股通(沪>港)资金-南向；5|港股通(深>港)资金-南向；6|南向资金
     * @param ktype     K线类别，取值范围：101|日线；102|周线；103|月线；104|季线；106|年线
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考HSGTMoney对象
     * @throws IOException
     */

    public String getHSGTMoney(int mtype, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<HSGTMoney> getHSGTMoney(int mtype, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getHSGTMoney(mtype, ktype, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      板块代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考HSGTBlockRank对象
     * @throws IOException
     */

    public String getHSGTBlockRank(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<HSGTBlockRank> getHSGTBlockRank(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getHSGTBlockRank(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考HSGTStockRank对象
     * @throws IOException
     */

    public String getHSGTStockRank(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<HSGTStockRank> getHSGTStockRank(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getHSGTStockRank(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param mtype     市场类别，取值范围：1|沪股通(港>沪)；2|深股通(港>深)；3|港股通(沪>港)；4|港股通(深>港)
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考HSGTHistory对象
     * @throws IOException
     */

    public String getHSGTHistory(int mtype, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<HSGTHistory> getHSGTHistory(int mtype, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getHSGTHistory(mtype, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param mtype     市场类别，取值范围：1|沪股通(港>沪)；2|港股通(沪>港)；3|深股通(港>深)；4|港股通(深>港)
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考HsgtStockTop10对象
     * @throws IOException
     */

    public String getHsgtStockTop10(String code, int mtype, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<HsgtStockTop10> getHsgtStockTop10(String code, int mtype, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getHsgtStockTop10(code, mtype, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param mtype     报告类型，取值范围：0|按报告期；1|按年度
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考CaiWuZYZBReportHSA对象
     * @throws IOException
     */

    public String getCaiWuZYZBReportHSA(String code, int mtype, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<CaiWuZYZBReportHSA> getCaiWuZYZBReportHSA(String code, int mtype, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getCaiWuZYZBReportHSA(code, mtype, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考CaiWuZYZBQuarterHSA对象
     * @throws IOException
     */

    public String getCaiWuZYZBQuarterHSA(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<CaiWuZYZBQuarterHSA> getCaiWuZYZBQuarterHSA(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getCaiWuZYZBQuarterHSA(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param mtype     报告类型，取值范围：0|按报告期；1|按年度
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考FinanceHSDebt对象
     * @throws IOException
     */

    public String getFinanceHSDebt(String code, int mtype, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<FinanceHSDebt> getFinanceHSDebt(String code, int mtype, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getFinanceHSDebt(code, mtype, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考PoolZT对象
     * @throws IOException
     */

    public String getPoolZT(String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<PoolZT> getPoolZT(String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getPoolZT(startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考PoolQS对象
     * @throws IOException
     */

    public String getPoolQS(String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<PoolQS> getPoolQS(String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getPoolQS(startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code   股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考PoolCX对象
     * @throws IOException
     */

    public String getPoolCX(String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<PoolCX> getPoolCX(String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getPoolCX(code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考PoolZB对象
     * @throws IOException
     */

    public String getPoolZB(String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<PoolZB> getPoolZB(String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getPoolZB(startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考PoolDT对象
     * @throws IOException
     */

    public String getPoolDT(String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<PoolDT> getPoolDT(String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getPoolDT(startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code   股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getCnFundBaseInfo(String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockBaseInfo> getCnFundBaseInfo(String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getCnFundBaseInfo(code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockDailyMarket对象
     * @throws IOException
     */

    public String getCnFundDailyMarket(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockDailyMarket> getCnFundDailyMarket(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getCnFundDailyMarket(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param startDate 开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate   结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockMinuteKLine对象
     * @throws IOException
     */

    public String getCnFundMinuteKLine(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockMinuteKLine> getCnFundMinuteKLine(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getCnFundMinuteKLine(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：5|5分钟；15|15分钟；30|30分钟；60|60分钟
     * @param startDate 开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate   结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockHourKLine对象
     * @throws IOException
     */

    public String getCnFundHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockHourKLine> getCnFundHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getCnFundHourKLine(code, ktype, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype     K线类别，取值范围：101|日线；102|周线；103|月线
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockKLine对象
     * @throws IOException
     */

    public String getCnFundADayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockKLine> getCnFundADayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getCnFundADayKLine(code, ktype, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code   基金代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考FundBaseInfo对象
     * @throws IOException
     */

    public String getFundBaseInfo(String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<FundBaseInfo> getFundBaseInfo(String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getFundBaseInfo(code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      基金代码，code参数可以从【基金->基金列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考FundRank对象
     * @throws IOException
     */

    public String getFundRank(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<FundRank> getFundRank(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getFundRank(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      基金代码，code参数可以从【基金->基金列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考FundNav对象
     * @throws IOException
     */

    public String getFundNav(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<FundNav> getFundNav(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getFundNav(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code   基金代码，code参数可以从【基金->基金列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考FundMaxBack对象
     * @throws IOException
     */

    public String getFundMaxBack(String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<FundMaxBack> getFundMaxBack(String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getFundMaxBack(code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      基金代码，code参数可以从【基金->基金列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考FundPosition对象
     * @throws IOException
     */

    public String getFundPosition(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<FundPosition> getFundPosition(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getFundPosition(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param scode     股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考FundPosition对象
     * @throws IOException
     */

    public String getStockPosition(String scode, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<FundPosition> getStockPosition(String scode, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockPosition(scode, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code   股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getStockHyBKBaseInfo(String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockBaseInfo> getStockHyBKBaseInfo(String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockHyBKBaseInfo(code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code   股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getStockGnBKBaseInfo(String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockBaseInfo> getStockGnBKBaseInfo(String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockGnBKBaseInfo(code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code   股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getStockDyBKBaseInfo(String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockBaseInfo> getStockDyBKBaseInfo(String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockDyBKBaseInfo(code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      板块代码（行业板块、地域板块、概念板块），code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockDailyMarket对象
     * @throws IOException
     */

    public String getStockHYADailyMarket(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockDailyMarket> getStockHYADailyMarket(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockHYADailyMarket(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      板块代码（行业板块、地域板块、概念板块），code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype     K线类别，取值范围：101|日线；102|周线；103|月线
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockKLine对象
     * @throws IOException
     */

    public String getStockBKDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockKLine> getStockBKDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockBKDayKLine(code, ktype, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      市场代码，取值范围：000300|沪深两市；000001|沪市主板；000688|科创板；399001|深市主板；399006|创业板
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考GZMarket对象
     * @throws IOException
     */

    public String getGZMarket(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<GZMarket> getGZMarket(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getGZMarket(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      板块代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考GZHangYe对象
     * @throws IOException
     */

    public String getGZHangYe(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<GZHangYe> getGZHangYe(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getGZHangYe(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【沪深京->A股->A股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考GZStock对象
     * @throws IOException
     */

    public String getHSGZStock(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<GZStock> getHSGZStock(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getHSGZStock(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type   资产类型，取值范围：40|行业板块；41|概念板块；42|地域板块；43|证监会行业板块
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfoPlatB对象
     * @throws IOException
     */

    public String getBaseInfoPlatB(int type, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockBaseInfoPlatB> getBaseInfoPlatB(int type, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getBaseInfoPlatB(type, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param bkcode 板块代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfoPlatB对象
     * @throws IOException
     */

    public String getHangyeCfgPlatB(String bkcode, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockBaseInfoPlatB> getHangyeCfgPlatB(String bkcode, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getHangyeCfgPlatB(bkcode, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code   股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getStockHKBaseInfo(String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockBaseInfo> getStockHKBaseInfo(String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockHKBaseInfo(code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【港股->港股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockDailyMarket对象
     * @throws IOException
     */

    public String getStockHKDailyMarket(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockDailyMarket> getStockHKDailyMarket(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockHKDailyMarket(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【港股->港股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param startDate 开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate   结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockMinuteKLine对象
     * @throws IOException
     */

    public String getStockHKMinuteKLine(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockMinuteKLine> getStockHKMinuteKLine(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockHKMinuteKLine(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【港股->港股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：5|5分钟；15|15分钟；30|30分钟；60|60分钟
     * @param startDate 开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate   结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockHourKLine对象
     * @throws IOException
     */

    public String getStockHKHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockHourKLine> getStockHKHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockHKHourKLine(code, ktype, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【港股->港股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype     K线类别，取值范围：101|日线；102|周线；103|月线
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockKLine对象
     * @throws IOException
     */

    public String getStockHKDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockKLine> getStockHKDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockHKDayKLine(code, ktype, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code   股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getStockUSABaseInfo(String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockBaseInfo> getStockUSABaseInfo(String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockUSABaseInfo(code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【美股->美股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockDailyMarket对象
     * @throws IOException
     */

    public String getStockUSADailyMarket(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockDailyMarket> getStockUSADailyMarket(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockUSADailyMarket(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【美股->美股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param startDate 开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate   结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockMinuteKLine对象
     * @throws IOException
     */

    public String getStockUSAMinuteKLine(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockMinuteKLine> getStockUSAMinuteKLine(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockUSAMinuteKLine(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【美股->美股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：5|5分钟；15|15分钟；30|30分钟；60|60分钟
     * @param startDate 开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate   结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockHourKLine对象
     * @throws IOException
     */

    public String getStockUSAHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockHourKLine> getStockUSAHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockUSAHourKLine(code, ktype, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【美股->美股列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype     K线类别，取值范围：101|日线；102|周线；103|月线
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockKLine对象
     * @throws IOException
     */

    public String getStockUSADayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockKLine> getStockUSADayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getStockUSADayKLine(code, ktype, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code   股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getIndexHSBaseInfo(String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockBaseInfo> getIndexHSBaseInfo(String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndexHSBaseInfo(code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code   股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getIndexHKBaseInfo(String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockBaseInfo> getIndexHKBaseInfo(String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndexHKBaseInfo(code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code   股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getIndexQQBaseInfo(String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockBaseInfo> getIndexQQBaseInfo(String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndexQQBaseInfo(code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code   股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getIndexBondBaseInfo(String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockBaseInfo> getIndexBondBaseInfo(String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndexBondBaseInfo(code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockDailyMarket对象
     * @throws IOException
     */

    public String getIndexDailyMarket(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockDailyMarket> getIndexDailyMarket(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndexDailyMarket(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：5|5分钟；15|15分钟；30|30分钟；60|60分钟
     * @param startDate 开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate   结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockHourKLine对象
     * @throws IOException
     */

    public String getIndexHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockHourKLine> getIndexHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndexHourKLine(code, ktype, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype     K线类别，取值范围：101|日线；102|周线；103|月线
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockKLine对象
     * @throws IOException
     */

    public String getIndexDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockKLine> getIndexDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getIndexDayKLine(code, ktype, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code   债券代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getBondHSBaseInfo(String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockBaseInfo> getBondHSBaseInfo(String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getBondHSBaseInfo(code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code   债券代码，code参数可以从【债券->可转债列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考BondBaseInfo对象
     * @throws IOException
     */

    public String getBondHSDetailInfo(String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<BondBaseInfo> getBondHSDetailInfo(String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getBondHSDetailInfo(code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【债券->可转债列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockDailyMarket对象
     * @throws IOException
     */

    public String getBondHSDailyMarket(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockDailyMarket> getBondHSDailyMarket(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getBondHSDailyMarket(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【债券->可转债列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param startDate 开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate   结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockMinuteKLine对象
     * @throws IOException
     */

    public String getBondMinuteKLine(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockMinuteKLine> getBondMinuteKLine(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getBondMinuteKLine(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【债券->可转债列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；不支持all参数查询。
     * @param ktype     K线类别，取值范围：5|5分钟；15|15分钟；30|30分钟；60|60分钟
     * @param startDate 开始日期，yyyy-MM-dd HH:mm:ss格式，例如：2020-01-01 01:00:00
     * @param endDate   结束日期，yyyy-MM-dd HH:mm:ss格式，例如：2050-01-01 01:00:00
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockHourKLine对象
     * @throws IOException
     */

    public String getBondHSHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockHourKLine> getBondHSHourKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getBondHSHourKLine(code, ktype, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【债券->可转债列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype     K线类别，取值范围：101|日线；102|周线；103|月线
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockKLine对象
     * @throws IOException
     */

    public String getBondHSDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockKLine> getBondHSDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getBondHSDayKLine(code, ktype, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code   股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getGoldBaseInfo(String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockBaseInfo> getGoldBaseInfo(String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getGoldBaseInfo(code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【其它->黄金->黄金列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype     K线类别，取值范围：101|日线；102|周线；103|月线
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockKLine对象
     * @throws IOException
     */

    public String getGoldDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockKLine> getGoldDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getGoldDayKLine(code, ktype, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code   股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getWaihuiBaseInfo(String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockBaseInfo> getWaihuiBaseInfo(String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getWaihuiBaseInfo(code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【其它->外汇->外汇列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype     K线类别，取值范围：101|日线；102|周线；103|月线
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockKLine对象
     * @throws IOException
     */

    public String getWaihuiDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockKLine> getWaihuiDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getWaihuiDayKLine(code, ktype, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code   股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockBaseInfo对象
     * @throws IOException
     */

    public String getReitsBaseInfo(String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockBaseInfo> getReitsBaseInfo(String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getReitsBaseInfo(code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【其它->REITS->REITS列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param ktype     K线类别，取值范围：101|日线；102|周线；103|月线
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考StockKLine对象
     * @throws IOException
     */

    public String getReitsDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<StockKLine> getReitsDayKLine(String code, int ktype, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getReitsDayKLine(code, ktype, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code   股票代码，支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param fields 数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token  令牌，登录后可获取
     * @param filter 过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考QiHuoBaseInfo对象
     * @throws IOException
     */

    public String getQihuoBaseInfo(String code, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<QiHuoBaseInfo> getQihuoBaseInfo(String code, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getQihuoBaseInfo(code, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param code      股票代码，code参数可以从【其它->期货->期货列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考QiHuoKLine对象
     * @throws IOException
     */

    public String getQihuoDailyMarket(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<QiHuoKLine> getQihuoDailyMarket(String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getQihuoDailyMarket(code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

    /**
     * @param type      资产类型，取值范围：1|沪深京A股；2|沪深京B股；3|港股
     * @param code      股票代码，code参数可以从【通用接口->股票列表】接口中批量获取，也可以选择左上角菜单栏【浏览模式】查询数据；支持批量查询，用逗号分隔，每次最多50个；若为all，则表示全部，即可获取任意一天内的所有数据。
     * @param startDate 开始日期，yyyy-MM-dd格式，例如：2020-01-01
     * @param endDate   结束日期，yyyy-MM-dd格式，例如：2050-01-01
     * @param fields    数据字段，多个字段之间使用逗号分隔，若获取所有字段，则取值为all。
     * @param token     令牌，登录后可获取
     * @param filter    过滤参数，例如filter=open>=15。建议选择左上角菜单栏【浏览模式】操作数据
     * @return 参考TSStockPosition对象
     * @throws IOException
     */

    public String getTSStockPosition(int type, String code, String startDate, String endDate, String fields, String token, String filter, MethodType method, ExportType exportType) throws IOException {
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

    public List<TSStockPosition> getTSStockPosition(int type, String code, String startDate, String endDate, String fields, String token, String filter, MethodType method) throws IOException {
        String data = getTSStockPosition(type, code, startDate, endDate, fields, token, filter, method, ExportType.String_Json);
        return ExportTool.toObj(data, new TypeToken<List<StockBaseInfo>>() {
        }.getType());
    }

}
