package com.example.cardapio.food;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "foods") //Essa anotação define o nome da tabela no banco de dados
@Entity(name = "foods") //Essa anotação indica que a classe Food é uma entidade JPA
@Getter //Essa anotação, proveniente do projeto Lombok, cria automaticamente os métodos getters para os campos da classe
@NoArgsConstructor
@AllArgsConstructor //geram automaticamente construtores vazios e construtores que incluem todos os campos da classe, respectivamente.
@EqualsAndHashCode(of = "id")
public class Food {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //para definir que o valor do ID será gerado automaticamente pelo banco de dados (utilizando uma estratégia de autoincremento).
    private Long id;
    private String title;
    private String image;
    private Integer price;

    public Food(FoodRequestDTO data){
        this.image = data.image();
        this.price = data.price();
        this.title = data.title();
    }
}
