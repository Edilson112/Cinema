/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Sysadmin
 */
public class FilmesData {
    
    private Integer id;
    private  String titulo;
    private  String genero;
   private String duracao;
    private String image;
    private Date data;
    private String actual;
    private String descricao;
    private String trailer;
    private Boolean status;
    

    public FilmesData(Integer id, String titulo, String genero, String duracao, String image, Date data, String actual, String descricao, String trailer, Boolean status) {
        this.id= id;
        this.titulo=titulo;
        this.genero=genero;
        this.duracao = duracao;
        this.image = image;
        this.data = data;
        this.actual=actual;
        this.descricao=descricao;
        this.trailer=trailer;
        this.status=status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }
    
            



    
   
}
