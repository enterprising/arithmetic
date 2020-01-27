package net.tanpeng.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by peng.tan on 2020/1/27.
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop {
    private int id;
    private long shopId;
    private long shopOid;
    private int shardid;
    private boolean isDelete;
    private Date createdTime;
    private Date updatedTime;
}
