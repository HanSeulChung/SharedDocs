package com.example.shareddocs.docs.entity.mongodb;

import java.util.List;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Document(collection = "shared-docs")
@AllArgsConstructor
@NoArgsConstructor
public class Docs {

  @Id
  @Field(name = "_id")
  private String id;

  @Field(name = "room_idx")
  private Long roomIdx;

  @Field(name = "title")
  private String title;

  @Field(name = "content")
  private String content;

  @Field(name = "create_member_id")
  private Long createMemberId;

  @Field(name = "member_id")
  private List<Long> memberId;

}
