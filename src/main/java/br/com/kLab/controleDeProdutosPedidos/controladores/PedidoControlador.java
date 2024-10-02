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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.kLab.controleDeProdutosPedidos.dtos.pedido.PedidoComProdutoDto;
import br.com.kLab.controleDeProdutosPedidos.dtos.pedido.PedidoDto;
import br.com.kLab.controleDeProdutosPedidos.entidades.Pedido;
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

	@GetMapping(path = "/{idPedido}")
	public ResponseEntity<PedidoComProdutoDto> consultarPorId(@PathVariable Integer idPedido) {
		PedidoComProdutoDto pedidoDto = servicoPedido.consultarPedidoPorIdDto(idPedido);

		if (pedidoDto != null) {
			return ResponseEntity.ok(pedidoDto);
		}
		return ResponseEntity.internalServerError().build();
	}

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

	@PostMapping
	public ResponseEntity<PedidoComProdutoDto> inserir(@RequestBody PedidoDto novoPedidoDto) {
		PedidoComProdutoDto novoPedido = servicoPedido.inserirPedido(novoPedidoDto);

		URI uri = UriComponentsBuilder.fromPath("pedido/").buildAndExpand(novoPedido.getNumeroPedido()).toUri();
		return ResponseEntity.created(uri).body(novoPedido);
	}

	@DeleteMapping(path = "/{idPedido}")
	public ResponseEntity<Pedido> excluir(@PathVariable Integer idPedido) {
		servicoPedido.excluirPedido(idPedido);

		return ResponseEntity.noContent().build();
	}

}
