pipeline {
    agent any

    stages {
        stage('Maven Build') {
            steps {
                sh 'pwd'
                sh 'ls -lrt'
                sh 'chmod 755 tools.sh'
                sh 'ls -lart'
                sh './tools.sh'
            }
         }

        stage('SonarQube Analysis') {
            steps {
                // Run SonarQube analysis on your code
                withSonarQubeEnv('SonarQube') {
                    withMaven(globalMavenSettingsConfig: '', jdk: 'Java', maven: 'Maven', mavenSettingsConfig: '', traceability: true) {
                    //sh 'mvn sonar:sonar'
                }
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
                sh ' docker run my-web-app-image'
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
