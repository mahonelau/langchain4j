package dev.langchain4j.data.document;

import dev.langchain4j.data.document.source.KmsDocSource;
import dev.langchain4j.data.document.source.KmsFileSource;

public class KmsDocument extends Document {

  /**
   * Common metadata key for the name of the file from which the document was loaded.
   */
  public static final String TITLE = "title";
  public static final String ENT_TYPE = "ent_type";
  public static final String FILE_ID = "file_id";
  public static final String DOC_ID = "doc_id";
  public static final String TOPIC_CODE = "topic_code";

  public KmsDocument(String text, Metadata metadata) {
    super(text, metadata);
  }
  public KmsDocument(String text) {
    super(text);
  }

  public static KmsDocument from(KmsDocSource source) {
    return new KmsDocument(source.getText());
  }
  public static KmsDocument from(KmsFileSource source) {
    return new KmsDocument(source.getText());
  }
}
