pipelineJob('react-app') {
  parameters {
    stringParam('REPO_URL', '', 'Git repository URL')
  }

  definition {
    cps {
      sandbox()
      script("""
        pipeline {
          agent any

          tools {
            nodejs 'node18'
          }

          stages {
            stage('Install') {
              steps {
                sh 'npm install'
              }
            }

            stage('Build') {
              steps {
                sh 'npm run build'
              }
            }
          }
        }
      """)
    }
  }
}
