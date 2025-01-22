package esercizi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class KeyboardScannerAscDesc {

	public void run() {
		
		Scanner sc = new Scanner(System.in);
		
		int arraySize = getArraySize(sc, "Inserisci il numero di elementi che deve avere l'array, e premi \"Enter\"");		
		int[] arrayElements = getArrayElements(sc, arraySize);
		
		String order = getOrder();
		
		System.out.println("Numero di elementi: " + arraySize);
		System.out.println("Ordinamento scelto: " + order);
		printArray("Array iniziale", arrayElements);
		
		printArray("Array ordinato", orderArray(arrayElements, order));
		
	}
	
	
	/* Questo metodo ha il compito di richiedere un input intero positivo, ovvero
	 * la dimensione dell'array.
	 * Se ciò che viene fornito dall'utente non è di tipo int positivo verrà
	 * richiesto all'infinito. */
	protected int getArraySize(Scanner sc, String prompt) {
		return getValidPositiveInteger(sc, prompt);
	}

	/* Questo metodo ritorna un array con i valori inseriti dall'utente */
	protected int[] getArrayElements(Scanner sc, int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = getValidInteger(sc, "Aggiungi elemento all'array - [pos: " + i + "]");
		}
		return arr;
	}
	
	// Questo metodo stampa gli array
	protected void printArray(String arrName, int[] array) {
		String arrToString = "[";
		for (int el : array) {
			arrToString += ", " + el;
		}
		arrToString = arrToString.replaceFirst(", ", "");
		arrToString += "]\n";
		System.out.println(arrName + ": " + arrToString);
	}
	
	/* Questo metodo ha il compito di recuperare la scelta dell'utente sull'ordinamento
	 * dell'array */
	protected String getOrder() {
		Scanner sc = new Scanner(System.in);
		String errorMessage = "\nERROR:\nInput non valido. Per favore, inserisci \"ASC\" (crescente) o \"DESC\" (decrescente)";
		String order = "";
		
		while (true) {
			System.out.println("Scegli ordinamento tra \"ASC\" (crescente) o \"DESC\" (decrescente)");
			
			if (sc.hasNext()) {
				order = sc.next();
			} else {
				System.err.println(errorMessage);
			}
			
			if (order.equalsIgnoreCase("ASC") || order.equalsIgnoreCase("DESC")) {
				
				return order.toUpperCase();
			} else {
				System.err.println(errorMessage);
			}
			
		}
	}
	
	// Questo metodo ha il compito di validare il numero intero fornito dall'utente
	protected int getValidPositiveInteger(Scanner sc, String prompt) {
		String errorMessage = "\nERROR:\nInput non valido. Per favore, inserisci un numero intero positivo.\n";
		
		// Finchè non ottengo un int positvo
		while (true) {
		    System.out.println(prompt);

		    if (sc.hasNextInt()) {
		        int inInt = sc.nextInt(); // Leggo il numero intero
		        if (inInt > 0) {
		            return inInt; // Se positivo, ritorno il valore
		        } else {
		            System.err.println(errorMessage);
		            // Non consumo ulteriori token, dato che inInt è già stato letto
		        }
		    } else {
		        System.err.println(errorMessage);
		        sc.next(); // Consuma il token non valido
		    }
		}
	}
	
	// Questo metodo ha il compito di fornire un intero valido da parte dell'utente
	protected int getValidInteger(Scanner sc, String prompt) {
		String errorMessage = "\nERROR:\nInput non valido. Per favore, inserisci un numero intero.\n";
		
		// Finchè non ottengo un int
		while (true) {
		    System.out.println(prompt);

		    if (sc.hasNextInt()) {
		        int inInt = sc.nextInt(); // Leggo il numero intero
		        return inInt;
		    } else {
		        System.err.println(errorMessage);
		        sc.next(); // Consuma il token non valido
		    }
		}
	}
	
	/* Questo metodo ordina l'array passato come argomento in base all'ordinamento
	scelto dall'utente */
	protected int[] orderArray(int[] arr, String order) {
		if (order.equalsIgnoreCase("ASC")) {
			return orderByAsc(arr);
		} else {
			return orderByDesc(arr);
		}
	}
	
	// Questo metodo ha il compito di ordinare in modo ASC un arr di int
	protected int[] orderByAsc(int[] arr) {
		Arrays.sort(arr);
		return arr;
	}
	
	protected int[] orderByDesc(int[] arr) {
		
		// Converto l'array primitivo in un array di oggetti (utilizzabile da comparator)
		// Converti int[] a Integer[]
		Integer[] arrObj = Arrays.stream(arr).boxed().toArray(Integer[]::new);
		
		// Utilizziamo un comparatore personalizzato per l'ordinamento decrescente
        Arrays.sort(arrObj, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // Ordinamento decrescente
                return b.compareTo(a);
            }
        });
        
        // Ritorno l'array convertito da Integer[] a int[]
        return Arrays.stream(arrObj)
                .mapToInt(Integer::intValue) // Converte ogni Integer in int
                .toArray();
	}

} 
