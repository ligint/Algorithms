public class InsertionSort {

    public void insertionSort(int[] arr){

        int n = arr.length ;
        for(int i = 1; i < n; i++){

            int key = arr[i];
            int j = i - 1;

            while(j >=0 && arr[j] > key){

                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = key;
        }
    }

    public void printArray(int[] arr){

        int n = arr.length;
        for(int i = 0; i < n; i++){
            System.out.println(arr[i] + " ");
        }

    }

    public  static void main(String[] args){

        InsertionSort ob = new InsertionSort();
        int[] arr = {64,34,25,12,22,11,90};
        g.insertionSort(arr);
        System.out.println("Sorted Array is ");
        g.printArray(arr);

    }

}
