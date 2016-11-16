package com.zyx.rpc.system.impl;

import com.zyx.constants.Constants;
import com.zyx.param.system.SearchParam;
import com.zyx.rpc.system.SearchFacade;
import com.zyx.service.system.SearchService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Rainbow
 *
 * @author SubDong
 * @version V2.0
 *          Copyright (c)2016 zyx-版权所有
 * @since 2016/11/15
 */
@Service("searchFacade")
public class SearchFacadeImpl implements SearchFacade {

    @Resource
    private SearchService searchService;

    private static Logger logger = Logger.getLogger(SearchFacadeImpl.class);


    @Override
    public Map<String, Object> modularSearch(SearchParam searchParam) {
        try {
            return searchService.modularSearch(searchParam);
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
            return Constants.MAP_500;
        }
    }
}
