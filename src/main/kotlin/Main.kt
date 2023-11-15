import kotlin.math.sqrt
data class Point(val x: Double, val y: Double)

fun main() {
    // Ввод координат вершин треугольника
    println("Введите координаты вершин треугольника:")
    val vertex1 = readPoint("Вершина 1")
    val vertex2 = readPoint("Вершина 2")
    val vertex3 = readPoint("Вершина 3")

    // Вычисление координат центра окружности
    val center = calculateCenter(vertex1, vertex2, vertex3)

    // Вычисление радиуса окружности
    val radius = calculateRadius(vertex1, center)

    // Вывод результатов
    println("Координаты центра окружности: (" + center.x + ", " + center.y + ")")
    println("Радиус окружности: $radius")
}

fun readPoint(vertexName: String): Point {
    print("$vertexName.x = ")
    val x = readLine()?.toDoubleOrNull() ?: throw IllegalArgumentException("Неверный формат ввода")
    print("$vertexName.y = ")
    val y = readLine()?.toDoubleOrNull() ?: throw IllegalArgumentException("Неверный формат ввода")
    return Point(x, y)
}

fun calculateCenter(vertex1: Point, vertex2: Point, vertex3: Point): Point {
    val d = 2 * (vertex1.x * (vertex2.y - vertex3.y) + vertex2.x * (vertex3.y - vertex1.y) + vertex3.x * (vertex1.y - vertex2.y))
    val center_x = ((vertex1.x * vertex1.x + vertex1.y * vertex1.y) * (vertex2.y - vertex3.y) +
            (vertex2.x * vertex2.x + vertex2.y * vertex2.y) * (vertex3.y - vertex1.y) +
            (vertex3.x * vertex3.x + vertex3.y * vertex3.y) * (vertex1.y - vertex2.y)) / d
    val center_y = ((vertex1.x * vertex1.x + vertex1.y * vertex1.y) * (vertex3.x - vertex2.x) +
            (vertex2.x * vertex2.x + vertex2.y * vertex2.y) * (vertex1.x - vertex3.x) +
            (vertex3.x * vertex3.x + vertex3.y * vertex3.y) * (vertex2.x - vertex1.x)) / d
    return Point(center_x, center_y)
}

fun calculateRadius(vertex: Point, center: Point): Double {
    return sqrt((center.x - vertex.x) * (center.x - vertex.x) + (center.y - vertex.y) * (center.y - vertex.y))
}