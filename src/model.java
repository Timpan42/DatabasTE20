import java.sql.*;

public class model {

    int forumId;
    String forumContent;
    String forumTitel;
    Timestamp forumCreatedAt;
    int forumAuthorId;
    int usersId;
    String usersName;
    String usersPassword;

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    public String getForumContent() {
        return forumContent;
    }

    public void setForumContent(String forumContent) {
        this.forumContent = forumContent;
    }

    public String getForumTitel() {
        return forumTitel;
    }

    public void setForumTitel(String forumTitel) {
        this.forumTitel = forumTitel;
    }

    public Timestamp getForumCreatedAt() {
        return forumCreatedAt;
    }

    public void setForumCreatedAt(Timestamp forumCreatedAt) {
        this.forumCreatedAt = forumCreatedAt;
    }

    public int getForumAuthorId() {
        return forumAuthorId;
    }

    public void setForumAuthorId(int forumAuthorId) {
        this.forumAuthorId = forumAuthorId;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public String getUsersPassword() {
        return usersPassword;
    }

    public void setUsersPassword(String usersPassword) {
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

    public void forumPrint(){
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
                String output = "";
                output += result.getInt("id") + ", " +
                        result.getString("content") + ", " +
                        result.getString("title") + ", " +
                        result.getTimestamp("createdAt") + ", " +
                        result.getInt("authorId");
                System.out.println(output);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        model m = new model();
        m.databaseConector();
        m.forumPrint();
    }
}
