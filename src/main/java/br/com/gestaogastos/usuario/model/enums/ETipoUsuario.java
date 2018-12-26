package br.com.gestaogastos.usuario.model.enums;

public enum ETipoUsuario {

    SISTEMA("Sistema"), CLIENTE("Cliente");

    private final String valor;

    ETipoUsuario(String valorOpcao) {
        valor = valorOpcao;
    }

    public String getValor(){
        return valor;
    }
}
