package ru.hh.radar.telegram.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.hh.radar.dto.VacancyDTO;
import ru.hh.radar.telegram.service.TelegramElementService;
import ru.hh.radar.telegram.service.TelegramMessageService;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
@Service
@RequiredArgsConstructor
public class TelegramMessageServiceImpl implements TelegramMessageService {

    private final TelegramElementService tgmElementService;

    @Override
    public SendMessage createMessage(Long chatId, String text) {
        return new SendMessage()
                .enableMarkdown(true)
                .setChatId(chatId)
                .setText(text);
    }

    @Override
    public SendMessage createHtmlMessage(Long chatId, String html) {
        return new SendMessage()
                .enableHtml(true)
                .setChatId(chatId)
                .setText(html);
    }

    @Override
    public SendMessage createButtonMessage(Long chatId, String text, InlineKeyboardMarkup inlineKeyboardMarkup) {
        return new SendMessage()
                .setChatId(chatId)
                .setText(text)
                .setReplyMarkup(inlineKeyboardMarkup);
    }

    @Override
    public SendMessage createButtonMessage(Long chatId, InlineKeyboardMarkup inlineKeyboardMarkup) {
        return createButtonMessage(chatId, "️✏️", inlineKeyboardMarkup);
    }

    @Override
    public SendMessage createMenuMessage(Long chatId, String text, ReplyKeyboardMarkup replyKeyboardMarkup) {
        return new SendMessage()
                .setChatId(chatId)
                .setText(text)
                .setReplyMarkup(replyKeyboardMarkup);
    }

    @Override
    public List<SendMessage> createVacancyMessages(Long chatId, String linkText, List<VacancyDTO> vacancies) {
        List<SendMessage> vacancyMessages = new ArrayList<>();
        for (VacancyDTO vacancy: vacancies) {
            InlineKeyboardButton linkButton = tgmElementService.createUrlButton(linkText, vacancy.getAlternateUrl());
            InlineKeyboardMarkup inlineKeyboardMarkup = tgmElementService.createInlineKeyboardMarkup(
                    tgmElementService.createInlineKeyboardRows(
                            tgmElementService.createInlineKeyboardRow(linkButton)
                    )
            );
            vacancyMessages.add(
                    createButtonMessage(chatId, vacancy.toString(), inlineKeyboardMarkup)
            );
        }
        return vacancyMessages;
    }
}
