var app = angular.module('produtoModule',[]);

app.controller('produtoControl', function($scope,$http){
	
	var url = 'http://localhost:8080/TrabalhoPDS2/rs/produto';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (produtosRetorno) {
			$scope.produtos = produtosRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
    $scope.salvar = function() {
		if ($scope.produto.codigo == '') {
			$http.post(url, $scope.produto).success(function(produto) {
				$scope.produtos.push($scope.produto);
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		} else {
			$http.put(url,$scope.produto).success(function(produto) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
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
			}).error(function (erro) {
				alert(erro);
			});
		}
		$scope.produtos.splice($scope.produtos.indexOf($scope.produto), 1);
		$scope.novo();
	}
	
	$scope.seleciona = function(produtoTabela) {
		$scope.produto = produtoTabela;
	}
	
	$scope.novo = function(){
		$scope.produto == '';
	}
	
	$scope.pesquisar();

});