import org.yaml.snakeyaml.Yaml

def yaml = new Yaml()

// GO PROJECTS
def goCfg = yaml.load(readFileFromWorkspace('projects/go.yaml'))
goCfg.projects.each { p ->
  evaluate readFileFromWorkspace('templates/go.groovy'), [
    name: p.name,
    port: p.port,
    repo: p.repo
  ]
}

// REACT PROJECTS
def reactCfg = yaml.load(readFileFromWorkspace('projects/react.yaml'))
reactCfg.projects.each { p ->
  evaluate readFileFromWorkspace('templates/react.groovy'), [
    name: p.name,
    repo: p.repo
  ]
}
