package app

class MenuNote(private val archive: Archive) {


    fun menuNotes() { // функция меню Заметок
        val countListNote =
            archive.listOfNotes.count() + 1 // количество объектов в списке Заметок+1 - для получения номера пункта Выход и проверки вводимых данных

        println("\nАрхив «${archive.nameArchive}»")
        println("Список заметок:")
        println("0. Создать заметку")


        // Проходим по листу заметок, если объекты есть печатаем их пункты как индекс+1, так как первый пункт меню постоянный
        archive.listOfNotes.forEachIndexed { index, arihive -> println("${index + 1}. ${arihive.nameNote}") }
        println("$countListNote. Назад в список архивов ") // Пункт тоже постоянный, считает кол-во объектов в списке и выводит пункт как кол-во+1

        // проверяем ввод данных для выбора пункта на ошибки через checkInput и исходя из пункта запускаем следущие функции
        val noteMenuItem = checkInput(
            countListNote,
            "Введите число от 0 до ",
            "Такого пункта нет\nВведите число от 0 до "
        )

        when (noteMenuItem) {
            0 -> createNote() // функция создания заметки
            // создаем класс Вид Заметки с передачей объекта Архива и выбранного объекта Заметки и запускаем функцию Вид заметки
            in 1..archive.listOfNotes.count() -> ViewNote(
                archive,
                archive.listOfNotes[noteMenuItem - 1]
            ).viewNote()
            countListNote -> MenuArchive().menuArchive() // возвращаемся в меню Архивов
        }

    }


    private fun createNote() {
        print("\nВведите название заметки: > ")
        val newNameNote = readln().trim() // Удаляем начальные и конечные пробелы ввода
        print("\nВведите текст заметки: > ")
        val textNote = readln().trim()
        archive.listOfNotes.add(
            Note(
                newNameNote,
                textNote
            )
        ) // добавляем объект Заметка в лист Заметок
        println("Заметка $newNameNote создана")
        menuNotes() // возвращаемся в меню Заметок
    }
}