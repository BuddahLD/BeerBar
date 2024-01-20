
import korlibs.event.Key
import korlibs.image.color.Colors
import korlibs.image.text.RichTextData
import korlibs.korge.Korge
import korlibs.korge.input.keys
import korlibs.korge.scene.Scene
import korlibs.korge.scene.sceneContainer
import korlibs.korge.view.SContainer
import korlibs.korge.view.align.centerOn
import korlibs.korge.view.align.centerOnStage
import korlibs.korge.view.position
import korlibs.korge.view.solidRect
import korlibs.korge.view.textBlock
import korlibs.math.geom.Size

suspend fun main() = Korge(
    windowSize = Size(1920, 1080),
    backgroundColor = Colors["#2b2b2b"]
) {
    sceneContainer {
        changeTo { InGameScene() }
    }
}

class InGameScene : Scene() {

    override suspend fun SContainer.sceneMain() {
        val beerDrinker = solidRect(width = 64, height = 64) {
            color = Colors.CORNFLOWERBLUE
            centerOnStage()

        }

        keys {
            down {
                when (it.key) {
                    Key.LEFT -> beerDrinker.x -= 10
                    Key.RIGHT -> beerDrinker.x += 10
                    Key.UP -> beerDrinker.y -= 10
                    Key.DOWN -> beerDrinker.y += 10
                    else -> Unit
                }
            }
        }

        val beerBar = solidRect(width = 270, height = 200) {
            color = Colors.LIMEGREEN
            position(x = 100, y = 100)

        }
        textBlock(text = RichTextData(text = "Bar", color = Colors.BLACK, textSize = 70.0)) {
            centerOn(beerBar)
        }


        borders()
    }

    private fun SContainer.borders() {
        solidRect(width = 1900, height = 10) {
            color = Colors.RED
            position(x = 10, y = 1070)
        }
        solidRect(width = 1900, height = 10) {
            color = Colors.RED
        }
        solidRect(width = 10, height = 1080) {
            color = Colors.RED
            position(x = 1900, y = 0)
        }
        solidRect(width = 10, height = 1080) {
            color = Colors.RED
        }
    }
}
