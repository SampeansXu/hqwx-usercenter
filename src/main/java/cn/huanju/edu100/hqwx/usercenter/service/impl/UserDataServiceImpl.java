package cn.huanju.edu100.hqwx.usercenter.service.impl;

import cn.huanju.edu100.hqwx.usercenter.api.UserDataService;
import cn.huanju.edu100.hqwx.usercenter.constant.UserCenterApiConstant;
import cn.huanju.edu100.hqwx.usercenter.model.api.*;
import cn.huanju.edu100.hqwx.usercenter.model.usercenter.BizBaseData;
import cn.huanju.edu100.hqwx.usercenter.model.usercenter.UCRequest;
import cn.huanju.edu100.hqwx.usercenter.model.usercenter.UCResponse;
import cn.huanju.edu100.hqwx.usercenter.utils.OrganizationUtil;
import cn.huanju.edu100.hqwx.usercenter.utils.UCGsonUtil;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description: 用户中心，用户个人相关数据接口
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-08-05
 */
@Service("SDK_HQWX_UserCenter_userDataService")
public class UserDataServiceImpl implements UserDataService {

    @Resource
    HttpClientHelper httpClientHelper;

    //修改用户信息
    private HQUCResponse<Object> updateUserInfo(Long uid, Long schId, UserInfoDTO userInfo, String sourceToken, BizBaseData baseData) {
        if (Objects.isNull(uid) || Objects.isNull(schId) || StringUtils.isEmpty(sourceToken) || Objects.isNull(userInfo)) {
            return HQUCResponse.Error("uid or schId or userInfo or sourceToken is null");
        }
        if (Objects.isNull(httpClientHelper)) {
            return HQUCResponse.Error("HttpClientHelper is null");
        }

        UCRequest request = httpClientHelper.createUCRequest(schId);
        Map<String, Object> params = httpClientHelper.createParamData(baseData);
        params.put("uid", uid);
        params.put("token", sourceToken);
        if (Objects.nonNull(userInfo.getFaceUrl())) {
            params.put("faceUrl", userInfo.getFaceUrl());
        }
        if (Objects.nonNull(userInfo.getName())) {
            params.put("name", userInfo.getName());
        }
        if (Objects.nonNull(userInfo.getNickName())) {
            params.put("nickName", userInfo.getNickName());
        }
        if (Objects.nonNull(userInfo.getSortId())) {
            params.put("sortId", userInfo.getSortId());
        }
        if (Objects.nonNull(userInfo.getSex())) {
            params.put("sex", userInfo.getSex());
        }
        request.setData(params);


        UCResponse response = httpClientHelper.doPost(UserCenterApiConstant.API_updateUserInfo, request);
        if (Objects.isNull(response)) {
            return HQUCResponse.Error("UserCenter over time");
        }

        if (response.isOk()) {
            return HQUCResponse.Ok(response.getData());
        }

        return HQUCResponse.response(response.getrCode(), response.getrMsg());
    }

    //管理员修改用户信息
    private HQUCResponse<Object> updateUserInfoByAdmin(Long uid, Long schId, UserInfoDTO userInfo, BizBaseData baseData) {
        if (Objects.isNull(uid) || Objects.isNull(schId) || Objects.isNull(userInfo)) {
            return HQUCResponse.Error("uid or schId or userInfo is null");
        }
        if (Objects.isNull(httpClientHelper)) {
            return HQUCResponse.Error("HttpClientHelper is null");
        }

        UCRequest request = httpClientHelper.createUCRequest(schId);
        Map<String, Object> params = httpClientHelper.createParamData(baseData);
        params.put("uid", uid);
        if (Objects.nonNull(userInfo.getFaceUrl())) {
            params.put("faceUrl", userInfo.getFaceUrl());
        }
        if (Objects.nonNull(userInfo.getName())) {
            params.put("name", userInfo.getName());
        }
        if (Objects.nonNull(userInfo.getNickName())) {
            params.put("nickName", userInfo.getNickName());
        }
        if (Objects.nonNull(userInfo.getSortId())) {
            params.put("sortId", userInfo.getSortId());
        }
        if (Objects.nonNull(userInfo.getSex())) {
            params.put("sex", userInfo.getSex());
        }
        request.setData(params);


        UCResponse response = httpClientHelper.doPost(UserCenterApiConstant.API_adminUpdateUserInfo, request);
        if (Objects.isNull(response)) {
            return HQUCResponse.Error("UserCenter over time");
        }

        if (response.isOk()) {
            return HQUCResponse.Ok(response.getData());
        }

        return HQUCResponse.response(response.getrCode(), response.getrMsg());
    }

