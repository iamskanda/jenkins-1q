node {
    
    stage('Checkout') {
        git branch: 'main', credentialsId: 'github', url: 'https://github.com/iamskanda/jenkins-1q.git'
  }
    
    stage('Test') {
        sh'mvn clean test'
    }
    
    stage('Build') {
        sh 'mvn install'
    }
 
    stage('Deploy') {
        sh 'sudo cp /home/ubuntu/jenkins/workspace/tomcat/target/*.war /opt/apache-tomcat-9.0.65/webapps/'
    }
}
