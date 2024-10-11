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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

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
	@Operation(summary = "Busca Pedido por Id", description = "Buscar pedidos com produtos por id.")
	@GetMapping(path = "/{idPedido}")
	public ResponseEntity<PedidoComProdutoDto> consultarPorId(
			@Parameter(description = "Id do pedido a ser consultado", required = true, example = "1") 
			@PathVariable Integer idPedido) {
		PedidoComProdutoDto pedidoDto = servicoPedido.consultarPedidoPorIdDto(idPedido);

		if (pedidoDto != null) {
			return ResponseEntity.ok(pedidoDto);
		}
		return ResponseEntity.notFound().build();
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
	@Operation(summary = "Busca Pedido por Data", description = "Buscar pedidos com produtos, "
			+ "filtrados pelas datas inicial e final, ordenados pelo numero do pedido e codigo do produto.")
	@GetMapping
	public ResponseEntity<List<PedidoComProdutoDto>> consultarPedidosPorData(
			@Parameter(description = "Data inicial do pedido", required = true, example = "2024-01-01")
			@RequestParam String dataInicial,
			@Parameter(description = "Data final do pedido", required = true, example = "2024-12-31")
			@RequestParam String dataFinal) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date dataConvertidaInicial, dataConvertidaFinal;

		try {
			dataConvertidaInicial = formato.parse(dataInicial);
			dataConvertidaFinal = formato.parse(dataFinal);
			List<PedidoComProdutoDto> listaPedidoDto = servicoPedido.consultarPedidosPorData(dataConvertidaInicial,
					dataConvertidaFinal);
			return ResponseEntity.ok(listaPedidoDto);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * EndPoint responsavel por inserir um novo {@link Pedido} no sistema.
	 *
	 * @autor Carlos Pereira
	 *
	 * @param novoPedidoDto
	 * @return ResponseEntity< {@link PedidoComProdutoDto} >
	 */
	@Operation(summary = "Inserir Pedido", description = "Cria um novo pedido no sistema.")
	@PostMapping
	public ResponseEntity<PedidoComProdutoDto> inserir(
			@io.swagger.v3.oas.annotations.parameters.RequestBody (description = "Detalhes do pedido a ser criado", required = true) 
			@RequestBody PedidoDto novoPedidoDto) {
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
	@Operation(summary = "Atualizar Pedido", description = "Atualiza um pedido e seus produtos no sistema.")
	@PutMapping("/{idPedido}")
	public ResponseEntity<PedidoComProdutoDto> atualizarPedido(
			@Parameter(description = "Id do pedido a ser atualizado", required = true, example = "1")
			@PathVariable Integer idPedido,
			@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Detalhes do pedido a ser atualizado", required = true)
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
	 * @return ResponseEntity< {@link Void} >
	 */
	@Operation(summary = "Excluir Pedido", description = "Exclui um pedido no sistema")
	@DeleteMapping(path = "/{idPedido}")
	public ResponseEntity<Void> excluir(
			@Parameter(description = "Id do pedido a ser excluído", required = true, example = "1")
			@PathVariable Integer idPedido) {
		servicoPedido.excluirPedido(idPedido);

		return ResponseEntity.noContent().build();
	}

}
