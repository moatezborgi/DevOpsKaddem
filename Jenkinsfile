pipeline {
    agent any;
   
    stages {
        stage('Build') {
            steps {
                script {
                    // Checkout the Git repository
                    git branch: 'FatmaMaazoun',
                        credentialsId: 'GitHub',
                            url: 'https://github.com/moatezborgi/DevOpsKaddem.git'
                }
            }
        }
    }

}
