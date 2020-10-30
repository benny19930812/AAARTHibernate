package eeit124.group4._04_Seat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity  //宣告此class為javabean
@Table(name = "SEAT")
public class SeatBean implements Serializable {

	
	@Id //設定primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //primary key的產生方式 有auto、IDENTITY	 
	@Column(name = "ACT_NO")
	private int ACT_NO;
	
	private int A1;
	private int A2;
	private int A3;
	private int A4;
	private int A5;
	private int A6;
	private int A7;
	private int A8;
	private int A9;
	private int A10;
	private int B1;
	private int B2;
	private int B3;
	private int B4;
	private int B5;
	private int B6;
	private int B7;
	private int B8;
	private int B9;
	private int B10;
	private int C1;
	private int C2;
	private int C3;
	private int C4;
	private int C5;
	private int C6;
	private int C7;
	private int C8;
	private int C9;
	private int C10;
	private int D1;
	private int D2;
	private int D3;
	private int D4;
	private int D5;
	private int D6;
	private int D7;
	private int D8;
	private int D9;
	private int D10;
	private int E1;
	private int E2;
	private int E3;
	private int E4;
	private int E5;
	private int E6;
	private int E7;
	private int E8;
	private int E9;
	private int E10;
	public int getACT_NO() {
		return ACT_NO;
	}
	public void setACT_NO(int aCT_NO) {
		ACT_NO = aCT_NO;
	}
	public int getA1() {
		return A1;
	}
	public void setA1(int a1) {
		A1 = a1;
	}
	public int getA2() {
		return A2;
	}
	public void setA2(int a2) {
		A2 = a2;
	}
	public int getA3() {
		return A3;
	}
	public void setA3(int a3) {
		A3 = a3;
	}
	public int getA4() {
		return A4;
	}
	public void setA4(int a4) {
		A4 = a4;
	}
	public int getA5() {
		return A5;
	}
	public void setA5(int a5) {
		A5 = a5;
	}
	public int getA6() {
		return A6;
	}
	public void setA6(int a6) {
		A6 = a6;
	}
	public int getA7() {
		return A7;
	}
	public void setA7(int a7) {
		A7 = a7;
	}
	public int getA8() {
		return A8;
	}
	public void setA8(int a8) {
		A8 = a8;
	}
	public int getA9() {
		return A9;
	}
	public void setA9(int a9) {
		A9 = a9;
	}
	public int getA10() {
		return A10;
	}
	public void setA10(int a10) {
		A10 = a10;
	}
	public int getB1() {
		return B1;
	}
	public void setB1(int b1) {
		B1 = b1;
	}
	public int getB2() {
		return B2;
	}
	public void setB2(int b2) {
		B2 = b2;
	}
	public int getB3() {
		return B3;
	}
	public void setB3(int b3) {
		B3 = b3;
	}
	public int getB4() {
		return B4;
	}
	public void setB4(int b4) {
		B4 = b4;
	}
	public int getB5() {
		return B5;
	}
	public void setB5(int b5) {
		B5 = b5;
	}
	public int getB6() {
		return B6;
	}
	public void setB6(int b6) {
		B6 = b6;
	}
	public int getB7() {
		return B7;
	}
	public void setB7(int b7) {
		B7 = b7;
	}
	public int getB8() {
		return B8;
	}
	public void setB8(int b8) {
		B8 = b8;
	}
	public int getB9() {
		return B9;
	}
	public void setB9(int b9) {
		B9 = b9;
	}
	public int getB10() {
		return B10;
	}
	public void setB10(int b10) {
		B10 = b10;
	}
	public int getC1() {
		return C1;
	}
	public void setC1(int c1) {
		C1 = c1;
	}
	public int getC2() {
		return C2;
	}
	public void setC2(int c2) {
		C2 = c2;
	}
	public int getC3() {
		return C3;
	}
	public void setC3(int c3) {
		C3 = c3;
	}
	public int getC4() {
		return C4;
	}
	public void setC4(int c4) {
		C4 = c4;
	}
	public int getC5() {
		return C5;
	}
	public void setC5(int c5) {
		C5 = c5;
	}
	public int getC6() {
		return C6;
	}
	public void setC6(int c6) {
		C6 = c6;
	}
	public int getC7() {
		return C7;
	}
	public void setC7(int c7) {
		C7 = c7;
	}
	public int getC8() {
		return C8;
	}
	public void setC8(int c8) {
		C8 = c8;
	}
	public int getC9() {
		return C9;
	}
	public void setC9(int c9) {
		C9 = c9;
	}
	public int getC10() {
		return C10;
	}
	public void setC10(int c10) {
		C10 = c10;
	}
	public int getD1() {
		return D1;
	}
	public void setD1(int d1) {
		D1 = d1;
	}
	public int getD2() {
		return D2;
	}
	public void setD2(int d2) {
		D2 = d2;
	}
	public int getD3() {
		return D3;
	}
	public void setD3(int d3) {
		D3 = d3;
	}
	public int getD4() {
		return D4;
	}
	public void setD4(int d4) {
		D4 = d4;
	}
	public int getD5() {
		return D5;
	}
	public void setD5(int d5) {
		D5 = d5;
	}
	public int getD6() {
		return D6;
	}
	public void setD6(int d6) {
		D6 = d6;
	}
	public int getD7() {
		return D7;
	}
	public void setD7(int d7) {
		D7 = d7;
	}
	public int getD8() {
		return D8;
	}
	public void setD8(int d8) {
		D8 = d8;
	}
	public int getD9() {
		return D9;
	}
	public void setD9(int d9) {
		D9 = d9;
	}
	public int getD10() {
		return D10;
	}
	public void setD10(int d10) {
		D10 = d10;
	}
	public int getE1() {
		return E1;
	}
	public void setE1(int e1) {
		E1 = e1;
	}
	public int getE2() {
		return E2;
	}
	public void setE2(int e2) {
		E2 = e2;
	}
	public int getE3() {
		return E3;
	}
	public void setE3(int e3) {
		E3 = e3;
	}
	public int getE4() {
		return E4;
	}
	public void setE4(int e4) {
		E4 = e4;
	}
	public int getE5() {
		return E5;
	}
	public void setE5(int e5) {
		E5 = e5;
	}
	public int getE6() {
		return E6;
	}
	public void setE6(int e6) {
		E6 = e6;
	}
	public int getE7() {
		return E7;
	}
	public void setE7(int e7) {
		E7 = e7;
	}
	public int getE8() {
		return E8;
	}
	public void setE8(int e8) {
		E8 = e8;
	}
	public int getE9() {
		return E9;
	}
	public void setE9(int e9) {
		E9 = e9;
	}
	public int getE10() {
		return E10;
	}
	public void setE10(int e10) {
		E10 = e10;
	}

	



	
	
}
