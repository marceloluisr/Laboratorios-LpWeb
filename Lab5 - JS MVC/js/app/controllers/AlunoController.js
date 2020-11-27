class AlunoController {    
    constructor() {
        let $ = document.querySelector.bind(document);
       
        this._inputNome = $('#nome');
        this._inputNota1 = $('#nota1');
        this._inputNota2 = $('#nota2');
        this._inputFrequencia = $("#pct_frequencia");
        this._inputNotaFinal = $("#prova_final");


        this._aluno = new Aluno(); 
        this._alunoView = new AlunoView($('#js-aluno-view') );
        this._alunoView.update(this._aluno);
        
        this._mensagem = new Mensagem();
        this._mensagemView = new MensagemView($('#js-mensagem-view') );
        this._mensagemView.update(this._mensagem);
    }
    
    adiciona(event) {
        event.preventDefault();

        let item = this._criaItemAluno();
        let alunoService = new AlunoService(item);
        
        let aprov = alunoService.validarAprovacao(item);
        item.aprovado = aprov;
        
        this._aluno.adiciona(item); 
        this._alunoView.update(this._aluno);

        this._limpaFormulario();

        this._mensagem.texto = `${item.nome} foi adicionado com sucesso.`;
        this._mensagemView.update(this._mensagem );
    }

    _criaItemAluno() {
        return new ItemAluno(
            this._inputNome.value,
            this._inputNota1.value,
            this._inputNota2.value,
            this._inputFrequencia.value,
            this._inputNotaFinal.value,
            false
        );
    }

    _limpaFormulario() {
        this._inputNome.value = '';
        this._inputNota1.value = '';
        this._inputNota2.value = '';
        this._inputFrequencia.value = '';
        this._inputNotaFinal.value = '';

        this._inputNome.focus();
    }
}