package com.example.watcher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PageState {
    private String lastHash;
    public boolean isChanged(String data) {
        String h = String.valueOf(data.hashCode());
        if (lastHash == null) { lastHash = h; return false; }
        boolean changed = !lastHash.equals(h);
        lastHash = h;
        return changed;
    }
    //new
    // private List<Product> lastProducts = new ArrayList<>();

    // public List<Product> getLastProducts() {
    //     return lastProducts;
    // }

    // public void update(List<Product> products) {
    //     this.lastProducts = products;
    // }

}
