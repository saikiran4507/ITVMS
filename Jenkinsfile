pipeline
agent any
{
stages{
stage('build')
{
echo "building the project"
sh 'mvn clean'
}
stage('test')
{
echo "testing the project"
sh 'mvn test'
}
}

}
