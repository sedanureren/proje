package akilliCihaz;

public class SqlFactory implements IVeritabaniFactory {
    @Override
    public IVeritabani factoryMethod() {
        VeriTabani veriTabani= new VeriTabani("SQL");
        Sql sql=new Sql();
        sql.setAdi("SQL");
        System.out.println("Sql veritabanına veri gönderildi...");
        return  sql;
    }

}
