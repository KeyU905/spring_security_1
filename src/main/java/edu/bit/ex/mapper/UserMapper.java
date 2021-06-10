package edu.bit.ex.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.bit.ex.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;



@Mapper
public interface UserMapper  {
	   @Insert("insert into users(username,password,enabled) values(#{username},#{password},#{enabled})")
	   public int insertUser(UserVO userVO);

	   @Insert("insert into AUTHORITIES (username,AUTHORITY) values(#{username},'ROLE_USER')")
	   public void insertAuthorities(UserVO UserVO);
  
}