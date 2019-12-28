package com.example.mundo_lap;

public class ListaDatos {
     String imagen;
     String precio;
     String marca;

    public ListaDatos(){}

    public ListaDatos(String imagen, String precio, String marca) {
        this.imagen = imagen;
        this.precio = precio;
        this.marca = marca;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}
