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
 
        stage('Verify Allure Results') {
            steps {
                bat 'dir AllureReports\\allure-results'
            }
        }
    }
 
    post {
        always {
            archiveArtifacts artifacts: 'AllureReports/allure-results/**',
                             allowEmptyArchive: true
        }
    }
}


