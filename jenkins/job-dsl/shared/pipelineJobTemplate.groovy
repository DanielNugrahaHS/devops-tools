return { dsl, config ->

  dsl.pipelineJob("${config.folder}/${config.name}") {

    description("Auto-generated ${config.language} pipeline")

    definition {
      cps {
        sandbox(true)
        script(config.pipeline)
      }
    }
  }
}
