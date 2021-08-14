package co.utp.reto2practica;

public class Estufa extends Electrodomestico{
    // Constantes y Atributos
    private final static Integer BOQUILLAS_BASE = 2;
    private Integer boquillas; 
    private Boolean horno; 
    //Constructores public Estufa(){
     
    public Estufa(){ 
        //Código 
        this(PRECIO_BASE, PESO_BASE, CONSUMO_W_BASE, BOQUILLAS_BASE, false);
        
    }
    public Estufa(Double precioBase, Integer peso){ 
        //Código 
        this(precioBase, peso, CONSUMO_W_BASE, BOQUILLAS_BASE, false);
    } 
    public Estufa(Double precioBase, Integer peso, char consumoW, Integer boquillas, boolean horno){ 
        //Código 
        super(precioBase, peso, consumoW);
        this.boquillas = boquillas;
        this.horno = horno;
    } 
    // Métodos 
    public Double calcularPrecio(){ 
        //Código
        Double adicion = super.calcularPrecio();
        if(boquillas>2){
            adicion += precioBase*0.4;
        }
        if(horno){
            adicion += 150.0;
        }
        return adicion;             
    }
    
}
