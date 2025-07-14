pipeline {
    agent any

    environment {
        TEST_URL = "https://example.com"
    }

    tools {
        maven 'Maven-3.9.10'
        jdk 'JDK-11'
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/your-org/java-selenium-url-test.git', branch: 'main'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test -DTEST_URL=$TEST_URL'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
            cleanWs()
        }

        failure {
            echo '❌ Build failed. One or more tests did not pass.'
        }

        success {
            echo '✅ Build succeeded. All tests passed.'
        }
    }
}
