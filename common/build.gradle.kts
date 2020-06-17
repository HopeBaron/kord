import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
 // testing
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
