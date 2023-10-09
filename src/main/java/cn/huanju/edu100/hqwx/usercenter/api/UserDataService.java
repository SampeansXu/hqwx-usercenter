package cn.huanju.edu100.hqwx.usercenter.api;

import cn.huanju.edu100.hqwx.usercenter.model.api.*;
import cn.huanju.edu100.hqwx.usercenter.model.usercenter.BizBaseData;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Description: 用户相关信息接口
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-08-04
 */
public interface UserDataService {
    /**
     * 管理员更新用户极简信息
     *
     * @param uid
     * @param schId
     * @param newUserInfo
     * @return
     */
    HQUCResponse<Object> updateUserInfoMiniByAdmin(Long uid, Long schId, UserInfoMiniDTO newUserInfo);
    /**
     * 管理员绑定或解绑用户手机号
     *
     * @param uid
     * @param schId
     * @param phone
     * @param bindStatus 1-绑定, 2-解绑定
     * @return
     */
    HQUCResponse<Object> updateUserBindPhoneByAdmin(Long uid, Long schId, String phone, int bindStatus);

    /**
     * 通过帐号uName，修获取用户信息
     *
     * @param uName
     * @param schId
     * @return
     */
    HQUCResponse<UserInfoDTO> getUserInfoByUName(String uName, Long schId);
    HQUCResponse<UserInfoDTO> getUserInfoByUName(String uName, Map<String, Object> extParam);
    HQUCResponse<UserInfoDTO> getUserInfoByUName(String uName, Collection<Long> orgIdList, Map<String, Object> extParam);

    /**
     * 通过帐号手机号，修获取用户信息
     *
     * @param phone
     * @param schId
     * @return
     */
    HQUCResponse<UserInfoDTO> getUserInfoByPhone(String phone, Long schId);
    HQUCResponse<UserInfoDTO> getUserInfoByPhone(String phone, Map<String, Object> extParam);
    HQUCResponse<UserInfoDTO> getUserInfoByPhone(String phone, Collection<Long> orgIdList, Map<String, Object> extParam);

    /**
     * 获取 用户完整信息
     *
     * @param uid
     * @param schId
     * @return
     */
    HQUCResponse<UserInfoDTO> getUserInfoById(Long uid, Map<String, Object> extParam);
    HQUCResponse<UserInfoDTO> getUserInfoById(Long uid, Long schId);
    HQUCResponse<UserInfoDTO> getUserInfoById(Long uid, Long schId, Map<String, Object> extParam);
    HQUCResponse<UserInfoDTO> getUserInfoById(Long uid, Long schId, Map<String, Object> extParam, BizBaseData baseData);
    HQUCResponse<UserInfoDTO> getUserInfoById(Long uid, Collection<Long> orgIdList);
    HQUCResponse<UserInfoDTO> getUserInfoById(Long uid, Collection<Long> orgIdList, BizBaseData baseData);
    HQUCResponse<UserInfoDTO> getUserInfoById(Long uid, Collection<Long> orgIdList, Map<String, Object> extParam);
    HQUCResponse<UserInfoDTO> getUserInfoById(Long uid, Collection<Long> orgIdList, Map<String, Object> extParam, BizBaseData baseData);

    /**
     * 获取 用户极简信息
     *
     * @param uid
     * @param schId
     * @return
     */
    HQUCResponse<UserInfoMiniDTO> getUserInfoMiniById(Long uid, Long schId);
    HQUCResponse<UserInfoMiniDTO> getUserInfoMiniById(Long uid, Long schId, BizBaseData baseData);
    HQUCResponse<UserInfoMiniDTO> getUserInfoMiniById(Long uid, Collection<Long> orgIdList);
    HQUCResponse<UserInfoMiniDTO> getUserInfoMiniById(Long uid, Collection<Long> orgIdList, BizBaseData baseData);

    /**
     * 获取 用户第3方信息
     *
     * @param uid
     * @param schId
     * @return
     */
    HQUCResponse<ThirdUserInfoDTO> getThirdUserInfoById(Long uid, Long schId);
    HQUCResponse<ThirdUserInfoDTO> getThirdUserInfoById(Long uid, Collection<Long> orgIdList);
    HQUCResponse<ThirdUserInfoDTO> getThirdUserInfoById(Long uid, Collection<Long> orgIdList, Map<String, Object> extParam, BizBaseData baseData);
    HQUCResponse<List<ThirdUserInfoDTO>> getThirdUserInfoListById(Long uid, Collection<Long> orgIdList, Map<String, Object> extParam, BizBaseData baseData);

