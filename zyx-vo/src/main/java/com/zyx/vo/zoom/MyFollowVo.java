package com.zyx.vo.zoom;


//import com.zyx.entity.activity.PageViews;
import com.zyx.entity.zoom.Concern;
import com.zyx.vo.account.UserIconVo;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.entity.zoom.dto
 * Create by XiaoWei on 2016/8/15
 */
public class MyFollowVo extends Concern {
    UserIconVo userIconVo;
    private Integer zanCounts;
    private Integer commentCounts;
    UserAuthVo userAuthVo;
    Integer isFollow;
//    PageViews pageViews;

    public Integer getZanCounts() {
        return zanCounts;
    }

    public void setZanCounts(Integer zanCounts) {
        this.zanCounts = zanCounts;
    }

    public Integer getCommentCounts() {
        return commentCounts;
    }

    public void setCommentCounts(Integer commentCounts) {
        this.commentCounts = commentCounts;
    }


    public UserIconVo getUserIconVo() {
        return userIconVo;
    }

    public void setUserIconVo(UserIconVo userIconVo) {
        this.userIconVo = userIconVo;
    }

    public UserAuthVo getUserAuthVo() {
        return userAuthVo;
    }

    public void setUserAuthVo(UserAuthVo userAuthVo) {
        this.userAuthVo = userAuthVo;
    }

    public Integer getIsFollow() {
        return isFollow;
    }

    public void setIsFollow(Integer isFollow) {
        this.isFollow = isFollow;
    }

    //    public PageViews getPageViews() {
//        return pageViews;
//    }
//
//    public void setPageViews(PageViews pageViews) {
//        this.pageViews = pageViews;
//    }
}
