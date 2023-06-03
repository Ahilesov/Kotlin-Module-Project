package app

import kotlin.system.exitProcess

class MenuArchive {

    companion object {
        val listOfArchives: MutableList<Archive> =
            mutableListOf() // лист с архивами создаем один раз
    }

    fun menuArchive() { // функция меню Архивов
        val countListArchive =
            listOfArchives.count() + 1 // количество объектов в списке Архивов+1 - для получения номера пункта Выход и проверки вводимых данных

        println("\nСписок архивов:")
        println("0. Создать архив")

        // Проходим по листу архивов, если объекты есть печатаем их пункты как индекс+1, так как первый пункт меню постоянный
        listOfArchives.forEachIndexed { index, arihive -> println("${index + 1}. ${arihive.nameArchive}") }
        println("$countListArchive. Выход") // Пункт тоже постоянный, считает кол-во объектов в списке и выводит пункт как кол-во+1

        // проверяем ввод данных для выбора пункта на ошибки через checkInput и исходя из пункта запускаем следущие функции
        val archiveMenuItem = checkInput(
            countListArchive,
            "Введите число от 0 до ",
            "Такого пункта нет\nВведите число от 0 до "
        )

        when (archiveMenuItem) {
            0 -> createArchive() // функция создания Архива
            // создаем класс Меню Заметок с передачей объекта выбранного Архива и запускаем функцию Меню Заметок
            in 1..listOfArchives.count() -> MenuNote(listOfArchives[archiveMenuItem - 1]).menuNotes()
            countListArchive -> {
                println("\nВы вышли из приложения...")
                exitProcess(0)
            } // выход из приложения
        }
    }


    private fun createArchive() { // функция создания Архива
        print("\nВведите название архива: > ")
        val nameArchive = readln().trim() // Удаляем начальные и конечные пробелы ввода
        listOfArchives.add(Archive(nameArchive, mutableListOf())) // добавляем объект Архив в лист Архивов
        println("Архив $nameArchive создан")
        menuArchive() // возвращаемся в функцию меню Архивов
    }
}