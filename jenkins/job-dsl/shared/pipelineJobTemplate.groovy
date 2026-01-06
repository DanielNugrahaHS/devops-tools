def createPipelineJob(dsl, folder, jobName, repoUrl) {
  dsl.pipelineJob("${folder}/${jobName}") {
    definition {
      cpsScm {
        scm {
          git {
            remote {
              url(repoUrl)
            }
            branches('*/main')
          }
        }
        scriptPath('Jenkinsfile')
      }
    }
  }
}

return this
