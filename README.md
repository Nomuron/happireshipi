# happireshipi
Website for creating shopping lists on a base of chosen meals.

### Instruction how to install and run
- Install docker and docker-compose
- Make one folder for back-end and front-end repo
- Copy back-end repo to folder
- Copy front-end repo to folder
- Open terminal and go to back-end directory
- Make sure that db script is possible to execute by using ```chmod +x init-database.sh```
- Use command ```docker-compose up -d```
- Back-end is available at ```localhost:8080```
- Front-end is available at ```localhost:8081```
- If issues with any container will appear, use ```docker-compose log {$name_of_container}```
- After work is done, kill containers by using ```docker-compose down```