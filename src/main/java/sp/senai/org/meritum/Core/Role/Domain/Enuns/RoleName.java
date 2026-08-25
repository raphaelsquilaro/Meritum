package sp.senai.org.meritum.Core.Role.Domain.Enuns;

public enum RoleName {
    ADMIN("Administração"),
    COORDINATION("Coordenação"),
    TEACHER("Professor"),
    STUDENT_COUNCIL("Conselho Estudantil"),
    CLASS_LEADER("Líder de Classe"),
    STUDENT("Estudante");

    private final String descricao;

    RoleName(String descricao) {this.descricao = descricao;}

    public String getDescricao() {return descricao;}
}
