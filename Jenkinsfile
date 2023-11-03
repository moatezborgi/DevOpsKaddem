pipeline {
    agent any;
   
    stages {
        stage('Build') {
            steps {
                script {
                    // Checkout the Git repository
                    git branch: 'FatmaMaazoun',
                    url: 'https://github.com/moatezborgi/DevOpsKaddem'
                    credentialsId: 'Github_Access',
                }
            }
        }
    }

}
