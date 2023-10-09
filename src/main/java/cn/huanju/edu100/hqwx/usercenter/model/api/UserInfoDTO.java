package cn.huanju.edu100.hqwx.usercenter.model.api;

import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Map;

/**
 * @Description: 说明
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-08-06
 */
public class UserInfoDTO implements Serializable {
    private String applyPlace; //报考省市
    private String birthday; //用户生日
    private Integer chId; //合作网站标识WebId
    private String city; //用户归属市
    private String education; //学历
    private String email; //用户邮箱
    private String faceUrl; //头像URL地址
    private Integer firstPType;//首次访问产品 SourceZt
    private String fromSite; //用户来源
    private String homePlace; //户籍所在省市
    private String idCard; //身份证号码
    private Integer isMobileVerified; //当为1时,才是绑定了手机号码
    private String keyWord; //SEO\SEM搜索关键字
    private Integer lastPType; //末次访问产品 lastPType
    private String lastUrl;//lasturl
    private String md5Phone; //手机号码,只有当用户手机号码已经绑定后，才会填写
    private String name; //用户真实性
    private String nickName; //用户昵称
    private Integer orgId; //用户注册时所在的机构
    private String phone; //手机号码,只有当用户手机号码已经绑定后，才会填写
    private String position; //职业
    private String province; //用户归属省
    private String refUrl; //RefUrl
    private String regAppid; //注册时的APPID
    private String regIp; //注册IP
    private String regPlatform; //注册时的Platform
    private String regTime; //用户注册时间,如果没有,则取系统时间(date-time)
    private String regUrl; //注册前的URL
    private Integer sex; //用户性别 0-未知 1-男 2-女
    private String sexString; //用户性别字符串格式
    private String shareKey; //分享KEY
    private String sortId; //分类ID (考试属性ID LessonId)
    private Integer srcType; //用户流量来源SourceType
    private Map<String, Object> thirdAddInfo; //与source同时存在时才有用.用户的第三方资料
    private Integer topOrg; //用户所在一级机构的ID
    private String traceInfo; //请求附加信息,URL编码, 目前有said=xxxxxxx
    private Long uid; //用户UID
    private Integer uMode; //用户密码状态,默认为普通模式 1:普通模式　2或者其它:排障模式
    private String uName; //用户名
    private Integer uStatus; // 用户状态，为int取值
    private String weekLearnDuration; //每周学习时长
    private Long unionId; //平台统一Id

