package ru.hh.radar.service.telegram.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.hh.radar.service.common.UserService;
import ru.hh.radar.service.hh.HhOauthService;
import ru.hh.radar.service.telegram.AuthorizeService;
import ru.hh.radar.telegram.service.TelegramElementService;
import ru.hh.radar.telegram.service.TelegramMessageService;

@SuppressWarnings("unchecked")
@Service
@RequiredArgsConstructor
public class AuthorizeServiceImpl implements AuthorizeService {

    private final TelegramMessageService tgmMessageService;
    private final TelegramElementService tgmElementService;

    private final HhOauthService hhOauthService;
    private final UserService userService;

    @Override
    public SendMessage showAuthorizeButton(Update update) throws TelegramApiException {
        String lang = userService.getLocaleForAnswerToUser(update);
        String link = hhOauthService.getUserAuthorizeURI().toString();

        InlineKeyboardButton linkButton = tgmElementService.createUrlButton("Подтвердить авторизацию", link);
        InlineKeyboardMarkup inlineKeyboardMarkup = tgmElementService.createInlineKeyboardMarkup(
                tgmElementService.createInlineKeyboardRows(
                        tgmElementService.createInlineKeyboardRow(linkButton)
                )
        );

        return tgmMessageService.createButtonMessage(
                userService.findUser(update).getChatId(),
                inlineKeyboardMarkup
        );
    }
}
