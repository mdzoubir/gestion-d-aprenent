package org.example.repository;

import org.example.entity.Etudiant;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantRepository {


    public void create(Etudiant etudiant){
        Connection conn=null;
        try{
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiat_management","simo","1234");

            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/etudiat_management");
            dataSource.setUsername("simo");
            dataSource.setPassword("1234");
            conn=dataSource.getConnection();

            String query = "INSERT INTO etudiant (nom, prenom, email, telephone, id_specialite) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,etudiant.getNom());
            preparedStatement.setString(2,etudiant.getPrenom());
            preparedStatement.setString(3,etudiant.getEmail());
            preparedStatement.setInt(4,etudiant.getTelephone());
            preparedStatement.setInt(5,etudiant.getId_spcialite());

            preparedStatement.executeUpdate();

            System.out.println("Etudiants insert");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if (conn!=null){
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    public void update(Etudiant etudiant){
        Connection conn=null;
        try{
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiat_management","simo","1234");
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/etudiat_management");
            dataSource.setUsername("simo");
            dataSource.setPassword("1234");
            conn=dataSource.getConnection();

            String query = "UPDATE etudiant SET nom=?, prenom=?, email=?, telephone=?, id_specialite=? WHERE id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,etudiant.getNom());
            preparedStatement.setString(2,etudiant.getPrenom());
            preparedStatement.setString(3,etudiant.getEmail());
            preparedStatement.setInt(4,etudiant.getTelephone());
            preparedStatement.setInt(5,etudiant.getId_spcialite());
            preparedStatement.setInt(6,etudiant.getId());

            preparedStatement.executeUpdate();

            System.out.println("Etudiants update");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if (conn!=null){
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }


    public void delete(int id){
        Connection conn=null;
        try{
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiat_management","simo","1234");
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/etudiat_management");
            dataSource.setUsername("simo");
            dataSource.setPassword("1234");
            conn=dataSource.getConnection();

            String query = "DELETE FROM etudiant WHERE id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();

            System.out.println("Etudiants delete");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if (conn!=null){
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    public Etudiant getById(int id){
        Connection conn=null;
        Etudiant etudiant = null;
        try{
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiat_management","simo","1234");
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/etudiat_management");
            dataSource.setUsername("simo");
            dataSource.setPassword("1234");
            conn=dataSource.getConnection();

            String query = "SELECT * FROM etudiant WHERE id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setInt(1,id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()){
                etudiant = new Etudiant();
                etudiant.setId(id);
                etudiant.setNom(rs.getString("nom"));
                etudiant.setPrenom(rs.getString("prenom"));
                etudiant.setEmail(rs.getString("email"));
                etudiant.setTelephone(rs.getInt("telephone"));
                etudiant.setId_spcialite(rs.getInt("id_specialite"));


            }

            System.out.println("Etudiants vu");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if (conn!=null){
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return etudiant;
    }

    public List<Etudiant> list(){
        Connection conn=null;
        List<Etudiant> etudiants = new ArrayList<>();
        try{
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiat_management","simo","1234");
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/etudiat_management");
            dataSource.setUsername("simo");
            dataSource.setPassword("1234");
            conn=dataSource.getConnection();

            String query = "SELECT * FROM etudiant";
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Etudiant etudiant = new Etudiant();
                etudiant.setNom(rs.getString("nom"));
                etudiant.setPrenom(rs.getString("prenom"));
                etudiant.setEmail(rs.getString("email"));
                etudiant.setTelephone(rs.getInt("telephone"));
                etudiant.setId_spcialite(rs.getInt("id_specialite"));
                etudiants.add(etudiant);

            }

            System.out.println("Etudiants List");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if (conn!=null){
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return etudiants;
    }
}
