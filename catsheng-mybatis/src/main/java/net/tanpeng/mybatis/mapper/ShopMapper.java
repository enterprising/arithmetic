package net.tanpeng.mybatis.mapper;

import net.tanpeng.mybatis.model.Shop;

/**
 * Created by peng.tan on 2020/1/27.
 */
public interface ShopMapper {
    Shop selectByid(Long id);
}
