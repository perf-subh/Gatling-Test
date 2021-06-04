pipeline {
    agent any
    stages {
        stage("Build Maven") {
            steps {
                sh 'mvn --version'
            }
        }
        stage("Run Gatling") {
            steps {
                sh 'mvn gatling:test'
            }
            post {
                always {
                    gatlingArchive()
                }
            }
        }
    }
}
