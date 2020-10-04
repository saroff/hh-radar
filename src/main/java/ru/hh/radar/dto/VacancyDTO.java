package ru.hh.radar.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jsoup.Jsoup;
import ru.hh.radar.dto.vacancy.*;

import java.util.List;

/**
 * Вакансия
 *
 * {
 *     "id": "8331228",
 *     "description": "...",
 *     "key_skills": [
 *         {
 *             "name": "Прием посетителей"
 *         },
 *         {
 *             "name": "Первичный документооборот"
 *         }
 *     ],
 *     "schedule": {
 *         "id": "fullDay",
 *         "name": "Полный день"
 *     },
 *     "experience": {
 *         "id": "between1And3",
 *         "name": "От 1 года до 3 лет"
 *     },
 *     "address": {
 *         "city": "Москва",
 *         "street": "улица Годовикова",
 *         "building": "9с10",
 *         "metro_stations": [
 *             {
 *                 "station_name": "Алексеевская",
 *                 "line_name": "Калужско-Рижская"
 *             }
 *         ]
 *     },
 *     "alternate_url": "https://hh.ru/vacancy/8331228",
 *     "apply_alternate_url": "https://hh.ru/applicant/vacancy_response?vacancyId=8331228",
 *     "employment": {
 *         "name": "Полная занятость"
 *     },
 *     "salary": {
 *         "to": null,
 *         "from": 30000,
 *         "currency": "RUR",
 *         "gross": true
 *     },
 *     "archived": false,
 *     "name": "Секретарь",
 *     "published_at": "2013-07-08T16:17:21+0400",
 *     "employer": {
 *         "name": "HeadHunter",
 *         "url": "https://api.hh.ru/employers/1455",
 *         "alternate_url": "https://hh.ru/employer/1455"
 *     },
 *     "response_letter_required": true,
 *     "type": {
 *         "name": "Открытая"
 *     },
 *     "has_test": true,
 *     "specializations": [
 *         {
 *             "profarea_id": "4",
 *             "profarea_name": "Административный персонал",
 *             "id": "4.264",
 *             "name": "Секретарь"
 *         },
 *         {
 *             "profarea_id": "4",
 *             "profarea_name": "Административный персонал",
 *             "id": "4.181",
 *             "name": "Начальный уровень, Мало опыта"
 *         }
 *     ]
 * }
 */
public class VacancyDTO {
    /** Идентификатор вакансии */
    @JsonProperty(value = "id")
    private String id;

    /** Описание вакансии, содержит html */
    @JsonProperty(value = "description")
    private String description;

    /** Информация о ключевых навыках, заявленных в вакансии. Список может быть пустым. */
    @JsonProperty(value = "key_skills")
    private List<SkillDTO> skills;

    /** График работы. Элемент справочника schedule */
    @JsonProperty(value = "schedule")
    private ScheduleDTO schedule;

    /** Требуемый опыт работы. Элемент справочника experience */
    @JsonProperty(value = "experience")
    private ExperienceDTO experience;

    /** Адрес вакансии */
    @JsonProperty(value = "address")
    private AddressDTO address;

    /** Ссылка на представление вакансии на сайте */
    @JsonProperty(value = "alternate_url")
    private String alternateUrl;

    /** Ссылка на отклик на вакансию на сайте */
    @JsonProperty(value = "apply_alternate_url")
    private String applyAlternateUrl;

    /** Тип занятости. Элемент справочника employment. */
    @JsonProperty(value = "employment")
    private EmploymentDTO employment;

    /** Оклад */
    @JsonProperty(value = "salary")
    private SalaryDTO salary;

    /** Находится ли данная вакансия в архиве */
    @JsonProperty(value = "archived")
    private boolean archived;

    /** Название вакансии */
    @JsonProperty(value = "name")
    private String name;

    /** Дата и время публикации вакансии */
    @JsonProperty(value = "published_at")
    private String publishedAt;

    /** Короткое представление работодателя. Описание полей смотрите в информации о работодателе. */
    @JsonProperty(value = "employer")
    private EmployerDTO employer;

    /** Обязательно ли заполнять сообщение при отклике на вакансию */
    @JsonProperty(value = "response_letter_required")
    private boolean responseLetterRequired;

    /** Тип вакансии. Элемент справочника vacancy_type. */
    @JsonProperty(value = "type")
    private TypeDTO type;

    /** Информация о наличии прикрепленного тестового задании к вакансии. В случае присутствия теста - true.*/
    @JsonProperty(value = "has_test")
    private Boolean hasTest;

    /** Специализации. Элементы справочника specializations */
    @JsonProperty(value = "specializations")
    private List<SpecializationDTO> specializations;

    @Override
    public String toString() {
        return "VacancyDTO{" +
                "id='" + id + '\'' +
                ", description='" + Jsoup.parse(description).text() + '\'' + "\n" +
                ", skills=" + skills +
                ", schedule=" + schedule +
                ", experience=" + experience +
                ", address=" + address +
                ", alternateUrl='" + alternateUrl + '\'' +
                ", applyAlternateUrl='" + applyAlternateUrl + '\'' +
                ", employment=" + employment +
                ", salary=" + salary +
                ", archived=" + archived +
                ", name='" + name + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", employer=" + employer +
                ", responseLetterRequired=" + responseLetterRequired +
                ", type=" + type +
                ", hasTest=" + hasTest +
                ", specializations=" + specializations +
                '}';
    }
}