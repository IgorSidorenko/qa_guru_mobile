# Проект автоматизации мобильного приложения https://wikipedia.org

<img src="images/screenshots/Wikipedia.jpeg">

## Содержание:

* <a href="#link-технологии-и-инструменты">Технологии и инструменты</a>
* <a href="#link-реализованные-проверки">Реализованные проверки</a>
* <a href="#link-сборка-в-jenkins">Сборка в Jenkins</a>
* <a href="#link-запуск-из-инструменты-командной-строки">Запуск из командной строки</a>
* <a href="#link-allure-отчет">Allure отчет</a>
* <a href="#link-отчет-browserstack">Отчет Browserstack</a>
* <a href="#link-отчет-в-telegram">Отчет в Telegram</a>
* <a href="#link-видео-прохождения-тестов">Видео прохождения тестов</a>


## Технологии и инструменты
В проекте используются:

<p align="center">
<img width="6%" src="images/logo/Java.svg">
<img width="6%" src="images/logo/Intelij_IDEA.svg">
<img width="6%" src="images/logo/Gradle.svg">
<img width="6%" src="images/logo/JUnit5.svg">
<img width="6%" src="images/logo/Jenkins.svg">
<img width="6%" src="images/logo/Selenide.svg">
<img width="6%" src="images/logo/Selenoid.svg">
<img width="6%" src="images/logo/GitHub.svg">
<img width="6%" src="images/logo/Allure_Report.svg">
<img width="6%" src="images/logo/Telegram.svg">
</p>

Тесты написаны на Java с использованием фреймворков Selenide, JUnit 5 и Allure. Для сборки проекта используется Gradle.

## Реализованные проверки
- [x] Запуск приложения и проверки стартового экрана
- [x] Поиск и открытие статьи по названию
- [x] Поиск в Wikipedia
- [x] Проверка добавления страницы в закладки

## Запуск из командной строки
Реализована возможность как локального, так и удалённого запуска.

Запуск выполняется командой:
`./gradlew clean test -Dhost={HOST}`, где вместо {HOST} передаётся тип запуска – 
локальный (задаётся значение local) или через Browserstack (задаётся значение browserstack).

В отдельный config-file вынесены настройки для запуска: логин и пароль пользователя, 
название девайса и версия операционной системы, ссылки для запуска.

Пример файла с настройками можно посмотреть в src/test/resources/config, файл credentials-example.properties.

## Сборка в Jenkins
Для удалённого запуска можно настроить запуск в Jenkins. Пример прогона:

<img src="images/screenshots/jenkins_report.png">

## Allure отчет
Результат прогона тестов можно посмотреть в отчёте. Информация в тесте представлена в виде шагов с действиями.

<img src="images/screenshots/test_example.png">

## Интеграция Allure Test-Ops
<img src="images/screenshots/allureto.png">
<img src="images/screenshots/allureto2.png">

## Отчет Browserstack
За прогоном тестов можно наблюдать в интерфейсе Browserstack.

<img src="images/screenshots/browserstack.png">

## Отчет в Telegram
Результат прохождения тестов отправляется в Telegram с помощью бота. Пример сообщения с отчётом:

<p align="center">
<img src="images/screenshots/telegram_report.png">
</p>

## Видео пример прохождения теста
Для каждого теста есть видео с прохождением. Ниже один из примеров:

<p align="center">
<img src="images/gif/bbf5a47f161a9f03eead5ef5fef16323ae502642.gif">
</p>
