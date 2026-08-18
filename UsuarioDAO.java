import java.util.ArrayList;

public interface UsuarioDAO {
    void salvar(Usuario usuario);
    ArrayList<Usuario> listar();
}