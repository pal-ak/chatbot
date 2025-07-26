package com.ecommerce.chatbot.data.config;

import com.ecommerce.chatbot.data.loader.CSVLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;

@Configuration
public class DataLoadConfig {

    @Bean
    CommandLineRunner run(CSVLoader csvLoader) {
        return args -> {
            csvLoader.loadDistributionCenters("src/main/resources/data/distribution_centers.csv");
            csvLoader.loadUsers("src/main/resources/data/users.csv");
            csvLoader.loadProductsFromCSV("src/main/resources/data/products.csv");
            csvLoader.loadInventoryItems("src/main/resources/data/inventory_items.csv");
            csvLoader.loadOrders("src/main/resources/data/orders.csv");
            csvLoader.loadOrderItems("src/main/resources/data/order_items.csv");
        };
    }
}
