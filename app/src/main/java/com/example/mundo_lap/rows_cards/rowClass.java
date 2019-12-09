package com.example.mundo_lap.rows_cards;

public class rowClass  {
    private String title;
    private String precio;
    private String imagen;

    public rowClass(String title, String precio, String imagen) {
        this.title = title;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
