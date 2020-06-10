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
                git 'https://github.com/saikiran4507/ITVMS.git'
                sh ' mvn clean test '
            }

        }
    }

}
