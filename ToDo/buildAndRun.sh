#!/bin/sh
mvn clean package && docker build -t com.mycompany/ToDo .
docker rm -f ToDo || true && docker run -d -p 8080:8080 -p 4848:4848 --name ToDo com.mycompany/ToDo 
