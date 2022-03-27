package cliente.porto.entities;

public enum CategoriaEnum {
    IMPORTACAO(0),
    EXPORTACAO(1);

    private int code;

    private CategoriaEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static CategoriaEnum valueOf(int code) {
        for (CategoriaEnum value : CategoriaEnum.values()) {
            if(value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Categoria");
    }

}

