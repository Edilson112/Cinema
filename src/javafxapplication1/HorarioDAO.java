package javafxapplication1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HorarioDAO {

    private Connection connect;

    // Construtor para iniciar a conexão
    public HorarioDAO() {
        connect = database.connectDb(); 
    }

    // Método para adicionar horários automaticamente após adicionar um filme
    public boolean adicionarHorariosAutomaticos(int filmeId, String duracaoFilme, int ticketsDisponiveis) {
        try {
            // Conversão da duração do filme (formato "HH:mm") para um objeto LocalTime
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            LocalTime duracao = LocalTime.parse(duracaoFilme, formatter);

            // O primeiro horário começa às 11:00
            LocalTime horarioInicio = LocalTime.of(11, 0);
            LocalTime horarioFim = horarioInicio.plusHours(duracao.getHour()).plusMinutes(duracao.getMinute());

            // Inserir o primeiro horário
            inserirHorario(filmeId, Time.valueOf(horarioInicio), Time.valueOf(horarioFim), ticketsDisponiveis);

            // O segundo horário começa após o primeiro + 15 minutos
            LocalTime horarioInicio2 = horarioFim.plusMinutes(15);
            LocalTime horarioFim2 = horarioInicio2.plusHours(duracao.getHour()).plusMinutes(duracao.getMinute());

            // Inserir o segundo horário
            inserirHorario(filmeId, Time.valueOf(horarioInicio2), Time.valueOf(horarioFim2), ticketsDisponiveis);

            // O terceiro horário começa após o segundo, sem intervalo
            LocalTime horarioInicio3 = horarioFim2.plusMinutes(15);
            LocalTime horarioFim3 = horarioInicio3.plusHours(duracao.getHour()).plusMinutes(duracao.getMinute());

            // Inserir o terceiro horário
            inserirHorario(filmeId, Time.valueOf(horarioInicio3), Time.valueOf(horarioFim3), ticketsDisponiveis);

            return true; // Se tudo deu certo, retorna true
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Se houver erro, retorna false
        }
    }

    // Método para inserir o horário no banco de dados
    private void inserirHorario(int filmeId, Time horarioInicio, Time horarioFim, int ticketsDisponiveis) throws SQLException {
        String sql = "INSERT INTO horario (id_filme, Horario_Inicio, horario_fim, tickets_disponiveis) VALUES (?, ?, ?, ?)";

        PreparedStatement prepare = connect.prepareStatement(sql);
        prepare.setInt(1, filmeId);
        prepare.setTime(2, horarioInicio);
        prepare.setTime(3, horarioFim);
        prepare.setInt(4, ticketsDisponiveis);
        
        prepare.executeUpdate();
    }
}
