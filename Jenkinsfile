pipeline {
    agent none
    stages {
        stage('Build Jar') {
            agent {
                docker {
                    image 'miraalmamun/maven'
                    args '-v $HOME/.m2:/root/.m2'
                }
            }
            steps {
			
                sh 'mvn clean package -DskipTests'
				//cmd /c docker ps
				 //bat 'mvn clean package -DskipTests'
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