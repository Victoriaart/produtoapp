package Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Produto implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;

    @NotEmpty
    private String produto;

    @NotEmpty
    private  String codigofabricante;

    @NotEmpty
    private String embalagem;

    @NotEmpty
    private String tipoembalagem;

    @NotEmpty
    private String quantidade;

    @OneToMany
    private List<Produto> produtos;

    @ManyToMany
    @JoinTable(name = "produto_roles",
            joinColumns = @JoinColumn(name = "produto_codigo", referencedColumnName = "roles_nome_role"))
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public long getCodigo() {
        return codigo;
    }
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }
    public String getCodigofabricante() {
        return codigofabricante;
    }
    public void setCodigofabricante(String codigofabricante) {
        this.codigofabricante = codigofabricante;
    }
    public String getEmbalagem() {
        return embalagem;
    }
    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }
    public String getTipoembalagem() {
        return tipoembalagem;
    }
    public void setTipoembalagem(String tipoembalagem) {
        this.tipoembalagem = tipoembalagem;
    }
    public String getQuantidade() {
        return quantidade;
    }
    public void setQuantidadem(String quantidade) {
        this.quantidade = quantidade;
    }

}
