package com.wortex.backend.web.translator.service.db;

import com.wortex.backend.web.translator.model.Translation;
import com.wortex.backend.web.translator.service.db.model.Word;

import java.util.List;

public interface DbService {

    List<Word> getAllWordsOnly();

    void save(Translation translation);

    Translation find(String word);

    void delete(String word);
}
