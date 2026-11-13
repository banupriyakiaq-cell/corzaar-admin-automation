 pipeline {
agent any
stages {
stage('Checkout') {
steps {
checkout scm
}
}
stage('Execute Test Cases') {
steps {
 bat 'mvn clean test'
}
}
stage('Generate Allure HTML Report') {
 steps {
 bat 'allure generate target/allure-results --clean -o target/allure-report'
}
}
stage('Publish Allure Report') {
steps {
allure([
includeProperties: false,
 jdk: '',
results: [[path: 'target/allure-results']]
])
}
}
stage('Publish HTML Report') {
 steps {
  publishHTML(target: [
  allowMissing: false,
 alwaysLinkToLastBuild: true,
 keepAll: true,
 reportDir: 'target/allure-report',
 reportFiles: 'index.html',
reportName: 'Allure HTML Report'
 ])
 }
 }
 stage('Archive HTML Report') {
 steps {
 archiveArtifacts(
artifacts: 'target/allure-report/**',
allowEmptyArchive: false
 )
   }
  }
}
 }
