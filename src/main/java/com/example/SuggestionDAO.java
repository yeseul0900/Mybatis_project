package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SuggestionDAO{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insertSug(SuggestionVO vo){
        String sql = "insert into p_suggestion (name, nickname, s_number, major, department, category, suggestion) values ("
                +"'"+"vo.getName()"+"',"
                +"'"+"vo.getNickname()"+"',"
                +"'"+"vo.getS_number()"+"',"
                +"'"+"vo.getMajor()"+"',"
                +"'"+"vo.getDepartment()"+"',"
                +"'"+"vo.getCategory()"+"',"
                +"'"+"vo.getSuggestion()"+"')";
        return jdbcTemplate.update(sql);
    }

    public int updateSug(SuggestionVO vo){
        String sql = "update p_suggestion set name = '"+vo.getName()+"'," +
                "nickname ='" +vo.getNickname()+"'," +
                "s_number ='" +vo.getS_number()+"'," +
                "major ='" +vo.getMajor()+"'," +
                "department ='" +vo.getDepartment()+"'," +
                "category ='" +vo.getCategory()+"'," +
                "suggestions ='" +vo.getSuggestion()+"'," +
                "where personID =" +vo.getPersonID();
        return jdbcTemplate.update(sql);
    }

    public int deleteSug(int personID){
        String sql = "delete from p_suggestion  where personID=?";
        return jdbcTemplate.update(sql);
    }

    class SugRowMapper implements RowMapper<SuggestionVO>{
        public SuggestionVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            SuggestionVO vo = new SuggestionVO();
            vo.setPersonID(rs.getInt("personID"));
            vo.setName(rs.getString("name"));
            vo.setNickname(rs.getString("nickname"));
            vo.setS_number(rs.getInt("s_number"));
            vo.setMajor(rs.getString("major"));
            vo.setDepartment(rs.getString("department"));
            vo.setCategory(rs.getString("category"));
            vo.setSuggestion(rs.getString("suggestions"));
            vo.setRegdate(rs.getDate("regdate"));
            return vo;
        }
    }

    public SuggestionVO getSug(int personID){
        String sql = "select * from p_suggestion where personID="+personID;
        return jdbcTemplate.queryForObject(sql, new SugRowMapper());
    }

    public List<SuggestionVO> getSugList(){
        String sql = "select * from p_suggestion order by regdate desc";
        return jdbcTemplate.query(sql, new SugRowMapper());
    }

}
