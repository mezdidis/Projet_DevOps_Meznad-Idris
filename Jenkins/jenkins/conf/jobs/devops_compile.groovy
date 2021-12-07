pipeline {
    agent any
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven 'maven'
    }
    environment{
        TEST = 'TEST'
    }

    options {
        buildDiscarder(logRotator(numToKeepStr:'100'))
        ansiColor('xtrem')
    }

    stages {
        stage('Job Pipeline') {
            steps{
                script{
                    println('Env var :' + env.TEST)
                    sh 'java --version'
                    sh 'mvn --version'
                    sh 'python3 --version'
                    currentBuild.displayName = "#${BUILD_NUMBER} ${params.PARAM1}"
                }
            }
        }

        stage('git'){
            steps{
                git branch: 'master', url:'https://github.com/Ozz007/sb3t'
            }
        }

        stage('Job MVM') {
            steps{
                script{
                    sh 'mvn compile '
                    sh 'mvn test'
                    sh 'mvn verify'
                    sh 'mvn install'
                }
            }
        }

    }
}
