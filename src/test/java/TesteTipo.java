import modelo.Tipo;
import persistence.Dao;
import persistence.IDao;

public class TesteTipo {
    public static void main(String[] args) {
        //testeModelo();
        testeListAll();

    }

    private static void testeListAll() {
        IDao dao = new Dao(new Tipo());
        System.out.println(dao.listAll());
    }

    private static void testeModelo() {
        Tipo tipo = new Tipo();
        tipo.setPk(10);
        tipo.setNome("Teste");
        System.out.println(tipo);
    }
}
