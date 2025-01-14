fun complexNumberMultiply(num1: String, num2: String): String {
    val regex = Regex("""^([-\d]+)\+([-\d]+)""")
    var match = regex.find(num1)!!
    val (real1, img1) = Pair(match.groups[1]!!.value.toInt(), match.groups[2]!!.value.toInt())
    match = regex.find(num2)!!
    val (real2, img2) = Pair(match.groups[1]!!.value.toInt(), match.groups[2]!!.value.toInt())

    val real = real1 * real2 + (-1*img1*img2)
    val img = real1 * img2 + real2 * img1
    return "$real+${img}i"
}