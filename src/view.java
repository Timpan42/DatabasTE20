import javax.swing.*;

public class view {
    private JPanel panel1;
    private JButton Post;
    private JButton Registrera;
    private JButton Login;
    private JScrollPane ForumList;

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JButton getPost() {
        return Post;
    }

    public void setPost(JButton post) {
        Post = post;
    }

    public JButton getRegistrera() {
        return Registrera;
    }

    public void setRegistrera(JButton registrera) {
        Registrera = registrera;
    }

    public JButton getLogin() {
        return Login;
    }

    public void setLogin(JButton login) {
        Login = login;
    }

    public JScrollPane getForumList() {
        return ForumList;
    }

    public void setForumList(String forumList) {
        this.ForumList.setText(forumList);
    }
}
