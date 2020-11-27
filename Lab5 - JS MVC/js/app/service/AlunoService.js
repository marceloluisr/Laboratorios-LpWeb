class AlunoService { 

    constructor(aluno) {
        this._aluno = aluno;

        Object.freeze(this);
    }

    /*
    criarAlunoServive(aluno) {
        return new AlunoService(aluno);
    }
    */

    validarAprovacao() {
        let media = this._aluno.calcularMedia();
        let frequencia = this._aluno.frequencia;
        let notaProvaFinal = this._aluno.notaFinal;

        if(frequencia >= 75) {
            if(media >= 7) {
                return true;
            } else {
                return this._validarProvaFinal(media, notaProvaFinal);
            }
        }
    }

    _validarProvaFinal(media, notaProvaFinal) {
        if(media >= 3 && media < 7) {
            if((media + notaProvaFinal)/2 < 5) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }
    
}