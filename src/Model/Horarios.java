/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Time;

/**
 *
 * @author Sysadmin
 */
public class Horarios {
    
    private int id;
    private int FilmeId;
    private Time Horario_inicio;
    private Time Horario_fim;
    private int TicketsDisponiveis;

    public Horarios(int id, int FilmeId, Time Horario_inicio, Time Horario_fim, int TicketsDisponiveis) {
        this.id = id;
        this.FilmeId = FilmeId;
        this.Horario_inicio = Horario_inicio;
        this.Horario_fim = Horario_fim;
        this.TicketsDisponiveis = TicketsDisponiveis;
        
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilmeId() {
        return FilmeId;
    }

    public void setFilmeId(int FilmeId) {
        this.FilmeId = FilmeId;
    }

    public Time getHorario_inicio() {
        return Horario_inicio;
    }

    public void setHorario_inicio(Time Horario_inicio) {
        this.Horario_inicio = Horario_inicio;
    }

    public Time getHorario_fim() {
        return Horario_fim;
    }

    public void setHorario_fim(Time Horario_fim) {
        this.Horario_fim = Horario_fim;
    }

    public int getTicketsDisponiveis() {
        return TicketsDisponiveis;
    }

    public void setTicketsDisponiveis(int TicketsDisponiveis) {
        this.TicketsDisponiveis = TicketsDisponiveis;
    }
    
    }



   