import groovy.json.JsonSlurper

def jsonText = readFileFromWorkspace(
  'job-dsl/jobs/go/go.json'
)

def data = new JsonSlurper().parseText(jsonText)

def template = evaluate(
  readFileFromWorkspace('job-dsl/shared/pipelineJobTemplate.groovy')
)

folder(data.folder)

data.jobs.each { job ->

  template(this, [
    folder   : data.folder,
    name     : job.name,
    language : data.language,
    pipeline : """
pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        git '${job.repo}'
      }
    }
    stage('Build') {
      steps {
        sh 'go version'
      }
    }
  }
}
"""
  ])
}
