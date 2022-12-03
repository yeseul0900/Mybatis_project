package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SugServiceImpl implements SugService{
    @Autowired
    SuggestionDAO suggestionDAO;

    @Override
    public int insertSug(SuggestionVO vo) {
        return suggestionDAO.insertSug(vo);
    }

    @Override
    public int deleteSug(int personID) {
        return suggestionDAO.deleteSug(personID);
    }

    @Override
    public int updateSug(SuggestionVO vo) {
        return suggestionDAO.updateSug(vo);
    }

    @Override
    public SuggestionVO getSug(int personID) {
        return suggestionDAO.getSug(personID);
    }

    @Override
    public List<SuggestionVO> getSugList() {
        return suggestionDAO.getSugList();
    }
}
