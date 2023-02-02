def call(){
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t mohamedelgendy/my-repo:jma-2.1 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push mohamedelgendy/my-repo:jma-2.1'
    }
} 
