package modelo;

import lombok.Data;
import model.Table;
import utils.Return;

import java.util.Arrays;
import java.util.List;

public @Data class Vlan  extends Table<String> {

    private String nome;

    public String getVlan(){
        return this.getPk();
    }

    public void setVlan(String vlan){
        this.setPk(vlan);
    }

    public List<String> getColumnNames() {
        return Arrays.asList("vlan", "nome");
    }

    public String getTableName() {
        return "vlan";
    }

    public Table getNewTableObject() {
        return new Vlan();
    }

    public Return setTableColumnValues(List<Object> list) {
        Return ret = new Return(true, "sucesso");
        try {
            this.setPk((String) list.get(0));
        }catch (Exception e){
            setReturnColumnError("pk", list.get(0), ret);
        }
        try {
            this.setNome((String) list.get(1));
        }catch (Exception e ){
            setReturnColumnError("nome", list.get(1), ret);
        }
        return ret;
    }

    public Object getColumnValue(String s) {
        if(s.equals("pk") || s.equals("vlan")){
            return this.getVlan();
        }else if(s.equals("nome")){
            return this.getNome();
        }
        return null;
    }

    public String getPkColumnName() {
        return "vlan";
    }

    public boolean usePkInInsert() {
        return true;
    }
}
