#FROM ubuntu:latest
#RUN apt-get update; apt-get clean
FROM openjdk:15.0.2-oracle
#FROM selenium/node-chrome:4.1.1-20211217
#FROM openjdk:jdk-alpine

#VOLUME C:/Users/micha/Desktop/Volume:/build
#RUN apt-get install brew
#RUN sudo yum install -y yum-utils
#
#RUN yum -y install wget

##Step 1 : Install the pre-requisite
#RUN apt-get update
#RUN apt-get install -y curl
#RUN apt-get install -y p7zip \
#    p7zip-full \
#    unace \
#    zip \
#    unzip \
#    bzip2

##Step 2: Install Chrome
#RUN curl http://dl.google.com/linux/chrome/deb/pool/main/g/google-chrome-stable/google-chrome-stable_$CHROME_VERSION-1_amd64.deb -o /chrome.deb
#RUN dpkg -i /chrome.deb
#RUN rm /chrome.deb

#RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
#RUN dpkg -i google-chrome-stable_current_amd64.deb


## Install Chrome.
#RUN apt-get update && apt-get -y install google-chrome-stable



#RUN brew install brew-cask
#RUN brew cask install google-chrome
# Install Chrome for Selenium

#RUN curl https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb -o /chrome.deb
#RUN dpkg -i /chrome.deb || apt-get install -yf
#RUN rm /chrome.deb

#RUN apt-get update
#RUN apt-get install -y wget #install wget lib
#RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb

#RUN sudo curl -sS -o - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
#RUN sudo echo "deb [arch=amd64]  http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list
#RUN sudo apt-get -y update
#RUN sudo apt-get -y install google-chrome-stable


#RUN apt-get update && apt-get -y install google-chrome-stable

# Install chromedriver for Selenium
#RUN curl https://chromedriver.storage.googleapis.com/2.31/chromedriver_linux64.zip -o /usr/local/bin/chromedriver
#RUN chmod +x /usr/local/bin/chromedriver


#COPY /build/* C:/Users/micha/Desktop/Volume/
#CMD ["./gradlew test", "-Dgroups="]
ARG groups

COPY . .
CMD ./gradlew test -Dgroups=$groups

#CMD java -version