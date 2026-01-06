def template = this

template.createPipelineJob(
  this,
  'go',
  'go_api',
  'git@github.com:ORG/go-api.git'
)
