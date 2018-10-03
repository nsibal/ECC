/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package src;

import java.math.*;

public class EllipticCurve {
	
	// The parameters of an EC.
	private BigInteger p;
	private BigInteger a;
	private BigInteger b;
	
	public EllipticCurve(BigInteger prime, BigInteger myA, BigInteger myB) {
		p = prime;
		a = myA;
		b = myB;
	}
	
	// Copy constructor.
	public EllipticCurve(EllipticCurve copy) {
		p = new BigInteger(copy.p.toString());
		a = new BigInteger(copy.a.toString());
		b = new BigInteger(copy.b.toString());	
	}
	
	// All three components must be equal for the curves to be the same.
	public boolean equals(EllipticCurve other) {
		return p.equals(other.p) && a.equals(other.a) && b.equals(other.b);
	}
	
	public BigInteger getP() {
		return p;
	}
	
	public BigInteger getA() {
		return a;
	}	
}
