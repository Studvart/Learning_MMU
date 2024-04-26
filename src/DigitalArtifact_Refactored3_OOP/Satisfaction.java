package DigitalArtifact_Refactored3_OOP;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Satisfaction {
    private final int numberOfQuestions = 5;
    private final int maxScore = 5;
    private final int minScore = 1;
    Scanner scanner = new Scanner(System.in);
    int[] surveyArray = new int[numberOfQuestions];
    int i;
    double averageScore;

    public void satisfactionSurvey() {

        System.out.printf("""
                We would like to ask you a few satisfaction questions.
                Please provide a score of %d (low) to %d (high) for the next %d questions.
                """, minScore, maxScore, numberOfQuestions);
        for (i = 0; i < numberOfQuestions; i++) {
            switch (i) {
                case 0:
                    System.out.println("""
                            How would you score:
                            The ease of your journey?
                            """);
                    surveyArray[i] = validateSurveyInput();
                    scanner.nextLine();
                    break;
                case 1:
                    System.out.println("""
                            How would you score:
                            The speed of your journey?
                            """);
                    surveyArray[i] = validateSurveyInput();
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.println("""
                            How would you score:
                            The clarity of the information presented?
                            """);
                    surveyArray[i] = validateSurveyInput();
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.println("""
                            How would you score:
                            The claims registration experience?
                            """);
                    surveyArray[i] = validateSurveyInput();
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.println("""
                            How would you score:
                            Your likelihood to recommend us?
                            """);
                    surveyArray[i] = validateSurveyInput();
                    scanner.nextLine();
                    break;
            }
        }
        System.out.println("""
                Thank you for participating.
                """);
    }

    private int validateSurveyInput() {
        int _inputValue = 0;

        do {
            System.out.printf("Please score between %d and %d.\n", minScore, maxScore);
            try {
                _inputValue = scanner.nextInt();

                if (_inputValue >= minScore && _inputValue <= maxScore) {
                    break;
                }

                System.out.printf("%d is not a valid option.\n", _inputValue);

            } catch (InputMismatchException e) {
                System.err.println("Please enter a valid integer for your score.\n");
                scanner.nextLine();
            }

        } while (!(_inputValue >= minScore && _inputValue <= maxScore));
        return _inputValue;
    }

    public void returnScores() {
        int scoreSum = 0;

        System.out.println("You scored us:");
        for (int j = 0; j <= numberOfQuestions; j++) {
            switch (j) {
                case 0:
                    System.out.printf("""
                            Ease: %d
                            """, surveyArray[j]);
                    scoreSum = scoreSum + surveyArray[j];
                    break;
                case 1:
                    System.out.printf("""
                            Speed: %d
                            """, surveyArray[j]);
                    scoreSum = scoreSum + surveyArray[j];
                    break;
                case 2:
                    System.out.printf("""
                            Clarity: %d
                            """, surveyArray[j]);
                    scoreSum = scoreSum + surveyArray[j];
                    break;
                case 3:
                    System.out.printf("""
                            Claims: %d
                            """, surveyArray[j]);
                    scoreSum = scoreSum + surveyArray[j];
                    break;
                case 4:
                    System.out.printf("""
                            Recommendation: %d
                            """, surveyArray[j]);
                    scoreSum = scoreSum + surveyArray[j];
                    break;
                case 5:
                    averageScore = ((double) scoreSum / (double) numberOfQuestions);
                    System.out.printf("""
                            Average Score: %.2f
                            """, averageScore);
                    break;
            }
        }
    }
}