    /**
     * 获取显示名称 昵称 -> 用户名
     * @return
     */
    public String getShowName() {
        return !StringUtils.isEmpty(this.nickName) ? this.nickName : this.uName;
    }


    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "applyPlace='" + applyPlace + '\'' +
                ", birthday='" + birthday + '\'' +
                ", chId=" + chId +
                ", city='" + city + '\'' +
                ", education='" + education + '\'' +
                ", email='" + email + '\'' +
                ", faceUrl='" + faceUrl + '\'' +
                ", firstPType=" + firstPType +
                ", fromSite='" + fromSite + '\'' +
                ", homePlace='" + homePlace + '\'' +
                ", idCard='" + idCard + '\'' +
                ", isMobileVerified=" + isMobileVerified +
                ", keyWord='" + keyWord + '\'' +
                ", lastPType=" + lastPType +
                ", lastUrl='" + lastUrl + '\'' +
                ", md5Phone='" + md5Phone + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", orgId=" + orgId +
                ", phone='" + phone + '\'' +
                ", position='" + position + '\'' +
                ", province='" + province + '\'' +
                ", refUrl='" + refUrl + '\'' +
                ", regAppid='" + regAppid + '\'' +
                ", regIp='" + regIp + '\'' +
                ", regPlatform='" + regPlatform + '\'' +
                ", regTime='" + regTime + '\'' +
                ", regUrl='" + regUrl + '\'' +
                ", sex=" + sex +
                ", sexString='" + sexString + '\'' +
                ", shareKey='" + shareKey + '\'' +
                ", sortId='" + sortId + '\'' +
                ", srcType=" + srcType +
                ", thirdAddInfo=" + thirdAddInfo +
                ", topOrg=" + topOrg +
                ", traceInfo='" + traceInfo + '\'' +
                ", uid=" + uid +
                ", uMode=" + uMode +
                ", uName='" + uName + '\'' +
                ", uStatus=" + uStatus +
                ", weekLearnDuration='" + weekLearnDuration + '\'' +
                ", unionId='" + unionId + '\'' +
                '}';
    }

    public String getApplyPlace() {
        return applyPlace;
    }

    public void setApplyPlace(String applyPlace) {
        this.applyPlace = applyPlace;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getChId() {
        return chId;
    }

    public void setChId(Integer chId) {
        this.chId = chId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public Integer getFirstPType() {
        return firstPType;
    }

    public void setFirstPType(Integer firstPType) {
        this.firstPType = firstPType;
    }

    public String getFromSite() {
        return fromSite;
    }

    public void setFromSite(String fromSite) {
        this.fromSite = fromSite;
    }

    public String getHomePlace() {
        return homePlace;
    }

    public void setHomePlace(String homePlace) {
        this.homePlace = homePlace;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getIsMobileVerified() {
        return isMobileVerified;
    }

    public void setIsMobileVerified(Integer isMobileVerified) {
        this.isMobileVerified = isMobileVerified;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Integer getLastPType() {
        return lastPType;
    }

    public void setLastPType(Integer lastPType) {
        this.lastPType = lastPType;
    }

    public String getLastUrl() {
        return lastUrl;
    }

    public void setLastUrl(String lastUrl) {
        this.lastUrl = lastUrl;
    }

    public String getMd5Phone() {
        return md5Phone;
    }

    public void setMd5Phone(String md5Phone) {
        this.md5Phone = md5Phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getRefUrl() {
        return refUrl;
    }

    public void setRefUrl(String refUrl) {
        this.refUrl = refUrl;
    }

    public String getRegAppid() {
        return regAppid;
    }

    public void setRegAppid(String regAppid) {
        this.regAppid = regAppid;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

    public String getRegPlatform() {
        return regPlatform;
    }

    public void setRegPlatform(String regPlatform) {
        this.regPlatform = regPlatform;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public String getRegUrl() {
        return regUrl;
    }

    public void setRegUrl(String regUrl) {
        this.regUrl = regUrl;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSexString() {
        return sexString;
    }

    public void setSexString(String sexString) {
        this.sexString = sexString;
    }

    public String getShareKey() {
        return shareKey;
    }

    public void setShareKey(String shareKey) {
        this.shareKey = shareKey;
    }

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }

    public Integer getSrcType() {
        return srcType;
    }

    public void setSrcType(Integer srcType) {
        this.srcType = srcType;
    }

    public Map<String, Object> getThirdAddInfo() {
        return thirdAddInfo;
    }

    public void setThirdAddInfo(Map<String, Object> thirdAddInfo) {
        this.thirdAddInfo = thirdAddInfo;
    }

    public Integer getTopOrg() {
        return topOrg;
    }

    public void setTopOrg(Integer topOrg) {
        this.topOrg = topOrg;
    }

    public String getTraceInfo() {
        return traceInfo;
    }

    public void setTraceInfo(String traceInfo) {
        this.traceInfo = traceInfo;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Integer getuMode() {
        return uMode;
    }

    public void setuMode(Integer uMode) {
        this.uMode = uMode;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Integer getuStatus() {
        return uStatus;
    }

    public void setuStatus(Integer uStatus) {
        this.uStatus = uStatus;
    }

    public String getWeekLearnDuration() {
        return weekLearnDuration;
    }

    public void setWeekLearnDuration(String weekLearnDuration) {
        this.weekLearnDuration = weekLearnDuration;
    }

    public Long getUnionId() {
        return unionId;
    }

    public void setUnionId(Long unionId) {
        this.unionId = unionId;
    }
}
