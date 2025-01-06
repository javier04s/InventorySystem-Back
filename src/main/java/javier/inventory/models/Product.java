package javier.inventory.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("product_id")
    Integer productId;

    @JsonProperty("description")
    String description;

    @JsonProperty("price")
    Double price;

    @JsonProperty("quantity")
    Integer quantity;

    @Generated
    public Integer getProductId() {
        return productId;
    }

    @Generated
    public Double getPrice() {
        return price;
    }

    @Generated
    public Integer getQuantity() {
        return quantity;
    }

    @Generated
    public String getDescription() {
        return description;
    }

    @Generated
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Generated
    public void setDescription(String description) {
        this.description = description;
    }

    @Generated
    public void setPrice(Double price) {
        this.price = price;
    }

    @Generated
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

