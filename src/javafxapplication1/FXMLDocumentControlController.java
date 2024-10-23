/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;
import javafx.fxml.FXMLLoader;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static javafx.application.ConditionalFeature.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



/**
 * FXML Controller class
 *
 * @author Sysadmin
 */
public class FXMLDocumentControlController implements Initializable {

    @FXML
    private Label SignUp_passwordRegra;
    
    
    @FXML
    private Label signUp_EmailRegra;
    
    @FXML
    private ComboBox<?> cargo;
    
        @FXML
    private TextField signUp_cargo;
    
    @FXML
    private Button signUp_Entrar;

    @FXML
    private TextField signUp_Username;

    @FXML
    private Button signUp_close;

    @FXML
    private TextField signUp_email;

    @FXML
    private AnchorPane signUp_form;

    @FXML
    private Button signUp_minimize;

    @FXML
    private PasswordField signUp_password;

    @FXML
    private Hyperlink signUp_temCOnta;

    @FXML
    private Button signin_Close;

    @FXML
    private Hyperlink signin_creatAccount;

    @FXML
    private AnchorPane signin_form;

    @FXML
    private Button signin_loginbtn;

    @FXML
    private Button signin_minimize;

    @FXML
    private PasswordField signin_password;

    @FXML
    private TextField signin_username;

    //ferramentas da base de dados
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    public boolean validEmail() {
        //Edilson_123@gmail.com      [primeira Letra][segunda letra -> antes @] [@] [gmail] [.] [COM]
        Pattern pattern = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");

        Matcher match = pattern.matcher(signUp_email.getText());

        Alert alert;

        if (match.find() && match.group().matches(signUp_email.getText())) {

            return true;
        } else {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Mensagem de Erro");
            alert.setHeaderText(null);
            alert.setContentText("email Invalido");
            alert.showAndWait();

            return false;
        }
    }

    //Accao do SingUp
    // Accao do SingUp
public void signup() {
    // SQL para inserir o novo usuário, agora com o campo cargo e status condicional
    String sql = "INSERT INTO admin (email, username, password, cargo, salario, status) VALUES (?,?,?,?,?,?)";

    // SQL para verificar se o username já existe
    String sqll = "SELECT username FROM admin WHERE username = ?";

    connect = database.connectDb();

    try {
        Alert alert;

        // Verificar se os campos estão vazios
        if (signUp_email.getText().isEmpty() || signUp_Username.getText().isEmpty() || signUp_password.getText().isEmpty() || cargo.getValue() == null) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Mensagem de Erro");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, preencha todos os campos");
            alert.showAndWait();
            return;
        }

