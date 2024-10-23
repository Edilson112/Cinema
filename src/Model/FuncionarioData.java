package Model;


public class FuncionarioData {
    private int id;
    private String email;
    private String username;
    private String cargo;
    private double salario;
    private boolean status;
 

    public FuncionarioData(int id, String email, String username, String cargo, double salario, boolean status) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.cargo = cargo;
        this.salario = salario;
        this.status = status;
    }

    public FuncionarioData(String email, String username, String cargo, double salario) {
        this.email = email;
        this.username = username;
        this.cargo = cargo;
        this.salario = salario;
    }

  
    
    
    
    

    // Getters e Setters para cada propriedade
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
