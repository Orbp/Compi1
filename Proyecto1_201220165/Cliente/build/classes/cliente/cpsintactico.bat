SET JAVA_HOME = "C:\Program Files\Java\jdk1.8.0_144\bin"
SET PATH = %JAVA_HOME%; %PATH%
SET CLASSPATH = %JAVA_HOME%;
cd C:\Users\oscar\Documents\NetBeansProjects\Proyecto1_201220165\Cliente\src\cliente
java -jar C:\Fuentes\java-cup-11b.jar -parser sintactico_cp -symbols tabla_sim_cpreport cpsintactico.cup
pause
