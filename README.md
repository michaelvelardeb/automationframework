#....................GRADLE BUILD INFO
#gradle build 
./gradlew build
JVM=15

#run tests using gradle with groups arg:'-Dgroups=' to run all tests
./gradlew test -Dgroups=

#run tests filtered by groups arg:'-Dgroups=smoke' to run only tests in the 'smoke' group
./gradlew test -Dgroups=smoke

#....................DOCKER IMAGE INFO
#create Docker image with name ex.. to name it test_framework run command from project root directory
docker build -t test_framework .

#Step 1: set up network and define subnet address for containers to connect with ip range and give network name
docker network create --subnet=172.20.0.0/16 selenium_network
#view docker networks
docker network ls
#remove docker network
docker network rm <NETWORK ID>

#Step 2: set up chrome standalone container, open port 7900 for vnc, connect to selenium port 4444, define desired ip, connect to previously created selenium_network
docker run -d -p 4444:4444 -p 7900:7900 --net selenium_network --ip 172.20.0.2 --shm-size="2g" selenium/standalone-chrome:4.1.1-20211217

#Step 3: build automation suite image
#build automation test suite image 
docker build -t <imageName> . 

#Step 4: run automation image on selenium_network on defined ip
docker run -d --rm --net selenium_network <automationImage>

#Step 5: view image on on VCN veiwer on localhost:7900 password: secret
put in browser //localhost:7900