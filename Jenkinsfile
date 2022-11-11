pipeline {
   agent any
   stages {
    
      stage('MVN CLEAN') {
            steps {
                sh 'mvn clean'
            }
        }
       
        stage('MVN COMPILE') {
            steps {
                sh 'mvn compile'
            }
        }
         stage("MVN SonarQube") {
      
       		steps {
        	  mvn sonar:sonar -Dsonar.projectKey=Devops -Dsonar.host.url=http://192.168.1.16:9000 -Dsonar.login=9882b98d70775551fbc1bd590616293f1a800810
      	}
    }
            stage('Test mvn') {
            steps {
              sh """ mvn -DskipTests clean package """ 
                sh """ mvn install """;
  
            }
        }

    stage('Nexus') {
      steps {
        sh 'mvn clean deploy -Dmaven.test.skip=true'
      }
    }
        stage('MVN PACKAGE') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
            stage('Building our image') {
            steps {
                script {
                    dockerImage = docker.build registry +":$BUILD_NUMBER"
                }
            }
        }
      stage('Deploy our image') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }    
                stage('Cleaning up') {
            steps {
                echo "docker rmi $registry:$BUILD_NUMBER "
                sh "docker rmi $registry:$BUILD_NUMBER "
        }
    }

     stage('Start container') {
             steps {
                sh 'docker-compose up -d '
      }
        }

       }
      }