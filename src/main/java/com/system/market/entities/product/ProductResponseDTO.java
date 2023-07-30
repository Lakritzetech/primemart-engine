package com.system.market.entities.product;

import com.system.market.model.Product;

import java.util.Date;

public record ProductResponseDTO(Long id, String name, Double preco, Long quantidade, Date validade) {
    public ProductResponseDTO(Product product) {
        this(product.getId(),product.getName(),product.getPreco(),product.getQuantidade(),product.getValidade());
    }
}
