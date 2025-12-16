pipelineJob('seed-job') {
  definition {
    cps {
      sandbox()
      script("""
        pipeline {
          agent any

          stages {
            stage('Load Job DSL') {
              steps {
                jobDsl targets: 'jobdsl/*.groovy',
                jobDsl targets: 'jobdsl/go/*.groovy',
                jobDsl targets: 'jobdsl/react/*.groovy'
              }
            }
          }
        }
      """)
    }
  }
}
