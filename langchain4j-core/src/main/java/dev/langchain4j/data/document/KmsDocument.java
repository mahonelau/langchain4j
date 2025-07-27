package dev.langchain4j.data.document;

import dev.langchain4j.data.document.source.KmsDocSource;
import dev.langchain4j.data.document.source.KmsFileSource;
import lombok.Getter;
import lombok.Setter;

@Getter
public class KmsDocument extends Document {

  /**
   * Common metadata key for the name of the file from which the document was loaded.
   */
  @Setter
  public KmsDocBase kmsDocBase;

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
