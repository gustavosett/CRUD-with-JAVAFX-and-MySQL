/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package novo.crud;

/**
 *
 * @author Gusta
 */
public class Pessoa {
    
    private int iD;
    private String nome;
    private int idade;
    private char sexo;

    public Pessoa(int iD, String nome, int idade, char sexo) {
        this.iD = iD;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
}