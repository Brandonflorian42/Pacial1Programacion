package Calculadora;


class Calculadora {
    public int sumar(int a, int b) {
        return a + b;
    }

    public int restar(int a, int b) {
        return a - b;
    }
}


class Logger {
    public void log(String mensaje) {
        System.out.println("Registro: " + mensaje);
    }
}


//*********************************************************************************


class CalculadoraYLogger {
    public int sumar(int a, int b) {
        int resultado = a + b;
        System.out.println("Resultado de la suma: " + resultado);
        return resultado;
    }

    public int restar(int a, int b) {
        int resultado = a - b;
        System.out.println("Resultado de la resta: " + resultado);
        return resultado;
    }
}