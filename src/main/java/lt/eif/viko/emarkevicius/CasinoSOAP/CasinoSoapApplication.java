package lt.eif.viko.emarkevicius.CasinoSOAP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(WebServiceConfig.class)
public class CasinoSoapApplication {

	public static void main(String[] args) {

		SpringApplication.run(CasinoSoapApplication.class, args);
	}

}
