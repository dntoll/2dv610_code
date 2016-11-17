package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleWrapper {
	
	BufferedReader b;
	ConsoleWrapper() {
		b=new BufferedReader(new InputStreamReader(System.in));
	}
	
	public String readLine() throws IOException {
		return b.readLine();
	}

	public void writeLine(String string) {
		System.out.println(string);
	}

}
