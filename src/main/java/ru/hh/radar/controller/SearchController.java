package ru.hh.radar.controller;

import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.hh.radar.model.SearchParameters.SearchParam;
import ru.hh.radar.service.telegram.SearchService;
import ru.hh.radar.telegram.annotations.BotController;
import ru.hh.radar.telegram.annotations.BotRequestMapping;

import java.util.List;

@BotController
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @BotRequestMapping("search.start")
    public SendMessage startSearch(Update update) throws TelegramApiException {
        return searchService.showSearchMenu(update);
    }

    @BotRequestMapping("search.experience")
    public SendMessage showExperienceMenu(Update update) throws TelegramApiException {
        return searchService.showExperienceMenu(update);
    }

    @BotRequestMapping(value = {
            "/search.experience.noExperience", "/search.experience.between1And3",
            "/search.experience.between3And6", "/search.experience.moreThan6"
    })
    public SendMessage setExperienceMenu(Update update) throws TelegramApiException {
        return searchService.setSearchParameters(SearchParam.EXPERIENCE, update, true);
    }

    @BotRequestMapping("search.employment")
    public SendMessage showEmploymentMenu(Update update) throws TelegramApiException {
        return searchService.showEmploymentMenu(update);
    }

    @BotRequestMapping(value = {
            "/search.employment.full", "/search.employment.part", "/search.employment.project",
            "/search.employment.volunteer", "/search.employment.probation"
    })
    public SendMessage setEmploymentMenu(Update update) throws TelegramApiException {
        return searchService.setSearchParameters(SearchParam.EMPLOYMENT, update, true);
    }


    @BotRequestMapping("search.schedule")
    public SendMessage showScheduleMenu(Update update) throws TelegramApiException {
        return searchService.showScheduleMenu(update);
    }

    @BotRequestMapping(value = {
            "/search.schedule.fullDay", "/search.schedule.shift", "/search.schedule.flexible",
            "/search.schedule.remote", "/search.schedule.flyInFlyOut"
    })
    public SendMessage setScheduleMenu(Update update) throws TelegramApiException {
        return searchService.setSearchParameters(SearchParam.SCHEDULE, update, true);
    }

    @BotRequestMapping("search.area")
    public SendMessage showAreaMenu(Update update) throws TelegramApiException {
        return searchService.showAreaMenu(update);
    }

    @BotRequestMapping(value = {
            "/search.area.1", "/search.area.113", "/search.area.1438", "/search.area.88", "/search.area.1202"
    })
    public SendMessage setAreaMenu(Update update) throws TelegramApiException {
        return searchService.setSearchParameters(SearchParam.AREA, update, true);
    }

    @BotRequestMapping("search.specialization")
    public SendMessage showSpecializationMenu(Update update) throws TelegramApiException {
        return searchService.showSpecializationMenu(update);
    }

    @BotRequestMapping(value = {
            "/search.specialization.1", "/search.specialization.2", "/search.specialization.3", "/search.specialization.4",
            "/search.specialization.5", "/search.specialization.6", "/search.specialization.7", "/search.specialization.8",
            "/search.specialization.9", "/search.specialization.10", "/search.specialization.11", "/search.specialization.12",
            "/search.specialization.13", "/search.specialization.14", "/search.specialization.15", "/search.specialization.16",
            "/search.specialization.17", "/search.specialization.18", "/search.specialization.19", "/search.specialization.20",
            "/search.specialization.21", "/search.specialization.22", "/search.specialization.23", "/search.specialization.24",
            "/search.specialization.25", "/search.specialization.27", "/search.specialization.29"
    })
    public SendMessage setSpecializationMenu(Update update) throws TelegramApiException {
        return searchService.setSearchParameters(SearchParam.SPECIALIZATION, update, true);
    }

    @BotRequestMapping(value = {
            "/search.specialization.1.3", "/search.specialization.1.9", "/search.specialization.1.25", "/search.specialization.1.82",
            "/search.specialization.1.110", "/search.specialization.1.113", "/search.specialization.1.117", "/search.specialization.1.137",
            "/search.specialization.1.172", "/search.specialization.1.211", "/search.specialization.1.221", "/search.specialization.1.270",
            "/search.specialization.1.273", "/search.specialization.1.296", "/search.specialization.1.327", "/search.specialization.1.400",
            "/search.specialization.1.420", "/search.specialization.1.474", "/search.specialization.1.475"
    })
    public SendMessage setItSpecializationMenu(Update update) throws TelegramApiException {
        return searchService.setSearchParameters(SearchParam.SPECIALIZATION, update, false);
    }

    @BotRequestMapping("/search.other")
    public SendMessage show(Update update) throws TelegramApiException {
        return searchService.showSearchParameters(update);
    }

    @BotRequestMapping("search.run")
    public List<SendMessage> runSearch(Update update) throws TelegramApiException {
        return searchService.runSearch(update);
    }
}
