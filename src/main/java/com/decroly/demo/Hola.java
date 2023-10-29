package com.decroly.demo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hola {
	
	LinkedList<String> resultados = new LinkedList<String>();
	
	@GetMapping("/saludar")
	public String saludar()
	{
		return "Hello There!!!!!";
	}
	
	@GetMapping("/jugar/{id}")
	public String jugar(@PathVariable("id") int id)
	{
		return piedraPapelTijera(id);
	}
	
	@GetMapping("/contestar")
	public String contestar()
	{
		return "Te odio Obiwan!!!!!!!!!!";
	}
	
	@GetMapping("/resultados")
	public List<String> getResultados()
	{
		List<String> res = null;
		if(resultados != null)
		{
			res = resultados;
		}
		else {
			res = new LinkedList<String>();
			res.add("No hay registros");
		}
		return res;
	}
	
	
	//Piedra = 0, Papel = 1, Tijera = 2
	private String piedraPapelTijera(int j)
	{
		String mensaje = "Sin jugada o parametro incorrecto";
		String posibilidades [] = {"Piedra", "Papel", "Tijera"};
		int jugadaIA = (int)( Math.random() * 3.0);
		if(j == jugadaIA) {
			mensaje = "EMPATE. Jugador ha jugado " + posibilidades[j] + " IA ha jugado " + posibilidades[jugadaIA];
		}
		else 
		{
			if(j == 0) 
			{
				if(jugadaIA == 1)
				{
					mensaje = "Victoria IA. Jugador ha jugado " + posibilidades[j] + " IA ha jugado " + posibilidades[jugadaIA];
				}
				else 
				{
					mensaje = "Victoria Jugador. Jugador ha jugado " + posibilidades[j] + " IA ha jugado " + posibilidades[jugadaIA];
				}
			}
			
			if(j == 1) 
			{
				if(jugadaIA == 0)
				{
					mensaje = "Victoria Jugador. Jugador ha jugado " + posibilidades[j] + " IA ha jugado " + posibilidades[jugadaIA];
				}
				else 
				{
					mensaje = "Victoria IA. Jugador ha jugado " + posibilidades[j] + " IA ha jugado " + posibilidades[jugadaIA];
				}
			}
			
			if(j == 2) 
			{
				if(jugadaIA == 0)
				{
					mensaje = "Victoria IA. Jugador ha jugado " + posibilidades[j] + " IA ha jugado " + posibilidades[jugadaIA];
				}
				else 
				{
					mensaje = "Victoria Jugador. Jugador ha jugado " + posibilidades[j] + " IA ha jugado " + posibilidades[jugadaIA];
				}
			}
			
		}
		
		resultados.add(mensaje);
		return mensaje;
		
	}

}
