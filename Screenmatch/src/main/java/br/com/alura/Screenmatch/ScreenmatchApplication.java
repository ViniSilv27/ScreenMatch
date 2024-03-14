package br.com.alura.Screenmatch;

import br.com.alura.Screenmatch.Model.DadosSerie;
import br.com.alura.Screenmatch.Service.ConsumoApi;
import br.com.alura.Screenmatch.Service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args)  {

		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		System.out.println(json);
		var aconsumoApi = new ConsumoApi();
		var ajson = consumoApi.obterDados("https://www.omdbapi.com/?t=how+i+met+your+mother&apikey=6585022c");
		System.out.println(ajson);


		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
		ConverteDados aconversor = new ConverteDados();
		DadosSerie adados = aconversor.obterDados(ajson, DadosSerie.class);
		System.out.println(adados);
	}
}
