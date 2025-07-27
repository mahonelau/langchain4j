package dev.langchain4j.data.document;

import lombok.Getter;
import lombok.Setter;

@Getter
public class KmsDocBase {
  /**
   * Common metadata key for the name of the file from which the document was loaded.
   */
  public static final Integer ENT_TYPE_DOC = 1;
  public static final Integer ENT_TYPE_FILE = 2;
  
  public static final String TITLE = "title";
  public static final String ENT_TYPE = "entType";
  public static final String FILE_ID = "fileId";
  public static final String DOC_ID = "docId";
  public static final String TOPIC_CODES = "topicCodes";
  public static final String RELEASE_FLAG = "releaseFlag";
  public static final String PUBLIC_REMARK = "publicRemark";
  public static final String CATEGORY = "category";
  public static final String ORG_CODE = "orgCode";
  public static final String RESTRICT_ACCESS_LEVEL = "restrictAccessLevel";
  public static final String CREATE_BY = "createBy";
  public static final String AUTHED_ORG_CODES = "authedOrgCodes";
  public static final String AUTHED_ROLES = "authedRoles";
  public static final String AUTHED_USER_IDS = "authedUserIds";

  //entType: 1-doc,2-file
  @Setter
  public Integer entType ;
  @Setter
  public String fileId;
  @Setter
  public String docId;
  @Setter
  public Integer releaseFlag ;
  @Setter
  public String title;
  @Setter
  public String[] topicCodes;
  //状态：0-内部公开 1-对外公开
  @Setter
  private Integer publicRemark;
  @Setter
  private String category;
  @Setter
  private String restrictAccessLevel;
  @Setter
  private String orgCode;
  @Setter
  private String createBy;
  @Setter
  private String[] authedOrgCodes;
  @Setter
  private String[] authedRoles;
  @Setter
  private String[] authedUserIds;
  
  public static Metadata properties2Metadata(KmsDocBase kmsDocBase) {
    Metadata metadata = new Metadata()
            .add(ENT_TYPE, kmsDocBase.getEntType())
            .add(TITLE, kmsDocBase.getTitle())
            .add(DOC_ID,kmsDocBase.getDocId())
            .add(RELEASE_FLAG,kmsDocBase.getReleaseFlag());

    if(kmsDocBase.getFileId() !=null && !kmsDocBase.getFileId().isEmpty())
      metadata = metadata.add(FILE_ID, kmsDocBase.getFileId());
    if(kmsDocBase.getTopicCodes()!=null && kmsDocBase.getTopicCodes().length > 0)
      metadata = metadata.add(TOPIC_CODES, kmsDocBase.getTopicCodes());

    if(kmsDocBase.getCategory() !=null && !kmsDocBase.getCategory().isEmpty())
      metadata = metadata.add(CATEGORY, kmsDocBase.getCategory());
    if(kmsDocBase.getOrgCode() !=null && !kmsDocBase.getOrgCode().isEmpty())
      metadata = metadata.add(ORG_CODE, kmsDocBase.getOrgCode());
    if(kmsDocBase.getPublicRemark() !=null)
      metadata = metadata.add(PUBLIC_REMARK, kmsDocBase.getPublicRemark());
    if(kmsDocBase.getCreateBy() !=null && !kmsDocBase.getCreateBy().isEmpty())
      metadata = metadata.add(CREATE_BY, kmsDocBase.getCreateBy());
    if(kmsDocBase.getRestrictAccessLevel() !=null && !kmsDocBase.getRestrictAccessLevel().isEmpty())
      metadata = metadata.add(RESTRICT_ACCESS_LEVEL, kmsDocBase.getRestrictAccessLevel());
    if(kmsDocBase.getAuthedUserIds()!=null && kmsDocBase.getAuthedUserIds().length > 0)
      metadata = metadata.add(AUTHED_USER_IDS, kmsDocBase.getAuthedUserIds());
    if(kmsDocBase.getAuthedRoles()!=null && kmsDocBase.getAuthedRoles().length > 0)
      metadata = metadata.add(AUTHED_ROLES, kmsDocBase.getAuthedRoles());
    if(kmsDocBase.getAuthedOrgCodes()!=null && kmsDocBase.getAuthedOrgCodes().length > 0)
      metadata = metadata.add(AUTHED_ORG_CODES, kmsDocBase.getAuthedOrgCodes());
    
    return metadata;
  }
  
}
