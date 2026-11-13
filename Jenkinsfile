Pipline{
  agent any
  stages{
    stage('Checkout'){
      steps{
        checkout scm 
      }
    }
    stage('Automation Excution'){
      steps{
        bat 'mvn claen test'
      }
    }
  }
}
