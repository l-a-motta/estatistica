public class Ex01 {

	public static void main(String[] args) 
	{
		double x, x0, xi, xi1;
		System.out.println("Valor de x: ");
		x = EntradaTeclado.leDouble();
		System.out.println("Chute: ");
		x0 = EntradaTeclado.leDouble();
		
		xi1 = x0;
		xi = (xi1 + x/xi1) / 2;
		//System.out.printf("Xi: %f\n", xi);
		//System.out.printf("Xi-1: %f\n", xi1);
		do
		{
			//System.out.println("Iteração -");
			xi1 = xi;
			xi = (xi1 + x/xi1) / 2;
			//System.out.printf("Xi: %f\n", xi);
			//System.out.printf("Xi-1: %f\n", xi1);
			//System.out.printf("Diferença: %.9f", xi - xi1);
		} while(Math.abs((xi - xi1)) >= 0.00000001);
		
		System.out.printf("Chute aprimorado: %.9f\n", xi);
		System.out.printf("Valor da raiz: %.9f", Math.sqrt(x));

	}

}
