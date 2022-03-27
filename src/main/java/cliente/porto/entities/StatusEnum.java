package cliente.porto.entities;

public enum StatusEnum {
    CHEIO(0),
    VAZIO(1);

    private int code;

    private StatusEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static StatusEnum valueOf(int code) {
        for (StatusEnum value : StatusEnum.values()) {
            if(value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Status");
    }
}
