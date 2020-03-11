public class Ex03 {

	public static void main(String[] args) {
		int x;
		x = EntradaTeclado.leInt();
		
		
		for(int i = x; i > 0; i--)
		{
			for(int k = i; k < x; k++)
				System.out.print(" ");
			for(int j = i; j > 0; j--)
				System.out.print("*");
			
			System.out.print("\n");
		}
		

	}

}
