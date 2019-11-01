import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexaoBanco {
    ConexaoBanco() {

    }

    public static void connectionUtil() {
        Connection con;

        String url = "jdbc:postgresql://localhost:5432/portal";
        String user = "postgres";
        String pass = "postgres";

        try {
             con = DriverManager.getConnection(url, user, pass);
            Statement statement = con.createStatement();
            String sql = "select * from produtos";

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                int quantidade = resultSet.getInt("quantidade");
                int valor = resultSet.getInt("valor");

                System.out.println(nome + "," + quantidade + ", R$" + valor);
            }
            statement.close();
            resultSet.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}