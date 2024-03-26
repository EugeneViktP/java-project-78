# Overview
Валидатор функционирует следующим образом: сначала создается объект валидатора, затем мы создаем и настраиваем схему проверки данных. После этого мы проводим проверку данных, используя ранее созданную схему. Далее рассмотрим каждый этап более подробно.

Чтобы воспользоваться валидатором, необходимо создать объект данной программы.

import hexlet.code.Validator;
var v = new Validator();

После этого необходимо создать и настроить схему валидации данных, которая будет содержать правила проверки. Схема представляет собой объект, который содержит правила и ограничения для данных, такие как обязательность заполнения, минимальную и максимальную длину строки и так далее. Настройка схемы валидации может быть произведена при помощи различных методов, которые предоставляет схема. Разные типы данных проверяются при помощи своих схем:


### Hexlet tests and linter status:
[![Actions Status](https://github.com/EugeneViktP/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/EugeneViktP/java-project-78/actions) <br>
[![Codeclimeate Badge](https://api.codeclimate.com/v1/badges/1b020edefd4cbc4bf1cd/maintainability)](https://codeclimate.com/github/EugeneViktP/java-project-78/maintainability)
<br>
[![Test Coverage](https://api.codeclimate.com/v1/badges/1b020edefd4cbc4bf1cd/test_coverage)](https://codeclimate.com/github/EugeneViktP/java-project-78/test_coverage)
