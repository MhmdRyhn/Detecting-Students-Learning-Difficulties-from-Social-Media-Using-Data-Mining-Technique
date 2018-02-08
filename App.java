
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;

public class App extends javax.swing.JFrame {

    private Connection con = null;
    private PreparedStatement prepStat = null;
    private Statement st = null;
    private ResultSet rs = null;

    public App() throws InstantiationException, IllegalAccessException {
        initComponents();
        initAppFrame();
        con = ConnectDb.conDb();
    }

    private void initAppFrame() {
        setTitle("Information Display Window");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tArea = new javax.swing.JTextArea();
        createDataSet = new javax.swing.JButton();
        collectTweets = new javax.swing.JButton();
        analyzeData = new javax.swing.JButton();
        inputManually = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        viewTweetsOption = new javax.swing.JRadioButton();
        viewDatasetOption = new javax.swing.JRadioButton();
        viewResultOption = new javax.swing.JRadioButton();
        viewTestTweetOption = new javax.swing.JRadioButton();
        viewTestDataOption = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tArea.setColumns(20);
        tArea.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        tArea.setRows(5);
        jScrollPane1.setViewportView(tArea);

        createDataSet.setForeground(new java.awt.Color(204, 0, 51));
        createDataSet.setText("Create Data");
        createDataSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createDataSetActionPerformed(evt);
            }
        });

        collectTweets.setForeground(new java.awt.Color(204, 0, 0));
        collectTweets.setText("Collect Tweets");
        collectTweets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collectTweetsActionPerformed(evt);
            }
        });

        analyzeData.setForeground(new java.awt.Color(204, 0, 0));
        analyzeData.setText("Analyze");
        analyzeData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyzeDataActionPerformed(evt);
            }
        });

        inputManually.setForeground(new java.awt.Color(204, 0, 0));
        inputManually.setText("Input Manually");
        inputManually.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manualInputActionPerformed(evt);
            }
        });

        jLabel1.setText("   View Data and Result");

        buttonGroup1.add(viewTweetsOption);
        viewTweetsOption.setText("View Training Tweet");
        viewTweetsOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewTweets(evt);
            }
        });

        buttonGroup1.add(viewDatasetOption);
        viewDatasetOption.setText("View Training Data");
        viewDatasetOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDataset(evt);
            }
        });

        buttonGroup1.add(viewResultOption);
        viewResultOption.setText("View Result");
        viewResultOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewResult(evt);
            }
        });

        buttonGroup1.add(viewTestTweetOption);
        viewTestTweetOption.setText("View Testing Tweet");
        viewTestTweetOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewTestTweet(evt);
            }
        });

        buttonGroup1.add(viewTestDataOption);
        viewTestDataOption.setText("View Testing Data");
        viewTestDataOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewTestData(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(collectTweets)
                        .addGap(49, 49, 49)
                        .addComponent(createDataSet)
                        .addGap(52, 52, 52)
                        .addComponent(analyzeData)
                        .addGap(47, 47, 47)
                        .addComponent(inputManually))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(viewTweetsOption))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(viewResultOption)
                                    .addComponent(viewDatasetOption)
                                    .addComponent(viewTestTweetOption)
                                    .addComponent(viewTestDataOption))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(viewTweetsOption)
                        .addGap(18, 18, 18)
                        .addComponent(viewDatasetOption)
                        .addGap(18, 18, 18)
                        .addComponent(viewTestTweetOption)
                        .addGap(18, 18, 18)
                        .addComponent(viewTestDataOption)
                        .addGap(18, 18, 18)
                        .addComponent(viewResultOption))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createDataSet)
                    .addComponent(collectTweets)
                    .addComponent(analyzeData)
                    .addComponent(inputManually))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setBackground(new java.awt.Color(0, 255, 204));
        jMenu1.setText("File");

        jMenuItem1.setText("new");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    //----------- "Create Data" Button Function -----------
    private void createDataSetActionPerformed(java.awt.event.ActionEvent evt) {                                              
        //String query="select count(*) from tweet";
        
        // for TRAIN_DATAET
        File file = new File("trainset.arff");
        
        try {
            PrintWriter pw=new PrintWriter(new FileWriter(file.getName(),false),false);
            pw.flush();
            
            pw.print("@relation engineeringStudent");
            pw.println();
            pw.println();
            pw.print("@attribute badFeelings {studyPressure, socialEngagementProblem, negEmo, sleepingProblem, diverseIssue}");
            pw.println();
            pw.print("@attribute goodFeelings {pride, curious, motivated, inspired}");
            pw.println();
            pw.print("@attribute DoesProblemFace  {yes, no}");
            pw.println();
            pw.println();
            pw.print("@data");
            pw.println();
            
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        String query = "select * from tweets";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        Feature feat = new Feature(); // object of "Feature" class

        try {
            while (rs.next()) {
                String data = "";
                //creating each row of @Data in dataset.arff
                data = feat.dataCreation(rs.getString("sig_word"));

                System.out.println("From DB: " + rs.getString("sig_word"));

                //System.out.println("Data: " +data );
                //File file = new File("dataset.arff");
                if (!file.exists()) {
                    file.createNewFile();
                }

                //Append into dataset.arff file
                FileWriter fWriter = new FileWriter(file.getName(), true);
                BufferedWriter bWriter = new BufferedWriter(fWriter);
                bWriter.newLine();
                bWriter.write(data);
                bWriter.close();
                //end append

            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // for TEST_DATASET
        File tsfile = new File("testset.arff");
        
        try {
            PrintWriter tspw=new PrintWriter(new FileWriter(tsfile.getName(),false),false);
            tspw.flush();
            
            tspw.print("@relation engineeringStudent");
            tspw.println();
            tspw.println();
            tspw.print("@attribute badFeelings {studyPressure, socialEngagementProblem, negEmo, sleepingProblem, diverseIssue}");
            tspw.println();
            tspw.print("@attribute goodFeelings {pride, curious, motivated, inspired}");
            tspw.println();
            tspw.print("@attribute DoesProblemFace  {yes, no}");
            tspw.println();
            tspw.println();
            tspw.print("@data");
            tspw.println();
            
            tspw.close();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        String tsquery = "select * from testtweet";
        try {
            st = con.createStatement();
            rs = st.executeQuery(tsquery);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        Feature tsfeat = new Feature(); // object of "Feature" class

        try {
            while (rs.next()) {
                String tsdata = "";
                //creating each row of @Data in dataset.arff
                tsdata = tsfeat.dataCreation(rs.getString("tsData"));

                System.out.println("From DB: " + rs.getString("tsData"));

                //System.out.println("Data: " +data );
                //File file = new File("dataset.arff");
                if (!tsfile.exists()) {
                    tsfile.createNewFile();
                }

                //Append into dataset.arff file
                FileWriter tsfWriter = new FileWriter(tsfile.getName(), true);
                BufferedWriter tsbWriter = new BufferedWriter(tsfWriter);
                tsbWriter.newLine();
                tsbWriter.write(tsdata);
                tsbWriter.close();
                //end append

            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        feat.prt();

    }                                             

    
    //----------- "Collect Tweets" Button Function --------------
    private void collectTweetsActionPerformed(java.awt.event.ActionEvent evt) {                                              

        Feature feat = new Feature();// object of "Feature" class

        try {
            
            //FOR TRAIN_DATASET
            String query1 = "delete from tweets"; //clearing the tweets from table "tweets"
            st = con.createStatement();
            st.executeUpdate(query1);
            //end clearing table

            File f = new File("src/files/trainDataSet.txt");

            BufferedReader b = new BufferedReader(new FileReader(f));

            String track = "";
            String readLn = "";
            String toBeInserted = "";

            // Insert operation MySql QUERY
            //String query = "INSERT INTO tweets(sig_word) VALUES('" + toBeInserted + "')";
            String query = null;
            
            while ((readLn = b.readLine()) != null) {
                //readLine = b.readLine();

                System.out.println("read from file");

                readLn = feat.omitWord(readLn);

                //if ("".equals(readLn.trim())) { // Insert data into data_table if a BLANK LINE is found
                if (readLn.length() == 0 && track.length() != 0) {
                    track=readLn;
                    System.out.println("Now: " + toBeInserted);
                    query = "INSERT INTO tweets(sig_word) VALUES('" + toBeInserted + "')";
                    try {
                        //String query = "INSERT INTO tweets(sig_word) VALUES('" + toBeInserted + "')";
                        prepStat = con.prepareStatement(query);
                        prepStat.execute();
                        System.out.println("Inserted");
                    } catch (SQLException ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    toBeInserted = "";
                    continue;
                }

                toBeInserted += readLn;
                track = readLn;
                readLn = "";
            }
            try {
                //String query = "INSERT INTO tweets(sig_word) VALUES('" + toBeInserted + "')";
                if (track.length() != 0) {
                    prepStat = con.prepareStatement(query);
                    prepStat.executeUpdate();
                }
                System.out.println("Inserted successfully");
            } catch (SQLException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
            //END TRAIN_DATASET
            
            
            //FOR TEST_DATASET
            String tsquery1 = "delete from testtweet"; //clearing the tweets from table "tweets"
            st = con.createStatement();
            st.executeUpdate(tsquery1);
            //end clearing table

            File tsf = new File("src/files/testDataSet.txt");

            BufferedReader tsb = new BufferedReader(new FileReader(tsf));

            String tstrack = "";
            String tsreadLn = "";
            String tstoBeInserted = "";

            // Insert operation MySql QUERY
            //String query = "INSERT INTO tweets(sig_word) VALUES('" + toBeInserted + "')";
            String tsquery = null;
            
            while ((tsreadLn = tsb.readLine()) != null) {
                //readLine = b.readLine();

                System.out.println("TS read from file");

                tsreadLn = feat.omitWord(tsreadLn);

                //if ("".equals(readLn.trim())) { // Insert data into data_table if a BLANK LINE is found
                if (tsreadLn.length() == 0 && tstrack.length() != 0) {
                    tstrack=tsreadLn;
                    System.out.println("TS Now: " + tstoBeInserted);
                    tsquery = "INSERT INTO testtweet(tsData) VALUES('" + tstoBeInserted + "')";
                    try {
                        //String query = "INSERT INTO tweets(sig_word) VALUES('" + toBeInserted + "')";
                        prepStat = con.prepareStatement(tsquery);
                        prepStat.execute();
                        System.out.println("TS Inserted");
                    } catch (SQLException ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    tstoBeInserted = "";
                    continue;
                }

                tstoBeInserted += tsreadLn;
                tstrack = tsreadLn;
                tsreadLn = "";
            }
            try {
                //String query = "INSERT INTO tweets(sig_word) VALUES('" + toBeInserted + "')";
                if (tstrack.length() != 0) {
                    prepStat = con.prepareStatement(tsquery);
                    prepStat.executeUpdate();
                }
                System.out.println("TS Inserted successfully");
            } catch (SQLException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
            //END TEST_DATASET
            
            //end try and start catch
        } catch (IOException e) {
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(rootPane, "Data Saved");

    }                                             

    //------------ "Analyze" Button Function --------------
    private void analyzeDataActionPerformed(java.awt.event.ActionEvent evt) {                                            
        try {
            BufferedReader bReader = new BufferedReader(new FileReader("trainset.arff"));

            trainSet = new Instances(bReader);
            trainSet.setClassIndex(trainSet.numAttributes() - 1);
            bReader.close();
            
            /*
            bReader = new BufferedReader(new FileReader("testset.arff"));
            testSet = new Instances(bReader);
            //trainSet.setClassIndex(trainSet.numAttributes() - 1);
            bReader.close();
            */

            nb = new NaiveBayes();
            nb.buildClassifier(trainSet);

            System.out.println("\n\nResult\n====================\n\n");
            System.out.println(nb);

            eval = new Evaluation(trainSet);
            eval.crossValidateModel(nb, trainSet, 3, new Random(1));
            //eval.evaluateModel(nb, trainSet);

            System.out.println(eval.toSummaryString("\n\nSummary Results\n==================", true));
            System.out.println(eval.toClassDetailsString());
            System.out.println(eval.toMatrixString());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }                                           

    //------------- "Input Manually" Button Function ----------------
    private void manualInputActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        ManualInputWindow miw;
        try {
            miw = new ManualInputWindow();
            miw.setVisible(true);
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }                                           

    private void viewTweets(java.awt.event.ActionEvent evt) {                            
        File f = new File("src/files/trainDataSet.txt");

        try {
            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLn = "";
            tArea.setText("");
            while ((readLn = b.readLine()) != null) {
                //System.out.println(readLn);
                //if(readLn.length()!=0)
                tArea.append(readLn + "\n");
                readLn = "";
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                           

    private void viewDataset(java.awt.event.ActionEvent evt) {                             
        File f = new File("trainset.arff");

        try {
            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLn = "";
            tArea.setText("");
            while ((readLn = b.readLine()) != null) {
                //System.out.println(readLn);
                tArea.append(readLn + "\n");
                readLn = "";
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                            

    private void viewResult(java.awt.event.ActionEvent evt) {                            

        tArea.setText("");
        try {
            //tArea.append("\n\nResult\n====================\n\n");
            //tArea.append(new String(nb));

            //tArea.append(eval.toSummaryString("Summary Results\n==================", true));
            //tArea.append(eval.toClassDetailsString());
            tArea.append(eval.toSummaryString("Summary Results\n==================", true));
            tArea.append(eval.toClassDetailsString());
            tArea.append(eval.toMatrixString());
            //tArea.append("\n\n" + eval.toMatrixString());

            tArea.append("\n\n");

            tArea.append("Number of Correctly Classified Tweets: " + eval.correct());
            tArea.append("\nNumber of Correct Tweets(%): " + eval.pctCorrect());
            tArea.append("\nNumber of Incorrectlu Classified Tweets: " + eval.incorrect());
            tArea.append("\nNumber of Incorrect Tweets(%): " + eval.pctIncorrect());
            tArea.append("\nNumber of Unclassified Tweets: " + eval.unclassified());
            tArea.append("\nNumber of Unclassified Tweets(%): " + eval.pctUnclassified());

        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }                           

    private void viewTestTweet(java.awt.event.ActionEvent evt) {                               
        // TODO add your handling code here:
        File f = new File("src/files/testDataSet.txt");

        try {
            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLn = "";
            tArea.setText("");
            while ((readLn = b.readLine()) != null) {
                //System.out.println(readLn);
                //if(readLn.length()!=0)
                tArea.append(readLn + "\n");
                readLn = "";
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                              

    private void viewTestData(java.awt.event.ActionEvent evt) {                              
        // TODO add your handling code here:
        File f = new File("testset.arff");

        try {
            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLn = "";
            tArea.setText("");
            while ((readLn = b.readLine()) != null) {
                //System.out.println(readLn);
                tArea.append(readLn + "\n");
                readLn = "";
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                             

    //variables for the classifier
    private Instances trainSet;
    private Instances testSet;
    private NaiveBayes nb;
    private Evaluation eval;
    //end classifier variable

    // Variables declaration - do not modify                     
    private javax.swing.JButton analyzeData;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JButton collectTweets;
    private javax.swing.JButton createDataSet;
    private javax.swing.JButton inputManually;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea tArea;
    private javax.swing.JRadioButton viewDatasetOption;
    private javax.swing.JRadioButton viewResultOption;
    private javax.swing.JRadioButton viewTestDataOption;
    private javax.swing.JRadioButton viewTestTweetOption;
    private javax.swing.JRadioButton viewTweetsOption;
    // End of variables declaration                   
}
