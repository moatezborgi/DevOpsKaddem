pipeline {
    agent {
        label 'Agent_Jenkins'
    }
  
    stages {
        stage('Checkout the Git repository') {
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
          stage('SonarQube Analysis') {
            steps {
                // Ajoutez cette commande pour exécuter l'analyse SonarQube
                    sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.1.15:9000 -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }
          stage("Nexus"){
           steps{
        sh "mvn deploy -Durl=https://192.168.1.15/repository/maven-releases/ -Drepository.username=admin -Drepository.password=admin -Dmaven.test.skip"
             }
    }
     stage("Docker Build"){
           steps{
                sh 'docker build -t moatezborgi/borgikaddem .'
             }
    }
           stage("Docker run"){
           steps{
                sh 'docker run -d -p 9091:9091 moatezborgi/borgikaddem'
             }
    }
              stage("Docker push"){
           steps{
                sh 'docker push moatezborgi/borgikaddem'
             }
    }
        stage("Docker compose up") {
            steps {
 
                // Run the Docker container in detached mode (-d)

                // Push the Docker image to a Docker registry (e.g., Docker Hub)

                // Optionally, if you have a docker-compose.yml file, you can use docker-compose to start your services
                sh 'docker-compose up -d'
            }
        }
    }
}
