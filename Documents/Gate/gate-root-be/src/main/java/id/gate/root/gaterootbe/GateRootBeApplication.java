package id.gate.root.gaterootbe;

import id.gate.root.gaterootbe.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class GateRootBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GateRootBeApplication.class, args);
	}

}
