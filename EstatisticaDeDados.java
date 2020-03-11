import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Este programa foi desenhado para facilitar o calculo de dados
 * para o Laboratorio de Fisica, para criar um relatorio mais rapidamente
 * Basta inserir suas medidas e ver seus resultados 
 * @author lamotta com modificacoes feitas nas funcoes de leitura
 * de inputs de @author delamaro
 *
 */

public class EstatisticaDeDados 
{
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);
	
	public static String leString() {
		while (true)
		try
		{
			String x;
			x = br.readLine();
			return x;
		}
		catch (Exception e)
		{
			System.out.println("O valor digitado deve ser STRING!\n");
		}
		

	}
	
	public static int leInt() {
		while (true)
		try
		{
			String x = leString();
			return Integer.parseInt(x);
		}
		catch (Exception e)
		{
			System.out.println("O valor digitado deve ser INT!\n");
		}
	}
	
	public static double leDouble() {
		while (true)
		try
		{
			String x = leString();
			return Double.parseDouble(x);
		}
		catch (Exception e)
		{
			System.out.println("O valor digitado deve ser DOUBLE!\n");
		}
	}

	public static void main(String[] args) 
	{
		
		System.out.printf("Quantas medidas serao feitas?: ");
		int n = leInt();
		
		double[] medidas = new double[n];
		double[] xiMenosX = new double[n];
		double[] xiMenosXQuadrado = new double[n];
		
		System.out.printf("Qual o erro minimo das medidas (ex.: 0.05 mm para o paquimetro)?: ");
		double erroInicial = leDouble();
		
		/*	LEITURA DAS MEDIDAS FEITAS PELO USUARIO	*/
		for(int i = 0; i < n; i++)
		{
			System.out.printf("\nMedida %d/%d: ", i+1, n);
			medidas[i] = EntradaTeclado.leDouble();
		}
		System.out.printf("\nMedidas e seus erros iniciais: ");
		for(int i = 0; i < n; i++)
		{
			System.out.printf("\n%d/%d: \t%.12f \t +- %.12f", i+1, n, medidas[i], erroInicial);
		}
		
		/*	CALCULO DO VALOR MEDIO	*/
		double xMed = 0;
		for(int i = 0; i < n; i++)
		{
			xMed += medidas[i];
		}
		xMed = xMed / n;
		System.out.printf("\n\nxMed: \t%.12f", xMed);
		
		/*	ESTATISTICAS MAIS DETALHADAS DO PROCESSO DO CALCULO DE DESVIO	*/
		for(int i = 0; i < n; i++)
		{
			xiMenosX[i] = Math.abs(medidas[i] - xMed);
		}
		for(int i = 0; i < n; i++)
		{
			xiMenosXQuadrado[i] = Math.pow((medidas[i] - xMed), 2);
		}
		
		/*	CALCULO DO DESVIO MEDIO	*/
		double desvioMedio = 0;
		for(int i = 0; i < n; i++)
		{
			desvioMedio += Math.abs(medidas[i] - xMed);
		}
		desvioMedio = desvioMedio / n;
		
		if(desvioMedio < erroInicial)
			desvioMedio = erroInicial;
		
		System.out.printf("\nΔx: \t%.12f", desvioMedio);
		
		/*	CALCULO DO DESVIO PADRAO	*/
		double desvioPadrao = 0;
		for(int i = 0; i < n; i++)
		{
			desvioPadrao += Math.pow((medidas[i] - xMed), 2);
		}
		desvioPadrao = desvioPadrao / (n-1);
		desvioPadrao = Math.sqrt(desvioPadrao);
		
		if(desvioPadrao < erroInicial)
			desvioPadrao = erroInicial;
		
		System.out.printf("\nσ: \t%.12f", desvioPadrao);
		
		/*	RESULTADOS FINAIS	*/
		System.out.printf("\n\nMedidas e seus erros finais: ");
		for(int i = 0; i < n; i++)
		{
			System.out.printf("\n%d/%d: \t%.12f \t +- %.12f medio\t+- %.12f padrao     |     (x[%d] - xMed) = %.12f\t (x[%d] - xMed)^2 = %.12f", i+1, n, medidas[i], desvioMedio, desvioPadrao, i, xiMenosX[i], i, xiMenosXQuadrado[i]);
		}
		System.out.printf("\n\nRESULTADO Δ: %.12f +- %.12f", xMed, desvioMedio);
		System.out.printf("\n\nRESULTADO σ: %.12f +- %.12f", xMed, desvioPadrao);
	}

}
