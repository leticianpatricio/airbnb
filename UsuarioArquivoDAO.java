import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UsuarioArquivoDAO implements UsuarioDAO {

    private String arquivo = "usuarios.txt";

    @Override
    public void salvar(Usuario usuario) {

        try {

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter(arquivo, true)
            );

            bw.write(
                    usuario.getNome() + ";" +
                    usuario.getEmail()
            );

            bw.newLine();

            bw.close();

        } catch (IOException e) {

            System.out.println(
                    "Erro ao salvar usuário."
            );
        }
    }

    @Override
    public ArrayList<Usuario> listar() {

        return new ArrayList<>();
    }
}