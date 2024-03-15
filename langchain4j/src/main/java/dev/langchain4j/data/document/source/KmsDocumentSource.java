package dev.langchain4j.data.document.source;

import dev.langchain4j.data.document.Metadata;
import lombok.Getter;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import static dev.langchain4j.data.document.KmsDocument.ENT_ID;
import static dev.langchain4j.data.document.KmsDocument.ENT_TYPE;

public class KmsDocumentSource extends FileSystemSource {

    public int entType ;
    public String entId;
    @Getter
    public String text;

    public KmsDocumentSource(String text,int entType, String entId, Path path) {
        super(path);
        this.entType = entType;
        this.entId = entId;
        this.text = text;
    }

    @Override
    public Metadata metadata() {
        return super.metadata()
                .add(ENT_ID, entId)
                .add(ENT_TYPE, entType);
    }

    public static KmsDocumentSource from(String text,int entType, String entId, Path filePath) {
        return new KmsDocumentSource(text,entType,entId,filePath);
    }

    public static KmsDocumentSource from(String text,int entType, String entId, String filePath) {
        return new KmsDocumentSource(text,entType,entId,Paths.get(filePath));
    }

    public static KmsDocumentSource from(String text,int entType, String entId, URI fileUri) {
        return new KmsDocumentSource(text,entType,entId,Paths.get(fileUri));
    }

    public static KmsDocumentSource from(String text,int entType, String entId, File file) {
        return new KmsDocumentSource(text,entType,entId,file.toPath());
    }
}
