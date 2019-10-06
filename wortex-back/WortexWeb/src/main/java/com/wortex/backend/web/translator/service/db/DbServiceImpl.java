package com.wortex.backend.web.translator.service.db;

import com.google.common.collect.Lists;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.wortex.backend.web.translator.model.Translation;
import com.wortex.backend.web.translator.service.db.model.Word;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.include;

public class DbServiceImpl implements DbService {

    private MongoClient client = new MongoClient();
    private MongoDatabase wordsDb;
    private MongoCollection<Translation> translations;
    private static final String WORDS_DB_NAME = "words";

    public DbServiceImpl() {

        String translationPackageName = Translation.class.getPackageName();
        CodecProvider translationModelCodecProvider =
                PojoCodecProvider.builder().register(translationPackageName)
                .build();
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                MongoClient.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(translationModelCodecProvider)
        );

        wordsDb = client.getDatabase(WORDS_DB_NAME).withCodecRegistry(codecRegistry);
        translations = wordsDb.getCollection("translations", Translation.class);
    }

    @Override
    public List<Word> getAllWordsOnly() {
        return Lists.newArrayList(translations.find().projection(include("word", "pos"))
                .map(translation -> new Word(translation.getWord(), translation.getPos())));
    }

    @Override
    public void save(Translation translation) {
        translations.insertOne(translation);
    }

    @Override
    public Translation find(String word) {
        return translations.find(eq("_id", word)).first();
    }

    @Override
    public void delete(String word) {
        translations.deleteOne(eq("word", word));
    }
}
