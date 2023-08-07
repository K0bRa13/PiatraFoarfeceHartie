import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PiatraFoarfeceHartie {

    public static void main(String[] args) {

        System.out.println("Bine ai venit, alegere una dintre variantele: piatra, foarfece, hartie sau exit.");




        enum Miscare {
            PIATRA("piatra"),
            HARTIE("hartie"),
            FOARFECE("foarfece");

            private static int victorii;
            private static int infrangeri;
            private String value;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            while(true){
                Object alegereJucator;

                Scanner scanner = new Scanner(System.in);
                System.out.println("Alegere miscarea: ");
                String alegereJucator = scanner.nextLine();

                if (alegereJucator.equals("exit")) {
                    System.out.println("Ai castigat " + victorii + " meciuri si ai pierdut " + infrangeri + " meciuri");
                    System.out.println("Multumesc ca ai jucat!");
                    break;
                }

                if (Arrays.stream(Miscare.values()).noneMatch(x -> x.getValue().equals(alegereJucator))) {
                    System.out.println("Mutarea ta nu e valida!");
                    continue;
                }
            }
            int victorii = 0;
            int infrangeri = 0;
            protected static String alegereComputerRandom() {
                Random random = new Random();
                int randomNumber = random.nextInt(3);
                String alegereComputer = Miscare.values() [randomNumber].getValue();
                System.out.println("Computer-ul a ales: " + alegereComputer);
                return alegereComputer;
            }
            private static String alegereComputer = alegereComputerRandom();


            private static boolean victorieJucator (String alegereJucator, String alegereComputer) {
                return alegereJucator.equals(Miscare.PIATRA.value) && alegereComputer.equals(Miscare.FOARFECE.value)
                        || (alegereJucator.equals(Miscare.FOARFECE.value) && alegereComputer.equals(Miscare.HARTIE.value))
                        || (alegereJucator.equals(Miscare.HARTIE.value) && alegereComputer.equals(Miscare.PIATRA.value));
                if (alegereJucator.equals(alegereComputer)) {
                    System.out.println("Egalitate!");
                } else if (victorieJucator(alegereJucator, alegereComputer)) {
                    System.out.println("Ai castigat!");
                    victorii++;
                } else {
                    System.out.println("Ai pierdut");
                    infrangeri++;
                }
            }
        }
    }
}