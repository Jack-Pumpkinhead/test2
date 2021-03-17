import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import ktx.app.KtxGame
import ktx.app.KtxScreen
import land.game.screen.MainScreen

/**
 * Created by CowardlyLion on 2021/3/16 22:46
 */
class MainGame : KtxGame<KtxScreen>() {

    override fun create() {

        val mainScreen = MainScreen()
        addScreen(mainScreen)
        setScreen<MainScreen>()


    }
}