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
 bat '''
 if exist AllureReports\\allure-results (
 rmdir /s /q AllureReports\\allure-results
)
 mvn clean test
 '''
 }
 }
stage('Generate Allure HTML Report') {
 steps {
 bat '''
 allure generate AllureReports/allure-results -o target/allure-report
 '''
 }
 }
stage('Generate Allure PDF Report') {
 steps {
 bat '''
  set "CHROME=C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"
  if not exist "%CHROME%" (
 set "CHROME=C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"
)
 if not exist "%CHROME%" (
 echo Chrome not found
 exit /b 1
 )
if not exist "target\\allure-report\\index.html" (
 echo Allure HTML report not found
 exit /b 1
 )
 "%CHROME%" --headless --disable-gpu --no-sandbox --virtual-time-budget=15000 --print-to-pdf="%WORKSPACE%\\target\\Allure-Report.pdf" "file:///%WORKSPACE:\\=/%/target/allure-report/index.html"
 if not exist "target\\Allure-Report.pdf" (
 echo PDF generation failed
 exit /b 1
 )
  '''
 }
 }
 stage('Publish Allure Report') {
 steps {
allure([
 includeProperties: false,
 jdk: '',
 results: [[path: 'AllureReports/allure-results']]
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
 stage('Archive PDF Report') {
 steps {
  archiveArtifacts(
 artifacts: 'target/Allure-Report.pdf',
 fingerprint: true,
  allowEmptyArchive: false

                )

            }

        }

    }

}
