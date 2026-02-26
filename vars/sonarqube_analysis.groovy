def call(String serverName, String projectKey, String projectName) {

    withSonarQubeEnv(serverName) {

        withCredentials([string(credentialsId: 'SONAR_TOKEN', variable: 'SONAR_TOKEN')]) {

            sh """
                sonar-scanner \
                  -Dsonar.projectKey=${projectKey} \
                  -Dsonar.projectName=${projectName} \
                  -Dsonar.login=${SONAR_TOKEN}
            """
        }
    }
}