    //根据UName 或 Phone 获取用户信息
    private HQUCResponse<UserInfoDTO> getUserInfoByUNameOrPhone(String uName, String phone, Collection<Long> orgIdList, Map<String, Object> extParam, BizBaseData baseData) {
        if (Objects.isNull(uName) && Objects.isNull(phone)) {
            return HQUCResponse.Error("uName or phone are null");
        }
        if (Objects.isNull(httpClientHelper)) {
            return HQUCResponse.Error("HttpClientHelper is null");
        }

        UCRequest request = httpClientHelper.createUCRequest((Long)orgIdList.iterator().next());
        Map<String, Object> params = httpClientHelper.createParamData(baseData);
        if (!StringUtils.isEmpty(uName)) {
            params.put("uName", uName);
        } else if (!StringUtils.isEmpty(phone)) {
            params.put("phone", phone);
        }
        params.put("orgidList", orgIdList);
        if (Objects.nonNull(extParam) && extParam.size() > 0) {
            params.putAll(extParam);
        }
        request.setData(params);


        UCResponse response = httpClientHelper.doPost(UserCenterApiConstant.API_adminGetUserInfo, request);
        if (Objects.isNull(response)) {
            return HQUCResponse.Error("UserCenter over time");
        }

        final String Key_userInfoArr = "userInfoArr";
        if (response.isOk() && response.getData().get(Key_userInfoArr) != null) {
            Type type = new com.google.gson.reflect.TypeToken<List<UserInfoDTO>>() {
            }.getType();
            List<UserInfoDTO> lstDto = UCGsonUtil.fromJson(UCGsonUtil.toJson(response.getData().get(Key_userInfoArr)), type);
            if (!CollectionUtils.isEmpty(lstDto)) {
                return HQUCResponse.Ok(lstDto.get(0));
            }
        }

        return HQUCResponse.response(response.getrCode(), response.getrMsg());
    }

    @Override
    public HQUCResponse<Object> updateUserInfoMiniByAdmin(Long uid, Long schId, UserInfoMiniDTO newUserInfo) {
        if (Objects.isNull(uid) || Objects.isNull(schId) || Objects.isNull(newUserInfo)) {
            return HQUCResponse.Error("uid or schId or newUserInfo is null");
        }

        UserInfoDTO userInfo = new UserInfoDTO();
        BeanUtils.copyProperties(newUserInfo, userInfo);
        return this.updateUserInfoByAdmin(uid, schId, userInfo, null);
    }

    @Override
    public HQUCResponse<Object> updateUserBindPhoneByAdmin(Long uid, Long schId, String phone, int bindStatus) {
        if (Objects.isNull(uid) || Objects.isNull(schId)) {
            return HQUCResponse.Error("uid or schId is null");
        }
        if(bindStatus!=0 && bindStatus!=1) {
            return HQUCResponse.Error("bindStatus must be 0 or 1");
        }
        if (Objects.isNull(httpClientHelper)) {
            return HQUCResponse.Error("HttpClientHelper is null");
        }

        UCRequest request = httpClientHelper.createUCRequest(schId);
        Map<String, Object> params = httpClientHelper.createParamData(null);
        params.put("uid", uid);
        params.put("bindStatus", bindStatus);
        if (!StringUtils.isEmpty(phone)) {
            params.put("phone", phone);
        }
        request.setData(params);


        UCResponse response = httpClientHelper.doPost(UserCenterApiConstant.API_adminBindPhone, request);
        if (Objects.isNull(response)) {
            return HQUCResponse.Error("UserCenter over time");
        }

        if (response.isOk()) {
            return HQUCResponse.Ok(response.getData());
        }

        return HQUCResponse.response(response.getrCode(), response.getrMsg());
    }

    @Override
    public HQUCResponse<UserInfoDTO> getUserInfoByUName(String uName, Long schId) {
        if (Objects.isNull(uName)) {
            return HQUCResponse.Error("uName is null");
        }

        List<Long> orgIdList = new ArrayList();
        orgIdList.add(schId);

        return this.getUserInfoByUNameOrPhone(uName, null, orgIdList, null,null);
    }

