package edu.bit.ex.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;



@Log4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberVO  {
	private String username;
	private String password;
	private String enabled;
	//이거 int 아니어도 마이바티스가 String으로도 잘 한다고 하신다.
	// 오류 나면 고치자
	
	private List<AuthVO> authList;
  

}