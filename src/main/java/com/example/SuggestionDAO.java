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
    private final String BOARD_INSERT = "insert into p_suggestion (name, nickname, s_number, major, department, category, suggestions) values (?,?,?,?,?,?,?)";
    private final String BOARD_UPDATE = "update p_suggestion set name = ?, nickname = ?, s_number = ?, major = ?, department = ?, category = ?, suggestions = ? where personID = ?";
    private final String BOARD_DELETE = "delete from p_suggestion  where personID=?";

    public int insertSug(SuggestionVO vo){
        return jdbcTemplate.update(BOARD_INSERT, new Object[]{vo.getName(), vo.getNickname(),vo.getS_number(),vo.getMajor(),vo.getDepartment(),vo.getCategory(),vo.getSuggestions()});
    }

    public int updateSug(SuggestionVO vo){
        return jdbcTemplate.update(BOARD_UPDATE, new Object[]{vo.getName(), vo.getNickname(),vo.getS_number(),vo.getMajor(),vo.getDepartment(),vo.getCategory(),vo.getSuggestions(),vo.getPersonID()});
    }

    public int deleteSug(int personID){
        return jdbcTemplate.update(BOARD_DELETE,new Object[]{personID});
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
            vo.setSuggestions(rs.getString("suggestions"));
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
