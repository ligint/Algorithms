public class BubbleSort {

    public void bubbleSort(int[] arr){

        int n = arr.length ;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(arr[j] > arr[j + 1]){

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void printArray(int[] arr){

        int n = arr.length;
        for(int i = 0; i < n; i++){
            System.out.println(arr[i] + " ");
        }

    }

    public  static void main(String[] args){

        BubbleSort ob = new BubbleSort();
        int[] arr = {64,34,25,12,22,11,90};
        ob.bubbleSort(arr);
        System.out.println("Sorted Array is ");
        ob.printArray(arr);

    }

}
