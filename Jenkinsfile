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
        	  sh 'mvn sonar:sonar -Dsonar.projectKey=Devops -Dsonar.host.url=http://192.168.1.24:9000 -Dsonar.login=33df7de48a81ba174bf8fb7a3d572e5ab312e9f4'
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
         
                stage('Cleaning up') {
            steps {
                echo "docker rmi $registry:$BUILD_NUMBER "
                sh "docker rmi $registry:$BUILD_NUMBER "
        }
    }


       }
      }