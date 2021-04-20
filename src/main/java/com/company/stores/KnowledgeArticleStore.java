package com.company.stores;

import com.company.models.KnowledgeArticle;
import java.util.*;

public class KnowledgeArticleStore {

  private List<KnowledgeArticle> knowledgeArticles;
  private List<Set<String>> knowledgeArticleTokens;

  public KnowledgeArticleStore() {
    knowledgeArticles = new ArrayList<KnowledgeArticle>();
    knowledgeArticleTokens = new ArrayList<Set<String>>();
  }

  public void addKnowledgeArticle(KnowledgeArticle knowledgeArticle) {
    String[] tokens = knowledgeArticle.getTitle().toLowerCase().split(" ");
    Set<String> tokenSet = new HashSet(Arrays.asList(tokens));

    knowledgeArticles.add(knowledgeArticle);
    knowledgeArticleTokens.add(tokenSet);
  }

  public KnowledgeArticle findById(long id) {
    for (KnowledgeArticle ka : knowledgeArticles) {
      if (ka.getId() == id) return ka;
    }
    return null;
  }

  public int size() {
    return knowledgeArticles.size();
  }

  public KnowledgeArticle getArticleAt(int index) {
    return knowledgeArticles.get(index);
  }

  public Set<String> getTokensAt(int index) {
    return knowledgeArticleTokens.get(index);
  }

  public List<KnowledgeArticle> getAll() {
    return knowledgeArticles;
  }
}
