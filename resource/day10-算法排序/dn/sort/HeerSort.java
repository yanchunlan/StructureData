package com.dn.sort;


//≤ªŒ»∂®
public class HeerSort {

 //œ£∂˚≈≈–Ú   
    public static void main(String[] args) {
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1,33,85,29};
        System.out.println("≈≈–Ú÷Æ«∞£∫");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        //œ£∂˚≈≈–Ú
        System.out.println();
        int d = a.length/2;
        while(true){
            for(int i=0;i<d;i++){
                for(int j=i;j+d<a.length;j+=d){
                int temp;
                if(a[j]>a[j+d]){
                    temp=a[j];
                    a[j]=a[j+d];
                    a[j+d]=temp;
                    }
                }
            }
            if(d==1){break;}
            d--;
           }
        System.out.println();
        System.out.println("≈≈–Ú÷Æ∫Û£∫");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

}