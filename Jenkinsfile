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
		/*
		stage('SonarQube analysis') {
			steps {
				// Will pick the global server connection you have configured
				withSonarQubeEnv()
				sh './gradlew sonarqube'
			}
		}
		*/
		/*			
		stage('SonarQube analysis') {
			environment {
				SCANNER_HOME = tool 'SonarQubeScanner'
				SONAR_TOKEN = credentials('SonarCloudOne')
				ORGANIZATION = "shan-github"
				PROJECT_NAME = "swimming-pool"
			}
			steps {
				withSonarQubeEnv(installationName: 'SonarCloudOne', credentialsId: 'SonarCloudOne') {
					sh '''./gradlew sonarqube -Dsonar.organization=$ORGANIZATION \
					-Dsonar.java.binaries='app/build/libs/' \
					-Dsonar.projectKey=$PROJECT_NAME \
					-Dsonar.sources=.'''
				}
			}
		}
		*/
		
        stage('Clone sources') {
            steps {
                git url: 'https://github.com/fcu-d0642135/swimming-pool.git'
            }
        }
        stage('SonarQube analysis') {
            steps {
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