pipeline {
    agent any

     environment {
        // Define the tool installations
        MAVEN_HOME = tool name: 'Maven', type: 'maven'
        SONAR_SCANNER_HOME = tool name: 'SonarQube', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
    }

    stages {
        stage('Maven Build') {
            steps {
                // Build your Maven project
                sh "${MAVEN_HOME}/bin/mvn clean install"
            }
         }

        stage('SonarQube Analysis') {
            steps {
                // Run SonarQube analysis on your code
                withSonarQubeEnv('SonarQube') {
                    sh "${SONAR_SCANNER_HOME}/bin/sonar-scanner"
                }
            }
        }

        stage('Docker Build and Push') {
            steps {
                // Build a Docker image
                sh 'docker build -t my-web-app-image .'

                sh 'docker images'

                // Push the Docker image to a Docker registry (e.g., Docker Hub)
                //sh 'docker push my-web-app-image'
                sh 'docker run -p 7000:8080 my-web-app-image'
                sh 'docker ps -a'
                sh 'docke ps'
            }
        }
    }

    post {
        success {
            // Add post-build steps here, e.g., notifications or deployment
            mail bcc: '', body: '''Hi Srikanth

            Your Jenkins Build is Success.

            Thanks
            Jenkins''', cc: '', from: '', replyTo: '', subject: 'Jenkins build is Success.', to: 'srikanthrdy7979@gmail.com'
        }
    }
}
