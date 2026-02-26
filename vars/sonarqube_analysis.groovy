def call(String scannerTool, String projectKey, String projectName) {

    def scannerHome = tool scannerTool

    withSonarQubeEnv('Sonar') {

        sh """
            ${scannerHome}/bin/sonar-scanner \
              -Dsonar.projectKey=${projectKey} \
              -Dsonar.projectName=${projectName}
        """
    }
}
