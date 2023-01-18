package Capitulo9c;

import java.util.Scanner;

public class Ejercicio5 {
	public static void main(String[] args) {
		Articulo[] articulos = new Articulo[100];
		for(Articulo a: articulos) {
			a=new Articulo("Descripcion",0,0,0);
			a.CodigoCero();
		}
		Scanner s = new Scanner(System.in);
		boolean salir=false;
		int opcion;
		
		String descripcion; double precioCompra, precioVenta; int stock;
		
		while(!salir) {
		System.out.println("1. Listado\n"
				+ "2. Alta\n"
				+ "3. Baja\n"
				+ "4. Modificación\n"
				+ "5. Entrada de mercancía\n"
				+ "6. Salida de mercancía\n"
				+ "7. Salir\n");
		
		opcion=Integer.parseInt(s.nextLine());
		
		switch(opcion) {
		case 1:
			for(int i=0; i<100;i++) {
				if(articulos[i].getCodigo()!=0) {
					System.out.println(articulos[i]);
				}
			}
		break;
		case 2:
			System.out.println("Introduzca la descripcion");
			descripcion=s.nextLine();
			System.out.println("Introduza el precio de compra");
			precioCompra=Double.parseDouble(s.nextLine());
			System.out.println("Introduza el precio de venta");
			precioVenta=Double.parseDouble(s.nextLine());
			System.out.println("Introduza el stock");
			stock=Integer.parseInt(s.nextLine());
			for(int i=0; i<100;i++) {
				if(articulos[i].getCodigo()==0) {
				articulos[i]=new Articulo(descripcion,precioCompra,precioVenta,stock);
				break;
				}
			}
			break;
			case 3:
				System.out.println("Introduzca el codigo");
				opcion=Integer.parseInt(s.nextLine());
				for(int i=0; i<100;i++) {
					if(articulos[i].getCodigo()==opcion) {
						articulos[i].CodigoCero();
						break;
						}
				}
			break;
			case 4:
				System.out.println("Introduzca el codigo");
				opcion=Integer.parseInt(s.nextLine());
				System.out.println("Introduzca la descripcion");
				descripcion=s.nextLine();
				System.out.println("Introduza el precio de compra");
				precioCompra=Double.parseDouble(s.nextLine());
				System.out.println("Introduza el precio de venta");
				precioVenta=Double.parseDouble(s.nextLine());
				System.out.println("Introduza el stock");
				stock=Integer.parseInt(s.nextLine());
				for(int i=0; i<100;i++) {
					if(articulos[i].getCodigo()==opcion) {
						articulos[i]=new Articulo(descripcion,precioCompra, precioVenta,stock);
						break;
						}
				}
				break;
			case 5:
				System.out.println("Introduzca el codigo");
				opcion=Integer.parseInt(s.nextLine());
				System.out.println("Introduzca la cantidad");
				stock=Integer.parseInt(s.nextLine());
				for(int i=0; i<100;i++) {
					if(articulos[i].getCodigo()==opcion) {
						articulos[i].incrementarStock(stock);
						break;
						}
				}
				break;
			case 6:
				System.out.println("Introduzca el codigo");
				opcion=Integer.parseInt(s.nextLine());
				System.out.println("Introduzca la cantidad");
				stock=Integer.parseInt(s.nextLine());
				for(int i=0; i<100;i++) {
					if(articulos[i].getCodigo()==opcion) {
						articulos[i].decrementarStock(stock);
						break;
						}
				}
				break;
			default: salir=true;
			}
		}
	}
}

class Articulo{
	private int codigo;
	private String descripcion;
	private double precioCompra, precioVenta;
	private int stock;
	private static int contadorCodigo=0;
	public Articulo(String descripcion, double precioCompra, double precioVenta, int stock){
		this.descripcion=descripcion; this.precioCompra=precioCompra; this.precioVenta=precioVenta;
		this.stock=stock;
		contadorCodigo++; codigo=contadorCodigo;
	}
	public String toString() {
		return "Codigo: "+codigo+"|Descripciom: "+descripcion+"| Precio de Compra: "+precioCompra+"|Precio de Venta: "+precioVenta+"|Stock: "+stock;
	}
	public int getCodigo() {
		return codigo;
	}
	public void CodigoCero() {
		codigo=0;
	}
	public void incrementarStock(int incremento) {
		stock+=incremento;
	}
	public void decrementarStock(int decremento) {
		if(stock>decremento) {stock-=decremento;}
		else {
			System.out.println("Supera el stock");
		}
	}
}