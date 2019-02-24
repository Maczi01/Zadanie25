import java.util.Scanner;

public class LoadData {

    public Integer loadPoints() {
        String line;
        Integer num;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj punkty gracza");
        line = scanner.nextLine();
        num = checkIfParsingIsPossible(line);
        return num;
    }

    public String loadNames() {
        String line;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj dane gracza");
        line = scanner.nextLine();
        return line;
    }

    public Integer checkIfParsingIsPossible(String line) {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        int num = 0;
        while (!check) {
            try {
                num = Integer.parseInt(line);
                check = true;
            } catch (NumberFormatException e) {
                System.out.println("Zly format wyniku");
                System.out.println("Podaj punkty gracza");
                line = scanner.nextLine();
            }
        }
        return num;
    }

}
