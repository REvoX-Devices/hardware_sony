/*
 * SPDX-License-Identifier: Apache-2.0
 */

package com.xperia.settings.audio

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle

/**
 * Handles android.media.action.DISPLAY_AUDIO_EFFECT_CONTROL_PANEL (e.g. the equalizer button of
 * music apps) by opening Dolby Atmos, falling back to the audio settings screen.
 */
class EffectPanelRedirectActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dolby = Intent().apply {
            component = ComponentName(DOLBY_PACKAGE, "$DOLBY_PACKAGE.MainActivity")
        }
        try {
            startActivity(dolby)
        } catch (e: ActivityNotFoundException) {
            startActivity(Intent(this, AudioSettingsActivity::class.java))
        }
        finish()
    }

    companion object {
        private const val DOLBY_PACKAGE = "com.dolby.daxappui"
    }
}
