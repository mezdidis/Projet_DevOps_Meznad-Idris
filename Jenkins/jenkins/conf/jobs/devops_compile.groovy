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
        stage('compile-git'){
            steps{
                script{
                    sh 'mvn package '
                }
            }

        }


        stage('Job compile') {
            steps{
                script{
                    sh 'mvn compile '

                }
            }
        }
        stage('test'){
            steps{
                script{
                    sh 'mvn test'
                }
            }
        }
        stage('verify'){
            steps{
                script{
                    sh 'mvn verify'
                }
            }
        }
        stage('install'){
            steps{
                script{
                    sh 'mvn install'
                }
            }
        }

        stage('Rename'){
            steps{
                script{
                    sh "mv sb3t-ws/target/sb3t-ws-1.0-SNAPSHOT.jar sb3t-${params.VERSION}-${params.VERSION_TYPE}.jar"
                }
            }
        }

    }
}
