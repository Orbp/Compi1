SET JAVA_HOME = "C:\Program Files\Java\jdk1.8.0_144\bin"
SET PATH = %JAVA_HOME%; %PATH%
SET CLASSPATH = %JAVA_HOME%;
cd C:\Users\oscar\Documents\NetBeansProjects\Proyecto1_201220165\Servidor\src\servidor
java -jar C:\Fuentes\java-cup-11b.jar -parser sintactico -symbols tabla_simbolos sintactico.cup
pause
