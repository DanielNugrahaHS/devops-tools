def template = evaluate(new File('shared/pipelineJobTemplate.groovy'))

template.createPipelineJob(
  'go',
  'go-api',
  'git@github.com:ORG/go-api.git'
)
