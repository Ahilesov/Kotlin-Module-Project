package app

class ViewNote(private val archive: Archive, private val name: Note) {

    fun viewNote() { // функция вид заметки
        println("\nАрхив «${archive.nameArchive}»")
        println("Зметка «${name.nameNote}»:")
        println(name.textNote)
        checkInput(
            0,
            "Введите для выхода цифру",
            "Такого пункта нет\nВведите для выхода цифру")
        MenuNote(archive).menuNotes() // возвращаемся в мюню Заметок

    }
}

