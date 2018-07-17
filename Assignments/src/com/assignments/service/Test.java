package com.assignments.service;

public class Test {

	public static void main(String[] args) {
		String str = "\"Reference,AccountNumber,Description,Start Balance,Mutation,End Balance\n194261,NL91RABO0315273637,Clothes from Jan Bakker,21.6,-41.83,-20.23\n112806,NL27SNSB0917829871,Clothes for Willem Dekker,91.23,+15.57,106.8\n183049,NL69ABNA0433647324,Clothes for Jan King,86.66,+44.5,131.16\n183356,NL74ABNA0248990274,Subscription for Peter de Vries,92.98,-46.65,46.33\n112806,NL69ABNA0433647324,Clothes for Richard de Vries,90.83,-10.91,79.92\n112806,NL93ABNA0585619023,Tickets from Richard Bakker,102.12,+45.87,147.99\n139524,NL43AEGO0773393871,Flowers from Jan Bakker,99.44,+41.23,140.67\n179430,NL93ABNA0585619023,Clothes for Vincent Bakker,23.96,-27.43,-3.47\n141223,NL93ABNA0585619023,Clothes from Erik Bakker,94.25,+41.6,135.85\n195446,NL74ABNA0248990274,Flowers for Willem Dekker,26.32,+48.98,75.3\n\"";
		String[] lines = str.split("\n");
		System.out.println("lines.length=====>"+lines.length);
		
		for(int i=0;i<lines.length;i++) {
			System.out.println("line=====>"+lines[i]);
		}
	}

}
