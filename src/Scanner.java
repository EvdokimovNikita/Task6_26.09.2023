public class Scanner {
    public static Integer scanner() {
        java.util.Scanner scannerMyText = new java.util.Scanner(System.in);
        System.out.println("Введите количество повторений:");
        return scannerMyText.nextInt();
    }
}
