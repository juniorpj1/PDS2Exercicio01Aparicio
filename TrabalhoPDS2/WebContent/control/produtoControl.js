var app = angular.module('produtoModule',[]);

app.controller('produtoControl', function($scope,$http){
	
	var url = 'http://localhost:8080/TrabalhoPDS2/rs/produto';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (produtosRetorno) {
			$scope.produtos = produtosRetorno;
		}).error(function(mensagemErro) {
			$scope.mensagens.push('Erro ao pesquisar produtos '+mensagemErro);
		});   
	}
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.produto = {};
		$scope.mensagens = [];
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}
	
    $scope.salvar = function() {
		if ($scope.produto.codProduto == undefined || $scope.produto.codProduto == '') {
			$http.post(url, $scope.produto).success(function(produto) {
				$scope.produtos.push($scope.produto);
				$scope.novo();
				$scope.mensagens.push('Produto salvo com sucesso!!!');
			}).error(function (erro) {
				//alert(erro);
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		} else {
			$http.put(url,$scope.produto).success(function(produto) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Produto atualizado com sucesso!!!');
			}).error(function (erro) {
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.produto.codProduto == '') {
			alert('Selecione um produto');
		} else {
			urlExcluir = url + '/' + $scope.produto.codProduto;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Produto excluído com sucesso');
			}).error(function (erro) {
				$scope.mensagens.push('Erro ao excluir cliente: '+erro);
			});
		}
	}
	
	$scope.seleciona = function(produtoTabela) {
		$scope.produto = produtoTabela;
	}

});