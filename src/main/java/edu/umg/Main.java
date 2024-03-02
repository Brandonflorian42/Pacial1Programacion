package edu.umg;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creamos  un objeto de la clase moto
        Moto miMoto = new Moto();

        // luego Accedemos a los atributos y métodos del objeto
        miMoto.marca = "Honda";
        miMoto.modelo = "CRF";
        miMoto.año = 2022;

        System.out.println("Marca: " +  miMoto.marca);
        System.out.println("Modelo: " +  miMoto.modelo);
        System.out.println("Año: " + miMoto.año);

        miMoto.encender();
        miMoto.apagar();
    }
}

