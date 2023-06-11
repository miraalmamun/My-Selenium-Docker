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
            steps {
                script {
                    app = docker.build("miraalmamun/sleniumcode")
                }
            }
        }

        stage('Push Image') {
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
