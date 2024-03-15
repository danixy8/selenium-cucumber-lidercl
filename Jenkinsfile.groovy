pipeline{

agent any

    stages{

        stage('Compile Stage'){
            steps{
                withMaven('maven_3_9_4'){
                    sh 'mvn clean compile'
                }
            }
        }

        stage('Test Stage'){
            steps{
                withMaven('maven_3_9_4'){
                    sh 'mvn clean verify -Dcucumber.filter.tags="@PRUEBA1"'
                }
            }
        }

        stage('Cucumber Reports'){
            steps{
                cucumber buildStatus: "UNSTABLE",
                fileIncludePattern: "**/cucumber.json",
                jsonReportDirectory: 'target'
            }
        }

    }

}