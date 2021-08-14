package co.utp.reto2practica;

public class Nevera extends Electrodomestico{
    // Constantes y Atributos
    private final static Integer CAPACIDAD_BASE = 100;
    private Integer capacidad;

    //Constructores 
    public Nevera(){ 
        //Código 
        this(PRECIO_BASE, PESO_BASE, CONSUMO_W_BASE, CAPACIDAD_BASE);
    } 
    public Nevera(Double precioBase, Integer peso){ 
        //Código 
        this(precioBase, peso, CONSUMO_W_BASE, CAPACIDAD_BASE);
    } 
    public Nevera(Double precioBase, Integer peso, char consumoW, Integer capacidad){ 
        //Código 
        super(precioBase, peso, consumoW);
        this.capacidad = capacidad;
    } 
    // Métodos 
    public Double calcularPrecio(){ 
        //Código 
        Double adicion = super.calcularPrecio();
        if(capacidad>250){
            adicion += 100.0;
        }
        return adicion;
    }
    
}
