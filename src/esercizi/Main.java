package esercizi;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		/* 1- Leggere da keyboard n° elementi array di int
		 * 2- Leggere tipo ordinamento A/O (chiedere all'utente se vuole i valori ordinati in "cresc" o "decr" ovvero ASC o DESC)
		 * 3- Istanziare array
		 * 4- Stamparlo ordinato
		 *  
		 *  
		 *  Classe Arrays  [  fornisce alcuni metodi come Arrays.sort(array) o Arrays.sort(array, comparatore)    ]
		 *  Il comparatore è una classe anonima che implementa il comparator
		 *  */
		
		
		// Creo scanner
		Scanner scanner = new Scanner(System.in);
		
		// Chiedo di inserire il numero di elementi, salvo il valore e lo stampo
		System.out.println("Inserisci il numero di elementi che deve avere l'array");
		int userInputElementsNumber = 0;
		
		try {
			userInputElementsNumber = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("Errore input. Riavvia il programma");
			scanner.close();
		}
		System.out.println("Numero di elementi richiesti: " + userInputElementsNumber);
		
		
		
		
		
		// Chiedo in che ordine vuole l'array, salvo il valore e lo stampo
		System.out.println("Scegli l'ordinamento array tra 'ASC' O 'DESC'");
		String userInputElementsOrder = scanner.next();
		System.out.println("Ordine scelto: " + userInputElementsOrder);
		
		
		// Creo l'array della lunghezza indicata (di default tutti i valori sono 0)
		int numArray[] = new int[userInputElementsNumber];
		
		for (int i = 0; i < userInputElementsNumber; i++) {
			System.out.println("Digita il valore n° " + (i + 1));
			numArray[i] = scanner.nextInt();
		}
		
		// Stampo array primitivo
		for (int element : numArray) {
			System.out.println(element);
		}
		
		// ORDINE ASC
		// Ordino l'array in ordine crescente
		Arrays.sort(numArray);
		
		// Stampo array primitivo
		for (int element : numArray) {
			System.out.println(element);
		}
		
		int[] numArraySorted = numArray;
		
		
		// ORDINE DESC
		// Utilizziamo un comparatore personalizzato per l'ordinamento decrescente
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // Ordinamento decrescente
                return b.compareTo(a);
            }
        });
		
	}

}




















