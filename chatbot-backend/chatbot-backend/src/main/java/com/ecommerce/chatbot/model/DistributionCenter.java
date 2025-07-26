package com.ecommerce.chatbot.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "distribution_centers")
public class DistributionCenter {

    @Id
    private Long id;

    private String name;
    private double latitude;
    private double longitude;
}
