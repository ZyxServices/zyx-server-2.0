package com.zyx.mapper.system;

import com.zyx.entity.system.City;
import com.zyx.mapper.BaseMapper;
import com.zyx.vo.system.CityVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rainbow
 *
 * @author SubDong
 * @version V2.0
 *          Copyright (c)2016 zyx-版权所有
 * @since 2016/11/10
 */
@Repository("systemCityMapper")
public interface SystemCityMapper extends BaseMapper<City> {

    /**
     * 查询热门城市
     * @return
     */
    List<CityVo> findHotCity();
}
