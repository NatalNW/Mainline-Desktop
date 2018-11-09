package software.classes;

public class Usuario {
    /* USUÁRIO */
    private static String nome;

    public static String getNome() {
        return nome;
    }

    protected static void setNome(String nome) {
        Usuario.nome = nome;
    }
}
