package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class QiHuoBaseInfo implements Serializable {

   //交易所代码
    private int jyscode ;

   //交易所名称
    private String jysname ;

   //品种代码
    private String pzcode ;

   //合约代码
    private String code ;

   //合约名称
    private String name ;

}

