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

   stage("Docker run"){
      steps{
         sh 'docker docker build -t moatezborgi/borgikaddem .'
         sh 'docker run -it moatezborgi/borgikaddem'
         sh 'docker push moatezborgi/borgikaddem'
         sh 'docker-compose up'
      }
    }
     
}
}
