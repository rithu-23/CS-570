//Rethick Arun
//CS 570 B
//HW 1 
//Stevens ID - 20035348
import java.util.Arrays;

public class BinaryNumber {
    private int[] data;
    private boolean overflow = false;

// Constructor given integer length, filled with 0s
    public BinaryNumber(int length) {
    	if (length == (int)length) {
    	data = new int[length];
        Arrays.fill(data, 0);
    	}
    	else {
    		throw new ArithmeticException("Given size of binary number is not of type integer");
    	}
    	}

// Constructor given string input
    public BinaryNumber(String str) {
        data = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
        	data[i] = Character.getNumericValue(str.charAt(i));
        }
        for (int i = 0; i < str.length(); i++) {
            if (data[i] != 1 && data[i] != 0) {
            	throw new ArithmeticException("Input is not binary"); 
        		
        	}
        }
        	
    }

// Get Length of the binary number
    public int getLength() {
        return data.length;
    }

// Get Digit at specific index
    public int getDigit(int index) {
        if (index < 0 || index >= data.length) {
            throw new ArithmeticException("Index out of bounds.");
        } else {
            return data[index];
        }
    }

// Shift the number to right by given digits and add 0
    public void shiftR(int amount) {
        if (amount <= 0) {
        	throw new ArithmeticException("Shift value needs to be positive");
        }

        int[] copyOfArray = new int[data.length + amount];
        Arrays.fill(copyOfArray, 0); 
        for (int i = 0; i < data.length; i++) {
        	copyOfArray[i + amount] = data[i];
        	
        }
        data = copyOfArray;
    }

// Add two binary numbers
    public void add(BinaryNumber aBinaryNumber) {
        if (this.getLength() != aBinaryNumber.getLength()) {
            throw new ArithmeticException("The binary numbers have different lengths, please change input.");
        }

        int carry = 0;
        int[] result = new int[data.length];
        
        
        for (int i = 0; i < data.length; i++) {
            int sum = data[i] + aBinaryNumber.data[i] + carry;
            result[i] = sum % 2;  
            carry = sum / 2;      
        }

       if (carry == 1) {
            overflow = true;
            int[] extendedResult = new int[data.length + 1];
            System.arraycopy(result, 0, extendedResult, 0, result.length);
            extendedResult[data.length] = 1;  
            data = extendedResult;
        } else {
            overflow = false;
            data = result;
        }
       clearOverflow();
    }

//Method too convert the binary number to string
    public String toString() {
        StringBuilder binaryString = new StringBuilder();
        for (int digit : data) {
            binaryString.append(digit);
        }
        return binaryString.toString();
    }
    
//Method to convert binary number to decimal
    public int toDecimal() {
        int decimalValue = 0;
        for (int i = 0; i < data.length; i++) {
            decimalValue += data[data.length - i - 1] * Math.pow(2, i);
        }
        return decimalValue;
    }

//Method to clear the overflow flag
    public void clearOverflow() {
    	if (overflow) {
    		throw new ArithmeticException("Overflow");
    	}
        overflow = false;
    }

    public static void main(String[] args) {
    	BinaryNumber binary1 = new BinaryNumber("1010");  
    	BinaryNumber binary2 = new BinaryNumber(4); 
        System.out.println("First Binary Number : " + binary1.toString()); //Expected Result - 1010
        System.out.println("Second Binary Number : " + binary2.toString());//Expected Result - 0000
        System.out.println("Length of Binary Number 1 : " + binary1.getLength());//Expected Result - 4
        System.out.println("Get Digit at Index 1 from Binary Number 1 : " + binary1.getDigit(1));//Expected Result - 0
        binary1.shiftR(3);
        System.out.println("Shift First Binary number by 3 places : " + binary1.toString());//Expected Result - 0001010
        BinaryNumber binary3 = new BinaryNumber("0100");
        BinaryNumber binary4 = new BinaryNumber("1000");
        binary3.add(binary4);
        System.out.println("Result of Binary Addition : " + binary3.toString());//Expected Result - 1100
        System.out.println("Binary Addition Result to Decimal : " + binary3.toDecimal());//Expected Result - 12
    }
}
//Rethick Arun
