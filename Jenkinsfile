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
		
        stage('Clone sources') {
            steps {
                git url: 'https://github.com/fcu-d0642135/swimming-pool.git'
            }
        }
        stage('SonarQube analysis') {
            steps {
				checkout scm
                withSonarQubeEnv('SonarQube') {
                    sh './gradlew sonarqube'
                }
            }
        }
		// if the SonarQube analysis result is a failure, we abort the pipeline
		stage('Quality gate') {
            steps {
                waitForQualityGate abortPipeline: true
            }
        }
		
    }
}