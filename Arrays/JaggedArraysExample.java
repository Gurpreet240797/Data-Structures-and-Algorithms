package Arrays;

public class JaggedArraysExample {

    public static void main(String[] args) {

        try {
            Arrays.JaggedArrayClass ja1 = new Arrays.JaggedArrayClass("3 2 3 2 5 7 5 6 6 5 4");
            //JaggedArrayClass ja2 = new JaggedArrayClass("3 2 3 2 1 2 3 4 5 6 7");

            System.out.println("Display before Appending : ");
            ja1.display();
            //ja1.swapRows(1, 2);
            //ja1.removeRow(1);
            //ja1.insertRow("1 2 3", 2);
            ja1.appendToAllRows(1);

            System.out.println("Display after Appending : ");
            ja1.display();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
