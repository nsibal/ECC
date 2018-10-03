/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package src;

import java.math.*;
import java.util.*;

public class ECC {
	
	// Parts of one ECC system.
	private EllipticCurve curve;
	public static Point generator;
	public static Point publicKey;
	public static BigInteger privateKey;
	public static String algorithm = "Blowfish";
	// We need a curve, a generator point (x,y) and a private key, nA, that will
	// be used to generate the public key.
	public ECC(EllipticCurve c, BigInteger x, BigInteger y, BigInteger nA) {
		
		curve = c;
		generator = new Point(curve, x, y);
		privateKey = nA;
		publicKey = generator.multiply(privateKey);
	}
	
	// Encryption.
	public Point[] encrypt(Point plain) {
		
		// First we must pick a random k, in range.
		int bits = curve.getP().bitLength();
		BigInteger k = new BigInteger(bits, new Random());
		System.out.println("Picked "+k+" as k for encrypting.");
		
		// Our output is an ordered pair, (k*generator, plain + k*publickey)
		Point[] ans = new Point[2];
		ans[0] = generator.multiply(k);
		ans[1] = plain.add(publicKey.multiply(k));
		return ans;
	}
	
	// Decryption - notice the similarity to El Gamal!!!
	public Point decrypt(Point[] cipher) {
		
		// This is what we subtract out.
		Point sub = cipher[0].multiply(privateKey);
		
		// Subtract out and return.
		return cipher[1].subtract(sub);
	}
	
	public String toString() {
		
		return "Gen: "+generator+"\n"+
			   "pri: "+privateKey+"\n"+
			   "pub: "+publicKey;
	}
	
	public static void main(String[] args) {
		
		
		// Just use the book's curve and test.
		EllipticCurve myCurve = new EllipticCurve(new BigInteger("23"), new BigInteger("1"), new BigInteger("1"));
		BigInteger x = new BigInteger("6");
		BigInteger y = new BigInteger("19");
		BigInteger nA = new BigInteger("10");
		ECC Alice = new ECC(myCurve, x, y, nA);
		
		// I have hard-coded my plaintext point.
		Point plain = new Point(myCurve, new BigInteger("3"), new BigInteger("13"));
		System.out.println("encrypting "+plain);
		
		// Encrypt and print.
		Point[] cipher = Alice.encrypt(plain);
		System.out.println("cipher first part "+cipher[0]);
		System.out.println("cipher second part "+cipher[1]);
		System.out.println("Public Key :"+publicKey);
                System.out.println("Private Key :"+privateKey);
                
                
		// Decrypt and verify.
		Point recover = Alice.decrypt(cipher);
		System.out.println("recovered "+recover);
		
	}
}