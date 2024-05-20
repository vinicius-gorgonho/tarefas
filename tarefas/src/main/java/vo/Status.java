package vo;

/**
 *
 * @author usuario
 */
public enum Status {
    PLANEJADA("Planejada"), PENDENTE("Pendente"), FAZENDO("Fazendo"), FEITA("Feita");

    private final String descricao;

    Status(String status) {
        this.descricao = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus(String status) {
        return switch (status) {
            case "PLANEJADA" ->
                "Planejada";
            case "PENDENTE" ->
                "Pendente";
            case "FAZENDO" ->
                "Fazendo";
            default ->
                "Planejada";
        };
    }

    public Status getValue() {
        return switch (descricao) {
            case "Planejada" ->
                PLANEJADA;
            case "PENDENTE" ->
                PENDENTE;
            case "Fazendo" ->
                FAZENDO;
            case "Feita" ->
                FEITA;
            default ->
                PLANEJADA;
        };
    }
}
