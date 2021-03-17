package land.game.screen

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import ktx.app.KtxScreen

/**
 * Created by CowardlyLion on 2021/3/16 22:51
 */
class MainScreen : KtxScreen {

    val batch by lazy { SpriteBatch() }
    val image by lazy { Texture("badlogic.png") }


    override fun render(delta: Float) {
        batch.begin()
        batch.draw(image, 165F, 180F)
        batch.end()
    }

    override fun dispose() {
        batch.dispose()
        image.dispose()
        super.dispose()
    }

}