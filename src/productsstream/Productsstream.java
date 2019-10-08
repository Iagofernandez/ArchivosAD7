
package productsstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Productsstream {

   
    public static void main(String[] args) throws FileNotFoundException, IOException {
    // Crear un novo proxecto denominado productsstream  que cree una clase 
    //denominada Product e una clase principal  tal como se describen a continuacion:
        
        //Se crean tres obxectos con datos nas variables
      Producto producto1 = new Producto("cod1", "parafusos", 3d);
        Producto producto2 = new Producto("cod2", "cravos", 4d);
        Producto producto3 = new Producto();

        //escritura
        FileOutputStream escribir = null;
        BufferedOutputStream escribirBuffer = null;
        DataOutputStream escribirData = null;
        //lectura
        FileInputStream leer = null;
        BufferedInputStream leerBuffer = null;
        DataInputStream leerData = null;

        escribir = new FileOutputStream("/home/oracle/Desktop/Eje7/productos.txt");
        escribirBuffer = new BufferedOutputStream(escribir);
        escribirData = new DataOutputStream(escribirBuffer);

        escribirData.writeUTF(producto1.getCodigo());
        escribirData.writeUTF(producto1.getDescripcion());
        escribirData.writeDouble(producto1.getPrecio());

        escribirData.writeUTF(producto2.getCodigo());
        escribirData.writeUTF(producto2.getDescripcion());
        escribirData.writeDouble(producto2.getPrecio());

        escribirData.close();

     
        leer = new FileInputStream("/home/oracle/Desktop/Eje7/productos.txt");
        leerBuffer = new BufferedInputStream(leer);
        leerData = new DataInputStream(leerBuffer);

        while (leerData.available() != 0) {
            producto3.setCodigo(leerData.readUTF());
            producto3.setDescripcion(leerData.readUTF());
            producto3.setPrecio(leerData.readDouble());

            System.out.println(producto3.getCodigo() + "\n" + producto3.getDescripcion() + "\n" + producto3.getPrecio());
        }

    }
}



 class Producto{
    private String codigo;
    private String descripcion;
    private Double precio;

    public Producto() {

        codigo = "";
        descripcion = "";
        precio = 0d;

    }

    public Producto(String codigo, String descripcion, Double precio) {

        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;

    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getPrecio() {
        return precio;
}
    
    }
