package tacos.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import tacos.domain.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
