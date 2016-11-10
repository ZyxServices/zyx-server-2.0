package com.zyx.entity.system;

import com.zyx.entity.BaseEntity;

import javax.persistence.Table;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.entity.zoom
 * Create by XiaoWei on 2016/6/27
 */
@Table(name = "reply")
public class Reply extends BaseEntity {
    private Integer replyParentId;//回复父级，如果reply_type为1，则该字段为comment表id，则表示对评论进行回复，如果为2则为回复id，则表示对回复进行回复
    private Integer replyFromUser;//回复人
    private Integer replyToUser;//被回复人
    private String replyContent;
    private Integer replyState;//回复状态，0：公开回复
    private String replyImgPath;//回复

    public Integer getReplyParentId() {
        return replyParentId;
    }

    public void setReplyParentId(Integer replyParentId) {
        this.replyParentId = replyParentId;
    }


    public Integer getReplyFromUser() {
        return replyFromUser;
    }

    public void setReplyFromUser(Integer replyFromUser) {
        this.replyFromUser = replyFromUser;
    }

    public Integer getReplyToUser() {
        return replyToUser;
    }

    public void setReplyToUser(Integer replyToUser) {
        this.replyToUser = replyToUser;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Integer getReplyState() {
        return replyState;
    }

    public void setReplyState(Integer replyState) {
        this.replyState = replyState;
    }

    public String getReplyImgPath() {
        return replyImgPath;
    }

    public void setReplyImgPath(String replyImgPath) {
        this.replyImgPath = replyImgPath;
    }
}