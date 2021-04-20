package com.company;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import com.company.models.KnowledgeArticle;
import com.company.services.KnowledgeArticleMatcher;
import com.company.stores.KnowledgeArticleStore;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@Slf4j
public class KnowledgeArticleStoreTest {

  private static KnowledgeArticleStore kaStore;

  @BeforeSuite
  public void setUp() {
    kaStore = new KnowledgeArticleStore();

    KnowledgeArticle ka;

    ka = new KnowledgeArticle(1L, "VPN network trouble", "Install client software version 1.2.3.4");
    kaStore.addKnowledgeArticle(ka);
    ka = new KnowledgeArticle(2L, "Forgot My Password", "Reset using okta master login");
    kaStore.addKnowledgeArticle(ka);
  }

  @Test
  public void getKnowledgeArticleById() {
    //
    // When
    //
    KnowledgeArticle result = kaStore.findById(1L);

    //
    // Verify
    //
    assertEquals(result.getTitle(), "VPN network trouble");
  }
}
