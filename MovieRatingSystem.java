import java.util.Scanner;

public class MovieRatingSystem {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.println("Hello, " + name);

        
        String[] movies = new String[5];
        int[] ratings = new int[5];

       
        for (int i = 0; i < movies.length; i++) {

            System.out.print("Enter movie " + (i + 1) + ": ");
            movies[i] = input.nextLine();

            
            while (true) {

                System.out.print("Rate " + movies[i] + " from 1 to 10: ");

                if (input.hasNextInt()) {

                    int rating = input.nextInt();
                    input.nextLine();

                    if (rating >= 1 && rating <= 10) {
                        ratings[i] = rating;
                        break;
                    } else {
                        System.out.println(
                            "Invalid rating. Enter a rating from 1 to 10."
                        );
                    }

                } else {

                    System.out.println(
                        "Invalid input. Please enter a number from 1 to 10."
                    );

                    
                    input.nextLine();
                }
            }
        }

        
        int total = 0;

        for (int i = 0; i < ratings.length; i++) {
            total += ratings[i];
        }

        double average = (double) total / ratings.length;

        System.out.printf("Average rating: %.1f%n", average);

        // Classify average rating
        if (average >= 9) {
            System.out.println("You are a cinephile!");
        } else if (average >= 7) {
            System.out.println("You enjoy movies quite a bit.");
        } else if (average >= 5) {
            System.out.println("You have mixed feelings about movies.");
        } else {
            System.out.println("You are a tough critic!");
        }

        
        boolean hasTen = false;
        boolean hasBelowFour = false;

        for (int i = 0; i < ratings.length; i++) {

            if (ratings[i] == 10) {
                hasTen = true;
            }

            if (ratings[i] < 4) {
                hasBelowFour = true;
            }
        }

       
        if (hasTen) {

            System.out.println("Wow! You found a masterpiece.");

            if (hasBelowFour) {
                System.out.println(
                    "That movie didn't impress you much."
                );
            }

        } else {

            if (hasBelowFour) {
                System.out.println(
                    "That movie didn't impress you much."
                );
            }
        }

      
        if (ratings[0] >= 7 &&
            ratings[1] >= 7 &&
            ratings[2] >= 7 &&
            ratings[3] >= 7 &&
            ratings[4] >= 7) {

            System.out.println("You seem to enjoy most movies.");

        }

      
        else if (ratings[0] < 3 ||
                 ratings[1] < 3 ||
                 ratings[2] < 3 ||
                 ratings[3] < 3 ||
                 ratings[4] < 3) {

            System.out.println(
                "You have strong opinions on movies!"
            );
        }

        
        System.out.print(
            "Enter your favorite genre " +
            "(Action, Comedy, Horror, Drama, Sci-Fi): "
        );

        String genre = input.nextLine();

       
        switch (genre.toLowerCase()) {

            case "action":
                System.out.println(
                    "You love excitement and thrills!"
                );
                break;

            case "comedy":
                System.out.println(
                    "You enjoy a good laugh."
                );
                break;

            case "horror":
                System.out.println(
                    "You have a taste for fear!"
                );
                break;

            case "drama":
                System.out.println(
                    "You appreciate deep storytelling."
                );
                break;

            case "sci-fi":
            case "sci fi":
            case "scifi":
                System.out.println(
                    "You love futuristic and imaginative worlds!"
                );
                break;

            default:
                System.out.println("Unknown genre.");
                break;
        }

        
        String recommendation =
                genre.equalsIgnoreCase("Sci-Fi") ||
                genre.equalsIgnoreCase("Sci Fi") ||
                genre.equalsIgnoreCase("Scifi")
                ? "Interstellar"
                : "The Dark Knight";

        System.out.println(
            "Movie recommendation: " + recommendation
        );

        input.close();
    }
}