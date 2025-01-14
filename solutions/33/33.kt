class Solution {
    fun search(nums: IntArray, target: Int): Int {
        val right = nums[nums.size - 1]
        val left = nums[0]

        if (nums.size == 1) {
            if (target != nums[0]) return -1;
            else return 0
        }

        if (right > left) {
            val res = nums.binarySearch(target)
            if (res < 0) return -1
            else return res
        }

        var lowerBound = 0
        var upperBound = nums.size - 1
        if (target > right) {
            // Ищем в повернутой

            // Если справа что то больше или (меньше И меньше правого) - идём влево
            // Иначе идём вправо

            while (lowerBound <= upperBound) {
                val mid = lowerBound + (upperBound - lowerBound) / 2
                if (nums[mid] == target) return mid
                
                if (nums[mid] > target || (nums[mid] < target && nums[mid] < right)) {
                    upperBound = mid - 1
                } else {
                    lowerBound = mid + 1
                }
            }

            return -1
        }

        if (target < left) {
            // Ищем в основной части

            // Если справа что то (больше и больше правого) или (меньше И меньше правого) - идём вправо
            // Иначе идём влево


            while (lowerBound <= upperBound) {
                val mid = lowerBound + (upperBound - lowerBound) / 2
                if (nums[mid] == target) return mid
                
                if ((nums[mid] > target && nums[mid] > right) || (nums[mid] < target && nums[mid] < right)) {
                    lowerBound = mid + 1
                } else {
                    upperBound = mid - 1
                }
            }
        }

        return -1

    // Если target > последнего и меньше первого - значит его вообще нет.

    // 1) Если последнее число меньше первого - значит массив повернули

    // Если обнаружено (1), тогда 
    // - если target > последнего, тогда он в повернутой части, в таком случае бинарный поиск с уходом влево
    // - если target < первого, тогда он в "основной" части, в таком случае бинарный поиск с уходом вправо

    // Если (1) не обнаружено, обычный бинарный поиск

    // Если элемент в котором мы стоим больше крайнего, значит мы в перевернутой части
    }
}