package com.owner.core.base;

import org.apache.poi.ss.formula.functions.T;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.RowBoundsMapper;
import tk.mybatis.mapper.common.rowbounds.SelectByConditionRowBoundsMapper;

public interface BaseMapper<T> extends tk.mybatis.mapper.common.BaseMapper<T>, ConditionMapper<T>,
MySqlMapper<T>, SelectByConditionRowBoundsMapper<T>, RowBoundsMapper<T> {

}
