package com.example.shareddocs.docs.entity.mysql;

import com.example.shareddocs.base.BaseEntity;
import com.vladmihalcea.hibernate.type.json.JsonType;
import java.util.HashMap;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@TypeDef(name = "json", typeClass = JsonType.class)
public class Documents extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long documentsId;
  private String title;
  private Long roomIdx;
  private Long writerId;
  private Long modifierId;

  @Type(type = "json")
  @Column(columnDefinition = "json")
  private HashMap<Long, String> documentsParticipantMap = new HashMap<>();

  // TODO: 팀과 댓글은 없이 문서만 test
//  @ManyToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "teamId")
//  private Team team;

//  @OneToMany(mappedBy = "documents")
//  private List<Comment> comments = new ArrayList<>();
}
