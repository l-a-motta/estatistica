import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Esta classe foi desenhada para facilitar a entrada de dados
 * pelo teclado. Basicamente ela implementa fun��es para
 * ler strings, inteiros e doubles. 
 * Ela faz verifica��es se o que foi digitado realmente
 * � o esperado.
 * Todos 
 * @author delamaro
 *
 */
public class EntradaTeclado {
static InputStreamReader isr = new InputStreamReader(System.in);
static BufferedReader br = new BufferedReader(isr);
	
	/**
	 * Le um string digitado pelo teclado, at� que seja pressionado
	 * um enter. Ou seja, le a linha toda.
	 * @return o string que foi digitado pelo usu�rio.
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
	 * Le um string do teclado (uma linha toda) e tenta transform�-lo num inteiro. 
	 * Por�m n�o faz qualquer verifica��o sobre a validade do dado digitado.
	 * @return  o valor inteiro digitado pelo usu�rio. 
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
	 * Le um string do teclado (uma linha toda) e tenta transform�-lo num double. 
	 * Por�m n�o faz qualquer verifica��o sobre a validade do dado digitado.
	 * @return  o valor double digitado pelo usu�rio. 
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