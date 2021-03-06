package com.zyx.service.zoom;

import com.zyx.entity.system.Zan;
import com.zyx.service.BaseService;
import com.zyx.vo.system.ZanCountVo;

import java.util.List;
import java.util.Map;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.zoom
 * Create by XiaoWei on 2016/6/17
 */
public interface ZanService extends BaseService<Zan> {
    Map<String,Object> addZan(Integer body_id, Integer body_type, Integer account_id);

    /**
     * 通过BodyId 查询多个点赞数量
     * MrDeng
     * @param type
     * @param bodyIds
     * @return
     */
    List<ZanCountVo> countZanByBodyId(Integer type, List<Integer> bodyIds);

    /**
     * 重载
     * @param type
     * @param bodyId
     * @return
     */
    ZanCountVo countZanByBodyId(Integer type, Integer bodyId);
}
