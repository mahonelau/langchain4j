package dev.langchain4j.data.document.loader;

import dev.langchain4j.data.document.KmsDocument;
import dev.langchain4j.data.document.source.KmsDocSource;
import dev.langchain4j.data.document.source.KmsFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static dev.langchain4j.data.document.source.KmsFileSource.from;
import static dev.langchain4j.internal.Exceptions.illegalArgument;

public class KmsFileLoader {

    private static final Logger log = LoggerFactory.getLogger(KmsFileLoader.class);

    private KmsFileLoader() {
    }

    /**
     * Loads a document from the specified file.
     * Returned document contains all the textual information from the file.
     *
     * @param text           kms Document extracted text.
     * @param fileId          kms Document  fileId.
     * @param docId          kms Document docId.
     * @param topicCode          kms Document topicCode.
     * @return document
     * @throws IllegalArgumentException If specified path is not a file.
     */
    public static KmsDocument loadDocument(String text, String fileId, String docId, String[] topicCode, String title,int entType) {
        //entType 1:doc,2:file
        if ( entType != 2 || (fileId == null && docId == null)) {
            throw illegalArgument("entType:%s or entId:%s is error", entType, fileId + docId);
        }

        return load(from(text,fileId,docId,topicCode,title,entType));
    }

    /**
     * Loads a document from the given source using the given parser.
     *
     * <p>Forwards the source Metadata to the parsed Document.
     *
     * @param source The source from which the document will be loaded.
     * @return The loaded document.
     */
    public static KmsDocument load(KmsFileSource source) {
        KmsDocument kmsDocument = KmsDocument.from(source);
        source.metadata().toMap().forEach((key, value) -> kmsDocument.metadata().add(key, value));
        return kmsDocument;
//        try (InputStream inputStream = source.inputStream()) {
//            Document document = parser.parse(inputStream);
//            source.metadata().asMap().forEach((key, value) -> document.metadata().add(key, value));
//            return document;
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to load document", e);
//        }
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
