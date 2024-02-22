package com.severett.thymeleafcomparison.kotlinscripting.scripting

import kotlin.script.experimental.annotations.KotlinScript
import kotlin.script.experimental.api.ScriptCompilationConfiguration
import kotlin.script.experimental.jvm.dependenciesFromCurrentContext
import kotlin.script.experimental.jvm.jvm
import kotlin.script.experimental.jvm.jvmTarget

@KotlinScript(
    fileExtension = "html.kts",
    compilationConfiguration = HtmlScriptCompilationConfiguration::class
)
abstract class HtmlScript(@Suppress("unused") val model: Map<String, Any?>)

object HtmlScriptCompilationConfiguration : ScriptCompilationConfiguration(
    {
        jvm {
            jvmTarget("21")
            dependenciesFromCurrentContext("main", "kotlinx-html-jvm-0.11.0")
        }
    }
) {
    private fun readResolve(): Any = HtmlScriptCompilationConfiguration
}
