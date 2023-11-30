package com.example.shareddocs.docs.entity.mongodb;

import java.time.LocalDateTime;
import java.util.List;
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

  @Field(name = "room_idx")
  private String roomIdx;

  @Field(name = "title")
  private String title;

  @Field(name = "content")
  private String content;

  @Field(name = "create_member_id")
  private Long createMemberId;

  @Field(name = "member_id")
  private List<Long> memberId;

  @CreatedDate
  @Field(name = "created_dt")
  private LocalDateTime createdDt;
  @LastModifiedDate
  @Field(name = "updated_dt")
  private LocalDateTime updatedDt;

}
