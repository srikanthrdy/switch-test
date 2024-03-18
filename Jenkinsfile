pipeline {
  agent any
      environment {
        DOCKER_CREDENTIALS = credentials('docker')
    }


  stages {
    stage('Checkout Source') {
      steps {
        git url:'https://github.com/srikanthrdy/Login-test.git', branch:'main'
      }
    }
     stage('Maven Build'){
      steps{
        script{
           withMaven(globalMavenSettingsConfig: '', jdk: '', maven: 'Maven', mavenSettingsConfig: '', traceability: true) {
             sh 'mvn clean package'
           } 
        }
      }
    }
      stage('SonarQube'){
      steps{
        script{
           withMaven(globalMavenSettingsConfig: '', jdk: '', maven: 'Maven', mavenSettingsConfig: '', traceability: true) {
            sh 'mvn sonar:sonar'
           }
        }
      }
    }
    stage('Build image'){
       steps{
           script{
             // dockerImage=docker.build dockerimagename + ":$BUILD_NUMBER"
             sh 'docker build -t login-test:$BUILD_NUMBER .'
             sh 'docker images'
           }
       }
    }
    stage('Parallel stages'){
      parallel {
        stage('Pushing Image'){
        steps{
          script{ 
                    sh 'docker tag login-test:$BUILD_NUMBER sree1408/login-test:$BUILD_NUMBER'
                    sh 'docker images'
                    withCredentials([usernamePassword(credentialsId: 'docker', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                       sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
                       sh 'docker push sree1408/login-test:$BUILD_NUMBER'
          }
        }
      }
   }
        stage('Nexus Publish'){
        steps{
          script{ 
                   withMaven(globalMavenSettingsConfig: '', jdk: '', maven: 'Maven', mavenSettingsConfig: '', traceability: true) {
                   sh  'mvn clean deploy'
          }
        }
      }
   }
 }
 }
       stage('Running Docker image'){
        steps{
          script{ 
                   sh 'docker pull sree1408/login-test:$BUILD_NUMBER'
                   sh 'docker run -d -p 7080:8080 sree1408/login-test:$BUILD_NUMBER'
                   sh 'docker ps'
          }
        }
      }
   }
 }