    @Override
    public HQUCResponse<UserInfoDTO> getUserInfoByUName(String uName, Map<String, Object> extParam) {
        return this.getUserInfoByUName(uName, OrganizationUtil.getCommonTopOrgIdList(), extParam);
    }

    @Override
    public HQUCResponse<UserInfoDTO> getUserInfoByUName(String uName, Collection<Long> orgIdList, Map<String, Object> extParam) {
        if(StringUtils.isEmpty(uName) || Objects.isNull(orgIdList)){
            return HQUCResponse.Error("phone or orgIdList is null");
        }
        return this.getUserInfoByUNameOrPhone(uName, null, orgIdList, extParam, null);
    }

    @Override
    public HQUCResponse<UserInfoDTO> getUserInfoByPhone(String phone, Long schId) {
        if (Objects.isNull(phone)) {
            return HQUCResponse.Error("phone is null");
        }

        List<Long> orgIdList = new ArrayList();
        orgIdList.add(schId);

        return this.getUserInfoByUNameOrPhone(null, phone, orgIdList, null, null);
    }

    @Override
    public HQUCResponse<UserInfoDTO> getUserInfoByPhone(String phone, Map<String, Object> extParam) {
        return this.getUserInfoByPhone(phone, OrganizationUtil.getCommonTopOrgIdList(), extParam);
    }

    @Override
    public HQUCResponse<UserInfoDTO> getUserInfoByPhone(String phone, Collection<Long> orgIdList, Map<String, Object> extParam) {
        if(StringUtils.isEmpty(phone) || Objects.isNull(orgIdList)){
            return HQUCResponse.Error("phone or orgIdList is null");
        }
        return this.getUserInfoByUNameOrPhone(null, phone, orgIdList, extParam, null);
    }

    @Override
    public HQUCResponse<UserInfoDTO> getUserInfoById(Long uid, Map<String, Object> extParam) {
        return this.getUserInfoById(uid, OrganizationUtil.getCommonTopOrgIdList(), extParam, null);
    }

    @Override
    public HQUCResponse<UserInfoDTO> getUserInfoById(Long uid, Long schId) {
        return this.getUserInfoById(uid, schId, null, null);
    }

    @Override
    public HQUCResponse<UserInfoDTO> getUserInfoById(Long uid, Long schId, Map<String, Object> extParam) {
        return this.getUserInfoById(uid, schId, extParam, null);
    }

    @Override
    public HQUCResponse<UserInfoDTO> getUserInfoById(Long uid, Long schId, Map<String, Object> extParam, BizBaseData baseData) {
        if (Objects.isNull(uid) || Objects.isNull(schId)) {
            return HQUCResponse.Error("uid or schIdList is null");
        }

        List<Long> orgIdList = new ArrayList();
        orgIdList.add(schId);

        return this.getUserInfoById(uid, orgIdList, extParam, baseData);
    }

    @Override
    public HQUCResponse<UserInfoDTO> getUserInfoById(Long uid, Collection<Long> orgIdList) {
        return this.getUserInfoById(uid, orgIdList, null,null);
    }

    @Override
    public HQUCResponse<UserInfoDTO> getUserInfoById(Long uid, Collection<Long> orgIdList, BizBaseData baseData) {
        return this.getUserInfoById(uid, orgIdList, null, baseData);
    }

    @Override
    public HQUCResponse<UserInfoDTO> getUserInfoById(Long uid, Collection<Long> orgIdList, Map<String, Object> extParam) {
        return this.getUserInfoById(uid, orgIdList, extParam, null);
    }

