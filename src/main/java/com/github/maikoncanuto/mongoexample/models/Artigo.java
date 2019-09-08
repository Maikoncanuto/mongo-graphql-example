package com.github.maikoncanuto.mongoexample.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "artigos")
public class Artigo implements Serializable {

    private String id;
    private String titulo;
    private String corpo;

}
