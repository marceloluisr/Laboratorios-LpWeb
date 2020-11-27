class AlunoView extends View {

    constructor(elemento) {
        super(elemento);
    }

    _template(aluno) {

        return `
        <table class="table table-hover table-bordered">
            <thead>
                <tr>
                    <th>NOME</th>
                    <th>NOTA 1</th>
                    <th>NOTA 2</th>
                    <th>MÉDIA PARCIAL</th>
                    <th>% FREQUÊNCIA</th>
                    <th>NOTA FINAL</th>
                    <th>MÉDIA FINAL</th>
                    <th>SITUAÇÃO</th>
                </tr>
            </thead>
        
            <tbody>
                ${aluno.getItens().map(item => `
                    
                    <tr>
                        <td>${item.nome}</td>
                        <td>${item.nota1}</td>
                        <td>${item.nota2}</td>
                        <td>${item.calcularMedia()}</td>
                        <td>${item.frequencia}</td>
                        <td>${item.notaFinal}</td>
                        <td>${item.calcularMediaFinal()}</td>
                        <td>${item.situacao()}</td>
                    </tr>
                    
                `).join('')}                
            </tbody>

           <tfoot>
                <td colspan="8"></td>
                <td>
                <p>Aprovados: </p>${aluno.getItens().reduce(function(total, item) {
                    //console.log(item.notaFinal);
                    if (item.isAprovado()) {
                        total = total + 1;
                    } 
                    return total;
                    
                }, 0)}
                </td>

                <td>
                <p>Reprovados: </p>${aluno.getItens().reduce(function(total, item) {
                    
                    if (!item.isAprovado()) {
                        total = total + 1;
                    } 
                    return total;
                    
                }, 0)}
                </td>
                

                <td>
                <p>Média geral: </p>${(aluno.getItens().reduce((total, item) => 
                                                total + item.calcularMedia(), 0.0)/aluno.getQuantidade()).toFixed(2)}
                </td>
            </tfoot>
            
        </table>
        `;
    }
}

