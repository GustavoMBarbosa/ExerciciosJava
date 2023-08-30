package pessoa;

public class Pessoa {
	private String nome;
    private String cpf;
    private int idade;
    private char sexo;

    public Pessoa(String nome, String cpf, int idade, char sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;
    }
    
 // Métodos de acesso (getters) para os atributos
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public char getSexo() {
        return sexo;
    }

    // Métodos de modificação (setters) para os atributos
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
 // verificar se a pessoa é maior de idade
    public boolean eMaiorDeIdade() {
        return idade >= 18;
    }
    
}
