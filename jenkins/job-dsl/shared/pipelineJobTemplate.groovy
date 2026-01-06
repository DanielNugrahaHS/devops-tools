def createPipelineJob(dsl, folderName, jobName, repoUrl) {
  dsl.pipelineJob("${folderName}/${jobName}") {
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
