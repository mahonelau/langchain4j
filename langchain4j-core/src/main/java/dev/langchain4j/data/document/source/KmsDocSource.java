package dev.langchain4j.data.document.source;

import dev.langchain4j.data.document.DocumentSource;
import dev.langchain4j.data.document.KmsDocBase;
import dev.langchain4j.data.document.Metadata;
import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;

public class KmsDocSource implements DocumentSource {

    public KmsDocBase kmsDocBase;
    @Getter
    public String text;

    public KmsDocSource(String text, String docId, String[] topicCode, String title,Integer entType,int releaseFlag) {
        this.kmsDocBase = new KmsDocBase();
        this.text = text;
        this.kmsDocBase.setTitle(title);
        this.kmsDocBase.setEntType(entType);
        this.kmsDocBase.setDocId(docId);
        this.kmsDocBase.setTopicCodes(topicCode);
        this.kmsDocBase.setReleaseFlag(releaseFlag);
    }
    
    public KmsDocSource(String text, KmsDocBase kmsDocBase) {
        this.text = text;
        this.kmsDocBase = kmsDocBase;
    }

    @Override
    public InputStream inputStream() throws IOException {
        return null;
    }

    @Override
    public Metadata metadata() {
        return KmsDocBase.properties2Metadata(kmsDocBase);
    }

    public static KmsDocSource from(String text, String docId, String[] topicCode,String title, Integer entType,int releaseFlag) {
        return new KmsDocSource(text,docId,topicCode,title,entType,releaseFlag);
    }

    public static KmsDocSource from(String text, KmsDocBase kmsDocBase) {
        return new KmsDocSource(text,kmsDocBase);
    }
}
