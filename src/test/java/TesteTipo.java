import exceptions.PersistenceException;
import modelo.Tipo;
import persistence.Dao;
import persistence.IDao;
import utils.Return;

public class TesteTipo {
    public static void main(String[] args) {
        //testeModelo();
        testeListAll();
        Tipo t = new Tipo();
        t.setNome("Tipo de Teste");
        Dao d = new Dao(t);

        try {
           Return rt =  d.insert(t);
            System.out.println(rt);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

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
