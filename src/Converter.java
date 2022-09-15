public class Converter {
    void Converter(int sum) {
        int stepsKm=(sum*75)/100000;
        int calorie= (sum*50)/1000;
        System.out.println("Вы прошли "+stepsKm+" км");
        System.out.println("Вы сожгли "+calorie+" киллокалорий");
    }
}
