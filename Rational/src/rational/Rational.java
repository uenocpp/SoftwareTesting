package rational;

public class Rational {
	private long num;
	private long den;
	public long getNum() {
		return num;
	}
	private void setNum(long num) {
		this.num = num;
	}
	public long getDen() {
		return den;
	}
	private void setDen(long den) {
		this.den = den;
	}
	Rational( long num, long den){
		setNum(num);
		setDen(den);
		reduceAndNormalize();
	}
	Rational( long num ){
		setNum(num);
		setDen(1);
	}
	Rational(){
		setNum(0);
		setDen(1);
	}
	private void reduceAndNormalize() {
		reduce();
		normalize();
	}
	private void reduce() {
		long d = gcd(getNum(),getDen());
		setNum(getNum()/d);
		setNum(getDen()/d);
	}
	private long gcd(long a, long b) {
		if(b==0){
			if( a < 0 ){
				return a * -1;
			}
			return a;
		}
		return gcd(b,a%b);
	}
	private void normalize() {
		if( this.den < 0 ){
			setNum(getNum()*-1);
			setDen(getDen()*-1);
		}
	}
	
	@Override
	public boolean equals( Object o ){
		try{
			Rational r = (Rational)o;
			if( r.getNum() == getNum() && r.getDen() == getDen() ){
				return true;
			}
		}catch(ClassCastException e ){}
		return false;
	}
	
	@Override
	public Object clone(){
		return new Rational( getNum(), getDen() );
	}
	
	private boolean isNegative(){
		return getNum() * getDen() < 0;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer();
		buf.append(isNegative()?"-":"");
		buf.append(Math.abs(getNum()));
		buf.append("/");
		buf.append(getDen());
		return buf.toString();
	}
	
	public static Rational arrayReader( long[] array ){
		if( array.length == 0 ){
			return null;
		} else if( array.length == 1 ){
			return new Rational( array[0] );
		} else if( array[1] == 0 ){
			return null;
		}
		return new Rational( array[0], array[1] );
	}
	
	public Rational add( Rational r ){
		long array[] = { getNum()*r.getDen() + getDen()*r.getNum(), getDen()*r.getDen()};
		return arrayReader( array );
	}
	
	private Rational reverse(){
		long array[] = { -getNum(), getDen() };
		return arrayReader( array );
	}
	
	public Rational subtract( Rational r ){
		return add( r.reverse() );
	}
	
	public Rational inverse(){
		if( getNum() == 0 ){ return null;}
		long array[] = { getDen(), getNum() };
		return arrayReader( array );
	}
}
