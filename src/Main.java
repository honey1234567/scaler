// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        Paircount p = new Paircount();
        int count =p.solve(new int[]{1,2,3,2,1},5);
        System.out.println(count);
    }
}