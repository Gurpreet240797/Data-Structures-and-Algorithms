package Arrays;

public class JaggedArrayClass {

    private int[][] array;
    private int numberOfRows;

    public JaggedArrayClass(String input) throws Exception {
        String[] splittedInput = input.split(" ");
        numberOfRows = Integer.parseInt(splittedInput[0]);

        // Check if at least we have the number of rows and all the sizes of columns
        if (numberOfRows > (splittedInput.length - 1)) {
            throw new Exception("Wrong input. Sizes of rows do not match the number of rows.");
        } else {
            array = new int[numberOfRows][];
            // Case without data
            int numberOfDataCells = 0;
            // Creating columns for each row
            for (int i = 1; i <= numberOfRows; i++) {
                int numColumnsInThisRow = Integer.parseInt(splittedInput[i]);
                array[i - 1] = new int[numColumnsInThisRow];
                numberOfDataCells = numberOfDataCells + numColumnsInThisRow;
            }
            // Case with Data
            int indexOfNextDataToUse = numberOfRows + 1;
            if (numberOfDataCells <= splittedInput.length - indexOfNextDataToUse) {
                for (int i = 0; i < numberOfRows; i++) {
                    for (int j = 0; j < array[i].length; j++) {
                        int num = Integer.parseInt(splittedInput[indexOfNextDataToUse]);
                        indexOfNextDataToUse++;
                        array[i][j] = num;
                    }
                }
            }
        }

        // Error(s)
    }

    public void swapRows(int index1, int index2) {
        int[] temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        /*int[] temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;*/
    }

    public void removeRow (int index) {
        int [][] tempArr = new int[array.length - 1][];
        int itr = 0;

        for (int i=0; i< array.length; i++) {
            if (index != i) {
                int[] temp = array[i];
                tempArr[itr++] = temp;
            }
        }
        array = tempArr;
    }

    public void insertRow (String row, int index) {
        String[] arr = row.split(" ");
        int[] intArr = new int[arr.length];
        int itr = 0;
        for (int i=0; i<arr.length; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }

        int[][] tempArr = new int[array.length + 1][];

        for (int i = 0; i < tempArr.length; i++) {
            if (index == i) {
                tempArr[i] = intArr;
            } else {
                tempArr[i] = array[itr++];
            }
        }

        array = tempArr;
    }

    public void appendToAllRows (int value) {
        for (int i=0; i<array.length; i++) {
            int[] temp = new int[array[i].length + 1];
            for (int j=0; j<array[i].length; j++) {
                temp[j] = array[i][j];
            }
            temp[temp.length - 1] = value;
            array[i] = temp;
        }
    }

    public void display() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "  ");
            }
            System.out.println("");
        }
    }
}
