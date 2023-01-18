package Capitulo9c;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		
	    final int N = 100;
	    Disco[] discos = new Disco[N];

	    for(int i = 0; i < N; i++) {
	      discos[i] = new Disco();
	    }
	    discos[0] = new Disco(
	      "GASA41", "Wim Mertens", "Maximazing the Audience", "instrumental", 50);
	    discos[1] = new Disco(
	      "FGHQ64", "Metallica", "Black album", "hard rock", 46);
	    discos[2] = new Disco(
	      "TYUI89", "Supersubmarina", "Viento de cara", "pop rock", 42);

	    int opcion;
	    Scanner s = new Scanner(System.in);
	    String codigoIntroducido;
	    String autorIntroducido;
	    String tituloIntroducido;
	    String generoIntroducido;
	    int duracionIntroducida;
	    boolean error=false;
	    int filtro;

	    do {
	      System.out.println("\nCOLECCIÓN DE DISCOS");
	      System.out.println("===================");
	      System.out.println("1. Listado");
	      System.out.println("2. Nuevo disco");
	      System.out.println("3. Modificar");
	      System.out.println("4. Borrar");
	      System.out.println("5. Salir");
	      System.out.print("Introduzca una opción: ");
	      opcion = Integer.parseInt(s.nextLine());
	      
	      switch (opcion) {
	      case 1:
	        System.out.println("\nLISTADO");
	        System.out.println("1.Motrar todo");
	        System.out.println("2. Ordenar por genero");
	        System.out.println("3. Ordenar por autor");
	        filtro=Integer.parseInt(s.nextLine());
	        System.out.println("=======");
	        
	        switch(filtro) {
	        case 1:
	        for(Disco d : discos) {
	          if (!d.getCodigo().equals("LIBRE")) {
	            System.out.println(d);
	          }
	        }
	        break;
	        case 2:
	        System.out.println("Introduce el genero"); generoIntroducido=s.nextLine();
	        for(Disco d : discos) {
	          if (!d.getCodigo().equals("LIBRE")&&d.getGenero().equals(generoIntroducido)) {
	            System.out.println(d);
	          }
	        }
	        break;
	        case 3:
		    System.out.println("Introduce el autor"); autorIntroducido=s.nextLine();
	        for(Disco d : discos) {
	          if (!d.getCodigo().equals("LIBRE")&&d.getAutor().equals(autorIntroducido)) {
	            System.out.println(d);
	          }
	        }
	        break;
	        
	        }

	        break;
	        
	      case 2:
	        System.out.println("\nNUEVO DISCO");
	        System.out.println("===========");
	        
	        // Busca la primera posición libre del array
	        int primeraLibre = -1;
	        do {
	          primeraLibre++;
	        } while ((!((discos[primeraLibre].getCodigo()).equals("LIBRE")))||primeraLibre<N);
	        
	        if(primeraLibre<=N) {
	        System.out.println("Por favor, introduzca los datos del disco.");  
	        System.out.print("Código: ");
	        codigoIntroducido = s.nextLine();
	        System.out.print("Autor: ");
	        autorIntroducido = s.nextLine();
	        System.out.print("Título: ");
	        tituloIntroducido = s.nextLine();
	        System.out.print("Género: ");
	        generoIntroducido = s.nextLine();
	        System.out.print("Duración: ");
	        duracionIntroducida = Integer.parseInt(s.nextLine());
	        discos[primeraLibre] = new Disco(codigoIntroducido, autorIntroducido, tituloIntroducido, generoIntroducido, duracionIntroducida);
	        }else {
	        	System.out.println("No hay espacio");
	        }
	        
	        break;
	        
	      case 3:
	        System.out.println("\nMODIFICAR");
	        System.out.println("===========");
	        
	        System.out.print("Por favor, introduzca el código del disco cuyos datos desea cambiar: ");
	        codigoIntroducido = s.nextLine();
	  
	        int i = -1;
	        do {
	          i++;
	        } while (!((discos[i].getCodigo()).equals(codigoIntroducido)));
	        
	        System.out.println("Introduzca los nuevos datos del disco o INTRO para dejarlos igual.");
	  
	        System.out.println("Código: " + discos[i].getCodigo());
	        System.out.print("Nuevo código: ");
	        codigoIntroducido = s.nextLine();
	        for(int j=0; j<N;j++) {
	        	if(discos[j].getCodigo().equals(codigoIntroducido)) {
	        		System.out.println("Ya existe");
	        		error=true;
	        		break;
	        	}
	        }
	        if (!codigoIntroducido.equals("")||!error) {
		          discos[i].setCodigo(codigoIntroducido);
		     }
	        System.out.println("Autor: " + discos[i].getAutor());
	        System.out.print("Nuevo autor: ");
	        autorIntroducido = s.nextLine();
	        if (!autorIntroducido.equals("")) {
	          discos[i].setAutor(autorIntroducido);
	        }
	        
	        System.out.println("Título: " + discos[i].getTitulo());
	        System.out.print("Nuevo título: ");
	        tituloIntroducido = s.nextLine();
	        if (!tituloIntroducido.equals("")) {
	          discos[i].setTitulo(tituloIntroducido);
	        }
	        
	        System.out.println("Género: " + discos[i].getGenero());
	        System.out.print("Nuevo género: ");
	        generoIntroducido = s.nextLine();
	        if (!generoIntroducido.equals("")) {
	          discos[i].setGenero(generoIntroducido);
	        }
	        
	        System.out.println("Duración: " + discos[i].getDuracion());
	        System.out.print("Duración: ");
	        final String duracionIntroducidaString = s.nextLine();
	        if (!duracionIntroducidaString.equals("")) {
	          discos[i].setDuracion(Integer.parseInt(duracionIntroducidaString));
	        }
	        
	        break;
	        
	      case 4:
	        System.out.println("\nBORRAR");
	        System.out.println("======");
	        
	        System.out.print("Por favor, introduzca el código del disco que desea borrar: ");
	        codigoIntroducido = s.nextLine();
	  
	        i = -1;
	        do {
	          i++;
	        } while ((!((discos[i].getCodigo()).equals(codigoIntroducido)))||i<N);
	        if(i<=N) {
	        discos[i].setCodigo("LIBRE");
	        System.out.println("Album borrado.");
	        }else {
	        	System.out.println("No encontrado");
	        }
	        
	        break;
	        
	      default:
	      
	      } // switch
	    } while (opcion != 5);
	  }
	
}