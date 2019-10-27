# StudentInformationSystem
"Student Information System" is a FullStackWeb Project, which is made using REST api implementation. The other details of the Project are as follows:

For Front end, we have used (HTML + CSS + BootStrap + JavaScript + jQuery)  
For Back end (Java + Jersy + JDBC + MySQL) were used
Database Schema  

`create database studentproject;`  
`use studentproject;`  
  
<code>
CREATE TABLE `student` (  
  `Name` varchar(100) NOT NULL,  
  `DOB` date NOT NULL,  
  `rollNumber` int NOT NULL,  
  `physicsMarks` double DEFAULT NULL,  
  `chemistryMarks` double DEFAULT NULL,  
  `mathematicsMarks` double DEFAULT NULL,  
  PRIMARY KEY (`rollNumber`),  
  CHECK ( `rollNumber` > 0 )  
);
</code>
