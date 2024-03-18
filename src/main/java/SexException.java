public class SexException extends Exception {
    public SexException(){

    }

    public void sexException(){
        System.out.println("Вы ввели некорректный пол, нужно указать в формате f - female/m - male");
        System.out.println();
    }
}
