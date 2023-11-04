pipeline {
    agent any;
   
    stages {
        stage('Build') {
            steps {
                script {
                    // Checkout the Git repository
                    git branch: 'fatmaMaazoun',
                    credentialsId: 'Github',
                    url: 'https://github.com/moatezborgi/DevOpsKaddem.git'
                }
            }
        }
                stage("Build Artifact") {
            steps {
                // Build your Maven project, skipping tests
                sh 'mvn clean compile'
                sh 'mvn package -DskipTests'
            }
        }
          stage('SonarQube Analysis') {
           steps {
            // Ajoutez cette commande pour exécuter l'analyse SonarQube
                   sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.100.21:9000 -Dsonar.login=admin -Dsonar.password=sonar'
           }
        }
         stage("Nexus"){
           steps{
        sh "mvn deploy -Durl=http://192.168.100.21/repository/maven-releases/ -Drepository.username=admin -Drepository.password=admin -Dmaven.test.skip"
             }
    }
    stage("Docker Build and Push") {
        steps { 
            script 
            { def dockerImage = 'fatmamaazoun/fatmakaddem' def dockerHubCredentials = credentials('docker-hub-credentials') 
                // Build the Docker image sh "docker build -t ${dockerImage} ." 
             // Push the Docker image to a Docker registry (e.g., Docker Hub) withDockerServer([url: 'https://registry-1.docker.io/v2/']) {
             withCredentials([dockerUsernamePassword(credentialsId: dockerHubCredentials, runAsUser: '')]) { 
                 sh "docker login -u ${dockerHubCredentials_USR} -p ${dockerHubCredentials_PSW}" } sh "docker push ${dockerImage}" }
            // Optionally, if you have a docker-compose.yml file, you can use docker-compose to start your services sh "docker-compose up -d" } }
        }
    }
}
