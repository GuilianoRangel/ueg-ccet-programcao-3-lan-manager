package modelo;

import lombok.Data;
import model.Table;
import utils.Return;

import java.util.Arrays;
import java.util.List;

public @Data class Tipo extends Table<Integer> {
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

    public Return setTableColumnValues(List<Object> list) {
        Return ret = new Return(true,"sucesso");
        try {
            this.setPk((Integer) list.get(0));
        }catch (Exception e){
            setReturnColumnError("pk", list.get(0),ret);
        }
        try {
            this.setNome((String) list.get(1));
        }catch (Exception e){
            setReturnColumnError("nome", list.get(1),ret);
        }
        return ret;
    }

    public Object getColumnValue(String s) {
        if(s.equals("idTipo")){
            return this.getPk();
        }else if(s.equals("tipo")){
            return this.getNome();
        }
        return null;
    }

    public String getPkColumnName() {
        return "idTipo";
    }

    public boolean usePkInInsert() {
        return false;
    }
}
