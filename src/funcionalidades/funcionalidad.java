package funcionalidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class funcionalidad {
    public static int leerInt(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        int numero;

        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim(); // Elimina espacios extras

            try {
                numero = Integer.parseInt(entrada); // Intenta convertir la entrada a un número entero
                return numero;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
            } finally {
                scanner.close();
            }
        }
    }

    public static boolean palindromo(String cadena){
        String di = new String();
        String dr = new String();
        for (int i = 0; i < cadena.length() ; i++) {
            String temp = cadena.substring(i, i+1);
            if (temp.compareTo(" ")!= 0) {// 0 igual y 1 diferente
                di = di + temp;
                dr = temp + dr;
            }
        }
        return di.compareTo(dr) == 0;
    }

    public static boolean capicua(int numero){
        int num = numero;
        int inverso = 0;
        while (num > 0) {
            inverso = inverso * 10 + num % 10;
            num = num / 10;
        }
        return numero == inverso;
    }

    public static double hipotenusa(float a, float b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    public static double areaCirculo(float radio) {
        return Math.PI * Math.pow(radio, 2);
    }

    public static double areaTriangulo(float base, float altura) {
        return (base * altura) / 2;
    }

    public static double areaRectangulo(float base, float altura) {
        return base * altura;
    }

    public static double areaCuadrado(float lado) {
        return Math.pow(lado, 2);
    }

    public static float deCelsiusAFahrenheit(float celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static float deFahrenheitACelsius(float fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void imprimirTablaMultiplicar(int numero) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + numero * i);
        }
    }

    public static double porcentaje(float total, float parcial) {
        return (parcial * 100) / total;
    }

    public static long combinatoria(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    public static long permutacion(int n, int k) {
        return factorial(n) / factorial(n - k);
    }

    public static float promedio(float[] numeros) {
        float suma = 0;
        for (float numero : numeros) {
            suma += numero;
        }
        return suma / numeros.length;
    }

    public static float mediana(float[] numeros) {
        Arrays.sort(numeros);
        if (numeros.length % 2 == 0) {
            return (numeros[numeros.length / 2 - 1] + numeros[numeros.length / 2]) / 2;
        } else {
            return numeros[numeros.length / 2];
        }
    }

    public static float moda(float[] numeros) {
        float moda = 0;
        int maximo = 0;
        for (int i = 0; i < numeros.length; i++) {
            int contador = 0;
            for (int j = 0; j < numeros.length; j++) {
                if (numeros[j] == numeros[i]) {
                    contador++;
                }
            }
            if (contador > maximo) {
                maximo = contador;
                moda = numeros[i];
            }
        }
        return moda;
    }

    public static float desviacionEstandar(float[] numeros) {
        float promedio = promedio(numeros);
        float suma = 0;
        for (float numero : numeros) {
            suma += Math.pow(numero - promedio, 2);
        }
        return (float) Math.sqrt(suma / numeros.length);
    }

    public static float varianza(float[] numeros) {
        return (float) Math.pow(desviacionEstandar(numeros), 2);
    }

    public static double[] resolverEcuacionCuadratica(float a, float b, float c) {
        double discriminante = Math.pow(b, 2) - 4 * a * c;
        if (discriminante < 0) {
            return new double[0];
        } else if (discriminante == 0) {
            return new double[] { -b / (2 * a) };
        } else {
            return new double[] { (-b + Math.sqrt(discriminante)) / (2 * a), (-b - Math.sqrt(discriminante)) / (2 * a) };
        }
    }
    
    public static int mayorV(int[] vector){
        int may = vector[0];
        for (int k = 0; k < vector.length; k++) {
            if (vector[k] > may) may = vector[k];
        }
        return may;
    }

    public static int encontrarV(int[] vector, int buscar){
        int sw = 0, i = 1;
        while (i <= vector.length && sw == 0){
            if (buscar == vector[i]){
                sw = 1;
            } else {
                i++;
            }    
        }
        if (sw != 0) return i;
        return -1;
    }
    
    public static String deci_bina(int decimal){
        return Integer.toBinaryString(decimal);
    }

    public static String deci_octa(int decimal){
        return Integer.toOctalString(decimal); 
    }

    public static int binar_octa(int binario){
        int pos = 0, y = 0, pro = binario, octal = 0; 

        while(pro > 0){
            octal = pro % 1000;
            if (octal == 000) {octal = 0;}
            if (octal == 001) {octal = 1;}
            if (octal == 010) {octal = 2;}
            if (octal == 011) {octal = 3;}
            if (octal == 100) {octal = 4;}
            if (octal == 101) {octal = 5;}
            if (octal == 110) {octal = 6;}
            if (octal == 111) {octal = 7;}
            y = y + octal * pos;
            pro = pro / 1000;
            if (octal == 0){
                pos = 1;
            } else {
                pos = pos * 10;
            }            
        }
        return y;
    }

    public static int bina_deci(int binario){
        int pos = 1, y = 0, pro = binario, decimal = 0;
        while (pro > 0) {
            decimal = pro % 10;
            y = y + decimal * pos;
            pos = pos * 2;
            pro = pro / 10;
        }
        return y;
    }

    public static int octa_deci(int octa){
        int pos = 1, y = 0, pro = octa, decimal = 0;
        while (pro > 0) {
            decimal = pro % 10;
            y = y + decimal * pos;
            pos = pos * 8;
            pro = pro / 10;
        }
        return y;
    }

    public static String deci_hexa(int decimal){
        return Integer.toHexString(decimal);
    }

    public static int eliminar_digito(int numero, int digito){
        int x = numero, R = 0, p = 1;

        while (x != 0){
            int es = x % 10;
            if (es != digito){
                R = R + es * p;
                p = p * 10;
            }
            x = x / 10;
        }        
        return R;
    }

    public static double acer_seno(double x, long lim){
        int k, j;
        long sig;
        double seno = 0, fac, pot;
        for (int i = 0; i <= lim; i++){
            sig = 1;
            for (k = 1; k <= i; k++) {
                sig = sig * -1;
            }
            fac = 1;
            pot =1;
            for (j = 1; j <= 2 * i + 1; j++) {
                fac = fac * j;
                pot = pot * x;
            }
            seno =seno + sig * pot / fac;
        }
        return seno;
    }

    public static double acer_coseno(double x, long lim){
        int i1, j1, k1;
        long sig1;
        double co = 0, fac1, pot1;
        co = 0;
        for (i1 = 0; i1 <= lim; i1++){
            sig1 = 1;
            for (k1 = 1; k1 <= i1; k1++) {
                sig1 = sig1 * -1;
            }
            fac1 = 1;
            pot1 =1;
            for (j1 = 1; j1 <= 2 * i1; j1++) {
                fac1 = fac1 * j1;
                pot1 = pot1 * x;
            }
            co = co + sig1 * pot1 / fac1;
        }
        return co;
    }

    public static long[] generar_Sin_Fibonnacci(int lim){
        long suce[] = new long[lim+1];
        suce[0] = 0;
        suce[1] = 1;
        for (int i = 3; i <= lim+1; i++) {
            suce[i] = suce[i-2] + suce[i-1];
        }
        return suce;
    }

    public static long sumar_Sin_Fibonacci(int lim){
        long serie[] = generar_Sin_Fibonnacci(lim);
        long res = 0;
        for (int i = 1; i <= lim +1; i++) {
            res = res + serie[i];
        }
        return res;
    }

    public static double acer_pi(int n){
        double pi = 0;
        for (int i = 0; i <= n; i++) {
            pi = pi + Math.pow(-1, i) / (2 * i + 1);
        }
        return pi * 4;
    }

    public static boolean es_primo(int primo){
        int con = 0;
        for (int j = 1; j <= primo; j++) {
            if (primo % j == 0) {
                con = con + 1;
            }
        }
        return con == 2;
    }

    public static void Llenar(Scanner sc, String file_name, int n_campos) {
        String campos[] = new String[n_campos+1];
        try {
            FileWriter outFile = new FileWriter(file_name + ".txt", false);  //Archivo.txt
            // if false the file will be deleted and created everytime
            // if true the registers will be appended to the end of the file
            PrintWriter register_clientes = new PrintWriter(outFile);

            // LOGICA
            String hay_cliente;
            System.out.println("Hay mas registros? si - no");
            hay_cliente = sc.nextLine();
            while (hay_cliente.equalsIgnoreCase("si")) {
                for(int i = 0; i <= n_campos;i++) {
                    System.out.println("digite el campo " + i);
                    campos[i] = sc.nextLine();
                }
                String registro = campos[1];
                //if (campo2.compareToIgnoreCase("deposito") == 0 && Double.parseDouble(campo3) > 500000) campo3 = String.valueOf(Double.parseDouble(campo3) + 20000);
                    for (int i = 1; i <=n_campos; i++) {
                        registro = registro+ "\t" + campos[i];
                    }
                    register_clientes.println(registro);
                System.out.println("Hay registos? si - no");
                hay_cliente = sc.nextLine();
            }
            register_clientes.close();
        } catch (IOException ex) {
            System.out.println("Error creando el archivo");
            ex.printStackTrace();
        }
    }
    
    public static void Leer(Scanner sc, String file_name) {
        boolean hay = false;
        while (hay == false) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file_name + ".txt"));
                String line = null; //definición de line
                while ((line = br.readLine()) != null) {
                    String registro = null;
                    String temp[] = line.split("\t");
                    // String temp[] ={1,2,3,4}
                    for (int i = 0; i <= temp.length; i++) {
                        registro = registro +"," + temp[i];
                    }
                    System.out.println(registro);
                }
                br.close();
                hay = true;

            } catch (IOException ex) {
                System.out.println("No se encontro archivo");
                hay = false;
                file_name = sc.nextLine(); // Archivo
            }
        }
    }

    public static void ordenarVector(int[] vector) {
        Arrays.sort(vector);
    }

    public static void imprimirVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.println(vector[i]);
        }
    }

    public static void llenarVector(int[] vector, Scanner sc) {
        for (int i = 0; i < vector.length; i++) {
            System.out.println("Digite el valor de la posicion " + i);
            vector[i] = sc.nextInt();
        }
    }

    public static void llenarMatriz(int[][] matriz, Scanner sc) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("Digite el valor de la posicion " + i + " " + j);
                matriz[i][j] = sc.nextInt();
            }
        }
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println(matriz[i][j]);
            }
        }
    }

    public static int[][] sumarMatrices(int[][] matriz1, int[][] matriz2) {
        int[][] matrizSuma = new int[matriz1.length][matriz1[0].length];
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {
                matrizSuma[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        return matrizSuma;
    }

    public static int[][] multiplicarMatrices(int[][] matriz1, int[][] matriz2) {
        int[][] matrizProducto = new int[matriz1.length][matriz2[0].length];
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz2[0].length; j++) {
                for (int k = 0; k < matriz1[0].length; k++) {
                    matrizProducto[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }
        return matrizProducto;
    }

    public static int[][] transponerMatriz(int[][] matriz) {
        int[][] matrizTranspuesta = new int[matriz[0].length][matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matrizTranspuesta[j][i] = matriz[i][j];
            }
        }
        return matrizTranspuesta;
    }

    public static int[][] matrizIdentidad(int n) {
        int[][] matrizIdentidad = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrizIdentidad[i][i] = 1;
        }
        return matrizIdentidad;
    }

    public static boolean esMatrizIdentidad(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][i] != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean esNumero(String cadena) {
        return cadena.matches("[0-9]+");
    }

    public static boolean esPalabra(String cadena) {
        return cadena.matches("[a-zA-Z]+");
    }

    public static boolean esCorreo(String cadena) {
        return cadena.matches("^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$");
    }
    
    public static int contarVocales(String cadena) {
        int contador = 0;
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                contador++;
            }
        }
        return contador;
    }
    
    public static int contarConsonantes(String cadena) {
        int contador = 0;
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' &&
                    c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                    contador++;
                }
            }
        }
        return contador;
    }

    public static int contarPalabras(String cadena) {
        return cadena.split(" ").length;
    }

    public static int contarLineas(String cadena) {
        return cadena.split("\n").length;
    }
    
    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    public static boolean esImpar(int numero) {
        return !esPar(numero);
    }
    
    public static long factorial(int numero) {
        if (numero <= 1) return 1;
        else return numero * factorial(numero - 1);
    }
    
    public static String invertirCadena(String cadena) {
        String invertida = "";
        for (int i = cadena.length() - 1; i >= 0; i--) {
            invertida += cadena.charAt(i);
        }
        return invertida;
    }

    public static String encriptarCadena(String cadena, int desplazamiento) {
        String encriptada = "";
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c = (char) (c + desplazamiento);
                if (c > 'z') {
                    c = (char) (c - 'z' + 'a' - 1);
                }
            } else if (c >= 'A' && c <= 'Z') {
                c = (char) (c + desplazamiento);
                if (c > 'Z') {
                    c = (char) (c - 'Z' + 'A' - 1);
                }
            }
            encriptada += c;
        }
        return encriptada;
    }

    public static String desencriptarCadena(String cadena, int desplazamiento) {
        return encriptarCadena(cadena, -desplazamiento);
    }
    
    public static int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public static int sumaDigitos(int numero) {
        int suma = 0;
        while (numero != 0) {
            suma += numero % 10;
            numero /= 10;
        }
        return suma;
    }
    
    public static Map<Character, Integer> contarCaracteres(String cadena) {
        Map<Character, Integer> frecuencias = new HashMap<>();
        for (char c : cadena.toCharArray()) {
            frecuencias.put(c, frecuencias.getOrDefault(c, 0) + 1);
        }
        return frecuencias;
    }

    public static int[] invertirVector(int[] vector) {
        int[] invertido = new int[vector.length];
        for (int i = 0; i < vector.length; i++) {
            invertido[i] = vector[vector.length - 1 - i];
        }
        return invertido;
    }

    public static int[] eliminarRepetidos(int[] vector) {
        int[] sinRepetidos = new int[vector.length];
        int contador = 0;
        for (int i = 0; i < vector.length; i++) {
            boolean repetido = false;
            for (int j = 0; j < contador; j++) {
                if (vector[i] == sinRepetidos[j]) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido) {
                sinRepetidos[contador] = vector[i];
                contador++;
            }
        }
        return sinRepetidos;
    }

    public static int[] eliminarRepetidos(ArrayList<Integer> vector) {
        return vector.stream().distinct().mapToInt(i -> i).toArray();
    }

    public static int[] eliminarElemento(int[] vector, int elemento) {
        return Arrays.stream(vector).filter(e -> e != elemento).toArray();
    }

    public static int[] eliminarElementos(int[] vector, int[] elementos) {
        return Arrays.stream(vector).filter(e -> Arrays.stream(elementos).noneMatch(i -> i == e)).toArray();
    }

    public static int[] eliminarElementos(ArrayList<Integer> vector, ArrayList<Integer> elementos) {
        return vector.stream().filter(e -> elementos.stream().noneMatch(i -> i == e)).mapToInt(i -> i).toArray();
    }

    public static int[] mezclarVectores(int[] vector1, int[] vector2) {
        int[] mezclado = new int[vector1.length + vector2.length];
        for (int i = 0; i < vector1.length; i++) {
            mezclado[i] = vector1[i];
        }
        for (int i = 0; i < vector2.length; i++) {
            mezclado[vector1.length + i] = vector2[i];
        }
        return mezclado;
    }

    public static int[] mezclarVectores(ArrayList<Integer> vector1, ArrayList<Integer> vector2) {
        int[] mezclado = new int[vector1.size() + vector2.size()];
        for (int i = 0; i < vector1.size(); i++) {
            mezclado[i] = vector1.get(i);
        }
        for (int i = 0; i < vector2.size(); i++) {
            mezclado[vector1.size() + i] = vector2.get(i);
        }
        return mezclado;
    }

    public static int[] ordenarVector(ArrayList<Integer> vector) {
        return vector.stream().sorted().mapToInt(i -> i).toArray();
    }

    public static int[] subVector(int[] vector, int inicio, int fin) {
        return Arrays.copyOfRange(vector, inicio, fin);
    }

    public static int[] subVector(ArrayList<Integer> vector, int inicio, int fin) {
        return vector.subList(inicio, fin).stream().mapToInt(i -> i).toArray();
    }
    
    public static String sendMessageAPI(String modelo, String promtText) throws ProtocolException, IOException, URISyntaxException {
        if ("".equals(modelo)) modelo = "llama3.2";
        
        URL url = new URI("http", "localhost", "/api/generate", null).toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; utf-8");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);
        
        String jsonInputString = "{ \"model\": " + modelo + ", \"prompt\": " + promtText + ", \"stream\": false}";

        // Write the JSON body to the request
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input,0, input.length);
        }

        System.out.println("Response Code: " + conn.getResponseCode());
        
        StringBuilder response;
        try ( BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
            response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) response.append(line);
        }

        return obtenerCampo(response.toString(), "response");
    }

    public static String obtenerCampo(String json, String campo) {
        String clave = "\"" + campo + "\":";
        int inicio = json.indexOf(clave);
        if (inicio == -1) return null; // El campo no se encuentra

        inicio += clave.length(); // Mover el inicio al valor del campo
        int fin = inicio;
        boolean dentroDeComillas = false;

        while (fin < json.length()) {
            char actual = json.charAt(fin);
            if (actual == '\"') dentroDeComillas = !dentroDeComillas; // Cambiar el estado si encontramos una comilla

            // Si estamos fuera de comillas y encontramos una coma o un cierre de llave
            if (!dentroDeComillas && (actual == ',' || actual == '}')) break; // Salimos del bucle
            fin++;
        }

        String valor = json.substring(inicio, fin).trim();
        if (valor.startsWith("\"") && valor.endsWith("\"")) valor = valor.substring(1, valor.length() - 1); // Eliminar las comillas si es un string
        return valor;
    }
    
    public static void eliminarMultiplos(int[] criba, int numero) {
        for (int i = 0; i < criba.length; i++) {
            if (criba[i] != 0 && criba[i] % numero == 0) criba[i] = 0; 
        }
    }
    
    public static int[] getVectorPrimos(int N) {
        int[] criba = new int[N - 1];  // Creamos el vector Criba con los números [2, N]
        int[] primos = new int[N - 1];
        int contadorPrimos = 0;  // Este contador rastrea cuántos números primos hemos encontrado

        for (int i = 0; i < criba.length; i++) criba[i] = i + 2;

        // Proceso de la Criba de Eratóstenes
        for (int i = 0; i < criba.length; i++) {
            if (criba[i] != 0) {
                primos[contadorPrimos] = criba[i]; // se toma el primer elemento no eliminado como primo
                contadorPrimos++;
                eliminarMultiplos(criba, criba[i]); // Eliminamos este número y todos sus múltiplos de Criba
            }
        }
        
        return primos;
    }

    public static int cambiarBase(int numero, int base) {
        return Integer.parseInt(Integer.toString(numero, base));
    }

    public static int[] cambiarBase(int[] vector, int base) {
        int[] vectorBase = new int[vector.length];
        for (int i = 0; i < vector.length; i++) {
            vectorBase[i] = cambiarBase(vector[i], base);
        }
        return vectorBase;
    }

    public static int[] rango(int inicio, int fin) {
        return rango(inicio, fin, 1);
    }

    public static int[] rango(int inicio, int fin, int paso) {
        int[] rango = new int[(fin - inicio) / paso + 1];
        for (int i = 0; i < rango.length; i++) {
            rango[i] = inicio + i * paso;
        }
        return rango;
    }

    public static int[] rango(int fin) {
        return rango(0, fin);
    }

    public static int[] factoresPrimos(int numero) {
        int[] factores = new int[0];
        int divisor = 2;
        while (numero != 1) {
            if (numero % divisor == 0) {
                factores = Arrays.copyOf(factores, factores.length + 1);
                factores[factores.length - 1] = divisor;
                numero /= divisor;
            } else {
                divisor++;
            }
        }
        return factores;
    }

    public static boolean estaOrdenado(int[] vector, boolean ascendente) {
        for (int i = 0; i < vector.length - 1; i++) {
            if (ascendente && vector[i] > vector[i + 1]) return false;
            if (!ascendente && vector[i] < vector[i + 1]) return false;
        }
        return true;
    }

    public static int determinanteMatriz(int[][] matriz) {
        if (matriz.length == 2) {
            return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
        } else {
            int determinante = 0;
            for (int i = 0; i < matriz.length; i++) {
                int[][] submatriz = new int[matriz.length - 1][matriz.length - 1];
                for (int j = 1; j < matriz.length; j++) {
                    for (int k = 0; k < matriz.length; k++) {
                        if (k < i) {
                            submatriz[j - 1][k] = matriz[j][k];
                        } else if (k > i) {
                            submatriz[j - 1][k - 1] = matriz[j][k];
                        }
                    }
                }
                determinante += matriz[0][i] * Math.pow(-1, i) * determinanteMatriz(submatriz);
            }
            return determinante;
        }
    }

    public static int[] obtenerColumna(int[][] matriz, int columna) {
        int[] columnaMatriz = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            columnaMatriz[i] = matriz[i][columna];
        }
        return columnaMatriz;
    }

    public static int[] obtenerFila(int[][] matriz, int fila) {
        return matriz[fila];
    }

    public static int[] obtenerDiagonalPrincipal(int[][] matriz) {
        int[] diagonalPrincipal = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            diagonalPrincipal[i] = matriz[i][i];
        }
        return diagonalPrincipal;
    }

    public static int[] obtenerDiagonalSecundaria(int[][] matriz) {
        int[] diagonalSecundaria = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            diagonalSecundaria[i] = matriz[i][matriz.length - 1 - i];
        }
        return diagonalSecundaria;
    }
    
    public static String[] getLetras(String frase){
        String[] letras = new String[frase.length()];
        for (int i = 0; i < frase.length(); i++) {
            letras[i] = frase.substring(i, i + 1);
        }
        return letras;
    }

    public static String[] getLetrasUnicas(String frase){
        String[] letras = new String[0];
        for (int i = 0; i < frase.length(); i++) {
            if (!estaIncluido(letras, frase.substring(i, i + 1))) {
                letras = Arrays.copyOf(letras, letras.length + 1);
                letras[letras.length - 1] = frase.substring(i, i + 1);
            }
        }
        return letras;
    }

    public static String[] getPalabras(String frase){
        return frase.split(" ");
    }

    public static boolean estaIncluido(String[] letras, String letra){
        for (String letra1 : letras) {
            if (letra1.equals(letra)) return true;
        }
        return false;
    }
    
    public static int getIndiceLetra(String[] letras, String letra) {
        for (int i = 0; i < letras.length; i++) {
            if (letras[i].equals(letra)) return i;
        }
        return -1;
    }
    
    public static void OrdenarMatriz(int[][] array, int columna) { // Usamos Bubble Sort para ordenar la columna indicada
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j][columna] > array[j + 1][columna]) {
                    int[] temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static double[] getVectorAleatorio(int n) {
        double[] vector = new double[n];
        for (int i = 0; i < n; i++) {
            vector[i] = Math.random() * 100;
        }
        return vector;
    }

    public static double[] getVectorAleatorio(int n, double min, double max) {
        double[] vector = new double[n];
        for (int i = 0; i < n; i++) {
            vector[i] = Math.random() * (max - min) + min;
        }
        return vector;
    }

    public static double raizCuadrada(double numero) {
        return Math.sqrt(numero);
    }

    public static double raizCubica(double numero) {
        return Math.cbrt(numero);
    }

    public static double potencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }

    public static float MatrizInversa(float[][] matriz) {
        float determinante = 0;
        for (int i = 0; i < matriz.length; i++) {
            float productoDiagonal = 1;
            float productoDiagonalInversa = 1;
            for (int j = 0; j < matriz.length; j++) {
                productoDiagonal *= matriz[j][j];
                productoDiagonalInversa *= matriz[j][matriz.length - 1 - j];
            }
            determinante += productoDiagonal - productoDiagonalInversa;
        }
        return determinante;
    }
}