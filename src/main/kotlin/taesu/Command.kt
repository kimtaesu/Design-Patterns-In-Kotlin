package taesu

import java.util.*

// Command
interface Runnable {
    fun execute()
}

// Concreate Command
class FileReadThread(val receiver: ImReceiver) : Runnable {
    override fun execute() {
        println("파일 읽기를 시작합니다.")
        receiver.print()
        println("파일 읽기를 종료합니다.")
        println()

    }
}

// Concreate Command
class NetworkThread(val receiver: ImReceiver) : Runnable {
    override fun execute() {
        println("네트워크 통신을 시작합니다.")
        receiver.print()
        println("네트워크 통신을 종료합니다.")
        println()
    }
}

// Receiver
// 사용될 때도 있고 사용되지 않을 때도 있습니다.
class ImReceiver {
    fun print() {
        println("저는 Receiver 입니다.")
    }
}

// Invoker
class ThreadPool {

    private val queue = ArrayList<Runnable>()

    //   Builder 패턴과 유사하게 사용법이 유용하다.
    fun addCommand(runnable: Runnable) = apply { queue.add(runnable) }


    fun processCommands() {
        queue.forEach {
            it.execute()
        }
        queue.clear()
    }
}


// Client
fun main(args: Array<String>) {
    val imReceiver = ImReceiver()

    val threadPool = ThreadPool()
    threadPool.addCommand(FileReadThread(imReceiver))
            .addCommand(NetworkThread(imReceiver))
            .processCommands()
}
