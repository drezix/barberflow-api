package br.com.barberflow.api.core.user.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "User") // Define que esta classe é uma entidade JPA
@Table(name = "users") // Define o nome da tabela no banco de dados
@Getter // Lombok: gera todos os getters
@NoArgsConstructor // Lombok: gera um construtor sem argumentos (obrigatório pelo JPA)
@AllArgsConstructor // Lombok: gera um construtor com todos os argumentos
@EqualsAndHashCode(of = "id") // Lombok: cria o equals e hashCode baseado apenas no 'id'
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}