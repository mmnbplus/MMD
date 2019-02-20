package com.mmd.mmdshop.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mmd.mmdshop.dbdo.AdminUserDO;
import com.mmd.mmdshop.result.AdminUserAll;
import com.mmd.mmdshop.result.AdminUserLoginResult;

/**
 * 管理用户DAO
 * @ClassName AdminUserDao.java
 * @author QJH
 * @version 1.0
 * @date 2019/2/18
 */

@Mapper
public interface AdminUserMapper extends BaseMapper<AdminUserDO>{
	/**
	 * 通过管理员用户ID查询管理员用户全名
	 * 顺便更新一下管理员用户的最后登录IP和最后登录时间
	 * @param userId	用管理员用户Id
	 * @param ip	登录时的IP地址
	 * @return fullName 管理员用户全名
	 */
	@Select("SELECT full_name,user_id FROM admin_user_details WHERE user_id = #{userId};"
			+ "SELECT jur_type FROM admin_user_jurisdiction WHERE user_id = #{userId};"
			+ "UPDATE admin_user_details SET last_ip = #{ip} , last_time=NOW() WHERE user_id = #{userId};")
	AdminUserLoginResult getAdminUserLoginResultByUserId(@Param("userId")int userId,@Param("ip")String ip);
	/**
	 * 通过用户名称查询此用户全部信息(admin_user,admin_user_details,admin_user_jurisdiction)
	 * @param username 用户名字
	 * @return	用户全部信息
	 */
	AdminUserAll getAdminUserAllByUsername(@Param("username")String username);
	
	
}
