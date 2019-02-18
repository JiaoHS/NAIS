package com.nasi.portal.web.model;

import com.nasi.portal.data.model.CourseHomeWorkAssign;

public class AssignCommitVo extends CourseHomeWorkAssign{
    
    private static final long serialVersionUID = 4950552901848041851L;

    private boolean isCommited = false;
    
    private Long commitId = null;

    private Integer commitStatus = 0;
    
    private String scoreDesc = null;
    
    public Integer getCommitStatus() {
        return commitStatus;
    }

    public void setCommitStatus(Integer commitStatus) {
        this.commitStatus = commitStatus;
    }

    public String getScoreDesc() {
        return scoreDesc;
    }

    public void setScoreDesc(String scoreDesc) {
        this.scoreDesc = scoreDesc;
    }

    public boolean getIsCommited() {
        return isCommited;
    }

    public void setIsCommited(boolean isCommited) {
        this.isCommited = isCommited;
    }

    public Long getCommitId() {
        return commitId;
    }

    public void setCommitId(Long commitId) {
        this.commitId = commitId;
    }
    
    
}
