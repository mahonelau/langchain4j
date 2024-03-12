package dev.langchain4j.data.document;

public class KmsDocument extends Document {

  /**
   * Common metadata key for the name of the file from which the document was loaded.
   */
  public static final String ENT_TYPE = "ENT_TYPE";
  public static final String ENT_ID = "ENT_ID";

  public KmsDocument(String text, Metadata metadata) {
    super(text, metadata);
  }
}
