package edu.umg;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

//clase principal
public class JuegoSerpientesEscalerasGUI extends JFrame {
    //definimos constantes
    private static final int TAMANO_TABLERO = 64;
    private static final int NUMERO_JUGADORES = 2;
    private static final int LADOS_DADO = 6;
    private static final int MAX_LANZAMIENTOS = 10;

  //atributos
    private int[] posicionesJugadores;
    private int[] lanzamientosConsecutivos;
    private int lanzamientosTotales;

    private JTextArea logTextArea;
    private JButton lanzarDadoButton;

    public JuegoSerpientesEscalerasGUI() {
        setTitle("Juego de Serpientes y Escaleras");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        posicionesJugadores = new int[NUMERO_JUGADORES];
        lanzamientosConsecutivos = new int[NUMERO_JUGADORES];

        initComponents();
        inicializarJuego();
    }
        //Metodos
    private void initComponents() {
        logTextArea = new JTextArea();
        logTextArea.setEditable(false);

        lanzarDadoButton = new JButton("Lanzar Dado");
        lanzarDadoButton.setBackground(new Color(0, 128, 0));
        lanzarDadoButton.setForeground(Color.WHITE);
        lanzarDadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jugarTurno();
            }
        });

        JPanel panel = new JPanel();
        panel.add(logTextArea);
        panel.add(lanzarDadoButton);

        getContentPane().setBackground(Color.BLACK);  // Fondo negro
        panel.setBackground(Color.BLACK);  // Fondo negro
        logTextArea.setForeground(Color.BLACK);  // Texto en blanco
        add(panel);
    }

    private void inicializarJuego() {
        for (int i = 0; i < NUMERO_JUGADORES; i++) {
            posicionesJugadores[i] = 1;
            lanzamientosConsecutivos[i] = 0;
        }
        lanzamientosTotales = 0;
    }
//*****
    private int lanzarDado() {
        Random random = new Random();
        return random.nextInt(LADOS_DADO) + 1;
    }

    private void moverJugador(int jugador, int pasos) {
        posicionesJugadores[jugador] += pasos;

        for (int i = 0; i < origenCasillasEspeciales.length; i++) {
            if (posicionesJugadores[jugador] == origenCasillasEspeciales[i]) {
                posicionesJugadores[jugador] = destinoCasillasEspeciales[i];
                break;
            }
        }

        if (posicionesJugadores[jugador] > TAMANO_TABLERO) {
            int exceso = posicionesJugadores[jugador] - TAMANO_TABLERO;
            posicionesJugadores[jugador] = TAMANO_TABLERO - exceso;
        }
    }

    private boolean haGanado(int jugador) {
        return posicionesJugadores[jugador] == TAMANO_TABLERO;
    }

    private void jugarTurno() {
        if (lanzamientosTotales < MAX_LANZAMIENTOS) {
            for (int i = 0; i < NUMERO_JUGADORES; i++) {
                int dado = lanzarDado();
                logTextArea.append("Jugador " + (i + 1) + " lanzó un " + dado + "\n");

                if (dado == LADOS_DADO) {
                    lanzamientosConsecutivos[i]++;
                    if (lanzamientosConsecutivos[i] == 3) {
                        logTextArea.append("Jugador " + (i + 1) + " ha sacado tres 6 consecutivos. Vuelve a la posición 1.\n");
                        posicionesJugadores[i] = 1;
                        lanzamientosConsecutivos[i] = 0;
                        continue;
                    }
                } else {
                    lanzamientosConsecutivos[i] = 0;
                }

                moverJugador(i, dado);

                logTextArea.append("Jugador " + (i + 1) + " está en la posición " + posicionesJugadores[i] + "\n");

                if (haGanado(i)) {
                    logTextArea.append("¡Jugador " + (i + 1) + " ha ganado!\n");
                    lanzarDadoButton.setEnabled(false);
                    return;
                }
            }
            lanzamientosTotales++;
        } else {
            logTextArea.append("Se alcanzó el límite de lanzamientos. No hay ganador.\n");
            lanzarDadoButton.setEnabled(false);
        }
    }

    private static final int[] origenCasillasEspeciales = {9, 12, 32, 31, 41, 44, 51, 60};
    private static final int[] destinoCasillasEspeciales = {39, 38, 47, 3, 22, 61, 6, 43};

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JuegoSerpientesEscalerasGUI().setVisible(true);
            }
        });
    }
}
