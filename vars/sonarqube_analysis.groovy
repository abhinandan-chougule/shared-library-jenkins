def call(String scannerTool, String projectKey, String projectName) {

    def scannerHome = tool scannerTool

    withSonarQubeEnv(scannerTool) {
        withCredentials([string(credentialsId: 'SONAR_TOKEN', variable: 'SONAR_TOKEN')]) {

            sh """
                ${scannerHome}/bin/sonar-scanner \
                  -Dsonar.projectKey=${projectKey} \
                  -Dsonar.projectName=${projectName} \
                  -Dsonar.login=\$SONAR_TOKEN
            """
        }
    }
}
