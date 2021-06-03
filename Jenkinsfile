pipeline {
    agent any
    stages {
        stage("Build Maven") {
            steps {
                withMaven {
                sh 'mvn -B clean package' 
                }
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
