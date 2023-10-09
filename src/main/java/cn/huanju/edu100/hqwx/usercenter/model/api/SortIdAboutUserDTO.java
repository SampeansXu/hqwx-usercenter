package cn.huanju.edu100.hqwx.usercenter.model.api;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 用户感兴趣的考试, 浏览过的考试和考试意向
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-08-11
 */
public class SortIdAboutUserDTO implements Serializable {
    List<Long> browsedList; //浏览过的考试Id列表
    List<Long> intentionList; //意向的考试Id列表
    List<Long> interestedList; //感兴趣的考试Id列表


    @Override
    public String toString() {
        return "SortIdAboutUser{" +
                "browsedList=" + browsedList +
                ", intentionList=" + intentionList +
                ", interestedList=" + interestedList +
                '}';
    }

    public List<Long> getBrowsedList() {
        return browsedList;
    }

    public void setBrowsedList(List<Long> browsedList) {
        this.browsedList = browsedList;
    }

    public List<Long> getIntentionList() {
        return intentionList;
    }

    public void setIntentionList(List<Long> intentionList) {
        this.intentionList = intentionList;
    }

    public List<Long> getInterestedList() {
        return interestedList;
    }

    public void setInterestedList(List<Long> interestedList) {
        this.interestedList = interestedList;
    }
}
