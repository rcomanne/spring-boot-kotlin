package nl.rcomanne.springbootkotlin.repository

import nl.rcomanne.springbootkotlin.domain.BuildResult
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface BuildResultRepository : MongoRepository<BuildResult, String> {
    fun findByBuildId(buildId: String): Optional<BuildResult>
    fun findByApplicationNameAndBuildId(applicationName: String, buildId: String): Optional<BuildResult>
    fun findByApplicationName(applicationName: String): List<BuildResult>
}