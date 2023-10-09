package cn.huanju.edu100.hqwx.usercenter.enums;

/**
 * @Description: 说明
 * @Author: xushengbin@hqwx.com
 * @Date: 2022-06-20
 */
public enum OrganizationEnum {
    //机构
    HuanQiu(2L, 14L, "环球网校"),
    LiuXue100(3L, 15L, "100YY留学"),
    KaoTa(28L, 27L, "靠他学"),
    SanLi(32L, 31L, "三立网校"),
    ZiMa(50L, 49L, "芝麻工学院"),
    QingTeng(94L, 93L, "青藤网校"),
    GuoGuo(96L, 95L, "果果教育"),
    LingHang(98L, 97L, "领航教育"),
    KuangRen(100L, 99L, "狂人学院"),
    JianZhuJie(1100L, 1100L, "建筑界"),
    OneGlobal(1300L, 1299L, "OneGlobalSchool"),
    YunQiPei(1304L, 1303L, "云企培"),
    ShengBenMao(1306L, 1305L, "升本猫"),
    YiAn(1308L, 1307L, "益安教育"),
    ;

    private Long orgId;
    private Long parOrgId;
    private String explain;

    //机构
    public Long OrgId() {
        return this.orgId;
    }

    //父机构
    public Long TopOrgId() {
        return this.parOrgId;
    }

    //说明
    public String Explain() {
        return this.explain;
    }

    @Override
    public String toString() {
        return "OrganizationEnum{" +
                "orgId=" + this.orgId +
                ", parOrgId=" + this.parOrgId +
                ", explain='" + this.explain + '\'' +
                '}';
    }

    OrganizationEnum(Long orgId, Long parOrgId, String explain) {
        this.orgId = orgId;
        this.parOrgId = parOrgId;
        this.explain = explain;
    }
}
