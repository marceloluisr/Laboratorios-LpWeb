let precosProdutos = new Map()
precosProdutos.set("Suco",4.00)
precosProdutos.set("Refrigerante",2.50)
precosProdutos.set("Água",1.50)
precosProdutos.set("Bolo",3.50)
precosProdutos.set("Pastel",3.00)
precosProdutos.set("Torta",4.00)


function criarPedido() {
    let pedido = {
        "cliente":"",
        "bebidas" : [],
        "docesEsalgados" : [],
        "valorTotal": []
    }

    return pedido
}


function calcValorTotal(pedido) {
    let valorTotal = 0

    pedido.bebidas.forEach(v => valorTotal += precosProdutos.get(v))
    pedido.docesEsalgados.forEach(v => valorTotal += precosProdutos.get(v))

    return valorTotal
}




function calcular() {
    let entradas = document.forms[0]
    
    let pedido = criarPedido()

    pedido.cliente = entradas[1].value
    for (let i = 1; i < entradas.length; i++) {
        if (entradas[i].type == 'checkbox' & entradas[i].checked) {
            if(entradas[i].name == 'bebida'){
                pedido.bebidas.push(entradas[i].value)
            } else if(entradas[i].name = 'doceEsalgado') {
                pedido.docesEsalgados.push(entradas[i].value)
            }
        } 
    }

    pedido.valorTotal = calcValorTotal(pedido)

    mostrarTela(pedido)
}

function mostrarTela(pedido) {
    document.getElementById("pedido-info").value = JSON.stringify(pedido)
    
}