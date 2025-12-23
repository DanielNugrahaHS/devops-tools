import org.yaml.snakeyaml.Yaml

def yaml = new Yaml()

def go = yaml.load(new File('/var/jenkins_home/jobdsl/projects/go.yaml').text)
go.projects.each { p ->
  evaluate(
    new File('/var/jenkins_home/jobdsl/templates/go.groovy').text,
    [name: p.name, port: p.port, repo: p.repo]
  )
}

def react = yaml.load(new File('/var/jenkins_home/jobdsl/projects/react.yaml').text)
react.projects.each { p ->
  evaluate(
    new File('/var/jenkins_home/jobdsl/templates/react.groovy').text,
    [name: p.name, repo: p.repo]
  )
}
