pipeline
agent any
{
stages{
stage('build')
{
steps{
echo "building the project"
sh 'mvn clean'
}
}
stage('test')
{
steps{
echo "testing the project"
sh 'mvn test'
}
}
}

}
