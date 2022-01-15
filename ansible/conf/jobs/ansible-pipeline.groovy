#!groovy
pipeline {
    agent any
    stages {
        stage('mv ansible folder') {
            steps {
                sh 'cp -r /ansible-files/* .'
            }
        }
        stage('ansible launch') {
            steps {
                sh 'ansible-playbook -i inventory.ini --user deploy playbook_install_apache.yml'
            }
        }
    }
}
