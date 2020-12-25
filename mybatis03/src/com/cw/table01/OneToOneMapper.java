package com.cw.table01;

import com.cw.bean.Card;

import java.util.List;

/**
 * @author 陈小哥cw
 * @date 2020/12/24 14:26
 * 一个身份证号对应一个人
 */
public interface OneToOneMapper {
    // 查询全部
    public abstract List<Card> selectAll();
}
