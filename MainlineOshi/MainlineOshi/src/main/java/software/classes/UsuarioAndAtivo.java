package software.classes;

public class UsuarioAndAtivo {
    /* USUÁRIO */
    private static int idUser; 
    private static String nome;

    public static int getIdUser() {
        return idUser;
    }

    protected static void setIdUser(int idUser) {
        UsuarioAndAtivo.idUser = idUser;
    }

    public static String getNome() {
        return nome;
    }

    protected static void setNome(String nome) {
        UsuarioAndAtivo.nome = nome;
    }
   
   

     /* ATIVO */
    private static String idAtivo;

    public static String getIdAtivo() {
        return idAtivo;
    }

    protected static void setIdAtivo(String idAtivo) {
        UsuarioAndAtivo.idAtivo = idAtivo;
    }
}
