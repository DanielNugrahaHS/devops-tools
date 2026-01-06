def template = evaluate(new File('shared/pipelineJobTemplate.groovy'))

template.createPipelineJob(
  'react',
  'react-web',
  'git@github.com:ORG/react-web.git'
)
