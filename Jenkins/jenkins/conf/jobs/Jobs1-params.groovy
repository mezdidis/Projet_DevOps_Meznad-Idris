pipeline {
    agent any
    parameters {
        string(name: 'BRANCH', defaultValue: '', description: 'Select branch du repo github')

        booleanParam(name: 'SKIP_TESTS', defaultValue: '', description: 'Control de exec des tests')


        choice(name: 'VERSION_TYPE', choices: ['Snapshot', 'Release', ], description: '')

        string(name: 'VERSION', defaultValue: '', description: '   ')
    }
    stages {
        stage('Example') {
            steps {
                echo "BRANCH ${params.PERSON}"

                echo "Biography: ${params.BIOGRAPHY}"

                echo "Toggle: ${params.TOGGLE}"

                echo "Choice: ${params.CHOICE}"

                echo "Password: ${params.PASSWORD}"
            }
        }
    }
}