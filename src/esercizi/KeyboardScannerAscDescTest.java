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
	
}
