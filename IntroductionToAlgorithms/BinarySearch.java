public class BinarySearch {

    int binarySearchRecursive(int[] a, int left , int right, int val){

        while(left <= right){

            int mid = left + (right - 1) / 2;

            if(a[mid] == val){
                return mid;
            } else if(a[mid] > val){

               return binarySearchRecursive(a,left,mid - 1,val);
            }

            return binarySearchRecursive(a,mid + 1,right,val);
        }

        return -1;
    }

    int binarySearchIterative(int[] a, int left , int right, int val){

        while (left <= right){

            int mid = left + (right - 1) / 2;

            if(a[mid] == val){
                return mid;
            } else if(a[mid] > val){
                right = mid - 1;
            } else
                left = mid + 1;

        }
        return -1;
    }

    public  static void main(String[] args){

        BinarySearch b = new BinarySearch();
        int[] a= {2,3,4,10,40};
        int n = a.length - 1;
        int x = 10;

        int result1 = b.binarySearchRecursive(a,0,n ,x);
        int result2 = b.binarySearchIterative(a,0,n, x);

        if(result1 == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element present at index " + result1);

        if(result2 == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element present at index " + result2);

    }

}
