# 歪枣网

<p align=center>
  <a href="http://www.waizaowang.com/">
    <img src="./doc/images/waizaowang.png" alt="财经数据接口" style="width:260px;height:120px">
  </a>
</p>

<p align=center>
   歪枣网，提供全面、准确、稳定的财经数据
</p>

## 前言

本人80后理工科程序猿一枚，2015年初随波入流，进入股市。到目前为止，总收益仍有亏损，但股市虐我千百遍，我待股市如初恋。
理想很丰满，现实很骨干。也许在股市这条道路上不会顺畅，但我会坚持。<br>
我不是专家、不是财经达人，我只是千千万万散户中的一位。我会用文字来记录我对股市的理解，记录我增长的理财知识，记录一位普通的小散在股市中的成长经历。
我会定期更新我建立的投资体系、近期积累的金融知识、股市投资的持仓盈亏等，不断成长，与诸位共勉。<br>
一些指数类的ETF，尤其是像创业板、沪深300这类宽基指数，波动相对稳定，存在一定周期性，挖掘财经数据是存在一定价值的，这是歪哥相信的，也是一直在探索的。<br>

## 项目介绍

歪枣网终于和大家见面了，非常感谢有大家的一路支持！<br>
歪枣网提供的财经数据下载接口，主要用于财经研究，解决大家在财经研究中数据获取的问题。<br>
通过歪枣网，能快速获取沪深股票、港股、大盘指数、基金净值、基金排行等财经数据，财经接口将提供Txt、Gson、Csv文件等多种数据形式，方便分析人员快速分析数据。<br>
力求给大家提供更高效、全面、稳定的财经数据服务，让大家不用再担心财经数据源，专心进行策略研究，提升投资收益。<br>
希望歪枣网提供的财经数据接口能给大家在投资上带来些许方便，在探索财富奥秘、追求财富自由的道路上，也希望有大家相伴。

## 财经数据

采集数据范围包括沪深京A股、沪深京B股、港股、美股、黄金、汇率、Reits、沪深指数、香港指数、全球指数、债券指数、场内基金、沪深债券、行业板块、概念板块、地域板块等范围列表。<br>
其中行业数据包括行业板块、概念板块、地域板块；场内基金包括ETF基金和LOF基金。<br>
主要数据包括：<br>

- 股票分钟数据，包括一分钟数据
- 股票时线数据，包括5分钟、15分钟、30分钟、60分钟数据。
- 股票日线数据，包括日线、周线、月线数据
- 成分股数据，包括行业板块成分股、主要指数成分股数据。
- 每日行情数据，每天股票各种指标数据采集，内盘、外盘、资金流向等
- 分时成交Level2数据
- 实时数据，提供交易日当天实时交易数据<br>
  更多数据请访问网站：[歪枣网](http://www.waizaowang.com/)

历史分钟数据下载地址  
为了降低服务器压力，将历史股票K线数据按一分钟、五分钟、十五分钟、三十分钟、六十分钟为粒度，上传到了百度网盘。打开可以自由下载。
链接：https://pan.baidu.com/s/1JrIFmzPmiVYehRSqctfNdA
提取码：vdes

## 项目特点

主要功能包括:<br>
1、选择模式，网站左上角菜单栏可以选择模式，包括文档模式、浏览模式、图表模式。

- 文档模式：提供接口十分详细的说明文档，详细展示了接口的入参、出参，包括字段的含义以及相关说明。
- 浏览模式：提供可视化获取数据的操作界面，用户获取数据完全可以在界面上操作，并且根据用户的操作，在页面下方可以实时生成获取数据的代码。
- 图表模式：提供股票数据的绘图功能，包括生成曲线图和柱状图。

2、支持过滤条件，可以灵活的设置过滤条件，定制返回数据，不需要用户二次开发去过滤数据。 <br>
3、接口搜索，展示所有接口信息，可以使用 Ctrl+F 快捷键，搜索你所需要的数据字段。<br>
4、支持的请求类型，支持GET方法和POST方法，且两种请求方式的路径和入参均相同。<br>
5、接口更新信息，包括接口更新周期、接口最后更新时间、接口更新耗时会在页面上更新。<br><br>
![image](./doc/images/apiOne.png)
![image](./doc/images/apiTwo.png)
![image](./doc/images/apiThree.png)

## 项目地址

目前项目托管在 Gitee 和 Github 平台上中，欢迎大家 Star 和 Fork 支持~ <br>

### Java SDK :

Gitee地址：https://gitee.com/waizao/StockApiJava <br>
Github地址：https://github.com/waizao/StockApiJava <br>

#### 初始化:

``` maven
<dependency>
    <groupId>io.gitee.waizao</groupId>
    <artifactId>openapi</artifactId>
    <version>1.1.4</version>
</dependency>
```

### Python SDK:

Gitee地址：https://gitee.com/waizao/StockApiPython <br>
Github地址：:https://github.com/waizao/StockApiPython <br>

#### 初始化:

```shell
pip install waizao -i http://mirrors.aliyun.com/pypi/simple/ --trusted-host=mirrors.aliyun.com  --upgrade
```

## 关注&交流

为了方便小伙伴们沟通交流，创建了QQ群 (加群备注：歪枣网)
，目前项目还存在很多不足之处，欢迎各位大佬进群进行交流，为了防止广告进入，希望加群的时候能添加备注，谢谢~<br>
如遇问题联系作者，邮箱：waizaowang@163.com <br>
[网站说明文档](https://ccn9lag3l54q.feishu.cn/wiki/KxFlwcXzhi4WRVkCAN4cnyhennb)<br>

| QQ群【推荐】                                                                                  |
|------------------------------------------------------------------------------------------|
| <img src="./doc/images/qqGroup.png" width="200"  height="200" /> |






