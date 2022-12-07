package com.example;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SuggestionDAO{
    @Autowired
    SqlSession sqlSession;

    public int insertSug(SuggestionVO vo){
        int result = sqlSession.insert("Suggestion.insertSug",vo);
        return result;
    }

    public int updateSug(SuggestionVO vo){
        int result = sqlSession.insert("Suggestion.updateSug",vo);
        return result;
    }

    public int deleteSug(int personID){
        int result = sqlSession.delete("Suggestion.deleteSug", personID);
        return result;
    }

    public SuggestionVO getSug(int personID){
        SuggestionVO one = sqlSession.selectOne("Suggestion.getSug", personID);
        return one;
    }

    public List<SuggestionVO> getSugList(){
        List<SuggestionVO> list = sqlSession.selectList("Suggestion.getSugList");
        return list;
    }

}
