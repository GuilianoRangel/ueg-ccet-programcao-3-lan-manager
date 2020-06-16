import exceptions.PersistenceException;
import modelo.Vlan;
import persistence.Dao;
import persistence.IDao;
import utils.Return;

public class TestVlan {
    public static void main(String[] args) {
        testeInsert();
    }

    private static void testeInsert() {
        IDao d = new Dao(new Vlan());

        Vlan vlan = new Vlan();
        vlan.setVlan("001");
        vlan.setNome("Vlan de Administração");

        try {
            Return insert = d.insert(vlan);
            System.out.println(insert);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }
}
