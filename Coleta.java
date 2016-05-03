package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Coleta 
{
    private int codColeta;
    private AgenteAmbiental codAgente;
    private PontoColeta codPonto;
    private String dataColeta;
    
    
    public Coleta()
    {}


    public Coleta(int cod) {

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
          rs=stmt.executeQuery("SELECT * FROM Coleta WHERE codColeta = " +cod);
          while (rs.next()) {
              this.codColeta = Integer.parseInt(rs.getString(1));
              this.codAgente = new AgenteAmbiental(Integer.parseInt(rs.getString(2)));
              this.codPonto = new PontoColeta(Integer.parseInt(rs.getString(3)));
              this.dataColeta = rs.getString(4);
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
          stmt.executeUpdate("INSERT INTO Coleta (codAgente, codPonto, dataColeta) VALUES("+this.getCodAgente().getCodAgente()+", "+this.getCodPonto().getCodPonto()+", '"+this.getDataColeta()+"')");
                 
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
          stmt.executeUpdate("UPDATE  Coleta set codAgente = " +this.getCodAgente().getCodAgente()+",  codPonto= " +this.getCodPonto().getCodPonto()+ ",  dataColeta= '"+this.getDataColeta()+"' WHERE codColeta= " +cod);
                 
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
          stmt.executeUpdate("DELETE FROM Coleta WHERE codColeta = " +cod);
                 
          stmt.close();
          con.close();
      }
      catch (SQLException e) 
      {
       e.printStackTrace();
      } 
    }
    
    
    
    

    public Coleta(String dataColeta) 
    {
        this.dataColeta = dataColeta;
    }

    public int getCodColeta() {
        return codColeta;
    }

    public void setCodColeta(int codColeta) {
        this.codColeta = codColeta;
    }

    public AgenteAmbiental getCodAgente() {
        return codAgente;
    }

    public void setCodAgente(AgenteAmbiental codAgente) {
        this.codAgente = codAgente;
    }

    public PontoColeta getCodPonto() {
        return codPonto;
    }

    public void setCodPonto(PontoColeta codPonto) {
        this.codPonto = codPonto;
    }

    public String getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(String dataColeta) {
        this.dataColeta = dataColeta;
    }

 
    
    
}
