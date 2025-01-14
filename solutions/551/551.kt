fun checkRecord(s: String): Boolean {
    var absentCount = 0
    var lateCount = 0

    for (day in s) {
        if (day == 'P') lateCount = 0
        if (day == 'L') {
            lateCount++
            if (lateCount >= 3) break;
        }
        if (day == 'A') {
            absentCount++
            lateCount = 0
            if (absentCount >= 2) break; 
        }
    }

    return lateCount < 3 && absentCount < 2
}