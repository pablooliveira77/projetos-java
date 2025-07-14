package banco;

import java.util.ArrayList;
import java.util.List;

public class ListaUsuarios {
    private List<Usuario> usuarios;

    public ListaUsuarios(List<Usuario> usuarios) {
        this.usuarios = new ArrayList<>(usuarios);
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void removerUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public Usuario buscarPorConta(int numeroConta) {
        for (Usuario u : usuarios) {
            if (u.getConta().getNumeroConta() == numeroConta) {
                return u;
            }
        }
        return null;
    }

    public Usuario buscarPorCpf(String cpf) {
        for (Usuario u : usuarios) {
            if (u.getCpf().equals(cpf)) {
                return u;
            }
        }
        return null;
    }
}
