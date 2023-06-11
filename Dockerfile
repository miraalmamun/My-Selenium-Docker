FROM  miraalmamun/alpine-jdk:latest

RUN apk add curl jq

#Workspace
WORKDIR /usr/share/mir

#ADD .jar under target from host in this image
ADD target/selenium-docker.jar        selenium-docker.jar
ADD target/selenium-docker-tests.jar  selenium-docker-tests.jar
ADD target/libs                       libs

#In case of any other dependency like .csv/.json/.xml add that as well

#Add suite files
ADD google.xml        google.xml

#ADD health check script healthckeck.sh"
ADD healthckeck.sh   healthckeck.sh  

ENTRYPOINT sh healthckeck.sh
