package com.synchronoss.storage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//**********************************Test Instruction*********************************
//
//Please use the TestSuite file for running all test cases.

public class StorageAPIFoundationTest {

	protected static final byte[] BYTES = "value".getBytes();
	protected static final String KEY = "key";
	protected StorageAPI storage;

	@Before
	public void setup() {
		storage = new StorageImplementation();
	}

	@After
	public void tearDown() {
		storage = null;
	}

	// *******************************Put Test Cases*********************//

	@Test
	public void testPutKeyInStorage() throws Exception {
		storage.put(KEY, BYTES);
		assertNotNull(storage.get(KEY));
		assertTrue("Key's value is not matched", Arrays.equals(storage.get(KEY), BYTES));
	}
	
	

	@Test(expected = IllegalArgumentException.class)
	public void testPutValueAsNull() throws Exception {
		storage.put("test", null);
	}

	@Test
	public void testPutEmptyKeyValueInStorage() throws Exception {
		storage.put("", "".getBytes());
		assertEquals("Empty key & Empty value are not accepted",1, storage.count());

	}

	// *******************************GET Test Cases*********************//

	@Test
	public void testKeyNotPresent() {
		assertNull("Key is Present", storage.get("Pankaj"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testKeyIsNull() {
		storage.get(null);
	}

	// *******************************DELETE Test Cases*********************//

	@Test
	public void testDeleteValidKey() throws Exception {
		String KEY1 = "aike";
		byte[] BYTE1 = "Ross".getBytes();
		storage.put(KEY1, BYTE1);
		assertTrue("Key and value are not stored",Arrays.equals(storage.get(KEY1), BYTE1));
		assertTrue("Value is not deleted for the input key",storage.delete(KEY1));
		assertNull("Key-value are not deleted",storage.get(KEY1));

	}

	@Test
	public void testDeleteInvalidKey() throws Exception {
		String KEY1 = "zone";
		byte[] BYTE1 = "dublin".getBytes();
		storage.put(KEY1, BYTE1);
		assertTrue(Arrays.equals(storage.get(KEY1), BYTE1));
		assertFalse("Invalid key present",storage.delete("enoz"));

	}

	@Test
	public void testDeleteNullKey() throws Exception {
		String KEY1 = "frog";
		byte[] BYTE1 = "jack".getBytes();
		storage.put(KEY1, BYTE1);
		assertTrue(Arrays.equals(storage.get(KEY1), BYTE1));
		assertFalse(storage.delete(null));
	}

	// *******************************Count Test Cases*********************//

	@Test
	public void testNullSize() {
		assertEquals("Map is not empty",0, storage.count());
	}

	@Test
	public void testSize() throws Exception {
		String KEY1 = "zone";
		byte[] BYTE1 = "dublin".getBytes();
		storage.put(KEY1, BYTE1);
		assertEquals("Map size is wrong",1, storage.count());
	}

}