    @Override
    public HQUCResponse<UserInfoDTO> getUserInfoById(Long uid, Collection<Long> orgIdList, Map<String, Object> extParam, BizBaseData baseData) {
        if (Objects.isNull(uid) || Objects.isNull(orgIdList)) {
            return HQUCResponse.Error("uid or orgIdList is null");
        }
        if (Objects.isNull(httpClientHelper)) {
            return HQUCResponse.Error("HttpClientHelper is null");
        }

        UCRequest request = this.httpClientHelper.createUCRequest((Long)orgIdList.iterator().next());
        Map<String, Object> params = this.httpClientHelper.createParamData(baseData);
        params.put("uid", uid);
        params.put("orgidList", orgIdList);
        if (Objects.nonNull(extParam) && extParam.size() > 0) {
            params.putAll(extParam);
        }
        request.setData(params);
        UCResponse response = this.httpClientHelper.doPost(UserCenterApiConstant.API_adminGetUserInfo, request);
        if (Objects.isNull(response)) {
            return HQUCResponse.Error("UserCenter over time");
        }

        final String Key_userInfoArr = "userInfoArr";
        if (response.isOk() && response.getData().get(Key_userInfoArr) != null) {
            Type type = (new TypeToken<List<UserInfoDTO>>() {}).getType();
            List<UserInfoDTO> lstDto = UCGsonUtil.fromJson(UCGsonUtil.toJson(response.getData().get(Key_userInfoArr)), type);
            if (!CollectionUtils.isEmpty(lstDto)) {
                return HQUCResponse.Ok(lstDto.get(0));
            }
        }

        return HQUCResponse.response(response.getrCode(), response.getrMsg());
    }

    @Override
    public HQUCResponse<UserInfoMiniDTO> getUserInfoMiniById(Long uid, Long schId) {
        return this.getUserInfoMiniById(uid, schId, null);
    }

    @Override
    public HQUCResponse<UserInfoMiniDTO> getUserInfoMiniById(Long uid, Long schId, BizBaseData baseData) {
        if (Objects.isNull(schId)) {
            return HQUCResponse.Error("schId is null");
        }

        List<Long> orgIdList = new ArrayList<Long>();
        orgIdList.add(schId);

        return this.getUserInfoMiniById(uid, orgIdList);
    }

    @Override
    public HQUCResponse<UserInfoMiniDTO> getUserInfoMiniById(Long uid, Collection<Long> orgIdList) {
        return this.getUserInfoMiniById(uid, orgIdList, null);
    }

    @Override
    public HQUCResponse<UserInfoMiniDTO> getUserInfoMiniById(Long uid, Collection<Long> orgIdList, BizBaseData baseData) {
        HQUCResponse<UserInfoDTO> response = this.getUserInfoById(uid, orgIdList, baseData);
        if (!response.isOk()) {
            return HQUCResponse.response(response.getCode(), response.getMsg());
        }

        UserInfoMiniDTO resultDTO = new UserInfoMiniDTO();
        BeanUtils.copyProperties(response.getData(), resultDTO);

        return HQUCResponse.Ok(resultDTO);
    }

    @Override
    public HQUCResponse<ThirdUserInfoDTO> getThirdUserInfoById(Long uid, Long schId) {
        if (Objects.isNull(uid) || Objects.isNull(schId)) {
            return HQUCResponse.Error("uids or schId is null");
        }

        List<Long> orgIdList = new ArrayList();
        orgIdList.add(schId);

        return this.getThirdUserInfoById(uid, orgIdList);
    }

    @Override
    public HQUCResponse<ThirdUserInfoDTO> getThirdUserInfoById(Long uid, Collection<Long> orgIdList) {
        return this.getThirdUserInfoById(uid, orgIdList, null, null);
    }

    @Override
    public HQUCResponse<ThirdUserInfoDTO> getThirdUserInfoById(Long uid, Collection<Long> orgIdList, Map<String, Object> extParam, BizBaseData baseData) {
        HQUCResponse<List<ThirdUserInfoDTO>> response = this.getThirdUserInfoListById(uid, orgIdList, extParam, baseData);
        if (response.isOk() && !CollectionUtils.isEmpty(response.getData())) {
            return HQUCResponse.Ok(response.getData().get(0));
        }

        return HQUCResponse.response(response.getCode(), response.getMsg());
    }

