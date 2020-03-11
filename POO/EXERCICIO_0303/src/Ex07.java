public class Ex07 {

	public static void main(String[] args)
	{
		// Algoritmo de Bisseção encontrado em: https://sites.icmc.usp.br/andretta/ensino/aulas/sme0301-1-11/Bisseccao.pdf
		
		System.out.println("Polinomio: x³ – x² – 13x + 8");
		
		double a, b, c, i = 0;
		
		System.out.println("Inicio do intervalo:");
		a = EntradaTeclado.leDouble();
		System.out.println("Fim do intervalo:");
		b = EntradaTeclado.leDouble();
		
		System.out.printf("f(x=%.0f) = %.3f\n", a, Math.pow(a, 3) - Math.pow(a, 2) - 13 * a + 8);
		System.out.printf("f(x=%.0f) = %.3f\n", b, Math.pow(b, 3) - Math.pow(b, 2) - 13 * b + 8);
		
		do
		{
			if((Math.pow(a, 3) - Math.pow(a, 2) - 13 * a + 8) * (Math.pow(b, 3) - Math.pow(b, 2) - 13 * b + 8) < 0)
			{
				i++;
				c = (a+b) / 2;
				System.out.printf("#%2.0f - [a, b] = [%.10f, %.10f],\t c = %.10f \t f(c) = %f\n", i, a, b, c, Math.pow(c, 3) - Math.pow(c, 2) - 13 * c + 8);
				
				if((Math.pow(c, 3) - Math.pow(c, 2) - 13 * c + 8) == 0)
				{
					System.out.println("Fim");
				}
				else if((Math.pow(c, 3) - Math.pow(c, 2) - 13 * c + 8) * (Math.pow(a, 3) - Math.pow(a, 2) - 13 * a + 8) < 0)
				{
					b = c;
					System.out.printf("SuB - [a, b] = [%.10f, %.10f],\t c = %.10f \t f(c) = %f\n", a, b, c, Math.pow(c, 3) - Math.pow(c, 2) - 13 * c + 8);
				}
				else if((Math.pow(c, 3) - Math.pow(c, 2) - 13 * c + 8) * (Math.pow(b, 3) - Math.pow(b, 2) - 13 * b + 8) < 0)
				{
					a = c;
					System.out.printf("SuA - [a, b] = [%.10f, %.10f],\t c = %.10f \t f(c) = %f\n", a, b, c, Math.pow(c, 3) - Math.pow(c, 2) - 13 * c + 8);
				}
			}
			else
			{
				System.out.println("Valores para a e b invalidos! Um valor deve resultar na função negativa e outro, positiva");
				break;
			}
		} while(Math.abs(a - b) / 2 >= 0.00000001);
	}

}
