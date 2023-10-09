package cn.huanju.edu100.hqwx.usercenter.model.api;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 用户考试意向信息
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-08-10
 */
public class SortIdInfoDTO implements Serializable {
    private Integer smarkCount;
    private String smarkSource;
    private String sortId; //分类ID (考试属性ID LessonId)
    private String uTime; //用户考试意向增加的时间 2017-06-13 15:12:29.954716

    @Override
    public String toString() {
        return "SortIdInfoDTO{" +
                "smarkCount=" + smarkCount +
                ", smarkSource='" + smarkSource + '\'' +
                ", sortId='" + sortId + '\'' +
                ", uTime=" + uTime +
                '}';
    }

    public Integer getSmarkCount() {
        return smarkCount;
    }

    public void setSmarkCount(Integer smarkCount) {
        this.smarkCount = smarkCount;
    }

    public String getSmarkSource() {
        return smarkSource;
    }

    public void setSmarkSource(String smarkSource) {
        this.smarkSource = smarkSource;
    }

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }

    public Date getuTimeDate(){
        if(this.uTime==null){
            return null;
        }

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSS");
        try {
            return sdf.parse(this.uTime);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getuTime() {
        return uTime;
    }

    public void setuTime(String uTime) {
        this.uTime = uTime;
    }
}
