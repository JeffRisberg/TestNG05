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
public class KnowledgeArticleMatcherTest {

  private static KnowledgeArticleStore kaStore;
  private static KnowledgeArticleMatcher kamService;

  @BeforeSuite
  public void setUp() {
    kaStore = new KnowledgeArticleStore();

    KnowledgeArticle ka;

    ka = new KnowledgeArticle(1L, "VPN network trouble", "Install client software version 1.2.3.4");
    kaStore.addKnowledgeArticle(ka);
    ka = new KnowledgeArticle(2L, "Forgot My Password", "Reset using okta master login");
    kaStore.addKnowledgeArticle(ka);
    ka = new KnowledgeArticle(3L, "4th Floor Printer", "printer supports color");
    kaStore.addKnowledgeArticle(ka);
    ka = new KnowledgeArticle(4L, "Discount Terms", "Only for 501c3 organizations");
    kaStore.addKnowledgeArticle(ka);
    ka = new KnowledgeArticle(5L, "Devices supported", "Windows, Mac");
    kaStore.addKnowledgeArticle(ka);
    ka = new KnowledgeArticle(6L, "Acme store location", "34 Main Street, Palo Alto");
    kaStore.addKnowledgeArticle(ka);
    ka = new KnowledgeArticle(7L, "BigBox store location", "Ravenswood, East Palo Alto");
    kaStore.addKnowledgeArticle(ka);

    kamService = new KnowledgeArticleMatcher(kaStore);
  }

  @Test(priority = 2)
  public void getKnowledgeArticleByRequest() {
    //
    // When
    //
    KnowledgeArticle result = kamService.getKnowledgeArticle("Forgot My Password");

    //
    // Verify
    //
    assertEquals(result.getBody(), "Reset using okta master login");
  }

  @Test(priority = 3, dataProvider = "requestProvider", dataProviderClass = RequestProvider.class)
  public void getKnowledgeArticleTest(String request, Long id) {
    System.out.println("request: " + request + ", id: " + id);

    KnowledgeArticle result = kamService.getKnowledgeArticle(request);
    assertNotNull(result);
    assertEquals(result.getId(), id);
  }
}
