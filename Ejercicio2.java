package Capitulo9c;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Gato[] gatos=new Gato[4];
		for(int i=0; i<4;i++) {
			gatos[i]=new Gato();
		}
		gatos[0].nombre="Meow"; gatos[0].sexo="M"; gatos[0].edad=2;
		gatos[1].nombre="MeowMeow"; gatos[1].sexo="F"; gatos[1].edad=3;
		gatos[2].nombre="Miau"; gatos[2].sexo="F"; gatos[2].edad=1;
		gatos[3].nombre="MiauMiau"; gatos[3].sexo="M"; gatos[3].edad=4;
		for(Gato g: gatos) {
			System.out.println(g);
		}
	}
	
}