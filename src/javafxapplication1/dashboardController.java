/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import Model.FuncionarioData;
import Model.ClienteData;
import Model.FilmesData;



import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.util.Date;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Sysadmin
 */


public class dashboardController implements Initializable {

    @FXML
    private ComboBox<String> availableMovies_metodoPagamento;

    @FXML
private TableView<FuncionarioData> tabelaFuncionario_Pendentes;

@FXML
private TableColumn<FuncionarioData, String> tabela_funcionario_col_Cargo1;

@FXML
private TableColumn<FuncionarioData, String> tabela_funcionario_col_email1;

@FXML
private TableColumn<FuncionarioData, Double> tabela_funcionario_col_salario1;

@FXML
private TableColumn<FuncionarioData, String> tabela_funcionario_col_user1;

     @FXML
    private Canvas canvas_cinema;
    
    @FXML
    private AnchorPane top_cinema;
    
    @FXML
    private ImageView A;
    
        @FXML
    private ImageView Cinema_C;
        
        
    @FXML
    private ImageView E;
    
     @FXML
    private ImageView I;

    @FXML
    private ImageView M;
    
     @FXML
    private ImageView N;

    @FXML
    private ImageView Numero24;

       @FXML
    private Canvas particleCanvas11;
       
    @FXML
    private ImageView Cinema_ImageView1;

    @FXML
    private ImageView Cinema_ImageView2;

    @FXML
    private ImageView Cinema_ImageView3;

    @FXML
    private ImageView Cinema_ImageView4;

    @FXML
    private AnchorPane Cinema_filmsDisponiveis;

    @FXML
    private Label Cinema_tituloImageView1;

    @FXML
    private Label Cinema_tituloImageView2;

    @FXML
    private Label Cinema_tituloImageView3;

    @FXML
    private Label Cinema_tituloImageView4;
        @FXML
    private AnchorPane cinema_form;
        
    @FXML
    private Button CInema24_btn;
    
    @FXML
    private Canvas particleCanvas1;
    
      @FXML
    private AnchorPane Dashboard_FilmeAnalise;

    @FXML
    private AnchorPane Dashboard_FilmesDisponiveis;

    @FXML
    private ImageView Dashboard_ImageView1;

    @FXML
    private ImageView Dashboard_ImageView2;

    @FXML
    private ImageView Dashboard_ImageView3;

    @FXML
    private ImageView Dashboard_ImageView4;

    @FXML
    private AnchorPane Dashboard_MelhoresVendas;

    @FXML
    private TableView<ClienteData> Dashboard_TableFilmeAnalise;

   

    @FXML
    private TableView<?> Dashboard_tableMelhoresVendas;

    @FXML
    private Label Dashboard_tituloImageView1;

    @FXML
    private Label Dashboard_tituloImageView2;

    @FXML
    private Label Dashboard_tituloImageView3;

    @FXML
    private Label Dashboard_tituloImageView4;

    

    @FXML
    private TableColumn<ClienteData, Integer> Dashboard_tableFIlme_col_ticketsVendidos;

    @FXML
    private TableColumn<ClienteData, String> Dashboard_tableFIlme_col_titulo;

    @FXML
    private TableColumn<ClienteData,Double> Dashboard_tableFIlme_col_ganhos;

  @FXML
    private Label filmDesc_data;

    @FXML
    private ImageView filmDesc_imagem;

    @FXML
    private Label filmDesc_tituloFilm;
    
    @FXML
    private Button availableMovies_refreshbtn;
    
    @FXML
    private Label availableMovies_tickets;
    
     @FXML
    private Button funcionario_Actualizar;

    @FXML
    private Button funcionario_Despromover;

    @FXML
    private TextField funcionario_Salario;

    @FXML
    private TextField funcionario_User;

    @FXML
    private TextField funcionario_cargo;

    @FXML
    private Button funcionario_demitir;

    @FXML
    private TextField funcionario_email;

    @FXML
    private Button funcionario_promover;

    @FXML
    private AnchorPane funcionario_tela;

    @FXML
    private Button funcionarios_btn;

 


@FXML
private TableColumn<FuncionarioData, String> tabela_funcionario_col_Cargo;

@FXML
private TableColumn<FuncionarioData, String> tabela_funcionario_col_email;

@FXML
private TableColumn<FuncionarioData, Double> tabela_funcionario_col_salario;

@FXML
private TableColumn<FuncionarioData, String> tabela_funcionario_col_user;



@FXML
private TableView<FuncionarioData> tabela_funcionarios;

private ObservableList<FuncionarioData> listaFuncionarios;


    
    
    @FXML
    private Button Close;

    @FXML
    private TableColumn<ClienteData, String> Costumers_Col_Data;

    @FXML
    private Label dashBoard_totalsoldTickets;

    @FXML
    private Label dashboard_filmesdisponiveis;

    @FXML
    private Label dashboard_money;


    @FXML
    private TextField Costumers_Col_Search;
    
    
    @FXML
    private TableView<ClienteData> Costumers_tableView;

    @FXML
    private TableColumn<ClienteData, String> Costumers_Col_tempo;

    @FXML
    private TableColumn<ClienteData, String> Costumers_Col_tickets;

    @FXML
    private TableColumn<ClienteData, String> Costumers_Col_titulo;

    @FXML
    private Label Costumers_ControleData;

    @FXML
    private Label Costumers_ControleTempo;

    @FXML
    private Label Costumers_Ticket;
    
    
    @FXML
    private Button filmeDesc_PAUSE;

    @FXML
    private Label Costumers_TicketFilme;

    @FXML
    private Label Costumers_Titulo;

    @FXML
    private Button Costumers_btn;

    @FXML
    private Button Costumers_deleteBtn;

    @FXML
    private AnchorPane Costumers_form;

    @FXML
    private Button Costumers_limparBtn;

    @FXML
    private Button Dashboard_btn;

    @FXML
    private AnchorPane Ed;

    @FXML
    private Button Editing_Screen_btn;

    
    @FXML
    private Button filmeDesc_voltarClnt;
    
    private final List<Particle> particles = new ArrayList<>(); 
   
   
    private final Random random = new Random();
    
  
    @FXML
    private Button AvailableMovies_butaoDetalhes;
    
    @FXML
    private DatePicker addMovies_Data;

    @FXML
    private TextField addMovies_Duracao;
    
    
    @FXML
    private TextField add_movies_descricao;
    
        @FXML
    private Button add_movies_trailer;

          @FXML
    private ComboBox<String> availableMovies_Horarios;

    @FXML
    private TextField addMovies_Genero;

    @FXML
    private TextField addMovies_Titulo;

    @FXML
    private Button addMovies_actualizarbtn;

    @FXML
    private TableColumn<FilmesData, String> addMovies_col_data;

    @FXML
    private TableColumn<FilmesData, String> addMovies_col_duracao;

    @FXML
    private TableColumn<FilmesData, String> addMovies_col_genero;

    @FXML
    private TableColumn<FilmesData, String> addMovies_col_titulo;

    @FXML
    private ImageView addMovies_imageView;
    
    
    @FXML
    private Button MostrarDetalhesBtn;

    @FXML
    private Button addMovies_deletebtn;

    @FXML
    private AnchorPane addMovies_form;

    @FXML
    private AnchorPane addMovies_image;

    @FXML
    private Button addMovies_import;

    @FXML
    private Button addMovies_inserirbtn;

    @FXML
    private Button addMovies_limparbtn;

    @FXML
    private TextField addMovies_search;

    @FXML
    private TableView<FilmesData> addMovies_tableView;
    
   @FXML
    private Canvas canvasParticles;
    
    @FXML
    private Button add_Movies_btn;

    @FXML
    private Label availableMovies_NormalClasse_price;

    @FXML
    private Label availableMovies_Total;

    @FXML
    private Button availableMovies_btn;

    @FXML
    private TableColumn<FilmesData, String> availableMovies_col_Genero;

    @FXML
    private TableColumn<FilmesData, String> availableMovies_col_data;

    @FXML
    private TableColumn<FilmesData, String> availableMovies_col_titulo;

    @FXML
    private Button availableMovies_comprarBtn;

    @FXML
    private Label availableMovies_data;

    @FXML
    private AnchorPane availableMovies_form;

    @FXML
    private Label availableMovies_genero;

        @FXML
    private ImageView availableMovies_imageView;

    @FXML
    private Button availableMovies_limparbtn;

    @FXML
    private Spinner<Integer> availableMovies_normalClass_quantity;
       
    @FXML
    private AnchorPane filmdesc_anchorTrailer;

    @FXML
    private Button availableMovies_recibobtn;

    @FXML
    private Button availableMovies_selecionarBtn;

    @FXML
    private Label availableMovies_specialClasse_price;

    @FXML
    private Spinner<Integer> availableMovies_specialClasse_quantity;

    @FXML
    private TableView<FilmesData> availableMovies_tableView;

    @FXML
    private Label availableMovies_titulo;

    @FXML
    private Label availableMovies_tituloFIlme;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private AnchorPane dashboard_totalGanhos;

    @FXML
    private AnchorPane dashboard_totalfilmes;

    @FXML
    private AnchorPane dashboard_totaltickets;
    
        @FXML
    private AnchorPane FilmeDesc_form;
      
     @FXML
    private Label filmDesc_Descricao;

    @FXML
    private Label filmDesc_Genero;
        
          @FXML
    private Button filmeDesc_start;

    @FXML
    private Button filmeDesc_voltar;


    @FXML
    private MediaView filmDesc_VideoTrailer;

    
 

    @FXML
    private AnchorPane filmeDesc_trailer;


    @FXML
    private ComboBox<?> editScreening_Actual;

    @FXML
    private Button editScreening_ActualizarBtn;

    @FXML
    private Button editScreening_RemoverBtn;

    @FXML
    private TextField editScreening_Search;

    @FXML
    private TableColumn<FilmesData, String> editScreening_col_Actual;

    @FXML
    private TableColumn<FilmesData, String> editScreening_col_Duracao;

    @FXML
    private TableColumn<FilmesData, String> editScreening_col_genero;

    @FXML
    private TableColumn<FilmesData, String> editScreening_col_titulo;

    @FXML
    private AnchorPane editScreening_form;

    @FXML
    private ImageView editScreening_imageview;

    @FXML
    private TableView<FilmesData> editScreening_tableView;

    @FXML
    private Label editScreening_titulo;

    @FXML
    private Button minimize;

    @FXML
    private AnchorPane painelEsquerdo;

    @FXML
    private Button signout;

    @FXML
    private Label username;

    @FXML
    private AnchorPane topForm;

    @FXML
    private Button funcionario_limpar;
    
    
    @FXML
    private TextField funcionario_search;
    
    private Image image;
    
        @FXML
    private TextField addmovies_Tickets;
    
     
    @FXML
    private Canvas particleCanvas; 

    
     ObservableList<FuncionarioData> listaFuncionariosPendentes = FXCollections.observableArrayList();

    private double x = 0;
    private double y = 0;

    //ferramentas da base de dados
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    
    private SpinnerValueFactory<Integer> spinner1;
    private SpinnerValueFactory<Integer> spinner2;
    
   
   
   private float price1=0;
   private float price2=0;
   private float total =0;
   private int qty1=0;
   private int qty2=0;
   
