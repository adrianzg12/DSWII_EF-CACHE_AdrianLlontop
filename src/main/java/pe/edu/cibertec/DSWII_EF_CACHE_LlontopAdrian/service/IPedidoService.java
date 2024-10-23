package pe.edu.cibertec.DSWII_EF_CACHE_LlontopAdrian.service;

import pe.edu.cibertec.DSWII_EF_CACHE_LlontopAdrian.model.Pedido;
import java.util.List;

public interface IPedidoService {

    List<Pedido> obtenerOrdenesPorEstado(String estado);

    Pedido registrarOrden(Pedido pedido);

    Pedido actualizarOrden(Pedido pedido);

    void eliminarOrden(Long id);

    void eliminarCache();
}