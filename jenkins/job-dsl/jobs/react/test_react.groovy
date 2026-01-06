def template = load 'jenkins/job-dsl/shared/pipelineJobTemplate.groovy'

template.createPipelineJob(
  this,
  'react',
  'react_web',
  'git@github.com:ORG/react-api.git'
)
