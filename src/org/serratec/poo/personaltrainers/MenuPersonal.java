package org.serratec.poo.personaltrainers;

import org.serratec.poo.academia.Menu;

public class MenuPersonal implements Menu {
    private PersonalTrainer personalTrainer;

    public MenuPersonal(PersonalTrainer personalTrainer) {
        this.personalTrainer = personalTrainer;
    }

    public PersonalTrainer getPersonalTrainer() {
        return personalTrainer;
    }

    @Override
    public void exibeMenu() {
        System.out.printf("""
				1 - Visualizar agenda de atendimentos
				2 - Registrar avaliações físicas dos alunos.
				3 - Visualizar lista de avaliações realizadas
				4 - Sair
				""");
    }

    @Override
    public void escolhaMenu(int opcao) {
        switch (opcao){
            case 1:
            	//Visualizar agenda de atendimentos.

                exibe();
                break;
            case 2:
            	// Registrar avaliações físicas dos alunos.
                cadastra();
                break;
            case 3:
            	//Visualizar lista de avaliações realizadas.

                exibe();
                break;
            case 4:
                break;
            default:
                System.out.println("Digite uma opção válida...\n");
                break;
        }
    }

    @Override
    public void exibe() {

    }

    @Override
    public void buscaAgendamento() {

    }

    @Override
    public void buscaAvaliacao() {

    }

    @Override
    public void cadastra() {

    }

    @Override
    public void remove() {

    }
}
