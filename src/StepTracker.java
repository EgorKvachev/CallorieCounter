import java.time.MonthDay;
import java.util.Scanner;
public class StepTracker {

    Scanner scanner = new Scanner(System.in);
     static MonthData[] monthToData;
      public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public static  class MonthData {
        int[] stepsPerDay = new int[30];
        int sum;
        int[] dayofMonthMonth = new int [30];
        Converter converter = new Converter();
        void day( int month, int dayByUser, int stepByDay) { //Метод для ввода шагов в день
            MonthData monthData = monthToData[month];
            stepsPerDay = monthData.dayofMonthMonth;
            stepsPerDay[dayByUser-1] =stepsPerDay[dayByUser-1] + stepByDay;


        }
        void Statistic(int month, int justDoIt) // Метод для вывода статистики
        {
            printAllSteps(month);
            sum = sum(month);
            maxSteps(month);
            averageSteps(sum);
            converter.Converter(sum);
            maxSteps(month);
            mvpSteps(month,justDoIt);
        }


        void printAllSteps(int month){ // Метод для вывода всех шагов
            MonthData monthData = monthToData[month];
            stepsPerDay = monthData.dayofMonthMonth;
            for(int i = 0; i< stepsPerDay.length;i++) {
                if (i == 29)
                {
                    System.out.println("День "+(i+1)+ ": "+stepsPerDay[i]+".");
                }else {
                System.out.print("День "+(i+1)+ ": "+stepsPerDay[i]+", ");
                }
            }
        }
        int sum(int month){ // Метод для суммирования всех шагов
            MonthData monthData = monthToData[month];
            stepsPerDay = monthData.dayofMonthMonth;
            for(int i =0 ; i<stepsPerDay.length; i++){
                sum = sum+stepsPerDay[i];
            }
            System.out.println("В этом месяце вы прошли: "+sum);
            return sum;

        }
        void maxSteps(int month) { //Наибольшое кол-во шагов за месяц
            int maxStep=0;
            MonthData monthData = monthToData[month];
            stepsPerDay = monthData.dayofMonthMonth;
            for(int i = 0 ; i<stepsPerDay.length; i++){
                if(maxStep<stepsPerDay[i]){
                    maxStep=stepsPerDay[i];
                }
            }
            System.out.println("Максимальное кол-во шагов в этом месяце: "+maxStep);
        }
        void averageSteps(int sum){ // Среднее кол-во шагов
            double  average;
            int x=0; //Хранит в себе кол-во дней, когда пользовать ходил.
            for(int i = 0 ; i<stepsPerDay.length; i++) {
              if (stepsPerDay[i]>0){
                  x=x+1;
              }
            }
            average=sum/x;
            System.out.println("Среднее количество шагов: "+average);
        }
        void mvpSteps(int month, int justDoIt) {// Лучшая серия
            MonthData monthData = monthToData[month];
            stepsPerDay = monthData.dayofMonthMonth;
            int[] mvp = new int[30];
            int j = 0;

            for (int i = 0; i < stepsPerDay.length; i++) {

                if (stepsPerDay[i] >= justDoIt) {
                    mvp[j] = mvp[j]+1;
                } else {
                    j++;
                }
            }
            int maxMVP=0;
            for(j=0; j<mvp.length;j++){
                if (maxMVP<mvp[j]){
                    maxMVP = mvp[j];
                }
            }
            System.out.println("Лучшая серия - "+maxMVP);
        }

        int justDoIt (int justDoIt) {
            if (justDoIt >= 0) {
                System.out.println("Цель шагов в день на данный момент = " + justDoIt);
                return justDoIt;
            } else {
                System.out.println("К счастью в минус здесь уйти нельзя =). Введите значение большее или равное нулю");
                return 10000;
            }
        }


    }

}




