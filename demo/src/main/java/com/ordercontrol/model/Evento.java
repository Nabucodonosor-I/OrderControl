package Conexao;

public class Evento {
    private int id;
    private int tipoEvento;
    private String nomeCliente;
    private String local;
    private String data;
    private String hora;
    private String descricao;


    public Evento(int tipoEvento, String nomeCliente, String local, String data, String hora, String descricao) {
        this.tipoEvento = tipoEvento;
        this.nomeCliente = nomeCliente;
        this.local = local;
        this.data = data;
        this.hora = hora;
        this.descricao = descricao;
    }

    public Evento() {
    }

    public int getTipoEvento() {
        return tipoEvento;
    }
    
    public String getTipoEventoToString() {
        if(tipoEvento == 0) {
            return "Ordem de Serviço" ;
        } else if (tipoEvento == 1) {
            return "Orçamento";
        } else {
            return "erro";
        }
        
    }
    public void setTipoEvento(int tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }   
}
