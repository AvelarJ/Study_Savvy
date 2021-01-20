
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.StringJoiner;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jordo
 */
public class Hangman extends javax.swing.JFrame {
    StringJoiner sj = new StringJoiner(" ");

    String[] schoolWords = {"homework", "semester", "cafeteria", "report card", 
            "science fair", "calculator", "calculus", "gymnasium",
            "curriculum", "vocabulary", "black board", "encyclopedia",
            "lunch box", "paper clip", "whiteboard", "yardstick", "student",
            "text book", "worksheet", "locker", "auditorium", "mathematics",
            "shakespeare", "computers", "yearbook", "principal", "teachers",};
    
    String[] animalWords = {"jaguar", "antelope", "hippopotamus", "beaver",
            "caribou", "chimpanzee", "flamingo", "cockatoo", "dolphin",
            "dragonfly", "silver backed fox", "grizzly bear", "hedgehog",
            "komodo dragon", "chipmunk", "elephant", "pheasant", "polar bear",
            "black panther", "blue jay", "anteater", "stallion", "opossum"};
    
    String [] countryWords = {"canada", "argentina", "belgium", "barbados",
            "bulgaria", "columbia", "costa rica", "cyprus", "denmark", "egypt",
            "el salvador", "finland", "france", "germany", "guatemala",
            "honduras", "indonesia", "ireland", "jamaica", "japan", "kazakhstan",
            "lebanon", "luxembourg", "madagascar", "mexico", "monaco", "morocco",
            "netherlands", "new zealand", "pakistan", "panama", "portugal",
            "sri lanka", "serbia", "syria", "thailand", "uganda", "ukraine", 
            "venezuela", "yemen","zimbabwe"};
    
    String[] fruitsVegWords = {"apricot", "asparagus", "avocado", "beetroot",
            "broccoli", "brussels sprout", "carrot", "cherry", "fennel",
            "garlic", "grape", "green bean", "guava", "honeydew melon",
            "iceberg lettuce", "leek", "lemon", "nectarine", "olive", "orange",
            "peanut", "sweet pepper", "pineapple", "pumpkin", "radish", "raisin",
            "rhubarb", "strawberry", "sweet potato", "tomato", "turnip", "yam",
            "watermelon", "zucchini", "blueblerry", "peach", "durian"};
    
    String[][] categories = {schoolWords, animalWords, countryWords, fruitsVegWords};
    
        int rn = new Random().nextInt(categories.length);
        String[] category = categories[rn];
    
        //choose a random word from the chosen array/category
        int rnd = new Random().nextInt(category.length);
        String word = category[rnd];
    
public static StringBuffer makeDashes(String s){
        StringBuffer dashes = new StringBuffer(s.length());
        for (int count=0; count < s.length(); count++)
            dashes.append('-'); //add dashes equal to length of the word
        return dashes;
}

public static void matchLetter(String word, StringBuffer dashes, char letter){
        char space = ' ';
        for (int index = 0; index < word.length(); index++)
            if (word.charAt(index) == letter){
                dashes.setCharAt(index, letter);
        System.out.print("Right letter!\n");
            }       //checking for spaces in the mystery word
            else if (word.charAt(index) == space){
        dashes.setCharAt(index, space);
            }
}
   
    
    public Hangman() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        guessInput = new javax.swing.JTextField();
        guessLabel = new javax.swing.JLabel();
        timerOutput = new javax.swing.JTextField();
        guessButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        wordOutput = new javax.swing.JTextArea();
        initializeButton = new javax.swing.JButton();
        wrongGuessOutput = new javax.swing.JTextField();
        wrongGuessLabel = new javax.swing.JLabel();
        newWordButton = new javax.swing.JButton();
        winsOutput = new javax.swing.JLabel();
        numberOfGuessesOutput = new javax.swing.JLabel();
        categoryOutput = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        titleLabel.setFont(new java.awt.Font("MS Gothic", 0, 48)); // NOI18N
        titleLabel.setText("Hangman");

        guessInput.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        guessLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        guessLabel.setText("Enter Guess");

