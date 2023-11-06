# Module 8 [Сервлети - основи]

Скачай і встанови на свій комп'ютер Tomcat. Скачати можна звідси, наприклад - [Apache Tomcat®](https://tomcat.apache.org/download-90.cgi)

## Завдання №1 - напиши сервлет, який віддає HTML сторінку з поточним часом по UTC
Напиши сервлет `TimeServlet`. Він має обробляти `GET` запит за адресою `/time` і віддавати HTML сторінку з поточним часом по часовому поясу `UTC`.

Сторінка має виводити час (з точністю до секунд) та часовий пояс. Наприклад, `2022-01-05 12:05:01 UTC`

Оскільки це `GET` запит, то його можна протестувати в браузері. Запусти програму, і переконайсь, що вона коректно працює і відкривається у браузері. Ти маєш ввести адресу на кшталт `http://localhost:8080/time` в браузері, і отримати результат.

## Завдання №2 - розшир сервлет, щоб він приймав часовий пояс
Розшир сервлет з попереднього завдання, щоб він приймав один `query` параметр `timezone`, і повертав час у переданому часовому поясі.

Наприклад, якщо відкрити в браузері URL виду `http://localhost:8080/time?timezone=UTC+2`, то отримаємо результат на кшталт - `2022-01-05 12:05:01 UTC+2`.

Якщо не передавати параметр `timezone`, то має повертатись час по `UTC`.

## Завдання №3 - додай WebFilter для некоректних часових поясів
Користувач може передати в параметрі timezone некоректний часовий пояс. У такому випадку повертай веб-сторінку з контентом `Invalid timezone` і HTTP кодом відповіді `400`.

Для цього створи веб-фільтр з назвою `TimezoneValidateFilter`, який має перехвачувати запит `/time`, перевіряти наявність параметру `timezone`, і валідувати його.

Для валідації часового поясу можна використати клас `Timezone`, [Javadoc].(https://docs.oracle.com/javase/7/docs/api/java/util/TimeZone.html)

## Завдання №4 - залий код проєкту на Github
Створи новий репозиторій на GitHub. Додай туди всі необхідні файли твого проєкту. Переконайсь, що в репозиторії немає зайвих файлів.

Результат виконання ДЗ - GitHub репозиторій з двома класами:

- TimeServlet
- TimezoneValidateFilter

Можуть бути також створені додаткові класи при потребі.
