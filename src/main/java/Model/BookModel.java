package Model;
import Entity.Author;
import Entity.Book;

import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import static Database.conectionDB.*;


public class BookModel implements IsCrudable{



    public  List<Object> getAll(){
        List<Object> listBook = new ArrayList<>();

        try {
            connectToDataBase();
            String query ="SELECT * From books;";
            pstm = databaseConnection.prepareStatement(query);
            ResultSet dataSet = pstm.executeQuery();
            while (dataSet.next()){
                Book addableBook = new Book();
                addableBook.setAuthorID(dataSet.getInt("idAuthor"));
                addableBook.setId(dataSet.getInt(("id")));
                addableBook.setTitle(dataSet.getString("title"));
                addableBook.setYearPublication(dataSet.getString("yearPublication"));
                addableBook.setPrice(dataSet.getDouble("price"));
                listBook.add(addableBook);
            }
        }catch (Exception e){
            System.out.println("Error Getting books :  " + e.getMessage());
            return null;
        }
        return listBook;
    }

    public List<Object> getAllWithAuthors(){
        List<Object> listBook = new ArrayList<>();
        try {
            connectToDataBase();
            String query ="SELECT * FROM books INNER JOIN authors ON idAuthor WHERE books.idAuthor = authors.id;";
            pstm = databaseConnection.prepareStatement(query);
            ResultSet dataSet = pstm.executeQuery();
            while (dataSet.next()){
                Book addableBook = new Book();
                Author addableAuthor = new Author();
                addableBook.setAuthorID(dataSet.getInt("idAuthor"));
                addableBook.setId(dataSet.getInt(("id")));
                addableBook.setTitle(dataSet.getString("title"));
                addableBook.setYearPublication(dataSet.getString("yearPublication"));
                addableBook.setPrice(dataSet.getDouble("price"));
                addableAuthor.setId(dataSet.getInt("idAuthor"));
                addableAuthor.setName(dataSet.getString("name"));
                addableAuthor.setNationality(dataSet.getString("nationality"));
                addableBook.setAuthor(addableAuthor);
                listBook.add(addableBook);
            }
        }catch (Exception e){
            System.out.println("Error Getting books :  " + e.getMessage());
        }
        return listBook;
    }
    public Object getbyId(int id) {
        Book addableBook;
        try {
            addableBook = new Book();
            connectToDataBase();
            String query = "SELECT * FROM books WHERE id = ?";
            pstm = databaseConnection.prepareStatement(query);
            pstm.setInt(1, id);
            ResultSet dataSet = pstm.executeQuery();
            while (dataSet.next()) {
                addableBook.setAuthorID(dataSet.getInt("idAuthor"));
                addableBook.setId(dataSet.getInt(("id")));
                addableBook.setTitle(dataSet.getString("title"));
                addableBook.setYearPublication(dataSet.getString("yearPublication"));
                addableBook.setPrice(dataSet.getDouble("price"));
            }
        } catch (Exception e) {
            System.out.println("Error getting a book by Id : " + e.getMessage());
            return null;
        }
        return addableBook;
    }

    public  Object insert(Object objeto){
        Book libro = (Book) objeto;
        try{
            connectToDataBase();
            String query = "INSERT INTO books(idAuthor, title, yearPublication, price) VALUES(? , ? , ? , ?)";
            pstm = databaseConnection.prepareStatement(query);
            pstm.setInt(1,libro.getAuthorID());
            System.out.println(libro.getAuthorID());
            pstm.setString(2, libro.getTitle());
            pstm.setString(3, libro.getYearPublication());
            pstm.setDouble(4, libro.getPrice());
            pstm.executeUpdate();
        }catch (Exception e){
            System.out.println("Error getting a book by Id : "  + e.getMessage());
        }
        return null;
    }

    public Boolean update(Object objeto){
        Book libro = (Book) objeto;
        try{
            connectToDataBase();
            String query = "UPDATE books SET (idAuthor = ? , title = ? , yearPublication = ?, price = ?)";
            pstm = databaseConnection.prepareStatement(query);
            pstm.setInt(1,libro.getAuthorID());
            pstm.setString(2, libro.getTitle());
            pstm.setString(3, libro.getYearPublication());
            pstm.setDouble(4, libro.getPrice());
            pstm.execute();
            pstm.close();
            databaseConnection.close();
        }catch (Exception e){
            System.out.println("Error getting a book by Id : "  + e.getMessage());

        }
        return null;
    }

    public Boolean delete(Object objeto){
        Integer id = (Integer) objeto;
        try{
            connectToDataBase();
            String query = "DELETE FROM books WHERE id = ?";
            pstm = databaseConnection.prepareStatement(query);
            pstm.setInt(1, id);
            int rowsAfected = Integer.parseInt(String.valueOf(pstm.executeUpdate()));
            if (rowsAfected>0){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.println("Error getting a book by Id : "  + e.getMessage());
        }
        return null;
    }


    public void auxiliarLocalDB(){
        try{
            String query = "USE Ejercicio7";
            pstm = databaseConnection.prepareStatement(query);
            pstm.execute();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }




}