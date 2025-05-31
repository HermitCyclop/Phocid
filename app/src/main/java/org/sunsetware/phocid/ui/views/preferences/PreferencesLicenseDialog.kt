package org.sunsetware.phocid.ui.views.preferences

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import org.sunsetware.phocid.Dialog
import org.sunsetware.phocid.MainViewModel
import org.sunsetware.phocid.R
import org.sunsetware.phocid.globals.Strings
import org.sunsetware.phocid.ui.components.DialogBase

@Stable
class PreferencesLicenseDialog() : Dialog() {
    @Composable
    override fun Compose(viewModel: MainViewModel) {
        DialogBase(
            title = Strings[R.string.preferences_license],
            onConfirmOrDismiss = { viewModel.uiManager.closeDialog() },
        ) {
            val context = LocalContext.current
            val text = remember {
                context.getString(R.string.app_copyright) +
                    "\n\n---\n" +
                    context.assets.open("GPL-3.0.txt").readBytes().decodeToString()
            }
            Text(
                text,
                modifier =
                    Modifier.horizontalScroll(rememberScrollState())
                        .verticalScroll(rememberScrollState())
                        .background(MaterialTheme.colorScheme.surfaceContainer)
                        .padding(24.dp),
            )
        }
    }
}
