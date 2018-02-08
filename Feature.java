
import java.util.*;

public class Feature {

    //Bad Feelings
    private final String[] omit = new String[]{"#EngineeringStudent",
        "to", "for", "on", "may", "a", "an", "the", "with",
        "in", "about", "at", "before", "after", "without",
        "of", "until", "this", "that", "it", "I", "me",
        "he", "she", "they", "and", "or", "when",
        "where", "what", "which", "while", "whom", "who",
        "how", "am", "is", "are", "was", "were", "will",};

    private final String[] studyPressure = new String[]{"hour", "homework", "exam", "day",
        "class", "work", "problem", "study", "week", "toomuch", "lab", "out", "thesis", "quiz",
        "page", "library", "spend", "today", "long", "varsity", "due", "engineer", "time"};

    private final String[] socialEngagementProblem = new String[]{"friday", "homework",
        "out", "study", "work", "weekend", "life", "class", "exam", "drink", "break",
        "people", "social", "lab", "spend", "tonight", "watch", "game", "miss",
        "party", "sunny", "beautiful"};

    private final String[] negEmo = new String[]{"hate", "f***", "shit", "exam", "class",
        "hell", "engineer", "suck", "study", "hour", "time", "lab", "sad", "bad", "day",
        "feel", "tired", "damn", "hard", "difficult", "death","not"};

    private final String[] sleepingProblem = new String[]{"sleep", "hour", "night", "bed",
        "allnight", "exam", "homework", "nap", "coffee", "time", "study","not", "dream",
        "more", "work", "class", "late", "week", "day", "long", "morning", "wake"};

    private final String[] diverseIssue = new String[]{"girl", "class", "only", "professor",
        "guy", "speak", "english", "female", "hot", "cold", "kid", "more", "too much",
        "walk", "people", "teach", "understand", "foreign", "white","not", "black"};

    //Good Feelings
    private final String[] pride = new String[]{"job", "offer", "success", "experience", "love",
        "marks", "happy", "great", "answer", "pass", "high", "grade", "solve"};

    private final String[] curious = new String[]{"hardware", "software", "computer", "science",
        "speed", "technology"};

    private final String[] motivated = new String[]{"conference", "paper", "pen", "gift",
        "book", "learn", "solution", "journey"};

    private final String[] inspired = new String[]{"result", "good", "value", "honesty",
        "future", "experience", "overcome", "gotta"};

    //feature length
    //bad
    private final int sp = studyPressure.length;
    private final int sep = socialEngagementProblem.length;
    private final int ne = negEmo.length;
    private final int slp = sleepingProblem.length;
    private final int di = diverseIssue.length;
    //good
    private final int prd = pride.length;
    private final int crs = curious.length;
    private final int mot = motivated.length;
    private final int insp = inspired.length;
    //end length

    //omit list
    List<String> omitList = Arrays.asList(omit);

    public String omitWord(String s) {
        String procData = "";

        StringTokenizer st = new StringTokenizer(s, " ");
        String tok = "";
        while (st.hasMoreTokens()) {
            tok = "";
            tok += st.nextToken();
            if (!omitList.contains(tok)) {
                procData += tok + " ";
            }
        }
        System.out.println(procData);
        return procData;
    }

    private int getMax(int[] a) {
        int m = a[0];
        int ln = a.length;
        for (int i = 1; i < ln; i++) {
            if (a[i] > m) {
                m = a[i];
            }
        }
        return m;
    }

    private int dsc(String[] feat, int len, String s) {
        int p = 0;
        for (int i = 0; i < len; i++) {
            if (s.contains(feat[i])) {
                p++;
            }
        }
        return p;
    }

