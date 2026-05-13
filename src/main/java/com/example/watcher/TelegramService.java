package com.example.watcher;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class TelegramService {
    private static final String TOKEN = "8632362485:AAEPlIpff7zLJWAmTmvW_yNsYSd1-FDgQzM";
    private static final String CHAT_ID = "453706821";
    private final RestTemplate restTemplate = new RestTemplate();
    public void send(String text) {
        String url = "https://api.telegram.org/bot" + TOKEN + "/sendMessage?chat_id=" + CHAT_ID + "&text=" + text;
        restTemplate.getForObject(url, String.class);
    }
}