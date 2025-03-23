
JCC = javac

JFLAGS = -g

JAVA = java

default: calculator.class add.class substract.class division.class multiply.class

calculator.class: calculator.java
									$(JCC) $(JFLAGS) calculator.java

add.class: add.java
					 $(JCC) $(JFLAGS) add.java

multiply.class: multiply.java
								$(JCC) $(JFLAGS) multiply.java
        
division.class: division.java
								$(JCC) $(JFLAGS) division.java
								
substract.class: substract.java
								$(JCC) $(JFLAGS) substract.java

run:
		$(JAVA) calculator

clean: 
		$(RM) *.class