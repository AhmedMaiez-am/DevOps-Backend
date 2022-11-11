pipeline {
    agent any
    
    stages {
        stage('clean') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('build') {
            steps {
                sh 'mvn package -DskipTests'
                
            }
        }
        stage('sonar') {
            steps {
              sh mvn sonar:sonar -Dsonar.projectKey=devops -Dsonar.host.url=http://192.168.1.11:9000 -Dsonar.login=ca4243aafb69466dbb09290b70be926c80936cb8
                echo 'sonar'
            }
        }
          stage('build docker image') {
            steps {
                script {
                    sh 'docker build -t ihebsahli/devops .'
                    }
                    }
             }
           stage('Docker login') {
                                 steps {
                                     script {

                                         sh 'docker login -u ihebsahli -p ihebihebiheb '}
                                 }
                                 }
                           stage('Pushing Docker Image') {
                                 steps {
                                     script {

                                      sh 'docker push ihebsahli/devops'
                                     }
                                 }
                           }
                           stage('Run Spring && MySQL Containers') {
                                 steps {
                                     script {
                                       sh 'docker-compose up -d'
                                     }
                                 }
                             }
}
}