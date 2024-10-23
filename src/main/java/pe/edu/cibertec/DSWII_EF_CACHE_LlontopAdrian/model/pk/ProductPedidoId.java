package pe.edu.cibertec.DSWII_EF_CACHE_LlontopAdrian.model.pk;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class ProductPedidoId implements Serializable {
    private Long pedidoId;
    private Long productoId;
}