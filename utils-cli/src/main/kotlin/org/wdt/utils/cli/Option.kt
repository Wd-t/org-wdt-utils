package org.wdt.utils.cli

data class Option(
  val fullName: String,
  val shortName: String,
  val hasArgs: Boolean = false,
  val describe: String? = null,
  val action: ((String?) -> Unit)? = null,
) {
  override fun equals(other: Any?): Boolean {
    if (this===other) return true
    if (other !is Option) return false

    if (fullName!=other.fullName) return false
    if (shortName!=other.shortName) return false
    if (hasArgs!=other.hasArgs) return false

    return true
  }

  override fun hashCode(): Int {
    var result = fullName.hashCode()
    result = 31 * result + shortName.hashCode()
    result = 31 * result + hasArgs.hashCode()
    return result
  }
}