        timerOutput.setEditable(false);
        timerOutput.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        guessButton.setText("Guess");
        guessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessButtonActionPerformed(evt);
            }
        });

        wordOutput.setEditable(false);
        wordOutput.setColumns(20);
        wordOutput.setFont(new java.awt.Font("MS Gothic", 0, 48)); // NOI18N
        wordOutput.setLineWrap(true);
        wordOutput.setRows(1);
        wordOutput.setWrapStyleWord(true);
        wordOutput.setAutoscrolls(false);
        jScrollPane1.setViewportView(wordOutput);

        initializeButton.setText("Initialize");
        initializeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initializeButtonActionPerformed(evt);
            }
        });

        wrongGuessOutput.setEditable(false);
        wrongGuessOutput.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        wrongGuessOutput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        wrongGuessOutput.setAutoscrolls(false);

        wrongGuessLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        wrongGuessLabel.setText("Wrong Guesses");

        newWordButton.setText("New Word");
        newWordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newWordButtonActionPerformed(evt);
            }
        });

        winsOutput.setFont(new java.awt.Font("Microsoft YaHei", 1, 36)); // NOI18N
        winsOutput.setForeground(new java.awt.Color(255, 232, 23));

        numberOfGuessesOutput.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        numberOfGuessesOutput.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        categoryOutput.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        categoryOutput.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(guessInput, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(guessLabel)))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(initializeButton)
                    .addComponent(guessButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(wrongGuessOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(timerOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newWordButton)
                .addGap(54, 54, 54))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(winsOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(wrongGuessLabel)
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(numberOfGuessesOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                    .addComponent(categoryOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titleLabel)
                    .addComponent(timerOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(newWordButton)
                        .addGap(13, 13, 13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(categoryOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(winsOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(numberOfGuessesOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wrongGuessLabel)
                        .addGap(17, 17, 17)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(guessLabel)
                            .addComponent(initializeButton))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(guessInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(guessButton)
                                .addGap(66, 66, 66))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(wrongGuessOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initializeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initializeButtonActionPerformed
        int Break = 5;
        dashes = makeDashes(word);
        
        wordOutput.setText(""+dashes);
        wrongGuessOutput.setText("");
        
        switch(rn){
            case 0:
                categoryDisplay = "School Words";
            break;
            case 1:
                categoryDisplay = "Animals";
            break;
            case 2:
                categoryDisplay = "Countries";
            break;
            case 3:
                categoryDisplay = "Fruits and Vegetables";
            break;
        }   //identifies which category is chosen for the round
                categoryOutput.setText("The category is: " + categoryDisplay);

        second = 59;
        minute = Break - 1;
        
        DecimalFormat x = new DecimalFormat ("00");
        
        countdowntimer = new javax.swing.Timer(1000, new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                //here is the action that should be performed
                //after a specified time.
                
                timerOutput.setText(minute+":"+x.format(second));
                second = second - 1;
                
                //after the counter is less than 0 stop the counter.
                if (second == -1) {
                    second = 59;
                    minute = minute - 1;
                }
                if (minute == 0 && second == 0) {                    
                    setVisible(false);
                    new TimerInterface().setVisible(true);
                    
                    countdowntimer.stop();
                }
                
            }
            
        });
        
        countdowntimer.start();
        initializeButton.setEnabled(false);
    }//GEN-LAST:event_initializeButtonActionPerformed

    private void guessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guessButtonActionPerformed
        String guess;
        char letter;
        
        guess = guessInput.getText();
        
        if(guess.length()>1){
            System.out.println("More than  one letter guesses not allowed");
        }
        else{
            {
                    letter = guess.charAt(0);
                    guesses += letter;
                    if (word.indexOf(letter) < 0)     //letter is not there
                    {	sj.add(guess);      //add letter to output
                    wrongGuessOutput.setText(sj.toString());
                  }
                    else
                  {
                  	//put letter in dashes where it belongs
                    matchLetter(word, dashes, letter);
                    wordOutput.setText(""+dashes);
                  }
                    if (word.equals(dashes.toString()))
                  {	wordOutput.setText("You Win!");
                        wins++;            //add 1 to win counter
                        winsOutput.setText("Wins: " + wins);
                        numberOfGuessesOutput.setText(guesses.length() + 
                                                        " guesses made!");
                            guesses = "";
                        sj.add("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                                + "\n\n\n\n\n\n\n\n\n");
                  }     //make it seem as though the wrong guesses box is wiped
            }
        }
                    SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        guessInput.requestFocusInWindow();
    }
});
        guessInput.setText("");
    }//GEN-LAST:event_guessButtonActionPerformed

    private void newWordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newWordButtonActionPerformed
        SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        guessInput.requestFocusInWindow();
            }
        });
        rn = new Random().nextInt(categories.length);
        category = categories[rn];
        // Choose a new random word from the array    
        rnd = new Random().nextInt(category.length);
        word = category[rnd];
        
        switch(rn){
            case 0:
                categoryDisplay = "School Words";
            break;
            case 1:
                categoryDisplay = "Animals";
            break;
            case 2:
                categoryDisplay = "Countries";
            break;
            case 3:
                categoryDisplay = "Fruits and Vegetables";
            break;
        }
        //again identifying the new category
        categoryOutput.setText("The category is: " + categoryDisplay);
        
        dashes = makeDashes(word);
        //obtaining a new word for the global variable
        wordOutput.setText(""+dashes);
    }//GEN-LAST:event_newWordButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Hangman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hangman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hangman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hangman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Hangman().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel categoryOutput;
    private javax.swing.JButton guessButton;
    private javax.swing.JTextField guessInput;
    private javax.swing.JLabel guessLabel;
    private javax.swing.JButton initializeButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newWordButton;
    private javax.swing.JLabel numberOfGuessesOutput;
    private javax.swing.JTextField timerOutput;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel winsOutput;
    private javax.swing.JTextArea wordOutput;
    private javax.swing.JLabel wrongGuessLabel;
    private javax.swing.JTextField wrongGuessOutput;
    // End of variables declaration//GEN-END:variables
private int second, minute, wins;
private Timer countdowntimer;           //global variables
String categoryDisplay, guesses;
StringBuffer dashes;
}
