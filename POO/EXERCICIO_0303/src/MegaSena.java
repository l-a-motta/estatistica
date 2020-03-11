
public class MegaSena {

	public static void main(String[] args) {
		
		// MegaSena
		/*Random r = new Random();
		
		for(int i = 0; i < 6; i++)
		{
			int rand = r.getIntRand(60) + 1;
			System.out.printf("MegaSena %do.: %d\n", i+1, rand);
		}*/
		
		// MegaSena dinamica com resultados diferentes a cada semente inputada - PRECISA Xi PUBLICO
		/*Random r = new Random();
		System.out.printf("Digite uma semente: ");
		int semente = EntradaTeclado.leInt();
		r.xi = semente;
		
		for(int i = 0; i < 6; i++)
		{
			int rand = r.getIntRand(60) + 1;
			System.out.printf("MegaSena %do.: %d\n", i+1, rand);
		}*/
		
		// MegaSena dinamica com get e set
		Random r = new Random();
		System.out.printf("Digite uma semente: ");
		int semente = EntradaTeclado.leInt();
		
		r.setXi(semente);
		
		for(int i = 0; i < 6; i++)
		{
			int rand = r.getIntRand(60) + 1;
			System.out.printf("MegaSena %do.: %d\n", i+1, rand);
		}
	}

}
