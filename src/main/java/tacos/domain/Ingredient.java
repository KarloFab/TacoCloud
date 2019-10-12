package tacos.domain;

import lombok.*;
import tacos.domain.enums.Type;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {

    public Ingredient(String id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private Type type;

    @ManyToMany
    private List<Ingredient> ingredients;
}

