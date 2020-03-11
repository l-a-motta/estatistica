import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Este programa foi desenhado para facilitar o calculo de dados
 * para o Laboratorio de Fisica, para criar um relatorio mais rapidamente
 * Basta inserir suas medidas e ver seus resultados 
 * @author lamotta com as funcoes de leitura do input do usuario de 
 * @author delamaro alteradas por mim
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
		String novo = "s";
		double desvioPadrao = 0;
		double desvioMedio = 0;
		double erroInicial = 1;
		double xMed = 0;
		int n = 1;
		do
		{
			System.out.printf("\n\nQuantas medidas serao feitas?: ");
			n = leInt();
			
			double[] medidas = new double[n];
			double[] xiMenosX = new double[n];
			double[] xiMenosXQuadrado = new double[n];
			
			System.out.printf("Qual o erro minimo das medidas (ex.: 0.05 mm para o paquimetro)?: ");
			erroInicial = leDouble();
			
			/*	LEITURA DAS MEDIDAS FEITAS PELO USUARIO	*/
			for(int i = 0; i < n; i++)
			{
				System.out.printf("\nMedida %d/%d: ", i+1, n);
				medidas[i] = EntradaTeclado.leDouble();
			}
			System.out.printf("\nMedidas e seus erros iniciais: ");
			for(int i = 0; i < n; i++)
			{
				System.out.printf("\n%d/%d: \t%3.12f \t +- %3.12f", i+1, n, medidas[i], erroInicial);
			}
			
			/*	CALCULO DO VALOR MEDIO	*/
			xMed = 0;
			for(int i = 0; i < n; i++)
			{
				xMed += medidas[i];
			}
			xMed = xMed / n;
			System.out.printf("\n\nxMed: \t%3.12f", xMed);
			
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
			desvioMedio = 0;
			for(int i = 0; i < n; i++)
			{
				desvioMedio += Math.abs(medidas[i] - xMed);
			}
			desvioMedio = desvioMedio / n;
			
			if(desvioMedio < erroInicial)
				desvioMedio = erroInicial;
			
			System.out.printf("\nΔx: \t%3.12f", desvioMedio);
			
			/*	CALCULO DO DESVIO PADRAO	*/
			desvioPadrao = 0;
			for(int i = 0; i < n; i++)
			{
				desvioPadrao += Math.pow((medidas[i] - xMed), 2);
			}
			desvioPadrao = desvioPadrao / (n-1);
			desvioPadrao = Math.sqrt(desvioPadrao);
			
			if(desvioPadrao < erroInicial)
				desvioPadrao = erroInicial;
			
			System.out.printf("\nσ: \t%3.12f", desvioPadrao);
			
			/*	RESULTADOS FINAIS	*/
			System.out.printf("\n\nMedidas e seus erros finais: ");
			for(int i = 0; i < n; i++)
			{
				System.out.printf("\n%d/%d: \t%3.12f \t +- %3.12f Δ\t+- %3.12f σ     |     (x[%d] - xMed) = %.12f\t (x[%d] - xMed)^2 = %.12f", i+1, n, medidas[i], desvioMedio, desvioPadrao, i, xiMenosX[i], i, xiMenosXQuadrado[i]);
			}
			System.out.printf("\n\nRESULTADO Δ: %.12f +- %.12f", xMed, desvioMedio);
			System.out.printf("\n\nRESULTADO σ: %.12f +- %.12f", xMed, desvioPadrao);
			
			System.out.printf("\n\nCalcular novamente (s/n)?: ");
			novo = leString();
			
		} while(novo.equals("s") || novo.equals("S"));
		
	}

}
