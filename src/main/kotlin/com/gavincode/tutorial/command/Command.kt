package com.gavincode.tutorial.command

import com.gavincode.tutorial.CommandRouter
import java.util.*

interface Command {

    fun handleInput(input: List<String>): Result

    data class Result(val status: Status,
                      val nestedCommandRouter: Optional<CommandRouter>) {
        companion object {
            fun invalid(): Result {
                return Result(Status.INVALID, Optional.empty())
            }

            fun handled(): Result {
                return Result(Status.HANDLED, Optional.empty())
            }

            fun inputCompleted(): Result {
                return Result(Status.INPUT_COMPLETED, Optional.empty())
            }

            fun enterNestedCommandSet(nestedCommandRouter: CommandRouter): Result {
                return Result(Status.HANDLED, Optional.of(nestedCommandRouter))
            }
        }
    }

    enum class Status {
        INVALID,
        HANDLED,
        INPUT_COMPLETED
    }
}