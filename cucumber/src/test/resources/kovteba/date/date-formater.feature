@foo
Feature: Date formater

  Background: Formater
    Given Create formater

  Scenario: Convert single date
    When Convert "2023-08-02 10:27:01.000001" using format "yyyy-MM-dd HH:mm:ss.SSSSSS"
    Then should be 2023-08-02T10:27:01.000001

  Scenario Outline: List of formats
    When Convert <date> using pattern <format>
    Then Result <result>

    Examples:
      | date                | format              | result              |
      | 2023-08-02 10:27:01 | yyyy-MM-dd HH:mm:ss | 2023-08-02T10:27:01 |

    Examples:
      | date                | format              | result              |
      | 2023-08-02 10:27:01 | yyyy-MM-dd HH:mm:ss | 2023-08-02T10:27:01 |

  Scenario: List of formats
    Given List of date with formats:
      | date                        | format                     |
      | 2023-08-02 10:27:01         | yyyy-MM-dd HH:mm:ss        |
      | 2023-08-02 10:27:01.000001  | yyyy-MM-dd HH:mm:ss.SSSSSS |
    Then Check all dates:
      | 2023-08-02T10:27:01         |
      | 2023-08-02T10:27:01.000001  |
