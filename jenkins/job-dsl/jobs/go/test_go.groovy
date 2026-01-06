def FOLDER = 'go'
def JOB_NAME = 'go_api'
def REPO_URL = 'git@github.com:ORG/go-api.git'

apply from: 'jenkins/job-dsl/shared/pipelineJobTemplate.groovy'
