package org.serratec.poo.academia;
public enum Status {
    PENDENTE("Pendente"),
    CONCLUIDO("Concluído"),
    DESMARCADO ("Desmarcado");

    private String descricaoTextual;

    private Status(String descricaoTextual) {
        this.descricaoTextual = descricaoTextual;
    }

    public String getDescricaoTextual() {
        return descricaoTextual;
    }
}
