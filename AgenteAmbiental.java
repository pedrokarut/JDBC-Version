package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AgenteAmbiental 
{
    private int codAgente;
    private String nome;
    private long cpf;
    private String dataNascimento;
    private String endereco;

    public AgenteAmbiental(String nome, long cpf, String dataNascimento, String endereco)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public AgenteAmbiental()
    {}
    
     public AgenteAmbiental(int cod) {

      Connection con = null;
      Statement stmt=null;
      ResultSet rs=null;
      try {  // carregar o driver
         Class.forName("com.mysql.jdbc.Driver");
      } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
      }         
      try {  // estabelecer conexão
         con = DriverManager.getConnection("jdbc:mysql://localhost/Coleta","root","182709");
      }
      catch (SQLException e) {
          e.printStackTrace();
      }
      try {  // recuperar objeto da tabela
          stmt = con.createStatement();
          rs=stmt.executeQuery("SELECT * FROM AgenteAmbiental WHERE codAgente = " +cod);
          while (rs.next()) {
              this.codAgente = Integer.parseInt(rs.getString(1));
              this.nome= rs.getString(2);
              this.cpf = Long.parseLong(rs.getString(3));
              this.dataNascimento = rs.getString(4);
              this.endereco = rs.getString(5);
          }
          rs.close();
          stmt.close();
          con.close();
      }
      catch (SQLException e) {
       e.printStackTrace();
      }
    }
   
    
    public void Save()
    {
        Connection con = null;
        Statement stmt = null;
        try 
        {  
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException ex) 
        {
            ex.printStackTrace();
        } 
      
        try
        {  
            con = DriverManager.getConnection("jdbc:mysql://localhost/Coleta","root","182709");
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        
         try 
         {  // salvar objeto na tabela
          stmt = con.createStatement();
          stmt.executeUpdate("INSERT INTO AgenteAmbiental (nome, cpf, dataNascimento, endereco) VALUES('"+this.getNome()+"',"+this.getCpf()+",'"+this.getDataNascimento()+"','"+this.getEndereco()+"')");
                 
          stmt.close();
          con.close();
      }
      catch (SQLException e) 
      {
       e.printStackTrace();
      }      
    
    }
    
    public void Delete(int cod)
    {
         Connection con = null;
        Statement stmt = null;
        try 
        {  
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException ex) 
        {
            ex.printStackTrace();
        } 
      
        try
        {  
            con = DriverManager.getConnection("jdbc:mysql://localhost/Coleta","root","182709");
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        
         try 
         {  // salvar objeto na tabela
          stmt = con.createStatement();
          stmt.executeUpdate("DELETE FROM AgenteAmbiental WHERE codAgente = " + cod);
                 
          stmt.close();
          con.close();
      }
      catch (SQLException e) 
      {
       e.printStackTrace();
      }      
        
    }
        
    public void Edit(int cod)
    {
        Connection con = null;
        Statement stmt = null;
        try 
        {  
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException ex) 
        {
            ex.printStackTrace();
        } 
      
        try
        {  
            con = DriverManager.getConnection("jdbc:mysql://localhost/Coleta","root","182709");
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        
         try 
         {  // salvar objeto na tabela
          stmt = con.createStatement();
          stmt.executeUpdate("UPDATE  AgenteAmbiental SET nome = '"+this.getNome()+"', cpf = "+this.getCpf()+", dataNascimento= '"+this.getDataNascimento()+"', endereco= '"+this.getEndereco()+"' WHERE codAgente= " + cod);
                 
          stmt.close();
          con.close();
      }
      catch (SQLException e) 
      {
       e.printStackTrace();
      }      
    
        
    }
    
    
    
      

    public int getCodAgente() {
        return codAgente;
    }

    public void setCodAgente(int codAgente) {
        this.codAgente = codAgente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
    
    
    
}
