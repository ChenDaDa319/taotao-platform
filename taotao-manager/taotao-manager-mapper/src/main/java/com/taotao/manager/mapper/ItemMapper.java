package com.taotao.manager.mapper;

import com.github.abel533.mapper.Mapper;
import com.taotao.manager.model.Item;

public interface ItemMapper extends Mapper<Item>{

    /**
     * 添加商品
     * @param item
     * @return
     */
    int addItem(Item item);
}
