package br.com.desafio.dto;

public class ApiInfoDTO extends BaseDTO {

    private static final long serialVersionUID = 34654523524L;

    private String projeto;

    private String versao;

    public ApiInfoDTO(String projeto, String versao) {
        this.projeto = projeto;
        this.versao = versao;
    }

    public String getProjeto() {
        return projeto;
    }

    public void setProjeto(String projeto) {
        this.projeto = projeto;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }
}
