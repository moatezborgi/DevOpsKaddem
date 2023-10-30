pipeline {
    agent maitre

    stages {
        stage('Build') {
            steps {
                script {
                    git branch: 'MoatezBorgi',
                    credentialsId: '0e227c2e-2fbb-4f48-86e4-f6303d79501c',
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
