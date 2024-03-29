import org.springframework.web.client.RestTemplate;

import com.algaworks.algafood.client.api.ClientApiException;
import com.algaworks.algafood.client.api.RestauranteClient;

public class ListagemRestauranteMain {
	
	public static void main(String[] args) {
		
		try {
			RestTemplate restTemplate = new RestTemplate();
			RestauranteClient restauranteClient = new RestauranteClient(
					restTemplate, "http://api.algafood.local:9000");
			
			restauranteClient.listar().stream()
			.forEach(restaurante -> System.out.println(restaurante));
			
		} catch(ClientApiException e) {
			if (e.getProblem() != null) {
				System.out.println(e.getProblem().getUserMessage());
			} else {
				System.out.println("Erro desconhecido");
				e.printStackTrace();
			}
		}
	}

}
