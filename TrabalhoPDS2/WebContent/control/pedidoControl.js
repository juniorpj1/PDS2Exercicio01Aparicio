var app = angular.module('pedidoModule',[]);
 
app.controller('pedidoControl', function($scope,$http){
	
	var url = 'http://localhost:8080/TrabalhoPDS2/rs/pedido';
		
	  $scope.closeAlert = function(pedido) {
		$scope.alerts = [];
	    $scope.alerts.splice(pedido, 1);
	  };
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (pedidosRetorno) {
			$scope.pedidos = pedidosRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.pedido = {};
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}
	
    $scope.salvar = function() {
		if ($scope.pedido.codPedido == '' || $scope.pedido.codPedido == undefined) {
			$http.post(url, $scope.pedido).success(function(pedido) {
				$scope.pedidos.push($scope.pedido);
				$scope.novo();
				$scope.mensagens.push('Pedido salvo com sucesso!');
				$scope.$parent.alerts.push({type: 'success', msg: 'Saved!'});
			}).error(function (erro) {
				// alert(erro);
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		} else {
			$http.put(url,$scope.pedido).success(function(pedido) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Pedido atualizado com sucesso!');
				$scope.$parent.alerts.push({type: 'success', msg: 'Updated!'});
			}).error(function (erro) {
				$scope.montaMensagemErro(erro.parameterViolations);
				$scope.$parent.alerts.push({type: 'danger', msg: 'Server: '+error.statusText});
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
				$scope.mensagens.push('Pedido excluído com sucesso!');
			}).error(function (erro) {
				//alert(erro);
				$scope.mensagens.push('Erro ao excluir cliente: '+erro);
			});
		}
		$scope.pedidos.splice($scope.pedidos.indexOf($scope.pedido), 1);
		$scope.novo();
	}
	
	$scope.seleciona = function(pedidoTabela) {
		$scope.pedido = pedidoTabela;
	}
	
});