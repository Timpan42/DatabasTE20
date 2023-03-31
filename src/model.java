import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.sql.*;
import java.util.ArrayList;

public class model {

    ArrayList<Integer> forumId = new ArrayList<>();
    ArrayList<String> forumContent = new ArrayList<>();
    ArrayList<String> forumTitel = new ArrayList<>();
    ArrayList<Timestamp> forumCreatedAt = new ArrayList<>();
    ArrayList<Integer> forumAuthorId = new ArrayList<>();
    ArrayList<Integer> usersId = new ArrayList<>();
    ArrayList<String> usersName = new ArrayList<>();
    ArrayList<String> usersPassword = new ArrayList<>();

    public ArrayList<Integer> getForumId() {
        return forumId;
    }

    public void setForumId(ArrayList<Integer> forumId) {
        this.forumId = forumId;
    }

    public ArrayList<String> getForumContent() {
        return forumContent;
    }

    public void setForumContent(ArrayList<String> forumContent) {
        this.forumContent = forumContent;
    }

    public ArrayList<String> getForumTitel() {
        return forumTitel;
    }

    public void setForumTitel(ArrayList<String> forumTitel) {
        this.forumTitel = forumTitel;
    }

    public ArrayList<Timestamp> getForumCreatedAt() {
        return forumCreatedAt;
    }

    public void setForumCreatedAt(ArrayList<Timestamp> forumCreatedAt) {
        this.forumCreatedAt = forumCreatedAt;
    }

    public ArrayList<Integer> getForumAuthorId() {
        return forumAuthorId;
    }

    public void setForumAuthorId(ArrayList<Integer> forumAuthorId) {
        this.forumAuthorId = forumAuthorId;
    }

    public ArrayList<Integer> getUsersId() {
        return usersId;
    }

    public void setUsersId(ArrayList<Integer> usersId) {
        this.usersId = usersId;
    }

    public ArrayList<String> getUsersName() {
        return usersName;
    }

    public void setUsersName(ArrayList<String> usersName) {
        this.usersName = usersName;
    }

    public ArrayList<String> getUsersPassword() {
        return usersPassword;
    }

    public void setUsersPassword(ArrayList<String> usersPassword) {
        this.usersPassword = usersPassword;
    }

    Connection conn = null;
    public void databaseConector() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + DatabaseLoginData.DBURL + ":" + DatabaseLoginData.port + "/" + DatabaseLoginData.DBname +
                            "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    DatabaseLoginData.user, DatabaseLoginData.password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getForum(){
        int j = 0;
        try {
            Statement stmt = conn.createStatement();
            String SQLQuery = "SELECT * FROM tf03forum";
            ResultSet result = stmt.executeQuery(SQLQuery);

            ResultSetMetaData metadata = result.getMetaData();

            int numCols = metadata.getColumnCount();
            for (int i = 1 ; i <= numCols ; i++) {
                System.out.println(metadata.getColumnClassName(i));
            }
            while (result.next()) {
              forumId.add(result.getInt("id"));
              forumContent.add(result.getString("content"));
              forumTitel.add(result.getString("title"));
              forumCreatedAt.add(result.getTimestamp("createdAt"));
              forumAuthorId.add(result.getInt("authorId"));
              j += 1;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printArrays(){
        for (int i = 0; i < forumId.size(); i++) {
            System.out.println(""+forumTitel.get(i) +
                    "," + forumContent.get(i) +
                    "" + forumAuthorId.get(i) +
                    "" + forumId.get(i) +
                    "" + forumCreatedAt.get(i));
        }
    }

    public static void main(String[] args) {
        model m = new model();
        m.databaseConector();
        m.getForum();
        m.printArrays();
    }
}
