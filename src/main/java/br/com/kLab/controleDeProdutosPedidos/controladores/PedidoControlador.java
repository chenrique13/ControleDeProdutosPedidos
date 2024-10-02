package br.com.kLab.controleDeProdutosPedidos.controladores;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.kLab.controleDeProdutosPedidos.dtos.pedido.PedidoComProdutoDto;
import br.com.kLab.controleDeProdutosPedidos.dtos.pedido.PedidoDto;
import br.com.kLab.controleDeProdutosPedidos.entidades.Pedido;
import br.com.kLab.controleDeProdutosPedidos.entidades.Produto;
import br.com.kLab.controleDeProdutosPedidos.servicos.PedidoServico;

/**
 * Classe responsável por ser o endpoint para operações relacionadas ao
 * {@link Pedido}.
 */
@RestController
@RequestMapping(path = "/pedido")
public class PedidoControlador {

	@Autowired
	private PedidoServico servicoPedido;

	/**
	 * Endpoint responsavel por buscar um {@link Pedido} com produtos por id.
	 *
	 * @autor Carlos Pereira
	 *
	 * @param idPedido
	 * @return ResponseEntity<List<{@link PedidoComProdutoDto}>>
	 */
	@GetMapping(path = "/{idPedido}")
	public ResponseEntity<PedidoComProdutoDto> consultarPorId(@PathVariable Integer idPedido) {
		PedidoComProdutoDto pedidoDto = servicoPedido.consultarPedidoPorIdDto(idPedido);

		if (pedidoDto != null) {
			return ResponseEntity.ok(pedidoDto);
		}
		return ResponseEntity.internalServerError().build();
	}

	/**
	 * Endpoint responsavel por buscar os {@link Pedido} com produtos por um
	 * intervalo de datas, ordenados pelo numero do {@link Pedido} e codigo do
	 * {@link Produto}.
	 *
	 * @autor Carlos Pereira
	 *
	 * @param dataInicial
	 * @param dataFinal
	 * @return ResponseEntity<List<{@link PedidoComProdutoDto}>>
	 */
	@GetMapping
	public ResponseEntity<List<PedidoComProdutoDto>> consultarPedidosPorData(@RequestParam String dataInicial,
			@RequestParam String dataFinal) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dataConvertidaInicial, dataConvertidaFinal;

		try {
			dataConvertidaInicial = formatter.parse(dataInicial);
			dataConvertidaFinal = formatter.parse(dataFinal);
			List<PedidoComProdutoDto> listaPedidoDto = servicoPedido.consultarPedidosPorData(dataConvertidaInicial,
					dataConvertidaFinal);
			return ResponseEntity.ok(listaPedidoDto);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ResponseEntity.internalServerError().build();
	}

	/**
	 * EndPoint responsavel por inserir um novo {@link Pedido} no sistema.
	 *
	 * @autor Carlos Pereira
	 *
	 * @param novoPedidoDto
	 * @return ResponseEntity< {@link PedidoComProdutoDto} >
	 */
	@PostMapping
	public ResponseEntity<PedidoComProdutoDto> inserir(@RequestBody PedidoDto novoPedidoDto) {
		PedidoComProdutoDto novoPedido = servicoPedido.inserirPedido(novoPedidoDto);

		URI uri = UriComponentsBuilder.fromPath("pedido/").buildAndExpand(novoPedido.getNumeroPedido()).toUri();
		return ResponseEntity.created(uri).body(novoPedido);
	}

	/**
	 * EndPoint responsavel por atualizar um {@link Pedido} do sistema.
	 *
	 * @autor Carlos Pereira
	 *
	 * @param idPedido
	 * @param pedidoDto
	 * @return ResponseEntity< {@link PedidoComProdutoDto} >
	 */
	@PutMapping("/{idPedido}")
	public ResponseEntity<PedidoComProdutoDto> atualizarPedido(@PathVariable Integer idPedido,
			@RequestBody PedidoDto pedidoDto) {
		PedidoComProdutoDto pedidoDtoAtualizado = servicoPedido.atualizarPedido(idPedido, pedidoDto);

		if (pedidoDtoAtualizado != null) {
			return ResponseEntity.ok(pedidoDtoAtualizado);
		}
		return ResponseEntity.internalServerError().build();
	}

	/**
	 * EndPoint responsavel por excluir um {@link Pedido} do sistema.
	 *
	 * @autor Carlos Pereira
	 *
	 * @param idPedido
	 * @return ResponseEntity< {@link Pedido} >
	 */
	@DeleteMapping(path = "/{idPedido}")
	public ResponseEntity<Pedido> excluir(@PathVariable Integer idPedido) {
		servicoPedido.excluirPedido(idPedido);

		return ResponseEntity.noContent().build();
	}

}
