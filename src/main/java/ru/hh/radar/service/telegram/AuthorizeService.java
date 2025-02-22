package ru.hh.radar.service.telegram;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface AuthorizeService {

    SendMessage showAuthorizeButton(Update update) throws TelegramApiException;
}
