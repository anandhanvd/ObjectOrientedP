package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;

import controller.MainFrame;

public class SelectionScreen extends JPanel {
    private MainFrame main;
    private JList<String> musicList;
    private JList<String> movieList;
    private DefaultListModel<String> musicListModel;
    private DefaultListModel<String> movieListModel;
    private String[] musicData = {"THE BEATLES", "BON VOYAGE", "THE BLUES", "NEVER SAY NEVER","NONE"};
    private String[] movieData = {"BATMAN", "SUPERMAN", "SPIDERMAN", "TRANSFORMERS", "WONKA", "INSIDIOUS", "OPPENHEIMER", "BARBIE","NONE"};
    private ImageIcon batmanIcon = new ImageIcon(this.getClass().getResource("/assets/batman.jpg"));
    private ImageIcon superman = new ImageIcon(this.getClass().getResource("/assets/superman.jpg"));
    private ImageIcon spiderman = new ImageIcon(this.getClass().getResource("/assets/spiderman.jpg"));
    private ImageIcon wonka = new ImageIcon(this.getClass().getResource("/assets/wonka.jpg"));
    private ImageIcon transformer = new ImageIcon(this.getClass().getResource("/assets/transformers.jpg"));
    private ImageIcon insi = new ImageIcon(this.getClass().getResource("/assets/insidious.jpg"));
    private ImageIcon barbie = new ImageIcon(this.getClass().getResource("/assets/barbie.jpg"));
    private ImageIcon blue = new ImageIcon(this.getClass().getResource("/assets/blues.jpg"));
    private ImageIcon beatle = new ImageIcon(this.getClass().getResource("/assets/beatless.jpg"));
    private ImageIcon never = new ImageIcon(this.getClass().getResource("/assets/never.jpg"));
    private ImageIcon bon = new ImageIcon(this.getClass().getResource("/assets/bon.jpg"));
    private ImageIcon oppen = new ImageIcon(this.getClass().getResource("/assets/oppenheimer.jpg"));

   
    public SelectionScreen(MainFrame main) {
        this.main = main;
        setLayout(null);

        JLabel lblItemSelection = new JLabel("Item Selection");
        lblItemSelection.setFont(new Font("Yu Gothic UI", Font.ITALIC, 16));
        lblItemSelection.setBounds(147, 36, 132, 16);
        add(lblItemSelection);

        // Create the music list and set the data
        musicListModel = new DefaultListModel<>();
        for (String music : musicData) {
            musicListModel.addElement(music);
        }
        musicList = new JList<>(musicListModel);
        JScrollPane musicScrollPane = new JScrollPane(musicList);
        musicScrollPane.setBounds(12, 99, 200, 160);
        add(musicScrollPane);

        // Create the movie list and set the data
        movieListModel = new DefaultListModel<>();
        for (String movie : movieData) {
            movieListModel.addElement(movie);
        }
        movieList = new JList<>(movieListModel);
        JScrollPane movieScrollPane = new JScrollPane(movieList);
        movieScrollPane.setBounds(238, 99, 200, 160);
        add(movieScrollPane);

        // Create JLabel to show the image
        JLabel imageLabel = new JLabel();
        imageLabel.setBounds(40, 282, 150, 150); // Adjust the size and position as needed
        add(imageLabel);

        movieList.addListSelectionListener(e -> {
            String selectedMovie = movieList.getSelectedValue();
            if (selectedMovie != null && selectedMovie.equals("BATMAN")) {
                imageLabel.setIcon(batmanIcon);
            } 
            else if(selectedMovie != null && selectedMovie.equals("SUPERMAN")) {
                imageLabel.setIcon(superman);
            } 
            else if(selectedMovie != null && selectedMovie.equals("SPIDERMAN")) {
                imageLabel.setIcon(spiderman);
            } 
            else if(selectedMovie != null && selectedMovie.equals("WONKA")) {
                imageLabel.setIcon(wonka);
            } 
            else if(selectedMovie != null && selectedMovie.equals("TRANSFORMERS")) {
                imageLabel.setIcon(transformer);
            } 
            else if(selectedMovie != null && selectedMovie.equals("INSIDIOUS")) {
                imageLabel.setIcon(insi);
            }  else if(selectedMovie != null && selectedMovie.equals("BARBIE")) {
                imageLabel.setIcon(barbie);
            }  else if(selectedMovie != null && selectedMovie.equals("OPPENHEIMER")) {
                imageLabel.setIcon(oppen);
            }});
            musicList.addListSelectionListener(e -> {
                String selectedMusic = musicList.getSelectedValue();
             if(selectedMusic != null && selectedMusic.equals("THE BLUES")) {
                imageLabel.setIcon(blue);
            }  
            else if(selectedMusic != null && selectedMusic.equals("BON VOYAGE")) {
                imageLabel.setIcon(bon);
            } 
            else if(selectedMusic != null && selectedMusic.equals("THE BEATLES")) {
                imageLabel.setIcon(beatle);
            }
            else if(selectedMusic != null && selectedMusic.equals("NEVER SAY NEVER")) {
                imageLabel.setIcon(never);
            } 
            else {
                imageLabel.setIcon(null); // Clear the image if another item is selected
            }
        });

        JButton btnAddToCart = new JButton("Add to Cart");
        btnAddToCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedMusic = musicList.getSelectedValue();
                String selectedMovie = movieList.getSelectedValue();
                main.getController().storeItem(selectedMusic, selectedMovie);
            }
        });
        btnAddToCart.setBounds(306, 283, 132, 25);
        add(btnAddToCart);

        JButton btnGoToCart = new JButton("Go To Cart");
        btnGoToCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.showCartScreen();
            }
        });
        btnGoToCart.setBounds(316, 321, 97, 25);
        add(btnGoToCart);
    }
}
