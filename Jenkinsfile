pipeline{
    agent any
    triggers
    {
        pollSCM('* * * * *')
    }
    stages
    {
        stage('clone and compile'){
            steps{
                git ''
                sh ' mvn clean test'
            }

        }
    }

}
}
