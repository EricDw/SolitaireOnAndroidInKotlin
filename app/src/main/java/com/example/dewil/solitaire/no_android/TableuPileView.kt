package com.example.dewil.solitaire.no_android

import android.content.Context
import android.view.ViewManager
import com.example.dewil.solitaire.*
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView

/**
 * Created by dewil on 2016-11-28.
 */
class TableuPileView(context: Context, val index: Int) : _RelativeLayout(context) {
    init {
        addViews()
    }

    fun update() {

        removeAllViews()
        addViews()
    }

    private fun addViews() {
        val cards = GameModel.tableauPiles[index].cards
        cards.forEachIndexed { i, card ->
            imageView {
                y = (i * dip(25)).toFloat()
                imageResource = if (card.faceUp) getResIdForCard(card) else cardBackDrawable
                onClick {
                    GamePresenter.onTableauTap(index, i)
                }
            }.lparams(context.cardWidth, context.cardHeight)
        }
    }
}

fun ViewManager.tableuPileView(
        index: Int, init: TableuPileView.() -> Unit = {}) =
        ankoView({ TableuPileView(it, index) }, 0, init)