package edu.bit.ex.mapper;

import org.apache.ibatis.annotations.Mapper;

import edu.bit.ex.vo.EmpVO;



@Mapper
public interface EmpMapper  {
	  
    public EmpVO getEmp(String ename);
    
    
}