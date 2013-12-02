package mytest;

import static org.junit.Assert.*;


import org.junit.Test;

public class RationalTest {

	public boolean compareWithOracle( mytest.Rational r1, rational.Rational r2 ){
		int null_counter = 0;
		if( r1 == null ) null_counter++;
		if( r2 == null ) null_counter++;
		if( null_counter == 2 ) return true;
		if( null_counter == 1 ) return false;
		assert( r1 != null && r2 != null );
		return r1.toString().equals(r2.toString());
	}
	
	long mlTestCaseSet[][] = {
		{ 1, 1 },
		{ 2, 4 },
		{ 15, 21 },
		{ 1, -2 },
		{ -1, 2 },
		{ 3, 1 },
		{ 5, 2 },
		{ -1, -1 },
		{ -2, 4 },
		{ 0, 1 },
		{ 0, 4 },
		{ 0, -2 },
	};
	
	long mlTestCaseSetNull[][] = {
			{ 1, 0 },
			{ 15, 0 },
			{ -1, 0 },
			{ -2, 0 },
			{ 0, 0 },	
	};
	
	long mlTestCaseSetSingle[][] = {
			{ 1 },
			{ 15 },
			{ -1 },
			{ -2 },
			{ 0 },	
	};
	
	long mlTestCaseSetTriple[][] = {
			{ 1, 1, 0},
			{ 2, 4, 3 },
			{ 15, 21, 45 },
			{ 1, -2, -2 },
			{ 0, 1, 505, 32 },
			{ 0, 4, 2, 215, 5952 },
			{ 0, -2, 0 },
			{ 1, 0, 1 },
			{ 15, 0, 1 },
			{ -1, 0, 991 },
			{ -2, 0, 31 },
			{ 0, 0, 0 },
		};
	
	@Test
	public void testEqualsObject() {
		for( final long[] l : mlTestCaseSet ){
			mytest.Rational r1 = mytest.Rational.arrayReader(l);
			mytest.Rational r2 = mytest.Rational.arrayReader(l);
			assertEquals( r1, r2 );
		}
	}

	@Test
	public void testClone() {
		for( final long[] l : mlTestCaseSet ){
			mytest.Rational r1 = mytest.Rational.arrayReader(l);
			assertEquals( r1, r1.clone() );
		}
	}

	@Test
	public void testToString() {
		assertEquals( new Rational(1,2).toString(), "1/2" );
		assertEquals( new Rational(4,1).toString(), "4" );
		assertEquals( new Rational(-7,9).toString(), "-7/9" );
		assertEquals( new Rational(-1,1).toString(), "-1" );
	}

	@Test
	public void testArrayReader() {
		for( final long[] l : mlTestCaseSet ){
			mytest.Rational r1 = mytest.Rational.arrayReader(l);
			rational.Rational r2 = rational.Rational.arrayReader(l);
			assertTrue( "long[]:" + l[0] + "," + l[1], compareWithOracle( r1, r2 ));
		}

		for( final long[] l : mlTestCaseSetNull ){
			mytest.Rational r1 = mytest.Rational.arrayReader(l);
			rational.Rational r2 = rational.Rational.arrayReader(l);
			assertEquals( r1, null );
			assertTrue( "long[]:" + l[0] + "," + l[1], compareWithOracle( r1, r2 )); // 念のため
		}
		
		for( final long[] l : mlTestCaseSetSingle ){
			mytest.Rational r1 = mytest.Rational.arrayReader(l);
			rational.Rational r2 = rational.Rational.arrayReader(l);
			assertTrue( "long[]:" + l[0] , compareWithOracle( r1, r2 ));
		}
		
		//要素が３以上のときに３つ目以降が無視されるか
		for( final long[] l : mlTestCaseSetTriple ){
			mytest.Rational r1 = mytest.Rational.arrayReader(l);
			rational.Rational r2 = rational.Rational.arrayReader(l);
			assertTrue( "long[]:" + l[0] , compareWithOracle( r1, r2 ));
		}
	}

