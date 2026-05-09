package section31;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.MysqlDataSource;

public class BusinessColumn {
    private Connection con;
    private static BusinessColumn bc;

    public static BusinessColumn getInstance() {
        if (bc == null) {
            bc = new BusinessColumn();
        }

        return bc;
    }    

    private Connection getConnection() throws SQLException {
        if (con == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setServerName("127.0.0.1");
            dataSource.setPort(3306);
            dataSource.setUser("root");
            dataSource.setPassword("root");
            dataSource.setDatabaseName("java_BusinessColumn");

            con = dataSource.getConnection();
        }

        return con;
    }

    public int addContact(Contact c) throws SQLException {
        String sql = "INSERT INTO contact(name, surname, phone) VALUES(?, ?, ?)";

        PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, c.getName());
        ps.setString(2, c.getSurname());
        ps.setString(3, c.getPhone());

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();

        return rs.getInt(1);
    }

    public List<Contact> searchContact() throws SQLException{
        String sql = "SELECT is, name, surname, phone FROM contact";

        PreparedStatement ps = getConnection().prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        List<Contact> contacts = new ArrayList<Contact>();
        while(rs.next()) {
            Contact c = new Contact();
            c.setId(rs.getInt(1));
            c.setName(rs.getString(2));
            c.setSurname(rs.getString(3));
            c.setPhone(rs.getString(4));

            contacts.add(c);
        }

        return contacts;
    }
}
