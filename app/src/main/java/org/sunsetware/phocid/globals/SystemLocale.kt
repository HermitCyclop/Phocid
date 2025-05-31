package org.sunsetware.phocid.globals

import java.util.Locale

/**
 * The actual system locale, because [Locale.getDefault] will be set to the string resource locale.
 *
 * This is only meant to be set by [org.sunsetware.phocid.MainActivity]!
 */
@Volatile var SystemLocale: Locale = Locale.getDefault()
