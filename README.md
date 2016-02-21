# ExLog4j
ExLog4j - фреймворк логгирования под Java. Сочетает в себе гибкость, простоту и высокую скорость работы.

Идея:

Написать логгер позволяющий работать с любым типом конфигураций(Java, xml, properties files) максимально простым и удобным способом.

Стиль разработки - TDD

# Описание
![alt tag](http://i.imgur.com/0mjYiLF.png)
Диаграмма классов:
![alt tag](http://i.imgur.com/H6jSeRJ.png)

[a link])(http://i.imgur.com/H6jSeRJ.png)

# Возможности

- Работа с любым типом конфигураций:
    - Java(в разработке)
    - Xml(в разработке)
    - Properties files(в разработке)
    - другие..
- Собственные аннотации для простоты использования + возможность создавать свои(?)
    - @JavaConfig(class)
    - @XmlConfig(path)
    - @PropertiesConfig(path)
    - Если не указан свой конфиг используется стандартный внутренний.
- Вывод
    - Вывод в stdout
    - Вывод в файл
- Уровни логирования - предоставляется стандартная иерархическая структура уровней логирования
    - TRACE
        - DEBUG
            - INFO
                - WARN
                    - ERROR
                        - FATAL
                            - OFF