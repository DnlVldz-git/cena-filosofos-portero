package Files;


import Cuestionario.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FilesJSON {

    private Gson gson;

    public FilesJSON() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void saveFile(Pregunta pregunta, String ruta) {
        try {
            Writer writer = Files.newBufferedWriter(Paths.get(ruta));
            gson.toJson(pregunta, writer);
            writer.close();
        } catch (Exception ex) {
            System.out.println("Peto");
        }
    }

    public Pregunta readFile(String ruta) {
        Pregunta pregunta = null;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(ruta));
            pregunta = gson.fromJson(reader, Pregunta.class);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pregunta;
    }

    public void saveFile(ArrayList<Pregunta> preguntas, String ruta){
        try {
            Writer writer = Files.newBufferedWriter(Paths.get(ruta));
            gson.toJson(preguntas, writer);
            writer.close();
            JOptionPane.showMessageDialog(null, "Se guardó exitosamente el objeto");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido guardar el archivo");
        }
    }


}