/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Sysadmin
 */
public class ClienteData {
    
  private int id;
  private String tipo;
  private String titulo;
  private int quantidade;
  private double total;
  private Date data;
  private Time tempo;

    public ClienteData(int id, String tipo, String titulo,int quantidade, double total, Date data, Time tempo) {
        this.id = id;
        this.tipo = tipo;
        this.titulo=titulo;
        this.quantidade = quantidade;
        this.total = total;
        this.data = data;
        this.tempo=tempo;
    }

    public Time getTempo() {
        return tempo;
    }

    public void setTempo(Time tempo) {
        this.tempo = tempo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    



    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    

}
