package com.ecommerce.chatbot.data.loader;

import com.ecommerce.chatbot.model.Product;
import com.ecommerce.chatbot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class CSVLoader {

    private final ProductRepository productRepository;

    @Autowired
    public CSVLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void loadProductsFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",", -1); // -1 to keep trailing empty strings

                if (fields.length < 9) {
                    System.err.println("Skipping malformed line: " + line);
                    continue;
                }

                try {
                    Product product = new Product();
                    product.setId(Long.parseLong(fields[0]));
                    product.setCost(Double.parseDouble(fields[1]));
                    product.setCategory(fields[2]);
                    product.setName(fields[3]);
                    product.setBrand(fields[4]);
                    product.setRetailPrice(Double.parseDouble(fields[5]));
                    product.setDepartment(fields[6]);
                    product.setSku(fields[7]);
                    product.setDistributionCenterId(Long.parseLong(fields[8]));

                    productRepository.save(product);
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing line (skipped): " + line);
                }
            }
            System.out.println("Product data loaded successfully.");
        } catch (IOException e) {
            System.err.println("Failed to load products CSV: " + e.getMessage());
        }
    }
}
