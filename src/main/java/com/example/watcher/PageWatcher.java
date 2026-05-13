package com.example.watcher;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;

//@Component
//@RequiredArgsConstructor
//public class PageWatcher {
//    private final PageService pageService;
//    private final PageState state;
//    private final TelegramService telegramService;
//    private static final String URL = "https://tools.by/catalog/markdown";
//    @Scheduled(fixedDelay = 60000)
//    public void check() {
//        try {
//            String data = pageService.extractData(URL);
//            if (state.isChanged(data)) {
//                telegramService.send("Изменения на странице: " + URL);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
@Component
@RequiredArgsConstructor
public class PageWatcher {

    private final PageService pageService;
    private final PageState state;
    private final TelegramService telegramService;

    private static final String URL = "https://tools.by/catalog/markdown";

    @Scheduled(fixedDelay = 60000)
    public void check() {

        try {
            List<Product> newProducts = pageService.getProducts(URL);

            if (state.getLastProducts().isEmpty()) {
                state.update(newProducts);
                return;
            }

            String diff = DiffUtil.buildDiff(state.getLastProducts(), newProducts);

            if (!diff.isEmpty()) {
                telegramService.send("⚡ Изменения:\n\n" + diff);
            }

            state.update(newProducts);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