    @Override
    public HQUCResponse<List<ThirdUserInfoDTO>> getThirdUserInfoListById(Long uid, Collection<Long> orgIdList, Map<String, Object> extParam, BizBaseData baseData) {
        if (Objects.isNull(uid) || Objects.isNull(orgIdList)) {
            return HQUCResponse.Error("uid or orgIdList is null");
        }
        if (Objects.isNull(httpClientHelper)) {
            return HQUCResponse.Error("HttpClientHelper is null");
        }

        UCRequest request = this.httpClientHelper.createUCRequest((Long)orgIdList.iterator().next());
        Map<String, Object> params = this.httpClientHelper.createParamData(baseData);
        params.put("uid", uid);
        params.put("orgidList", orgIdList);
        if (Objects.nonNull(extParam) && extParam.size() > 0) {
            params.putAll(extParam);
        }
        request.setData(params);
        UCResponse response = this.httpClientHelper.doPost(UserCenterApiConstant.API_adminGetThirdUserInfo, request);
        if (Objects.isNull(response)) {
            return HQUCResponse.Error("UserCenter over time");
        }

        final String Key_userInfoArr = "userInfoArr";
        if (response.isOk() && response.getData().get(Key_userInfoArr) != null) {
            Type type = (new TypeToken<List<ThirdUserInfoDTO>>() {}).getType();
            List<ThirdUserInfoDTO> lstDto = UCGsonUtil.fromJson(UCGsonUtil.toJson(response.getData().get(Key_userInfoArr)), type);
            if (!CollectionUtils.isEmpty(lstDto)) {
                return HQUCResponse.Ok(lstDto);
            }
        }

        return HQUCResponse.response(response.getrCode(), response.getrMsg());
    }

    @Override
    public Map<Long, UserInfoDTO> userInfoList2Map(List<UserInfoDTO> lst) {
        Map<Long, UserInfoDTO> result = new HashMap<>();
        if(CollectionUtils.isEmpty(lst)){
            return result;
        }

        for (UserInfoDTO ui : lst) {
            result.put(ui.getUid(), ui);
        }
        return result;
    }

    @Override
    public HQUCResponse<List<UserInfoDTO>> getUserInfoByIds(Collection<Long> uids, Map<String, Object> extParam) {
        return this.getUserInfoByIds(uids, OrganizationUtil.getCommonTopOrgIdList(), extParam, null);
    }

    @Override
    public HQUCResponse<List<UserInfoDTO>> getUserInfoByIds(Collection<Long> uids, Long schId) {
        return this.getUserInfoByIds(uids, schId, null);
    }

    @Override
    public HQUCResponse<List<UserInfoDTO>> getUserInfoByIds(Collection<Long> uids, Long schId, BizBaseData baseData) {
        if (CollectionUtils.isEmpty(uids) || Objects.isNull(schId)) {
            return HQUCResponse.Error("uids or schId is null");
        }

        List<Long> orgIdList = new ArrayList();
        orgIdList.add(schId);

        return this.getUserInfoByIds(uids, orgIdList, baseData);
    }

    @Override
    public HQUCResponse<List<UserInfoDTO>> getUserInfoByIds(Collection<Long> uids, Collection<Long> orgIdList) {
        return this.getUserInfoByIds(uids, orgIdList, null, null);
    }

    @Override
    public HQUCResponse<List<UserInfoDTO>> getUserInfoByIds(Collection<Long> uids, Collection<Long> orgIdList, BizBaseData baseData) {
        return this.getUserInfoByIds(uids, orgIdList, null, baseData);
    }

    @Override
    public HQUCResponse<List<UserInfoDTO>> getUserInfoByIds(Collection<Long> uids, Collection<Long> orgIdList, Map<String, Object> extParam) {
        return this.getUserInfoByIds(uids, orgIdList, extParam, null);
    }

    @Override
    public HQUCResponse<List<UserInfoDTO>> getUserInfoByIds(Collection<Long> uids, Collection<Long> orgIdList, Map<String, Object> extParam, BizBaseData baseData) {
        if(CollectionUtils.isEmpty(uids) || CollectionUtils.isEmpty(orgIdList)){
            return HQUCResponse.Error("uids or orgIdList is null");
        }
        if(Objects.isNull(this.httpClientHelper)){
            return HQUCResponse.Error("HttpClientHelper is null");
        }

        UCRequest request = this.httpClientHelper.createUCRequest((Long)orgIdList.iterator().next());
        Map<String, Object> params = this.httpClientHelper.createParamData(baseData);
        params.put("UidList", uids);
        params.put("orgIdList", orgIdList);
        if (Objects.nonNull(extParam) && extParam.size() > 0) {
            params.putAll(extParam);
        }

        request.setData(params);
        UCResponse response = this.httpClientHelper.doPost(UserCenterApiConstant.API_adminGetUserByList, request);
        if (Objects.isNull(response)) {
            return HQUCResponse.Error("UserCenter over time");
        }

        final String Key_userInfoArr = "userInfoArr";
        if (response.isOk() && response.getData().get(Key_userInfoArr) != null) {
            List objs = (List)response.getData().get(Key_userInfoArr);
            Type type = (new TypeToken<List<UserInfoDTO>>() {}).getType();
            List<UserInfoDTO> lstDto = UCGsonUtil.fromJson(UCGsonUtil.toJson(objs), type);
            return HQUCResponse.Ok(lstDto);
        }

        return HQUCResponse.response(response.getrCode(), response.getrMsg());
    }

