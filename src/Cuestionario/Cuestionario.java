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
public class Cuestionario {
    ArrayList<Pregunta> preguntas;
    
    public Cuestionario(){
        preguntas = new ArrayList<Pregunta>();
    }

    public ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(ArrayList<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
    
    public void removePregunta(int num){
        preguntas.remove(num);
    }
    
    public void addPregunta(String enunciado, String instruccion, int id){
        Pregunta preg = new Pregunta();
        preg.setEnunciado(enunciado);
        preg.setInstruccion(instruccion);
        preg.setId(id);
        
        preguntas.add(preg);
    }

    @Override
    public String toString() {
        return "Cuestionario{" + "preguntas=" + preguntas + '}';
    }
}
