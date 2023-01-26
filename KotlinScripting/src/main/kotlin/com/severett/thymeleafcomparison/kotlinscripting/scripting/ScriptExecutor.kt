package com.severett.thymeleafcomparison.kotlinscripting.scripting

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.io.File
import kotlin.script.experimental.api.ResultValue
import kotlin.script.experimental.api.ScriptDiagnostic
import kotlin.script.experimental.api.ScriptEvaluationConfiguration
import kotlin.script.experimental.api.constructorArgs
import kotlin.script.experimental.api.valueOrNull
import kotlin.script.experimental.host.toScriptSource
import kotlin.script.experimental.jvm.jvm
import kotlin.script.experimental.jvm.mainArguments
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost
import kotlin.script.experimental.jvmhost.createJvmCompilationConfigurationFromTemplate

@Service
class ScriptExecutor {
    private val logger = LoggerFactory.getLogger(ScriptExecutor::class.java)
    private val compilationConfiguration = createJvmCompilationConfigurationFromTemplate<HtmlScript>()
    private val scriptingHost = BasicJvmScriptingHost()

    fun executeScript(scriptName: String, arguments: Map<String, Any?> = emptyMap()): String {
        val file = File(Thread.currentThread().contextClassLoader.getResource(scriptName)!!.toURI())
        val evaluationConfiguration = ScriptEvaluationConfiguration {
            constructorArgs(arguments)
            jvm {
                mainArguments(arrayOf("FOO", "BAR"))
            }
        }
        val response = scriptingHost.eval(file.toScriptSource(), compilationConfiguration, evaluationConfiguration)
        response.reports.asSequence()
            .filter { it.severity == ScriptDiagnostic.Severity.ERROR }
            .forEach { logger.error("An error occurred while rendering {}: {}", scriptName, it.message) }
        return (response.valueOrNull()?.returnValue as? ResultValue.Value)?.value as? String ?: ""
    }
}
