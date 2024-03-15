package dev.langchain4j.data.document;

import dev.langchain4j.data.document.source.KmsDocumentSource;

public class KmsDocument extends Document {

  /**
   * Common metadata key for the name of the file from which the document was loaded.
   */
  public static final String ENT_TYPE = "ent_type";
  public static final String ENT_ID = "ent_id";

  public KmsDocument(String text, Metadata metadata) {
    super(text, metadata);
  }
  public KmsDocument(String text) {
    super(text);
  }

  public static KmsDocument from(KmsDocumentSource source) {
//    Metadata metadata = new Metadata();
//    metadata.put(ENT_TYPE, source.getEntType());
//    metadata.put(ENT_ID, source.getEntId());
    return new KmsDocument(source.getText());
  }
}
