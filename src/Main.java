
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sca = new Scanner (System.in);
        while (true){
            System.out.println("Selecciona una opcion: ");
            System.out.println("1.-Generame numeros aleatorios: ");
            System.out.println("2.-Ordename los numeros aleatorios: ");
            System.out.println("3.-Busca un numero: ");
            System.out.println("4.-Muestra los numeros: ");

            System.out.println("=== Salir ===");
            System.out.print("Escribir una opcion: ");
            int opcion = sca.nextInt();
            switch (opcion){
                case 1:
                    generarNumerosAleatorios();

                    break;
                case 2:
                    ordenarNumeros();

                    break;
                case 3:
                    System.out.print("Introduce el numero: ");
                    int numero = sca.nextInt();
                    buscarNumero(numero);
                    break;
                case 4:
                    mostrarNumeros();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Opcion no valida");



            }
        }
    }
    public static void generarNumerosAleatorios() throws IOException{
        Random rand = new Random();
        PrintWriter writer = new
                PrintWriter("numeros_random.txt");
        for (int i = 0; i < 10; i++){
            writer.println(rand.nextInt(1000));
        }
        writer.close();
        System.out.println("Numeros aleatorios generados");
    }
    public static void ordenarNumeros() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("numeros_random.txt"));
        List<Integer> numeros = new ArrayList<>();
        String linea;
        while ((linea = reader.readLine()) !=null){
            numeros.add(Integer.parseInt(linea));
        }
        Collections.sort(numeros);
        PrintWriter writer = new PrintWriter("numeros_ordenados.txt");
        for (int numero :numeros){
            writer.println(numero);
        }
        writer.close();
        System.out.println("Numero ordenados");
    }
    public static void buscarNumero(int numeroBuscado) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("numeros_random.txt"));
        String linea;
        while ((linea = reader.readLine())!=null ){
            int numero = Integer.parseInt(linea);
            if (numero == numeroBuscado){
                System.out.println("Numero encontrado: ---" + numero + "---");
                return;
            }
        }
        System.out.println("Numero no encontrado");
    }
    public static void mostrarNumeros() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("numeros_ordenados.txt"));
        String linea;
        while ((linea = reader.readLine()) !=null ){
            System.out.println(linea);
        }

    }
}




