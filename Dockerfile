# Use a lightweight base image
FROM alpine:latest

# Copy the WAR file from your local filesystem to the Docker container
COPY ./target/test.war C:\Users\Srikanth\Downloads\apache-tomcat-10.1.13-windows-x64\apache-tomcat-10.1.13\webapps
