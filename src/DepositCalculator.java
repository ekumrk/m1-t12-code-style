import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return calculateUserInput(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return calculateUserInput(amount + amount * yearRate * depositPeriod, 2);
    }

    double calculateUserInput(double value, int places) {
       double scale = Math.pow(10, places);
       return Math.round(value * scale) / scale;
    }

    void calculateContributionAmount() {
        double outDoubleVar = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        int depositPeriod = scanner.nextInt( );
        System.out.println("Выберите тип вклада, " +
                "1 - вклад с обычным процентом, " +
                "2 - вклад с капитализацией:");
        int action = scanner.nextInt();
        if (action == 1) {
            outDoubleVar = calculateSimplePercent(amount, 0.06, depositPeriod);
        } else if (action == 2) {
            outDoubleVar = calculateComplexPercent(amount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + outDoubleVar);
    }

    public static void Main(String[] args) {

        new DepositCalculator().calculateContributionAmount();
    }
}
