package pe.edu.cibertec.DSWII_EF_CACHE_LlontopAdrian.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private Double precio;

    @Column(name = "disponibilidad", nullable = false)
    private Boolean disponibilidad;

    @OneToMany(mappedBy = "producto",
            cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<PedidoDetails> pedidosDetalles = new HashSet<>();
}
