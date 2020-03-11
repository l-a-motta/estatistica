
public class Random {
	
	// parametros de geracao
	private long p = 2147483648L;
	private long m = 843314861;
	private long a = 453816693;
	
	//public long xi = 1023; // semente estatica e publica para alteracoes
	private long xi = 1023; // semente estatica e privada de alteracoes

	public double getRand() {
		//calcula valor entre 0 e 1, dividindo por p
		xi = (a + m * xi) % p;
		double d = xi; // promove p/ double
		return d/p;
	}
	
	public int getIntRand(int max) {
		double d = getRand() * max;
		return (int) d;
	}
	
	
	public double getXi() {
		return xi;
	}
	
	public void setXi(long xiNovo) {
		this.xi = xiNovo;
	}
	
	public Random()
	{	setXi(System.currentTimeMillis());	}
	
	public Random(int xiNovo)
	{	setXi(xiNovo);	}
}