    @Override
    public HQUCResponse<Object> updateUserInfoMini(Long uid, Long schId, UserInfoMiniDTO newUserInfo, String sourceToken) {
        return this.updateUserInfoMini(uid, schId, newUserInfo, sourceToken, null);
    }

    @Override
    public HQUCResponse<Object> updateUserInfoMini(Long uid, Long schId, UserInfoMiniDTO newUserInfo, String sourceToken, BizBaseData baseData) {
        if (Objects.isNull(uid) || Objects.isNull(schId)
                || StringUtils.isEmpty(sourceToken) || Objects.isNull(newUserInfo)) {
            return HQUCResponse.Error("uid or schId or newUserInfo or sourceToken is null");
        }

        UserInfoDTO userInfo = new UserInfoDTO();
        BeanUtils.copyProperties(newUserInfo, userInfo);
        return this.updateUserInfo(uid, schId, userInfo, sourceToken, baseData);
    }

    @Override
    public Map<Long, UserInfoMiniDTO> userInfoMiniList2Map(List<UserInfoMiniDTO> lst) {
        Map<Long, UserInfoMiniDTO> result = new HashMap<>();
        if(CollectionUtils.isEmpty(lst)){
            return result;
        }

        for (UserInfoMiniDTO ui : lst) {
            result.put(ui.getUid(), ui);
        }
        return result;
    }

    @Override
    public HQUCResponse<List<UserInfoMiniDTO>> getUserInfoMiniByIds(Collection<Long> uids) {
        return this.getUserInfoMiniByIds(uids, OrganizationUtil.getCommonTopOrgIdList());
    }

    @Override
    public HQUCResponse<List<UserInfoMiniDTO>> getUserInfoMiniByIds(Collection<Long> uids, Long schId) {
        return this.getUserInfoMiniByIds(uids, schId, null);
    }

    @Override
    public HQUCResponse<List<UserInfoMiniDTO>> getUserInfoMiniByIds(Collection<Long> uids, Long schId, BizBaseData baseData) {
        if (Objects.isNull(uids) || Objects.isNull(schId)) {
            return HQUCResponse.Error("uids or schId is null");
        }

        List<Long> orgIdList = new ArrayList();
        orgIdList.add(schId);

        return this.getUserInfoMiniByIds(uids, orgIdList, null);
    }

    @Override
    public HQUCResponse<List<UserInfoMiniDTO>> getUserInfoMiniByIds(Collection<Long> uids, Collection<Long> orgIdList) {
        return this.getUserInfoMiniByIds(uids, orgIdList, null);
    }

    @Override
    public HQUCResponse<List<UserInfoMiniDTO>> getUserInfoMiniByIds(Collection<Long> uids, Collection<Long> orgIdList, BizBaseData baseData) {
        HQUCResponse<List<UserInfoDTO>> response = this.getUserInfoByIds(uids, orgIdList, baseData);
        if (!response.isOk()) {
            return HQUCResponse.response(response.getCode(), response.getMsg());
        }

        List<UserInfoMiniDTO> resultList = (List)((List)response.getData()).stream().map((u) -> {
            UserInfoMiniDTO resultDTO = new UserInfoMiniDTO();
            BeanUtils.copyProperties(u, resultDTO);
            return resultDTO;
        }).collect(Collectors.toList());

        return HQUCResponse.Ok(resultList);
    }

    @Override
    public HQUCResponse<Object> updateUserSortId(Long uid, Long schId, Collection<Long> sortIds, String sourceToken) {
        return this.updateUserSortId(uid, schId, sortIds, sourceToken, null);
    }

