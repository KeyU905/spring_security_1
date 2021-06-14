package edu.bit.ex.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.bit.ex.mapper.EmpMapper;
import edu.bit.ex.vo.EmpUser;
import edu.bit.ex.vo.EmpVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

/* principal.emp.sal = 확장하고 싶지？*/


@Log4j
@Service
public class EmpDetailsService implements UserDetailsService {

	@Setter(onMethod_ = @Autowired)
	private EmpMapper empMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("Load User By EmpVO number: " + username);
		
		EmpVO vo = empMapper.getEmp(username);

		log.warn("queried by MemberVO mapper: " + vo);

		return (vo == null) ? null : new EmpUser(vo);
		// 삼항연산자. vo == null 값이 true 이면 null을, false 이면 new EmpUser(vo)를 리턴한다. 

	}
}