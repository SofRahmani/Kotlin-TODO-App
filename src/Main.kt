data class Task(val name: String, var isCompleted: Boolean = false)

val tasks = mutableListOf<Task>()

fun addTask(name: String) {
    tasks.add(Task(name))
    println("Tâche ajoutée : $name")
}


fun showTasks() {
    if (tasks.isEmpty()) {
        println("Aucune tâche dans la liste.")
    } else {
        println("Liste des tâches :")
        tasks.forEachIndexed { index, task ->
            val status = if (task.isCompleted) "Terminée" else "En cours"
            println("${index + 1}. ${task.name} - $status")
        }
    }
}


fun completeTask(index: Int) {
    if (index in 1..tasks.size) {
        tasks[index - 1].isCompleted = true
        println("Tâche marquée comme terminée : ${tasks[index -1].name}")
    } else {
        println("Index de tâche invalide.")
    }
}

fun deleteTask(index: Int) {
    if (index in 1..tasks.size) {
        val removedTask = tasks.removeAt(index - 1)
        println("Tâche supprimée : ${removedTask.name}")
    } else {
        println("Index de tâche invalide.")
    }
}

fun main() {
    while (true) {
        println("\nMenu :")
        println("1. Ajouter une tâche")
        println("2. Afficher les tâches")
        println("3. Marquer une tâche comme terminée")
        println("4. Supprimer une tâche")
        println("5. Quitter")
        print("Choisissez une option : ")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                print("Entrez le nom de la tâche : ")
                val name = readLine().orEmpty()
                addTask(name)
            }
            2 -> showTasks()
            3 -> {
                print("Entrez le numéro de la tâche à marquer comme terminée : ")
                val index = readLine()?.toIntOrNull() ?: -1
                completeTask(index)
            }
            4 -> {
                print("Entrez le numéro de la tâche à supprimer : ")
                val index = readLine()?.toIntOrNull() ?: -1
                deleteTask(index)
            }
            5 -> {
                println("Au revoir !")
                break
            }
            else -> println("Option invalide.")
        }
    }
}