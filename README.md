# Thesis Title
Detecting Students' Learning Difficulties from Social Media Using Data Mining Technique

## Prerequisite
1. Xampp
2. JDK
3. IDE - Eclipse / NetBeans
4. twitter4j, a Java API (if you want to collect tweet from twitter automatically)

## Instructions
  1. This thesis work actually collects data from the informal social media platform related to Engineering Students about how they face difficulties in their learning process in the Engineering Institutions.
  
  2. I've faced some difficultied during data collection from Twitter using a java API twitter4j. So I've collected data from twitter and saved them in a text file from where my code collects tweets. It can be done other way by changing the code inside App.collectTweetsActionPerformed() method. twitter4j is a java API to collect tweet from twitter which can be used to collect data from twitter automatically.

  3. Database used is named as datamining and the tables are as follows:<br/>
  (i) authertication (userName(varchar), passWord(varchar))<br/>
  *- Only registered user can ue the system*<br/>
  (ii) tweets (sig_word(text))<br/>
  *- This table is used to save processed tweets for creating dataset(.arff file format) for training*<br/>
  (iii) testtweet (tsData(text))<br/>
  *- This table is used to save processed tweets for creating dataset(.arff file format) for testing*<br/>
 
  4. The sstructure of .arff file format is easily understandable from the body of App.createDataSetActionPerformed() method.
  
  5. The implementation of the thesis works fine considering all the processing and claculations used. But the implementation has least facilities for the user. Anyone can develop this system more user friendly leaving the data analysis parts in different methods in different Classes.

## Author
[Mahmood Al Rayhan](https://github.com/MhmdRyhn)<br/>
Computer Science and Engineering<br/>
Rajshahi University of Engineering and Technology<br/>
Rajshahi, Bangladesh<br/>
