
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;




public class ManualInputWindow extends javax.swing.JFrame {
    
    private Connection con=null;
    private PreparedStatement prepStat=null;
    
    
    
    public ManualInputWindow() throws InstantiationException, IllegalAccessException {
        initComponents();
        initManualInputFrame();
        con=ConnectDb.conDb();
    }
    
    private void initManualInputFrame(){
        setTitle("Manual Input Window");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        tweetPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputManualTweet = new javax.swing.JTextArea();
        saveManualTweetButton = new javax.swing.JButton();
        instruction = new javax.swing.JLabel();
        closeManualInputButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputManualTweet.setColumns(20);
        inputManualTweet.setRows(5);
        jScrollPane1.setViewportView(inputManualTweet);

        javax.swing.GroupLayout tweetPanelLayout = new javax.swing.GroupLayout(tweetPanel);
        tweetPanel.setLayout(tweetPanelLayout);
        tweetPanelLayout.setHorizontalGroup(
            tweetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        tweetPanelLayout.setVerticalGroup(
            tweetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tweetPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        saveManualTweetButton.setText("Save");
        saveManualTweetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveManualTweetActionPerformed(evt);
            }
        });

        instruction.setText("                          Write one tweet at a time in the following field");

        closeManualInputButton.setText("Close");
        closeManualInputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeMaualInputWindow(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tweetPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(instruction, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(saveManualTweetButton)
                .addGap(40, 40, 40)
                .addComponent(closeManualInputButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(instruction, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tweetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveManualTweetButton)
                    .addComponent(closeManualInputButton))
                .addContainerGap())
        );

        pack();
    }                      

    @SuppressWarnings("empty-statement")
    private void saveManualTweetActionPerformed(java.awt.event.ActionEvent evt) {
        String inp=inputManualTweet.getText();
        System.out.println(inp);
        String query="INSERT INTO tweets(sig_word)  VALUES('"+inp+"')";
        
        try {
            prepStat=con.prepareStatement(query);
            //qprepStat.setString(1, inputManualTweet.getText());
            prepStat.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ManualInputWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
        inputManualTweet.setText(null);
    }                                               

    private void closeMaualInputWindow(java.awt.event.ActionEvent evt) {                                       
        this.dispose(); //Closes the window
    }                                      

    
    
    // Variable Declaration
    private javax.swing.JButton closeManualInputButton;
    private javax.swing.JTextArea inputManualTweet;
    private javax.swing.JLabel instruction;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveManualTweetButton;
    private javax.swing.JPanel tweetPanel;
}
