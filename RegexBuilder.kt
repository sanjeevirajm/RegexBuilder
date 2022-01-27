class RegexBuilder {
    private val stringBuilder = StringBuilder()

    fun contains(vararg textList: CharSequence): RegexBuilder {
        textList.forEach {
            stringBuilder.append(it)
        }
        return this
    }

    fun group(
        function: (regexBuilder: RegexBuilder) -> Unit
    ): RegexBuilder {
        stringBuilder.append("(")
        function(this)
        stringBuilder.append("")
        return this
    }

    fun shouldBeStartOfTheLine(): RegexBuilder {
        stringBuilder.append("^")
        return this
    }

    fun shouldBeEndOfTheLine(): RegexBuilder {
        stringBuilder.append("$")
        return this
    }

    infix fun or(sameInstanceBuilder: RegexBuilder): RegexBuilder {
        if (this === sameInstanceBuilder) {
            return or()
        } else {
            throw IllegalArgumentException("Argument must be the same instance")
        }
    }

    infix fun and(sameInstanceBuilder: RegexBuilder): RegexBuilder {
        if (this === sameInstanceBuilder) {
            return and()
        } else {
            throw IllegalArgumentException("Argument must be the same instance")
        }
    }

    fun or(): RegexBuilder {
        stringBuilder.append('|')
        return this
    }

    fun and(): RegexBuilder {
        return this
    }

    infix fun Char.to(character: Char): String {
        return "$this-$character"
    }

    fun charCount(count: Int): RegexBuilder {
        stringBuilder.append("{$count}")
        return this
    }

    fun charRange(min: Int, max: Int): RegexBuilder {
        stringBuilder.append("{$min,$max}")
        return this
    }

    fun build(): Regex {
        return Regex(stringBuilder.toString())
    }

    fun buildAsString(): String {
        return stringBuilder.toString()
    }
}
