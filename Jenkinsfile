pipeline {
    agent any
        tools {
        maven 'Maven 3.8.1'
        jdk 'jdk8'
    }
    stages {
        stage ("Initialize") {
            steps {
                sh '''
                    export MAVEN_HOME=/usr/local/Cellar/maven/3.8.1/libexec
                    export PATH=$PATH:$MAVEN_HOME/bin
                '''
            }
        }
    stages {
        stage("Build Maven") {
            steps {
                sh 'mvn -B clean package'
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
