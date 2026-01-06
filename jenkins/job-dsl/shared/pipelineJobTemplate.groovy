def createPipelineJob(folder, name, repo) {
  pipelineJob("${folder}/${name}") {
    definition {
      cpsScm {
        scm {
          git {
            remote { url(repo) }
            branches('*/main')
          }
        }
      }
    }
  }
}

return this