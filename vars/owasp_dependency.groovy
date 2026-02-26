def call(String args = '') {

    dependencyCheck(
        odcInstallation: 'OWASP',
        additionalArguments: "--scan ./ ${args}"
    )

    dependencyCheckPublisher(
        pattern: '**/dependency-check-report.xml'
    )
}
