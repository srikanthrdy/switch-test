# Stage 1: Build the Maven project
FROM maven:3.8.4-openjdk-11 AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project files (e.g., pom.xml) into the container
COPY pom.xml .

# Download and install project dependencies
RUN mvn dependency:go-offline

# Copy the entire project into the container
COPY . .

# Build and verify the Maven project
RUN mvn clean verify

# Stage 2: Create a Tomcat-based image
FROM tomcat:8.5-jre8

# Remove the default ROOT application
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy the .war file from the builder stage into the webapps directory of Tomcat
COPY --from=builder /app/target/Demo.war /usr/local/tomcat/webapps/ROOT.war

# Expose the port your application will run on (Tomcat default is 8080)
EXPOSE 7080

# Start Tomcat when the container starts
CMD ["catalina.sh", "run"]