    /**
     * 批量获取 用户完整信息
     *
     * @param uids
     * @param schId
     * @return
     */
    Map<Long, UserInfoDTO> userInfoList2Map(List<UserInfoDTO> lst);
    HQUCResponse<List<UserInfoDTO>> getUserInfoByIds(Collection<Long> uids, Map<String, Object> extParam);
    HQUCResponse<List<UserInfoDTO>> getUserInfoByIds(Collection<Long> uids, Long schId);
    HQUCResponse<List<UserInfoDTO>> getUserInfoByIds(Collection<Long> uids, Long schId, BizBaseData baseData);
    HQUCResponse<List<UserInfoDTO>> getUserInfoByIds(Collection<Long> uids, Collection<Long> orgIdList);
    HQUCResponse<List<UserInfoDTO>> getUserInfoByIds(Collection<Long> uids, Collection<Long> orgIdList, BizBaseData baseData);
    HQUCResponse<List<UserInfoDTO>> getUserInfoByIds(Collection<Long> uids, Collection<Long> orgIdList, Map<String, Object> extParam);
    HQUCResponse<List<UserInfoDTO>> getUserInfoByIds(Collection<Long> uids, Collection<Long> orgIdList, Map<String, Object> extParam, BizBaseData baseData);

    /**
     * 更新用户极简信息
     *
     * @param uid
     * @param schId
     * @param newUserInfo
     * @return
     */
    HQUCResponse<Object> updateUserInfoMini(Long uid, Long schId, UserInfoMiniDTO newUserInfo, String sourceToken);
    HQUCResponse<Object> updateUserInfoMini(Long uid, Long schId, UserInfoMiniDTO newUserInfo, String sourceToken, BizBaseData baseData);

    /**
     * 批量获取 用户极简信息
     *
     * @param uids
     * @param schId
     * @return
     */
    Map<Long, UserInfoMiniDTO> userInfoMiniList2Map(List<UserInfoMiniDTO> lst);
    HQUCResponse<List<UserInfoMiniDTO>> getUserInfoMiniByIds(Collection<Long> uids);
    HQUCResponse<List<UserInfoMiniDTO>> getUserInfoMiniByIds(Collection<Long> uids, Long schId);
    HQUCResponse<List<UserInfoMiniDTO>> getUserInfoMiniByIds(Collection<Long> uids, Long schId, BizBaseData baseData);
    HQUCResponse<List<UserInfoMiniDTO>> getUserInfoMiniByIds(Collection<Long> uids, Collection<Long> orgIdList);
    HQUCResponse<List<UserInfoMiniDTO>> getUserInfoMiniByIds(Collection<Long> uids, Collection<Long> orgIdList, BizBaseData baseData);

    /**
     * 修改 用户意向考试
     *
     * @param uid
     * @param schId
     * @param sortIds
     * @param sourceToken
     * @return
     */
    HQUCResponse<Object> updateUserSortId(Long uid, Long schId, Collection<Long> sortIds, String sourceToken);
    HQUCResponse<Object> updateUserSortId(Long uid, Long schId, Collection<Long> sortIds, String sourceToken, BizBaseData baseData);

    /**
     * 获取 用户意向考试Id
     *
     * @param uid
     * @param schId
     * @param sourceToken 用户登陆得到的原始 token
     * @return
     */
    HQUCResponse<List<Long>> getUserSortId(Long uid, Long schId, String sourceToken);
    HQUCResponse<List<Long>> getUserSortId(Long uid, Long schId, String sourceToken, BizBaseData baseData);
    HQUCResponse<List<Long>> getUserSortIdLatest(Long uid, Long schId, String sourceToken);
    HQUCResponse<List<Long>> getUserSortIdLatest(Long uid, Long schId, String sourceToken, BizBaseData baseData);
    HQUCResponse<List<SortIdInfoDTO>> getUserSortIdDetail(Long uid, Long schId, String sourceToken);
    HQUCResponse<List<SortIdInfoDTO>> getUserSortIdDetail(Long uid, Long schId, String sourceToken, BizBaseData baseData);

    /**
     * 获取 用户感兴趣的考试,浏览过的考试和考试意向
     *
     * @param uid
     * @param schId
     * @param sourceToken 用户登陆得到的原始 token
     * @return
     */
    HQUCResponse<SortIdAboutUserDTO> getSortIdAboutUser(Long uid, Long schId, String sourceToken);
    HQUCResponse<SortIdAboutUserDTO> getSortIdAboutUser(Long uid, Long schId, String sourceToken, BizBaseData baseData);

    /**
     * 获取用户手机号
     * @param uids
     * @param schId
     * @return
     */
    HQUCResponse<List<UserPhoneDataInfoDTO>> getUserPhone(Collection<Long> uids, Long schId);
    HQUCResponse<List<UserPhoneDataInfoDTO>> getUserPhone(Collection<Long> uids, Long schId, BizBaseData baseData);
}