	@Test
	public void testAdd() {
		for( final long[] l : mlTestCaseSet ){
			mytest.Rational r1 = mytest.Rational.arrayReader(l);
			rational.Rational r2 = rational.Rational.arrayReader(l);
			for( final long[] l2 : mlTestCaseSet ){
				mytest.Rational r3 = mytest.Rational.arrayReader(l2);
				rational.Rational r4 = rational.Rational.arrayReader(l2);
				assertTrue( "long[]:" + l[0] + "," + l[1], compareWithOracle( r1.add(r3), r2.add(r4) ));
			}
		}
	}

	@Test
	public void testSubtract() {
		for( final long[] l : mlTestCaseSet ){
			mytest.Rational r1 = mytest.Rational.arrayReader(l);
			rational.Rational r2 = rational.Rational.arrayReader(l);
			for( final long[] l2 : mlTestCaseSet ){
				mytest.Rational r3 = mytest.Rational.arrayReader(l2);
				rational.Rational r4 = rational.Rational.arrayReader(l2);
				assertTrue( "long[]:" + l[0] + "," + l[1], compareWithOracle( r1.subtract(r3), r2.subtract(r4) ));
			}
		}
	}
	
	@Test
	public void testMultiply(){
		for( final long[] l : mlTestCaseSet ){
			mytest.Rational r1 = mytest.Rational.arrayReader(l);
			rational.Rational r2 = rational.Rational.arrayReader(l);
			for( final long[] l2 : mlTestCaseSet ){
				mytest.Rational r3 = mytest.Rational.arrayReader(l2);
				rational.Rational r4 = rational.Rational.arrayReader(l2);
				assertTrue( "long[]:" + l[0] + "," + l[1], compareWithOracle( r1.multiply(r3), r2.multiply(r4) ));
			}
		}
	}
	
	@Test
	public void testDivide(){
		for( final long[] l : mlTestCaseSet ){
			mytest.Rational r1 = mytest.Rational.arrayReader(l);
			rational.Rational r2 = rational.Rational.arrayReader(l);
			for( final long[] l2 : mlTestCaseSet ){
				mytest.Rational r3 = mytest.Rational.arrayReader(l2);
				rational.Rational r4 = rational.Rational.arrayReader(l2);
				assertTrue( "long[]:" + l[0] + "," + l[1], compareWithOracle( r1.divide(r3), r2.divide(r4) ));
			}
		}
	}

	@Test
	public void testInverse() {
		for( final long[] l : mlTestCaseSet ){
			mytest.Rational r1 = mytest.Rational.arrayReader(l);
			rational.Rational r2 = rational.Rational.arrayReader(l);
			assertTrue( "long[]:" + l[0] + "," + l[1], compareWithOracle( r1.inverse(), r2.inverse() ));
		}
	}

	@Test
	public void testPower() {
		/*
		for( final long[] l : mlTestCaseSet ){
			mytest.Rational r1 = mytest.Rational.arrayReader(l);
			rational.Rational r2 = rational.Rational.arrayReader(l);
			for( int i = -3; i < 4; i++ ){
				//assertTrue( r1.power(i)+":"+r2.power(i) , compareWithOracle( r1.power(i), r2.power(i) ));
				//Baliの方にバグがあるため、このテストは失敗する。
			}
		}
		*/
	}

	@Test
	public void testGreterThan() {
		for( final long[] l : mlTestCaseSet ){
			mytest.Rational r1 = mytest.Rational.arrayReader(l);
			rational.Rational r2 = rational.Rational.arrayReader(l);
			for( final long[] l2 : mlTestCaseSet ){
				mytest.Rational r3 = mytest.Rational.arrayReader(l2);
				rational.Rational r4 = rational.Rational.arrayReader(l2);
				assertEquals( r1.greaterThan(r3), r2.greaterThan(r4) );
			}
		}
	}

	@Test
	public void testLessThan() {
		for( final long[] l : mlTestCaseSet ){
			mytest.Rational r1 = mytest.Rational.arrayReader(l);
			rational.Rational r2 = rational.Rational.arrayReader(l);
			for( final long[] l2 : mlTestCaseSet ){
				mytest.Rational r3 = mytest.Rational.arrayReader(l2);
				rational.Rational r4 = rational.Rational.arrayReader(l2);
				assertEquals( r1.lessThan(r3), r2.lessThan(r4) );
			}
		}
	}

}
