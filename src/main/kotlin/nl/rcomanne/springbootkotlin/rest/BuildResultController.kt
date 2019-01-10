package nl.rcomanne.springbootkotlin.rest

import nl.rcomanne.springbootkotlin.domain.BuildResult
import nl.rcomanne.springbootkotlin.service.BuildResultService
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/build")
class BuildResultController (val service: BuildResultService) {
    @PostMapping("/")
    fun postBuildResult(@RequestBody @Valid buildResult: BuildResult, bindingResult: BindingResult) {
        if (bindingResult.hasErrors()) throw IllegalArgumentException()
        service.save(buildResult)
    }

    @GetMapping("/id/{buildId}")
    fun findByBuildId(@PathVariable buildId: String) = service.findByBuildId(buildId)

    @GetMapping("/{applicationName}")
    fun findByApplicationName(@PathVariable applicationName: String) = service.findByApplicationName(applicationName)
}