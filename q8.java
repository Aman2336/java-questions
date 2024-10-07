public class q8 {
    public static void merge(int[] arr, int s, int e) {
        int mid = s + (e - s) / 2;
        int n1 = mid - s + 1;
        int n2 = e - mid;
        int arrindex = s;
        int arr1[] = new int[n1];
        int arr2[] = new int[n2];
        for (int i = 0; i < n1; i++) {
            arr1[i] = arr[arrindex++];
        }
        arrindex = mid + 1;
        for (int i = 0; i < n2; i++) {
            arr2[i] = arr[arrindex++];
        }
        int i = 0;
        int j = 0;
        arrindex = s;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                arr[arrindex++] = arr1[i++];
            } else {
                arr[arrindex++] = arr2[j++];
            }
        }
        while (i < n1) {
            arr[arrindex++] = arr1[i++];
        }
        while (j < n2) {
            arr[arrindex++] = arr2[j++];
        }
    }

    public static void mergesort(int[] arr, int s, int e) {
        if (s >= e) {
            return;
        }
        int mid = s + (e - s) / 2;
        mergesort(arr, s, mid);
        mergesort(arr, mid+1, e);
        merge(arr, s, e);
    }

    public static void main(String[] args) {
        int arr[] = { 34, 2, 65, 7, 12 };
        mergesort(arr, 0, arr.length - 1);
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
