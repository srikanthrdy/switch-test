#!/bin/bash

# Download Java
echo "Downloading Java..."
wget -q -O java.tar.gz https://download.oracle.com/java/17/latest/jdk-17_windows-x64_bin.zip
tar -xzf java.tar.gz
rm java.tar.gz

# Set JAVA_HOME
export JAVA_HOME=$(pwd)/java
export PATH=$JAVA_HOME/bin:$PATH

# Download Maven
echo "Downloading Maven..."
wget -q -O maven.tar.gz https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.tar.gz
tar -xzf maven.tar.gz
rm maven.tar.gz

# Set MAVEN_HOME
export MAVEN_HOME=$(pwd)/apache-maven-<version>
export PATH=$MAVEN_HOME/bin:$PATH
