#使用说明
##1.pom.xml 引入
```
<dependency>
    <groupId>cn.huanju.edu100</groupId>
    <artifactId>hqwx-usercenter</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```
##2.项目增加配置
```editorconfig
# 不配置将使用默认值
hquc:
  ucfg:
    app-id: 203                     # 用户中心接入配置
    app-key: tuQXM7BnIN2TirVP       # 用户中心接入配置
    platform: srv                   # 用户中心接入配置
    host-url: http://uapi.98809.com # 用户中心接口Host
  http:
    pool-size: 6             # 链接池大小，提高HttpClient的复用
    response-timeout: 20000  # 等待反馈超时，毫秒(ms)
    request-timeout: 10000   # 请求超时，毫秒(ms)
```
##3.业务服务调用
```java
@Resource
UserDataService userDataService;

public List<UserInfoMiniDTO> getUserInfoes(List<Long> uids, Long schId) {
    if (CollectionUtils.isEmpty(uids)) {
        return null;
    }

    HQUCResponse<List<UserInfoMiniDTO>> response = userDataService.getUserInfoMiniByIds(uids, schId);
    if (!response.isOk()) {
        System.out.println(response.toString());
        return null;
    }

    return response.getData();
}
```

#测试
```text
1.接口测试（class Test_ApiUnit）
  执行: Test_ApiUnit.testApi

2.压测（class Test_Stress）
  设置Thread_Count线程数
  执行: Test_Stress.testStress
  结果:并发线程100, HttpClient管理连接池大小6, 请求无异常
```
#编译提交
```
mvn clean package deploy -Dmaven.test.skip=true
```