    @Override
    public HQUCResponse<Object> updateUserSortId(Long uid, Long schId, Collection<Long> sortIds, String sourceToken, BizBaseData baseData) {
        if (Objects.isNull(uid) || Objects.isNull(schId) || StringUtils.isEmpty(sourceToken) || CollectionUtils.isEmpty(sortIds)) {
            return HQUCResponse.Error("uid or schId or sortIds or sourceToken is null");
        }

        String strSortId = "";
        for (Long id : sortIds) {
            if (!StringUtils.isEmpty(strSortId)) {
                strSortId += ",";
            }
            strSortId += id;
        }
        UserInfoDTO userInfo = new UserInfoDTO();
        userInfo.setSortId(strSortId);

        return this.updateUserInfo(uid, schId, userInfo, sourceToken, baseData);
    }

    @Override
    public HQUCResponse<List<Long>> getUserSortId(Long uid, Long schId, String sourceToken) {
        return this.getUserSortId(uid, schId, sourceToken, null);
    }

    @Override
    public HQUCResponse<List<Long>> getUserSortId(Long uid, Long schId, String sourceToken, BizBaseData baseData) {
        HQUCResponse<List<SortIdInfoDTO>> response = this.getUserSortIdDetail(uid, schId, sourceToken, baseData);
        if(!response.isOk()){
            return HQUCResponse.response(response.getCode(), response.getMsg());
        }

        List<Long> resultList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(response.getData())) {
            for (SortIdInfoDTO dto : response.getData()) {
                if (!StringUtils.isEmpty(dto.getSortId())) {
                    resultList.add(Long.valueOf(dto.getSortId()));
                }
            }
        }

