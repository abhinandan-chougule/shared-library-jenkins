def call(String server, String projectKey, String projectName) {

    withCredentials([string(credentialsId: 'SONAR_TOKEN', variable: 'SONAR_TOKEN')]) {

        sh """
        ${tool server}/bin/sonar-scanner \
          -Dsonar.projectKey=${projectKey} \
          -Dsonar.projectName=${projectName} \
          -Dsonar.login=${SONAR_TOKEN}
        """
    }
}
