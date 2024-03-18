import java.util.Scanner;

public class InputData {
    public String[] enterData(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Введите данные через ПРОБЕЛ в формате <Фамилия> <Имя> <Отчество> " +
                    "<dd.mm.yyyy> <номер телефона без символов> <пол - f/m> : ");
            String data = scanner.nextLine();
            String[] arrayData = data.split(" ");
            if (arrayData.length == 6){
                return arrayData;
            } else if (arrayData.length < 6) {
                System.out.println("Вы ввели недостаточно данных, попробуйте еще раз");
            } else {
                System.out.println("Вы ввели слишком много данных, попробуйте еще раз");
            }
        }
    }
}
