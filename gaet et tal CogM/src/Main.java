import java.util.Scanner;
import java.util.Random;

public class Main {

    // Metode til at vise velkomstmeddelser og intrukstioner til brugeren
    public static void showWelcomemessage() {
        System.out.println("Velkommen til spillet.");
        System.out.println("1. let (1-10)");
        System.out.println("2. mellem (1-50)");
        System.out.println("3. svær (1-100)");
        System.out.println("Indtast en sværhedsgrad: ");

    }

    // Metode til at vælge sværhedsgraden
    public static int chooseDifficulty(int vælgSværhedsgrad) {
        int tilfældigtTal = 0;
        if (vælgSværhedsgrad == 1) {
            System.out.println("jeg tænker på et tal mellem 1-10, prøv og gæt det");
            tilfældigtTal = 10;
        } else if (vælgSværhedsgrad == 2) {
            System.out.println("jeg tænker på et tal mellem 1-50, prøv og gæt det");
            tilfældigtTal = 50;
        } else if (vælgSværhedsgrad == 3) {
            System.out.println("jeg tænker på et tal mellem 1-100, prøv og gæt det");
            tilfældigtTal = 100;
        } else System.out.println("Du tastede forkert - fejl");
        return tilfældigtTal;
        /* vi giver "tilfældigt tal en vlrdi baseret på brugerens valg af sværhedsgrad, og den
         værdi vi giver den er det tal som bliver tilfældigt og skal gættes */
    }



    // Metode til at kontrollere om brugerens gæt er korrekt, for lavt eller for højt
    public static boolean controlGuess(int gæt, int korrektTal) {
        if (gæt < korrektTal) {
            System.out.println("Dit gæt er for lavt.");
            return false;
        } else if (gæt > korrektTal) {
            System.out.println("Dit gæt er for højt.");
            return false;
        } else {
            System.out.println("Tillykke! Du gættede rigtigt.");
            return true;
        }
    }
//Metode til at vælge om man vil spille igen eller ej
    public static boolean handlePlayAgain(Scanner input ) {
        System.out.print("Vil du spille igen? (ja/nej): ");
        String svar = input.next().toLowerCase();

        switch (svar) {
            case "ja":
                return true;

            case "nej":
                System.out.println("Du har afsluttet spillet");
                return false;

            default:
                System.out.println("Du tastede forkert, program afsluttes");
                return false;
        }
    }

    //Hovedprogrammet
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        //sørger for at programmet starter.
        boolean spilleIgen = true;
        int antalgæt =0;


        while(spilleIgen){
            //kalder showWelcomemessage metoden
            showWelcomemessage();

            //læs input fra brugeren, for at vælge sværhedsgraden
            int vælgSværhedsgrad = input.nextInt();

            //kalder chooseDifficulty metoden, med den værdi der lige er blevet inputet
            int tilfældigtTal = chooseDifficulty(vælgSværhedsgrad);

            //sørger for at programmet ikke afslutter uden brugeren har spillet.
            boolean KorrekGæt = false;


            int Generatednumber = random.nextInt(tilfældigtTal) + 1;


            /*While-løkke til at gentage processen indtil brugeren gætter rigtigt
            "antalgæt++" er en int som plusses med 1 hvert gæt, så brugeren kan se hvor mange gæt det tog.
             */
            while (!KorrekGæt) {
                System.out.println("indtast dit gæt: ");
                int gæt = input.nextInt();
                antalgæt++;
                KorrekGæt = controlGuess(gæt,Generatednumber);
            }
            System.out.println("du gættede rigtigt på "+antalgæt+" forsøg");
            System.out.println("Tak fordi du spillede med.");

            //brug af switchcase, til at bestemme om brugeren vil spille igen - handlePlayAgain
            spilleIgen = handlePlayAgain(input);
        }
        System.out.println("Tak fordi du spillede med.");
        input.close();
    }
}




