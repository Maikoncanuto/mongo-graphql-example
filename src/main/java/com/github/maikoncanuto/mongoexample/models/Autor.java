package com.github.maikoncanuto.mongoexample.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "autores")
public class Autor implements Serializable {

    @Id
    private String id;

    private String nome;

    private List<Artigo> artigos = new LinkedList<>();
}
