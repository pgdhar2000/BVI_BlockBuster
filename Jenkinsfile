pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        bat(script: 'mvn clean', returnStatus: true, returnStdout: true)
      }
    }
    stage('test') {
      steps {
        bat(script: 'mvn install test', returnStatus: true, returnStdout: true)
      }
    }
  }
}