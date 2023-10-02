package com.Practies;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonReadDataTest {

	public static void main(String[] args) throws Throwable {
		JSONParser p= new JSONParser();
		Object obj = p.parse(new FileReader(".\\src\\test\\resources\\jsonData.json.txt"));
		
		JSONObject map= (JSONObject) obj;
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("browse"));
		System.out.println(map.get("url"));

	}

}
