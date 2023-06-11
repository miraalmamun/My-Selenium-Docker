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
                    docker.withRegistry('https://registry.hub.docker.com', 'DockerHub') {
                        // Build the Docker image using the Dockerfile
                        def dockerImage = docker.build("miraalmamun/sleniumcode", "--file Dockerfile .")
                        // Tag the image with the build number and 'latest'
                        dockerImage.tag("${BUILD_NUMBER}")
                        dockerImage.tag("latest")
                        // Push the image to the Docker registry
                        dockerImage.push()
                    }
                }
            }
        }

        stage('Push Image') {
            agent any
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'DockerHub') {
                        // Push the image with the build number and 'latest' tags
                        docker.image("miraalmamun/sleniumcode:${BUILD_NUMBER}").push()
                        docker.image("miraalmamun/sleniumcode:latest").push()
                    }
                }
            }
        }
    }
}
