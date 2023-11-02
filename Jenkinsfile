pipeline {
    agent {
        label 'Agent_Jenkins'
    }
  
    stages {
        stage('Build') {
            steps {
                script {
                    // Checkout the Git repository
                    git branch: 'MoatezBorgi',
                    credentialsId: 'GitHub',
                    url: 'https://github.com/moatezborgi/DevOpsKaddem.git'
                }
            }
        }

        stage("Build Artifact") {
            steps {
                // Build your Maven project, skipping tests
                sh 'mvn package -DskipTests'
            }
        }
          stage("Nexus"){
           steps{
        sh "mvn deploy -Durl=https://192.168.1.15/repository/maven-releases/ -Drepository.username=admin -Drepository.password=admin -Dmaven.test.skip"
             }
    }

        stage("Docker Build and Run") {
            steps {
                // Build the Docker image
                sh 'docker build -t moatezborgi/borgikaddem .'

                // Run the Docker container in detached mode (-d)
                sh 'docker run -d -p 9090:9090 moatezborgi/borgikaddem'

                // Push the Docker image to a Docker registry (e.g., Docker Hub)
                sh 'docker push moatezborgi/borgikaddem'

                // Optionally, if you have a docker-compose.yml file, you can use docker-compose to start your services
                sh 'docker-compose up -d'
            }
        }
    }
}
