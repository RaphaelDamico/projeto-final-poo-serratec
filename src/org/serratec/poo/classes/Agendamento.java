package org.serratec.poo.classes;

public class Agendamento {
    private Horario horario;
    private String aluno;
    private String personalTrainer;
    public enum Status{
        PENDENTE ("Pendente"), CONCLUIDO ("Concluído"), DESMARCADO ("Desmarcado");

        private String status;
        private Status(String status) {
            this.status = status;
        }
    }
    private Status status;

    public Agendamento(Horario horario, String aluno, String personalTrainer, String status) {
        this.horario = horario;
        this.aluno = aluno;
        this.personalTrainer = personalTrainer;
        this.status = Status.valueOf(status.toUpperCase());
    }

    public Horario getHorario() {
        return horario;
    }

    public String getAluno() {
        return aluno;
    }

    public String getPersonalTrainer() {
        return personalTrainer;
    }

    @Override
    public String toString() {
        return String.format("""
                Aluno: %s
                Personal: %s
                Dia: %s     Horario: %s""", aluno, personalTrainer, horario.getData(), horario.getHora());
    }
    public String toString2() {
        return String.format("%s;%s;%s;%s", aluno, personalTrainer, horario.getData(), horario.getHora());
    }
}
