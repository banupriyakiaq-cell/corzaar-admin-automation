 pipeline {
agent any
 stages {
stage('Checkout') {
 steps {
 checkout scm
 }
 }
  stage('Clean Old Allure Results') {
steps {
 powershell '''
 $path = "AllureReports/allure-results"
if (Test-Path $path) {
Remove-Item $path -Recurse -Force
 }
 New-Item -ItemType Directory -Path $path -Force
 '''}
  }
 stage('Automation Execution') {
 steps {
 bat 'mvn clean test'
}
 }
 stage('Generate Allure Report') {
 steps {
 allure([
includeProperties: false,
 results: [[path: 'AllureReports/allure-results']]
])
 }
 }
 }
post {
 always {
  archiveArtifacts(
artifacts: 'AllureReports/allure-results/**',
allowEmptyArchive: true
  )
 }  
}
}
