FROM sandeepalguri/java-ubuntu-imp
#RUN apt-get update \
 # && apt-get install sudo -y \
# &&  sudo apt install xvfb  -y \
# && apt-get install git maven -y \
# && sudo apt install default-jdk -y 
#RUN wget https://download-installer.cdn.mozilla.net/pub/firefox/releases/95.0.2/linux-x86_64/en-GB/firefox-95.0.2.tar.bz2 \
 #   && apt-get install bzip2 -y \
  #  && cd ~ \
   # && tar xjf firefox-95.0.2.tar.bz2 \
    #&& sudo apt install firefox
COPY . .
#ADD target/DarazOrder-0.0.1-SNAPSHOT.jar DarazOrder-0.0.1-SNAPSHOT.jar
#ENV DISPLAY=:89
#RUN export DISPLAY=:89
#RUN Xvfb :89 
#RUN  Xvfb :89 & export DISPLAY=:89 & java -jar DarazOrder-0.0.1-SNAPSHOT.jar ../testng.xml  
#CMD [ "Xvfb :89" & "export" "DISPLAY=:89" & "java" "-jar" "target/DarazOrder-0.0.1-SNAPSHOT.jar" "../testng.xml" ]
ENTRYPOINT ["/bin/sh", "target/shell"]                                             
