package com.example.dewil.solitaire.no_android

import android.content.Context
import android.view.ViewManager
import android.widget.ImageView
import com.example.dewil.solitaire.GameModel
import com.example.dewil.solitaire.GamePresenter
import com.example.dewil.solitaire.cardBackDrawable
import com.example.dewil.solitaire.emptyPileDrawable
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.onClick

/**
 * Created by dewil on 2016-11-28.
 */
class DeckView(context: Context) : ImageView(context) {
    init {
        imageResource = cardBackDrawable
        onClick {
            GamePresenter.onDeckTap()
        }
    }

    fun update() {
        val cards = GameModel.deck.cardsInDeck
        imageResource = if (cards.size > 0) cardBackDrawable else emptyPileDrawable
    }
}

fun ViewManager.deckView(init: DeckView.() -> Unit = {}) =
        ankoView(::DeckView, 0, init)