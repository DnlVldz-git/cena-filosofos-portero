package Control;

public class Respuestas {

    private Integer identificador;
    private String respuesta;

    public Respuestas(String respuesta) {
        this.respuesta = respuesta;
    }

    public Respuestas(String respuesta, Integer identificador) {
        this.respuesta = respuesta;
        this.identificador = identificador;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }
}
