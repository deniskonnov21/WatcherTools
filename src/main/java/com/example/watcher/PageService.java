package com.example.watcher;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

@Service
public class PageService {
   public String extractData(String url) throws Exception {
       Document doc = Jsoup.connect(url).get();
       Elements elements = doc.select("a");
       return elements.stream().map(e -> e.text()+"|"+e.attr("href")).reduce("", String::concat);
   }

    // public List<Product> getProducts(String url) throws Exception {

    //     Document doc = Jsoup.connect(url).get();

    //     List<Product> result = new ArrayList<>();

    //     Elements rows = doc.select("tr"); // или нужный selector

    //     for (Element row : rows) {

    //         Elements cols = row.select("td");

    //         if (cols.size() >= 2) {
    //             String name = cols.get(0).text();
    //             String price = cols.get(1).text();

    //             if (!name.isEmpty()) {
    //                 result.add(new Product(name, price));
    //             }
    //         }
    //     }

    //     return result;
    // }

}
