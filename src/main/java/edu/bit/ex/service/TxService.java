package edu.bit.ex.service;

import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bit.ex.mapper.UserMapper;
import edu.bit.ex.vo.UserVO;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor
@Service
public class TxService {

    @Inject
    private UserMapper userMapper;

    // 정상동작
    public void txTest1() {

        log.info("transionTest1()..테스트");

        userMapper.deleteAuthorities();
        userMapper.deleteUsers();

        UserVO user = new UserVO();
        user.setUsername("abcd");
        user.setPassword("1111");

        userMapper.insertUser(user);

        user.setUsername("efg");
        user.setPassword("2222");

        userMapper.insertUser(user);

    }

    public void txTest2() {

        log.info("transionTest2()..테스트");

        userMapper.deleteAuthorities();
        userMapper.deleteUsers();

        UserVO user = new UserVO();
        user.setUsername("abcd");
        user.setPassword("1111");

        userMapper.insertUser(user);

        user.setUsername("efg");
        user.setPassword("2222");

        userMapper.insertUser(null);

    }

    @Transactional
    public void txTest3() {

        log.info("transionTest3()..테스트");

        userMapper.deleteAuthorities();
        userMapper.deleteUsers();

        UserVO user = new UserVO();
        user.setUsername("abcd");
        user.setPassword("1111");

        userMapper.insertUser(user);

        user.setUsername("efg");
        user.setPassword("2222");

        userMapper.insertUser(null);

    }

    // uncheckedExeption(롤백 함)
    @Transactional
    public void txTest4() {

        userMapper.deleteAuthorities();
        userMapper.deleteUsers();

        throw new RuntimeException("RuntimeException for rollback");
    }

    // CheckedExeption 테스트(롤백 안함)
    @Transactional
    public void txTest5() throws SQLException  {
        //try {
            userMapper.deleteAuthorities();
            userMapper.deleteUsers();

            throw new SQLException("SQLException for rollback");

        // } catch (Exception e) {
            // 개발자가 기본적으로 에러처리에 대한 코딩을 한다는 의미임
            // 롤백하지는 않는다. 개발자가 알아서.

       // }

        // @Transactional 했는데 롤백 안됨. 이유는? test4와 어떤 차이?
        // Checked Exception 과 Unchecked Exception 의 차이.
        // 예외처리가 반드시 필요하다. try-catch
    }
    
    //@Transactional의 rollabackFor 옵션을 이용하면 Rollback이 되는 클래스를 지엉
    @Transactional(rollbackFor = SQLException.class)
    public void txTest6() throws SQLException  {

        userMapper.deleteAuthorities();
            userMapper.deleteUsers();

            throw new SQLException("SQLException for rollback");
    
    }
    
    //@Transactional의 rollbackFor 옵션을 이용하면 Rollback이 되는 클래스를 지정가능함.
    // Exception예외로 롤백을 하려면 다음과 같이 지정하면됩니다. 
    //@Transactional(rollbackFor = Exception.class) 
    // 여러개의 예외를 지정할 수도 있습니다. @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    @Transactional(rollbackFor = Exception.class)    
    public void txTest7() {
        try {
       userMapper.deleteAuthorities();
       userMapper.deleteUsers();
       
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
}