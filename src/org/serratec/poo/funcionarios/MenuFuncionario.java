package org.serratec.poo.funcionarios;

import org.serratec.poo.academia.Menu;

public class MenuFuncionario implements Menu {
    private Funcionario funcionario;

    public MenuFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    @Override
    public void exibeMenu() {
        System.out.printf("""
				1 - Cadastrar novo plano
				2 - Cadastrar novo aluno
				3 - Cadastrar novo Personal Trainer
				4 - Emitir relatório de planos
				5 - Emitir relatório de equipe
				6 - Emitir relação de avaliações físicas por período
				7 - Sair
				""");
    }

    @Override
    public void escolhaMenu(int opcao) {
        switch (opcao){
            case 1:
                cadastra();
                break;
            case 2:
                cadastra();
                break;
            case 3:
                cadastra();
                break;
            case 4:
                exibe();
                break;
            case 5:
                exibe();
                break;
            case 6:
                exibe();
                break;
            case 7:
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
