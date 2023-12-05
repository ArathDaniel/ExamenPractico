package com.mycompany.video;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Ventana extends JFrame {
    private Timer timer;
    private JLabel videoLabel;
    private JButton playPauseButton;
    private boolean isPlaying = false;
    
    public Ventana(){
        setTitle("Reproductor de Video Simple");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Etiqueta para mostrar el video
        videoLabel = new JLabel();
        videoLabel.setHorizontalAlignment(JLabel.CENTER);
        
        // Botón de reproducción/pausa
        playPauseButton = new JButton("Play");
        playPauseButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isPlaying){
                    pausarVideo();
                }else{
                    playVideo();
                }
            }
        });
        
        // Configurar el diseño
        setLayout(new BorderLayout());
        add(videoLabel, BorderLayout.CENTER);
        add(playPauseButton, BorderLayout.SOUTH);
        
        
        // Establece la ubicación del archivo de video
        String videoPath = "craneo_carta_de_trabajo.mp4"; // Cambia esto a la ruta de tu video
        
        try {
            URL videoURL = new URL("file://" + videoPath);
            videoLabel.setIcon(new ImageIcon(videoURL));
            
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Inicializa el temporizador para actualizar la reproducción
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
    
    private void playVideo() {
        isPlaying = true;
        playPauseButton.setText("Pause");
        timer.start();
    }

    private void pausarVideo() {
        isPlaying = false;
        playPauseButton.setText("Play");
        timer.stop();
    }
}