package dev.langchain4j.data.document.source;

import dev.langchain4j.data.document.DocumentSource;
import dev.langchain4j.data.document.Metadata;
import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static dev.langchain4j.data.document.KmsDocument.*;

public class KmsDocSource implements DocumentSource {

    public int entType ;
    public String docId;
    public String title;
    public String[] topicCode;
    @Getter
    public String text;

    public KmsDocSource(String text, String docId, String[] topicCode, String title,int entType) {
        this.title = title;
        this.entType = entType;
        this.docId = docId;
        this.topicCode = topicCode;
        this.text = text;
    }

    @Override
    public InputStream inputStream() throws IOException {
        return null;
    }

    @Override
    public Metadata metadata() {
        Metadata metadata = new Metadata()
                .add(TITLE, title)
                .add(DOC_ID, docId)
                .add(ENT_TYPE, entType);
        if(topicCode!=null && topicCode.length>0)
            metadata = metadata.add(TOPIC_CODE, topicCode);

        return metadata;
    }

    public static KmsDocSource from(String text, String docId, String[] topicCode,String title, int entType) {
        return new KmsDocSource(text,docId,topicCode,title,entType);
    }

}
