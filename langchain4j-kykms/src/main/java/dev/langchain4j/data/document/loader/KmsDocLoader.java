package dev.langchain4j.data.document.loader;

import dev.langchain4j.data.document.KmsDocument;
import dev.langchain4j.data.document.source.KmsDocSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static dev.langchain4j.data.document.source.KmsDocSource.from;
import static dev.langchain4j.internal.Exceptions.illegalArgument;

public class KmsDocLoader {

    private static final Logger log = LoggerFactory.getLogger(KmsDocLoader.class);

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
    public static KmsDocument loadDocument(String text, String docId, String[] topicCode, String title,int entType) {
        //entType 1:doc,2:file
        if (entType != 1 || docId == null) {
            throw illegalArgument("entType:%s or docId:%s is error", entType,  docId);
        }

        return load(from(text,docId,topicCode,title,entType));
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
        source.metadata().toMap().forEach((key, value) -> kmsDocument.metadata().put(key, value));
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
