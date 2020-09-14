pipeline {
    environment {
        registry = "abhishek360/stock-market-sector-service"
        registryCredential = 'dockerhub_id'
        dockerImage = ''
    }
    agent any
    stages {
        stage('Cloning our Git') {
            steps {
                git 'https://github.com/ABHISHEK-360/stockMarketSpring.git/'
            }
        }
        stage('Running Test Cases') {
            steps {
               bat 'mvn test'
            }
        }
        stage('Building our image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":latest"
                }
            }
        }
        stage('Deploy our image') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
    }
}