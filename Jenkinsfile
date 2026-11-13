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
