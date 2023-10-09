package cn.huanju.edu100.hqwx.usercenter.model.api;

import java.io.Serializable;
import java.util.Map;

/**
 * @Description: ThirdLoginRequestDTO
 * @Author: xushengbin@hqwx.com
 * @Date: 2023-01-16
 * @Ver: v1.0 -create
 */
public class ThirdLoginRequestDTO implements Serializable {
    private String appId; //必填 业务模块定义（登录真实来源）
    private String openId; //必填 第三方提供的OpenId 此值可以与服务端沟通配置在openToken验证时取数。建议由对端直接上传
    private Integer source; //必填 第三方来源
    private Integer srcType; //用户流量来源SourceType
    private String sha1Pwd; //必填 用户密码Sha1
    private String shareKey; //用户注册时的附加信息KEY
    private String srvName; //必填 当为微信绑定时,需要提供此信息.推荐填写微信服务号APPID. 可以用户标识不同的服务号等信息,非微信时,建议与OpenID相同.
    private String appVer; //App版本
    private Integer chId; //合作网站标识WebId
    private String city; //用户归属市,如果没有,则会根据上面的手机号码查询一个数据出来
    private String clientIp; //客户端的IP地址
    private String codeString; //图形验证码字符串
    private String deviceId; //用户登录的当前设备ID
    private String deviceInfo; //用户登录的当前设备信息
    private String email; //用户邮箱
    private String emailCode; //用户收到的邮箱验证码
    private Map<String, String> extProperties; // 扩展属性
    private String faceUrl; //头像地址
    private Integer firstPType; //首次访问产品 SourceZt
    private String firstUrl; //FirstUrl
    private String fromSite; //用户来源
    private String keyWord; //SEO/SEM搜索关键字
    private Integer lastPType; //末次访问产品
    private String lastUrl; //LastUrl
    private String loginIp; //用户登录时的IP地址
    private String loginUrl; //用户登录前访问的URL
    private Integer loginWay; //登录方式：1:微信扫码
    private String model; //Model
    private String name; //用户真实姓名
    private String nickName; //用户的昵称
    private String oldSortId; //旧的sortid 映射至新的sortid
    private String optUser; //操作人员的用户名 后台操作需要传入
    private String phone; //uName/phone/email三选一或uname/phone/email同时存在|手机号码
    private String platform; //平台终端定义（登录真实来源）
    private String province; //用户归属省,如果没有,则会根据上面的手机号码查询一个数据出来
    private String refUrl; //注册前一跳的页面地址
    private String regIp; //注册IP
    private String regTime; //用户注册时间,如果没有,则取系统时间
    private String regUrl; //注册前的URL
    private  Integer sex; //用户性别
    private String smsCode; //短信验证码
    private String sortId; //分类ID (考试属性ID LessonId),有多个考试意向时可以使用,分隔
    private String traceInfo; //户附加属性信息,URL编码,如:a=xxx&b=yyy&ccc=zzz
    private String trafficUuid; //渠道追踪id
    private Long uid; //可选参数,如果有,则以此数据为用户的UID.
    private String uname; //uName/phone/email三选一或uname/phone/email同时存在|用户名
    private String verifyCode; //图形验证码

    public ThirdLoginRequestDTO() {
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppVer() {
        return appVer;
    }

    public void setAppVer(String appVer) {
        this.appVer = appVer;
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

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getCodeString() {
        return codeString;
    }

    public void setCodeString(String codeString) {
        this.codeString = codeString;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }

    public Map<String, String> getExtProperties() {
        return extProperties;
    }

    public void setExtProperties(Map<String, String> extProperties) {
        this.extProperties = extProperties;
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

    public String getFirstUrl() {
        return firstUrl;
    }

    public void setFirstUrl(String firstUrl) {
        this.firstUrl = firstUrl;
    }

    public String getFromSite() {
        return fromSite;
    }

    public void setFromSite(String fromSite) {
        this.fromSite = fromSite;
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

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public Integer getLoginWay() {
        return loginWay;
    }

    public void setLoginWay(Integer loginWay) {
        this.loginWay = loginWay;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public String getOldSortId() {
        return oldSortId;
    }

    public void setOldSortId(String oldSortId) {
        this.oldSortId = oldSortId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getOptUser() {
        return optUser;
    }

    public void setOptUser(String optUser) {
        this.optUser = optUser;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
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

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp;
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

    public String getSha1Pwd() {
        return sha1Pwd;
    }

    public void setSha1Pwd(String sha1Pwd) {
        this.sha1Pwd = sha1Pwd;
    }

    public String getShareKey() {
        return shareKey;
    }

    public void setShareKey(String shareKey) {
        this.shareKey = shareKey;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getSrcType() {
        return srcType;
    }

    public void setSrcType(Integer srcType) {
        this.srcType = srcType;
    }

    public String getSrvName() {
        return srvName;
    }

    public void setSrvName(String srvName) {
        this.srvName = srvName;
    }

    public String getTraceInfo() {
        return traceInfo;
    }

    public void setTraceInfo(String traceInfo) {
        this.traceInfo = traceInfo;
    }

    public String getTrafficUuid() {
        return trafficUuid;
    }

    public void setTrafficUuid(String trafficUuid) {
        this.trafficUuid = trafficUuid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
