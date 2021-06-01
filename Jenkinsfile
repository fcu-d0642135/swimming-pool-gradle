pipeline {
    agent any
    /* insert Declarative Pipeline here */
    stages {
        stage('run-test') {
            when {
                anyOf {
                    branch 'master'
                    branch 'dev'
                }
            }
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
            steps {
                withSonarQubeEnv('sqa-sonar') {
                    sh './gradlew sonarqube'
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