package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DominioException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.println("Numero do quarto: ");
			int numero = sc.nextInt();
			System.out.println("Data do check-in: (dia/mes/ano):");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Data do check-out: (dia/mes/ano):");
			Date checkOut = sdf.parse(sc.next());

			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println(reserva);

			System.out.println();
			System.out.println("Insira novas datas para atualizar...");
			System.out.println("Data do check-in: (dia/mes/ano):");
			checkIn = sdf.parse(sc.next());
			System.out.println("Data do check-out: (dia/mes/ano):");
			checkOut = sdf.parse(sc.next());

			reserva.atualizaData(checkIn, checkOut); // vai lançar uma exceção caso ela ocorra
			System.out.println("Reserva: " + reserva);
		} catch (ParseException e) {
			System.out.println("Formato de data invalido...");
		} catch (DominioException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch(RuntimeException e){
			System.out.println("Erro Inesperado...");
		}
		sc.close();
	}
}
