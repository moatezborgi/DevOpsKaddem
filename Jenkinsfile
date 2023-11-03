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
    }
}
