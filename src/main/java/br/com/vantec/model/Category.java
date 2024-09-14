package br.com.vantec.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categorias")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String name;

    public Category(String name) {
        this.name = name;
    }

}
