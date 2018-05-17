package it.eng.productunithubwebinterface;

import it.eng.productunithubledgerclient.base.BlockchainFactory;
import it.eng.productunithubledgerclient.base.LedgerClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
@SpringBootApplication

public class ProductUnitHubWebInterfaceApplication {

    @Bean
    public LedgerClient createLedgerClient() throws Exception {
        BlockchainFactory blockchainFactory = new BlockchainFactory();
        return blockchainFactory.getType();
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductUnitHubWebInterfaceApplication.class, args);
    }
}
