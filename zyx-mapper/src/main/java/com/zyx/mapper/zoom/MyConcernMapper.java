package com.zyx.mapper.zoom;

import com.zyx.entity.zoom.MyConcern;
import com.zyx.mapper.BaseMapper;
import com.zyx.vo.zoom.MyConcernVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.mapper.zoom
 * Create by XiaoWei on 2016/6/20
 */
@Repository("myConcernMapper")
public interface MyConcernMapper extends BaseMapper<MyConcern> {
    Integer getCounts(@Param(value = "concernType") Integer concernType, @Param(value = "concernId") Integer concernId);

    MyConcern existConcern(@Param(value = "accountId") Integer accountId, @Param(value = "concernId") Integer concernId, @Param(value = "concernType") Integer concernType);

    List<MyConcernVo> findByParams(@Param("concernId") Integer concernId, @Param("concernType") Integer concernType, @Param("keyWord") String keyWord);

    Integer delMyConcern(@Param("id") Integer concernId);
}
