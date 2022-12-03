package com.example;
import java.util.List;

public interface SugService {
    public int insertSug(SuggestionVO vo);
    public int deleteSug(int personID);
    public int updateSug(SuggestionVO vo);
    public SuggestionVO getSug(int personID);
    public List<SuggestionVO> getSugList();
}
