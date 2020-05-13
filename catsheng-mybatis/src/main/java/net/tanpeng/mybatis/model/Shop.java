package net.tanpeng.mybatis.model;

import lombok.*;

import java.util.Date;

/**
 * Created by peng.tan on 2020/1/27.
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Shop {
    private int id;
    private long shopId;
    private long shopOid;
    private int shardid;
    private boolean isDelete;
    private Date createdTime;
    private Date updatedTime;

    public int getShardid() {
        return shardid;
    }
}
