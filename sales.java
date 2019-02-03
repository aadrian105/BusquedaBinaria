package pack;

import java.util.Scanner;

public class sales <T extends Comparable<T> > {
    
    Scanner s = new Scanner(System.in);
    
    String[] mes;
    int[][] dia;
    double[] venta;
    
    public sales() {
        mes = new String[12];
        mes[0] = "Enero";
        mes[1] = "Febrero";
        mes[2] = "Marzo";
        mes[3] = "Abril";
        mes[4] = "Mayo";
        mes[5] = "Junio";
        mes[6] = "Julio";
        mes[7] = "Agosto";
        mes[8] = "Septiembre";
        mes[9] = "Octubre";
        mes[10] = "Noviembre";
        mes[11] = "Diciembre";
        
        dia = new int[12][];
        dia[0] = new int[31];
        dia[1] = new int[28];
        dia[2] = new int[31];
        dia[3] = new int[30];
        dia[4] = new int[31];
        dia[5] = new int[30];
        dia[6] = new int[31];
        dia[7] = new int[31];
        dia[8] = new int[30];
        dia[9] = new int[31];
        dia[10] = new int[30];
        dia[11] = new int[31];
        
        venta = new double[getLenght(dia)];
        LlenarVenta(venta);
        
        System.out.print("Valor que desea buscar: ");
        double valorBuscado = s.nextDouble();
        
        BubbleSort(venta);
        binarySearch(venta, valorBuscado);
    }
    
    public void BubbleSort(double[] arreglo) {
        double temporal;
        
        for (int j = 0; j < arreglo.length; j++) {
            for (int i = 0; i < arreglo.length - 1; i++) {
                if (arreglo[i] > arreglo[i + 1]) {
                    temporal = arreglo[i + 1];
                    arreglo[i + 1] = arreglo[i];
                    arreglo[i] = temporal;
                }
            }
        }
        
    }
    
    public void LlenarVenta(double[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            venta[i] = (Math.random() * 99) + 1;
        }
        
    }
    
    public int getLenght(int[][] array) {
        int longit = 0;
        
        for (int i = 0; i < array.length; i++) {
            longit = longit + array[i].length;
        }
        
        return longit;
    }
    
    public boolean binarySearch(T[] array, T value) {
        int medio;
        int inferior = 0;
        int superior = array.length - 1;
        
        do {
            medio = (superior + inferior) / 2;
            if (value.compareTo(array[medio]) == 1) 
                inferior = medio + 1;
            else
                superior = medio;
        } while (inferior != superior);
        
        if (array[superior] == value)
            return true;
        else
            return false;
        
    }
    
}
