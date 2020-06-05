package modelo;

import lombok.Data;
import model.Table;

import java.util.Arrays;
import java.util.List;

public @Data class Tipo extends Table {
    private String nome;

    public List<String> getColumnNames() {
        return Arrays.asList("idTipo", "tipo");
    }

    public String getTableName() {
        return "tipo";
    }

    public Table getNewTableObject() {
        return new Tipo();
    }

    public boolean setTableColumnValues(List<Object> list) {
        this.setPk((Integer) list.get(0));
        this.setNome((String) list.get(1));
        return true;
    }

    public String getPkColumnName() {
        return "idTipo";
    }

    public boolean usePkInInsert() {
        //TODO é só para teste
        return true;
    }
}
