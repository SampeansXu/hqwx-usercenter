package cn.huanju.edu100.hqwx.usercenter;

import cn.huanju.edu100.hqwx.usercenter.api.*;
import cn.huanju.edu100.hqwx.usercenter.config.HQWXUsercenterConfig;
import cn.huanju.edu100.hqwx.usercenter.constant.UserCenterConstant;
import cn.huanju.edu100.hqwx.usercenter.enums.ThirdSourceEnum;
import cn.huanju.edu100.hqwx.usercenter.model.api.*;
import cn.huanju.edu100.hqwx.usercenter.service.impl.*;
import cn.huanju.edu100.hqwx.usercenter.utils.OrganizationUtil;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        HQWXUsercenterConfig.class,
        UserDataServiceImpl.class,
        UserLoginServiceImpl.class,
        UCTokenServiceImpl.class,
        RegisterServiceImpl.class,
        UCOtherServiceImpl.class,
        HttpClientHelper.class
})
class Test_ApiUnit {

    @Resource
    UserDataService userDataService;
    @Resource
    UserLoginService userLoginService;
    @Resource
    UCTokenService ucTokenService;
    @Resource
    RegisterService registerService;
    @Resource
    UCOtherService ucOtherService;

    @Test
    void testLogin() {
        userDataService.updateUserBindPhoneByAdmin(230117607L,1308L,"11012345678",1);
        HQUCResponse<AuthTokenDTO> hqucTest = ucTokenService.authToken(2L, "test");

        HQUCResponse<LoginResponseDTO> response = userLoginService.loginByPhone("11020180002", "123456", 94L, null);
        String token = response.getData().getToken();
        token = "343f6c6c2c1b7b57c00a94c356e325789d6af6a16674671fb278d970dd06f8475cbcc240becd59bdd7aaee27bcd52fc3799d98472837d64717ae7479fe0dc0e7e37c6620b64c3746a83337b36668340002";
        System.out.println("--> getSortIdAboutUser: " +
                (userDataService.getUserSortIdDetail(184229251L, 94L, token)).toString());
        System.out.println("--> getSortIdAboutUser: " +
                (userDataService.getSortIdAboutUser(184229251L, 94L, token)).toString());
        HQUCResponse<AuthTokenDTO> hqucResponse = ucTokenService.authToken(94L, token);
        HQUCResponse<SendSmsCodeDTO> sendSmsCodeDTOHQUCResponse =
                ucOtherService.sendSmsCode("11805218525", UserCenterConstant.SendSmsOpt.Register, 94L);
        HQUCResponse<RegisterResponseDTO> registerResponseDTO =
                registerService.register("1234567890123", "021691", "123456", "Test_nk", 94L);


        HQUCResponse<RegisterResponseDTO> registerResponseDTOHQUCResponse = registerService.internalRegister(
                "TestX_22020180003", "123456", "nk03_这是昵称", 94L);

        userLoginService.changePasswordByUName("TestX_22020180002", "12345678", 94L);
        userLoginService.loginByUName("TestX_22020180002", "12345678", 94L, null);

        Date Start_Date = new Date(2014 - 1900, (1 - 1), 1, 0, 0, 0);
        long time = Start_Date.getTime();

        UserInfoMiniDTO newUser = new UserInfoMiniDTO();
        newUser.setName("Test");
        newUser.setSex(1);
//        newUser.setNickName("Test_nick");
        newUser.setFaceUrl("http://image001.jpg");
        userDataService.updateUserInfoMini(response.getData().getUid(), 94L, newUser, token);

        HQUCResponse<AuthTokenDTO> authTokenDTOHQUCResponse = ucTokenService.authToken(94L, token);

        List<Long> sortIds = Lists.newArrayList();
        sortIds.add(11460L);
        sortIds.add(8499L);
        HQUCResponse<Object> objectHQUCResponse = userDataService.updateUserSortId(response.getData().getUid(), response.getData().getOrgId().longValue(), sortIds, token);
    }

    @Test
    void testApi() {
        HQUCResponse<UserInfoDTO> userInfoByPhone = userDataService.getUserInfoByPhone("18809089913", OrganizationUtil.getCommonOrgIdList(), null);
        System.out.println(userInfoByPhone.toString());
        Map<String, Object> extParam = new HashMap<>();
        //extParam.put("optUser","web_php");
        extParam.put("source", ThirdSourceEnum.WxUnionId.Type());
        System.out.println("--> getUserInfoById: " +
                (userDataService.getUserInfoById(190185780L, OrganizationUtil.getCommonTopOrgIdList(), extParam)).toString());

        System.out.println("--> getThirdUserInfoById: " +
                (userDataService.getThirdUserInfoById(230133410L, OrganizationUtil.getCommonTopOrgIdList())).toString());

        System.out.println("--> getUserInfoByPhone: " +
                (userDataService.getUserPhone(Arrays.asList(184229251L), 94L)).toString());

        UserInfoMiniDTO userInfoMiniDTO = new UserInfoMiniDTO();
        userInfoMiniDTO.setFaceUrl("http://4534636.jpg");
        userInfoMiniDTO.setNickName("就是这么帅");
        userDataService.updateUserInfoMiniByAdmin(3L, 94L, userInfoMiniDTO);
        System.out.println("--> getUserInfoById: " +
                (userDataService.getUserInfoById(3L, 94L)).toString());

        System.out.println("--> getUserInfoByPhone: " +
                (userDataService.getUserInfoByPhone("11020191052", 94L)).toString());

        System.out.println("--> getUserInfoByUName: " +
                (userDataService.getUserInfoByUName("TestX_22020180002", 94L)).toString());

        System.out.println("--> getUserInfoById: " +
                (userDataService.getUserInfoById(151235971L, 94L)).toString());

        String token = "34044b58632664c81a67db482d5724a759025e9f89181812d1ce1c69f8ca232b397fa0fd38b461616b0a327c123f68a65556b8347df54f7aa6c30dfc78775188c5";

        System.out.println("--> getSortIdAboutUser: " +
                (userDataService.getSortIdAboutUser(151235971L, 94L, token)).toString());

        System.out.println("--> getUserSortId: " +
                (userDataService.getUserSortId(151235971L, 94L, token)).toString());

        System.out.println("--> getUserInfoMiniById: " +
                (userDataService.getUserInfoMiniById(151235971L, 94L)).toString());


        Long[] ids = new Long[]{12733684L, 12733705L, 12715368L, 12735500L, 12720410L, 12754565L};
        System.out.println("--> getUserInfoByIds: " +
                (userDataService.getUserInfoByIds(Lists.newArrayList(ids), 15L)).toString());

        System.out.println("--> getUserInfoMiniByIds: " +
                (userDataService.getUserInfoMiniByIds(Lists.newArrayList(ids), 15L)).toString());
    }


}
