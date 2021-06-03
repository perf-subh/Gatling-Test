pipeline {
    agent any
    
    stages {
        stage("Build Maven") {
            steps {
                sh 'echo $M2_HOME'
                sh'echo $PATH'
        
            }
        }
    stages {
        stage("Clean Maven") {
            steps {
                sh '''mvn -B clean package'''
            }
        }
        

        stage("Run Gatling") {
            steps {
                sh '''mvn gatling:test'''
            }
            post {
                always {
                    gatlingArchive()
                }
            }
        }
    }
}
