
Feature: Bowling Game

  Scenario Outline: Scoring a game with all missed pins
    Given a game with knocked pins represented with "<frames>"
    When the score is calculated
    Then the score is <score>
    Examples:
      | frames                        | score |
      | --,--,--,--,--,--,--,--,--,-- | 0     |

  Scenario Outline: Scoring a game with all some pins knocked down
    Given a game with knocked pins represented with "<frames>"
    When the score is calculated
    Then the score is <score>
    Examples:
      | frames                        | score |
      | 21,22,23,24,25,26,27,2-,2-,2- | 48    |
      | --,22,-4,2-,2-,26,27,2-,26,27 | 48    |

  Scenario Outline: Scoring a game with all some pins knocked and with spares
    Given a game with knocked pins represented with "<frames>"
    When the score is calculated
    Then the score is <score>
    Examples:
      | frames                        | score |
      | 21,22,23,24,25,26,2/,2-,2-,2- | 53    |
      | --,22,-4,2-,2-,26,2/,2/,2/,27 | 71    |

  Scenario Outline: Scoring a game with all some pins knocked and with spares and strikes
    Given a game with knocked pins represented with "<frames>"
    When the score is calculated
    Then the score is <score>
    Examples:
      | frames                        | score |
      | X,22,23,24,X,X,2/,2-,2-,2-    | 93    |
      | --,22,-4,2-,2-,X,X,X,2/,27    | 109   |