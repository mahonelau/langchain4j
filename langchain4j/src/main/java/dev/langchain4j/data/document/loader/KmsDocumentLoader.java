package dev.langchain4j.data.document.loader;

import dev.langchain4j.data.document.KmsDocument;
import dev.langchain4j.data.document.source.KmsDocumentSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dev.langchain4j.data.document.source.KmsDocumentSource.from;
import static dev.langchain4j.internal.Exceptions.illegalArgument;

public class KmsDocumentLoader {

    private static final Logger log = LoggerFactory.getLogger(KmsDocumentLoader.class);

    private KmsDocumentLoader() {
    }

    /**
     * Loads a document from the specified file.
     * Returned document contains all the textual information from the file.
     *
     * @param text           kms Document extracted text.
     * @param entId          kms Document docId or fileId.
     * @param filePath       kms Document file path.
     * @return document
     * @throws IllegalArgumentException If specified path is not a file.
     */
    public static KmsDocument loadDocument(String text,int entType,String entId,String filePath) {
        //entType 1:doc,2:file
        if ((entType != 1 && entType != 2) || entId == null) {
            throw illegalArgument("entType:%s or entId:%s is error", entType,entId);
        }

        return load(from(text,entType,entId,filePath));
    }

    /**
     * Loads a document from the given source using the given parser.
     *
     * <p>Forwards the source Metadata to the parsed Document.
     *
     * @param source The source from which the document will be loaded.
     * @return The loaded document.
     */
    public static KmsDocument load(KmsDocumentSource source) {
        KmsDocument kmsDocument = KmsDocument.from(source);
        source.metadata().asMap().forEach((key, value) -> kmsDocument.metadata().add(key, value));
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
