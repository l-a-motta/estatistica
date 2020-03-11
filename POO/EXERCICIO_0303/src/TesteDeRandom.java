
public class TesteDeRandom {

	public static void main(String[] args) {
		Random r1 = new Random();
		Random r2 = new Random();
		
		System.out.printf("Digite uma semente: ");
		int semente1 = EntradaTeclado.leInt();
		System.out.printf("\nDigite outra semente: ");
		int semente2 = EntradaTeclado.leInt();
		
		r1.setXi(semente1);
		r2.setXi(semente2);
		
		int i = 0;
		int rand1;
		int rand2;
		do
		{
			i++;
			rand1 = r1.getIntRand(60) + 1;
			rand2 = r2.getIntRand(60) + 1;
			System.out.printf("Iter #%d - Rand1: %d\tRand2: %d\n", i, rand1, rand2);
		} while (rand1 != rand2);
		
		System.out.printf("Iteracoes necessarias para igualar: %d", i);
	}

}
