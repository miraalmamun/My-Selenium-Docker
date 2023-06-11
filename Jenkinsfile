pipeline {
    // master executor should be set to 0
    agent any
     stages {
    stage('Build Jar') {
        agent {
            docker {
                image 'miraalmamun/maven'
                args '-v %USERPROFILE%/.m2:/root/.m2'
            }
        }
        steps {
            bat 'mvn clean package -DskipTests'
        }
    }
}

        stage('Build Image') {
            steps {
                bat 'docker build -t miraalmamun/seleniumcode .'
            }
        }


        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'DockerHub', passwordVariable: 'pass', usernameVariable: 'user')]) {
                    //sh
			        bat "docker login --username=${user} --password=${pass}"
			        bat "docker push miraalmamun/sleniumcode:latest"
			    }
            }
        }
    }
}
