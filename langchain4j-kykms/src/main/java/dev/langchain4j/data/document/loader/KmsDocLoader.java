package dev.langchain4j.data.document.loader;

import dev.langchain4j.data.document.KmsDocBase;
import dev.langchain4j.data.document.KmsDocument;
import dev.langchain4j.data.document.source.KmsDocSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

import static dev.langchain4j.data.document.source.KmsDocSource.from;
import static dev.langchain4j.internal.Exceptions.illegalArgument;

public class KmsDocLoader {

    private static final Logger log = LoggerFactory.getLogger(KmsDocLoader.class);
    private static KmsDocSource source;

    private KmsDocLoader() {
    }

    /**
     * Loads a document from the specified file.
     * Returned document contains all the textual information from the file.
     *
     * @param text           kms Document extracted text.
     * @param docId          kms Document docId.
     * @param topicCode          kms Document topicCode.
     * @return document
     * @throws IllegalArgumentException If specified path is not a file.
     */
    public static KmsDocument loadDocument(String text, String docId, String[] topicCode, String title,Integer entType,int releaseFlag) {
        //entType 1:doc,2:file
        if (!Objects.equals(entType, KmsDocBase.ENT_TYPE_DOC) || docId == null) {
            throw illegalArgument("entType:%s or docId:%s is error", entType,  docId);
        }

        return load(from(text,docId,topicCode,title,entType,releaseFlag));
    }    
    
    /**
     * Loads a document from the specified file.
     * Returned document contains all the textual information from the file.
     *
     * @param text           kms Document extracted text.
     * @param kmsDocBase     kmsDocBase.
     * @return document
     * @throws IllegalArgumentException If specified path is not a file.
     */
    public static KmsDocument loadDocument(String text, KmsDocBase kmsDocBase) {
        if (!Objects.equals(kmsDocBase.getEntType(), KmsDocBase.ENT_TYPE_DOC) || kmsDocBase.getDocId() == null) {
            throw illegalArgument("entType:%s or docId:%s is error", kmsDocBase.getEntType(),  kmsDocBase.getDocId());
        }

        return load(from(text,kmsDocBase));
    }

    /**
     * Loads a document from the given source using the given parser.
     *
     * <p>Forwards the source Metadata to the parsed Document.
     *
     * @param source The source from which the document will be loaded.
     * @return The loaded document.
     */
    public static KmsDocument load(KmsDocSource source) {
        KmsDocument kmsDocument = KmsDocument.from(source);
        source.metadata().toMap().forEach((key, value) -> kmsDocument.metadata().add(key, value));
        
        kmsDocument.setKmsDocBase(source.kmsDocBase);
        return kmsDocument;
    }
    /**
     * Loads a document from the specified file.
     * Returned document contains all the textual information from the file.
     *
     * @param filePath       The path to the file.
     * @param documentParser The parser to be used for parsing text from the file.
     * @return document
     * @throws IllegalArgumentException If specified path is not a file.
     */
//    public static Document loadDocument(String text,String filePath, DocumentParser documentParser) {
//        return loadDocument(text,Paths.get(filePath), documentParser);
//    }

}
