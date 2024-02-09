import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        llenadoDeDatos(scanner);
    }
    static void llenadoDeDatos(Scanner scanner){
        int opc = 0;
        double total = 0;
        double aumentoTotal = 0;
        boolean[] compra = new boolean[7];
        int[] cantidad = new int[7];
        double[] precio = {30, 27, 20, 35, 15, 29, 54};
        double[] costo = new double[7];
        double[] aumento = new double[7];
        String[] libro = {  "Manual Practico de Construccion", "Manual Practico de Instalaciones Sanitarias",
                "Manual Practico de Instalaciones Electricas", "Manual Practico de Acabados",
                "Manual Teorico de Construccion", "Manual Teorico de Instalaciones Sanitarias",
                "Manual Teorico y Practico Sobre el Proceso de Construccion"};

        System.out.print("============= Construya Facil =============\nBienvenido, Ingrese los libros que desee:\nSi: [1]\nNo: [2]\nSalir: [3]\n");
        librosAComprar(opc, compra, scanner, libro);

        System.out.print("=== Ingrese para cada libro la cantidad que desea: ===\n");
        llenarCantidad(compra, cantidad, precio, costo, libro, scanner);

        System.out.print("La compra se efectuo en:\nSede central: [1]\nDomicilio: [2]");
        opc = validacionSede(opc, scanner);

        System.out.print("========= Total: ==========\n");
        total(total, compra, costo, aumento, opc, libro, aumentoTotal);
        System.out.print("Gracias por su compra!");
    }
    static void librosAComprar(int opc, boolean[] compra, Scanner scanner, String[] libro){
        exit:
        for(int i = 0; i < 7; i++){
            System.out.printf("Desea comprar %s: ", libro[i]);
            opc = validacionOpc(opc, scanner);
            switch(opc){
                case 1: compra[i] = true; break;
                case 2: compra[i] = false; break;
                case 3:{
                    for(int j = i; j < 7; j ++)
                        compra[j] = false;
                    break exit;
                }
            }
        }
    }
    static int validacionOpc(int opc, Scanner scanner){
        do{
            try{
                opc = scanner.nextInt();
                if(opc == 3) break;
            }catch(Exception InputMismatchException){
                scanner.nextLine();
                System.out.print("Intente de nuevo: ");
                continue;
            }
            if(opc != 1 && opc != 2) System.out.print("Intente de nuevo: ");
        }while(opc != 1 && opc != 2);
        return opc;
    }
    static void llenarCantidad(boolean[] compra, int[] cantidad, double[] precio, double[] costo, String[] libro, Scanner scanner){
        for(int i = 0; i < 7; i++){
            if(compra[i]){
                System.out.printf("%s, cantidad: ", libro[i]);
                cantidad[i] = validacionCantidad(cantidad[i], scanner);
                costo[i] = cantidad[i] * precio[i];
            }
        }
    }
    static int validacionCantidad(int cantidad, Scanner scanner){
        do{
            try{
                cantidad = scanner.nextInt();
            }catch(Exception InputMismatchException){
                scanner.nextLine();
                System.out.print("Intente de nuevo: ");
                continue;
            }
            if(cantidad <= 0 || cantidad > 200) System.out.print("Intente de nuevo: ");
        }while(cantidad <= 0 || cantidad > 200);
        return cantidad;
    }
    static int validacionSede(int opc, Scanner scanner){
        do{
            try{
                opc = scanner.nextInt();
            }catch(Exception InputMismatchException){
                scanner.nextLine();
                System.out.print("Intente de nuevo: ");
                continue;
            }
            if(opc != 1 && opc != 2) System.out.print("Intente de nuevo: ");
        }while(opc != 1 && opc != 2);
        return opc;
    }
    static void total(double total, boolean[] compra, double[] costo, double[] aumento, int opc, String[] libro, double aumentoTotal){
        System.out.print('\n');
        for(int i = 0; i < 7; i++){
            if(compra[i]){
                aumento[i] = opc == 1 ? 0 : costo[i] * 0.05;
                costo[i] -= aumento[i];
                System.out.printf("%s: %.2f\nAumento: %.2f\n", libro[i], costo[i], aumento[i]);
                total += costo[i];
                aumentoTotal += aumento[i];
            }
        }
        System.out.printf("=====================\nTotal: %.2f\nAumento total: %.2f\n", total, aumentoTotal);
    }
}
//ZUBLIME;
