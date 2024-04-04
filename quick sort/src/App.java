import java.util.Scanner;
// quick sort
public class App {
    public int temp, i, j, l, r;
    public static int Pivot; 
    public int array[];

    public void quicksort() {
        l = 0;
        r = array.length - 1;
        printvalues();
        DivideArray(array, l, r);
    }

    public void DivideArray(int array[], int l, int r) {
        if (l < r) {
            int p = partition(array, l, r);
            DivideArray(array, l, p - 1); //  recursive call for the left subarray
            DivideArray(array, p + 1, r);
        }
    }

    public int partition(int array[], int l, int r) {
        Pivot = l; 
        i = l;
        j = r;

        while ((checkBelowpivot() == false) || (checkabovepivot() == false)) {
            System.out.println("i,j:" + i + " " + j);
            checkfromright();
            checkfromleft();
        }
        return Pivot; 
    }

    public boolean checkBelowpivot() {
        for (int k = 0; k < Pivot; k++) {
            if (array[k] > array[Pivot]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkabovepivot() {
        if (Pivot < array.length - 1) {
            for (int k = Pivot + 1; k < array.length; k++) { 
                if (array[k] < array[Pivot]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void checkfromright() {//used for checking the element and if element is greater than pivot than it swaps
        for (int k = r; k > Pivot; k--) { 
            if (array[k] < array[Pivot]) {
                swapvalues(i, k);
                printvalues();
                Pivot = j = k; 
                checkfromleft();
            }
        }
    }

    public void checkfromleft() {//used for checking the element and if element is greater than pivot than it swaps
        for (int k = l; k < Pivot; k++) {
            if (array[k] > array[Pivot]) {
                swapvalues(k, j); 
                printvalues();
                Pivot = i = k; 
                checkfromright();
            }
        }
    }

    public void swapvalues(int i, int j) {
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void printvalues() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Value at position" + i + " is " + array[i]); //print statement
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();
        int array[] = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        App q = new App();
        q.array = array;
        q.quicksort();
        sc.close(); // Closing the scanner
    }
}
