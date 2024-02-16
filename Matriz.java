import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
public class Main{
    public static void main(String[] args){
        Main objeto = new Main();
        objeto.menuDeOpciones();
    }
    void menuDeOpciones(){
        int m[][] = new int[10][10];
        int[] z = new int[m.length * m[0].length];
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int opc = 0;
        while(opc != 7){
            System.out.print("======== MENU DE OPCIONES ========\nIngrese una opcion:\nLlenar Elementos: [1]\n" +
                    "Mostrar elementos: [2] \nCalcular sutoria de diagonales: [3]\nOrdenar de menor a mayor: [4]\n" +
                    "Ordenar de mayor a menor: [5]\nBuscar un numero(busqueda binaria): [6]\nSalir: [7]\n");
            opc = checkOpc(opc, scanner);

            switch(opc){
                case 1: llenarElementos(m, random); break;
                case 2: mostrarElementos(m); break;
                case 3: calcularSumaDeDiagonales(m); break;
                case 4: ordenarDeMenorAMayor(m, z); break;
                case 5: ordenarDeMayorAMenor(m, z); break;
                case 6: buscarElemento(m, scanner, z); break;
                case 7: System.out.print("Gracias por usarme y dejarme :c");
            }
        }
    }
    int checkOpc(int opc, Scanner scanner){
        do{
            try{
                opc = scanner.nextInt();
            }catch(Exception InputMismtachException){
                scanner.nextLine();
                System.out.print("Intente de nuevo: ");
                continue;
            }
            if(opc != 1 && opc != 2 && opc != 3 && opc != 4 && opc != 5 && opc != 6 && opc != 7) System.out.print("Intente de nuevo: ");
        }while(opc != 1 && opc != 2 && opc != 3 && opc != 4 && opc != 5 && opc != 6 && opc != 7);
        return opc;
    }
    void llenarElementos(int[][] m, Random random){
        for(int i = 0; i < m.length; i++)
            for(int j = 0; j < m[i].length; j++)
                m[i][j] = random.nextInt(100) + 1;

    }
    void mostrarElementos(int[][] m){
        for(int i = 0; i < m.length; i++){
            System.out.print('|');
            for(int j = 0; j < m[i].length; j++){
                if(j != m.length - 1) System.out.printf("%3d, ", m[i][j]);
                else System.out.printf("%3d|", m[i][j]);
            }
            System.out.println();
        }
    }
    void calcularSumaDeDiagonales(int[][] m){
        int sumaIzquierda = 0, sumaDerecha = 0;
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[i].length; j++){
                if(i == j) sumaIzquierda += m[i][j];
                else if(m.length - i == j) sumaDerecha += m[i][j];
            }
        }
        System.out.printf("==================\nSuma de la diagonal izquierda: %d\nSuma de la diagonal derecha: %d\n===================\n", sumaIzquierda, sumaDerecha);
    }
    int llenarZ(int[] z, int[][] m, int con){
        for(int i = 0; i < m.length; i++)
            for(int j = 0; j < m[i].length; j++){
                z[con] = m[i][j];
                con ++;
            }
        return con;
    }
    void ordenarDeMenorAMayor(int[][] m, int[] z){
        int con = 0;
        con = llenarZ(z, m, con);

        con--;
        for(int i = z.length - 1; i >= 0; i--){
            int temp = z[i];
            int j = i + 1;
            while(j < z.length && z[j] > temp){
                z[j-1] = z[j];
                j++;
            }
            z[j-1] = temp;
        }
        for(int i = 0; i < m.length; i++)
            for(int j = 0; j < m[i].length; j++){
                m[i][j] = z[con];
                con--;
            }
    }
    void ordenarDeMayorAMenor(int[][] m, int[] z){
        int con = 0;
        con = llenarZ(z, m, con);

        con--;
        for(int i = 1; i < z.length; i++){
            int temp = z[i];
            int j = i - 1;
            while(j >= 0 && z[j] > temp){
                z[j+1] = z[j];
                j--;
            }
            z[j+1] = temp;
        }
        for(int i = 0; i < m.length; i++)
            for(int j = 0; j < m[i].length; j++){
                m[i][j] = z[con];
                con--;
            }
    }
    void buscarElemento(int[][] m, Scanner scanner, int[] z){
        int[][] a = new int[m.length][m[0].length];
        int [] b = new int[z.length];

        for(int i = 0; i < m.length; i++)
            for(int j = 0; j < m[0].length; j++)
                a[i][j] = m[i][j];
        for(int i = 0; i < z.length; i++)
            b[i] = z[i];

        ordenarDeMayorAMenor(a, b);
        int target = 0;
        System.out.printf("====================\nNumero: ");
        int num = target = checkTarget(target, scanner);

        target = busquedaBinaria(target, b);

        int con = 0;
        int ejeX = 0, ejeY = 0;
        exit:
        for(int i = 0; i < m.length; i++)
            for(int j = 0; j < m[i].length; j++){
                if(target == b[con]){
                    ejeX = i; ejeY = j;
                    break exit;
                }
                con++;
            }

        if(target == -1) System.out.printf("No se encontro el numero %d\n================\n", num);
        else System.out.printf("Posicion del numero: M[%d, %d]\n====================\n", ejeX, ejeY);
    }
    int checkTarget(int x, Scanner scanner){
        do{
            try{
                x = scanner.nextInt();
            }catch(Exception InputMismatchException){
                scanner.nextLine();
                System.out.print("Intente de nuevo: ");
                continue;
            }
            if(x <= 0 && x > 100) System.out.print("Intente de nuevo: ");
        }while(x <= 0 && x > 100);
        return x;
    }
    int busquedaBinaria(int target, int[] z){
        int inicio = 0;
        int fin = z.length - 1;
        while(inicio <= fin){
            int mitad = inicio + (fin - inicio) / 2;
            if(z[mitad] == target) return target;
            else if(z[mitad] < target) inicio = mitad + 1;
            else fin = mitad - 1;
        }
        return -1;
    }
}
//Zublime
