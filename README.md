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

## Валидация строк

```java
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;

var v = new Validator();

var schema = v.string();

// Пока не вызван метод required(), null и пустая строка считаются валидным
schema.isValid(""); // true
schema.isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(""); // false
schema.isValid("what does the fox say"); // true
schema.isValid("hexlet"); // true

schema.contains("wh").isValid("what does the fox say"); // true
schema.contains("what").isValid("what does the fox say"); // true
schema.contains("whatthe").isValid("what does the fox say"); // false

schema.isValid("what does the fox say"); // false
// Здесь уже false, так как добавлена еще одна проверка contains("whatthe")

// Если один валидатор вызывался несколько раз
// то последний имеет приоритет (перетирает предыдущий)
var schema1 = v.string();
schema1.minLength(10).minLength(4).isValid("Hexlet"); // true
```
## Валидация чисел
```java
import hexlet.code.Validator;
import hexlet.code.schemas.NumberSchema;

var v = new Validator();

var schema = v.number();

schema.isValid(5); // true

// Пока не вызван метод required(), null считается валидным
schema.isValid(null); // true
schema.positive().isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(10); // true

// Потому что ранее мы вызвали метод positive()
schema.isValid(-10); // false
//  Ноль — не положительное число
schema.isValid(0); // false

schema.range(5, 10);

schema.isValid(5); // true
schema.isValid(10); // true
schema.isValid(4); // false
schema.isValid(11); // false
```
## Валидация объектов типа Map
```java
import hexlet.code.Validator;
import hexlet.code.schemas.MapSchema;

var v = new Validator();

var schema = v.map();

schema.isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(new HashMap<>()); // true
var data = new HashMap<String, String>();
data.put("key1", "value1");
schema.isValid(data); // true

schema.sizeof(2);

schema.isValid(data);  // false
data.put("key2", "value2");
schema.isValid(data); // true
```
