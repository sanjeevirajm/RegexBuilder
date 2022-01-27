fun main() {
      val userNameRegexBuilder = RegexBuilder().run {
        shouldBeStartOfTheLine()
        contains('a' to 'z') or contains('A' to 'Z') or contains("_", "-") or contains('0' to '9')
        charRange(min = 3, max = 10)
        shouldBeEndOfTheLine()
    }
    println("userNameRegexBuilder.build: ${userNameRegexBuilder.build()}")
    println("userNameRegexBuilder.buildAsString: ${userNameRegexBuilder.buildAsString()}")

//     val phoneNoRegexBuilder = RegexBuilder().run {
//         shouldBeStartOfTheLine()
//         contains("+") or contains("(") or contains('0' to '9') and charCount(3) or contains(")")
//         or()
//         contains("+") or contains("(") or contains('0' to '9') and charCount(3) or contains(")")
//         charRange(min = 3, max = 10)
//         shouldBeEndOfTheLine()
//     }
    
//     println("phoneNoRegexBuilder.build: ${phoneNoRegexBuilder.build()}")
//     println("phoneNoRegexBuilder.buildAsString: ${phoneNoRegexBuilder.buildAsString()}")

}
