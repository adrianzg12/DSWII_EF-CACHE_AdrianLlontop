package pe.edu.cibertec.DSWII_EF_CACHE_LlontopAdrian.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;  // Importa BigDecimal
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Pedido")  // Nombre de la tabla en la base de datos
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Cambiado a Long para coincidir con el tipo de id en la BD

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)  // Relación con Cliente
    private Cliente cliente;

    @Column(name = "estado", nullable = false)
    private String estado;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PedidoDetails> productos = new HashSet<>();  // Relación con PedidoDetails
}
