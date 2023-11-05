pipeline {
    agent any;
   
    stages {
        stage('Build') {
            steps {
                script {
                    // Checkout the Git repository
                    git branch: 'KarimBranch',
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
                    sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.100.21:9000 -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }
         stage("Nexus"){
           steps{
        sh "mvn deploy -Durl=http://192.168.100.21/repository/maven-releases/ -Drepository.username=admin -Drepository.password=admin -Dmaven.test.skip"
             }
    }
         stage("Docker Build and Run") {
            steps {
                // Build the Docker image
                sh 'docker build -t karimabbassi1902/abbasikaddem .'
                    sh "docker login -u karimabbassi1902 -p kiki190201"

                // Run the Docker container in detached mode (-d)
                sh 'docker run -d -p 9090:9090 karimabbassi1902/abbasikaddem'

                // Push the Docker image to a Docker registry (e.g., Docker Hub)
                sh 'docker push karimabbassi1902/abbasikaddem'

                // Optionally, if you have a docker-compose.yml file, you can use docker-compose to start your services
                sh 'docker-compose up -d'
            }

        stage('Prometheus Setup') {
            steps {
                sh 'docker run -d -p 9090:9090 --name prometheus prom/prometheus'
            }
        }
        stage('Mockito JUnit') {
            steps {
                sh 'mvn test'  // Or any other command to run tests, including Prometheus monitoring
            }
        }

        stage('Grafana Setup') {
            steps {
                sh 'docker run -d -p 3000:3000 --name grafana grafana/grafana'
            }
        }
        }
        }
    }
}
