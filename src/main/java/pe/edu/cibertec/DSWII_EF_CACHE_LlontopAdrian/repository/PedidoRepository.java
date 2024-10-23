package pe.edu.cibertec.DSWII_EF_CACHE_LlontopAdrian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_EF_CACHE_LlontopAdrian.model.Pedido;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(value = "SELECT * FROM Pedido WHERE estado = ?", nativeQuery = true)
    List<Pedido> obtenerOrdenesPorEstado(String estado);
}