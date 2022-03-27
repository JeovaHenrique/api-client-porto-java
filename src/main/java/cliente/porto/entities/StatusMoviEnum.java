package cliente.porto.entities;

public enum StatusMoviEnum {
    EMBARQUE(0),
    DESCARGA(1),
    GATE_IN(2),
    GATE_OUT(3),
    REPOSICIONAMENTO(4),
    PESAGEM(5),
    SCANNER(6);

    private int code;

    private StatusMoviEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static StatusMoviEnum valueOf(int code) {
        for (StatusMoviEnum value : StatusMoviEnum.values()) {
            if(value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Status movement code");
    }

}
