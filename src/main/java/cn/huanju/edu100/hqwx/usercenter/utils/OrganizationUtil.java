package cn.huanju.edu100.hqwx.usercenter.utils;

import cn.huanju.edu100.hqwx.usercenter.enums.OrganizationEnum;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Description: 说明
 * @Author: xushengbin@hqwx.com
 * @Date: 2022-06-20
 */
public class OrganizationUtil {
    /**
     * 获取机构id
     * @return
     */
    public static Set<Long> getCommonOrgIdList() {
        Set<Long> resultSet = new HashSet();
        resultSet.add(OrganizationEnum.HuanQiu.OrgId());
        resultSet.add(OrganizationEnum.LiuXue100.OrgId());
        resultSet.add(OrganizationEnum.KaoTa.OrgId());
        resultSet.add(OrganizationEnum.SanLi.OrgId());
        resultSet.add(OrganizationEnum.ZiMa.OrgId());
        resultSet.add(OrganizationEnum.QingTeng.OrgId());
        resultSet.add(OrganizationEnum.GuoGuo.OrgId());
        resultSet.add(OrganizationEnum.LingHang.OrgId());
        resultSet.add(OrganizationEnum.KuangRen.OrgId());
        resultSet.add(OrganizationEnum.JianZhuJie.OrgId());
        resultSet.add(OrganizationEnum.OneGlobal.OrgId());
        resultSet.add(OrganizationEnum.ShengBenMao.OrgId());
        resultSet.add(OrganizationEnum.YunQiPei.OrgId());
        resultSet.add(OrganizationEnum.YiAn.OrgId());
        return resultSet;
    }

    /**
     * 获取父机构id
     * @return
     */
    public static Set<Long> getCommonTopOrgIdList() {
        Set<Long> resultSet = new HashSet();
        resultSet.add(OrganizationEnum.HuanQiu.TopOrgId());
        resultSet.add(OrganizationEnum.LiuXue100.TopOrgId());
        resultSet.add(OrganizationEnum.KaoTa.TopOrgId());
        resultSet.add(OrganizationEnum.SanLi.TopOrgId());
        resultSet.add(OrganizationEnum.ZiMa.TopOrgId());
        resultSet.add(OrganizationEnum.QingTeng.TopOrgId());
        resultSet.add(OrganizationEnum.GuoGuo.TopOrgId());
        resultSet.add(OrganizationEnum.LingHang.TopOrgId());
        resultSet.add(OrganizationEnum.KuangRen.TopOrgId());
        resultSet.add(OrganizationEnum.JianZhuJie.TopOrgId());
        resultSet.add(OrganizationEnum.OneGlobal.TopOrgId());
        resultSet.add(OrganizationEnum.ShengBenMao.TopOrgId());
        resultSet.add(OrganizationEnum.YunQiPei.TopOrgId());
        resultSet.add(OrganizationEnum.YiAn.TopOrgId());
        return resultSet;
    }

    /**
     * 获取父机构id
     * @return
     */
    public static Long getTopOrgIdByOrgId(Long orgId) {
        if(Objects.isNull(orgId) || orgId<=0) return null;

        if(OrganizationEnum.HuanQiu.OrgId().equals(orgId)){
            return OrganizationEnum.HuanQiu.TopOrgId();
        }
        else if(OrganizationEnum.LiuXue100.OrgId().equals(orgId)){
            return OrganizationEnum.LiuXue100.TopOrgId();
        }
        else if(OrganizationEnum.KaoTa.OrgId().equals(orgId)){
            return OrganizationEnum.KaoTa.TopOrgId();
        }
        else if(OrganizationEnum.SanLi.OrgId().equals(orgId)){
            return OrganizationEnum.SanLi.TopOrgId();
        }
        else if(OrganizationEnum.ZiMa.OrgId().equals(orgId)){
            return OrganizationEnum.ZiMa.TopOrgId();
        }
        else if(OrganizationEnum.QingTeng.OrgId().equals(orgId)){
            return OrganizationEnum.QingTeng.TopOrgId();
        }
        else if(OrganizationEnum.GuoGuo.OrgId().equals(orgId)){
            return OrganizationEnum.GuoGuo.TopOrgId();
        }
        else if(OrganizationEnum.LingHang.OrgId().equals(orgId)){
            return OrganizationEnum.LingHang.TopOrgId();
        }
        else if(OrganizationEnum.KuangRen.OrgId().equals(orgId)){
            return OrganizationEnum.KuangRen.TopOrgId();
        }
        else if(OrganizationEnum.JianZhuJie.OrgId().equals(orgId)){
            return OrganizationEnum.JianZhuJie.TopOrgId();
        }
        else if(OrganizationEnum.OneGlobal.OrgId().equals(orgId)){
            return OrganizationEnum.OneGlobal.TopOrgId();
        }
        else if(OrganizationEnum.ShengBenMao.OrgId().equals(orgId)){
            return OrganizationEnum.ShengBenMao.TopOrgId();
        }
        else if(OrganizationEnum.YunQiPei.OrgId().equals(orgId)){
            return OrganizationEnum.YunQiPei.TopOrgId();
        }
        else if(OrganizationEnum.YiAn.OrgId().equals(orgId)){
            return OrganizationEnum.YiAn.TopOrgId();
        }

        return null;
    }

}