   public void carregarFilmesMaisVendidos(ObservableList<ClienteData> clientes) {
    // Map para agrupar os filmes e somar os tickets vendidos
    Map<String, Integer> filmeTicketsMap = new HashMap<>();
    // Map para calcular o valor total arrecadado por filme
    Map<String, Double> filmeArrecadadoMap = new HashMap<>();

    // Loop através dos clientes para agrupar os tickets e somar o valor arrecadado por filme
    for (ClienteData cliente : clientes) {
        String filme = cliente.getTitulo();  // Obtém o título do filme
        int tickets = cliente.getQuantidade();  // Obtém a quantidade de tickets vendidos
        double totalArrecadado = cliente.getTotal();  // Calcula o total arrecadado por esse cliente

        // Se o filme já está no map, soma os tickets, caso contrário, adiciona
        filmeTicketsMap.put(filme, filmeTicketsMap.getOrDefault(filme, 0) + tickets);
        
        // Se o filme já está no map, soma o valor arrecadado, caso contrário, adiciona
        filmeArrecadadoMap.put(filme, filmeArrecadadoMap.getOrDefault(filme, 0.0) + totalArrecadado);
    }

    // Ordenar os filmes pelos tickets vendidos (maior para menor)
    List<Map.Entry<String, Integer>> filmesOrdenados = filmeTicketsMap.entrySet()
            .stream()
            .sorted((f1, f2) -> f2.getValue().compareTo(f1.getValue()))  // Ordenar de forma decrescente
            .collect(Collectors.toList());

    // Criar uma lista observável para a TableView
    ObservableList<ClienteData> listaFilmes = FXCollections.observableArrayList();

    // Adicionar os dados do map ordenado para a lista de filmes
    for (Map.Entry<String, Integer> entry : filmesOrdenados) {
        String filmeTitulo = entry.getKey();
        int ticketsVendidos = entry.getValue();
        double arrecadadoTotal = filmeArrecadadoMap.get(filmeTitulo);  // Obtém o valor arrecadado do outro map

        // Criamos uma instância de ClienteData com o título, tickets e total arrecadado
        listaFilmes.add(new ClienteData(0, "", filmeTitulo, ticketsVendidos, arrecadadoTotal, null, null));
    }

    // Vincular as colunas definidas no FXML às propriedades da classe ClienteData
    Dashboard_tableFIlme_col_titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
    Dashboard_tableFIlme_col_ticketsVendidos.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
    
    // Adicionar coluna para exibir o valor arrecadado
    Dashboard_tableFIlme_col_ganhos.setCellValueFactory(new PropertyValueFactory<>("total"));  // Usamos 'total' para o valor arrecadado

    // Define os dados da lista observável na TableView
    Dashboard_TableFilmeAnalise.setItems(listaFilmes);
}

   
   
   public void loadDashboardMovies() {
    // Obter a lista de filmes disponíveis
    AvailableMoviesList = availableMoviesList();

    // Limpar as ImageView e Label (caso haja menos de 4 filmes)
    clearDashboardImagesAndTitles();

    // Loop para preencher até 4 filmes
    for (int i = 0; i < AvailableMoviesList.size() && i < 4; i++) {
        FilmesData movie = AvailableMoviesList.get(i);
        String imagePath = "file:" + movie.getImage();
        Image image = new Image(imagePath, 226, 291, false, true); // Ajustar o tamanho conforme necessário
        
        switch (i) {
            case 0:
                Dashboard_tituloImageView1.setText(movie.getTitulo());
                Dashboard_ImageView1.setImage(image);
                break;
            case 1:
                Dashboard_tituloImageView2.setText(movie.getTitulo());
                Dashboard_ImageView2.setImage(image);
                break;
            case 2:
                Dashboard_tituloImageView3.setText(movie.getTitulo());
                Dashboard_ImageView3.setImage(image);
                break;
            case 3:
                Dashboard_tituloImageView4.setText(movie.getTitulo());
                Dashboard_ImageView4.setImage(image);
                break;
        }
        
        
    }
    
      
}

// Método para limpar as ImageView e Label caso haja menos de 4 filmes
private void clearDashboardImagesAndTitles() {
 
    Dashboard_tituloImageView1.setText("");
    Dashboard_ImageView1.setImage(null);

    Dashboard_tituloImageView2.setText("");
    Dashboard_ImageView2.setImage(null);

    Dashboard_tituloImageView3.setText("");
    Dashboard_ImageView3.setImage(null);

    Dashboard_tituloImageView4.setText("");
    Dashboard_ImageView4.setImage(null);
}

public void setupCinemaImageClickEvents() {
    // Listener para a primeira imagem do cinema
    Cinema_ImageView1.setOnMouseClicked(event -> {
        if (AvailableMoviesList != null && AvailableMoviesList.size() > 0) {
            FilmesData movie = AvailableMoviesList.get(0); // Primeiro filme
            updateSelectedMovieDetails1(movie); // Atualiza os detalhes com o primeiro filme
            FilmeDesc_form.setVisible(true); // Exibe a tela de detalhes
             cinema_form.setVisible(false);
        }
    });

    // Listener para a segunda imagem do cinema
    Cinema_ImageView2.setOnMouseClicked(event -> {
        if (AvailableMoviesList != null && AvailableMoviesList.size() > 1) {
            FilmesData movie = AvailableMoviesList.get(1); // Segundo filme
            updateSelectedMovieDetails1(movie); // Atualiza os detalhes com o segundo filme
            FilmeDesc_form.setVisible(true); // Exibe a tela de detalhes
             cinema_form.setVisible(false);
        }
    });

    // Listener para a terceira imagem do cinema
    Cinema_ImageView3.setOnMouseClicked(event -> {
        if (AvailableMoviesList != null && AvailableMoviesList.size() > 2) {
            FilmesData movie = AvailableMoviesList.get(2); // Terceiro filme
            updateSelectedMovieDetails1(movie); // Atualiza os detalhes com o terceiro filme
            FilmeDesc_form.setVisible(true); // Exibe a tela de detalhes
            cinema_form.setVisible(false);
        }
    });

    // Listener para a quarta imagem do cinema
    Cinema_ImageView4.setOnMouseClicked(event -> {
        if (AvailableMoviesList != null && AvailableMoviesList.size() > 3) {
            FilmesData movie = AvailableMoviesList.get(3); // Quarto filme
            updateSelectedMovieDetails1(movie); // Atualiza os detalhes com o quarto filme
            FilmeDesc_form.setVisible(true); // Exibe a tela de detalhes
             cinema_form.setVisible(false);
        }
    });
}



public void navigateToMovieDetails(FilmesData movie) {
    // Verificar se o filme é válido
    if (movie != null) {
        // Salvar os detalhes do filme selecionado no objeto `getData`
        getData.path = movie.getImage();
        getData.titulo = movie.getTitulo();
        getData.FilmeId = movie.getId();  
        getData.Trailerpath = movie.getTrailer();

        // Atualizar os detalhes do filme na tela de descrição
        updateSelectedMovieDetails();

        // Tornar visível o formulário de detalhes do filme
        FilmeDesc_form.setVisible(true);
    } else {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText("Não foi possível carregar os detalhes do filme.");
        alert.showAndWait();
    }
}

 

public void loadCinemaMovies() {
    // Obter a lista de filmes disponíveis
    AvailableMoviesList = availableMoviesList();

    // Limpar as ImageView e Label (caso haja menos de 4 filmes)
    clearDashboardImagesAndTitles();

    // Loop para preencher até 4 filmes
    for (int i = 0; i < AvailableMoviesList.size() && i < 4; i++) {
        FilmesData movie = AvailableMoviesList.get(i);
        String imagePath = "file:" + movie.getImage();
        Image image = new Image(imagePath, 226, 291, false, true); 
        
        switch (i) {
            case 0:
                Cinema_tituloImageView1.setText(movie.getTitulo());
                Cinema_ImageView1.setImage(image);
                break;
            case 1:
               Cinema_tituloImageView2.setText(movie.getTitulo());
                Cinema_ImageView2.setImage(image);
                break;
            case 2:
                Cinema_tituloImageView3.setText(movie.getTitulo());
                Cinema_ImageView3.setImage(image);
                break;
            case 3:
                Cinema_tituloImageView4.setText(movie.getTitulo());
                Cinema_ImageView4.setImage(image);
                break;
        }
    }
     setupCinemaImageClickEvents();
}

// Método para limpar as ImageView e Label caso haja menos de 4 filmes
private void clearCinemaImagesAndTitles() {
 
    Cinema_tituloImageView1.setText("");
    Cinema_ImageView1.setImage(null);

    Cinema_tituloImageView2.setText("");
    Cinema_ImageView2.setImage(null);

    Cinema_tituloImageView3.setText("");
    Cinema_ImageView3.setImage(null);

    Cinema_tituloImageView4.setText("");
    Cinema_ImageView4.setImage(null);
}
   
