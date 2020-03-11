import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Esta classe foi desenhada para facilitar a entrada de dados
 * pelo teclado. Basicamente ela implementa funções para
 * ler strings, inteiros e doubles. 
 * Ela faz verificações se o que foi digitado realmente
 * é o esperado.
 * Todos 
 * @author delamaro
 *
 */
public class EntradaTeclado {
static InputStreamReader isr = new InputStreamReader(System.in);
static BufferedReader br = new BufferedReader(isr);
	
	/**
	 * Le um string digitado pelo teclado, até que seja pressionado
	 * um enter. Ou seja, le a linha toda.
	 * @return o string que foi digitado pelo usuário.
	 * @throws IOException
	 */
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

	/**
	 * Le um string do teclado (uma linha toda) e tenta transformá-lo num inteiro. 
	 * Porém não faz qualquer verificação sobre a validade do dado digitado.
	 * @return  o valor inteiro digitado pelo usuário. 
	 * @throws IOException
	 */
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

	/**
	 * Le um string do teclado (uma linha toda) e tenta transformá-lo num double. 
	 * Porém não faz qualquer verificação sobre a validade do dado digitado.
	 * @return  o valor double digitado pelo usuário. 
	 * @throws IOException
	 */

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
}