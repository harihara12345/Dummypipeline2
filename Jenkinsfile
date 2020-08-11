pipeline
{
    agent any
    stages{
        stage('Compile Cucumber Project')
        {
            steps
            {
              
             sh 'mvn clean compile'   
            
            }
            
        }
        stage('Execute Cucumber Project')
        {
            steps
            {
                
             sh 'mvn test'   
            }
             
        }
    }
}