   public void funcionariosTableView(){
       
    ObservableList<FuncionarioData> listaFuncionarios = FXCollections.observableArrayList();
    String sql = "SELECT * FROM admin WHERE cargo != 'cliente' AND status = true"; // Exclui 'cliente' e só mostra os com status true

    connect = database.connectDb();

    try {
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();

        while (result.next()) {
            FuncionarioData funcionario = new FuncionarioData(
                    result.getInt("id"),
                    result.getString("email"),
                    result.getString("username"),
                    result.getString("cargo"),
                    result.getDouble("salario"),
                    result.getBoolean("status")
            );
            listaFuncionarios.add(funcionario);
        }

        // Atribuir os valores da tabela
        tabela_funcionario_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        tabela_funcionario_col_user.setCellValueFactory(new PropertyValueFactory<>("username"));
        tabela_funcionario_col_Cargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        tabela_funcionario_col_salario.setCellValueFactory(new PropertyValueFactory<>("salario"));

        // Exibe os funcionários na TableView
        tabela_funcionarios.setItems(listaFuncionarios);

    } catch (Exception e) {
        e.printStackTrace();
    }
}
   
public ObservableList<FuncionarioData> funcionariosList() {

    ObservableList<FuncionarioData> listData = FXCollections.observableArrayList();

    String sql = "SELECT * FROM admin WHERE status = true"; // Apenas funcionários com status true (ativos)

    connect = database.connectDb();

    try {
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();

        FuncionarioData funcData;

        while (result.next()) {
            funcData = new FuncionarioData(result.getInt("id"),
                                           result.getString("email"),
                                           result.getString("username"),
                                           result.getString("cargo"),
                                           result.getDouble("salario"),
                                           result.getBoolean("status"));

            listData.add(funcData);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return listData;
}

   
  
   
  private int totalMovies;

public void totalAvailableMovies() {
    String sql = "SELECT COUNT(id) AS total FROM filme WHERE status =true AND actual = 'Em exibicao'";

    connect = database.connectDb();

    try {
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();

        if (result.next()) {
            totalMovies = result.getInt("total");  // Usando o alias "total" definido no SQL
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

   
   public void displayTotalMovies(){
       totalAvailableMovies();
       dashboard_filmesdisponiveis.setText(String.valueOf(totalMovies));
   }
   
       
   
   
   private double totalIncome;
   public void totalIncomeToday(){
       
       
       Date date= new Date();
       java.sql.Date sqlDate= new java.sql.Date(date.getTime());
       
       String sql= "SELECT SUM(total) FROM cliente WHERE data='" + String.valueOf(sqlDate)+ "'";
       
       
       connect= database.connectDb();
       
       try {
           
           prepare= connect.prepareStatement(sql);
           result= prepare.executeQuery();
           
           if(result.next()){
               totalIncome= result.getDouble("SUM(total)");
               
               
           }
           
       } catch (Exception e) {e.printStackTrace();}
       
   }
   
   public void displayTotalIncomeToday(){
       totalIncomeToday();
       dashboard_money.setText(String.valueOf(totalIncome));
   }
   
   private int soldTicket;

public void countTicket() {
    String sql = "SELECT SUM(quantidade) AS totalTickets FROM cliente";  // Somando a coluna 'quantidade'

    connect = database.connectDb();

    try {
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();

        if (result.next()) {
            soldTicket = result.getInt("totalTickets");  // Acessa o total de tickets vendidos
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

          
       
           
      
   
   
   public void displayTotalSoldTicket(){
       countTicket();
       dashBoard_totalsoldTickets.setText(String.valueOf(soldTicket));
       
   }
   
   
   // Método para exibir o botão quando o mouse entrar no AnchorPane
    @FXML
    private void handleMouseEnter() {
        filmeDesc_start.setVisible(true);
    }

    // Método para ocultar o botão quando o mouse sair do AnchorPane
    @FXML
    private void handleMouseExit() {
        filmeDesc_start.setVisible(false);
       
    }
    
    @FXML
private void handleStartClick() {
    playTrailer();  // Chama o método para iniciar o trailer
    
    // Oculta o botão "Start" e exibe o botão "Pause"
    filmeDesc_start.setVisible(false);
    filmeDesc_PAUSE.setVisible(true);
}

@FXML
private void handlePauseClick() {
    pauseTrailer();  // Chama o método para pausar o trailer
    
    // Oculta o botão "Pause" e exibe o botão "Start"
    filmeDesc_PAUSE.setVisible(false);
    filmeDesc_start.setVisible(true);
}

public void aprovarFuncionario() {
    // Obter o funcionário selecionado
    FuncionarioData funcionarioSelecionado = tabelaFuncionario_Pendentes.getSelectionModel().getSelectedItem();

    if (funcionarioSelecionado != null) {
        String sql = "UPDATE admin SET status = true WHERE username = ?";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, funcionarioSelecionado.getUsername());
            prepare.executeUpdate();

            // Atualizar a tabela após aprovação
            listaFuncionariosPendentes.remove(funcionarioSelecionado);
            tabelaFuncionario_Pendentes.refresh();

            // Exibir mensagem de sucesso
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Aprovação de Funcionário");
            alert.setHeaderText(null);
            alert.setContentText("Funcionário " + funcionarioSelecionado.getUsername() + " foi aprovado com sucesso!");
            alert.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        // Exibir erro se nenhum funcionário for selecionado
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro de Aprovação");
        alert.setHeaderText(null);
        alert.setContentText("Por favor, selecione um funcionário para aprovar.");
        alert.showAndWait();
        
        funcionariosTableView();
        
    }
}

public void carregarFuncionariosPendentes() {
 
            
    String sql = "SELECT email, username, cargo, salario FROM admin WHERE status = false";

    connect = database.connectDb();

    try {
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();

        while (result.next()) {
            String email = result.getString("email");
            String username = result.getString("username");
            String cargo = result.getString("cargo");
            double salario = result.getDouble("salario");

            FuncionarioData funcionario = new FuncionarioData(email, username, cargo, salario);
            listaFuncionariosPendentes.add(funcionario);
        }

        // Definir as colunas com os valores
        tabela_funcionario_col_email1.setCellValueFactory(new PropertyValueFactory<>("email"));
        tabela_funcionario_col_user1.setCellValueFactory(new PropertyValueFactory<>("username"));
        tabela_funcionario_col_Cargo1.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        tabela_funcionario_col_salario1.setCellValueFactory(new PropertyValueFactory<>("salario"));

        // Carregar a lista na tabela
        tabelaFuncionario_Pendentes.setItems(listaFuncionariosPendentes);

    } catch (Exception e) {
        e.printStackTrace();
    }
}
   
   

public void searchFuncionario(){
    FilteredList<FuncionarioData> filter= new FilteredList<>(listaFuncionarios, e ->true);
    
    funcionario_search.textProperty().addListener((observable, odlValue, newValue) ->{
        
        filter.setPredicate(predicateFuncionario -> {
            
            if(newValue.isEmpty() || newValue == null){
                return true;
            }
            String searchKey = newValue.toLowerCase();
            
            if(String.valueOf(predicateFuncionario.getId()).contains(searchKey)){
                return true;
            }else if(predicateFuncionario.getUsername().toLowerCase().contains(searchKey)){
                return true;
            }else if(predicateFuncionario.getEmail().toLowerCase().contains(searchKey)){
                return true;
               
            }else if(predicateFuncionario.getCargo().toLowerCase().contains(searchKey)){
                return true;
            }else if(String.valueOf(predicateFuncionario.getSalario()).contains(searchKey)){
                return true;
            }else{
            return false;
            }
            
        });
    });
        
        SortedList<FuncionarioData>sort= new SortedList<>(filter);
        
        sort.comparatorProperty().bind(tabela_funcionarios.comparatorProperty());
        tabela_funcionarios.setItems(sort);
                
}

public void atualizarFuncionario() {
    FuncionarioData funcionarioSelecionado = tabela_funcionarios.getSelectionModel().getSelectedItem();

    if (funcionarioSelecionado != null) {
        String sql = "UPDATE admin SET email = ?, username = ?, cargo = ?, salario = ? WHERE id = ?";

        connect = database.connectDb();

        try {
            // Verificar se todos os campos estão preenchidos
            if (funcionario_email.getText().isEmpty() ||
                funcionario_User.getText().isEmpty() ||
                funcionario_cargo.getText().isEmpty() ||
                funcionario_Salario.getText().isEmpty()) {

                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Mensagem de Erro");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, preencha todos os campos.");
                alert.showAndWait();
                return;
            }

            // Prepara a SQL para atualizar os dados do funcionário
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, funcionario_email.getText());
            prepare.setString(2, funcionario_User.getText());
            prepare.setString(3, funcionario_cargo.getText()); // Cargo é um campo de texto
            prepare.setDouble(4, Double.parseDouble(funcionario_Salario.getText()));
            prepare.setInt(5, funcionarioSelecionado.getId());

            int resultado = prepare.executeUpdate();

            Alert alert;
            if (resultado > 0) {
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Mensagem de Informação");
                alert.setHeaderText(null);
                alert.setContentText("Funcionário atualizado com sucesso!");
                alert.showAndWait();

                // Atualiza a lista de funcionários após a atualização
               funcionariosTableView();
            } else {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Mensagem de Erro");
                alert.setHeaderText(null);
                alert.setContentText("Erro ao atualizar o funcionário.");
                alert.showAndWait();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText("Por favor, selecione um funcionário para atualizar.");
        alert.showAndWait();
    }
}




public void demitirFuncionario() {
    FuncionarioData funcionarioSelecionado = tabela_funcionarios.getSelectionModel().getSelectedItem();

    if (funcionarioSelecionado != null) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmar Demissão");
        alert.setHeaderText(null);
        alert.setContentText("Você tem certeza que deseja demitir o funcionário " + funcionarioSelecionado.getUsername() + "?");

        ButtonType cancelar = new ButtonType("Cancelar");
        ButtonType continuar = new ButtonType("Continuar");

        alert.getButtonTypes().setAll(cancelar, continuar);

        alert.showAndWait().ifPresent(response -> {
            if (response == continuar) {
                // Atualiza o status do funcionário para false (demitido)
                String sql = "UPDATE admin SET status = false WHERE id = ?";

                connect = database.connectDb();

                try {
                    prepare = connect.prepareStatement(sql);
                    prepare.setInt(1, funcionarioSelecionado.getId());

                    int resultado = prepare.executeUpdate();

                    Alert resultadoAlert;
                    if (resultado > 0) {
                        resultadoAlert = new Alert(AlertType.INFORMATION);
                        resultadoAlert.setTitle("Mensagem de Informação");
                        resultadoAlert.setHeaderText(null);
                        resultadoAlert.setContentText("Funcionário " + funcionarioSelecionado.getUsername() + " demitido com sucesso!");
                        resultadoAlert.showAndWait();

                        // Atualiza a lista de funcionários após a demissão
                        funcionariosTableView();
                    } else {
                        resultadoAlert = new Alert(AlertType.ERROR);
                        resultadoAlert.setTitle("Mensagem de Erro");
                        resultadoAlert.setHeaderText(null);
                        resultadoAlert.setContentText("Erro ao demitir o funcionário.");
                        resultadoAlert.showAndWait();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Alert cancelAlert = new Alert(AlertType.INFORMATION);
                cancelAlert.setTitle("Cancelado");
                cancelAlert.setHeaderText(null);
                cancelAlert.setContentText("Ação de demitir " + funcionarioSelecionado.getUsername() + " foi cancelada.");
                cancelAlert.showAndWait();
            }
        });

    } else {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText("Por favor, selecione um funcionário para demitir.");
        alert.showAndWait();
    }
}








   public void searchCustomer(){
       
       FilteredList<ClienteData> filter= new FilteredList<>(custList, e -> true);
       
       Costumers_Col_Search.textProperty().addListener((observable, oldValue, newValue) -> {
       
       filter.setPredicate(predicateCustomer -> {
           
           if(newValue.isEmpty() || newValue == null){
               return true;
                   }
           
           String searchKey = newValue.toLowerCase();
           
           if(String.valueOf(predicateCustomer.getId()).contains(searchKey)) {
               return true;
           }else if(predicateCustomer.getTitulo().toLowerCase().contains(searchKey)){
               return true;
           }else if(predicateCustomer.getData().toString().contains(searchKey)){
               return true;
           }else{
              return false;
           }
           
           
         
           
       });
       });
       
       SortedList<ClienteData> sort=new SortedList<>(filter);
       
       sort.comparatorProperty().bind(Costumers_tableView.comparatorProperty());
       Costumers_tableView.setItems(sort);
       
   }
   
   
   
public ObservableList<ClienteData> customerList() {
   
    ObservableList<ClienteData> CustomerL = FXCollections.observableArrayList();
   
    // Modificando a consulta SQL para selecionar apenas clientes com Status igual a true (ou 1)
    String sql = "SELECT * FROM cliente WHERE Status = 1";
   
    connect = database.connectDb();
   
    try {
        ClienteData customerD;
       
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();
       
        while (result.next()) {
           
            customerD = new ClienteData(
                result.getInt("id"), 
                result.getString("tipo"),
                result.getString("TituloFilme"),
                result.getInt("quantidade"),
                result.getDouble("total"),
                result.getDate("data"),
                result.getTime("tempo"),
                result.getString("assentos_comprados"),
                result.getString("metodo_pagamento"),
                result.getBoolean("Status")
            );
           
            CustomerL.add(customerD);
        }
       
    } catch (Exception e) {
        e.printStackTrace();
    }
    return CustomerL;
}

       
   private ObservableList<ClienteData> custList;
   
   public void showCustomerList(){
       custList = customerList();
       
       Costumers_Col_tickets.setCellValueFactory(new PropertyValueFactory<>("id"));
       Costumers_Col_titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
       Costumers_Col_Data.setCellValueFactory(new PropertyValueFactory<>("data"));
       Costumers_Col_tempo.setCellValueFactory(new PropertyValueFactory<>("tempo"));
       
       Costumers_tableView.setItems(custList);
   }
       
   public void SelectFuncionarioList(){
       FuncionarioData funcD= tabela_funcionarios.getSelectionModel().getSelectedItem();
       int num= tabela_funcionarios.getSelectionModel().getSelectedIndex();
       
       if((num -1) < -1){
           return;
       }
       
       funcionario_User.setText(funcD.getUsername());
       funcionario_email.setText(funcD.getEmail());
       funcionario_cargo.setText(funcD.getCargo());
       funcionario_Salario.setText(String.valueOf(funcD.getSalario()));
   }
   
   
   public void SelectCustomerList(){
       
       ClienteData CustD = Costumers_tableView.getSelectionModel().getSelectedItem();
       int num= Costumers_tableView.getSelectionModel().getSelectedIndex();
       
       if((num -1) < -1){
           return;
       }
       
       Costumers_Ticket.setText(String.valueOf(CustD.getId()));
       Costumers_Titulo.setText(CustD.getTitulo());
       Costumers_ControleData.setText(String.valueOf(CustD.getData()));
       Costumers_ControleTempo.setText(String.valueOf(CustD.getTempo()));
       
   }
   
   
  public void deleteCustomer(){
    
    String sql = "UPDATE cliente SET status = 0 WHERE id = '" + Costumers_Ticket.getText() + "'";
    
    connect = database.connectDb();
    
    try {
        
        Alert alert;
        
        statement = connect.createStatement();
        
        if(Costumers_Ticket.getText().isEmpty() ||
           Costumers_Titulo.getText().isEmpty() ||
           Costumers_ControleTempo.getText().isEmpty() ||
           Costumers_ControleData.getText().isEmpty()) {
            
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Mensagem de Erro");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione o cliente primeiro.");
            alert.showAndWait();
        } else {
            
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Mensagem de Confirmação");
            alert.setHeaderText(null);
            alert.setContentText("Tem certeza que deseja desativar " + Costumers_Titulo.getText() + "?");
            
            Optional<ButtonType> option = alert.showAndWait();
            
            if(option.isPresent() && option.get() == ButtonType.OK) {
                
                // Executa o update para alterar o status para 0 em vez de excluir
                statement.executeUpdate(sql);
                
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mensagem de Informação");
                alert.setHeaderText(null);
                alert.setContentText("Desativado com sucesso!");
                alert.showAndWait();
                
                showCustomerList();
                clearCustomer();
                
            } else {
                return;
            }
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (statement != null) statement.close();
            if (connect != null) connect.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

   public void clearFuncionario(){
       funcionario_User.setText("");
       funcionario_email.setText("");
       funcionario_cargo.setText("");
       funcionario_Salario.setText("");
   }
   
   public void clearCustomer(){
     
       Costumers_Ticket.setText("");
       Costumers_Titulo.setText("");
       Costumers_ControleData.setText("");
       Costumers_ControleTempo.setText("");
        
   }
   
   
   public void receipt(){
       if(total>0){
       
       HashMap hash= new HashMap();
       hash.put("recibo", num);
       
        try {
            JasperDesign jDesign= JRXmlLoader.load("C:\\Users\\Sysadmin\\Documents\\NetBeansProjects\\JavaFXApplication1\\src\\javafxapplication1\\report.jrxml");
            JasperReport jReport = JasperCompileManager.compileReport(jDesign);
            JasperPrint jPrint = JasperFillManager.fillReport(jReport, hash, connect);
            
            JasperViewer.viewReport(jPrint,false);
            
            
        } catch (JRException ex) {
            
        }
       }else{
       
           Alert alert= new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Mensagem de Erro");
           alert.setHeaderText(null);
           alert.setContentText("Invalido");
           alert.showAndWait();
       
   }}
   
  private int num;
  private int qty;
   

@FXML
public void buy() {
    
    Boolean Status = true; 
     
    String sqlCliente = "INSERT INTO cliente(tipo, TituloFilme, quantidade, total, data, tempo, assentos_comprados, metodo_pagamento, Status) VALUES(?,?,?,?,?,?,?,?,?)";
    String sqlInfoCliente = "INSERT INTO info_cliente(id_cliente, tipo, quantidade, total, TituloFilme) VALUES(?,?,?,?,?)";
    connect = database.connectDb();

    String tipo = "";
    if (price1 > 0 && price2 == 0) {
        tipo = "Classe Especial";
    } else if (price2 > 0 && price1 == 0) {
        tipo = "Classe Normal";
    } else if (price2 > 0 && price1 > 0) {
        tipo = "Classe Normal e Especial";
    }

    Date data = new Date();
    java.sql.Date setDate = new java.sql.Date(data.getTime());

    String horarioInicio = availableMovies_Horarios.getSelectionModel().getSelectedItem();
    String metodoPagamento = (String) availableMovies_metodoPagamento.getSelectionModel().getSelectedItem();

    try {
        LocalTime localTime = LocalTime.now();
        Time time = Time.valueOf(localTime);
        qty = qty1 + qty2;

        // Verificações de quantidade e seleção de filme
        if (qty <= 0) {
            showErrorAlert("Quantidade Inválida", "A quantidade de tickets deve ser maior que zero.");
            return;
        }

        if (availableMovies_imageView.getImage() == null || availableMovies_titulo.getText().isEmpty()) {
            showErrorAlert("Erro", "Por favor, selecione o filme primeiro.");
            return;
        } 
        
        if (price1 == 0 && price2 == 0) {
            showErrorAlert("Erro", "Por favor, indique a quantidade de tickets que deseja comprar.");
            return;
        }

        if (horarioInicio == null || horarioInicio.isEmpty()) {
            showErrorAlert("Erro", "Por favor, selecione um horário para o filme.");
            return;
        }

        if (metodoPagamento == null || metodoPagamento.isEmpty()) {
            showErrorAlert("Erro", "Por favor, selecione um método de pagamento.");
            return;
        }

        // Verificar disponibilidade de tickets
        String sqlCheckTickets = "SELECT tickets_disponiveis FROM horario WHERE id_filme = ? AND Horario_Inicio = ?";
        prepare = connect.prepareStatement(sqlCheckTickets);
        prepare.setInt(1, getData.FilmeId);
        prepare.setString(2, horarioInicio);
        result = prepare.executeQuery();

        int ticketsDisponiveis = 0;
        if (result.next()) {
            ticketsDisponiveis = result.getInt("tickets_disponiveis");
        }

        availableMovies_tickets.setText("Tickets disponíveis: " + ticketsDisponiveis);

        if (ticketsDisponiveis <= 0) {
            showErrorAlert("Tickets Indisponíveis", "Desculpe, não há mais tickets disponíveis para este horário.");
            return;
        } else if (ticketsDisponiveis < qty) {
            showErrorAlert("Tickets Insuficientes", "Desculpe, apenas " + ticketsDisponiveis + " tickets estão disponíveis para este horário.");
            return;
        }

        // Lista de assentos comprados
        StringBuilder assentosComprados = new StringBuilder();
        for (int i = ticketsDisponiveis; i > ticketsDisponiveis - qty; i--) {
            assentosComprados.append(i).append(",");
        }
        assentosComprados.setLength(assentosComprados.length() - 1);

        // Atualizar tickets disponíveis no banco
        String sqlUpdateHorario = "UPDATE horario SET tickets_disponiveis = tickets_disponiveis - ? WHERE id_filme = ? AND Horario_Inicio = ?";
        prepare = connect.prepareStatement(sqlUpdateHorario);
        prepare.setInt(1, qty);
        prepare.setInt(2, getData.FilmeId);
        prepare.setString(3, horarioInicio);
        prepare.executeUpdate();
        
       

        // Inserção na tabela cliente
        prepare = connect.prepareStatement(sqlCliente, Statement.RETURN_GENERATED_KEYS);
        prepare.setString(1, tipo);
        prepare.setString(2, availableMovies_titulo.getText());
        prepare.setString(3, String.valueOf(qty));
        prepare.setString(4, String.valueOf(total));
        prepare.setString(5, String.valueOf(setDate));
        prepare.setString(6, String.valueOf(time));
        prepare.setString(7, assentosComprados.toString());
        prepare.setString(8, metodoPagamento);  // 
        prepare.setBoolean(9, Status); //
        prepare.executeUpdate();

        // Obtém o ID do cliente recém-inserido e atribui a `num`
        ResultSet generatedKeys = prepare.getGeneratedKeys();
        if (generatedKeys.next()) {
            num = generatedKeys.getInt(1);  // Atribui o ID gerado a `num`
        }

        // Inserção na tabela info_cliente
        prepare = connect.prepareStatement(sqlInfoCliente);
        prepare.setInt(1, num); // Usa `num` como ID do cliente
        prepare.setString(2, tipo);
        prepare.setInt(3, qty);
        prepare.setDouble(4, total);
        prepare.setString(5, availableMovies_titulo.getText());
        prepare.executeUpdate();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mensagem de Informação");
        alert.setHeaderText(null);
        alert.setContentText("Pagamento realizado com sucesso!\nAssentos comprados: " + assentosComprados.toString());
        alert.showAndWait();

        clearPurchaseTicketInfo();

    } catch (Exception e) {
        e.printStackTrace();
    }
}




// Método auxiliar para mostrar alertas de erro
private void showErrorAlert(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
}




public void carregarMetodosPagamento() {
    availableMovies_metodoPagamento.getItems().clear(); 
    availableMovies_metodoPagamento.getItems().addAll("Mpesa", "POS"); 
}

 








// Método para configurar o listener na ComboBox de horários
public void setupHorariosListener() {
    availableMovies_Horarios.setOnAction(event -> {
        String horarioSelecionado = availableMovies_Horarios.getSelectionModel().getSelectedItem(); 
        if (horarioSelecionado != null && !horarioSelecionado.isEmpty()) {
            atualizarTicketsDisponiveis(horarioSelecionado);  // Atualiza os tickets disponíveis para o horário selecionado
        } else {
            // Limpa a label caso nenhum horário seja selecionado
            availableMovies_tickets.setText("Tickets disponíveis: 0");
        }
    });
}


// Método para atualizar a label com os tickets disponíveis
// Método para atualizar a label com os tickets disponíveis
public void atualizarTicketsDisponiveis(String horarioInicio) {
    try {
        String sqlCheckTickets = "SELECT tickets_disponiveis FROM horario WHERE id_filme = ? AND Horario_Inicio = ?";
        prepare = connect.prepareStatement(sqlCheckTickets);
        prepare.setInt(1, getData.FilmeId); // Pega o id do filme selecionado
        prepare.setString(2, horarioInicio); // Usa o horário selecionado na combo box
        result = prepare.executeQuery();

        int ticketsDisponiveis = 0;
        if (result.next()) {
            ticketsDisponiveis = result.getInt("tickets_disponiveis");
        }

        // Atualiza a label com os tickets disponíveis
        availableMovies_tickets.setText("Tickets disponíveis: " + ticketsDisponiveis);

    } catch (SQLException e) {
        e.printStackTrace();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText("Erro ao buscar os tickets disponíveis: " + e.getMessage());
        alert.showAndWait();
    }
}





    
   public void clearPurchaseTicketInfo(){
       
       spinner1=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0);
       spinner2=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0);
       
       availableMovies_specialClasse_quantity.setValueFactory(spinner1);
       availableMovies_normalClass_quantity.setValueFactory(spinner2);
       
       availableMovies_specialClasse_price.setText("0.0 Mts");
       availableMovies_NormalClasse_price.setText("0.0 Mts");
       availableMovies_Total.setText("0.0 Mts");
       availableMovies_tickets.setText("Tickets disponíveis: 0");
       
       availableMovies_imageView.setImage(null);
       availableMovies_titulo.setText("");
           
   }
    public void showSpinnerValue(){
        
        spinner1= new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0);
        
        spinner2= new  SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0);
        
        availableMovies_normalClass_quantity.setValueFactory(spinner2);
        availableMovies_specialClasse_quantity.setValueFactory(spinner1);
            
    }
    
    public void getSpinnerValue(MouseEvent event){
        
        qty1=availableMovies_specialClasse_quantity.getValue();
        qty2= availableMovies_normalClass_quantity.getValue();
        
        price1= (qty1 * 230);
        price2= (qty2 * 100);
        
        total= (price1 +price2);
        
        availableMovies_specialClasse_price.setText(String.valueOf(price1) + " Mts" );
        availableMovies_NormalClasse_price.setText( String.valueOf(price2) + " Mts" );
        
        availableMovies_Total.setText(String.valueOf(total) + "Mts");
        
        
    }
    
    
  public ObservableList<FilmesData> availableMoviesList() {

    ObservableList<FilmesData> ListAvMovies = FXCollections.observableArrayList();

    // Modificação na consulta SQL para incluir o filtro pelo status true
    String sql = "SELECT * FROM filme WHERE actual = 'Em exibicao' AND status = true";

    connect = database.connectDb();

    try {

        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();

        FilmesData movD;

        while (result.next()) {

            movD = new FilmesData(result.getInt("id"),
                    result.getString("TituloFilme"),
                    result.getString("genero"),
                    result.getString("duracao"),
                    result.getString("imagem"),
                    result.getDate("data"),
                    result.getString("actual"),
                    result.getString("descricao"),
                    result.getString("trailer"),
                    result.getBoolean("status"));

            ListAvMovies.add(movD);

        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return ListAvMovies;
}

  
  private ObservableList<FilmesData> AvailableMoviesList;
  
  public void showAvailableMovies(){
    AvailableMoviesList= availableMoviesList();
    availableMovies_col_titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
    availableMovies_col_Genero.setCellValueFactory(new PropertyValueFactory<>("genero"));
    availableMovies_col_data.setCellValueFactory(new PropertyValueFactory<>("data"));
    
    availableMovies_tableView.setItems(AvailableMoviesList);
  }
  
public void selectAvailableMovies() {
    // Obter o item selecionado da tabela
    FilmesData movD = availableMovies_tableView.getSelectionModel().getSelectedItem();
    int num = availableMovies_tableView.getSelectionModel().getSelectedIndex();
    
    // Verificar se a seleção é válida
    if ((num - 1) < -1) {
        return;
    }

    // Preencher os campos com os dados do filme selecionado
    availableMovies_tituloFIlme.setText(movD.getTitulo());
    availableMovies_genero.setText(movD.getGenero());
    availableMovies_data.setText(String.valueOf(movD.getData()));
    

    // Salvar o caminho da imagem e do título no objeto getData
    getData.path = movD.getImage();
    getData.titulo = movD.getTitulo();
    getData.FilmeId = movD.getId();  

    
    // Adicionar o caminho do trailer ao objeto getData
    getData.Trailerpath = movD.getTrailer(); // Certifique-se de que o método getTrailer() exista no seu modelo FilmesData
}

public void loadAvailableHorarios(int id_filme) {
    String sql = "SELECT Horario_Inicio FROM horario WHERE id_filme = ?";

    try {
        // Limpa a ComboBox antes de adicionar novos horários
        availableMovies_Horarios.getItems().clear();

        connect = database.connectDb();
        prepare = connect.prepareStatement(sql);
        prepare.setInt(1, id_filme);
        result = prepare.executeQuery();

        LocalTime currentTime = LocalTime.now(); // Hora atual

        // Criar uma lista observável para armazenar os horários
        ObservableList<String> horariosList = FXCollections.observableArrayList();

        while (result.next()) {
            // Obtém o horário de início do banco de dados e converte para LocalTime
            Time horarioInicio = result.getTime("Horario_Inicio");
            LocalTime horarioLocal = horarioInicio.toLocalTime();

            // Verifica se o horário ainda é válido (depois da hora atual)
            if (horarioLocal.isAfter(currentTime)) {
                // Adiciona o horário na lista observável
                horariosList.add(horarioLocal.toString());
            }
        }

        // Atualiza a ComboBox com a lista de horários
        availableMovies_Horarios.setItems(horariosList);
        

      
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (connect != null) connect.close();
            if (prepare != null) prepare.close();
            if (result != null) result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}









public void updateSelectedMovieDetails() {
    
    FilmesData selectedMovie = availableMovies_tableView.getSelectionModel().getSelectedItem();
    
    
    if (selectedMovie != null) {
        
        filmDesc_tituloFilm.setText(selectedMovie.getTitulo());
        
       
        filmDesc_Genero.setText("Genero: " + selectedMovie.getGenero());
        
        
        filmDesc_data.setText("Data: " +String.valueOf(selectedMovie.getData())); // Converter data para String
        
        filmDesc_Descricao.setText("Descricao: " + selectedMovie.getDescricao());
        
        // Define a imagem do filme na 'ImageView' filmDesc_imagem
        String imagePath = "file:" + selectedMovie.getImage(); // Obtém o caminho da imagem
        Image image = new Image(imagePath, 226, 291, false, true); // Ajuste o tamanho conforme necessário
        filmDesc_imagem.setImage(image);
    } else {
        // Caso não haja filme selecionado, exibe uma mensagem de erro
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText("Nenhum filme foi selecionado.");
        alert.showAndWait();
    }
}


public void updateSelectedMovieDetails1(FilmesData selectedMovie) {
    if (selectedMovie != null) {
        // Atualizar os detalhes do filme
        filmDesc_tituloFilm.setText(selectedMovie.getTitulo());
        filmDesc_Genero.setText("Genero: " + selectedMovie.getGenero());
        filmDesc_data.setText("Data: " + String.valueOf(selectedMovie.getData()));
        filmDesc_Descricao.setText("Descricao: " + selectedMovie.getDescricao());

        // Definir a imagem do filme
        String imagePath = "file:" + selectedMovie.getImage(); // Caminho da imagem
        Image image = new Image(imagePath, 226, 291, false, true); // Ajuste de tamanho
        filmDesc_imagem.setImage(image);

        // Carregar e exibir o trailer do filme
        String trailerPath = selectedMovie.getTrailer();
        if (trailerPath != null && !trailerPath.isEmpty()) {
            File trailerFile = new File(trailerPath);
            if (trailerFile.exists()) {
                String trailerURI = trailerFile.toURI().toString();
                Media media = new Media(trailerURI);

                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                }

                mediaPlayer = new MediaPlayer(media);
                filmDesc_VideoTrailer.setMediaPlayer(mediaPlayer);
                filmDesc_VideoTrailer.setFitWidth(914);  
                filmDesc_VideoTrailer.setFitHeight(514); 
                filmDesc_VideoTrailer.setPreserveRatio(true);

                mediaPlayer.setOnReady(() -> {
                    mediaPlayer.pause(); // Pause o trailer para não reproduzir automaticamente
                });
            } else {
                // Caso o arquivo do trailer não seja encontrado
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("O arquivo do trailer não foi encontrado.");
                alert.showAndWait();
            }
        } else {
            // Caso o trailer não esteja disponível
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Trailer do filme não disponível.");
            alert.showAndWait();
        }
    } else {
        // Caso não haja filme selecionado, exibe uma mensagem de erro
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText("Nenhum filme foi selecionado.");
        alert.showAndWait();
    }
}





  
  private MediaPlayer mediaPlayer;
  
public void SelectMovie() {
    Alert alert;

    
    
    if (availableMovies_tituloFIlme.getText().isEmpty() 
        || availableMovies_genero.getText().isEmpty()
        || availableMovies_data.getText().isEmpty()) {
        
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Mensagem de Erro");
        alert.setHeaderText(null);
        alert.setContentText("Por favor selecione o filme primeiro");
        alert.showAndWait();
    } else {
        String imagePath = "file:" + getData.path;
        image = new Image(imagePath, 255, 307, false, true);
        availableMovies_imageView.setImage(image);
        availableMovies_titulo.setText(getData.titulo);

        availableMovies_tituloFIlme.setText("");
        availableMovies_genero.setText("");
        availableMovies_data.setText("");

        try {
            String trailerPath = getData.Trailerpath;  

            if (trailerPath != null && !trailerPath.isEmpty()) {
                File trailerFile = new File(trailerPath);
                if (trailerFile.exists()) {
                    String trailerURI = trailerFile.toURI().toString();
                    Media media = new Media(trailerURI);

                    if (mediaPlayer != null) {
                        mediaPlayer.stop();
                    }

                    mediaPlayer = new MediaPlayer(media);
                    filmDesc_VideoTrailer.setMediaPlayer(mediaPlayer);
                    filmDesc_VideoTrailer.setFitWidth(900);
                    filmDesc_VideoTrailer.setFitHeight(500);
                    filmDesc_VideoTrailer.setPreserveRatio(true);

                    mediaPlayer.setOnReady(() -> {
                        mediaPlayer.pause();
                    });
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText(null);
                    alert.setContentText("O arquivo do trailer não foi encontrado.");
                    alert.showAndWait();
                }
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Trailer do filme não disponível.");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Erro ao carregar o trailer: " + e.getMessage());
            alert.showAndWait();
        }

        // Carregar horários disponíveis para o filme selecionado
        int selectedMovieId = getData.FilmeId;
        System.out.println("ID do filme selecionado: " + selectedMovieId); // Depuração
        loadAvailableHorarios(selectedMovieId); // Carrega os horários usando o ID do filme
        
       availableMovies_Horarios.setVisible(false);
       
      updateSelectedMovieDetails();
        
    }
}




  
  public void playTrailer() {
    if (mediaPlayer != null) {
        mediaPlayer.play();  // Iniciar a reprodução
    } else {
        System.out.println("Nenhum trailer carregado.");
    }
}
  
  
  public void pauseTrailer() {
    if (mediaPlayer != null) {
        mediaPlayer.pause();  // Pausar a reprodução
    } else {
        System.out.println("Nenhum trailer carregado.");
    }
}

  
  
    
    private String[] currentList= {"Em exibicao", "Fim de Exibicao"};
    
    public void comboBox(){
        
        List<String> listCurrent= new ArrayList<>();
        
        for(String data: currentList){
            listCurrent.add(data);
        }
        
        ObservableList listC= FXCollections.observableArrayList(listCurrent);
        editScreening_Actual.setItems(listC);
          
    }
    
    
    public void updateEditScreening(){
    
    // Contagem de filmes com 'Em exibicao'
    String countSql = "SELECT COUNT(id) FROM filme WHERE actual = 'Em exibicao'";
    
    String sql = "UPDATE filme SET actual= '" 
            +editScreening_Actual.getSelectionModel().getSelectedItem() 
            + "' WHERE TituloFilme = '" +editScreening_titulo.getText() + "'";
    
    connect = database.connectDb();
    
    try {
        statement = connect.createStatement();
        result = statement.executeQuery(countSql);
        
        int totalEmExibicao = 0;
        
        if (result.next()) {
            totalEmExibicao = result.getInt(1); // Obtém o número de filmes com 'Em exibicao'
        }
        
        Alert alert;
        
        // Verifica se já existem 4 filmes 'Em exibicao'
        if (editScreening_titulo.getText().isEmpty() ||
            editScreening_imageview.getImage() == null ||
            editScreening_Actual.getSelectionModel().isEmpty()) {
            
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Mensagem de Erro");
            alert.setHeaderText(null);
            alert.setContentText("Por favor selecione o Filme primeiro.");
            alert.showAndWait();
            
        } else if (totalEmExibicao >= 4 && 
                   editScreening_Actual.getSelectionModel().getSelectedItem().equals("Em exibicao")) {
            
            // Se já houverem 4 filmes 'Em exibicao', exibe erro
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Você não pode adicionar mais de 4 filmes com o status 'Em exibicao'.");
            alert.showAndWait();
            
        } else {
            // Realiza a atualização se tudo estiver certo
            statement.executeUpdate(sql);
            
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensagem de Informacao");
            alert.setHeaderText(null);
            alert.setContentText("Filme Atualizado com sucesso!");
            alert.showAndWait();
            
            // Atualiza a tela
            showEditScreening();
            clearEditScreening();
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    
    public void clearEditScreening(){
        
        editScreening_titulo.setText("");
        editScreening_imageview.setImage(null);
        
        
    }
    
    
    public void searchEditScreening(){
        FilteredList<FilmesData> filter= new FilteredList(editScreeningL, e -> true);
        editScreening_Search.textProperty().addListener((Observable, oldValue, newValue) ->{
        
        filter.setPredicate(predicatedFilmesData ->{
            
            if(newValue.isEmpty() || newValue == null){
                return true;
            }
        
                
                String searchKey= newValue.toLowerCase();
                
                if(predicatedFilmesData.getTitulo().toLowerCase().contains(searchKey)){
                    return true;
                }else if(predicatedFilmesData.getGenero().toLowerCase().contains(searchKey)){
                    return true;
                }else if(predicatedFilmesData.getDuracao().toLowerCase().contains(searchKey)){
                    return true;
                }else if(predicatedFilmesData.getActual().toLowerCase().contains(searchKey)){
                    return true;
                }
                
                return false;
        
           
    });
    });
        
        
     SortedList<FilmesData> sortData= new SortedList<>(filter);
     
     sortData.comparatorProperty().bind(editScreening_tableView.comparatorProperty());
     
     editScreening_tableView.setItems(sortData);
    }
    
    public void selectEditScreening(){
        
       FilmesData movD= editScreening_tableView.getSelectionModel().getSelectedItem();
       int num = editScreening_tableView.getSelectionModel().getFocusedIndex();
       
       if((num -1) < -1 ){
           return;
       }
        
       String uri= "file:" + movD.getImage();
       
       image= new Image(uri,327,343,false,true);
       editScreening_imageview.setImage(image);
       
       editScreening_titulo.setText(movD.getTitulo());
       
       
       
       
    }
    
    //Edit Sreening
    
public ObservableList<FilmesData> editSreeningList() {
    ObservableList<FilmesData> editList = FXCollections.observableArrayList();
    
    // Ajuste a consulta para filtrar apenas os filmes com status true
    String sql = "SELECT * FROM filme WHERE status = true";
    
    connect = database.connectDb();

    try {
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();

        FilmesData movD;

        while (result.next()) {
            movD = new FilmesData(
                result.getInt("id"),
                result.getString("TituloFilme"),
                result.getString("genero"),
                result.getString("duracao"),
                result.getString("imagem"),
                result.getDate("data"),
                result.getString("Actual"),
                result.getString("descricao"),
                result.getString("trailer"),
                result.getBoolean("status")  // Verifica se o campo status é booleano
            );

            editList.add(movD);
        }

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Fechar conexões corretamente
        try {
            if (result != null) result.close();
            if (prepare != null) prepare.close();
            if (connect != null) connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return editList;
}

    
    private ObservableList<FilmesData> editScreeningL;
    public void showEditScreening(){
        editScreeningL= editSreeningList();
        
        editScreening_col_titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        editScreening_col_genero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        editScreening_col_Duracao.setCellValueFactory(new PropertyValueFactory<>("duracao"));
        editScreening_col_Actual.setCellValueFactory(new PropertyValueFactory<>("actual"));
        
        editScreening_tableView.setItems(editScreeningL);
        
    }
    
     
    public void searchAddMovies(){
        
        FilteredList <FilmesData> filter = new FilteredList(listAddMovies, e -> true);
        
        addMovies_search.textProperty().addListener((observable, oldValue, newValue)  ->{
            
            filter.setPredicate(predicateFilmesData ->{
                
                if( newValue.isEmpty() || newValue == null){
                    return true;
                }
                
                String KeySearch = newValue.toLowerCase();
                
                if(predicateFilmesData.getTitulo().toLowerCase().contains(KeySearch)){
                    return true;
                }
                        
                
                        
                        
                return false;
            
                
            });
              
            
        });
        
        SortedList<FilmesData> sortData = new SortedList<>(filter);
                sortData.comparatorProperty().bind(addMovies_tableView.comparatorProperty());
                
                addMovies_tableView.setItems(sortData);
        
        
    }
    
    

    public void importImage() {

        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new ExtensionFilter("Image File", "*png", "*jpg"));

        Stage stage = (Stage) addMovies_form.getScene().getWindow();
        File file = open.showOpenDialog(stage);

        if (file != null) {
            image = new Image(file.toURI().toString(), 235, 338, false, true);
            addMovies_imageView.setImage(image);

            //o caminho da imagem  : )
            getData.path = file.getAbsolutePath();
        }

    }
    
    
   public void importVideo() {
    FileChooser open = new FileChooser();
    open.setTitle("Open Video File");
    // Adiciona filtros para formatos de vídeo suportados
    open.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Video Files", "*.mp4", "*.mkv", "*.avi", "*.mov")
    );

    // Obtém a janela principal
    Stage stage = (Stage) addMovies_form.getScene().getWindow();
    
    File file = open.showOpenDialog(stage);

    if (file != null) {
        
        getData.Trailerpath = file.getAbsolutePath(); // Armazena o caminho do vídeo
        
        
        System.out.println("Video selected: " + getData.Trailerpath);
    }
}
   
 
   
   




    

    
    private int countId;
    
    
    public void FilmeId(){
        
        String sql= "SELECT count(id) FROM filme";
        
        connect = database.connectDb();
        
        try {
            
            prepare= connect.prepareStatement(sql);
            result= prepare.executeQuery();
            
            
            if(result.next()){
                 getData.FilmeId=result.getInt("count(id)");
            }
          
            
        } catch (Exception e) {e.printStackTrace();
        }
        
    }

public void insertAddMovies() {

    String sqll = "SELECT * FROM filme WHERE TituloFilme = '" + addMovies_Titulo.getText() + "'";
    connect = database.connectDb();

    Alert alert;

    try {

        statement = connect.createStatement();
        result = statement.executeQuery(sqll);

        if (result.next()) {

            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Mensagem de Erro");
            alert.setHeaderText(null);
            alert.setContentText(addMovies_Titulo.getText() + " JÁ EXISTE!");
            alert.showAndWait();

        } else {

            // Verifica se algum campo está vazio
            if (addMovies_Titulo.getText().isEmpty()
                    || addMovies_Genero.getText().isEmpty()
                    || addMovies_Duracao.getText().isEmpty()
                    || addMovies_imageView.getImage() == null
                    || addMovies_Data.getValue() == null
                    || add_movies_descricao.getText().isEmpty()
                    || addmovies_Tickets.getText().isEmpty()
                    || getData.Trailerpath == null || getData.Trailerpath.isEmpty()) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Mensagem de Erro");
                alert.setHeaderText(null);
                alert.setContentText("Preencha todos os espaços em branco!");
                alert.showAndWait();

            } else {

                // Número de tickets padrão inserido pelo usuário
                int defaultTickets = Integer.parseInt(addmovies_Tickets.getText());

                // Validação do número de tickets
                if (defaultTickets > 50) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Mensagem de Erro");
                    alert.setHeaderText(null);
                    alert.setContentText("O número de tickets não pode superar o número de assentos (50)!");
                    alert.showAndWait();
                    return; // Interrompe o processo de inserção
                }

                // Insere o filme
                String sql = "INSERT INTO filme (id, TituloFilme, genero, duracao, imagem, data, actual, Descricao, trailer, status) VALUES(?,?,?,?,?,?,?,?,?,?)";

                String uri = getData.path;
                uri = uri.replace("\\", "\\\\");

                String uri2 = getData.Trailerpath;
                uri2 = uri2.replace("\\", "\\\\");

                FilmeId();
                String mID = String.valueOf(getData.FilmeId + 1);

                prepare = connect.prepareStatement(sql);
                prepare.setString(1, mID);
                prepare.setString(2, addMovies_Titulo.getText());
                prepare.setString(3, addMovies_Genero.getText());
                prepare.setString(4, addMovies_Duracao.getText());
                prepare.setString(5, uri);
                prepare.setString(6, String.valueOf(addMovies_Data.getValue()));
                prepare.setString(7, "Fim de Exibicao");
                prepare.setString(8, add_movies_descricao.getText());
                prepare.setString(9, uri2);
                prepare.setBoolean(10, true);

                prepare.execute();

                // Adiciona os horários automáticos após o filme ser inserido
                HorarioDAO horarioDAO = new HorarioDAO();
                boolean horariosAdicionados = horarioDAO.adicionarHorariosAutomaticos(
                        Integer.parseInt(mID), addMovies_Duracao.getText(), defaultTickets);

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mensagem de Informação");
                alert.setHeaderText(null);
                alert.setContentText(addMovies_Titulo.getText() + " - novo filme adicionado com sucesso com horários e tickets!");
                alert.showAndWait();

                clearAddMoviesList();
                showAddMoviesList();
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}



    
    public void updateAddMovies(){
        
        String uri= getData.path;
        uri= uri.replace("\\", "\\\\");
        
        String sql= "UPDATE filme SET TituloFilme = '" + addMovies_Titulo.getText()
                + "', genero =  '" + addMovies_Genero.getText()
                + "', duracao=  '" + addMovies_Duracao.getText() 
                + "', imagem= '" + uri 
                + "', data=  '" + addMovies_Data.getValue()
                +"',descricao= '" + add_movies_descricao.getText()
                + "' WHERE id= '" + String.valueOf(getData.FilmeId) +  "' ";
        
       connect= database.connectDb();
       
        try {
            
            statement= connect.createStatement();
            
            Alert alert;
            
            if(addMovies_Titulo.getText().isEmpty() 
                    ||  addMovies_Genero.getText().isEmpty()
                    ||  addMovies_Duracao.getText().isEmpty() 
                    || addMovies_imageView.getImage()== null 
                    || addMovies_Data.getValue() == null
                    || add_movies_descricao.getText().isEmpty()){
                
                
                alert= new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Mensagem de Erro");
                alert.setHeaderText(null);
                alert.setContentText("por favor, selecione o filme primeiro");
                alert.showAndWait();
                
                
            }else{
                
                statement.executeUpdate(sql);
                        
                alert= new Alert(Alert.AlertType.INFORMATION);
                  alert.setTitle("Mensagem de Informacao");
                alert.setHeaderText(null);
                alert.setContentText("Filme Adicionado com sucesso!");
                alert.showAndWait();
                
                showAddMoviesList();
                clearAddMoviesList();
                
                
            }
            
            
        } catch (Exception e) {e.printStackTrace();
        }
        
    }
    
    public void deleteAddMovies() {
    // SQL para atualizar o status do filme para 0 (ou false)
    String sql = "UPDATE filme SET status = 0 WHERE TituloFilme = ?"; // Usar ? para evitar SQL Injection
    
    connect = database.connectDb();
    
    Alert alert;
    
    try {
        // Usar PreparedStatement para evitar SQL Injection
        prepare = connect.prepareStatement(sql);
        
        if (addMovies_Titulo.getText().isEmpty() 
                || addMovies_Genero.getText().isEmpty()
                || addMovies_Duracao.getText().isEmpty()
                || addMovies_Data.getValue() == null
                || addMovies_imageView.getImage() == null) {
            
            // Se os campos estiverem vazios, mostrar um erro
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Mensagem de Erro");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione o filme primeiro");
            alert.showAndWait();
            
        } else {
            // Confirmação do usuário
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Mensagem de Confirmação");
            alert.setHeaderText(null);
            alert.setContentText("Você tem certeza que deseja desativar o filme " + addMovies_Titulo.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();
            
            if (ButtonType.OK.equals(option.get())) {
                // Define o título do filme no SQL
                prepare.setString(1, addMovies_Titulo.getText());
                
                // Executa a atualização do status no banco de dados
                prepare.executeUpdate();
                
                // Atualiza a lista de filmes na interface gráfica
                showAddMoviesList();  // A lista deve filtrar filmes com status 1 (ou true)
                clearAddMoviesList(); // Limpa os campos do formulário
                
                // Exibe mensagem de sucesso
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mensagem de Informação");
                alert.setHeaderText(null);
                alert.setContentText("Filme desativado com sucesso!");
                alert.showAndWait();
            } else {
                return;
            }
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    public void clearAddMoviesList() {

        addMovies_Titulo.setText("");
        addMovies_Genero.setText("");
        addMovies_Duracao.setText("");
        addMovies_imageView.setImage(null);
        addMovies_Data.setValue(null);
        add_movies_descricao.setText("");
        addmovies_Tickets.setText("");
    }

   public ObservableList<FilmesData> addMoviesList() {
    ObservableList<FilmesData> listData = FXCollections.observableArrayList();

    // Modificar a consulta SQL para buscar apenas filmes com status 1 (ativos)
    String sql = "SELECT * FROM filme WHERE status = 1";

    connect = database.connectDb();

    try {
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();

        FilmesData movD;

        while (result.next()) {
            movD = new FilmesData(result.getInt("id"),
                    result.getString("TituloFilme"),
                    result.getString("genero"),
                    result.getString("duracao"),
                    result.getString("imagem"),
                    result.getDate("data"),
                    result.getString("actual"),
                    result.getString("descricao"),
                    result.getString("trailer"),
                    result.getBoolean("status"));  // Já pega o status como booleano (deve ser true)

            
            if (result.getBoolean("status")) {
                listData.add(movD);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return listData;
}


    private ObservableList<FilmesData> listAddMovies;

   
      public void showAddMoviesList() {
    listAddMovies = addMoviesList();  // Agora filtra automaticamente filmes com status 1

    // Configurar as colunas da TableView
    addMovies_col_titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
    addMovies_col_genero.setCellValueFactory(new PropertyValueFactory<>("genero"));
    addMovies_col_duracao.setCellValueFactory(new PropertyValueFactory<>("duracao"));
    addMovies_col_data.setCellValueFactory(new PropertyValueFactory<>("data"));

    // Define os dados filtrados na TableView
    addMovies_tableView.setItems(listAddMovies);
}

    

    public void selectAddMoviesList() {

        FilmesData movD = addMovies_tableView.getSelectionModel().getSelectedItem();
        int num = addMovies_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        
        getData.path = movD.getImage();
        
        getData.FilmeId= movD.getId();

        addMovies_Titulo.setText(movD.getTitulo());
        addMovies_Genero.setText(movD.getGenero());
        addMovies_Duracao.setText(movD.getDuracao());

        String getDate = String.valueOf(movD.getData());

        String uri = "file:" + movD.getImage();

        image = new Image(uri, 235, 296, false, true);
        addMovies_imageView.setImage(image);
        
        addMovies_Data.setValue(movD.getData().toLocalDate());
        
        add_movies_descricao.setText(movD.getDescricao());
       
        
        
    }

    public void logout() {

        signout.getScene().getWindow().hide();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            root.setOnMousePressed((MouseEvent event) -> {

                x = event.getSceneX();
                y = event.getSceneY();

            });

            root.setOnMouseDragged((MouseEvent event) -> {

                stage.setX(event.getScreenX() - x);
                stage.setY(event.getSceneY() - y);

            });

            stage.initStyle(StageStyle.TRANSPARENT);

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void SetupUser(String userRole){
        
        hideAllForms();
        
        switch(userRole){
        case "admin":
            Dashboard_btn.setVisible(true);
            add_Movies_btn.setVisible(true);
            availableMovies_btn.setVisible(true);
            Editing_Screen_btn.setVisible(true);
            Costumers_btn.setVisible(true);
            MostrarDetalhesBtn.setVisible(true);
            funcionarios_btn.setVisible(true);
            CInema24_btn.setVisible(true);
            break;
        case "gerente":
            Dashboard_btn.setVisible(true);
            add_Movies_btn.setVisible(true);
            availableMovies_btn.setVisible(true );
            Editing_Screen_btn.setVisible(true);
            Costumers_btn.setVisible(true);
            MostrarDetalhesBtn.setVisible(true);
            funcionarios_btn.setVisible(false);
            CInema24_btn.setVisible(true);
            break;
        case "cliente":
            Dashboard_btn.setVisible(false);
            add_Movies_btn.setVisible(false);
            availableMovies_btn.setVisible(false);
            Editing_Screen_btn.setVisible(false);
            Costumers_btn.setVisible(false);
            MostrarDetalhesBtn.setVisible(false);
            funcionarios_btn.setVisible(false);
            CInema24_btn.setVisible(true);
            filmeDesc_voltar.setVisible(false);
            break;
         case "vendedor":
             Dashboard_btn.setVisible(false);
            add_Movies_btn.setVisible(false);
            availableMovies_btn.setVisible(true);
            Editing_Screen_btn.setVisible(false);
            Costumers_btn.setVisible(true);
            MostrarDetalhesBtn.setVisible(true);
            funcionarios_btn.setVisible(false);
            CInema24_btn.setVisible(true);
    }
        
        
    
    }
    
     private void hideAllForms() {
       
            
             dashboard_form.setVisible(false);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(false);
            editScreening_form.setVisible(false);
            Costumers_form.setVisible(false);
            FilmeDesc_form.setVisible(false);
            funcionario_tela.setVisible(false);
            cinema_form.setVisible(false);
    }

   
  
    public void switchForm(ActionEvent event) {

        if (event.getSource() == Dashboard_btn) {

            dashboard_form.setVisible(true);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(false);
            editScreening_form.setVisible(false);
            Costumers_form.setVisible(false);
            FilmeDesc_form.setVisible(false);
            funcionario_tela.setVisible(false);
             cinema_form.setVisible(false);

            Dashboard_btn.setStyle("-fx-background-color:#ae2d3c;");
            add_Movies_btn.setStyle("-fx-background-color:transparent;");
            availableMovies_btn.setStyle("-fx-background-color:transparent");
            Editing_Screen_btn.setStyle("-fx-background-color:transparent");
            Costumers_btn.setStyle("-fx-background-color:transparent");
            funcionarios_btn.setStyle("-fx-background-color:transparent");
            CInema24_btn.setStyle("-fx-background-color:transparent");

            carregarFilmesMaisVendidos(customerList());
            
            displayTotalIncomeToday();
            displayTotalSoldTicket();
            displayTotalMovies();
            
           loadDashboardMovies();
        } else if (event.getSource() == add_Movies_btn) {

            dashboard_form.setVisible(false);
            addMovies_form.setVisible(true);
            availableMovies_form.setVisible(false);
            editScreening_form.setVisible(false);
            Costumers_form.setVisible(false);
            FilmeDesc_form.setVisible(false);
            funcionario_tela.setVisible(false);
             cinema_form.setVisible(false);

            Dashboard_btn.setStyle("-fx-background-color:transparent");
            add_Movies_btn.setStyle("-fx-background-color:#ae2d3c;");
            availableMovies_btn.setStyle("-fx-background-color:transparent");
            Editing_Screen_btn.setStyle("-fx-background-color:transparent");
            Costumers_btn.setStyle("-fx-background-color:transparent");
            funcionarios_btn.setStyle("-fx-background-color:transparent");
            CInema24_btn.setStyle("-fx-background-color:transparent");
            
            showAddMoviesList();

        } else if (event.getSource() == availableMovies_btn) {

            dashboard_form.setVisible(false);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(true);
            editScreening_form.setVisible(false);
            Costumers_form.setVisible(false);
            FilmeDesc_form.setVisible(false);
            funcionario_tela.setVisible(false);
             cinema_form.setVisible(false);
            

            Dashboard_btn.setStyle("-fx-background-color:transparent");
            add_Movies_btn.setStyle("-fx-background-color:transparent;");
            availableMovies_btn.setStyle("-fx-background-color:#ae2d3c;");
            Editing_Screen_btn.setStyle("-fx-background-color:transparent");
            Costumers_btn.setStyle("-fx-background-color:transparent");
            funcionarios_btn.setStyle("-fx-background-color:transparent");
            CInema24_btn.setStyle("-fx-background-color:transparent");
            availableMovies_Horarios.setVisible(false);
            
            showAvailableMovies();

        } else if (event.getSource() == Editing_Screen_btn) {

            dashboard_form.setVisible(false);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(false);
            editScreening_form.setVisible(true);
            Costumers_form.setVisible(false);
            FilmeDesc_form.setVisible(false);
            funcionario_tela.setVisible(false);
             cinema_form.setVisible(false);

            Dashboard_btn.setStyle("-fx-background-color:transparent");
            add_Movies_btn.setStyle("-fx-background-color:transparent;");
            availableMovies_btn.setStyle("-fx-background-color:transparent");
            Editing_Screen_btn.setStyle("-fx-background-color:#ae2d3c;");
            Costumers_btn.setStyle("-fx-background-color:transparent");
            funcionarios_btn.setStyle("-fx-background-color:transparent");
            CInema24_btn.setStyle("-fx-background-color:transparent");
            
            
            showEditScreening();

        } else if (event.getSource() == Costumers_btn) {

            dashboard_form.setVisible(false);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(false);
            editScreening_form.setVisible(false);
            Costumers_form.setVisible(true);
            FilmeDesc_form.setVisible(false);
            funcionario_tela.setVisible(false);
             cinema_form.setVisible(false);

            Dashboard_btn.setStyle("-fx-background-color:transparent");
            add_Movies_btn.setStyle("-fx-background-color:transparent;");
            availableMovies_btn.setStyle("-fx-background-color:transparent");
            Editing_Screen_btn.setStyle("-fx-background-color:transparent");
            Costumers_btn.setStyle("-fx-background-color:#ae2d3c;");
            funcionarios_btn.setStyle("-fx-background-color:transparent");
            CInema24_btn.setStyle("-fx-background-color:transparent");
            
           showCustomerList();

        }else if(event.getSource() == MostrarDetalhesBtn){
            dashboard_form.setVisible(false);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(false);
            editScreening_form.setVisible(false);
            Costumers_form.setVisible(false);
            FilmeDesc_form.setVisible(true);
            funcionario_tela.setVisible(false);
             cinema_form.setVisible(false);
            
            Dashboard_btn.setStyle("-fx-background-color:transparent");
            add_Movies_btn.setStyle("-fx-background-color:transparent;");
            availableMovies_btn.setStyle("-fx-background-color:transparent");
            Editing_Screen_btn.setStyle("-fx-background-color:transparent");
            Costumers_btn.setStyle("-fx-background-color:transparent");
            funcionarios_btn.setStyle("-fx-background-color:transparent");
            CInema24_btn.setStyle("-fx-background-color:transparent");
          
     }else if(event.getSource() == funcionarios_btn){
          dashboard_form.setVisible(false);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(false);
            editScreening_form.setVisible(false);
            Costumers_form.setVisible(false);
            FilmeDesc_form.setVisible(false);
            funcionario_tela.setVisible(true);
             cinema_form.setVisible(false);
            
            Dashboard_btn.setStyle("-fx-background-color:transparent");
            add_Movies_btn.setStyle("-fx-background-color:transparent;");
            availableMovies_btn.setStyle("-fx-background-color:transparent");
            Editing_Screen_btn.setStyle("-fx-background-color:transparent");
            Costumers_btn.setStyle("-fx-background-color:transparent");
            funcionarios_btn.setStyle("-fx-background-color:#ae2d3c;");
            CInema24_btn.setStyle("-fx-background-color:transparent");
            
            
            funcionariosTableView();
     }else if(event.getSource() == availableMovies_refreshbtn){
           dashboard_form.setVisible(false);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(true);
            editScreening_form.setVisible(false);
            Costumers_form.setVisible(false);
            FilmeDesc_form.setVisible(false);
            funcionario_tela.setVisible(false);
             cinema_form.setVisible(false);
            
            Dashboard_btn.setStyle("-fx-background-color:transparent");
            add_Movies_btn.setStyle("-fx-background-color:transparent;");
            availableMovies_btn.setStyle("-fx-background-color:#ae2d3c;");
            Editing_Screen_btn.setStyle("-fx-background-color:transparent");
            Costumers_btn.setStyle("-fx-background-color:transparent");
            funcionarios_btn.setStyle("-fx-background-color:transparent");
            CInema24_btn.setStyle("-fx-background-color:transparent");
            availableMovies_Horarios.setVisible(true);
            showAvailableMovies();
            
     }else if(event.getSource() ==filmeDesc_voltar){
         dashboard_form.setVisible(false);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(true);
            editScreening_form.setVisible(false);
            Costumers_form.setVisible(false);
            FilmeDesc_form.setVisible(false);
            funcionario_tela.setVisible(false);
            cinema_form.setVisible(false);
            
            Dashboard_btn.setStyle("-fx-background-color:transparent");
            add_Movies_btn.setStyle("-fx-background-color:transparent;");
            availableMovies_btn.setStyle("-fx-background-color:#ae2d3c;");
            Editing_Screen_btn.setStyle("-fx-background-color:transparent");
            Costumers_btn.setStyle("-fx-background-color:transparent");
            funcionarios_btn.setStyle("-fx-background-color:transparent");
            CInema24_btn.setStyle("-fx-background-color:transparent");
            showAvailableMovies();
            
     }else if(event.getSource() ==CInema24_btn){
           dashboard_form.setVisible(false);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(false);
            editScreening_form.setVisible(false);
            Costumers_form.setVisible(false);
            FilmeDesc_form.setVisible(false);
            funcionario_tela.setVisible(false);
            cinema_form.setVisible(true);
            
            Dashboard_btn.setStyle("-fx-background-color:transparent");
            add_Movies_btn.setStyle("-fx-background-color:transparent;");
            availableMovies_btn.setStyle("-fx-background-color:transparent");
            Editing_Screen_btn.setStyle("-fx-background-color:transparent");
            Costumers_btn.setStyle("-fx-background-color:transparent");
            funcionarios_btn.setStyle("-fx-background-color:transparent");
            CInema24_btn.setStyle("-fx-background-color:#ae2d3c;");
            
            loadCinemaMovies();
     }else if(event.getSource()== filmeDesc_voltarClnt){
         
        dashboard_form.setVisible(false);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(false);
            editScreening_form.setVisible(false);
            Costumers_form.setVisible(false);
            FilmeDesc_form.setVisible(false);
            funcionario_tela.setVisible(false);
            cinema_form.setVisible(true);
            
            Dashboard_btn.setStyle("-fx-background-color:transparent");
            add_Movies_btn.setStyle("-fx-background-color:transparent;");
            availableMovies_btn.setStyle("-fx-background-color:transparent");
            Editing_Screen_btn.setStyle("-fx-background-color:transparent");
            Costumers_btn.setStyle("-fx-background-color:transparent");
            funcionarios_btn.setStyle("-fx-background-color:transparent");
            CInema24_btn.setStyle("-fx-background-color:#ae2d3c;");
            loadCinemaMovies();
     }
    }
    
 
    

    //Muda o Username do Usuario
    public void displayUsername() {
        username.setText(getData.username);
    }

    public void close() {
        System.exit(0);
    }

    public void minimize() {
        Stage stage = (Stage) topForm.getScene().getWindow();
        stage.setIconified(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        displayUsername();
        
        //mostra os filmes addicionados
        showAddMoviesList();
        
        //mostra os filmes editados
        showEditScreening();
        
        //combo box da tela Edit
        comboBox();
        
        
        //mostra os filmes disponiveis
        showAvailableMovies();
        
        showSpinnerValue();
        
        showCustomerList();
        
        filmeDesc_PAUSE.setVisible(false);
        
        startParticleAnimation();
        
        startParticleAnimation1();
        
        startParticleAnimation2();
        
        displayTotalSoldTicket();
        displayTotalMovies();
        displayTotalIncomeToday();
       
        funcionariosTableView();
        
        loadDashboardMovies();
        
        loadCinemaMovies();
        
        
        carregarFilmesMaisVendidos(customerList());
        
        FilmsAnaliseOpen();
        
        setupCinemaImageClickEvents();
        
        startFireEffect();
        
        carregarFuncionariosPendentes();
        
        carregarMetodosPagamento();
    }
    
    
    

    
    public void FilmsDespOpen() {
 
    Dashboard_FilmeAnalise.setVisible(false);
    Dashboard_FilmesDisponiveis.setVisible(true);
}
    
    public void FilmsAnaliseOpen() {

    Dashboard_FilmeAnalise.setVisible(true);
    Dashboard_FilmesDisponiveis.setVisible(false);
}
    
    
 public void showTicketDetails() {
    Dialog<String> detailsDialog = new Dialog<>();
    
   
    Stage stage = (Stage) detailsDialog.getDialogPane().getScene().getWindow();
    stage.initStyle(StageStyle.UNDECORATED);
    
    // Conteúdo do diálogo
    Label title = new Label("Benefícios do Ticket Especial");
    title.setFont(Font.font("Arial", 18));
    title.setStyle("-fx-font-weight: bold; -fx-text-fill: #2c3e50;");

    Label detailsLabel = new Label("- Pipocas extras\n- Óculos 3D incluídos\n-Concorre para um sorteio de 5 Tickets Gratis");
    detailsLabel.setFont(Font.font("Arial", 16));
    detailsLabel.setStyle("-fx-text-fill: #34495e;");

    // Layout do dialog
    VBox dialogContent = new VBox(15, title, detailsLabel);
    dialogContent.setStyle("-fx-padding: 20; -fx-background-color: #ecf0f1; -fx-border-color: #bdc3c7; -fx-border-radius: 10; -fx-background-radius: 10;");
dialogContent.setMinWidth(400); 
dialogContent.setMinHeight(300); 

    
    detailsDialog.getDialogPane().setContent(dialogContent);

    // Adicionando um botão "Ok" no dialog
    detailsDialog.getDialogPane().getButtonTypes().add(ButtonType.OK);

    // Estilizando o diálogo
    detailsDialog.getDialogPane().setStyle("-fx-border-radius: 10; -fx-background-radius: 10;");

    // Exibir o dialog
    detailsDialog.showAndWait();
}

    

    private void startFireEffect() {
        GraphicsContext gc = canvas_cinema.getGraphicsContext2D();

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(30), e -> draw(gc)));
        timeline.setCycleCount(Timeline.INDEFINITE); // A animação continua indefinidamente
        timeline.play(); // Iniciar a animação
    }

    private void draw(GraphicsContext gc) {
        // Limpar o canvas
        gc.clearRect(0, 0, canvas_cinema.getWidth(), canvas_cinema.getHeight());

        // Adicionar novas partículas aleatoriamente
        if (random.nextDouble() < 0.8) {
            particles.add(new Particle(random.nextDouble() * canvas_cinema.getWidth(),
                    canvas_cinema.getHeight(), random));
        }

        // Desenhar e atualizar partículas
        Iterator<Particle> it = particles.iterator();
        while (it.hasNext()) {
            Particle p = it.next();
            p.update(); // Atualizar posição e estado da partícula
            if (p.isDead()) {
                it.remove(); // Remover partícula se ela "morrer"
            } else {
                p.render(gc); // Desenhar partícula
            }
        }
    }

    // Classe para representar uma partícula de fogo
    private static class Particle {
        private double x, y; // Posição da partícula
        private double vx, vy; // Velocidade
        private double life; // Vida útil da partícula (tempo até desaparecer)
        private final Color color;

        public Particle(double x, double y, Random random) {
            this.x = x;
            this.y = y;
            this.vx = (random.nextDouble() - 0.5) * 2; // Movimento lateral
            this.vy = -(random.nextDouble() * 2 + 1);  // Movimento para cima
            this.life = random.nextDouble() * 60 + 40; // Tempo de vida
            this.color = Color.rgb(255, random.nextInt(100), 0, 1); // Cor inicial (vermelho-laranja)
        }

        public void update() {
            // Atualizar a posição
            x += vx;
            y += vy;

            // Reduzir a vida útil
            life -= 1;
        }

        public void render(GraphicsContext gc) {
            // Definir a cor da partícula
            double opacity = life / 100.0; // Transparência baseada na vida
            gc.setFill(new Color(color.getRed(), color.getGreen(), color.getBlue(), opacity));

            // Desenhar a partícula como um pequeno círculo
            gc.fillOval(x, y, 5, 5);
        }

        public boolean isDead() {
            return life <= 0;
        }
    }
    
 private void startParticleAnimation1() {
    GraphicsContext gc = particleCanvas1.getGraphicsContext2D();
    List<Map<String, Object>> particles = new ArrayList<>();
    int numParticles = 2000;  // Aumentar o número de partículas para 1000
    
    // Cria partículas
    for (int i = 0; i < numParticles; i++) {
        Map<String, Object> particle = new HashMap<>();
        particle.put("x", Math.random() * particleCanvas1.getWidth());
        particle.put("y", Math.random() * particleCanvas1.getHeight());
        particle.put("speedX", (Math.random() - 0.5) * 2);  // Velocidade ajustada
        particle.put("speedY", (Math.random() - 0.5) * 2);
        particle.put("size", Math.random() * 3 + 1);
        particle.put("color", Color.BLACK);  // Cor das partículas
        particles.add(particle);
    }
    
    AnimationTimer timer1 = new AnimationTimer() {
        @Override
        public void handle(long now) {
            // Limpa o canvas
            gc.clearRect(0, 0, particleCanvas1.getWidth(), particleCanvas1.getHeight());
            
            // Atualiza as partículas
            for (Map<String, Object> particle : particles) {
                // Atualiza a posição da partícula
                double newX = (double) particle.get("x") + (double) particle.get("speedX");
                double newY = (double) particle.get("y") + (double) particle.get("speedY");

                // Verifica se está dentro dos limites do Canvas, se não, reverte a direção
                if (newX < 0 || newX > particleCanvas1.getWidth()) {
                    particle.put("speedX", -(double) particle.get("speedX"));
                }
                if (newY < 0 || newY > particleCanvas1.getHeight()) {
                    particle.put("speedY", -(double) particle.get("speedY"));
                }

                // Atualiza as coordenadas com os novos valores
                particle.put("x", newX);
                particle.put("y", newY);

                // Desenha a partícula no canvas
                gc.setFill((Color) particle.get("color"));
                gc.fillOval((double) particle.get("x"), (double) particle.get("y"), (double) particle.get("size"), (double) particle.get("size"));
            }
        }
    };
    timer1.start();
}

  private void startParticleAnimation2() {
    GraphicsContext gc = particleCanvas11.getGraphicsContext2D();
    List<Map<String, Object>> particles = new ArrayList<>();
    int numParticles = 500;  
    
    // Cria partículas
    for (int i = 0; i < numParticles; i++) {
        Map<String, Object> particle = new HashMap<>();
        particle.put("x", Math.random() * particleCanvas11.getWidth());
        particle.put("y", Math.random() * particleCanvas11.getHeight());
        particle.put("speedX", (Math.random() - 0.5) * 2);  // Velocidade ajustada
        particle.put("speedY", (Math.random() - 0.5) * 2);
        particle.put("size", Math.random() * 3 + 1);
        particle.put("color", Color.WHITESMOKE);  // Cor das partículas
        particles.add(particle);
    }
    
    AnimationTimer timer2 = new AnimationTimer() {
        @Override
        public void handle(long now) {
            // Limpa o canvas
            gc.clearRect(0, 0, particleCanvas11.getWidth(), particleCanvas11.getHeight());
            
            // Atualiza as partículas
            for (Map<String, Object> particle : particles) {
                // Atualiza a posição da partícula
                double newX = (double) particle.get("x") + (double) particle.get("speedX");
                double newY = (double) particle.get("y") + (double) particle.get("speedY");

                // Verifica se está dentro dos limites do Canvas, se não, reverte a direção
                if (newX < 0 || newX > particleCanvas11.getWidth()) {
                    particle.put("speedX", -(double) particle.get("speedX"));
                }
                if (newY < 0 || newY > particleCanvas11.getHeight()) {
                    particle.put("speedY", -(double) particle.get("speedY"));
                }

                // Atualiza as coordenadas com os novos valores
                particle.put("x", newX);
                particle.put("y", newY);

                // Desenha a partícula no canvas
                gc.setFill((Color) particle.get("color"));
                gc.fillOval((double) particle.get("x"), (double) particle.get("y"), (double) particle.get("size"), (double) particle.get("size"));
            }
        }
    };
    timer2.start();
}
        
   
     
    
    private void startParticleAnimation() {
    GraphicsContext gc = particleCanvas.getGraphicsContext2D();
    List<Map<String, Object>> particles = new ArrayList<>();
    int numParticles = 1000;  // Aumentar o número de partículas para 1000
    
    // Cria partículas
    for (int i = 0; i < numParticles; i++) {
        Map<String, Object> particle = new HashMap<>();
        particle.put("x", Math.random() * particleCanvas.getWidth());
        particle.put("y", Math.random() * particleCanvas.getHeight());
        particle.put("speedX", (Math.random() - 0.5) * 2);  // Velocidade ajustada
        particle.put("speedY", (Math.random() - 0.5) * 2);
        particle.put("size", Math.random() * 3 + 1);
        particle.put("color", Color.RED);  // Cor das partículas
        particles.add(particle);
    }

    // Anima as partículas
    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            gc.clearRect(0, 0, particleCanvas.getWidth(), particleCanvas.getHeight());  // Limpa o canvas
            for (Map<String, Object> particle : particles) {
                // Atualiza a posição da partícula
                double newX = (double) particle.get("x") + (double) particle.get("speedX");
                double newY = (double) particle.get("y") + (double) particle.get("speedY");

                // Verifica se está dentro dos limites do Canvas, se não, reverte a direção
                if (newX < 0 || newX > particleCanvas.getWidth()) {
                    particle.put("speedX", -(double) particle.get("speedX"));
                }
                if (newY < 0 || newY > particleCanvas.getHeight()) {
                    particle.put("speedY", -(double) particle.get("speedY"));
                }

                // Atualiza as coordenadas com os novos valores
                particle.put("x", (double) particle.get("x") + (double) particle.get("speedX"));
                particle.put("y", (double) particle.get("y") + (double) particle.get("speedY"));

                // Desenha a partícula no canvas
                gc.setFill((Color) particle.get("color"));
                gc.fillOval((double) particle.get("x"), (double) particle.get("y"), (double) particle.get("size"), (double) particle.get("size"));
            }
        }
    };
    timer.start();  // Inicia a animação
}
}


