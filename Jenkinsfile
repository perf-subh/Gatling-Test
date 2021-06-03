pipeline {
    agent any
    stages {
    stage ('build') {
      steps {
        withEnv(['PATH+MAVEN_HOME=/usr/local/Cellar/maven/3.8.1/libexec/bin']) {
          echo "PATH is: $PATH"
        }
      }
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
