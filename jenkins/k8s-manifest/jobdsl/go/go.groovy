pipelineJob('go-app') {
  parameters {
    stringParam('REPO_URL', '', 'Git repository URL')
  }

  definition {
    cps {
      sandbox()
      script("""
        pipeline {
          agent any

          stages {
            stage('Checkout') {
              steps {
                git params.REPO_URL
              }
            }

            stage('Build') {
              steps {
                sh 'go build ./...'
              }
            }

            stage('Test') {
              steps {
                sh 'go test ./...'
              }
            }
          }
        }
      """)
    }
  }
}
