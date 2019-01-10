package nl.rcomanne.springbootkotlin

import nl.rcomanne.springbootkotlin.domain.BuildResult
import nl.rcomanne.springbootkotlin.repository.BuildResultRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SpringBootKotlinApplication {
	@Bean
	fun init(repository: BuildResultRepository) = CommandLineRunner {
		repository.save(BuildResult("SUCCESFULL", "Test-Application", 1L, "1", 10L))
		repository.save(BuildResult("UNSTABLE", "Test-Application", 2L,  "2", 10L))
		repository.save(BuildResult("FAILED", "Test-Application", 3L, "3", 10L))
	}
}

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinApplication>(*args)
}


