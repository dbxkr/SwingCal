package fsd;

import java.util.*;

//import java.awt.*;

public class tt {
	public static void main(String[] args) {
		String str = "10+((234*113)*7)+(3+32*(8)*6)/112+37";
		System.out.println(Equation.eq(str));
		System.out.println(10+((234*113.0)*7)+(3+32*(8)*6)/112.0+37);
		
	}
}
