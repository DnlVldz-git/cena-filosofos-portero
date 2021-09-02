/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cuestionario;

import java.util.ArrayList;

/**
 *
 * @author dani_
 */
public class Pregunta {
    private int id;
    private String instruccion;
    private String enunciado;
    private ArrayList<Respuesta> respuestas;
    
    public Pregunta(){
        respuestas = new ArrayList<Respuesta>();
    }
    
    public void addRespuesta(String respuesta, int indice){
        Respuesta resp = new Respuesta();
        resp.setIndice(indice);
        resp.setRespuesta(respuesta);
        respuestas.add(resp);
    }
    
    public ArrayList<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuesta(ArrayList<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstruccion() {
        return instruccion;
    }

    public void setInstruccion(String instruccion) {
        this.instruccion = instruccion;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    @Override
    public String toString() {
        return "Pregunta{" + "id=" + id + ", instruccion=" + instruccion + ", enunciado=" + enunciado + '}';
    }
    
    
}
