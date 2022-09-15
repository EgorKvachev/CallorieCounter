import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        StepTracker.MonthData monthData = new StepTracker.MonthData();
        int justDoIt = 10000;
        printMenu();
        int userInput = scanner.nextInt();
        while(userInput!=0)
        {
            if (userInput == 1)
            {
                System.out.println("Выбирете месяц 0-Январь, 1-Февраль, 2-Март и т.д");
                int month = scanner.nextInt();
                System.out.println("Выберите день 1,2,3,...,30");
                int dayByUser = scanner.nextInt();
                System.out.println("Введите кол-во шагов за день");
                int stepByUser = scanner.nextInt();
                monthData.day(month, dayByUser, stepByUser);
            } else if (userInput == 2){
                System.out.println("Введите месяц, за который вы хотите просмотреть статистку: ");
                int month = scanner.nextInt();
                monthData.Statistic(month,justDoIt);
            }else if (userInput == 3) {
                System.out.println("Цель шагов в день на данный момент = " + justDoIt);
                System.out.println("Введите новую цель шагов в день");
                justDoIt = scanner.nextInt();
                justDoIt = monthData.justDoIt(justDoIt);
            } else {
                System.out.println("Данной камманды не существует!");
            }
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена!");
    }
    private static void printMenu()
    {
        System.out.println("Выберите нужную вам комманду: ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по кличеству шагов в день");
        System.out.println("0 - Выйти из приложения ");
    }
}
