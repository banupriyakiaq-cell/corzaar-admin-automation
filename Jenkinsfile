 pipeline {
 agent any
stages {
 //1.Checkout source code
 stage('Checkout') {
 steps {
checkout scm
}
}
 //2.Execute automation test case
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
 //3.Generate Allure HTML Report
stage('Generate Allure HTML Report') {
 steps {
 bat '''
 allure generate AllureReports/allure-results -o target/allure-report
 '''
 }
 }
 //4.Generate Html zip for Email Attachement
 stage('Zip Allure HTML Report') {

    steps {
bat '''
 if not exist "target\\allure-report" (
 echo Allure report folder not found
 exit /b 1
 )
powershell -NoProfile -ExecutionPolicy Bypass -Command "Compress-Archive -Path 'target/allure-report/*' -DestinationPath 'target/allure-report.zip' -Force"
 '''
}
 }
 //4.Generate Pdf Report using Chrome
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
 //5.Publish Allure jenkins Report
 stage('Publish Allure Report') {
 steps {
allure ([commandline: 'Allure', includeProperties: false, jdk: '', resultPolicy: 'LEAVE_AS_IS',
 results: [[path: 'AllureReports/allure-results']]
         ])
 }
 }
 //6.Publish HTML Report in Jenkins
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
 //7.Archive pdf Report 
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
//8.Email Notification
  post{
   always{
    emailext(
     to:
     'banupriya.kiaq@gmail.com',
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
     //9.Attach PDF and HTML
     attachmentsPattern:
     'target/Allure-report.pdf,target/allure-report.zip'
     )
   }
  }
}
