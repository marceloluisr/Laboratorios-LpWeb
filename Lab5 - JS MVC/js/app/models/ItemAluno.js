class ItemAluno {
    constructor(nome, nota1, nota2, frequencia, nota_Final, aprovado) {
        this._nome = nome;
        this._nota1 = Number(nota1);
        this._nota2 = Number(nota2);
        this._frequencia = Number(frequencia);
        this._notaFinal = this.calcularMedia() > 7 ? 0.0:Number(nota_Final);
        this._aprovado = aprovado;

        //Object.freeze(this);
    }

    calcularMedia() { // todo para CALCULARMEDIA
        let aux = [];
        aux.push(this._nota1, this._nota2);
        let acu = 0;
        for (let index = 0; index < aux.length; index++) {
            acu = acu + aux[index];
        }
        
        let media = acu/2;
        
        return media;              
    }

    get nome() {
        return this._nome;
    }
    
    set nome(nome) {
        this._nome = nome;
    }

    get nota1() {
        return this._nota1;
    }
    
    get nota2() {
        return this._nota2;
    }

    get frequencia() {
        return this._frequencia;
    }

    
    set frequencia(freq) {
        this._frequencia = freq;
    }
    
    get notaFinal() {
        return this._notaFinal;
    }

    /*
    set notaFinal(nota) {
        //console.log(this.calcularMedia())
        if(this.calcularMedia() > 7 ) {
            this._notaFinal = 0.0;
        } else {
            this._notaFinal = nota;
        }
    }
    */

    calcularMediaFinal() {
        if(this._notaFinal > 0.0) {
            return (this._notaFinal + this.calcularMedia()) / 2;
        } else {
            return this.calcularMedia();
        }
    }
    
    situacao() {
        if(this._aprovado == true) {
            return "Aprovado";
        } else {
            return "Reprovado";
        }
    }

    isAprovado() {
        if(this._aprovado == true) {
            return true;
        } else {
            return false;
        }
    }

    set aprovado(novo) {
        this._aprovado = novo;
    }

    
}