package nl.rcomanne.springbootkotlin.service

import nl.rcomanne.springbootkotlin.domain.BuildResult
import nl.rcomanne.springbootkotlin.repository.BuildResultRepository
import nl.rcomanne.springbootkotlin.socket.BuildResultHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BuildResultService {
    @Autowired
    lateinit var repository: BuildResultRepository
    val handler = BuildResultHandler()

    fun addBuildResult(buildResult: BuildResult) {
        if (!repository.findByApplicationNameAndBuildId(buildResult.applicationName, buildResult.buildId).isPresent) {
            repository.save(buildResult)

        }

    }
    fun findByBuildId(buildId: String) = repository.findByBuildId(buildId)
    fun findByApplicationName(applicationName: String) = repository.findByApplicationName(applicationName)
}

