package util

operator fun Boolean.plus(other: Boolean) = this || other
operator fun Boolean.times(other: Boolean) = this && other