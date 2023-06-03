package app

fun checkInput(numberOfObjects: Int, textBeforeEntering: String, errorText: String): Int { // функция проверки вводимых данных пунктов меню
    var input = "" // локальная переменная
    print("\n$textBeforeEntering $numberOfObjects: > ") // текст до ввода данных
    while (true) {
        input = readln() // ввод
        // Анализируем строку как число Int и возвращаем результат или null если строка не является допустимым представлением числа.
        // Спасение от ввода Enter))
        // Проверяем вводимое число на промежуток
        if (input.toIntOrNull() in 0..numberOfObjects) {
            break
        } else print("$errorText $numberOfObjects: > ") // текст в случае ошибки
    }
    return input.trim().toInt()  // Удаляем пробелы ввода и приводим к Int
}