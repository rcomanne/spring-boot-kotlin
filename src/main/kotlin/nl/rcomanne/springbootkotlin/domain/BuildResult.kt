package nl.rcomanne.springbootkotlin.domain

import org.springframework.data.annotation.Id
import javax.validation.constraints.NotNull

class BuildResult(
        @NotNull
        var buildResult: String,
        @NotNull
        var applicationName: String,
        @NotNull
        @Id
        var id: Long,
        @NotNull
        var buildId: String,
        var buildDuration: Long = 0
)