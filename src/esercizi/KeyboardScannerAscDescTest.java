package esercizi;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KeyboardScannerAscDescTest {
	
	KeyboardScannerAscDesc ksad;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		ksad = new KeyboardScannerAscDesc();
	}

	// Tutti i metodi sono stati impostati come protected per poter effettuare i test

	@Test
	void getArraySizeTest() {
		
		// Test input corretto
		String simulatedInput = "3\n"; // Simula l'input dell'utente
	    Scanner sSc = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
		assertEquals(3, ksad.getArraySize(sSc));
		
		// Test input errato per 3 volte (il limite di tentativi prima che il programma si fermi)
		String simulatedInput2 = "test\ntest\ntest\n";
		Scanner sSc2 = new Scanner(new ByteArrayInputStream(simulatedInput2.getBytes()));
		assertThrows(IllegalArgumentException.class, () -> ksad.getArraySize(sSc2));
	}
	
	@Test
	void getArrayElementsTest() {
		
		// Test input corretto
		String simulatedInput = "3\n54\n09\n"; // Simula l'input dell'utente
	    Scanner sSc = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
	    int[] resultArray = {3, 54, 9};
		assertArrayEquals(resultArray, ksad.getArrayElements(sSc, 3));
		
		// Test input errato per 3 volte (il limite di tentativi prima che il programma si fermi)
		String simulatedInput2 = "test\n5test\ntest7\n"; // Simula l'input dell'utente
	    Scanner sSc2 = new Scanner(new ByteArrayInputStream(simulatedInput2.getBytes()));
		assertThrows(IllegalArgumentException.class, () -> ksad.getArraySize(sSc2));
	}
	
	@Test
	void printArrayTest() {
		
		int[] intArray = {12, 4, 98};
		String arrToString = "intArray: [12, 4, 98]\n";
		assertEquals(arrToString, ksad.printArray("intArray", intArray));
	}
	
	@Test
	void getOrderingTest() {
		
		String correctAscInpUpp = "ASC";
		String correctDescInpUpp = "DESC";
		String correctAscInpLow = "asc";
		String correctDescInpLow = "desc";
		String correctAscInpCapital = "Asc";
		String wrongMaxAttempts = "0asc\ndesc0\n10\n";
		
		Scanner correctAscInpUppSSC = new Scanner(new ByteArrayInputStream(correctAscInpUpp.getBytes()));
		assertEquals("ASC", ksad.getOrdering(correctAscInpUppSSC));
		
		Scanner correctDescInpUppSCC = new Scanner(new ByteArrayInputStream(correctDescInpUpp.getBytes()));
		assertEquals("DESC", ksad.getOrdering(correctDescInpUppSCC));
		
		Scanner correctAscInpLowSSC = new Scanner(new ByteArrayInputStream(correctAscInpLow.getBytes()));
		assertEquals("ASC", ksad.getOrdering(correctAscInpLowSSC));
		
		Scanner correctDescInpLowSSC = new Scanner(new ByteArrayInputStream(correctDescInpLow.getBytes()));
		assertEquals("DESC", ksad.getOrdering(correctDescInpLowSSC));
		
		Scanner correctAscInpCapitalSSC = new Scanner(new ByteArrayInputStream(correctAscInpCapital.getBytes()));
		assertEquals("ASC", ksad.getOrdering(correctAscInpCapitalSSC));
		
		Scanner wrongMaxAttemptsSSC = new Scanner(new ByteArrayInputStream(wrongMaxAttempts.getBytes()));
		assertThrows(IllegalArgumentException.class, () -> ksad.getOrdering(wrongMaxAttemptsSSC));
	}
	
	@Test
	void orderByAscTest() {
		
		int[] unsortedArr = {30, 10, 20};
		int[] ascSortedArr = {10, 20, 30};
		assertArrayEquals(ascSortedArr, ksad.orderByAsc(unsortedArr));
	}
	
	@Test
	void orderByDescTest() {
		
		int[] unsortedArr = {30, 10, 20};
		int[] descSortedArr = {30, 20, 10};
		assertArrayEquals(descSortedArr, ksad.orderByDesc(unsortedArr));
	}
	
}
