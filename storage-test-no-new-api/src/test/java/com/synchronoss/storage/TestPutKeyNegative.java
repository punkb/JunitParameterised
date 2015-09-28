package com.synchronoss.storage;

import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
//**********************************Test Instruction*********************************
//
//Please use the TestSuite file for running all test cases.

@RunWith(Parameterized.class)
public class TestPutKeyNegative {

	private String key;
	private byte[] value;
	protected StorageAPI storage;

	public TestPutKeyNegative(String key, byte[] value) 
	{
			        this.key = key;
			        this.value = value;
	}

	@Before
	public void setup() {
		storage = new StorageImplementation();
	}

	@After
	public void tearDown() {
		storage = null;
	}

	@Parameters
	public static Collection keyData() {
		return Arrays.asList(new Object[][] { { "Abc", "test1".getBytes() }, { "aZc", "test2".getBytes() },
				{ "bbC", "test3".getBytes() }, { "bb1", "test4".getBytes() }, { "bb£e", "test".getBytes() }, { "o'raly", "test".getBytes() },{ "12", "test".getBytes() }, { "34", "12".getBytes()},

		});
	}
	
	@Test(expected = Exception.class)
	public void testRegExMatching() throws Exception {
		storage.put(key, value);
	}

}
