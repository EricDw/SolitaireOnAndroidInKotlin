package com.example.dewil.solitaire.no_android

import android.content.Context
import android.view.ViewManager
import android.widget.ImageView
import com.example.dewil.solitaire.GameModel
import com.example.dewil.solitaire.GamePresenter
import com.example.dewil.solitaire.emptyPileDrawable
import com.example.dewil.solitaire.getResIdForCard
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.onClick

/**
 * Created by dewil on 2016-11-28.
 */
class FoundationPileView(context: Context, val index: Int) : ImageView(context) {
    init {
        imageResource = emptyPileDrawable
        onClick {
            GamePresenter.onFoundationTap(index)
        }
    }

    fun update() {
        val cards = GameModel.foundationPiles[index].cards
        imageResource = if (cards.size > 0)
            getResIdForCard(cards.last()) else emptyPileDrawable
    }
}

fun ViewManager.foundationPileView(
        index: Int, init: FoundationPileView.() -> Unit = {}) =
        ankoView({ FoundationPileView(it, index) }, 0, init)