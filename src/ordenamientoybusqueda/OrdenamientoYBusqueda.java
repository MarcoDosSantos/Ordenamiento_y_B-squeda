package ordenamientoybusqueda;

import java.util.Scanner;

/**
 *
 * @author Marco Dos Santos
 */
public class OrdenamientoYBusqueda {
       
    public static void main(String[] args) {
        /*En esta primera parte, le pedimos al usuario que intruduzca la magnitud
        del array, y que vaya completando las posiciones con números aleatorios.*/
        Scanner intro = new Scanner(System.in);
        try{
            
        System.out.print("Bienvenid@ a Ordenamiento y Búsqueda, "
                + "un programa que combina Bubble Sort y Búsqueda binaria."
                + "\n¿Cuántos números deseas ordenar? ");
        int n = intro.nextInt();
        int numeros[] = new int[n];
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Por favor, introduce cualquier número entero en la posición: " + (i + 1) + ": ");
            numeros[i] = intro.nextInt();
        }
        System.out.println("\nLista de números introducidos sin ordenar: ");
        for (int j = 0; j < numeros.length; j++) {
            System.out.println((j+1) + " - " + numeros[j]);
        }

        // Aquí comienza el ordenamiento mediante el método de la burbuja, o bubble sort.
        for (int k = 0; k <= numeros.length; k++) {/* La primera regla del 
            método es que se debe recorrer el array, tantas veces como posiciones tenga el mismo. */
            for (int apuntador1 = 0; apuntador1 < numeros.length - 1; apuntador1++) {
                int apuntador2 = apuntador1 + 1;
                if (numeros[apuntador1] > numeros[apuntador2]) {
                    int auxiliar = numeros[apuntador1]; /* La segunda regla del método consiste en que nunca
                    *se debe perder un valor almacenado en las posiciones del array.*/
                    numeros[apuntador1] = numeros[apuntador2]; /* La tercera y última regla del método
                    * de la burbuja consiste en que, en cada iteración, si el valor en la posición n, es mayor
                    * que el valor en la posición n+1, éstos deben intercambiarse (asumiendo que hemos elegido un
                    * criterio de ordenamiento ascendente; de lo contrario, debe ser al revés).*/
                    numeros[apuntador2] = auxiliar;
                }
            }

        }

        System.out.println("\nLista de números ordenada: ");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println((i+1) + " - " + numeros[i]);
        }
        
        // Aquí comienza la parte de la búsqueda binaria.
        // Este método de búsqueda sólo funciona si el array se halla previamente ordenado de manera ascendente o descendente.
        
        int mitad = 0;/*Esta variable tiene dos funciones: determinar un extremo 
        * de la porción del array en que se va a buscar el número, y luego también,
        * indicar la posición del número buscado, si es que existe en la lista. */
        int limiteInferior = 0;//Límite móvil, su posición depende de la comparación entre "mitad" y el número buscado.
        int limiteSuperior = numeros.length;// Idem anterior.
        boolean encontrado = false;// valor que determina si el número buscado se ha encontrado o no.
        System.out.print("\nPor favor, indica qué numero quieres buscar: ");
        int numeroBuscado = intro.nextInt();
        
        while(limiteInferior <= limiteSuperior && !encontrado){
            mitad = (limiteInferior + limiteSuperior) / 2;
            /* Mientras que el límite inferior del ámbito de búsqueda sea menor o igual
            * a su límite superior, y el número buscado, no haya sido encontrado, el programa
            * debe continuar haciendo lo siguiente: determinar que la variable "mitad" debe ser
            * la mitad de la suma de ambos límites.
            */
            if(numeros[mitad] == numeroBuscado){encontrado = true;}
            /* Si el valor buscado es igual al valor en la posición indicada por "mitad" 
            * cambia el valor del booleano "encontrado", y la ejecución salta a la instrucción correspondiente.
            */
            else if (numeros[mitad] > numeroBuscado){limiteSuperior = mitad -1;}
            /* Si el valor hallado en la posición indicada por "mitad" es mayor al número buscado, 
            * significa que el número buscado estará en la porción de los números menores a mitad.
            * Luego, el límite superior del ámbito en que se buscará el número, se corre a una posición
            * menos que la que actualmente ocupa "mitad", y vuelve a comenzar la búsqueda.
            */
            else if (numeros[mitad] < numeroBuscado){limiteInferior = mitad +1;}
            // Caso inverso al anterior.
        }
        if(encontrado){System.out.println("\n¡Felicidades! El número " + numeroBuscado + " se encuentra en la posición "
        + (mitad + 1) + " de la lista ordenada de números."
        );} else {System.out.println("\nLamentablemente, el número buscado no ha sido encontrado.");}
        
        }catch(Exception e){
            System.out.println("\nEste programa sólo admite números enteros (no decimales ni otro tipo de caracteres).");                        
        }
        
    }

}
