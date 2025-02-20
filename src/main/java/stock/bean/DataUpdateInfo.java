package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataUpdateInfo implements Serializable {

   //数据标识ID
    private String id ;

   //数据更新时间
    private String updateDate ;

   //数据描述
    private String comment ;

}

