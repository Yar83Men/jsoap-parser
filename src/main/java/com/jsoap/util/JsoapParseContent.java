package com.jsoap.util;

import com.jsoap.model.CodeEntity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class JsoapParseContent {
    private static final List<CodeEntity> entityList = new ArrayList<>();

    public static void getContent(String content) {
        assert content != null;
        Document doc = Jsoup.parse(content);
        String cssSelector1 = "div.product-code > span.value";
        String cssSelector2 = "span.add-to-card";
        Elements elementsCode1 = doc.select(cssSelector1);
        Elements elementsCode2 = doc.select(cssSelector2);

        CodeEntity codesEntity = new CodeEntity();

        for (Element element : elementsCode1) {
            //System.out.println("Element 1 ---" + element.text());
            codesEntity.setCode1(element.text());
        }

        for (Element element : elementsCode2) {
            //System.out.println("Element 2 ---" + element.attributes().get("data-good-id"));
            codesEntity.setCode2(element.attributes().get("data-good-id"));
        }

        entityList.add(codesEntity);
    }

    public static List<CodeEntity> getEntity() {
        return entityList;
    }
}
