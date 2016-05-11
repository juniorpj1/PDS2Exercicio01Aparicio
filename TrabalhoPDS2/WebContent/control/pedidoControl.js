var app = angular.module('pedidoModule',[]);

app.controller('pedidoControl',function($scope,$http){
	
	var url = 'http://localhost:8080/TrabalhoPDS2/rs/pedido';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (pedidosRetorno) {
			$scope.pedidos = pedidosRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
    $scope.salvar = function() {
		if ($scope.pedido.codPedido == '') {
			$http.post(url, $scope.pedido).success(function(pedido) {
				$scope.pedidos.push($scope.pedido);
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		} else {
			$http.put(url,$scope.pedido).success(function(pedido) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.pedido.codPedido == '') {
			alert("Selecione um pedido");
		} else {
			urlExcluir = url + '/' + $scope.pedido.codPedido;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
		$scope.pedidos.splice($scope.pedidos.indexOf($scope.pedido), 1);
		$scope.novo();
	}
	
	$scope.novo = function(){
		$scope.pedido = "";
	}
	
	$scope.seleciona = function(pedidoTabela) {
		$scope.pedido = pedidoTabela;
	}
	
	$scope.pesquisar();
	
});