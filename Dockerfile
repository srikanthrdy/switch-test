# Use an official Tomcat runtime as a parent image
FROM tomcat:9.0.80-jre11-temurin-jammy

# Set environment variables if necessary
# ENV EXAMPLE_VARIABLE=value

# Copy your WAR file into the webapps directory of Tomcat
COPY /target/test.war /usr/local/tomcat/webapps/

# Optionally, you can expose ports if needed (e.g., Tomcat default port 8080)
 EXPOSE 7000

# Define an entrypoint (optional)
 CMD ["catalina.sh", "run"]
