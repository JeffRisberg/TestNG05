package com.company.services;

import com.company.models.KnowledgeArticle;
import com.company.stores.KnowledgeArticleStore;
import com.google.common.collect.Sets;
import java.util.*;

public class KnowledgeArticleMatcher {

  private KnowledgeArticleStore kaStore;

  public KnowledgeArticleMatcher(KnowledgeArticleStore kaStore) {
    this.kaStore = kaStore;
  }

  public KnowledgeArticle getKnowledgeArticle(String request) {
    String[] requestTokens = request.toLowerCase().split(" ");
    Set<String> requestTokenSet = new HashSet<String>(Arrays.asList(requestTokens));

    KnowledgeArticle result = null;
    int maxMatch = 0;

    for (int i = 0; i < kaStore.size(); i++) {
      Set<String> tokens = kaStore.getTokensAt(i);
      int match = Sets.intersection(requestTokenSet, tokens).size();

      if (match > maxMatch) {
        result = kaStore.getArticleAt(i);
        maxMatch = match;
      }
    }

    return result;
  }
}
