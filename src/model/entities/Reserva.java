package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DominioException;

public class Reserva {

	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva() {

	}

	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
			throw new DominioException ("o Check-out é uma data depois do Check-in");
		}
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duracacao() {
		long calc = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(calc, TimeUnit.MILLISECONDS);
	}

	public void atualizaData(Date checkIn, Date checkOut){

		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DominioException ("As datas de reserva tem que ser funturas...");
		}
		if (!checkOut.after(checkIn)) {
			throw new DominioException ("o Check-out é uma data depois do Check-in");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Quarto " + numeroQuarto + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut)
				+ ", " + duracacao() + " noites";
	}

}
