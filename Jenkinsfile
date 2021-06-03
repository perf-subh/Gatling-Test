pipeline {
    agent any
    node 

{
def mvn_version = ''
    
withEnv( ["PATH+MAVEN=${tool mvn_version}/bin"] ) 
  {   
      sh  'mvn clean package'
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
