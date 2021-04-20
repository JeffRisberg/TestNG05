package com.company.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class KnowledgeArticle {
  protected Long id;
  protected String title;
  protected String body;
}
