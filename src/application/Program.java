package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Numero do quarto: ");
		int numero = sc.nextInt();
		System.out.println("Data do check-in: (dia/mes/ano):");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Data do check-out: (dia/mes/ano):");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Probleme na reserva: o Check-out é uma data depois do Check-in");
		} else {
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println(reserva);

			System.out.println();
			System.out.println("Insira novas datas para atualizar...");
			System.out.println("Data do check-in: (dia/mes/ano):");
			checkIn = sdf.parse(sc.next());
			System.out.println("Data do check-out: (dia/mes/ano):");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();

			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Probleme na reserva...");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Probleme na reserva: o Check-out é uma data depois do Check-in");
			} else {
				reserva.atualizaData(checkIn, checkOut);
				System.out.println(reserva);
			}
		}
	}

}
