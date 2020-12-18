package com.ifma.livraria_api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isbn")
    @NotNull(message = "ISBN obrigatório.")
    @NotEmpty
    @Length(min = 10, max = 13, message = "ISBN deve ser no minímo 10 e no máximo 13")
    private String isbn;

    @Column(name = "nome")
    @NotNull(message = "Nome do livro obrigatório.")
    @NotEmpty
    @Length(max = 40, message = "Nome do livro muito longo.")
    private String nomeLivro;

    @Column(name = "editora")
    @NotNull(message = "Editora do livro obrigatória.")
    @NotEmpty
    private String editoraLivro;

    @Column(name = "ano")
    @NotNull(message = "Ano de publicação do livro obrigatório.")
    private Long anoPublicacaoLivro;

    @Column(name = "assunto")
    @Length(max = 100, message = "Assunto descrito muito longo.")
    private String assunto;

    public Livro() {

    }

    public Livro(String isbn, String nomeLivro, String editoraLivro, Long anoPublicacaoLivro, String assunto) {
        this.isbn = isbn;
        this.nomeLivro = nomeLivro;
        this.editoraLivro = editoraLivro;
        this.anoPublicacaoLivro = anoPublicacaoLivro;
        this.assunto = assunto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getEditoraLivro() {
        return editoraLivro;
    }

    public void setEditoraLivro(String editoraLivro) {
        this.editoraLivro = editoraLivro;
    }

    public Long getAnoPublicacaoLivro() {
        return anoPublicacaoLivro;
    }

    public void setAnoPublicacaoLivro(Long anoPublicacaoLivro) {
        this.anoPublicacaoLivro = anoPublicacaoLivro;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    @Override
    public String toString() {
        return "Livro[id=" + id + ", anoPublicacaoLivro=" + anoPublicacaoLivro + ", assunto=" + assunto
                + ", editoraLivro=" + editoraLivro + ", isbn=" + isbn + ", nomeLivro=" + nomeLivro + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Livro other = (Livro) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
