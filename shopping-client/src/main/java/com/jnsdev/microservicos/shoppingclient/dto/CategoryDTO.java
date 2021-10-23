package com.jnsdev.microservicos.shoppingclient.dto;

import javax.validation.constraints.NotNull;

/**
 * @Autor Jairo Nascimento
 * @Created 26/09/2021 - 17:01
 */
public class CategoryDTO {
    @NotNull
    private Long id;
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//    public static CategoryDTO convert(Category category) {
//        CategoryDTO categoryDTO = new CategoryDTO();
//        categoryDTO.setId(category.getId());
//        categoryDTO.setNome(category.getNome());
//        return categoryDTO;
//    }
}
