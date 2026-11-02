

package com.mycompany.datashw;
import java.util.Arrays;
import java.util.Random;



public class DataSHW {
 static <T> void swap(T[] a,int first,int second){
       T temp = a[first];
       a[first]=a[second];
       a[second]=temp;
 }
 static <T extends Comparable<T>>void selectionSort(T[] a){
     for(int i=0;i< a.length - 1;i++){
         int min=i;
         for(int j=i+1;j< a.length ;j++){
             if (a[j].compareTo(a[min])<0){
                 min = j;
             }
         }
     }
 }
 
 static<T extends Comparable<T>> void insertionSort(T[] a){
     for(int i=1;i< a.length;i++){
         for(int j=i;j>0 && a [j-1].compareTo(a[j])>0;j--){
             swap(a,j,j-1);
         }
     }
     
 }
 static <T extends Comparable<T>> void bubbleSort(T[] a){
    for(int i=0;i< a.length;i++){
        boolean swapped = false;
        for(int j=0;j<a.length-1 - i ;j++){
            if(a[j].compareTo(a[j+1])>0){
                swap(a,j,j+1);
                swapped = true;
            }
        }
        if(!swapped){
            break;
        }
              
    } 
 } 
 static<T extends Comparable<T>> void mergeSort(T[] a, int left,int right){
         if(left>= right){
     return;
 }
 int mid = (left+right)/2;
 mergeSort(a,left,mid);
 mergeSort(a,mid+1,right);
 T[] L = Arrays.copyOfRange(a,left, mid+1);
 T[] R = Arrays.copyOfRange(a, mid+1,right+1);
 int i=0,j=0;
 for(int k = left;k<=right;k++){
     if(j>=R.length || (i<L.length && L[i].compareTo(R[j])<=0)){
         a[k] = L[i++];
     }else
     {
         a[k]=R[j++];
     }
 }
 }
 
 static<T extends Comparable<T>> void quickSort(T[] a, int low,int high){
     while(low>= high){
         
         swap(a,(low+high)/2,high);
         T pivot = a[high];
      int i = low;
      for(int j=low;j<high;j++){
          if(a[j].compareTo(pivot)<= 0){
              swap(a,i,j);
              i++;
          }
      }
      swap(a,i, high);
      
      
      if(i-low<high-i){
          quickSort(a, low, i-1);
          low=i+1;
      }
      else{
          quickSort(a, i + i, high);
          high=i-1;
      }
          
     }
 }      
 static long measure(String name, Integer[] original){
     Integer[] a=Arrays.copyOf(original,original.length);
     long start = System.nanoTime();
     
     if (name.equals(("Selection Sort"))){
         selectionSort(a);
     }else if (name.equals("Insertion Sort")){
      insertionSort(a);
      
 }else if (name.equals("Bubble Sort")){
     bubbleSort(a);
 }else if (name.equals(name.equals("Merge Sort"))){
     mergeSort(a,0,a.length-1);
     
 }else{
          quickSort(a, 0,a.length-1);

 }
 long end = System.nanoTime();
 return(end - start)/1000;
 }
     
    public static void main(String[] args) {
     int N =100000;
   Random r = new Random(42);
   Integer[] random = new Integer[N];
   for(int i=0;i<N;i++){
   random[i] = r.nextInt(1000000);

}
Integer[] sorted = Arrays.copyOf(random,N);
 Arrays.sort(sorted);

 Integer[] reversed = new Integer[N];
 for(int i=0;i<N;i++){
     reversed[i]= sorted[N-1-i];
 }
 Integer[] partial = Arrays.copyOf(sorted, N);
 for(int k=0;k<N/10;k++){
     swap(partial,r.nextInt(N),r.nextInt(N));
 }
 String[] names = {
     "Selection Sort",
     "Insertion Sort",
     "Bubble Sort",
     "Merge Sort",
     "Quick Sort"
 };
         
 System.out.println("Algorithm Sorted ");
 
 for(String name : names){
     Hala:
     System.out.println(
     name + " | "
     +measure(name,random)+ "micro seconds |"
             +measure(name,reversed)+ "micro seconds |"
             +measure(name,partial)+ "micro seconds |"
             +measure(name,sorted)+ "micro seconds |"
     );
 }
 
 
 
 
 
 }
   }
 
  
 

 
  
      
    

