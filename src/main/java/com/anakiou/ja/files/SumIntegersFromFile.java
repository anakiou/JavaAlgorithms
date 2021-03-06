package com.anakiou.ja.files;

import java.io.BufferedReader;
import java.io.FileReader;

public class SumIntegersFromFile {

	public static void sumFile(String name) {
		try {
			int total = 0;
			BufferedReader in = new BufferedReader(new FileReader(name));
			for (String s = in.readLine(); s != null; s = in.readLine()) {
				total += Integer.parseInt(s);
			}
			System.out.println(total);
			in.close();
		} catch (Exception xc) {
			xc.printStackTrace();
		}
	}

}
