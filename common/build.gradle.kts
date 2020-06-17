import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
 // testing

// testing 2
tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = Jvm.target
        freeCompilerArgs = listOf(
                CompilerArguments.inlineClasses,
                CompilerArguments.coroutines,
                CompilerArguments.time
        )
    }
}
