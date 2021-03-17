import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration

/**
 * Created by CowardlyLion on 2021/3/16 23:09
 */

fun main() {
    val config = Lwjgl3ApplicationConfiguration()
    config.setTitle("test1")
    config.setWindowedMode(710, 470)
    config.setWindowIcon(
        "image/libgdx16.png",
        "image/libgdx32.png",
        "image/libgdx64.png",
        "image/libgdx128.png"
    )
    Lwjgl3Application(MainGame(), config)
}