import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        // testing for upto 10

        Scanner s = new Scanner(System.in);

        System.out.println("Enter grid size: ");
        int n = s.nextInt();

        SymbolSquares mySquares = new SymbolSquares (n);

        System.out.println(mySquares.toString());


    }
}
