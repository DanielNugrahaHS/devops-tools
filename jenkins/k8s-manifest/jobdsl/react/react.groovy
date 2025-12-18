def cfg = binding.variables

pipelineJob("DEVELOPMENT/${cfg.name}") {
  definition {
    cps {
      sandbox(true)
      script("""
        pipeline {
          agent any
          stages {
            stage('Checkout') {
              steps { git '${cfg.repo}' }
            }
            stage('Build') {
              steps {
                sh 'npm install'
                sh 'npm run build'
              }
            }
          }
        }
      """)
    }
  }
}
