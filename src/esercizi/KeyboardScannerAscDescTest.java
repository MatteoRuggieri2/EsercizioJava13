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
//		String simulatedInput = "3\n"; // Simula l'input dell'utente
//	    Scanner sSc = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
//		assertEquals(3, ksad.getArraySize(sSc));
		
		String simulatedInput2 = "test";
		Scanner sSc2 = new Scanner(new ByteArrayInputStream(simulatedInput2.getBytes()));
		assertEquals(3, ksad.getArraySize(sSc2));
		
		// devo fare che quando riceve una stringa lancia un'exception
	}
	
}
