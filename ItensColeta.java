package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ItensColeta
{
    private int codItem;
    private Material codMaterial;
    private Coleta codColeta;
    private int quantidade;

    public ItensColeta(int quantidade) 
    {
        this.quantidade = quantidade;
    }
    
    public ItensColeta()
    { }
    
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
          stmt.executeUpdate("INSERT INTO ItensColeta (codMaterial, codColeta, quantidade) VALUES("+this.getCodMaterial().getCodMaterial()+", "+this.getCodColeta().getCodColeta()+", "+this.getQuantidade()+")");
                 
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
          stmt.executeUpdate("UPDATE  ItensColeta set codMaterial = " +this.getCodMaterial().getCodMaterial()+", set codColeta = "+this.getCodColeta().getCodColeta()+", quantidade = "+this.getQuantidade()+" WHERE codIem = " +cod);
                 
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
          stmt.executeUpdate("DELETE FROM ItensColeta WHERE codItem = " +cod);
                 
          stmt.close();
          con.close();
      }
      catch (SQLException e) 
      {
       e.printStackTrace();
      } 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public int getCodItem() {
        return codItem;
    }

    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }

    public Material getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(Material codMaterial) {
        this.codMaterial = codMaterial;
    }

    public Coleta getCodColeta() {
        return codColeta;
    }

    public void setCodColeta(Coleta codColeta) {
        this.codColeta = codColeta;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
    
    
}
