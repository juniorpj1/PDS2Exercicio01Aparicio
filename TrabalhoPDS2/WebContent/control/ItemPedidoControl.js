var app = angular.module('ItemPedidoModule', []);

app.controller('ItemPedidoControl', function($scope, $http) {
	
	var urlProduto = 'http://localhost:8080/TrabalhoPDS2/rs/produto';
	
	var urlPedido = 'http://localhost:8080/TrabalhoPDS2/rs/pedido';

	var url = 'http://localhost:8080/TrabalhoPDS2/rs/ItemPedido';
	
	$scope.pesquisarProduto = function() {
		$http.get(urlProduto).success(function (produtos) {
			$scope.produtos = produtos;
		}).error(function (mensagemErro) {
			$scope.mensagens.push('Erro ao pesquisar Produtos '+mensagemErro);
		});
	}
	
	$scope.pesquisarPedido = function() {
		$http.get(urlPedido).success(function (pedidos) {
			$scope.pedidos = pedidos;
		}).error(function (mensagemErro) {
			$scope.mensagens.push('Erro ao pesquisar Pedidos '+mensagemErro);
		});
	}

	$scope.pesquisar = function() {
		$http.get(url).success(function(ItemPedidosRetorno) {
			$scope.ItemPedidos = ItemPedidosRetorno;
		}).error(function(mensagemErro) {
			$scope.mensagens.push('Erro ao pesquisar Itens '+mensagemErro);
		});
	}
	
	$scope.pesquisar();
	$scope.pesquisarPedido();
	$scope.pesquisarProduto();
	
	$scope.novo = function() {
		$scope.ItemPedido = {};
		$scope.mensagens = [];
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}

	$scope.salvar = function() {
		if ($scope.produto.codItemPedido == undefined || $scope.ItemPedido.codItemPedido == '') {
			$http.post(url, $scope.ItemPedido).success(function(ItemPedido) {
				$scope.ItemPedidos.push($scope.ItemPedido);
				$scope.novo();
				$scope.mensagens.push('Item de pedido cadastrado com sucesso!!!');
			}).error(function(erro) {
				//alert(erro);
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		} else {
			$http.put(url, $scope.ItemPedido).success(function(ItemPedido) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Item de pedido atualizado com sucesso!!!');
			}).error(function(erro) {
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
	}

	
	$scope.excluir = function() {
		if ($scope.ItemPedido.codItemPedido == '') {
			alert('Selecione um ItemPedido');
		} else {
			urlExcluir = url + '/' + $scope.ItemPedido.codItemPedido;
			$http.delete(urlExcluir).success(function() {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Item de pedido excluído com sucesso');
			}).error(function(erro) {
				$scope.mensagens.push('Erro ao excluir o item de pedido: '+erro);
			});
		}
		$scope.ItemPedidos.splice($scope.ItemPedidos.indexOf($scope.ItemPedido), 1);
		$scope.novo();
	}
	
	$scope.seleciona = function(ItemPedidoTabela) {
		$scope.ItemPedido = ItemPedidoTabela;
	}
	
	$scope.selecionaProduto = function(produto) {
		$scope.produto = produto;
	}

});