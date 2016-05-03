package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Material 
{
    private int codMaterial;
    private String nome;
    private String tipo;
    private int TempoDecomposicao;
    private String descricao;

    public Material(String nome, String tipo, int TempoDecomposicao, String descricao)
    {
        this.nome = nome;
        this.tipo = tipo;
        this.TempoDecomposicao = TempoDecomposicao;
        this.descricao = descricao;
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
          stmt.executeUpdate("INSERT INTO Material (nome, tipo, tempoDecomposicao, descricao) VALUES('"+this.getNome()+"', '"+this.getTipo()+"', "+ this.getTempoDecomposicao()+", '"+this.getDescricao()+"')");
                 
          stmt.close();
          con.close();
      }
      catch (SQLException e) 
      {
       e.printStackTrace();
      }      
    }
    
    
     public Material(int cod) {

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
          rs=stmt.executeQuery("SELECT * FROM Material WHERE codMaterial = " +cod);
          while (rs.next()) {
              this.codMaterial = Integer.parseInt(rs.getString(1));
              this.nome= rs.getString(2);
              this.tipo = (rs.getString(3));
              this.TempoDecomposicao = Integer.parseInt(rs.getString(4));
              this.descricao = rs.getString(5);
          }
          rs.close();
          stmt.close();
          con.close();
      }
      catch (SQLException e) {
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
          stmt.executeUpdate("Update  Material set nome = '"+this.getNome()+"', tipo= '"+this.getTipo()+"', tempoDecomposicao = "+this.getTempoDecomposicao()+", descricao = '"+this.getDescricao()+"' WHERE codMaterial = "+cod);
                 
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
          stmt.executeUpdate("DELETE FROM Material WHERE codMaterial = " +cod);
                 
          stmt.close();
          con.close();
      }
      catch (SQLException e) 
      {
       e.printStackTrace();
      } 
    }
    
    public Material()
    {}
    
    
    

    public int getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(int codMaterial) {
        this.codMaterial = codMaterial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTempoDecomposicao() {
        return TempoDecomposicao;
    }

    public void setTempoDecomposicao(int TempoDecomposicao) {
        this.TempoDecomposicao = TempoDecomposicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
    
}
