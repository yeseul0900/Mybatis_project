package com.example;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class UserDAO {
    @Autowired
    SqlSessionTemplate sqlSession;
    public UserVO getUser(UserVO vo){
        return sqlSession.selectOne("User.getUser", vo);
    }
    @Service
    public class UserServiceImpl{
        @Autowired
        UserDAO userDAO;
        public UserVO getUser(UserVO vo){
            return userDAO.getUser(vo);
        }
    }

}
