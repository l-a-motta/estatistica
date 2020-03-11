public class Ex08 {

	public static void main(String[] args) 
	{
		// Algoritmo Newton-Raphson encontrado em: https://sites.icmc.usp.br/andretta/ensino/aulas/sme0500-1-14/aula3-newton.pdf
		System.out.println("Polinomio: x³ – x² – 13x + 8");
		System.out.println("Coef.: +1 –1 –13 +8\n");
		System.out.println("Polinomio derivado: 3x² – 2x – 13");
		System.out.println("Coef.: +3 –2 –13\n");
		
		double p0, p, i;
		double TOL = 0.00000001;
		
		System.out.println("Digite seu chute: ");
		p0 = EntradaTeclado.leDouble();
		
		i = 0;
		p = p0 - ( (Math.pow(p0, 3) - Math.pow(p0, 2) - 13 * p0 + 8) / (3 * (Math.pow(p0, 2)) - 2 * p0 - 13) );
		//System.out.printf("Iter %.0f p vale: %f\n", i, p);
		
		while(Math.abs(p - p0) >= TOL || Math.abs(p - p0) / Math.abs(p) >= TOL || Math.abs((Math.pow(p, 3) - Math.pow(p, 2) - 13 * p + 8)) >= TOL)
		{
			p = p0 - ( (Math.pow(p0, 3) - Math.pow(p0, 2) - 13 * p0 + 8) / (3 * (Math.pow(p0, 2)) - 2 * p0 - 13) );
			i++;
			p0 = p;
			//System.out.printf("Iter %.0f p vale: %.9f\n", i, p);
		}
		System.out.printf("Resultado: %.10f\n", p);
		System.out.printf("Iterações: %.0f", i);
	}

}
