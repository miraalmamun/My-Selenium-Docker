pipeline {
    agent none
    stages {
        stage('Build Jar') {
            agent {
                node {
                    label 'Windows'
                }
            }
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }
        
        stage('Build Image') {
            agent any
            steps {
                script {
                    app = docker.build("miraalmamun/seleniumcode")
                }
            }
        }

        stage('Push Image') {
            agent any
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'DockerHub') {
                        app.push("${BUILD_NUMBER}")
                        app.push("latest")
                    }
                }
            }
        }
    }
}
