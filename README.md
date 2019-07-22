```
Exercise Summary:
This Developer In Test Design and Development exercise is used in the evaluation process for potential new hire candidates.  Please approach this exercise as you would approach a design and development project at work.  Please plan to allocate somewhere between 2-6 hours to complete the exercise.  Any documentation or explanations about your approach and assumptions are helpful.  Please e-mail your completed exercise back to your recruiting contact at Expeditors when complete.

Requirements:
Write a standalone executable or script using the language of your preference (Java is the primary dev language at Expeditors).  Given the provided input data, print the expected output to the console or write to a text file.

Input data:
"Dave","Smith","123 main st.","seattle","wa","43"
"Alice","Smith","123 Main St.","Seattle","WA","45"
"Bob","Williams","234 2nd Ave.","Tacoma","WA","26"
"Carol","Johnson","234 2nd Ave","Seattle","WA","67"
"Eve","Smith","234 2nd Ave.","Tacoma","WA","25"
"Frank","Jones","234 2nd Ave.","Tacoma","FL","23"
"George","Brown","345 3rd Blvd., Apt. 200","Seattle","WA","18"
"Helen","Brown","345 3rd Blvd. Apt. 200","Seattle","WA","18"
"Ian","Smith","123 main st ","Seattle","Wa","18"
"Jane","Smith","123 Main St.","Seattle","WA","13"

Expected output: 
Each household and number of occupants, followed by:
Each First Name, Last Name, Address and Age sorted by Last Name then First Name where the occupant(s) is 18 and older.

```

# How to run

## Clone repo

```bash
git clone https://github.com/LenarBad/expeditors.git
```

## Compile

```bash
mvn compile
```

## Run Unit tests

```bash
mvn test
```
  
## No parameter Run

```bash
mvn exec:java -Dexec.mainClass=io.lenar.exercise.expeditors.Main 
```

By default it will use ```input.txt``` in the ```resources``` folder as a data source (copied from exercise __Input data__)

## Run with different Input data

You can run the app against different __Input data__.

Available options:
 - Text file in any location in the File System
 - Text file in the ```resources``` folder - available even if it's packed into a jar.
 - Resource in any location in the network/internet accessible by simple GET requests

Running the app without parameters (see __Run by default__) is the same as  running with parameters ```source=RESOURCE path=input.txt```

```bash
mvn exec:java -Dexec.mainClass=io.lenar.exercise.expeditors.Main -Dexec.args="source=RESOURCE path=input.txt"
```
or
```bash
mvn exec:java -Dexec.mainClass=io.lenar.exercise.expeditors.Main -Dsource=RESOURCE -Dpath=input.txt
```

There are 2 parameters available: 
 - __source__ - stands for the type of the input data source (available values: __RESOURCE__, __FILE_SYSTEM__ and __NETWORK__)
 - __path__ - the path to the file/resource where __Input data__ is stored
 
 ### Examples
 
 ```bash
 mvn exec:java -Dexec.mainClass=io.lenar.exercise.expeditors.Main -Dsource=NETWORK -Dpath=https://raw.githubusercontent.com/LenarBad/expeditors/master/src/main/resources/input.txt
 ```
* you have to be connected to the internet in order to access to ```input.txt```

 ```bash
 mvn exec:java -Dexec.mainClass=io.lenar.exercise.expeditors.Main -Dsource=FILE_SYSTEM -Dpath=C:/example/testdata/input.txt
 ```
* you have to place the ```input.txt``` file in the location ```C:/example/testdata/input.txt```


# External Dependencies

```xml
        <dependency>
            <groupId>io.lenar</groupId>
            <artifactId>files</artifactId>
            <version>1.6.0</version>
        </dependency>
```
and

```xml
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>6.10</version>
            <scope>test</scope>
        </dependency>
```