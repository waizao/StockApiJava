package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class ZhiShuChengFenGuZhongZhen implements Serializable {

   //指数代码
    private String code ;

   //指数名称
    private String name ;

   //股票名称
    private String stockname ;

   //股票代码
    private String stockcode ;

   //成分股权重
    private float weight ;

}

