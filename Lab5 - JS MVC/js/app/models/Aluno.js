class Aluno {
   
    constructor() {
        this._itens = [];
    }

    adiciona (item) {
        this._itens.push(item );
    }

    getItens() {
       //return this._itens;
       return [].concat(this._itens );
    }

    getQuantidade() {
        let quant = this._itens.length;
        if(quant != 0) {
            return quant;
        } 
    }

}