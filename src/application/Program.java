package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do Cliente:");
		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("eMail: ");
		String email = sc.nextLine();
		System.out.print("Data de Nascimento (DD/MM/AAAA): ");
		Date birthdata = sdf.parse(sc.next());
		
		
		
		Client cliente = new Client(name, email, birthdata);
		
		System.out.println("Dados do Pedido");
		System.out.print( "Status do Pedido: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());

		Order order = new Order(new Date(), status, cliente);

		System.out.print("Quantos itens serão cadastrados");
		int n = sc.nextInt();
		for (int i = 1; i<=n; i++){
			System.out.println("Entre com o item #" + i);
			System.out.print("Nome do Produto: ");
			sc.nextLine();
			String prodName = sc.nextLine();
			System.out.print("Preço: ");
			double prodPrice = sc.nextDouble();
			
			Product produto = new Product(prodName, prodPrice);
			
			System.out.print("Quantidade: ");
			int prodQuant = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(prodQuant, prodPrice, produto);
			
			order.addItem(orderItem);			
			
		}
		
		System.out.println();
		System.out.println("Sumario do Pedido: ");
		System.out.println(order);

		sc.close();
	}

}
