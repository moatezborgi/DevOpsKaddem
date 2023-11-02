pipeline {
   agent {
  label 'Agent_Jenkins'
}

    stages {
        stage('Build') {
            steps {
                script {
                    git branch: 'MoatezBorgi',
                    credentialsId: 'GitHub',
                    url: 'https://github.com/moatezborgi/DevOpsKaddem.git'
                }
            }
        }

        stage('Checking Docker Version') {
            steps {
                script {
                    sh 'docker --version'
                }
            }
        }
    }
}
