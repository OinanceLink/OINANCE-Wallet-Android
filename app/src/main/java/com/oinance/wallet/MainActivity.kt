package com.oinance.wallet

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
private val background = Color.rgb(10, 12, 16)
private val panel = Color.rgb(22, 25, 32)
private val accent = Color.rgb(111, 210, 170)
private val primaryText = Color.rgb(245, 247, 250)
private val secondaryText = Color.rgb(158, 166, 180)

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    window.statusBarColor = background
    window.navigationBarColor = background

    val scroll = ScrollView(this).apply {
        setBackgroundColor(background)
    }

    val root = LinearLayout(this).apply {
        orientation = LinearLayout.VERTICAL
        setPadding(dp(24), dp(34), dp(24), dp(28))
    }

    val brand = TextView(this).apply {
        text = "OINANCE"
        textSize = 14f
        letterSpacing = 0.24f
        setTextColor(accent)
        typeface = Typeface.DEFAULT_BOLD
    }
    root.addView(brand)

    val title = TextView(this).apply {
        text = "Your wallet.\nYour control."
        textSize = 32f
        setTextColor(primaryText)
        typeface = Typeface.create("sans-serif", Typeface.BOLD)
        setPadding(0, dp(18), 0, dp(8))
    }
    root.addView(title)

    val subtitle = TextView(this).apply {
        text = "A self-custody wallet for Bitcoin, Ethereum, BNB Chain and Solana."
        textSize = 15f
        setTextColor(secondaryText)
        setLineSpacing(dp(4).toFloat(), 1f)
    }
    root.addView(subtitle)

    val statusCard = LinearLayout(this).apply {
        orientation = LinearLayout.VERTICAL
        setPadding(dp(18), dp(18), dp(18), dp(18))
        setBackgroundColor(panel)
    }

    val statusTitle = TextView(this).apply {
        text = "DEVELOPMENT PREVIEW"
        textSize = 12f
        letterSpacing = 0.12f
        setTextColor(accent)
        typeface = Typeface.DEFAULT_BOLD
    }
    statusCard.addView(statusTitle)

    val statusBody = TextView(this).apply {
        text = "This is the first Android app foundation. Wallet creation, recovery, PIN protection and transactions are not implemented yet. Do not use it to store real funds."
        textSize = 14f
        setTextColor(primaryText)
        setLineSpacing(dp(4).toFloat(), 1f)
        setPadding(0, dp(10), 0, 0)
    }
    statusCard.addView(statusBody)

    val cardParams = LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    ).apply {
        topMargin = dp(28)
    }
    root.addView(statusCard, cardParams)

    val createButton = makeButton("Create a new wallet", true)
    createButton.setOnClickListener {
        Toast.makeText(
            this,
            "Secure wallet creation will be added in a later step.",
            Toast.LENGTH_LONG
        ).show()
    }

    val createParams = LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        dp(54)
    ).apply {
        topMargin = dp(24)
    }
    root.addView(createButton, createParams)

    val importButton = makeButton("Import an existing wallet", false)
    importButton.setOnClickListener {
        Toast.makeText(
            this,
            "Secure wallet import will be added in a later step.",
            Toast.LENGTH_LONG
        ).show()
    }

    val importParams = LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        dp(54)
    ).apply {
        topMargin = dp(12)
    }
    root.addView(importButton, importParams)

    val footer = TextView(this).apply {
        text = "Built step by step by OINANCE Technology"
        textSize = 12f
        setTextColor(secondaryText)
        gravity = Gravity.CENTER
        setPadding(0, dp(30), 0, 0)
    }
    root.addView(footer)

    scroll.addView(root)
    setContentView(scroll)
}

private fun makeButton(label: String, filled: Boolean): Button {
    return Button(this).apply {
        text = label
        isAllCaps = false
        textSize = 15f
        setTextColor(if (filled) background else primaryText)
        setBackgroundColor(if (filled) accent else panel)
        typeface = Typeface.DEFAULT_BOLD
    }
}

private fun dp(value: Int): Int {
    return (value * resources.displayMetrics.density).toInt()
}

}
