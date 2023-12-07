package com.example.shareddocs.docs.entity.mongodb;

import java.time.LocalDateTime;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Builder
@Document(collection = "shared-docs")
@AllArgsConstructor
@NoArgsConstructor
public class Docs {

  @Id
  @Field(name = "_id")
  private String id;

  @Field(name = "document_idx")
  private String documentIdx;

  @Field(name = "title")
  private String title;

  @Field(name = "content")
  private String content;

  @Field(name = "writer_id")
  private Long writerId;

  @Field(name = "modifier_id")
  private Long modifierId;

  @Field(name = "team_id")
  private Long teamId;

  // Todo : Comment

//  @Field(name = "member_id")
//  private List<Long> memberId;

  @CreatedDate
  @Field(name = "created_dt")
  private LocalDateTime createdDt;
  @LastModifiedDate
  @Field(name = "updated_dt")
  private LocalDateTime updatedDt;

}
