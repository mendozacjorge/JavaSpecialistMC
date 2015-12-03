package uaq.cds.jsmc.test;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uaq.cds.jsmc.LeftRightInsert;
import uaq.cds.jsmc.LeftRightInsert2;
import uaq.cds.jsmc.LeftRightInsertJSMC;
import uaq.cds.jsmc.LeftRightInsertJSMC2;

/**
 *
 * @author Jorge
 */
public class UnitTests {

	public UnitTests() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	// The methods must be annotated with annotation @Test. For example:
	//
	@Test
	public void testImpl1() {
		LeftRightInsert<String> list = new LeftRightInsert<>();
		list.add("uno");
		list.add("dos");
		list.add("tres");
		list.add("cuatro");
		list.add("cinco");
		list.add("seis");
		list.add("siete");
		list.add("ocho");
		list.add("nueve");
		list.add("diez");

		assertEquals("[nueve, siete, cinco, tres, uno, dos, cuatro, seis, ocho, diez]", list.toString());
	}

	@Test
	public void testImpl2() {
		LeftRightInsert2<String> list = new LeftRightInsert2<>();
		list.add("uno");
		list.add("dos");
		list.add("tres");
		list.add("cuatro");
		list.add("cinco");
		list.add("seis");
		list.add("siete");
		list.add("ocho");
		list.add("nueve");
		list.add("diez");

		assertEquals("[nueve, siete, cinco, tres, uno, dos, cuatro, seis, ocho, diez]", list.toString());
	}

	public static void main(String... args) {

		try {
			LeftRightInsert2<String> list = new LeftRightInsert2<>();
			list.add("uno");
			list.add("dos");
			list.add("tres");
			list.add("cuatro");
			list.add("cinco");
			list.add("seis");
			list.add("siete");
			list.add("ocho");
			list.add("nueve");
			list.add("diez");

//			System.out.println(list.toString());
//			for (Iterator<String> it = list.iterator(); it.hasNext();)
//				System.out.println(it.next());
		} catch (Exception ex) {
			Logger.getLogger(UnitTests.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
		}

	}

	@Test
	public void testLRI1() {
		for (int i = 0; i < 6; i++) {
			LeftRightInsert<Integer> lri = new LeftRightInsert<>();
			for (int j = 0; j < i; j++) {
				lri.add(j);
			}
			Iterator<Integer> it = lri.iterator();
			for (int j = 0; j < i; j++) {
				assertEquals(j, it.next().intValue());
			}
		}
	}
	
	@Test
	public void testLRI2() {
		for (int i = 0; i < 6; i++) {
			LeftRightInsert2<Integer> lri = new LeftRightInsert2<>();
			for (int j = 0; j < i; j++) {
				lri.add(j);
			}
			Iterator<Integer> it = lri.iterator();
			for (int j = 0; j < i; j++) {
				assertEquals(j, it.next().intValue());
			}
		}
	}
	
	@Test
	public void testJSMCI1() {
		for (int i = 0; i < 6; i++) {
			LeftRightInsertJSMC<Integer> lri = new LeftRightInsertJSMC<>();
			for (int j = 0; j < i; j++) {
				lri.add(j);
			}
			Iterator<Integer> it = lri.iterator();
			for (int j = 0; j < i; j++) {
				assertEquals(j, it.next().intValue());
			}
		}
	}
	
	@Test
	public void testJSMCI2() {
		for (int i = 0; i < 6; i++) {
			LeftRightInsertJSMC2<Integer> lri = new LeftRightInsertJSMC2<>();
			for (int j = 0; j < i; j++) {
				lri.add(j);
			}
			Iterator<Integer> it = lri.iterator();
			for (int j = 0; j < i; j++) {
				assertEquals(j, it.next().intValue());
			}
		}
	}

}
