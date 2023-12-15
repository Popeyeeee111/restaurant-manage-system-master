package me.freezehome.blog.dao;

import me.freezehome.blog.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by freeze on 16-11-13.
 */
//@Repository
public interface UserDAO {
    String table = "administrator";
    String id = "user_name";
    String selectField = "user_name, user_password";
    String userRank = "user_rank";
    String insertField = "user_name, user_phone, user_email, user_password";

    @Select({"SELECT  user_name  FROM "+table})
    List<String> getAllUserName();

    @Select({"SELECT "+ selectField+" FROM "+ table+ " WHERE user_name=#{userId}"})
    User getUserById(@Param("userId") String userId);


    @Select({" SELECT is_login FROM "+ table+ " WHERE user_name=#{userId}"})
    String getLoginById(@Param("userId") String userID);

    @Update({"UPDATE " + table+ " SET is_login=#{isLogin} WHERE user_name=#{userName}"})
    int updateUserLogin(@Param("isLogin") String isLogin,
                        @Param("userName") String userName);

    @Select({"SELECT", selectField, "FROM", table, "WHERE user_name=#{userName}"})
    User getUserByName(@Param("userName") String userName);

    @Select({"SELECT", selectField, "FROM", table, "WHERE user_phone=#{userPhone}"})
    User getUserByPhone(@Param("userPhone") String userPhone);

    @Select({"SELECT", selectField, "FROM", table, "WHERE user_email=#{userEmail}"})
    User getUserByEmail(@Param("userEmail") String userEmail);

    @Insert({"INSERT INTO", table, "(", insertField, ")", "VALUES (#{userName}, #{userPhone}, #{userEmail}, #{userPassword})"})
    int insertUser(User user);

    @Delete({"DELETE FROM", table, "WHERE user_name=#{userName}"})
    int deleteUserByName(@Param("userName") String userName);

    @Select({"SELECT user_password FROM", table, "WHERE user_name=#{userName}"})
    String getUserPasswordByUserName(@Param("userName") String userName);

    @Update({"UPDATE", table, "SET user_phone=#{userPhone} WHERE user_name=#{userName}"})
    int updateUserPhone(@Param("userPhone") String userPhone,
                        @Param("userName") String userName);

    @Update({"UPDATE", table, "SET user_name=#{userName} WHERE user_name=#{currentUserName}"})
    int updateUserName(@Param("userName") String userName,
                       @Param("currentUserName") String currentUserName);

    @Update({"UPDATE", table, "SET user_email=#{userEmail} WHERE user_name=#{userName}"})
    int updateUserEmail(@Param("userEmail") String userEmail,
                        @Param("userName") String userName);

    @Update({"UPDATE", table, "SET user_password=#{userPassword} WHERE user_name=#{userName}"})
    int updateUserPassword(@Param("userPassword") String userPassword,
                           @Param("userName") String userName);

    @Update({"UPDATE", table, "SET user_rank=#{userRank} WHERE user_name=#{userName}"})
    int updateUserRank(@Param("userRank") int userRank,
                       @Param("userName") String userName);
}
