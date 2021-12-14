package Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Role implements GrantedAuthority{

    @Id
    private String nomeRole;

    @ManyToMany(mappedBy = "roles")
    private List<Produto> produtos;

    public String getNomeRole() {
        return nomeRole;
    }

    public void setNomeRole(String nomeRole) {
        this.nomeRole = nomeRole;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String getAuthority() {
        // TODO Auto-generated method stub
        return this.nomeRole;
    }


}

