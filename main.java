/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macbook
 */
public class main {
    public static void main(String[] args){
        procesos procesito = new procesos(); //se crea una referencia a procesos.
        procesito.crear_filos();    //se crean los filósofos, con estados aleatorios
        for(int i = 0; i<10;i++){ //el portero actuará 10 veces
            procesito.portero();    //llamada a la función portero
        }
        
    }

}   //fin de main

class procesos {    //clase procesos empieza
    filosofo inicio  = null, fin = null;//se crean las referencias de tipo filosofo
    
    public void atender(filosofo fil){ //esta función toma como parámetro a un nodo de tipo filósofo, el cual tiene hambre, por lo que se le debe asignar lugar y sentarlo
        if(num_comiendo()==4){//en caso de que estén 4 personas comiendo, se le pondrá en espera
            fil.espera=fil.espera+1;
        }else{//en otro caso
            fil.espera=0; //se reinicia el tiempo de espera
            fil.mesa=true; //se sienta el filósofo para esperar que se le asignen cubiertos
        }
    }
    
    public void comer(filosofo fil){//esta función hace que el filósofo coma, hasta que un número aleatorio sea 2
        int comer=0;
        while(comer == 2){
            comer = (int)(Math.random()*10+1);
        }
        fil.estado='P';//cuando termina estará pensando y aún en la mesa, por lo que se le pedirá que se levante y se vaya a pensar
    }
    
    public void pensar(filosofo fil){ //esta función hace que el filósofo piense
        int pensar=0; //se pone pensar en 0
        while(pensar ==2){ //se hará un ciclo aleatorio
            pensar = (int)(Math.random()*20+1);
        }
        fil.estado='H';
    }
    
    public void tomar_palillos(filosofo fil){//aquí checa el portero cuántas personas están ocupando palillos, si hay 4, se pondrá en espera
        if(num_comiendo()==4){
            fil.espera=fil.espera+1;
            fil.mesa=false;
            fil.estado='H';
        }else{//en otro caso, se le sentará y comerá
            fil.palillos=true;
            fil.espera=0;
            fil.estado='C';
        }
    }
    
    public void portero(){//el portero checa el estado de los filósofos cada ciclo, y dependiendo de su estado actuará
        
        filosofo aux = inicio;        
        System.out.println("\n");   
        
            while(aux!=null){
                if(aux.mesa==true&&aux.estado=='P'){
                    
                    System.out.println("El filósofo "+aux.num_fil+" se levantó de la mesa");
                    aux.palillos=false;
                    aux.mesa = false;
                    
                }else if(aux.mesa == true && aux.estado == 'C'){
                    
                    System.out.println("El filósofo "+aux.num_fil+" está comiendo");
                    comer(aux);
                    
                }else if(aux.mesa == true && aux.estado == 'H'){
                    
                    System.out.print("El filósofo "+aux.num_fil+" espera tomar palillos");
                    tomar_palillos(aux);
                    if(aux.estado=='H'){
                        System.out.print("....... se le pidió que se retire de la mesa y que espere.\n");
                    }else{
                        System.out.print("....... se le dieron palillos y comerá.\n");
                    }
                    
                }else if(aux.mesa == false && aux.estado == 'P'){
                    
                    System.out.println("El filósofo "+aux.num_fil+" no está en la mesa y está pensando");
                    pensar(aux);
                    
                }else if(aux.mesa == false && aux.estado == 'H'){
                    
                    if(aux.espera ==1){
                        int filo_levantado = pedir_levantarse(aux);
                        if(filo_levantado==0){
                            System.out.println("El filósofo "+aux.num_fil+" será sentado a la fuerza para que no muera, ya que todos se acaban de levantar");
                            aux.estado='C';
                            aux.mesa= true;
                            tomar_palillos(aux);
                            aux.espera=0;
                        }else{
                            System.out.print("\tEl filósofo "+filo_levantado+" dejó su lugar para que coma el filósofo "+aux.num_fil+"\n");
                            aux.espera=0;
                            comer(aux);
                        }
                    }else if(aux.espera ==2){
                        aux.estado='M';
                        System.out.println("El filósofo "+aux.num_fil+" acaba de morir");
                    }else{
                        System.out.println("El filósofo "+aux.num_fil+" espera ser atendido");
                        atender(aux);
                    }
                    
                }else if(aux.mesa == false && aux.estado=='M'){
                    
                    System.out.println("El filósofo "+aux.num_fil+" murió de hambre");
                    
                }else if(aux.mesa == true && aux.estado=='M'){
                    
                    System.out.println("El filósofo "+aux.num_fil+" murió de hambre");
                    
                }            
                aux = aux.sig;
            }
    }
    
    public int pedir_levantarse(filosofo fil){
        filosofo aux = inicio;
        while(aux!=null){
            if(aux.estado=='C'){
                aux.estado='H';
                aux.mesa=false;
                aux.palillos = false;
                fil.estado='C';               
                fil.mesa=true;
                fil.palillos=true;
                return aux.num_fil;
            }
            aux= aux.sig;
        }
        return 0;
    }
    
    public int num_comiendo(){
        filosofo aux = inicio;
        int contador = 0;
        while(aux!= null){
            if(aux.palillos==true){
               contador++; 
            }
            aux = aux.sig;
        }        
        return contador;
    }
    
    public void crear_filos(){
        for(int i = 0; i<8;i++){
            filosofo nuevo = new filosofo();
            int estado = (int)(Math.random()*3+1);
            
            int mesa = (int)(Math.random()*2+1);  
            char ayuda = estado(estado);
            boolean ah = mesa(mesa);
            nuevo.estado = ayuda;
            nuevo.mesa = ah;
            nuevo.num_fil=i+1;
            if(nuevo.estado == 'C'){
                nuevo.palillos=true;
            }
            if(nuevo.estado == 'C'&&nuevo.mesa== false){
                nuevo.estado='H';
            }
            if(inicio == null){
                inicio = nuevo;
                fin = nuevo;
            }else{
                fin.sig = nuevo;
                fin = nuevo;
                fin.sig = null;
            }
        }
    }   
    
    public boolean mesa(int num){
        if(num == 1)
            return true;
        else
            return false;
    }
    
    public char estado(int num){
        switch (num){
            case 1:
                return 'C';
            case 2:
                return 'P';
            case 3:
                return 'H';
            case 4:
                return 'M';
            default:
                return 'N';
                
        }
    }
}

class filosofo{//creamos la clase filósofo
    int num_fil;
    boolean mesa;
    char estado;
    int espera;
    boolean palillos;
    filosofo sig;
}
