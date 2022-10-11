package com.selles.ifindit.presentation.extension

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.selles.ifindit.R
import com.selles.ifindit.core.viewmodel.UIAction
import com.selles.ifindit.core.viewmodel.UIState
import com.selles.ifindit.core.viewmodel.ViewModel
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

fun ImageView.loadImage(
    context: Context,
    imageUrl: String
) {
    Glide.with(context)
        .load(imageUrl)
        .placeholder(R.mipmap.noimage)
        .error(R.mipmap.noimage)
        .into(this)
}

fun Int.toMinutes(): String {
    val minutes = this / 1000 / 60
    val seconds = this / 1000 % 60

    return "${minutes.toString().padStart(2, '0')}:${seconds.toString().padStart(2, '0')}"
}

inline fun <reified State : UIState, reified Action : UIAction> Fragment.onStateChange(
    viewModel: ViewModel<State, Action>,
    crossinline handleStates: (State) -> Unit
) {
    viewModel.state.observe(
        viewLifecycleOwner,
        Observer { event -> handleStates(event as State) }
    )
}

inline fun <reified State : UIState, reified Action : UIAction> Fragment.onAction(
    viewModel: ViewModel<State, Action>,
    crossinline handleEvents: (Action) -> Unit
) {
    viewModel.action.observe(
        viewLifecycleOwner,
        Observer { event -> handleEvents(event as Action) }
    )
}

fun Fragment.openExternalLink(url: String) {
    val openURL = Intent(Intent.ACTION_VIEW)
    openURL.data = Uri.parse(url)
    startActivity(openURL)
}

fun Fragment.shareElement(textToShare: String?) {
    val sendIntent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, textToShare)
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, null)
    startActivity(shareIntent)

}

fun Fragment.openToast(text: String?) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}

fun Double.toRidePrice(currency: String?): String {
    val format: NumberFormat = NumberFormat.getCurrencyInstance()
    format.maximumFractionDigits = 2
    format.currency = Currency.getInstance(currency)

    return format.format(this)
}

fun String.getYear(): Int {
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    val result = formatter.parse(this)
    val calendar = Calendar.getInstance()
    calendar.time = result as Date

    return calendar.get(Calendar.YEAR)
}

fun BottomSheetBehavior<*>.toggle() {
    this.state = when (this.state) {
        BottomSheetBehavior.STATE_EXPANDED -> BottomSheetBehavior.STATE_COLLAPSED
        else -> BottomSheetBehavior.STATE_EXPANDED
    }
}

fun View.hideKeyboard() {
    val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(windowToken, 0)
}