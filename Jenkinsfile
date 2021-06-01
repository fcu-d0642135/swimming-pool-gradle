pipeline {
    agent any
    /* insert Declarative Pipeline here */
    stages {
        stage('run-test') {
            /* when {
                anyOf {
                    branch 'master'
                    branch 'dev'
                }
            } */
            steps {
                sh 'chmod +x ./gradlew'
                sh './gradlew test'
                jacoco(
                    classPattern: 'app/build/classes',
                    inclusionPattern: '**/*.class',
                    exclusionPattern: '**/*Test*.class',
                    execPattern: 'app/build/jacoco/**/*.exec'
                )
            }
        }
        stage('sonarqube-analysis') {
            environment {
                SONAR_TOKEN = credentials('sonarqube_token')
                PROJECT_NAME = "swimming_pool"
            }
            steps {
                withSonarQubeEnv(installationName: 'sqa-sonar', credentialsId: 'sonarqube_token') {
                    sh '''./gradlew sonarqube \
                    -Dsonar.login=$SONAR_TOKEN \
                    -Dsonar.projectKey=$PROJECT_NAME'''
                }
            }
        }
		// if the SonarQube analysis result is a failure, we abort the pipeline
// 		stage('Quality gate') {
//             steps {
//                 waitForQualityGate abortPipeline: true
//             }
//         }
    }
}