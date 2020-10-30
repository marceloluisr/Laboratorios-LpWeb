function carregarSearchBar() {
    document.getElementById("barra-pesquisa").innerHTML = 
        '<div class="input-group" style="position:relative;right:1rem"><input placeholder="Pesquise no Book.net" type="text" class="form-control form-control-range"><button type="button" class="btn btn-success"><span style="color:white;">IR</button></span> </div>';   
}

function adicionarCarrinho() {
    document.getElementById("items-carrinho").innerHTML = 
    '<table class="table table-striped table-hover table-bordered"><thead> <tr><th>Id</th> <th>Nome</th><th class="d-none d-sm-table-cell">Autor</th><th class="d-none d-sm-table-cell">Cadastro</th> <th class="d-none d-sm-table-cell">Comprado</th><th class="d-none d-sm-table-cell">Alugado</th><th class="d-none d-sm-table-cell">Reservado</th></tr></thead><tbody><tr><td scope="row">1</td><td>Dom Casmurro</td><td class="d-none d-sm-table-cell">Machado de Assis</td><td class="d-none d-sm-table-cell">10/02/1998</td><td class="d-none d-sm-table-cell"><span class="btn btn-success btn-sm disabled" type="button">Sim</span></td><td class="d-none d-sm-table-cell"><span class="btn btn-success btn-sm disabled" type="button">Sim</span></td><td class="d-none d-sm-table-cell"><span class="btn btn-success btn-sm disabled" type="button">Sim</span></td></tr></tbody></table>'
    
}