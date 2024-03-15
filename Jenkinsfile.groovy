pipeline{

agent any
    tools {
        // Especifica el nombre de la herramienta de Maven configurada en Jenkins
        maven 'Maven 3.9.6'
    }
    stages {
        stage('Compile') {
            steps {
                // Ejecuta las tareas de compilación con Maven
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                // Ejecuta las pruebas con Maven
                sh 'mvn clean verify -Dcucumber.filter.tags="@PRUEBA1"'
            }
        }
        // Otras etapas del pipeline

        stage('Cucumber Reports'){
            steps{
                cucumber buildStatus: "UNSTABLE",
                fileIncludePattern: "**/cucumber.json",
                jsonReportDirectory: 'target'
            }
        }

    }

}