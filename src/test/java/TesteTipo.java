import modelo.Tipo;

public class TesteTipo {
    public static void main(String[] args) {
        Tipo tipo = new Tipo();
        tipo.setPk(10);
        tipo.setNome("Teste");
        System.out.println(tipo);
    }
}
