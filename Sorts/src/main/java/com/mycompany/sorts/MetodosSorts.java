package com.mycompany.sorts;

public class MetodosSorts {

    public int[] vetor;
    public int numTrocas ;
    
    
    public void selectionSort(int[] vetor) {
        int n = vetor.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (vetor[j] < vetor[minIndex]) {
                    minIndex = j;
                    numTrocas++;
                }
            }

            int temp = vetor[minIndex];
            vetor[minIndex] = vetor[i];
            vetor[i] = temp;
        }

    }

    public void selectionSortMenor(int[] vetor) {
        int n = vetor.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (vetor[j] > vetor[minIndex]) {
                    minIndex = j;
                    numTrocas++;
                    
                }
            }

            int temp = vetor[minIndex];
            vetor[minIndex] = vetor[i];
            vetor[i] = temp;
        }

    }

    public void InsertSort(int[] vetor) {

        int n = vetor.length;

        for (int i = 1; i < n; i++) {
            int chave = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j--;
                numTrocas++;
            }

            vetor[j + 1] = chave;
        }
    }

    public void InsertSortMenor(int[] vetor) {

        int n = vetor.length;

        for (int i = 1; i < n; i++) {
            int chave = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j] < chave) {
                vetor[j + 1] = vetor[j];
                j--;
                numTrocas++;
            }

            vetor[j + 1] = chave;
        }

    }

    public void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
           
            if (arr[j] >= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                numTrocas++;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        numTrocas++;
        return i + 1;
    }

    
    
    
    
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
        }
    }

    private void merge(int[] arr, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
                numTrocas++;
            }
            k++;
        }

        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }
    }

   
}
