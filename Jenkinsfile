pipeline {
    agent any
 
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
 
        stage('Automation Execution') {
            steps {
                bat 'mvn clean test'
            }
        }
    }
}
