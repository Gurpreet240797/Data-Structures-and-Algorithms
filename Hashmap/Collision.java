package Hashmap;

import java.util.Scanner;

class Hashtable {
    int[][] hashtable;

    Hashtable (int rows, int cols) {
        hashtable = new int[rows+1][cols+1];
    }

    private int hashcode(int value) {
        return (((4 * value) + 7) % 13);
    }

    public void hashAndAdd(int value) {
        int index = hashcode(value);

        for (int i=0; i<hashtable[index].length; i++) {
            if (hashtable[index][i] == 0) {
                hashtable[index][i] = value;
                break;
            }
        }
    }

    public void maxCollision () {
        int collision = 1;
        int indexCollision = 0;

        for (int i = 0; i < hashtable.length; i++) {
            int noOfCollisions = 0;
            for (int j = 0; j < hashtable[i].length; j++) {
               if (hashtable[i][j] == 0) break;
               noOfCollisions += 1;
            }

            if (noOfCollisions > collision) {
                collision = noOfCollisions;
                indexCollision = i;
            }
        }

        System.out.println("Max Collision: " + collision + " at index: " + indexCollision + ".");
    }
}

public class Collision {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int cols = keyboard.nextInt();

        Hashtable hashtable = new Hashtable(13, cols);

        for (int i=0; i<cols; i++) {
            hashtable.hashAndAdd(keyboard.nextInt());
        }

        hashtable.maxCollision();
        keyboard.close();
    }
}
