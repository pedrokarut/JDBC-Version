package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PontoColeta 
{
    private int codPonto;
    private String nome;
    private String endereco;
    private String cidade;
    private String estado;
    private String dataRetirada;

    public PontoColeta(String nome, String endereco, String cidade, String estado, String dataRetirada) 
    {
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.dataRetirada = dataRetirada;
    }
    
    public PontoColeta()
    {}
    
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
          stmt.executeUpdate("INSERT INTO PontoColeta (nome, endereco, cidade, estado, dataRetirada) VALUES('"+this.getNome()+"', '"+this.getEndereco()+"', '"+ this.getCidade()+"', '"+this.getEstado()+"', '"+this.getDataRetirada()+"')");
                 
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
          stmt.executeUpdate("Update  PontoColeta set nome = '"+this.getNome()+"', endereco= '"+this.getEndereco()+"', cidade = '"+this.getCidade()+"', estado = '"+this.getEstado()+"', dataRetirada = '"+this.getDataRetirada()+"' WHERE codPonto = "+cod);
                 
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
          stmt.executeUpdate("DELETE FROM PontoColeta WHERE codPonto = " +cod);
                 
          stmt.close();
          con.close();
      }
      catch (SQLException e) 
      {
       e.printStackTrace();
      } 
    }
    
      public PontoColeta(int cod) {

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
          rs=stmt.executeQuery("SELECT * FROM PontoColeta WHERE codPonto = " +cod);
          while (rs.next()) {
              this.codPonto = Integer.parseInt(rs.getString(1));
              this.nome= rs.getString(2);
              this.endereco = (rs.getString(3));
              this.cidade = rs.getString(4);
              this.estado = rs.getString(5);
              this.dataRetirada = rs.getString(5);
          }
          rs.close();
          stmt.close();
          con.close();
      }
      catch (SQLException e) {
       e.printStackTrace();
      }
    }
    
    

    public int getCodPonto() {
        return codPonto;
    }

    public void setCodPonto(int codPonto) {
        this.codPonto = codPonto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(String dataRetirada) {
        this.dataRetirada = dataRetirada;
    }
    
    
    
    
}
