package pe.edu.cibertec.DSWII_EF_CACHE_LlontopAdrian.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_EF_CACHE_LlontopAdrian.model.Pedido;
import pe.edu.cibertec.DSWII_EF_CACHE_LlontopAdrian.repository.PedidoRepository;
import pe.edu.cibertec.DSWII_EF_CACHE_LlontopAdrian.service.IPedidoService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PedidoService implements IPedidoService {

    private final PedidoRepository pedidoRepository;

    @Cacheable(value = "ordenesPorEstado", key = "#estado")
    @Override
    public List<Pedido> obtenerOrdenesPorEstado(String estado) {
        return pedidoRepository.obtenerOrdenesPorEstado(estado);
    }

    @CacheEvict(value = "ordenesPorEstado", allEntries = true)
    @Override
    public Pedido registrarOrden(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @CachePut(value = "ordenesPorEstado", key = "#pedido.id")
    @Override
    public Pedido actualizarOrden(Pedido pedido) {
        return pedidoRepository.save(pedido); // Guarda el pedido actualizado
    }

    @CacheEvict(value = "ordenesPorEstado", allEntries = true)
    @Override
    public void eliminarOrden(Long id) {
        pedidoRepository.deleteById(id); // Elimina el pedido por ID
    }

    @CacheEvict(value = {"ordenesPorEstado"}, allEntries = true)
    @Override
    public void eliminarCache() {
        // Se elimina la caché para "ordenesPorEstado"
    }
}