    public String dataCreation(String s) {
        int bad[] = {0, 0, 0, 0, 0};
        int good[] = {0, 0, 0, 0};

        //bad count
        bad[0] = dsc(studyPressure, sp, s);
        bad[1] = dsc(socialEngagementProblem, sep, s);
        bad[2] = dsc(negEmo, ne, s);
        bad[3] = dsc(sleepingProblem, slp, s);
        bad[4] = dsc(diverseIssue, di, s);

        //good count
        good[0] = dsc(pride, prd, s);
        good[1] = dsc(curious, crs, s);
        good[2] = dsc(motivated, mot, s);
        good[3] = dsc(inspired, insp, s);

        //bad and good count
        int badCnt = 0, goodCnt = 0;
        for (int i = 0; i < bad.length; i++) {
            badCnt += bad[i];
        }
        for (int i = 0; i < good.length; i++) {
            goodCnt += good[i];
        }
        //End count

        //Emotion Status
        
        String emoStat = "";
        /*
        if (badCnt==0 && goodCnt==0) {
            emoStat = "neutral";
        } else if (badCnt == goodCnt) {
            emoStat = "confused";
        } else */
            if (badCnt > goodCnt) {
            emoStat = "yes";
        } else {
            emoStat = "no";
        }
        //End emoStat

        //bad [0]=studyPressure, [1]=socialEngagementProblem [2]=negEmo [3]=sleepingProblem [4]=diverseIssue
        //good [0]=pride [1]=curious [2]=motivated [3]=inspired
        String badEmo = "", goodEmo = "";

        int badMax = getMax(bad);
        if (bad[0] == badMax) {
            badEmo = "studyPressure";
            //yn[0]++;
        } else if (bad[1] == badMax) {
            badEmo = "socialEngagementProblem";
            //yn[1]++;
        } else if (bad[2] == badMax) {
            badEmo = "negEmo";
            //yn[2]++;
        } else if (bad[3] == badMax) {
            badEmo = "sleepingProblem";
            //yn[3]++;
        } else {
            badEmo = "diverseIssue";
            //yn[4]++;
        }

        int goodMax = getMax(good);
        if (bad[0] == goodMax) {
            goodEmo = "pride";
            //nn[0]++;
        } else if (bad[1] == goodMax) {
            goodEmo = "curious";
            //nn[1]++;
        } else if (bad[2] == goodMax) {
            goodEmo = "motivated";
            //nn[2]++;
        } else {
            goodEmo = "inspired";
            //nn[3]++;
        }
        
        ////   CNT   /////
        if(emoStat=="yes"){
            if(badEmo=="studyPressure"){
                yn[0]++;
            }else if(badEmo == "socialEngagementProblem"){
                yn[1]++;
            }else if(badEmo == "negEmo"){
                yn[2]++;
            }else if(badEmo == "sleepingProblem"){
                yn[3]++;
            }else if(badEmo == "diverseIssue"){
                yn[4]++;
            }
            
            
            if(goodEmo=="pride"){
                yp[0]++;
            }else if(goodEmo == "curious"){
                yp[1]++;
            }else if(goodEmo == "motivated"){
                yp[2]++;
            }else if(goodEmo == "inspired"){
                yp[3]++;
            }
                
        }
        
        if(emoStat=="no"){
            if(badEmo=="studyPressure"){
                nn[0]++;
            }else if(badEmo == "socialEngagementProblem"){
                nn[1]++;
            }else if(badEmo == "negEmo"){
                nn[2]++;
            }else if(badEmo == "sleepingProblem"){
                nn[3]++;
            }else if(badEmo == "diverseIssue"){
                nn[4]++;
            }
            
            
            if(goodEmo=="pride"){
                np[0]++;
            }else if(goodEmo == "curious"){
                np[1]++;
            }else if(goodEmo == "motivated"){
                np[2]++;
            }else if(goodEmo == "inspired"){
                np[3]++;
            }
                
        }   
        
        //// END CNT /////

        String data = "";
        //data to be inserted into dataset.arff file
        data = badEmo + "," + goodEmo + "," + emoStat;

        return data;
    }
    
    public void prt(){
            System.out.println("RELEVANT CALC");
            System.out.println("#####******#####");
            
            System.out.println("FOR YES");
            System.out.println("Study Problem  "+yn[0]);
            System.out.println("Social Engagement Problem  "+yn[1]);
            System.out.println("Neg EMo  "+yn[2]);
            System.out.println("Sleeping Problem  "+yn[3]);
            System.out.println("Diverse Issue  "+yn[4]);
            System.out.println("pride  "+yp[0]);
            System.out.println("curious  "+yp[1]);
            System.out.println("motivated  "+yp[2]);
            System.out.println("inspired  "+yp[3]);
            
            System.out.println("#####******#####");
            System.out.println("FOR NO");
            System.out.println("Study Problem  "+nn[0]);
            System.out.println("Social Engagement Problem  "+nn[1]);
            System.out.println("Neg EMo  "+nn[2]);
            System.out.println("Sleeping Problem  "+nn[3]);
            System.out.println("Diverse Issue  "+nn[4]);
            System.out.println("pride  "+np[0]);
            System.out.println("curious  "+np[1]);
            System.out.println("motivated  "+np[2]);
            System.out.println("inspired  "+np[3]);
        }
    
    public int[] yn=new int[]{0,0,0,0,0};
    public int[] yp=new int[]{0,0,0,0};
    public int[] nn=new int[]{0,0,0,0,0};
    public int[] np=new int[]{0,0,0,0};

}
