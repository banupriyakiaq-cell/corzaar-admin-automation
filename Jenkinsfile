 pipeline {
 agent any
stages {
 //Checkout source code
 stage('Checkout') {
 steps {
checkout scm
}
}
 //Execute automation test case
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
 //Generate Allure HTML Report
stage('Generate Allure HTML Report') {
 steps {
 bat '''
 allure generate AllureReports/allure-results -o target/allure-report
 '''
 }
 }
 //Generate Pdf Report using Chrome
stage('Generate Allure PDF Report') {
 steps {
 bat '''
set "CHROME=C:\\Users\\Kiaq_Lap_63\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe"
if not exist "%CHROME%" (
echo Chrome not found
 exit /b 1
)
if not exist "target\\allure-report\\index.html" (
 echo Allure HTML report not found
 exit /b 1
 )
 "%CHROME%" --headless --disable-gpu --no-sandbox --print-to-pdf="%WORKSPACE%\\target\\Allure-report.pdf" "file:///%WORKSPACE%/target/allure-report/index.html"
 if not exist "target\\Allure-report.pdf" (
 echo PDF generation failed
 exit /b 1
  )
 '''
 }
 }
 //Publish Allure jenkins Report
 stage('Publish Allure Report') {
 steps {
allure([
 includeProperties: false,
 jdk: '',
 results: [[path: 'AllureReports/allure-results']]
  ])
 }
 }
 //Publish HTML Report in Jenkins
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
 //Archive pdf Report 
 stage('Archive PDF Report') {
 steps {
  archiveArtifacts(
 artifacts: 'target/Allure-report.pdf',
 fingerprint: true,
  allowEmptyArchive: false
 )
 }
 }
}
//Email Notification
  post{
   always{
    emailext(
     to:
     'banupriya.kiaq@gmail.com,banupriyav@kiaq.in,preetha.kiaq@gmail.com',
     subject:'QA Automation Report - Build'+ 
     env.BUILD_NUMBER +'-'+
     currentBuild.currentResult,
     mimeType:'text/html',
     body:"""
     <html>
     <body>
     <h2>QA Automation Execution Report </h2>
     <p>Project:${env.JOB_NAME}</p>
     <p>Build Number:${env.BUILD_NUMBER}</P>
     <p>Build Status:${currentBuild.currentResult}</p>
     <p>Environment:QA</P>
     <p>
     Jenkins Build:
    <a href="${env.BUILD_URL}">View Build </a></p>
     <h3>Attached Reports </h3>
     <ul>
     <li>Allure PDF Report </li>
     <li> Allure HTML Reprot </li>
     </ul>
     <p>Regards,<br>
     QA Automation Team </p>
     </body>
     </html>
     """,
     //Attach PDF and HTML
     attachmentsPattern:
     'target/allure-report.pdf,target/allure-report'
     )
   }
  }
}
