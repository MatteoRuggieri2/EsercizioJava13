package esercizi;

import java.util.Arrays;
import java.util.Scanner;

public class KeyboardScannerAscDesc {

	public void run() {
		
		int arraySize = getArraySize("Inserisci il numero di elementi che deve avere l'array, e premi \"Enter\"");		
		int[] arrayElements = getArrayElements(arraySize);
		
		String order = getOrder();
		
		System.out.println("Numero di elementi: " + arraySize);
		System.out.println("Ordinamento scelto: " + order);
		printArray("Array iniziale", arrayElements);
		
//		// Chiedo di inserire il numero di elementi, salvo il valore e lo stampo
//		System.out.println("Inserisci il numero di elementi che deve avere l'array");
//		int userInputElementsNumber = 0;
//		
//		try {
//			userInputElementsNumber = scanner.nextInt();
//		} catch (InputMismatchException e) {
//			System.err.println("Errore input. Riavvia il programma");
//			scanner.close();
//		}
//		System.out.println("Numero di elementi richiesti: " + userInputElementsNumber);
//		
//		
//		
//		
//		
//		// Chiedo in che ordine vuole l'array, salvo il valore e lo stampo
//		System.out.println("Scegli l'ordinamento array tra 'ASC' O 'DESC'");
//		String userInputElementsOrder = scanner.next();
//		System.out.println("Ordine scelto: " + userInputElementsOrder);
//		
//		
//		// Creo l'array della lunghezza indicata (di default tutti i valori sono 0)
//		int numArray[] = new int[userInputElementsNumber];
//		
//		for (int i = 0; i < userInputElementsNumber; i++) {
//			System.out.println("Digita il valore n° " + (i + 1));
//			numArray[i] = scanner.nextInt();
//		}
//		
//		// Stampo array primitivo
//		for (int element : numArray) {
//			System.out.println(element);
//		}
//		
//		// ORDINE ASC
//		// Ordino l'array in ordine crescente
//		Arrays.sort(numArray);
//		
//		// Stampo array primitivo
//		for (int element : numArray) {
//			System.out.println(element);
//		}
//		
//		int[] numArraySorted = numArray;
//		
//		
//		// ORDINE DESC
//		// Utilizziamo un comparatore personalizzato per l'ordinamento decrescente
//        Arrays.sort(array, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer a, Integer b) {
//                // Ordinamento decrescente
//                return b.compareTo(a);
//            }
//        });
	}
	
	
	/* Questo metodo ha il compito di richiedere un input intero positivo, ovvero
	 * la dimensione dell'array.
	 * Se ciò che viene fornito dall'utente non è di tipo int positivo verrà
	 * richiesto all'infinito. */
	public int getArraySize(String prompt) {
		return getValidPositiveInteger(prompt);
	}

	/* Questo metodo ritorna un array con i valori inseriti dall'utente */
	private int[] getArrayElements(int n) {
		int[] myArray = new int[n];
		for (int i = 0; i < n; i++) {
			myArray[i] = getValidInteger("Aggiungi elemento all'array - [pos: " + i + "]");
		}
		return myArray;
	}
	
	// Questo metodo stampa gli array
	private void printArray(String arrName, int[] array) {
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
	private String getOrder() {
		Scanner sc = new Scanner(System.in);
		String errorMessage = "\nERROR:\nInput non valido. Per favore, inserisci \"ASC\" o \"DESC\"";
		String order = "";
		
		while (true) {
			System.out.println("Scegli ordinamento tra ASC o DESC");
			
			if (sc.hasNext()) {
				order = sc.next();
			} else {
				System.out.println(errorMessage);
			}
			
			if (order.toUpperCase().equals("ASC") || order.toUpperCase().equals("DESC")) {
				sc.close();
				return order.toUpperCase();
			} else {
				System.out.println(errorMessage);
			}
			
		}
	}
	
	// Questo metodo ha il compito di validare il numero intero fornito dall'utente
	private int getValidPositiveInteger(String prompt) {
		Scanner sc = new Scanner(System.in);
		String errorMessage = "\nERROR:\nInput non valido. Per favore, inserisci un numero intero positivo.\n";
		
		// Finchè non ottengo un int positvo
		while (true) {
		    System.out.println(prompt);

		    if (sc.hasNextInt()) {
		        int inInt = sc.nextInt(); // Leggo il numero intero
		        if (inInt > 0) {
		            return inInt; // Se positivo, ritorno il valore
		        } else {
		            System.out.println(errorMessage);
		            // Non consumo ulteriori token, dato che inInt è già stato letto
		        }
		    } else {
		        System.out.println(errorMessage);
		        sc.next(); // Consuma il token non valido
		    }
		}
	}
	
	// Questo metodo ha il compito di fornire un intero valido da parte dell'utente
	private int getValidInteger(String prompt) {
		Scanner sc = new Scanner(System.in);
		String errorMessage = "\nERROR:\nInput non valido. Per favore, inserisci un numero intero.\n";
		
		// Finchè non ottengo un int positvo
		while (true) {
		    System.out.println(prompt);

		    if (sc.hasNextInt()) {
		        int inInt = sc.nextInt(); // Leggo il numero intero
		        return inInt;
		    } else {
		        System.out.println(errorMessage);
		        sc.next(); // Consuma il token non valido
		    }
		}
	}
	
	// Questo metodo ha il compito di ordinare in modo ASC un arr di int
	private int[] orderByAsc(int[] arr) {
		Arrays.sort(arr);
		return arr;
	}

}
