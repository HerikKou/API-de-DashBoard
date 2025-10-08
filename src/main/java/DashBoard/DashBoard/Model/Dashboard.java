package DashBoard.DashBoard.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dashboard")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dashboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int idade;
    private String estado;
    private String cidade;
    private String profissao;
    private double salario;
    private String pais;
    

}
