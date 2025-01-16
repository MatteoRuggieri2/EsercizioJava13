package esercizi;

import java.util.Scanner;

public class KeyboardScannerAscDesc {

	public void run() {
		
		int arraySize = getArraySize("Inserisci il numero di elementi che deve avere l'array, e premi \"Enter\"");
		System.out.println(arraySize);
		
//		int[] arrayElements = getArrayElements(arraySize);

		
		
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

	
	private int[] getArrayElements(int n) {
		int[] myArray = new int[n];
		for (int i = 0; i < n; i++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Inserisci elemento array: ");
			myArray[i] = sc.nextInt();
		}
		return myArray;
	}
	
	private String getOrder() {
		Scanner sc = new Scanner(System.in);
		String order = sc.next();
		while (order.equals("ASC") || order.equals("DESC")) {
			System.out.println("Inserisci l'ordine: ");
			order = sc.next();
			
		}
		return order;
	}

}
