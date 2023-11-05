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
                 sh 'mvn test'

                sh 'mvn package -DskipTests'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                // Add this command to execute the SonarQube analysis
                sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.100.21:9000 -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }

        stage("Nexus") {
            steps {
                sh "mvn deploy -Durl=http://192.168.100.21/repository/maven-releases/ -Drepository.username=admin -Drepository.password=admin -Dmaven.test.skip"
            }
        }

        stage("Docker Build and Push") {
            steps {
                script {
                    // Build the Docker image
                    sh 'docker build -t fatmamaazoun/fatmakaddem .'

                    // Log in to Docker Hub
                    sh "docker login -u fatmamaazoun -p github211"

                    // Run the Docker container
                    sh 'docker run -d -p 9090:9090 fatmamaazoun/fatmakaddem'

                    // Push the Docker image to a Docker registry (e.g., Docker Hub)
                    sh 'docker push fatmamaazoun/fatmakaddem'

                    // Start a Docker Compose service (if needed)
                    sh 'docker-compose up -d'
                }
            }
        }
    }
}

