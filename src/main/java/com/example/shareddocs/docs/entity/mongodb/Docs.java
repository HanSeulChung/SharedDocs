package com.example.shareddocs.docs.entity.mongodb;

import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collation = "shared-docs")
public class Docs {

  @Id
  @Field(name = "_id")
  private String id;

  @Field(name = "title")
  private String title;

  @Field(name = "content")
  private String content;

  @Field(name = "member_id")
  private Long memberId;

}