        return HQUCResponse.Ok(resultList);
    }

    @Override
    public HQUCResponse<List<Long>> getUserSortIdLatest(Long uid, Long schId, String sourceToken) {
        return this.getUserSortIdLatest(uid, schId, sourceToken, null);
    }

    @Override
    public HQUCResponse<List<Long>> getUserSortIdLatest(Long uid, Long schId, String sourceToken, BizBaseData baseData) {
        HQUCResponse<List<SortIdInfoDTO>> response = this.getUserSortIdDetail(uid, schId, sourceToken, baseData);
        if(!response.isOk()){
            return HQUCResponse.response(response.getCode(), response.getMsg());
        }

        List<Long> resultList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(response.getData())) {
            String latestTime = response.getData().get(0).getuTime();
            for (SortIdInfoDTO dto : response.getData()) {
                if (!StringUtils.isEmpty(dto.getSortId())
                        && latestTime.equals(dto.getuTime())) {
                    resultList.add(Long.valueOf(dto.getSortId()));
                }
            }
        }

        return HQUCResponse.Ok(resultList);
    }

    @Override
    public HQUCResponse<List<SortIdInfoDTO>> getUserSortIdDetail(Long uid, Long schId, String sourceToken) {
        return this.getUserSortIdDetail(uid, schId, sourceToken, null);
    }

    @Override
    public HQUCResponse<List<SortIdInfoDTO>> getUserSortIdDetail(Long uid, Long schId, String sourceToken, BizBaseData baseData) {
        if (Objects.isNull(uid) || Objects.isNull(schId) || StringUtils.isEmpty(sourceToken)) {
            return HQUCResponse.Error("uid or schId or sourceToken is null");
        }
        if (Objects.isNull(httpClientHelper)) {
            return HQUCResponse.Error("HttpClientHelper is null");
        }

        UCRequest request = httpClientHelper.createUCRequest(schId);
        Map<String, Object> params = httpClientHelper.createParamData(baseData);
        params.put("uid", uid);
        params.put("token", sourceToken);
        request.setData(params);


        UCResponse response = httpClientHelper.doPost(UserCenterApiConstant.API_getUserSortID, request);
        if (Objects.isNull(response)) {
            return HQUCResponse.Error("UserCenter over time");
        }

        final String Key_sortIdList = "sortIdList";
        if (response.isOk() && response.getData().get(Key_sortIdList) != null) {
            Type type = new TypeToken<List<SortIdInfoDTO>>() {
            }.getType();
            List<SortIdInfoDTO> resultList = UCGsonUtil.fromJson(UCGsonUtil.toJson(response.getData().get(Key_sortIdList)), type);

            return HQUCResponse.Ok(resultList);
        }

        return HQUCResponse.response(response.getrCode(), response.getrMsg());
    }

    @Override
    public HQUCResponse<SortIdAboutUserDTO> getSortIdAboutUser(Long uid, Long schId, String sourceToken) {
        return this.getSortIdAboutUser(uid, schId, sourceToken, null);
    }

    @Override
    public HQUCResponse<SortIdAboutUserDTO> getSortIdAboutUser(Long uid, Long schId, String sourceToken, BizBaseData baseData) {
        if (Objects.isNull(uid) || Objects.isNull(schId) || StringUtils.isEmpty(sourceToken)) {
            return HQUCResponse.Error("uid or schId or sourceToken is null");
        }
        if (Objects.isNull(httpClientHelper)) {
            return HQUCResponse.Error("HttpClientHelper is null");
        }

        UCRequest request = httpClientHelper.createUCRequest(schId);
        Map<String, Object> params = httpClientHelper.createParamData(baseData);
        params.put("uid", uid);
        params.put("token", sourceToken);
        request.setData(params);


        UCResponse response = httpClientHelper.doPost(UserCenterApiConstant.API_getSortIdInfo, request);
        if (Objects.isNull(response)) {
            return HQUCResponse.Error("UserCenter over time");
        }

        if (response.isOk() && response.getData() != null) {
            SortIdAboutUserDTO resultDTO = new SortIdAboutUserDTO();

            if (!StringUtils.isEmpty(response.getData().get("browsedSortIdList"))) {
                String[] ids = UCGsonUtil.fromJson(UCGsonUtil.toJson(response.getData().get("browsedSortIdList")), String[].class);
                resultDTO.setBrowsedList(Arrays.stream(ids).map(id -> Long.valueOf(id)).collect(Collectors.toList()));
            }

            if (!StringUtils.isEmpty(response.getData().get("interestedSortIdList"))) {
                String[] ids = UCGsonUtil.fromJson(UCGsonUtil.toJson(response.getData().get("interestedSortIdList")), String[].class);
                resultDTO.setInterestedList(Arrays.stream(ids).map(id -> Long.valueOf(id)).collect(Collectors.toList()));
            }

            if (!StringUtils.isEmpty(response.getData().get("intentionSortIdList"))) {
                String[] ids = UCGsonUtil.fromJson(UCGsonUtil.toJson(response.getData().get("intentionSortIdList")), String[].class);
                resultDTO.setIntentionList(Arrays.stream(ids).map(id -> Long.valueOf(id)).collect(Collectors.toList()));
            }

            return HQUCResponse.Ok(resultDTO);
        }

        return HQUCResponse.response(response.getrCode(), response.getrMsg());
    }

    @Override
    public HQUCResponse<List<UserPhoneDataInfoDTO>> getUserPhone(Collection<Long> uids, Long schId) {
        return this.getUserPhone(uids, schId, null);
    }

    @Override
    public HQUCResponse<List<UserPhoneDataInfoDTO>> getUserPhone(Collection<Long> uids, Long schId, BizBaseData baseData) {
        if (Objects.isNull(schId) || CollectionUtils.isEmpty(uids)) {
            return HQUCResponse.Error("uids or schId is null");
        }
        if (Objects.isNull(httpClientHelper)) {
            return HQUCResponse.Error("HttpClientHelper is null");
        }

        UCRequest request = httpClientHelper.createUCRequest(schId);
        Map<String, Object> params = httpClientHelper.createParamData(baseData);
        params.put("operatorId", 1);
        params.put("operatorIp", "127.0.0.1");
        params.put("operatorName", httpClientHelper.getConfig().getPlatform());
        params.put("uids", uids);
        request.setData(params);


        UCResponse response = httpClientHelper.doPost(UserCenterApiConstant.API_getUserPhone, request);
        if (Objects.isNull(response)) {
            return HQUCResponse.Error("UserCenter over time");
        }

        final String Key_userPhoneDataInfoList = "userPhoneDataInfoList";
        if (response.isOk() && response.getData().get(Key_userPhoneDataInfoList) != null) {
//            JSONArray objects = JSONUtil.parseArray(response.getData().get(Key_userInfoArr).toString());
//            List<UserInfoDTO> lstDto = JSONUtil.toList(objects, UserInfoDTO.class);
            Type type = new com.google.gson.reflect.TypeToken<List<UserPhoneDataInfoDTO>>() {
            }.getType();
            List<UserPhoneDataInfoDTO> lstDto = UCGsonUtil.fromJson(UCGsonUtil.toJson(response.getData().get(Key_userPhoneDataInfoList)), type);
            return HQUCResponse.Ok(lstDto);
        }

        return HQUCResponse.response(response.getrCode(), response.getrMsg());
    }
}
