/*
 * $Id: Test.java,v 1.1 2006/04/15 14:40:06 platform Exp $
 * Created on 2006-4-15
 */
package org.json.simple;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.json.simple.parser.Yytoken;
import org.junit.Test;

public class TestJson {

	@Test
	public void testDecode() throws Exception{
		System.out.println("=======decode=======");

		String s="[0,10]";
		Object obj=JSONValue.parse(s);
		JSONArray array=(JSONArray)obj;
		System.out.println("======the 2nd element of array======");
		System.out.println(array.get(1));
		System.out.println();
		assertEquals("10",array.get(1).toString());
	}

	@Test
	public void testJSONArrayCollection() {
		final ArrayList<String> testList = new ArrayList<String>();
		testList.add("First item");
		testList.add("Second item");
		final JSONArray jsonArray = new JSONArray(testList);

		assertEquals("[\"First item\",\"Second item\"]", jsonArray.toJSONString());
	}
	@Test
	public void testJSONArrayBooleanToString() {
		final boolean[] testArray = new boolean[]{true, false, true};
		final JSONArray jsonArray = new JSONArray(Collections.singleton(testArray));
		assertEquals("[[true,false,true]]", jsonArray.toJSONString());
	}

	@Test
	public void testJSONObjectWithNestedObjects() {
		final JSONObject innerObject1 = new JSONObject();
		innerObject1.put("key1", "value1");
		innerObject1.put("key2", "value2");

		final JSONObject innerObject2 = new JSONObject();
		innerObject2.put("key3", "value3");
		innerObject2.put("key4", "value4");

		final JSONObject outerObject = new JSONObject();
		outerObject.put("innerObject1", innerObject1);
		outerObject.put("innerObject2", innerObject2);

		assertEquals("{\"innerObject1\":{\"key1\":\"value1\",\"key2\":\"value2\"},\"innerObject2\":{\"key3\":\"value3\",\"key4\":\"value4\"}}", outerObject.toJSONString());
	}

	@Test
	public void testJSONArrayToStringWithNullValues() {
		final JSONArray jsonArray = new JSONArray();
		jsonArray.add(null);
		jsonArray.add("value");
		jsonArray.add(null);
		assertEquals("[null,\"value\",null]", jsonArray.toString());
	}

	@Test
	public void testJSONObjectWithNullValues() {
		final JSONObject jsonObject = new JSONObject();
		jsonObject.put("key1", null);
		jsonObject.put("key2", "value2");
		jsonObject.put("key3", null);
		assertEquals("{\"key1\":null,\"key2\":\"value2\",\"key3\":null}", jsonObject.toJSONString());
	}


	@Test
	public void testJSONArrayWithMixedTypes() {
		final JSONArray jsonArray = new JSONArray();
		jsonArray.add("string");
		jsonArray.add(10);
		jsonArray.add(true);
		jsonArray.add(2.5);
		assertEquals("[\"string\",10,true,2.5]", jsonArray.toJSONString());
	}



}
