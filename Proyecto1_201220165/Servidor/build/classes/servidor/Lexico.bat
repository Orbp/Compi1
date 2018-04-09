SET JAVA_HOME = "C:\Program Files\Java\jdk1.8.0_144\bin"
SET PATH = %JAVA_HOME%; %PATH%
SET CLASSPATH = %JAVA_HOME%;
SET JFLEX_HOME = C:\Fuentes\jflex-1.6.1
cd C:\Users\oscar\Documents\NetBeansProjects\Proyecto1_201220165\Servidor\src\servidor
java -jar C:\Fuentes\jflex-1.6.1\lib\JFlex.jar lexico.jflex
pause
