package com.gavincode.tutorial

import com.gavincode.tutorial.command.Command
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommandProcessor {

    private val commandRouterStack: Deque<CommandRouter> = ArrayDeque()

    @Inject constructor(firstCommandRouter: CommandRouter) {
        commandRouterStack.push(firstCommandRouter)
    }

    fun process(input: String): Command.Status {
        val result = commandRouterStack.peek().route(input)

        if (result.status == Command.Status.INPUT_COMPLETED) {
            commandRouterStack.pop()
            return if (commandRouterStack.isEmpty()) {
                Command.Status.INPUT_COMPLETED
            } else {
                Command.Status.HANDLED
            }
        }

        result.nestedCommandRouter.ifPresent(commandRouterStack::push)
        return result.status
    }
}