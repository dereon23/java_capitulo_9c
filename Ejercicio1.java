package Capitulo9c;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Gato[] gatos=new Gato[4];
		for(int i=0; i<4;i++) {
			System.out.println("Gato "+i+":");
			System.out.println("Nombre, sexo, edad");
			gatos[i]=new Gato(s.nextLine(),s.nextLine(),Integer.parseInt(s.nextLine()));
		}
		for(Gato g: gatos) {
			System.out.println(g);
		}
	}
	
}

class Gato{
	public String nombre, sexo; public int edad, numero;
	private static int gatosCreados=0;
	public Gato(String nombre, String sexo, int edad) {
		this.nombre=nombre; this.sexo=sexo; this.edad=edad;
		gatosCreados++; numero=gatosCreados;
	}
	public Gato() {
		
	}
	public String toString() {
		return "Nombre: "+nombre+" Sexo: "+sexo+" Edad: "+edad;
	}
}
