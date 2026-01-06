def template = load 'jenkins/job-dsl/shared/pipelineJobTemplate.groovy'

template.createPipelineJob(
  this,
  'go',
  'go_api',
  'git@github.com:ORG/go-api.git'
)
