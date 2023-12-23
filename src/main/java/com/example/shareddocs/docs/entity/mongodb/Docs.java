package com.example.shareddocs.docs.entity.mongodb;

import java.time.LocalDateTime;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Builder
@Document(collection = "Documents")
@AllArgsConstructor
@NoArgsConstructor
public class Docs {

  @Id
  private String id;

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

//  @DocumentReference
//  @Field(name = "comment_ids")
//  @Builder.Default
//  private List<Comment> commentIds = new ArrayList<>();;

  @Field(name = "modifier_id")
  private Long modifierId;

  @Field(name = "team_id")
  private Long teamId;

  @CreatedDate
  @Field(name = "created_dt")
  private LocalDateTime createdDt;
  @LastModifiedDate
  @Field(name = "updated_dt")
  private LocalDateTime updatedDt;

}
