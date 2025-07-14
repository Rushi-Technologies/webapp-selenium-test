pipeline {
    agent any

    parameters {
        string(name: 'TEST_URL', defaultValue: 'https://example.com', description: 'URL to test')
    }

    environment {
        TEST_URL = "${params.TEST_URL}"
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

        stage('Run Tests') {
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
            echo "❌ Test failed for $TEST_URL"
        }

        success {
            echo "✅ Test passed for $TEST_URL"
        }
    }
}
