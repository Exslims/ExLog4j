# ExLog4j
ExLog4j - фреймворк логгирования под Java. Сочетает в себе гибкость, простоту и высокую скорость работы.

Идея:

Написать логгер позволяющий работать с любым типом конфигураций(Java, xml, properties files) максимально простым и удобным способом.

Стиль разработки - TDD

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
- Уровни логирования - предоставляется стандартная иерархическая структура уровней логирования, есть возможность добавить свой.
    - TRACE
        - DEBUG
            - INFO
                - WARN
                    - ERROR
                        - FATAL
                            - OFF
    - новый созданный уровень можно вставить в любое место.