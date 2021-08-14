package co.utp.reto2practica;

public class PrecioTotal { 
    // Atributos 
    private Double totalElectrodomesticos = 0.0;
    private Double totalNeveras = 0.0;
    private Double totalEstufas = 0.0;
    private Electrodomestico[] listaElectrodomesticos;


    // Constructor 
    PrecioTotal(Electrodomestico[] pElectrodomesticos) { 
        //Codigo 
        this.listaElectrodomesticos = pElectrodomesticos;        
    } 
    //Metodos 
    public void mostrarTotales(){
        // Código 
        for(int i = 0; i< listaElectrodomesticos.length ; i++){
            
            if(listaElectrodomesticos[i] instanceof Electrodomestico){
                totalElectrodomesticos += listaElectrodomesticos[i].calcularPrecio();
            }
            if(listaElectrodomesticos[i] instanceof Nevera){
                totalNeveras += listaElectrodomesticos[i].calcularPrecio();
            }
            if(listaElectrodomesticos[i] instanceof Estufa){
                totalEstufas += listaElectrodomesticos[i].calcularPrecio();
            }


        }
    
        // Mostramos los resultados 
        System.out.println("La suma del precio de los Electrodomésticos es de " + totalElectrodomesticos); 
        System.out.println("La suma del precio de las Neveras es de " + totalNeveras); 
        System.out.print("La suma del precio de las Estufas es de " + totalEstufas);
    }
}
