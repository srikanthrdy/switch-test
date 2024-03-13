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
    
      stage('Pushing Image'){
        steps{
          script{ 
                    sh 'docker tag login-test:$BUILD_NUMBER sr79979/login-test:$BUILD_NUMBER'
                    sh 'docker images'
                    withCredentials([usernamePassword(credentialsId: 'docker', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                       sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
                       sh 'docker push sr79979/login-test:$BUILD_NUMBER'
          }
        }
      }
   }
        stage('Nexus Publish'){
        steps{
          script{ 
                   withMaven(globalMavenSettingsConfig: '', jdk: '', maven: 'Maven', mavenSettingsConfig: '', traceability: true) {
                   sh  'mvn clean deploy'
                    sh 'docker tag login-test:$BUILD_NUMBER 172.29.158.73:8081/repository/docker-images/login-test:$BUILD_NUMBER'
                    sh 'docker images'
                    // withCredentials([usernamePassword(credentialsId: 'docker', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    //    sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
                       sh 'docker login -u admin -p admin123 http://172.29.158.73:8081'
                       sh 'docker push 172.29.158.73:8081/repository/docker-images/login-test:$BUILD_NUMBER'
          }
        }
      }
   }
 }
}
