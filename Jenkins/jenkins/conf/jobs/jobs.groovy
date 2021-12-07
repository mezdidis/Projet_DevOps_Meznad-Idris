#!groovy
println('---------------------------------------------------------------------------Import Job CI/Job1')
def pipelineScript = new File('/var/jenkins_config/jobs/devops_compile.groovy').getText("UTF-8")

pipelineJob('CI/devops_compile'){
    description("Job Pipeline 1")
    parameters {
        stringParam {
            name('PARAM1')
            defaultValue('PARAM1')
            description("PARAM1 Desc")
            trim(false)
        }
    }
    definition{
        cps {
            script(pipelineScript)
            sandbox()
        }
    }
}