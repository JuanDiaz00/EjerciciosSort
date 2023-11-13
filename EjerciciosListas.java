import java.util.ArrayList;
import java.util.Scanner;

public class EjerciciosListas {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("1. Ejercicio 1. Eliminación y ordenamiento.");
            System.out.println("2. Ejercicio 2. Cuadrados y ordenamiento.");
            System.out.println("3. Ejercicio 3. Problema de la moneda.");
            System.out.print("Ingrese un número: ");
            int ent = sc.nextInt();

            sc.nextLine();

            switch (ent) {
                case 1:
                    ejercicio1();
                    break;
                case 2:
                    ejercicio2();
                    break;
                case 3:
                    ejercicio3();
                    break;
                case 4:
                    System.out.println("Salir");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ingrese un número valido");
                    break;
            }

        }
    }

    public static void ejercicio1() {
        int hashValor = 3; //VALOR A CAMBIAR, 3 DA CUANDO PONGO MI NOMBRE
        System.out.print("Ingrese la lista: ");
        String datos = sc.nextLine();

        datos = datos.replace("[", "");
        datos = datos.replace("]", "");
        datos = datos.replace(",", "");

        for (int i = hashValor; i < 10; i++) {
            datos = datos.replace(String.valueOf(i), "");
        }

        datos = datos.replace("   ", " ");
        datos = datos.replace("  ", " ");
        
        String[] datosS = datos.split(" ");
        ArrayList<Integer> listaNumeros = new ArrayList<>();

        for (String s : datosS) {
            if (!s.isEmpty()) {
                listaNumeros.add(Integer.parseInt(s));
            }
        }

        if (listaNumeros.isEmpty()) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            for (int i = listaNumeros.size() - 1; i >= 0; i--) {
                if (i != 0)
                    System.out.print(listaNumeros.get(i) + ", ");
                else
                    System.out.print(listaNumeros.get(i));
            }
            System.out.println("]");
        }
        System.out.println("");
    }

    public static void ejercicio2() {
        int hashValor = 3; //VALOR A CAMBIAR, 3 DA CUANDO PONGO MI NOMBRE
        
        int valorCuadrado = Integer.parseInt(String.valueOf(hashValor) + String.valueOf(hashValor));
        
        System.out.print("Ingrese la lista: ");
        String datos = sc.nextLine();
        
        datos = datos.replaceAll("[a-zA-Z]", "");
        datos = datos.replaceAll("[^0-9\\s]", "");
        
        String[] datosS = datos.split(" ");
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        ArrayList<Integer> listaNumerosF = new ArrayList<>();
        
        for (String s : datosS) {
            if (!s.isEmpty()) {
                listaNumeros.add(Integer.parseInt(s));
            }
        }
        
        for(int i = 0; i < listaNumeros.size(); i++){
            int c = (int) Math.pow(listaNumeros.get(i), 2);
            if(c < valorCuadrado)
                listaNumerosF.add(c);
        }
        
        bubbleSortArrayList(listaNumerosF);
        
        if (listaNumerosF.isEmpty()) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            for (int i = 0; i < listaNumerosF.size(); i++) {
                if (i != listaNumerosF.size() - 1)
                    System.out.print(listaNumerosF.get(i) + ", ");
                else
                    System.out.print(listaNumerosF.get(i));
            }
            System.out.println("]");
        }
        System.out.println("");
    }

    public static void ejercicio3() {
        System.out.print("Ingrese la lista: ");
        String datos = sc.nextLine();
        int cantidad = 1;
        datos = datos.replaceAll("[a-zA-Z]", "");
        datos = datos.replaceAll("[^0-9\\s]", "");
        
        String[] datosS = datos.split(" ");
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        
        for (String s : datosS) {
            if (!s.isEmpty()) {
                listaNumeros.add(Integer.parseInt(s));
            }
        }
        
        bubbleSortArrayList(listaNumeros);
        
        for (int i = 0; i < listaNumeros.size(); i++){
            if(listaNumeros.get(i) <= cantidad)
                cantidad = cantidad + listaNumeros.get(i);
        }
        
        System.out.println(cantidad);
        
    }

    public static void bubbleSortArrayList(ArrayList<Integer> lista) {
        int n = lista.size();
        boolean intercambio;

        for (int i = 0; i < n - 1; i++) {
            intercambio = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (lista.get(j) > lista.get(j + 1)) {
                    // Intercambiar elementos si están en el orden incorrecto
                    intercambiar(lista, j, j + 1);
                    intercambio = true;
                }
            }

            // Si no hubo intercambios en una pasada, la lista ya está ordenada
            if (!intercambio) {
                break;
            }
        }
    }

    public static void intercambiar(ArrayList<Integer> lista, int i, int j) {
        int temp = lista.get(i);
        lista.set(i, lista.get(j));
        lista.set(j, temp);
    }

}
