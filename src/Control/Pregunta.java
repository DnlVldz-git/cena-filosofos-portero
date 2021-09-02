package Control;

import Control.Respuestas;

import java.util.ArrayList;

public class Pregunta{

    private Integer identificador;
    private String intrucciones;
    private String pregunta;
    private ArrayList<Respuestas> respuestas;

    public Pregunta(Integer identificador, String intrucciones, String pregunta, ArrayList<Respuestas> respuestas) {
        this.identificador = identificador;
        this.intrucciones = intrucciones;
        this.pregunta = pregunta;
        this.respuestas = respuestas;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getIntrucciones() {
        return intrucciones;
    }

    public void setIntrucciones(String intrucciones) {
        this.intrucciones = intrucciones;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public ArrayList<Respuestas> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ArrayList<Respuestas> respuestas) {
        this.respuestas = respuestas;
    }
}
