package cn.huanju.edu100.hqwx.usercenter.enums;

/**
 * @Description: ThirdSourceEnum
 * @Author: xushengbin@hqwx.com
 * @Date: 2023-01-16
 * @Ver: v1.0 -create
 */
public enum ThirdSourceEnum {
    //第三方 来源
    WxUnionId(8,"微信UnionId (用户和应用所有者共同生成的唯一id)"),
    WxOpenId(9,"微信OpenId (用户和应用共同生成的唯一id)"),
    ;

    public Integer Type() {
        return type;
    }

    public String Desc() {
        return desc;
    }

    private final Integer type;
    private final String desc;

    ThirdSourceEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