        // Verificar se a senha tem pelo menos 8 caracteres
        if (signUp_password.getText().length() < 8) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Mensagem de Erro");
            alert.setHeaderText(null);
            alert.setContentText("A senha deve ter pelo menos 8 caracteres");
            alert.showAndWait();
            return;
        }

        // Verifica se o email é válido
        if (!validEmail()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Mensagem de Erro");
            alert.setHeaderText(null);
            alert.setContentText("Email inválido!");
            alert.showAndWait();
            return;
        }

        // Verificar se o username já existe
        prepare = connect.prepareStatement(sqll);
        prepare.setString(1, signUp_Username.getText());
        result = prepare.executeQuery();

        if (result.next()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Mensagem de Erro");
            alert.setHeaderText(null);
            alert.setContentText(signUp_Username.getText() + " já existe!");
            alert.showAndWait();
            return;
        }

        // Determinar o salário com base no cargo selecionado
        double salario = 0.0; // Salário padrão
        String cargoSelecionado = (String) cargo.getValue();
        boolean status = true; // Status padrão para "cliente"

        if (cargoSelecionado.equalsIgnoreCase("cliente")) {
            salario = 0.0; 
            status = true;  // Clientes têm status ativo
        } else if (cargoSelecionado.equalsIgnoreCase("vendedor")) {
            salario = 3000.0; 
            status = false;  // Vendedores têm status pendente (0)
        } else if (cargoSelecionado.equalsIgnoreCase("gerente")) {
            salario = 10000.0; 
            status = false;  // Gerentes têm status pendente (0)
        }

        // Se o username for único, inserir o novo usuário
        prepare = connect.prepareStatement(sql);
        prepare.setString(1, signUp_email.getText());
        prepare.setString(2, signUp_Username.getText());
        prepare.setString(3, signUp_password.getText());
        prepare.setString(4, cargoSelecionado); // Pegar o valor do cargo selecionado no ComboBox
        prepare.setDouble(5, salario); // Define o salário baseado no cargo
        prepare.setBoolean(6, status); // Define o status baseado no cargo (true para cliente, false para gerente/vendedor)

        prepare.execute();

        // Exibe mensagem de sucesso
        alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Mensagem de Informação");
        alert.setHeaderText(null);
        alert.setContentText("Nova conta criada com sucesso!");
        alert.showAndWait();

        // Limpar campos após criar conta com sucesso
        signUp_email.setText("");
        signUp_Username.setText("");
        signUp_password.setText("");
        cargo.setValue(null); // Limpar seleção do ComboBox

    } catch (Exception e) {
        e.printStackTrace();
    }
}




    private double x=0;
    private double y=0;
    
   public void signin() {

    String sql = "SELECT * FROM admin WHERE username= ? and password= ?";
    connect = database.connectDb();

    try {
        prepare = connect.prepareStatement(sql);
        prepare.setString(1, signin_username.getText());
        prepare.setString(2, signin_password.getText());

        result = prepare.executeQuery();

        Alert alert;

        // Verifica se o username ou password estão vazios
        if (signin_username.getText().isEmpty() || signin_password.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Mensagem de Erro");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, preencha todos os campos");
            alert.showAndWait();
        } else {
            if (result.next()) {
                // Verifica o status do usuário
                boolean status = result.getBoolean("status");

                // Se o status for 0, exibe uma mensagem e bloqueia o login
                if (!status) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Mensagem de Erro");
                    alert.setHeaderText(null);
                    alert.setContentText("Sua conta está pendente de aprovação. Entre em contato com o administrador.");
                    alert.showAndWait();
                    return; // Bloqueia o login
                }

                // Armazenar o cargo do usuário
                String userRole = result.getString("cargo"); // Supondo que você tenha um campo "cargo" na tabela

                getData.username = signin_username.getText();
                
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Mensagem de Informação");
                alert.setHeaderText(null);
                alert.setContentText("Login com Sucesso!");
                alert.showAndWait();

                // Esconde a tela de login
                signin_loginbtn.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
                Parent root = loader.load();
 
                dashboardController daController = loader.getController();
               
                daController.SetupUser(userRole); // Passa o cargo do usuário

                Stage stage = new Stage();
                Scene scene = new Scene(root);
                
                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);
                });

                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();

            } else {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Mensagem de Erro");
                alert.setHeaderText(null);
                alert.setContentText("Username ou password incorretos");
                alert.showAndWait();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    
     private String[] cargos= {"Vendedor", "gerente","cliente"};
     
    public void comboBox(){
         List<String> listCurrent= new ArrayList<>();
         
         for(String data: cargos){
            listCurrent.add(data);
        }
        
        ObservableList listC= FXCollections.observableArrayList(listCurrent);
        cargo.setItems(listC);
    }

    public void switchForm(ActionEvent event) {

        if (event.getSource() == signin_creatAccount) {
            signin_form.setVisible(false);
            signUp_form.setVisible(true);

        } else if (event.getSource() == signUp_temCOnta) {
            signin_form.setVisible(true);
            signUp_form.setVisible(false);
        }
    }

    public void signIn_close() {
        System.exit(0);

    }

    public void signIn_minimize() {
        Stage stage = (Stage) signin_form.getScene().getWindow();
        stage.setIconified(true);
    }

    public void signUp_close() {
        System.exit(0);
    }

    public void signUp_minimize() {
        Stage stage = (Stage) signUp_form.getScene().getWindow();
        stage.setIconified(true);
    }
    
    public void Regra(){
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBox();
        
        signUp_EmailRegra.setVisible(false);
        SignUp_passwordRegra.setVisible(false);
        
       
        signUp_email.setOnMouseClicked(event -> {
            signUp_EmailRegra.setVisible(true); 
        });

        // Adicionar evento para o campo de senha
        signUp_password.setOnMouseClicked(event -> {
            SignUp_passwordRegra.setVisible(true);  
        });

        
       signUp_email.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {  
                signUp_EmailRegra.setVisible(false); 
            }
        });

        signUp_password.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {  
                SignUp_passwordRegra.setVisible(false);
            }
        });
    }

}
