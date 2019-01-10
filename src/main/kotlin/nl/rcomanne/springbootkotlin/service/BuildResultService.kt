package nl.rcomanne.springbootkotlin.service

import nl.rcomanne.springbootkotlin.domain.BuildResult
import nl.rcomanne.springbootkotlin.repository.BuildResultRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BuildResultService {
    @Autowired
    lateinit var repository: BuildResultRepository

    fun save(buildResult: BuildResult) = repository.save(buildResult)
    fun findByBuildId(buildId: String) = repository.findByBuildId(buildId)
    fun findByApplicationName(applicationName: String) = repository.findByApplicationName(applicationName)
}