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
                    sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.100.21/:9000 -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }
    }
}
