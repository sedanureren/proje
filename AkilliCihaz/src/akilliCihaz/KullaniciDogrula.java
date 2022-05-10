package akilliCihaz;

import java.sql.*;

public class KullaniciDogrula extends Kullanici implements IKullaniciDogrula {
    private final String url = "jdbc:postgresql://localhost:5432/akilliCihaz";
    private final String user = "postgres";
    private final String password = "123456";


    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public KullaniciDogrula() {
        super();

    }

    @Override
    public boolean kullaniciDogrula(String kullaniciAdi, String sifre, boolean yetki) {
        try {
            Connection conn = this.connect();
            if (conn != null) {
                String GetUsersSQL = "Select * From public.\"kullanicilar\"";
                Statement stmt = conn.createStatement();
                ResultSet result = stmt.executeQuery(GetUsersSQL);
                conn.close();

                boolean dogrula = false;
                while (result.next()) {
                    if (result.getString("kullaniciAdi").equals(kullaniciAdi) && result.getString("sifre").equals(sifre)){
                        dogrula = true;
                    }
                }

                if (dogrula) {
                    System.out.println("\nArayüze Hoşgeldiniz");
                    return true;
                }else {
                    System.out.println("\nArayüze giriş yapamadınız...!\n");
                    return false;
                }
            }
            else {
                System.out.println("Veritabanına baglanamadınız");
                return false;
            }
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

}


