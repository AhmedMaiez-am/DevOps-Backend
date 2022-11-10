pipeline {
    agent any
    environment{
    SONAR_LOGIN= '4f1b8dd395e6e44a81bfbbce3c415c7b0a5bc34e'
    SONAR_KEY = 'devops'
    SONAR_URL = 'http://192.168.1.14:9000'
    }
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
                sh 'mvn sonar:sonar -Dsonar.host.url=$SONAR_URL -Dsonar.login=$SONAR_LOGIN -Dsonar.projectKey=$SONAR_KEY'
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